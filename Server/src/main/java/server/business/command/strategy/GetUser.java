package server.business.command.strategy;

import io.grpc.GenericRequest;
import io.grpc.GenericResponse;
import io.grpc.GreeterGrpc;
import server.client.CommunicationManager;
import server.commons.Chord.Node;
import server.commons.domain.GenericCommand;
import server.commons.utils.MessageMap;
import server.model.hashmap.Manipulator;

import java.math.BigInteger;

public class GetUser implements CommandStrategy {

	@Override
	public void executeCommand(GenericCommand genericCommand) {
		BigInteger code = genericCommand.getCode();

		GenericResponse getResponse;

		byte[] res = Manipulator.getValue(code);

		if(res != null){
			getResponse = GenericResponse.newBuilder()
					.setStatus(MessageMap.SUCCESS.getMessage())
					.setMessage(MessageMap.GET_SUCCESS.getMessage())
					.setData(new String(res))
					.build();
		} else {
			getResponse = GenericResponse.newBuilder()
					.setStatus(MessageMap.ERROR.getMessage())
					.setMessage(MessageMap.USER_NOT_FOUND.getMessage())
					.build();
		}

		if(genericCommand.getOutput() != null) {
			genericCommand.getOutput().onNext(getResponse);
			genericCommand.getOutput().onCompleted();
		}
	}

	@Override
	public void passCommand(GenericCommand genericCommand, Node node) {
		System.err.println(node.getPort());
		GreeterGrpc.GreeterStub stub = CommunicationManager.initCommunication(node.getIp(), node.getPort());

		stub.getUser(
				GenericRequest.newBuilder()
						.setCode(genericCommand.getCode().intValue())
						.build(),
				new GenericResponseObserver(genericCommand.getOutput())
		);
	}
}