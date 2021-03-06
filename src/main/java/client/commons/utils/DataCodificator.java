package client.commons.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;

import client.commons.domain.User;

public class DataCodificator {

	public static byte[] encode(User user) throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ObjectOutputStream os = new ObjectOutputStream(out);
		os.writeObject(user);
		return out.toByteArray();
	}

	public static User decode(byte[] byteArray) throws IOException, ClassNotFoundException {
		ByteArrayInputStream in = new ByteArrayInputStream(byteArray);
		ObjectInputStream is = new ObjectInputStream(in);
		return (User) is.readObject();
	}

	public static BigInteger stringToBigInteger(String str) {
		return new BigInteger(str.getBytes());
	}
}
