package com.web3jtest.web3;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import com.web3jtest.contract.CopyRight;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.Web3jFactory;
import org.web3j.protocol.admin.Admin;
import org.web3j.protocol.admin.AdminFactory;
import org.web3j.protocol.admin.methods.response.PersonalUnlockAccount;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.EthAccounts;
import org.web3j.protocol.core.methods.response.EthEstimateGas;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import org.web3j.tuples.generated.Tuple4;
import org.web3j.tuples.generated.Tuple5;
import org.web3j.tuples.generated.Tuple6;
import org.web3j.tuples.generated.Tuple9;
import org.web3j.tx.ClientTransactionManager;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.utils.Convert;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

import static org.web3j.protocol.http.HttpService.DEFAULT_URL;

/**
 * Created by liuqikang on 2018/8/28.
 */

public class Web3jManager {
    static Web3j web3j;
    static Admin admin;

    static String bank;
    static List<String> accountList;
    static String password = "123";

    static Map<String, String> mapAddrContractToOwner = new HashMap<>();
    static Map<String, List<String> > mapAddrContractToAgent = new HashMap<>();

    private static BigDecimal defaultGasPrice = BigDecimal.valueOf(5);
    private static BigInteger unlockDuration = BigInteger.valueOf(60L);

    // 合约地址与拥有者(商家)对照
    public static Map<String, String> getContractToOwner() {
        return mapAddrContractToOwner;
    }
    // 合约与代理人(认证者)对照
    public static Map<String, List<String>> getContractToAgent() {
        return mapAddrContractToAgent;
    }

    public static void init(Context context){
        Properties properties = new Properties();
        String url = DEFAULT_URL;
        try {
            properties.load(context.getAssets().open("config.properties"));
            url = properties.getProperty("url");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            properties.clear();
        }
        web3j = Web3jFactory.build(new HttpService());
        admin = AdminFactory.build(new HttpService());
        loadAccounts();
    }

