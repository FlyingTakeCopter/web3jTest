package com.web3jtest;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.web3jtest.web3.Web3jManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import org.web3j.protocol.Web3jFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "web3j-log";

    public static Map<String, String> ownerToGoods;

    public static Map<String, List<Integer>> ownerToAgent;

    static String bank = "0x855ce19c4714c980a35c985704947ecd1e9992a0";

    static String[] user_account = {
            "0x2b40bef721451017c60b30c806493bba8e64e59d",
            "0x782462c0418f4a94e86c7391b4dfb713092ce570",
            "0xf2c942176ba4532995092cb25436513008b29386",
            "0x93427a42c469aa1277978daf5139ddee06a02184"
    };

    static String passwrod = "123";

    Button btnVersion;
    Button btnBalance;
    Button btnDeploy;
    Button btnSignup;
    Button btnTransfer;
    Button btnSell;
    Button btnSellByAgent;
    Button btnPrice;
    Button btnAgentInfo;

    TextView text;

    void initView(){
        text = findViewById(R.id.text);
        btnVersion = findViewById(R.id.testversion);
        btnBalance = findViewById(R.id.balance);
        btnDeploy = findViewById(R.id.deploy);
        btnSignup = findViewById(R.id.signup);
        btnTransfer = findViewById(R.id.transfer);
        btnSell = findViewById(R.id.sell);
        btnSellByAgent = findViewById(R.id.sellbyagent);
        btnPrice = findViewById(R.id.price);
        btnAgentInfo = findViewById(R.id.agentinfo);

        btnVersion.setOnClickListener(this);
        btnBalance.setOnClickListener(this);
        btnDeploy.setOnClickListener(this);
        btnSignup.setOnClickListener(this);
        btnTransfer.setOnClickListener(this);
        btnSell.setOnClickListener(this);
        btnSellByAgent.setOnClickListener(this);
        btnPrice.setOnClickListener(this);
        btnAgentInfo.setOnClickListener(this);
    }

    void initData(){
        initAccounts();
        ownerToGoods = new HashMap<>();
        ownerToAgent = new HashMap<>();
    }

    private void initAccounts() {
        try {
            List<String> accounts = new ArrayList<>();
            InputStream is = getResources().getAssets().open("account.config");
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String s;
            while ((s = reader.readLine()) != null) {
                accounts.add(s);
            }
            bank = accounts.get(0);
            Log.i(TAG, "initAccounts: " + bank);
            user_account = accounts.subList(1, accounts.size()).toArray(user_account);
            Log.i(TAG, "initAccounts: " + Arrays.toString(user_account));
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();

        int REQUEST_EXTERNAL_STORAGE = 1;
        String[] PERMISSIONS_STORAGE = {
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        };
        int permission = ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    MainActivity.this,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }

        Web3jManager.init(this);



//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    String url = "http://127.0.0.1:8545";
//
//                    //只读属性，返回当前节点持有的帐户列表
//                    Web3j web3 = Web3jFactory.build(new HttpService());
//
//                    Request<?, Web3ClientVersion> request = web3.web3ClientVersion();
//                    Web3ClientVersion response = request.send();
//                    String version = response.getWeb3ClientVersion();
//                    Log.i(TAG, "web3j version: " + version);
//
//                    //获取账户列表
//                    EthAccounts ethAccounts = web3.ethAccounts().sendAsync().get();
//                    List<String> accountList = ethAccounts.getAccounts();//返回当前节点持有的账户列表
//                    for (int i = 0; i < accountList.size(); i++){
//                        Log.i(TAG, "account_" + i + ":" + accountList.get(i));
//                    }
//
////                    String pass = "12345678";
//                    // 导入已有私钥，根据私钥推导公钥和账户
////                    BigInteger privateKey = new BigInteger("c87509a1c067bbde78beb793e6fa76530b6382a4c0241e5e4a9ec0a0f44dc0d3", 16);
////                    ECKeyPair keyPair = ECKeyPair.create(privateKey);
////                    String account = Keys.getAddress(keyPair);
////                    String publicKey = keyPair.getPublicKey().toString(16);
////                    Log.i(TAG, "web3j account: " + account);
////                    Log.i(TAG, "web3j publicKey: " + publicKey);
////
////                    File destDir = new File(Environment.getExternalStorageDirectory().toString(), "keystore");
////                    // 根据密码创建一个钱包
////                     String fn = WalletUtils.generateWalletFile(pass, keyPair, destDir, false);
////                    Log.i(TAG, "web3j WalletFile: " + fn);
//
//                    // 加载钱包(凭证)
////                    String fn = "UTC--2018-07-24T02-58-35.591--627306090abab3a6e1400e9345bc60c78a8bef57.json";
////                    String filePath = Environment.getExternalStorageDirectory().toString() + "/keystore";
////                    File destDir = new File(filePath, fn);
////                    Credentials credentials = WalletUtils.loadCredentials(pass,destDir);
//
//                    String user1 = "0x627306090abab3a6e1400e9345bc60c78a8bef57";
//                    String user1PrivateKey = "c87509a1c067bbde78beb793e6fa76530b6382a4c0241e5e4a9ec0a0f44dc0d3";
//                    // 通过user1私钥加载凭证
//                    Credentials credentials = Credentials.create(user1PrivateKey);
//
//                    Log.i(TAG, "web3j credentials address: " + credentials.getAddress());
//                    //智能合约部署
//                    TutorialToken lqktoken = TutorialToken.deploy(web3,credentials, Contract.GAS_PRICE,Contract.GAS_LIMIT).send();
//                    Log.i(TAG, "web3j lqktoken contract address: " + lqktoken.getContractAddress());
//
//                    //查余额
//                    BigInteger userBalances = lqktoken.balanceOf(user1).send();
//                    Log.i(TAG, "user1 balances: " + userBalances.toString());
//
//                    String user2 = "0xf17f52151ebef6c7334fad080c5704d77216b732";
//                    //转账
//                    TransactionReceipt transactionReceipt = lqktoken.transfer(user2, BigInteger.valueOf(100)).send();
//                    String status = transactionReceipt.getStatus();
//
//                    //结果
//                    userBalances = lqktoken.balanceOf(user1).send();
//                    Log.i(TAG, "user1 balances: " + userBalances.toString());
//                    userBalances = lqktoken.balanceOf(user2).send();
//                    Log.i(TAG, "user2 balances: " + userBalances.toString());
////                    //运行日志
////                    List<org.web3j.protocol.core.methods.response.Log> listLog = transactionReceipt.getLogs();
////                    Log.i(TAG, "transactionReceipt log start:");
////                    for (int i = 0; i < listLog.size(); i++){
////                        Log.i(TAG, listLog.get(i) + "");
////                    }
////                    Log.i(TAG, "transactionReceipt log end:");
////                    //状态
////                    Log.i(TAG, "transfer status: " + status);
//
////
////
////
////                    return;
//                    /////////////////////
//
//
//
//
//
//
//
//
//
//                    //web3j中账户管理的功能主要由org.web3j.crypto包实现，常用的类 包括：
//                    //
//                    //ECKeyPair：表征密钥对的类
//                    //WalletUtils：钱包辅助类
//                    //Credentials：账户凭证类
//                    //
//                    //可以使用ECKeyPair来创建新的密钥对，或者导入已有的私钥； WalletUtils可以用来生成或载入钱包文件，
//                    // 而Credentials则 包含了一个账户的全部标识信息，是执行交易的主体。
//                    //创建私钥(账户和公钥都可以从私钥中推导出)
////                    ECKeyPair keyPair = Keys.createEcKeyPair();
////                    String privateKey = keyPair.getPrivateKey().toString(16);
////                    String publicKey = keyPair.getPublicKey().toString(16);
////                    String account = Keys.getAddress(keyPair);
////                    String account1 = Keys.getAddress(publicKey);
//
//                    // 导入已有私钥，根据私钥推导公钥和账户
////                    BigInteger privateKey = new BigInteger("5908481cfd9d9aacbe068e749d3b2213046cf42b6b4bdc3833d21143df758b36", 16);
////                    ECKeyPair keyPair = ECKeyPair.create(privateKey);
////                    String account = Keys.getAddress(keyPair);
////                    String publicKey = keyPair.getPublicKey().toString(16);
//
//                    // 根据用户私钥，创建一个钱包
////                    String pass = "123";
//////                    File destDir = new File(Environment.getExternalStorageDirectory().toString(), "keystore");
//////                    // 根据密码创建一个钱包
//////                     String fn = WalletUtils.generateWalletFile(pass, keyPair, destDir, false);
////                    // 加载一个钱包,获取用户信息
////                    String fn = "UTC--2018-07-11T01-42-37.316--a62846ad6dfbe04a413de2ff66ddc02eac49e97a.json";
////                    String filePath = Environment.getExternalStorageDirectory().toString() + "/keystore";
////                    File destDir = new File(filePath, fn);
////                    Credentials credentials = WalletUtils.loadCredentials(pass,destDir);
////                    ECKeyPair keyPair = credentials.getEcKeyPair();
////                    String account2 = credentials.getAddress();
////                    String privateKey2 = keyPair.getPrivateKey().toString(16);
////                    Log.i(TAG,"load Credentials success!\n account : " + account2 + "\n private key : " + privateKey2);
//
//
//
//
//
//                }catch (InterruptedException e) {
//                    e.printStackTrace();
//                } catch (ExecutionException e) {
//                    e.printStackTrace();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();

    }

    private void MyLog(final String _show){
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                text.setText(_show + "\n" + text.getText());
            }
        });
    }

    Web3jManager.ReqGetBalanceListener getBalanceListener = new Web3jManager.ReqGetBalanceListener() {

        @Override
        public void onSuccess(String _addr, String _balance) {
            MyLog(_addr + ":" + _balance);
        }

        @Override
        public void onError(Exception _e) {
            MyLog(_e.toString());
        }
    };

    Web3jManager.ReqSendTransferListener sendTransferListener = new Web3jManager.ReqSendTransferListener() {
        @Override
        public void onSuccess(String _from, String _to, int _val, String _result) {
            MyLog("from:" + _from + " to:" + _to + " val:" + _val + " res:" + _result);
        }

        @Override
        public void onError(Exception _e) {
            MyLog(_e.toString());
        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.testversion:
            {
                Web3jManager.getVersion(new Web3jManager.ReqVersionListener() {
                    @Override
                    public void onSuccess(String _version) {
                        MyLog(_version);
                    }

                    @Override
                    public void onError(Exception _e) {
                        MyLog(_e.toString());
                    }
                });
                break;
            }
            case R.id.balance:
            {
                Web3jManager.getBalance(bank, getBalanceListener);
                for (String s : user_account) {
                    Web3jManager.getBalance(s, getBalanceListener);
                }
//                Web3jManager.getBalance(user_account[0], getBalanceListener);
//                Web3jManager.getBalance(user_account[1], getBalanceListener);
//                Web3jManager.getBalance(user_account[2], getBalanceListener);
//                Web3jManager.getBalance(user_account[3], getBalanceListener);

                break;
            }
            case R.id.deploy:
            {
                Web3jManager.deploy(user_account[0], passwrod, "黑鲨手机", 10,
                        20, 20, new Web3jManager.ReqDepolyListener(){

                    @Override
                    public void onSuccess(String _goodsOwner, String _contractAddr) {
                        MyLog(_goodsOwner + _contractAddr);
                    }

                    @Override
                    public void onError(Exception _e) {

                    }
                });
                break;
            }
            case R.id.signup:
            {
//                Web3jManager.createAgent(ownerToGoods.get(user_account[0]), user_account[1], passwrod, 10);
                break;
            }
            case R.id.transfer:
            {
//                Web3jManager.sendTransaction(bank, passwrod, user_account[0], 100, sendTransferListener);
//                Web3jManager.sendTransaction(bank, passwrod, user_account[1], 100, sendTransferListener);
//                Web3jManager.sendTransaction(bank, passwrod, user_account[2], 100, sendTransferListener);
//                Web3jManager.sendTransaction(bank, passwrod, user_account[3], 100, sendTransferListener);
                for (String s : user_account) {
                    Web3jManager.sendTransaction(bank, passwrod, s, 100, sendTransferListener);
                }
                break;
            }
            case R.id.sell:
            {
//                Web3jManager.buy(ownerToGoods.get(user_account[0]), user_account[3], passwrod, 10);
                break;
            }
            case R.id.sellbyagent:
            {
//                Web3jManager.buyByAgent(ownerToGoods.get(user_account[0]), user_account[2], passwrod, 0, 10);
                break;
            }
            case R.id.price:
            {
//                Web3jManager.getGoodsPrice(ownerToGoods.get(user_account[0]) ,user_account[0]);
                break;
            }
            case R.id.agentinfo:
            {
//                Web3jManager.getAgentInfo(ownerToGoods.get(user_account[0]) ,user_account[0], 0);
                break;
            }
        }
    }

}
