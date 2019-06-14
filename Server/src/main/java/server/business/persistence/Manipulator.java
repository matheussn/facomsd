package server.business.persistence;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Manipulator {
	
	private Manipulator() {}
	
    private static volatile HashMap<BigInteger, byte[]> db = new HashMap<>();

    public static void addValue(BigInteger code, byte[] data) {
        db.put(code, data);
    }

    public static void addValues(Map<BigInteger, byte[]> values) {
        db.putAll(values);
    }

    public static void removeValue(BigInteger code) {
        db.remove(code);
    }

    public static byte[] getValue(BigInteger code) {
        return db.get(code);
    }

    public static void updateValue(BigInteger code, byte[] data) {
        db.replace(code, data);
    }

    public static boolean containKey(BigInteger code) {
        return db.containsKey(code);
    }
    
    public static Map<BigInteger, byte[]> getDb() {
    	return db;
    }
    
    public static void clearDatabase() {
    	db = new HashMap<>();
    }

    public static HashMap<BigInteger, byte[]> removeValues(ArrayList<Integer> range) {
        HashMap<BigInteger, byte[]> res = new HashMap<>();

        range.forEach((key) -> {

            if(db.containsKey(BigInteger.valueOf(key))){
                res.put(BigInteger.valueOf(key), db.get(BigInteger.valueOf(key)));
                db.remove(BigInteger.valueOf(key));
            }
        });

        return res;
    }
}