    public static void loadAccounts(){
        //获取账户列表
        EthAccounts ethAccounts = null;
        try {
            ethAccounts = web3j.ethAccounts().sendAsync().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        List<String> _accountList = ethAccounts.getAccounts();//返回当前节点持有的账户列表
        if(_accountList.size() > 1){
            bank = _accountList.get(0);
            _accountList.remove(0);
            accountList = _accountList;
        }
    }

    public static String getBankAddress(){return bank;}
    public static String getAccount(int _idex){return accountList.get(_idex);}
    public static String getPassword() {    return password;
    }

    // 测试函数
    public static void getVersion(final ReqVersionListener listener){
        new Thread(new Runnable() {
            @Override
            public void run() {
                Web3ClientVersion response = null;
                try {
                    response = web3j.web3ClientVersion().send();
                    listener.onSuccess(response.getWeb3ClientVersion());
                } catch (IOException e) {
                    listener.onError(e);
                }
            }
        }).start();
    }

    /**
     * 获取普通交易的gas上限
     *
     * @param transaction 交易对象
     * @return gas 上限
     */
    private static BigInteger getTransactionGasLimit(Transaction transaction) {
        BigInteger gasLimit = BigInteger.ZERO;
        try {
            EthEstimateGas ethEstimateGas = web3j.ethEstimateGas(transaction).send();
            gasLimit = ethEstimateGas.getAmountUsed();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return gasLimit;
    }

    /**
     * 获取账号交易次数 nonce
     *
     * @param address 钱包地址
     * @return nonce
     */
    private static BigInteger getTransactionNonce(String address) {
        BigInteger nonce = BigInteger.ZERO;
        try {
            EthGetTransactionCount ethGetTransactionCount = web3j.ethGetTransactionCount(address, DefaultBlockParameterName.PENDING).send();
            nonce = ethGetTransactionCount.getTransactionCount();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return nonce;
    }

    /**
     * 生成一个普通交易对象
     *
     * @param fromAddress 放款方
     * @param toAddress   收款方
     * @param nonce       交易序号
     * @param gasPrice    gas 价格
     * @param gasLimit    gas 数量
     * @param value       金额
     * @return 交易对象
     */
    private static Transaction makeTransaction(String fromAddress, String toAddress,
                                               BigInteger nonce, BigInteger gasPrice,
                                               BigInteger gasLimit, BigInteger value) {
        Transaction transaction;
        transaction = Transaction.createEtherTransaction(fromAddress, nonce, gasPrice, gasLimit, toAddress, value);
        return transaction;
    }

    /**
     * 发送一个普通交易
     *
     * @return 交易 Hash
     */
    public static void sendTransaction(final String _from, final String _password, final String _to, final int _val,
                                       final ReqSendTransferListener listener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                BigDecimal amount = new BigDecimal(_val);
                String txHash = null;
                try {
                    PersonalUnlockAccount personalUnlockAccount = admin.personalUnlockAccount(_from, _password, unlockDuration).send();
                    if (personalUnlockAccount.accountUnlocked()) {
                        BigInteger value = Convert.toWei(amount, Convert.Unit.ETHER).toBigInteger();
//                        Transaction transaction = makeTransaction(_from, _to,
//                                null, null, null, value);
//                        //不是必须的 可以使用默认值
//                        BigInteger gasLimit = getTransactionGasLimit(transaction);
//                        //不是必须的 缺省值就是正确的值
//                        BigInteger nonce = getTransactionNonce(_from);
//                        //该值为大部分矿工可接受的gasPrice
//                        BigInteger gasPrice = Convert.toWei(defaultGasPrice, Convert.Unit.GWEI).toBigInteger();
                        Transaction transaction = makeTransaction(_from, _to,
                                null, Contract.GAS_PRICE, Contract.GAS_LIMIT, value);
                        EthSendTransaction ethSendTransaction = web3j.ethSendTransaction(transaction).send();
                        txHash = ethSendTransaction.getTransactionHash();
                        listener.onSuccess(_from, _to, _val, txHash);
                    }
                } catch (IOException e) {
                    listener.onError(e);
                }
            }
        }).start();
    }

