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

public class DeleteUser implements CommandStrategy {

	@Override
	public void executeCommand(GenericCommand genericCommand) {
		BigInteger code = genericCommand.getCode();

		GenericResponse deleteResponse;

		if(Manipulator.getValue(code) != null) {
			Manipulator.removeValue(code);

			if (!Manipulator.containKey(code)) {
				deleteResponse = GenericResponse.newBuilder()
						.setStatus(MessageMap.SUCCESS.getMessage())
						.setMessage(MessageMap.DELETE_SUCCESS.getMessage())
						.build();
			} else {
				deleteResponse = GenericResponse.newBuilder()
						.setStatus(MessageMap.ERROR.getMessage())
						.setMessage(MessageMap.EXECUTION_ERROR.getMessage())
						.build();
			}
		} else {
			deleteResponse = GenericResponse.newBuilder()
					.setStatus(MessageMap.ERROR.getMessage())
					.setMessage(MessageMap.USER_NOT_FOUND.getMessage())
					.build();
		}

		if(genericCommand.getOutput() != null) {
			genericCommand.getOutput().onNext(deleteResponse);
			genericCommand.getOutput().onCompleted();
		}
	}

	@Override
	public void passCommand(GenericCommand genericCommand, Node node) {
		GreeterGrpc.GreeterStub stub = CommunicationManager.initCommunication(node.getIp(), node.getPort());

		stub.deleteUser(
				GenericRequest.newBuilder()
						.setCode(genericCommand.getCode().intValue())
						.build(),
				new GenericResponseObserver(genericCommand.getOutput())
		);
	}
}