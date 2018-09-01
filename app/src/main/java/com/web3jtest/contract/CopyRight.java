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
    private static final String BINARY = "0x6080604052600060015534801561001557600080fd5b50604051606080611d4d833981018060405281019080805190602001909291908051906020019092919080519060200190929190505050336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055508260078190555081600660006101000a81548160ff021916908360ff16021790555080600881905550505050611c86806100c76000396000f300608060405260043610610196576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff168063095ea7b31461019b5780630a4acb14146101e857806319a6a6e91461023f5780631cf1c2bc146102c1578063200198e61461030657806344f6d9b314610347578063457100741461037457806350f820e61461037e57806356e36b93146103a95780636352211e146103d6578063664d2095146104435780636d6fdd9b1461047057806370a082311461049b5780637237ad2a146104f257806374c59e961461053757806380d65b3f146105c05780638da5cb5b1461062d5780638eb85168146106845780638f2357ba146106af5780639a644bab1461071c578063a9059cbb1461073c578063b1847c2e14610789578063b2e6ceeb146107ce578063b956c0b1146107fb578063bca40bfa14610832578063bf7bcfd014610877578063cb06cbdd146108b8578063d3f5ca9e146108f9578063d846dd0f14610924578063e90d6e551461094f578063eec5136914610990578063fdbe6667146109d1575b600080fd5b3480156101a757600080fd5b506101e6600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803590602001909291905050506109fc565b005b3480156101f457600080fd5b50610229600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610acb565b6040518082815260200191505060405180910390f35b34801561024b57600080fd5b5061026a60048036038101908080359060200190929190505050610ae3565b604051808573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200184815260200183815260200182815260200194505050505060405180910390f35b3480156102cd57600080fd5b506102ec60048036038101908080359060200190929190505050610bcf565b604051808215151515815260200191505060405180910390f35b34801561031257600080fd5b5061033160048036038101908080359060200190929190505050610bec565b6040518082815260200191505060405180910390f35b34801561035357600080fd5b5061037260048036038101908080359060200190929190505050610c3f565b005b61037c610ca4565b005b34801561038a57600080fd5b50610393610e08565b6040518082815260200191505060405180910390f35b3480156103b557600080fd5b506103d460048036038101908080359060200190929190505050610e15565b005b3480156103e257600080fd5b5061040160048036038101908080359060200190929190505050610fc7565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34801561044f57600080fd5b5061046e60048036038101908080359060200190929190505050611004565b005b34801561047c57600080fd5b5061048561112a565b6040518082815260200191505060405180910390f35b3480156104a757600080fd5b506104dc600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050611134565b6040518082815260200191505060405180910390f35b3480156104fe57600080fd5b5061051d6004803603810190808035906020019092919050505061117d565b604051808215151515815260200191505060405180910390f35b34801561054357600080fd5b5061056260048036038101908080359060200190929190505050611201565b604051808681526020018573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018481526020018381526020018281526020019550505050505060405180910390f35b3480156105cc57600080fd5b506105eb60048036038101908080359060200190929190505050611392565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34801561063957600080fd5b506106426113c5565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34801561069057600080fd5b506106996113ea565b6040518082815260200191505060405180910390f35b3480156106bb57600080fd5b506106da600480360381019080803590602001909291905050506113f4565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b61073a6004803603810190808035906020019092919050505061143e565b005b34801561074857600080fd5b50610787600480360381019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291908035906020019092919050505061163a565b005b34801561079557600080fd5b506107b46004803603810190808035906020019092919050505061165d565b604051808215151515815260200191505060405180910390f35b3480156107da57600080fd5b506107f960048036038101908080359060200190929190505050611694565b005b34801561080757600080fd5b50610830600480360381019080803590602001909291908035906020019092919050505061171d565b005b34801561083e57600080fd5b5061085d6004803603810190808035906020019092919050505061174f565b604051808215151515815260200191505060405180910390f35b34801561088357600080fd5b506108a26004803603810190808035906020019092919050505061179f565b6040518082815260200191505060405180910390f35b3480156108c457600080fd5b506108e3600480360381019080803590602001909291905050506117c9565b6040518082815260200191505060405180910390f35b34801561090557600080fd5b5061090e6117f3565b6040518082815260200191505060405180910390f35b34801561093057600080fd5b5061093961180d565b6040518082815260200191505060405180910390f35b34801561095b57600080fd5b5061097a60048036038101908080359060200190929190505050611854565b6040518082815260200191505060405180910390f35b34801561099c57600080fd5b506109bb6004803603810190808035906020019092919050505061187e565b6040518082815260200191505060405180910390f35b3480156109dd57600080fd5b506109e66119e9565b6040518082815260200191505060405180910390f35b610a058161117d565b1515610a1057600080fd5b816005600083815260200190815260200160002060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055508173ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff167f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b925836040518082815260200191505060405180910390a35050565b60046020528060005260406000206000915090505481565b600080600080610af1611c12565b600286815481101515610b0057fe5b906000526020600020906005020160a060405190810160405290816000820160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200160018201548152602001600282015481526020016003820160009054906101000a900460ff16151515158152602001600482015481525050905080600001518160200151826040015183608001519450945094509450509193509193565b6000808210158015610be5575060028054905082105b9050919050565b6000806064600660009054906101000a900460ff1660ff16811515610c0d57fe5b0460ff16600754029050610c1f61112a565b610c288461179f565b8202811515610c3357fe5b04905080915050919050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610c9a57600080fd5b8060078190555050565b6000806000806007543410151515610cbb57600080fd5b60009350610cc761112a565b9250600083141515610d98576064600660009054906101000a900460ff1660ff163402811515610cf357fe5b049350600091505b610d03610e08565b821015610d9757610d138261165d565b15610d8a5782610d228361179f565b8502811515610d2d57fe5b049050610d39826113f4565b73ffffffffffffffffffffffffffffffffffffffff166108fc829081150290604051600060405180830381858888f19350505050158015610d7e573d6000803e3d6000fd5b50610d89828261171d565b5b8180600101925050610cfb565b5b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166108fc8534039081150290604051600060405180830381858888f19350505050158015610e01573d6000803e3d6000fd5b5050505050565b6000600280549050905090565b60006001600260a0604051908101604052803373ffffffffffffffffffffffffffffffffffffffff16815260200185815260200142815260200160011515815260200160008152509080600181540180825580915050906001820390600052602060002090600502016000909192909190915060008201518160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550602082015181600101556040820151816002015560608201518160030160006101000a81548160ff021916908315150217905550608082015181600401555050039050336003600083815260200190815260200160002060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550600460003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008154809291906001019190505550816001600082825401925050819055505050565b60006003600083815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff169050919050565b600061100f82610bcf565b8015611020575061101f8261174f565b5b801561103157506110308261117d565b5b151561103c57600080fd5b60028281548110151561104b57fe5b906000526020600020906005020190508060030160009054906101000a900460ff16801561107e57506000816001015414155b151561108957600080fd5b806001015460016000828254039250508190555060006002838154811015156110ae57fe5b906000526020600020906005020160030160006101000a81548160ff021916908315150217905550600460003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008154809291906001900391905055505050565b6000600154905090565b6000600460008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020549050919050565b600061118882610bcf565b151561119757600090506111fc565b6003600083815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161490505b919050565b6000806000806000611211611c12565b600080600061121e61180d565b8a10151561122b57600080fd5b60009250600090505b6002805490508110156113665760028181548110151561125057fe5b906000526020600020906005020160a060405190810160405290816000820160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200160018201548152602001600282015481526020016003820160009054906101000a900460ff1615151515815260200160048201548152505093503373ffffffffffffffffffffffffffffffffffffffff16846000015173ffffffffffffffffffffffffffffffffffffffff1614801561133b575083606001515b1561135957809150828a141561135057611366565b82806001019350505b8080600101915050611234565b818460000151856020015186604001518760800151985098509850985098505050505091939590929450565b60036020528060005260406000206000915054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b6000600754905090565b600060028281548110151561140557fe5b906000526020600020906005020160000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff169050919050565b6000806000806000600754341015151561145757600080fd5b6000945061146486610bcf565b801561147557506114748661174f565b5b156114e7576064600854340281151561148a57fe5b049450611496866113f4565b73ffffffffffffffffffffffffffffffffffffffff166108fc869081150290604051600060405180830381858888f193505050501580156114db573d6000803e3d6000fd5b506114e6868661171d565b5b6114ef61112a565b9350600092506000841415156115c6576064600660009054906101000a900460ff1660ff168634030281151561152157fe5b049250600091505b611531610e08565b8210156115c5576115418261165d565b156115b857836115508361179f565b840281151561155b57fe5b049050611567826113f4565b73ffffffffffffffffffffffffffffffffffffffff166108fc829081150290604051600060405180830381858888f193505050501580156115ac573d6000803e3d6000fd5b506115b7828261171d565b5b8180600101925050611529565b5b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166108fc84873403039081150290604051600060405180830381858888f19350505050158015611631573d6000803e3d6000fd5b50505050505050565b6116438161117d565b151561164e57600080fd5b6116593383836119f3565b5050565b600060028281548110151561166e57fe5b906000526020600020906005020160030160009054906101000a900460ff169050919050565b60003373ffffffffffffffffffffffffffffffffffffffff166005600084815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614151561170357600080fd5b61170c82610fc7565b90506117198133846119f3565b5050565b8060028381548110151561172d57fe5b9060005260206000209060050201600401600082825401925050819055505050565b600061175a82610bcf565b1515611769576000905061179a565b60028281548110151561177857fe5b906000526020600020906005020160030160009054906101000a900460ff1690505b919050565b60006002828154811015156117b057fe5b9060005260206000209060050201600101549050919050565b60006002828154811015156117da57fe5b9060005260206000209060050201600201549050919050565b6000600660009054906101000a900460ff1660ff16905090565b6000600460003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002054905090565b600060028281548110151561186557fe5b9060005260206000209060050201600401549050919050565b6000611888611c12565b600080600061189561180d565b861015156118a257600080fd5b60009250600090505b6002805490508110156119dd576002818154811015156118c757fe5b906000526020600020906005020160a060405190810160405290816000820160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200160018201548152602001600282015481526020016003820160009054906101000a900460ff1615151515815260200160048201548152505093503373ffffffffffffffffffffffffffffffffffffffff16846000015173ffffffffffffffffffffffffffffffffffffffff161480156119b2575083606001515b156119d057809150828614156119c7576119dd565b82806001019350505b80806001019150506118ab565b81945050505050919050565b6000600854905090565b611a466001600460008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002054611bdb90919063ffffffff16565b600460008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002081905550611adc6001600460003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002054611bf990919063ffffffff16565b600460003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002081905550816003600083815260200190815260200160002060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055508173ffffffffffffffffffffffffffffffffffffffff168373ffffffffffffffffffffffffffffffffffffffff167fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef836040518082815260200191505060405180910390a3505050565b6000808284019050838110151515611bef57fe5b8091505092915050565b6000828211151515611c0757fe5b818303905092915050565b60a060405190810160405280600073ffffffffffffffffffffffffffffffffffffffff16815260200160008152602001600081526020016000151581526020016000815250905600a165627a7a723058200554834da0bbf3c3cc29d40fb42ea841e08494ff7493ac70972d051e852b46710029";

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

    public static RemoteCall<CopyRight> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger _value, BigInteger _ratio, BigInteger _commission) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Uint256(_value),
                new org.web3j.abi.datatypes.generated.Uint8(_ratio), 
                new Uint256(_commission)));
        return deployRemoteCall(CopyRight.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static RemoteCall<CopyRight> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger _value, BigInteger _ratio, BigInteger _commission) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Uint256(_value),
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