    // 查询用户余额
    public static void getBalance(final String _addr, final ReqGetBalanceListener listener){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    EthGetBalance ethGetBalance = web3j
                            .ethGetBalance(_addr, DefaultBlockParameterName.LATEST)
                            .sendAsync()
                            .get();

                    //格式转化 wei-ether
                    String blanceETH = Convert.fromWei(ethGetBalance.getBalance().toString(), Convert.Unit.ETHER).toPlainString().concat(" ether");

                    listener.onSuccess(_addr, blanceETH);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    // 商家部署商品合约
    public static void deploy(final String _goodsOwner, final String _pwd, final String _name,
                              final int _goodsVal, final int _ratio, final int _commission,
                              final int _singleval,
                              final ReqDepolyListener listener){
        new Thread(new Runnable() {
            @Override
            public void run() {
                // 部署合约
                try {
                    PersonalUnlockAccount personalUnlockAccount = admin.personalUnlockAccount(_goodsOwner, _pwd, unlockDuration).send();
                    if (personalUnlockAccount.accountUnlocked()) {
                        // 以某个用户的身份调用合约
                        TransactionManager transactionManager = new ClientTransactionManager(web3j, _goodsOwner);
                        BigDecimal amount = new BigDecimal(_goodsVal);
                        BigInteger value = Convert.toWei(amount, Convert.Unit.ETHER).toBigInteger();
                        CopyRight contract = CopyRight.deploy(web3j, transactionManager,
                                Contract.GAS_PRICE, Contract.GAS_LIMIT, _name,
                                value, BigInteger.valueOf(_ratio), BigInteger.valueOf(_commission), BigInteger.valueOf(_singleval)).send();
                        mapAddrContractToOwner.put(contract.getContractAddress(), _goodsOwner);
                        listener.onSuccess(_goodsOwner, contract.getContractAddress());
                    }
                } catch (Exception e) {
                    listener.onError(e);
                }
            }
        }).start();
    }

    // 普通用户购买商品
    public static void buy(final String _goodAddr, final String _buyer, final String pwd, final int _val
                            , final ReqSellListener listener){
        new Thread(new Runnable() {
            @Override
            public void run() {
                BigDecimal amount = new BigDecimal(_val);
                BigInteger value = Convert.toWei(amount, Convert.Unit.ETHER).toBigInteger();
                try {
                    PersonalUnlockAccount personalUnlockAccount = admin.personalUnlockAccount(_buyer, pwd, unlockDuration).send();
                    if (personalUnlockAccount.accountUnlocked()) {
                        // 以某个用户的身份调用合约
                        TransactionManager transactionManager = new ClientTransactionManager(web3j, _buyer);
                        CopyRight contract = CopyRight.load(_goodAddr, web3j, transactionManager,
                                Contract.GAS_PRICE, Contract.GAS_LIMIT);
                        //购买
                        TransactionReceipt receipt = contract.sell(value).send();
                        listener.onSuccess(_goodAddr, _buyer, receipt.getTransactionHash());
                    }
                } catch (Exception e) {
                    listener.onError(e);
                }
            }
        }).start();
    }

    // 普通用户通过认证者购买商品
    public static void buyByAgent(final String _goodAddr, final String _buyer, final String pwd,
                                  final int _agentid, final int _val, final ReqSellByAgentListener listener){
        new Thread(new Runnable() {
            @Override
            public void run() {
                BigDecimal amount = new BigDecimal(_val);
                BigInteger value = Convert.toWei(amount, Convert.Unit.ETHER).toBigInteger();

                try {
                    PersonalUnlockAccount personalUnlockAccount = admin.personalUnlockAccount(_buyer, pwd, unlockDuration).send();
                    if (personalUnlockAccount.accountUnlocked()) {
                        TransactionManager transactionManager = new ClientTransactionManager(web3j, _buyer);
                        CopyRight contract = CopyRight.load(_goodAddr, web3j, transactionManager,
                                Contract.GAS_PRICE, Contract.GAS_LIMIT);
                        TransactionReceipt receipt = contract.sellByAgent(BigInteger.valueOf(_agentid), value).send();
                        listener.onSuccess(_goodAddr, _buyer, receipt.getBlockHash());
                    }
                } catch (Exception e) {
                    listener.onError(e);
                }
            }
        }).start();
    }

    // 认证二级代理权，返回刚注册的代理ID
    public static void createAgent(final String _goodAddr, final String _buyer, final String pwd,
                                   final int _weight, final ReqSignUpListener listener){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    PersonalUnlockAccount personalUnlockAccount = admin.personalUnlockAccount(_buyer, pwd, unlockDuration).send();
                    if (personalUnlockAccount.accountUnlocked()) {
                        TransactionManager transactionManager = new ClientTransactionManager(web3j, _buyer);
                        CopyRight contract = CopyRight.load(_goodAddr, web3j, transactionManager,
                                Contract.GAS_PRICE, Contract.GAS_LIMIT);

                        contract.createAgent(BigInteger.valueOf(_weight)).send();
                        BigInteger bgInt = contract.getOwnerAgentCount().send();
                        mapAddrContractToAgent.get(_goodAddr).add(_buyer);
                        listener.onSuccess(_goodAddr, _buyer, bgInt.intValue());
                    }
                } catch (Exception e) {
                    listener.onError(e);
                }
            }
        }).start();
    }

    // 获取代理info
    public static void getAgentInfo(final String _goodAddr, final String _addr, final int _agentid,
                                    final ReqAgentInfoListener listener){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TransactionManager transactionManager = new ClientTransactionManager(web3j, _addr);
                    CopyRight contract = CopyRight.load(_goodAddr, web3j, transactionManager,
                            Contract.GAS_PRICE, Contract.GAS_LIMIT);
                    Tuple4<String, BigInteger, BigInteger, BigInteger> res = contract.getAgentInfo(BigInteger.valueOf(_agentid)).send();

                    listener.onSuccess(res.getValue1(), res.getValue2().intValue(), res.getValue3().intValue(), res.getValue4().intValue());
                } catch (Exception e) {
                    listener.onError(e);
                }
            }
        }).start();
    }

    // 获取代理总数
    public static void getOwnerAgentCount(final String _goodAddr, final String _addr,
                                          final ReqOwnerAgentCountListener listener){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TransactionManager transactionManager = new ClientTransactionManager(web3j, _addr);
                    CopyRight contract = CopyRight.load(_goodAddr, web3j, transactionManager,
                            Contract.GAS_PRICE, Contract.GAS_LIMIT);
                    BigInteger bgInt = contract.getOwnerAgentCount().send();
                    listener.onSuccess(_goodAddr, bgInt.intValue());
                } catch (Exception e) {
                    listener.onError(e);
                }
            }
        }).start();
    }

    // 根据idx获取代理id
    public static void getAgentIdByIdx(final String _goodAddr, final String _addr,
                                       final int _agentidx, final ReqAgentIdByIdxListener listener){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TransactionManager transactionManager = new ClientTransactionManager(web3j, _addr);
                    CopyRight contract = CopyRight.load(_goodAddr, web3j, transactionManager,
                            Contract.GAS_PRICE, Contract.GAS_LIMIT);
                    BigInteger bgInt = contract.getOwnerAgent(BigInteger.valueOf(_agentidx)).send();
                    listener.onSuccess(_goodAddr, bgInt.intValue());
                } catch (Exception e) {
                    listener.onError(e);
                }
            }
        }).start();
    }

    // 根据idx获取代理Info
    public static void getAgentInfoByIdx(final String _goodAddr, final String _addr,
                                         final int _agentidx, final ReqAgentInfoByIdxListener listener){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TransactionManager transactionManager = new ClientTransactionManager(web3j, _addr);
                    CopyRight contract = CopyRight.load(_goodAddr, web3j, transactionManager,
                            Contract.GAS_PRICE, Contract.GAS_LIMIT);
                    Tuple5<BigInteger, String, BigInteger, BigInteger, BigInteger> res =
                            contract.getOwnerAgentInfo(BigInteger.valueOf(_agentidx)).send();
                    listener.onSuccess(_goodAddr, res.getValue1().intValue(), res.getValue2(),
                            res.getValue3().intValue(), res.getValue4().intValue(), res.getValue5().intValue());
                } catch (Exception e) {
                    listener.onError(e);
                }
            }
        }).start();
    }

    // 获取商品info
    public static void getGoodsInfo(final String _goodAddr, final String _addr, final ReqGetGoodsInfoListener listener){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TransactionManager transactionManager = new ClientTransactionManager(web3j, _addr);
                    CopyRight contract = CopyRight.load(_goodAddr, web3j, transactionManager,
                            Contract.GAS_PRICE, Contract.GAS_LIMIT);
                    final Tuple9<String, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger,
                            BigInteger, BigInteger, BigInteger> res =
                            contract.getGoodsInfo().send();
                    //格式转化 wei-ether
                    final String blanceETH = Convert.fromWei(res.getValue2().toString(), Convert.Unit.ETHER).toString();

                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                         @Override
                         public void run() {
                             listener.onSuccess(_goodAddr, res.getValue1(),
                                     Integer.parseInt(blanceETH),
                                     res.getValue3().intValue(),res.getValue4().intValue(),
                                     res.getValue5().intValue(), res.getValue6().intValue(),
                                     res.getValue7().intValue(), res.getValue8().intValue(),
                                     res.getValue9().intValue());
                         }
                     });

                } catch (Exception e) {
                    listener.onError(e);
                }
            }
        }).start();
    }

    // 根据商品合约信息
