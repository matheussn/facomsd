package server.commons.chord.observers;

import com.fasterxml.jackson.core.type.TypeReference;
import io.grpc.GetRangeResponse;
import io.grpc.stub.StreamObserver;
import server.business.persistence.Manipulator;
import server.commons.atomix.ClusterAtomix;
import server.commons.chord.ChodNode;
import server.commons.chord.Chord;
import server.commons.chord.FingerTable;
import server.commons.exceptions.ServerException;
import server.commons.utils.JsonUtils;
import server.requester.GrpcCommunication;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetRangeObserver implements StreamObserver<GetRangeResponse> {

    private String chordIp;
    private int chordPort;

    public GetRangeObserver(String chordIp, int chordPort){
        this.chordIp = chordIp;
        this.chordPort = chordPort;
    }

    @Override
    public void onNext(GetRangeResponse getRangeResponse) {
        try {
            ChodNode newChodNode = JsonUtils.deserialize(getRangeResponse.getNode(), ChodNode.class);

            if (newChodNode.getKey() != Chord.getChodNode().getKey()) {
                loadDatabase(getRangeResponse);
                setRange(getRangeResponse);

                FingerTable newFt = JsonUtils.deserialize(getRangeResponse.getFingerT(), FingerTable.class);

                Chord.getFt().updateFT(newChodNode);
                Chord.getFt().updateFT(newFt.getMap());

            } else {
                Chord.getChodNode().setNewKey();
                ClusterAtomix.setKey(Chord.getChodNode().getKey());

                GrpcCommunication.findNode(chordIp, chordPort);
            }
        } catch (ServerException e) {
            e.printStackTrace();
        }
    }

    private void loadDatabase(GetRangeResponse getRangeResponse) {
        try {
            TypeReference<HashMap<BigInteger, byte[]>> dbRef = new TypeReference<HashMap<BigInteger, byte[]>>() {};
            HashMap<BigInteger, byte[]> map = JsonUtils.deserialize(getRangeResponse.getData(), dbRef);
            for (Map.Entry<BigInteger, byte[]> entry : map.entrySet()) {
                Manipulator.addValue(entry.getKey(), entry.getValue());
            }
        } catch (ServerException e) {
            e.printStackTrace();
        }
    }

    private void setRange(GetRangeResponse getRangeResponse) {
        try {
            TypeReference<List<Integer>> arrayRef = new TypeReference<List<Integer>>() {};
            final List<Integer> deserialize = JsonUtils.deserialize(getRangeResponse.getRange(), arrayRef);
            Chord.getChodNode().setRangeWithArray(deserialize);
            ClusterAtomix.setRange(deserialize);
        } catch (ServerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onError(Throwable throwable) { }

    @Override
    public void onCompleted() { }
}