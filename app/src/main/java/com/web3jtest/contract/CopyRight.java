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
import org.web3j.tuples.generated.Tuple7;
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
    private static final String BINARY = "0x608060405260006001553480156200001657600080fd5b5060405162002223380380620022238339810180604052810190808051820192919060200180519060200190929190805190602001909291908051906020019092919080519060200190929190505050336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055508460099080519060200190620000be9291906200010a565b508360078190555082600660006101000a81548160ff021916908360ff160217905550816008819055506000600a819055506000600b8190555080600c819055505050505050620001b9565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106200014d57805160ff19168380011785556200017e565b828001600101855582156200017e579182015b828111156200017d57825182559160200191906001019062000160565b5b5090506200018d919062000191565b5090565b620001b691905b80821115620001b257600081600090555060010162000198565b5090565b90565b61205a80620001c96000396000f3006080604052600436106101ac576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff168063095ea7b3146101b15780630a4acb14146101fe57806319a6a6e9146102555780631cf1c2bc146102d7578063200198e61461031c57806344f6d9b31461035d578063457100741461038a57806350f820e61461039457806356e36b93146103bf5780636352211e146103ec578063664d2095146104595780636d6fdd9b1461048657806370a08231146104b15780637237ad2a1461050857806374c59e961461054d57806380d65b3f146105d65780638da5cb5b146106435780638eb851681461069a5780638f2357ba146106c55780639a644bab14610732578063a9059cbb14610752578063ab1684411461079f578063b1847c2e1461086f578063b2e6ceeb146108b4578063b5e16cc1146108e1578063b956c0b1146109a9578063bca40bfa146109e0578063bf7bcfd014610a25578063cb06cbdd14610a66578063d3f5ca9e14610aa7578063d846dd0f14610ad2578063e90d6e5514610afd578063eec5136914610b3e578063fdbe666714610b7f575b600080fd5b3480156101bd57600080fd5b506101fc600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190505050610baa565b005b34801561020a57600080fd5b5061023f600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610c79565b6040518082815260200191505060405180910390f35b34801561026157600080fd5b5061028060048036038101908080359060200190929190505050610c91565b604051808573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200184815260200183815260200182815260200194505050505060405180910390f35b3480156102e357600080fd5b5061030260048036038101908080359060200190929190505050610d7d565b604051808215151515815260200191505060405180910390f35b34801561032857600080fd5b5061034760048036038101908080359060200190929190505050610d9a565b6040518082815260200191505060405180910390f35b34801561036957600080fd5b5061038860048036038101908080359060200190929190505050610ded565b005b610392610e52565b005b3480156103a057600080fd5b506103a9610fc6565b6040518082815260200191505060405180910390f35b3480156103cb57600080fd5b506103ea60048036038101908080359060200190929190505050610fd3565b005b3480156103f857600080fd5b5061041760048036038101908080359060200190929190505050611185565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34801561046557600080fd5b50610484600480360381019080803590602001909291905050506111c2565b005b34801561049257600080fd5b5061049b6112e8565b6040518082815260200191505060405180910390f35b3480156104bd57600080fd5b506104f2600480360381019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506112f2565b6040518082815260200191505060405180910390f35b34801561051457600080fd5b506105336004803603810190808035906020019092919050505061133b565b604051808215151515815260200191505060405180910390f35b34801561055957600080fd5b50610578600480360381019080803590602001909291905050506113bf565b604051808681526020018573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018481526020018381526020018281526020019550505050505060405180910390f35b3480156105e257600080fd5b5061060160048036038101908080359060200190929190505050611550565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34801561064f57600080fd5b50610658611583565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b3480156106a657600080fd5b506106af6115a8565b6040518082815260200191505060405180910390f35b3480156106d157600080fd5b506106f0600480360381019080803590602001909291905050506115b2565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b610750600480360381019080803590602001909291905050506115fc565b005b34801561075e57600080fd5b5061079d600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190505050611818565b005b3480156107ab57600080fd5b506107ca6004803603810190808035906020019092919050505061183b565b6040518080602001888152602001878152602001868152602001858152602001848152602001838152602001828103825289818151815260200191508051906020019080838360005b8381101561082e578082015181840152602081019050610813565b50505050905090810190601f16801561085b5780820380516001836020036101000a031916815260200191505b509850505050505050505060405180910390f35b34801561087b57600080fd5b5061089a60048036038101908080359060200190929190505050611933565b604051808215151515815260200191505060405180910390f35b3480156108c057600080fd5b506108df6004803603810190808035906020019092919050505061196a565b005b3480156108ed57600080fd5b506108f66119f3565b60405180806020018a815260200189815260200188815260200187815260200186815260200185815260200184815260200183815260200182810382528b818151815260200191508051906020019080838360005b8381101561096657808201518184015260208101905061094b565b50505050905090810190601f1680156109935780820380516001836020036101000a031916815260200191505b509a505050505050505050505060405180910390f35b3480156109b557600080fd5b506109de6004803603810190808035906020019092919080359060200190929190505050611af1565b005b3480156109ec57600080fd5b50610a0b60048036038101908080359060200190929190505050611b23565b604051808215151515815260200191505060405180910390f35b348015610a3157600080fd5b50610a5060048036038101908080359060200190929190505050611b73565b6040518082815260200191505060405180910390f35b348015610a7257600080fd5b50610a9160048036038101908080359060200190929190505050611b9d565b6040518082815260200191505060405180910390f35b348015610ab357600080fd5b50610abc611bc7565b6040518082815260200191505060405180910390f35b348015610ade57600080fd5b50610ae7611be1565b6040518082815260200191505060405180910390f35b348015610b0957600080fd5b50610b2860048036038101908080359060200190929190505050611c28565b6040518082815260200191505060405180910390f35b348015610b4a57600080fd5b50610b6960048036038101908080359060200190929190505050611c52565b6040518082815260200191505060405180910390f35b348015610b8b57600080fd5b50610b94611dbd565b6040518082815260200191505060405180910390f35b610bb38161133b565b1515610bbe57600080fd5b816005600083815260200190815260200160002060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055508173ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff167f8c5be1e5ebec7d5bd14f71427d1e84f3dd0314c0f7b2291e5b200ac8c7c3b925836040518082815260200191505060405180910390a35050565b60046020528060005260406000206000915090505481565b600080600080610c9f611fe6565b600286815481101515610cae57fe5b906000526020600020906005020160a060405190810160405290816000820160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200160018201548152602001600282015481526020016003820160009054906101000a900460ff16151515158152602001600482015481525050905080600001518160200151826040015183608001519450945094509450509193509193565b6000808210158015610d93575060028054905082105b9050919050565b6000806064600660009054906101000a900460ff1660ff16811515610dbb57fe5b0460ff16600754029050610dcd6112e8565b610dd684611b73565b8202811515610de157fe5b04905080915050919050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610e4857600080fd5b8060078190555050565b6000806000806007543410151515610e6957600080fd5b60009350610e756112e8565b9250600083141515610f56576064600660009054906101000a900460ff1660ff163402811515610ea157fe5b04935083600a60008282540192505081905550600091505b610ec1610fc6565b821015610f5557610ed182611933565b15610f485782610ee083611b73565b8502811515610eeb57fe5b049050610ef7826115b2565b73ffffffffffffffffffffffffffffffffffffffff166108fc829081150290604051600060405180830381858888f19350505050158015610f3c573d6000803e3d6000fd5b50610f478282611af1565b5b8180600101925050610eb9565b5b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166108fc8534039081150290604051600060405180830381858888f19350505050158015610fbf573d6000803e3d6000fd5b5050505050565b6000600280549050905090565b60006001600260a0604051908101604052803373ffffffffffffffffffffffffffffffffffffffff16815260200185815260200142815260200160011515815260200160008152509080600181540180825580915050906001820390600052602060002090600502016000909192909190915060008201518160000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550602082015181600101556040820151816002015560608201518160030160006101000a81548160ff021916908315150217905550608082015181600401555050039050336003600083815260200190815260200160002060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550600460003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008154809291906001019190505550816001600082825401925050819055505050565b60006003600083815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff169050919050565b60006111cd82610d7d565b80156111de57506111dd82611b23565b5b80156111ef57506111ee8261133b565b5b15156111fa57600080fd5b60028281548110151561120957fe5b906000526020600020906005020190508060030160009054906101000a900460ff16801561123c57506000816001015414155b151561124757600080fd5b8060010154600160008282540392505081905550600060028381548110151561126c57fe5b906000526020600020906005020160030160006101000a81548160ff021916908315150217905550600460003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008154809291906001900391905055505050565b6000600154905090565b6000600460008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020549050919050565b600061134682610d7d565b151561135557600090506113ba565b6003600083815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161490505b919050565b60008060008060006113cf611fe6565b60008060006113dc611be1565b8a1015156113e957600080fd5b60009250600090505b6002805490508110156115245760028181548110151561140e57fe5b906000526020600020906005020160a060405190810160405290816000820160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200160018201548152602001600282015481526020016003820160009054906101000a900460ff1615151515815260200160048201548152505093503373ffffffffffffffffffffffffffffffffffffffff16846000015173ffffffffffffffffffffffffffffffffffffffff161480156114f9575083606001515b1561151757809150828a141561150e57611524565b82806001019350505b80806001019150506113f2565b818460000151856020015186604001518760800151985098509850985098505050505091939590929450565b60036020528060005260406000206000915054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b6000600754905090565b60006002828154811015156115c357fe5b906000526020600020906005020160000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff169050919050565b6000806000806000600754341015151561161557600080fd5b6000945061162286610d7d565b8015611633575061163286611b23565b5b156116b5576064600854340281151561164857fe5b04945084600b60008282540192505081905550611664866115b2565b73ffffffffffffffffffffffffffffffffffffffff166108fc869081150290604051600060405180830381858888f193505050501580156116a9573d6000803e3d6000fd5b506116b48686611af1565b5b6116bd6112e8565b9350600092506000841415156117a4576064600660009054906101000a900460ff1660ff16863403028115156116ef57fe5b04925082600a60008282540192505081905550600091505b61170f610fc6565b8210156117a35761171f82611933565b15611796578361172e83611b73565b840281151561173957fe5b049050611745826115b2565b73ffffffffffffffffffffffffffffffffffffffff166108fc829081150290604051600060405180830381858888f1935050505015801561178a573d6000803e3d6000fd5b506117958282611af1565b5b8180600101925050611707565b5b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166108fc84873403039081150290604051600060405180830381858888f1935050505015801561180f573d6000803e3d6000fd5b50505050505050565b6118218161133b565b151561182c57600080fd5b611837338383611dc7565b5050565b60606000806000806000806009600754600660009054906101000a900460ff166008546118666112e8565b61186f8d611b73565b6118788e611c28565b868054600181600116156101000203166002900480601f01602080910402602001604051908101604052809291908181526020018280546001816001161561010002031660029004801561190d5780601f106118e25761010080835404028352916020019161190d565b820191906000526020600020905b8154815290600101906020018083116118f057829003601f168201915b505050505096508460ff1694509650965096509650965096509650919395979092949650565b600060028281548110151561194457fe5b906000526020600020906005020160030160009054906101000a900460ff169050919050565b60003373ffffffffffffffffffffffffffffffffffffffff166005600084815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161415156119d957600080fd5b6119e282611185565b90506119ef813384611dc7565b5050565b60606000806000806000806000806009600754600660009054906101000a900460ff16600854611a216112e8565b611a29610fc6565b600a54600b54600c54888054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015611ac75780601f10611a9c57610100808354040283529160200191611ac7565b820191906000526020600020905b815481529060010190602001808311611aaa57829003601f168201915b505050505098508660ff169650985098509850985098509850985098509850909192939495969798565b80600283815481101515611b0157fe5b9060005260206000209060050201600401600082825401925050819055505050565b6000611b2e82610d7d565b1515611b3d5760009050611b6e565b600282815481101515611b4c57fe5b906000526020600020906005020160030160009054906101000a900460ff1690505b919050565b6000600282815481101515611b8457fe5b9060005260206000209060050201600101549050919050565b6000600282815481101515611bae57fe5b9060005260206000209060050201600201549050919050565b6000600660009054906101000a900460ff1660ff16905090565b6000600460003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002054905090565b6000600282815481101515611c3957fe5b9060005260206000209060050201600401549050919050565b6000611c5c611fe6565b6000806000611c69611be1565b86101515611c7657600080fd5b60009250600090505b600280549050811015611db157600281815481101515611c9b57fe5b906000526020600020906005020160a060405190810160405290816000820160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200160018201548152602001600282015481526020016003820160009054906101000a900460ff1615151515815260200160048201548152505093503373ffffffffffffffffffffffffffffffffffffffff16846000015173ffffffffffffffffffffffffffffffffffffffff16148015611d86575083606001515b15611da45780915082861415611d9b57611db1565b82806001019350505b8080600101915050611c7f565b81945050505050919050565b6000600854905090565b611e1a6001600460008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002054611faf90919063ffffffff16565b600460008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002081905550611eb06001600460003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002054611fcd90919063ffffffff16565b600460003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002081905550816003600083815260200190815260200160002060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055508173ffffffffffffffffffffffffffffffffffffffff168373ffffffffffffffffffffffffffffffffffffffff167fddf252ad1be2c89b69c2b068fc378daa952ba7f163c4a11628f55a4df523b3ef836040518082815260200191505060405180910390a3505050565b6000808284019050838110151515611fc357fe5b8091505092915050565b6000828211151515611fdb57fe5b818303905092915050565b60a060405190810160405280600073ffffffffffffffffffffffffffffffffffffffff16815260200160008152602001600081526020016000151581526020016000815250905600a165627a7a72305820bd4abf865de5d7b2f30f7d777f6e2b0b7deb5de5e7bc73cb8a37b92e0479ad7d0029";

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

    public RemoteCall<Tuple7<String, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger>> getAgentListInfo(BigInteger _agentid) {
        final Function function = new Function("getAgentListInfo", 
                Arrays.<Type>asList(new Uint256(_agentid)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple7<String, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger>>(
                new Callable<Tuple7<String, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger>>() {
                    @Override
                    public Tuple7<String, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple7<String, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger, BigInteger>(
                                (String) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue(), 
                                (BigInteger) results.get(3).getValue(), 
                                (BigInteger) results.get(4).getValue(), 
                                (BigInteger) results.get(5).getValue(), 
                                (BigInteger) results.get(6).getValue());
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