//    public static void getGoodsInfo(final String _goodAddr, final String _addr, final ReqGetGoodsInfoListener listener){
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    TransactionManager transactionManager = new ClientTransactionManager(web3j, _addr);
//                    CopyRight contract = CopyRight.load(_goodAddr, web3j, transactionManager,
//                            Contract.GAS_PRICE, Contract.GAS_LIMIT);
//                    BigInteger val1 = contract.getGoodsValue().send();
//                    BigInteger val2 = contract.getCommissionRatio().send();
//                    BigInteger val3 = contract.getShineRatio().send();
//
//                    listener.onSuccess(_goodAddr, val1.intValue(), val2.intValue(), val3.intValue());
//                } catch (Exception e) {
//                    listener.onError(e);
//                }
//            }
//        }).start();
//    }

    public interface Web3jReqListener{
        void onError(Exception _e);
    }

    public interface ReqVersionListener extends Web3jReqListener{
        void onSuccess(String _version);
    }

    public interface ReqDepolyListener extends Web3jReqListener{
        void onSuccess(String _goodsOwner, String _contractAddr);
    }

    public interface ReqSignUpListener extends Web3jReqListener{
        void onSuccess(String _goodAddr, String _buyer, int _agentCount);
    }

    public interface ReqGetBalanceListener extends Web3jReqListener{
        void onSuccess(String _addr, String _balance);
    }

    public interface ReqSendTransferListener extends Web3jReqListener{
        void onSuccess(String _from, String _to, int _val,String _result);
    }

    public interface ReqSellListener extends Web3jReqListener{
        void onSuccess(String _goodAddr, String _buyer, String _blockAddr);
    }

    // 通过代理购买商品
    public interface ReqSellByAgentListener extends Web3jReqListener{
        void onSuccess(String _goodAddr, String _buyer, String _blockAddr);
    }

    //获取代理信息
    public interface ReqAgentInfoListener extends Web3jReqListener{
        void onSuccess(String _owner, int _weight, int _createtime, int _profit);
    }

    // 获取代理数量
    public interface ReqOwnerAgentCountListener extends Web3jReqListener{
        void onSuccess(String _addr, int _count);
    }

    // 获取代理id
    public interface ReqAgentIdByIdxListener extends Web3jReqListener{
        void onSuccess(String _addr, int _agentid);
    }

    // 获取代理Info
    public interface ReqAgentInfoByIdxListener extends Web3jReqListener{
        void onSuccess(String _addr, int _agentid,String _owner, int _weight, int _createtime, int _profit);
    }

    // 获取商品信息
    public interface ReqGetGoodsInfoListener extends Web3jReqListener{
        void onSuccess(String _addr, String _name, int _price,
                       int _commRatio, int _shineRatio,
                       int _sumAgenter, int _allweight,
                       int _allShine, int _allComm,
                       int _singleval);
    }


