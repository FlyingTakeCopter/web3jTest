package com.web3jtest.contract;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple4;
import org.web3j.tuples.generated.Tuple5;
import org.web3j.tuples.generated.Tuple6;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import rx.Observable;
import rx.functions.Func1;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.3.1.
 */
public class CopyRight extends Contract {
    private static final String BINARY = "0x608060405260006001553480156200001657600080fd5b5060405162001fd338038062001fd383398101806040528101908080518201929190602001805190602001909291908051906020019092919080519060200190929190505050336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055508360099080519060200190620000b4929190620000e8565b508260078190555081600660006101000a81548160ff021916908360ff160217905550806008819055505050505062000197565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106200012b57805160ff19168380011785556200015c565b828001600101855582156200015c579182015b828111156200015b5782518255916020019190600101906200013e565b5b5090506200016b91906200016f565b5090565b6200019491905b808211156200019057600081600090555060010162000176565b5090565b90565b611e2c80620001a76000396000f3006080604052600436106101a1576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff168063095ea7b3146101a65780630a4acb14146101f357806319a6a6e91461024a5780631cf1c2bc146102cc578063200198e61461031157806344f6d9b314610352578063457100741461037f57806350f820e61461038957806356e36b93146103b45780636352211e146103e1578063664d20951461044e5780636d6fdd9b1461047b57806370a08231146104a65780637237ad2a146104fd57806374c59e961461054257806380d65b3f146105cb5780638da5cb5b146106385780638eb851681461068f5780638f2357ba146106ba5780639a644bab14610727578063a9059cbb14610747578063b1847c2e14610794578063b2e6ceeb146107d9578063b5e16cc114610806578063b956c0b1146108b9578063bca40bfa146108f0578063bf7bcfd014610935578063cb06cbdd14610976578063d3f5ca9e146109b7578063d846dd0f146109e2578063e90d6e5514610a0d578063eec5136914610a4e578063fdbe666714610a8f575b600080fd5b3480156101b257600080fd5b506101f1600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190505050610aba565b005b3480156101ff57600080fd5b50610234600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610b89565b6040518082815260200191505060405180910390f35b34801561025657600080fd5b5061027560048036038101908080359060200190929190505050610ba1565b604051808573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200184815260200183815260200182815260200194505050505060405180910390f35b3480156102d857600080fd5b506102f760048036038101908080359060200190929190505050610c8d565b604051808215151515815260200191505060405180910390f35b34801561031d57600080fd5b5061033c60048036038101908080359060200190929190505050610caa565b6040518082815260200191505060405180910390f35b34801561035e57600080fd5b5061037d60048036038101908080359060200190929190505050610cfd565b005b610387610d62565b005b34801561039557600080fd5b5061039e610ec6565b6040518082815260200191505060405180910390f35b3480156103c057600080fd5b506103df60048036038101908080359060200190929190505050610ed3565b005b3480156103ed57600080fd5b5061040c60048036038101908080359060200190929190505050611085565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34801561045a57600080fd5b50610479600480360381019080803590602001909291905050506110c2565b005b34801561048757600080fd5b506104906111e8565b6040518082815260200191505060405180910390f35b3480156104b257600080fd5b506104e7600480360381019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506111f2565b6040518082815260200191505060405180910390f35b34801561050957600080fd5b506105286004803603810190808035906020019092919050505061123b565b604051808215151515815260200191505060405180910390f35b34801561054e57600080fd5b5061056d600480360381019080803590602001909291905050506112bf565b604051808681526020018573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018481526020018381526020018281526020019550505050505060405180910390f35b3480156105d757600080fd5b506105f660048036038101908080359060200190929190505050611450565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34801561064457600080fd5b5061064d611483565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34801561069b57600080fd5b506106a46114a8565b6040518082815260200191505060405180910390f35b3480156106c657600080fd5b506106e5600480360381019080803590602001909291905050506114b2565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b610745600480360381019080803590602001909291905050506114fc565b005b34801561075357600080fd5b50610792600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803590602001909291905050506116f8565b005b3480156107a057600080fd5b506107bf6004803603810190808035906020019092919050505061171b565b604051808215151515815260200191505060405180910390f35b3480156107e557600080fd5b5061080460048036038101908080359060200190929190505050611752565b005b34801561081257600080fd5b5061081b6117db565b6040518080602001878152602001868152602001858152602001848152602001838152602001828103825288818151815260200191508051906020019080838360005b8381101561087957808201518184015260208101905061085e565b50505050905090810190601f1680156108a65780820380516001836020036101000a031916815260200191505b5097505050505050505060405180910390f35b3480156108c557600080fd5b506108ee60048036038101908080359060200190929190803590602001909291905050506118c3565b005b3480156108fc57600080fd5b5061091b600480360381019080803590602001909291905050506118f5565b604051808215151515815260200191505060405180910390f35b34801561094157600080fd5b5061096060048036038101908080359060200190929190505050611945565b6040518082815260200191505060405180910390f35b34801561098257600080fd5b506109a16004803603810190808035906020019092919050505061196f565b6040518082815260200191505060405180910390f35b3480156109c357600080fd5b506109cc611999565b6040518082815260200191505060405180910390f35b3480156109ee57600080fd5b506109f76119b3565b6040518082815260200191505060405180910390f35b348015610a1957600080fd5b50610a38600480360381019080803590602001909291905050506119fa565b6040518082815260200191505060405180910390f35b348015610a5a57600080fd5b50610a7960048036038101908080359060200190929190505050611a24565b6040518082815260200191505060405180910390f35b348015610a9b57600080fd5b50610aa4611b8f565b6040518082815260200191505060405180910390f35b610ac38161123b565b1515610ace57600080fd5b816005600083815260200190815260200160002060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055508173ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff167f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b925836040518082815260200191505060405180910390a35050565b60046020528060005260406000206000915090505481565b600080600080610baf611db8565b600286815481101515610bbe57fe5b906000526020600020906005020160a060405190810160405290816000820160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200160018201548152602001600282015481526020016003820160009054906101000a900460ff16151515158152602001600482015481525050905080600001518160200151826040015183608001519450945094509450509193509193565b6000808210158015610ca3575060028054905082105b9050919050565b6000806064600660009054906101000a900460ff1660ff16811515610ccb57fe5b0460ff16600754029050610cdd6111e8565b610ce684611945565b8202811515610cf157fe5b04905080915050919050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610d5857600080fd5b8060078190555050565b6000806000806007543410151515610d7957600080fd5b60009350610d856111e8565b9250600083141515610e56576064600660009054906101000a900460ff1660ff163402811515610db157fe5b049350600091505b610dc1610ec6565b821015610e5557610dd18261171b565b15610e485782610de083611945565b8502811515610deb57fe5b049050610df7826114b2565b73ffffffffffffffffffffffffffffffffffffffff166108fc829081150290604051600060405180830381858888f19350505050158015610e3c573d6000803e3d6000fd5b50610e4782826118c3565b5b8180600101925050610db9565b5b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166108fc8534039081150290604051600060405180830381858888f19350505050158015610ebf573d6000803e3d6000fd5b5050505050565b6000600280549050905090565b60006001600260a0604051908101604052803373ffffffffffffffffffffffffffffffffffffffff16815260200185815260200142815260200160011515815260200160008152509080600181540180825580915050906001820390600052602060002090600502016000909192909190915060008201518160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550602082015181600101556040820151816002015560608201518160030160006101000a81548160ff021916908315150217905550608082015181600401555050039050336003600083815260200190815260200160002060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550600460003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008154809291906001019190505550816001600082825401925050819055505050565b60006003600083815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff169050919050565b60006110cd82610c8d565b80156110de57506110dd826118f5565b5b80156110ef57506110ee8261123b565b5b15156110fa57600080fd5b60028281548110151561110957fe5b906000526020600020906005020190508060030160009054906101000a900460ff16801561113c57506000816001015414155b151561114757600080fd5b8060010154600160008282540392505081905550600060028381548110151561116c57fe5b906000526020600020906005020160030160006101000a81548160ff021916908315150217905550600460003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008154809291906001900391905055505050565b6000600154905090565b6000600460008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020549050919050565b600061124682610c8d565b151561125557600090506112ba565b6003600083815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161490505b919050565b60008060008060006112cf611db8565b60008060006112dc6119b3565b8a1015156112e957600080fd5b60009250600090505b6002805490508110156114245760028181548110151561130e57fe5b906000526020600020906005020160a060405190810160405290816000820160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200160018201548152602001600282015481526020016003820160009054906101000a900460ff1615151515815260200160048201548152505093503373ffffffffffffffffffffffffffffffffffffffff16846000015173ffffffffffffffffffffffffffffffffffffffff161480156113f9575083606001515b1561141757809150828a141561140e57611424565b82806001019350505b80806001019150506112f2565b818460000151856020015186604001518760800151985098509850985098505050505091939590929450565b60036020528060005260406000206000915054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b6000600754905090565b60006002828154811015156114c357fe5b906000526020600020906005020160000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff169050919050565b6000806000806000600754341015151561151557600080fd5b6000945061152286610c8d565b80156115335750611532866118f5565b5b156115a5576064600854340281151561154857fe5b049450611554866114b2565b73ffffffffffffffffffffffffffffffffffffffff166108fc869081150290604051600060405180830381858888f19350505050158015611599573d6000803e3d6000fd5b506115a486866118c3565b5b6115ad6111e8565b935060009250600084141515611684576064600660009054906101000a900460ff1660ff16863403028115156115df57fe5b049250600091505b6115ef610ec6565b821015611683576115ff8261171b565b15611676578361160e83611945565b840281151561161957fe5b049050611625826114b2565b73ffffffffffffffffffffffffffffffffffffffff166108fc829081150290604051600060405180830381858888f1935050505015801561166a573d6000803e3d6000fd5b5061167582826118c3565b5b81806001019250506115e7565b5b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166108fc84873403039081150290604051600060405180830381858888f193505050501580156116ef573d6000803e3d6000fd5b50505050505050565b6117018161123b565b151561170c57600080fd5b611717338383611b99565b5050565b600060028281548110151561172c57fe5b906000526020600020906005020160030160009054906101000a900460ff169050919050565b60003373ffffffffffffffffffffffffffffffffffffffff166005600084815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161415156117c157600080fd5b6117ca82611085565b90506117d7813384611b99565b5050565b606060008060008060006009600754600660009054906101000a900460ff166008546118056111e8565b61180d610ec6565b858054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156118a25780601f10611877576101008083540402835291602001916118a2565b820191906000526020600020905b81548152906001019060200180831161188557829003601f168201915b505050505095508360ff169350955095509550955095509550909192939495565b806002838154811015156118d357fe5b9060005260206000209060050201600401600082825401925050819055505050565b600061190082610c8d565b151561190f5760009050611940565b60028281548110151561191e57fe5b906000526020600020906005020160030160009054906101000a900460ff1690505b919050565b600060028281548110151561195657fe5b9060005260206000209060050201600101549050919050565b600060028281548110151561198057fe5b9060005260206000209060050201600201549050919050565b6000600660009054906101000a900460ff1660ff16905090565b6000600460003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002054905090565b6000600282815481101515611a0b57fe5b9060005260206000209060050201600401549050919050565b6000611a2e611db8565b6000806000611a3b6119b3565b86101515611a4857600080fd5b60009250600090505b600280549050811015611b8357600281815481101515611a6d57fe5b906000526020600020906005020160a060405190810160405290816000820160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200160018201548152602001600282015481526020016003820160009054906101000a900460ff1615151515815260200160048201548152505093503373ffffffffffffffffffffffffffffffffffffffff16846000015173ffffffffffffffffffffffffffffffffffffffff16148015611b58575083606001515b15611b765780915082861415611b6d57611b83565b82806001019350505b8080600101915050611a51565b81945050505050919050565b6000600854905090565b611bec6001600460008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002054611d8190919063ffffffff16565b600460008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002081905550611c826001600460003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002054611d9f90919063ffffffff16565b600460003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002081905550816003600083815260200190815260200160002060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055508173ffffffffffffffffffffffffffffffffffffffff168373ffffffffffffffffffffffffffffffffffffffff167fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef836040518082815260200191505060405180910390a3505050565b6000808284019050838110151515611d9557fe5b8091505092915050565b6000828211151515611dad57fe5b818303905092915050565b60a060405190810160405280600073ffffffffffffffffffffffffffffffffffffffff16815260200160008152602001600081526020016000151581526020016000815250905600a165627a7a72305820c2ec8b94b16e48340447cfb811271295b160d72da513f1abed8f4137c21c56e50029";

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<>();
    }

    protected CopyRight(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected CopyRight(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public List<TransferEventResponse> getTransferEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("Transfer", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(event, transactionReceipt);
        ArrayList<TransferEventResponse> responses = new ArrayList<TransferEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            TransferEventResponse typedResponse = new TransferEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._from = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse._to = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse._tokenId = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<TransferEventResponse> transferEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("Transfer", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, TransferEventResponse>() {
            @Override
            public TransferEventResponse call(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(event, log);
                TransferEventResponse typedResponse = new TransferEventResponse();
                typedResponse.log = log;
                typedResponse._from = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse._to = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse._tokenId = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public List<ApprovalEventResponse> getApprovalEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("Approval", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(event, transactionReceipt);
        ArrayList<ApprovalEventResponse> responses = new ArrayList<ApprovalEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            ApprovalEventResponse typedResponse = new ApprovalEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._owner = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse._approved = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse._tokenId = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<ApprovalEventResponse> approvalEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("Approval", 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, ApprovalEventResponse>() {
            @Override
            public ApprovalEventResponse call(Log log) {
                EventValuesWithLog eventValues = extractEventParametersWithLog(event, log);
                ApprovalEventResponse typedResponse = new ApprovalEventResponse();
                typedResponse.log = log;
                typedResponse._owner = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse._approved = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse._tokenId = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public RemoteCall<TransactionReceipt> approve(String _to, BigInteger _tokenId) {
        final Function function = new Function(
                "approve", 
                Arrays.<Type>asList(new Address(_to),
                new Uint256(_tokenId)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> ownerAgentCount(String param0) {
        final Function function = new Function("ownerAgentCount", 
                Arrays.<Type>asList(new Address(param0)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<Tuple4<String, BigInteger, BigInteger, BigInteger>> getAgentInfo(BigInteger _agentid) {
        final Function function = new Function("getAgentInfo", 
                Arrays.<Type>asList(new Uint256(_agentid)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple4<String, BigInteger, BigInteger, BigInteger>>(
                new Callable<Tuple4<String, BigInteger, BigInteger, BigInteger>>() {
                    @Override
                    public Tuple4<String, BigInteger, BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple4<String, BigInteger, BigInteger, BigInteger>(
                                (String) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue());
                    }
                });
    }

    public RemoteCall<Boolean> checkAgentExist(BigInteger _agentId) {
        final Function function = new Function("checkAgentExist", 
                Arrays.<Type>asList(new Uint256(_agentId)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<BigInteger> getAllAgentsCount() {
        final Function function = new Function("getAllAgentsCount", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> createAgent(BigInteger _weight) {
        final Function function = new Function(
                "createAgent", 
                Arrays.<Type>asList(new Uint256(_weight)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> ownerOf(BigInteger _tokenId) {
        final Function function = new Function("ownerOf", 
                Arrays.<Type>asList(new Uint256(_tokenId)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> deleteAgent(BigInteger _agentId) {
        final Function function = new Function(
                "deleteAgent", 
                Arrays.<Type>asList(new Uint256(_agentId)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> getAllAgentsWeight() {
        final Function function = new Function("getAllAgentsWeight", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> balanceOf(String _owner) {
        final Function function = new Function("balanceOf", 
                Arrays.<Type>asList(new Address(_owner)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<Boolean> checkAgentOwnerOf(BigInteger _agentId) {
        final Function function = new Function("checkAgentOwnerOf", 
                Arrays.<Type>asList(new Uint256(_agentId)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<Tuple5<BigInteger, String, BigInteger, BigInteger, BigInteger>> getOwnerAgentInfo(BigInteger _agentIdx) {
        final Function function = new Function("getOwnerAgentInfo", 
                Arrays.<Type>asList(new Uint256(_agentIdx)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple5<BigInteger, String, BigInteger, BigInteger, BigInteger>>(
                new Callable<Tuple5<BigInteger, String, BigInteger, BigInteger, BigInteger>>() {
                    @Override
                    public Tuple5<BigInteger, String, BigInteger, BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple5<BigInteger, String, BigInteger, BigInteger, BigInteger>(
                                (BigInteger) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue(), 
                                (BigInteger) results.get(4).getValue());
                    }
                });
    }

    public RemoteCall<String> agentToOwner(BigInteger param0) {
        final Function function = new Function("agentToOwner", 
                Arrays.<Type>asList(new Uint256(param0)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> owner() {
        final Function function = new Function("owner", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<String> getAgentAddress(BigInteger _agentid) {
        final Function function = new Function("getAgentAddress", 
                Arrays.<Type>asList(new Uint256(_agentid)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> transfer(String _to, BigInteger _tokenId) {
        final Function function = new Function(
                "transfer", 
                Arrays.<Type>asList(new Address(_to),
                new Uint256(_tokenId)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Boolean> getAgentValid(BigInteger _agentid) {
        final Function function = new Function("getAgentValid", 
                Arrays.<Type>asList(new Uint256(_agentid)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<TransactionReceipt> takeOwnership(BigInteger _tokenId) {
        final Function function = new Function(
                "takeOwnership", 
                Arrays.<Type>asList(new Uint256(_tokenId)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> addAgentProfit(BigInteger _agentid, BigInteger _val) {
        final Function function = new Function(
                "addAgentProfit", 
                Arrays.<Type>asList(new Uint256(_agentid),
                new Uint256(_val)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Boolean> checkAgentValid(BigInteger _agentId) {
        final Function function = new Function("checkAgentValid", 
                Arrays.<Type>asList(new Uint256(_agentId)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<BigInteger> getAgentWeight(BigInteger _agentid) {
        final Function function = new Function("getAgentWeight", 
                Arrays.<Type>asList(new Uint256(_agentid)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> getAgentCreateTime(BigInteger _agentid) {
        final Function function = new Function("getAgentCreateTime", 
                Arrays.<Type>asList(new Uint256(_agentid)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> getOwnerAgentCount() {
        final Function function = new Function("getOwnerAgentCount", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> getAgentProfit(BigInteger _agentid) {
        final Function function = new Function("getAgentProfit", 
                Arrays.<Type>asList(new Uint256(_agentid)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> getOwnerAgent(BigInteger _agentIdx) {
        final Function function = new Function("getOwnerAgent", 
                Arrays.<Type>asList(new Uint256(_agentIdx)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public static RemoteCall<CopyRight> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _name, BigInteger _value, BigInteger _ratio, BigInteger _commission) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Utf8String(_name),
                new Uint256(_value),
                new org.web3j.abi.datatypes.generated.Uint8(_ratio), 
                new Uint256(_commission)));
        return deployRemoteCall(CopyRight.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static RemoteCall<CopyRight> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _name, BigInteger _value, BigInteger _ratio, BigInteger _commission) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Utf8String(_name),
                new Uint256(_value),
                new org.web3j.abi.datatypes.generated.Uint8(_ratio), 
                new Uint256(_commission)));
        return deployRemoteCall(CopyRight.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public RemoteCall<TransactionReceipt> sell(BigInteger weiValue) {
        final Function function = new Function(
                "sell", 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteCall<TransactionReceipt> sellByAgent(BigInteger _agentid, BigInteger weiValue) {
        final Function function = new Function(
                "sellByAgent", 
                Arrays.<Type>asList(new Uint256(_agentid)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteCall<TransactionReceipt> setGoodsValue(BigInteger _val) {
        final Function function = new Function(
                "setGoodsValue", 
                Arrays.<Type>asList(new Uint256(_val)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> getGoodsValue() {
        final Function function = new Function("getGoodsValue", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> getCommissionRatio() {
        final Function function = new Function("getCommissionRatio", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> getShineRatio() {
        final Function function = new Function("getShineRatio", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> getCurShineValue(BigInteger _agentid) {
        final Function function = new Function("getCurShineValue", 
                Arrays.<Type>asList(new Uint256(_agentid)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<Tuple6<String, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger>> getGoodsInfo() {
        final Function function = new Function("getGoodsInfo", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple6<String, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger>>(
                new Callable<Tuple6<String, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger>>() {
                    @Override
                    public Tuple6<String, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple6<String, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger>(
                                (String) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue(), 
                                (BigInteger) results.get(4).getValue(), 
                                (BigInteger) results.get(5).getValue());
                    }
                });
    }

    public static CopyRight load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new CopyRight(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static CopyRight load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new CopyRight(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static class TransferEventResponse {
        public Log log;

        public String _from;

        public String _to;

        public BigInteger _tokenId;
    }

    public static class ApprovalEventResponse {
        public Log log;

        public String _owner;

        public String _approved;

        public BigInteger _tokenId;
    }
}
