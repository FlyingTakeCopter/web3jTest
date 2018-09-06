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
import org.web3j.tuples.generated.Tuple9;
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
    private static final String BINARY = "0x608060405260006001553480156200001657600080fd5b5060405162002050380380620020508339810180604052810190808051820192919060200180519060200190929190805190602001909291908051906020019092919080519060200190929190505050336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055508460099080519060200190620000be9291906200010a565b508360078190555082600660006101000a81548160ff021916908360ff160217905550816008819055506000600a819055506000600b8190555080600c819055505050505050620001b9565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106200014d57805160ff19168380011785556200017e565b828001600101855582156200017e579182015b828111156200017d57825182559160200191906001019062000160565b5b5090506200018d919062000191565b5090565b620001b691905b80821115620001b257600081600090555060010162000198565b5090565b90565b611e8780620001c96000396000f3006080604052600436106101a1576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff168063095ea7b3146101a65780630a4acb14146101f357806319a6a6e91461024a5780631cf1c2bc146102cc578063200198e61461031157806344f6d9b314610352578063457100741461037f57806350f820e61461038957806356e36b93146103b45780636352211e146103e1578063664d20951461044e5780636d6fdd9b1461047b57806370a08231146104a65780637237ad2a146104fd57806374c59e961461054257806380d65b3f146105cb5780638da5cb5b146106385780638eb851681461068f5780638f2357ba146106ba5780639a644bab14610727578063a9059cbb14610747578063b1847c2e14610794578063b2e6ceeb146107d9578063b5e16cc114610806578063b956c0b1146108ce578063bca40bfa14610905578063bf7bcfd01461094a578063cb06cbdd1461098b578063d3f5ca9e146109cc578063d846dd0f146109f7578063e90d6e5514610a22578063eec5136914610a63578063fdbe666714610aa4575b600080fd5b3480156101b257600080fd5b506101f1600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190505050610acf565b005b3480156101ff57600080fd5b50610234600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610b9e565b6040518082815260200191505060405180910390f35b34801561025657600080fd5b5061027560048036038101908080359060200190929190505050610bb6565b604051808573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200184815260200183815260200182815260200194505050505060405180910390f35b3480156102d857600080fd5b506102f760048036038101908080359060200190929190505050610ca2565b604051808215151515815260200191505060405180910390f35b34801561031d57600080fd5b5061033c60048036038101908080359060200190929190505050610cbf565b6040518082815260200191505060405180910390f35b34801561035e57600080fd5b5061037d60048036038101908080359060200190929190505050610d12565b005b610387610d77565b005b34801561039557600080fd5b5061039e610eeb565b6040518082815260200191505060405180910390f35b3480156103c057600080fd5b506103df60048036038101908080359060200190929190505050610ef8565b005b3480156103ed57600080fd5b5061040c600480360381019080803590602001909291905050506110aa565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34801561045a57600080fd5b50610479600480360381019080803590602001909291905050506110e7565b005b34801561048757600080fd5b5061049061120d565b6040518082815260200191505060405180910390f35b3480156104b257600080fd5b506104e7600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050611217565b6040518082815260200191505060405180910390f35b34801561050957600080fd5b5061052860048036038101908080359060200190929190505050611260565b604051808215151515815260200191505060405180910390f35b34801561054e57600080fd5b5061056d600480360381019080803590602001909291905050506112e4565b604051808681526020018573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018481526020018381526020018281526020019550505050505060405180910390f35b3480156105d757600080fd5b506105f660048036038101908080359060200190929190505050611475565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34801561064457600080fd5b5061064d6114a8565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34801561069b57600080fd5b506106a46114cd565b6040518082815260200191505060405180910390f35b3480156106c657600080fd5b506106e5600480360381019080803590602001909291905050506114d7565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b61074560048036038101908080359060200190929190505050611521565b005b34801561075357600080fd5b50610792600480360381019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291908035906020019092919050505061173d565b005b3480156107a057600080fd5b506107bf60048036038101908080359060200190929190505050611760565b604051808215151515815260200191505060405180910390f35b3480156107e557600080fd5b5061080460048036038101908080359060200190929190505050611797565b005b34801561081257600080fd5b5061081b611820565b60405180806020018a815260200189815260200188815260200187815260200186815260200185815260200184815260200183815260200182810382528b818151815260200191508051906020019080838360005b8381101561088b578082015181840152602081019050610870565b50505050905090810190601f1680156108b85780820380516001836020036101000a031916815260200191505b509a505050505050505050505060405180910390f35b3480156108da57600080fd5b50610903600480360381019080803590602001909291908035906020019092919050505061191e565b005b34801561091157600080fd5b5061093060048036038101908080359060200190929190505050611950565b604051808215151515815260200191505060405180910390f35b34801561095657600080fd5b50610975600480360381019080803590602001909291905050506119a0565b6040518082815260200191505060405180910390f35b34801561099757600080fd5b506109b6600480360381019080803590602001909291905050506119ca565b6040518082815260200191505060405180910390f35b3480156109d857600080fd5b506109e16119f4565b6040518082815260200191505060405180910390f35b348015610a0357600080fd5b50610a0c611a0e565b6040518082815260200191505060405180910390f35b348015610a2e57600080fd5b50610a4d60048036038101908080359060200190929190505050611a55565b6040518082815260200191505060405180910390f35b348015610a6f57600080fd5b50610a8e60048036038101908080359060200190929190505050611a7f565b6040518082815260200191505060405180910390f35b348015610ab057600080fd5b50610ab9611bea565b6040518082815260200191505060405180910390f35b610ad881611260565b1515610ae357600080fd5b816005600083815260200190815260200160002060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055508173ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff167f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b925836040518082815260200191505060405180910390a35050565b60046020528060005260406000206000915090505481565b600080600080610bc4611e13565b600286815481101515610bd357fe5b906000526020600020906005020160a060405190810160405290816000820160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200160018201548152602001600282015481526020016003820160009054906101000a900460ff16151515158152602001600482015481525050905080600001518160200151826040015183608001519450945094509450509193509193565b6000808210158015610cb8575060028054905082105b9050919050565b6000806064600660009054906101000a900460ff1660ff16811515610ce057fe5b0460ff16600754029050610cf261120d565b610cfb846119a0565b8202811515610d0657fe5b04905080915050919050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610d6d57600080fd5b8060078190555050565b6000806000806007543410151515610d8e57600080fd5b60009350610d9a61120d565b9250600083141515610e7b576064600660009054906101000a900460ff1660ff163402811515610dc657fe5b04935083600a60008282540192505081905550600091505b610de6610eeb565b821015610e7a57610df682611760565b15610e6d5782610e05836119a0565b8502811515610e1057fe5b049050610e1c826114d7565b73ffffffffffffffffffffffffffffffffffffffff166108fc829081150290604051600060405180830381858888f19350505050158015610e61573d6000803e3d6000fd5b50610e6c828261191e565b5b8180600101925050610dde565b5b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166108fc8534039081150290604051600060405180830381858888f19350505050158015610ee4573d6000803e3d6000fd5b5050505050565b6000600280549050905090565b60006001600260a0604051908101604052803373ffffffffffffffffffffffffffffffffffffffff16815260200185815260200142815260200160011515815260200160008152509080600181540180825580915050906001820390600052602060002090600502016000909192909190915060008201518160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550602082015181600101556040820151816002015560608201518160030160006101000a81548160ff021916908315150217905550608082015181600401555050039050336003600083815260200190815260200160002060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550600460003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008154809291906001019190505550816001600082825401925050819055505050565b60006003600083815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff169050919050565b60006110f282610ca2565b8015611103575061110282611950565b5b8015611114575061111382611260565b5b151561111f57600080fd5b60028281548110151561112e57fe5b906000526020600020906005020190508060030160009054906101000a900460ff16801561116157506000816001015414155b151561116c57600080fd5b8060010154600160008282540392505081905550600060028381548110151561119157fe5b906000526020600020906005020160030160006101000a81548160ff021916908315150217905550600460003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008154809291906001900391905055505050565b6000600154905090565b6000600460008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020549050919050565b600061126b82610ca2565b151561127a57600090506112df565b6003600083815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161490505b919050565b60008060008060006112f4611e13565b6000806000611301611a0e565b8a10151561130e57600080fd5b60009250600090505b6002805490508110156114495760028181548110151561133357fe5b906000526020600020906005020160a060405190810160405290816000820160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200160018201548152602001600282015481526020016003820160009054906101000a900460ff1615151515815260200160048201548152505093503373ffffffffffffffffffffffffffffffffffffffff16846000015173ffffffffffffffffffffffffffffffffffffffff1614801561141e575083606001515b1561143c57809150828a141561143357611449565b82806001019350505b8080600101915050611317565b818460000151856020015186604001518760800151985098509850985098505050505091939590929450565b60036020528060005260406000206000915054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b6000600754905090565b60006002828154811015156114e857fe5b906000526020600020906005020160000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff169050919050565b6000806000806000600754341015151561153a57600080fd5b6000945061154786610ca2565b8015611558575061155786611950565b5b156115da576064600854340281151561156d57fe5b04945084600b60008282540192505081905550611589866114d7565b73ffffffffffffffffffffffffffffffffffffffff166108fc869081150290604051600060405180830381858888f193505050501580156115ce573d6000803e3d6000fd5b506115d9868661191e565b5b6115e261120d565b9350600092506000841415156116c9576064600660009054906101000a900460ff1660ff168634030281151561161457fe5b04925082600a60008282540192505081905550600091505b611634610eeb565b8210156116c85761164482611760565b156116bb5783611653836119a0565b840281151561165e57fe5b04905061166a826114d7565b73ffffffffffffffffffffffffffffffffffffffff166108fc829081150290604051600060405180830381858888f193505050501580156116af573d6000803e3d6000fd5b506116ba828261191e565b5b818060010192505061162c565b5b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166108fc84873403039081150290604051600060405180830381858888f19350505050158015611734573d6000803e3d6000fd5b50505050505050565b61174681611260565b151561175157600080fd5b61175c338383611bf4565b5050565b600060028281548110151561177157fe5b906000526020600020906005020160030160009054906101000a900460ff169050919050565b60003373ffffffffffffffffffffffffffffffffffffffff166005600084815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1614151561180657600080fd5b61180f826110aa565b905061181c813384611bf4565b5050565b60606000806000806000806000806009600754600660009054906101000a900460ff1660085461184e61120d565b611856610eeb565b600a54600b54600c54888054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156118f45780601f106118c9576101008083540402835291602001916118f4565b820191906000526020600020905b8154815290600101906020018083116118d757829003601f168201915b505050505098508660ff169650985098509850985098509850985098509850909192939495969798565b8060028381548110151561192e57fe5b9060005260206000209060050201600401600082825401925050819055505050565b600061195b82610ca2565b151561196a576000905061199b565b60028281548110151561197957fe5b906000526020600020906005020160030160009054906101000a900460ff1690505b919050565b60006002828154811015156119b157fe5b9060005260206000209060050201600101549050919050565b60006002828154811015156119db57fe5b9060005260206000209060050201600201549050919050565b6000600660009054906101000a900460ff1660ff16905090565b6000600460003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002054905090565b6000600282815481101515611a6657fe5b9060005260206000209060050201600401549050919050565b6000611a89611e13565b6000806000611a96611a0e565b86101515611aa357600080fd5b60009250600090505b600280549050811015611bde57600281815481101515611ac857fe5b906000526020600020906005020160a060405190810160405290816000820160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200160018201548152602001600282015481526020016003820160009054906101000a900460ff1615151515815260200160048201548152505093503373ffffffffffffffffffffffffffffffffffffffff16846000015173ffffffffffffffffffffffffffffffffffffffff16148015611bb3575083606001515b15611bd15780915082861415611bc857611bde565b82806001019350505b8080600101915050611aac565b81945050505050919050565b6000600854905090565b611c476001600460008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002054611ddc90919063ffffffff16565b600460008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002081905550611cdd6001600460003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002054611dfa90919063ffffffff16565b600460003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002081905550816003600083815260200190815260200160002060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055508173ffffffffffffffffffffffffffffffffffffffff168373ffffffffffffffffffffffffffffffffffffffff167fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef836040518082815260200191505060405180910390a3505050565b6000808284019050838110151515611df057fe5b8091505092915050565b6000828211151515611e0857fe5b818303905092915050565b60a060405190810160405280600073ffffffffffffffffffffffffffffffffffffffff16815260200160008152602001600081526020016000151581526020016000815250905600a165627a7a72305820985ced317fb37abc0e5362bbd705fa76c153291bf2c80a6f0c5fad22140ea0350029";

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

    public static RemoteCall<CopyRight> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _name, BigInteger _value, BigInteger _ratio, BigInteger _commission, BigInteger _singleval) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Utf8String(_name),
                new Uint256(_value),
                new org.web3j.abi.datatypes.generated.Uint8(_ratio), 
                new Uint256(_commission),
                new Uint256(_singleval)));
        return deployRemoteCall(CopyRight.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static RemoteCall<CopyRight> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _name, BigInteger _value, BigInteger _ratio, BigInteger _commission, BigInteger _singleval) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Utf8String(_name),
                new Uint256(_value),
                new org.web3j.abi.datatypes.generated.Uint8(_ratio), 
                new Uint256(_commission),
                new Uint256(_singleval)));
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

    public RemoteCall<Tuple9<String, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger>> getGoodsInfo() {
        final Function function = new Function("getGoodsInfo", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple9<String, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger>>(
                new Callable<Tuple9<String, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger>>() {
                    @Override
                    public Tuple9<String, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple9<String, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger>(
                                (String) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue(), 
                                (BigInteger) results.get(4).getValue(), 
                                (BigInteger) results.get(5).getValue(), 
                                (BigInteger) results.get(6).getValue(), 
                                (BigInteger) results.get(7).getValue(), 
                                (BigInteger) results.get(8).getValue());
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