//    public interface Web3jResListener {
//        void reqVersionSuccess(String _version);    // 测试版本信息
//        void reqDepolySuccess(String _goodsOwner, String _contractAddr);    // 部署商品
//        void reqSignUpSuccess(String _goodAddr, String _buyer, int _agentCount);     // 用户认购商品
//        void reqGetBalanceSuccess(String _addr, String _balance); // 用户余额
//        void reqSendTransferSuccess(String _from, String _to, int _val,String _result);//银行分账
//        void reqSellSuccess(String _goodAddr, String _buyer, String _blockAddr); // 购买商品
//        void reqSellByAgentSuccess(String _goodAddr, String _buyer, String _blockAddr);  // 通过代理购买商品
//        void reqAgentInfoSuccess(String _owner, int _weight, int _createtime, int _profit);//获取代理信息
//        void reqOwnerAgentCountSuccess(String _addr, int _count);// 获取代理数量
//        void reqAgentIdByIdxSuccess(String _addr, int _agentid);  // 获取代理id
//        void reqAgentInfoByIdxSuccess(String _addr, int _agentid,String _owner, int _weight, int _createtime, int _profit);// 获取代理Info
//        void reqGetGoodsInfoSuccess(String _addr, int _price, int _commRatio, int _shineRatio);// 获取商品信息
//        void onError(Exception _e);
//    }
}
