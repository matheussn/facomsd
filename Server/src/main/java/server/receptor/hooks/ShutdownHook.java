package server.receptor.hooks;

import io.grpc.GreeterGrpc;
import io.grpc.SafeOutputRequest;
import server.business.persistence.Manipulator;
import server.commons.chord.Chord;
import server.commons.chord.Node;
import server.commons.exceptions.ServerException;
import server.commons.utils.JsonUtils;
import server.receptor.ServerThread;
import server.requester.CommunicationManager;

import java.math.BigInteger;
import java.util.Map;

public class ShutdownHook implements Runnable {

    private ServerThread server;

    public ShutdownHook(ServerThread context) {
        this.server = context;
    }

    @Override
    public void run() {
        System.err.println("*** shutting down gRPC server since JVM is shutting down");

        Integer searchKey = Chord.getNode().getKey() + 1;
        Node responsibleNode = Chord.getFt().catchResponsibleNode(searchKey);

        GreeterGrpc.GreeterStub stub = CommunicationManager.initCommunication(responsibleNode.getIp(), responsibleNode.getPort());

        Map<BigInteger, byte[]> db = Manipulator.removeValues(Chord.getNode().getRange());

        try {
            stub.safeOutput(
                    SafeOutputRequest.newBuilder()
                            .setData(JsonUtils.serialize(db))
                            .setNode(JsonUtils.serialize(Chord.getNode()))
                            .build(),
                    new SafeOutputObserver()
            );
        } catch (ServerException e) {
            e.printStackTrace();
        }

        this.server.stop();
        System.err.println("*** server shut down");
    }
}
