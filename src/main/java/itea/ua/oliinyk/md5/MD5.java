package itea.ua.oliinyk.md5;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
	private MessageDigest messageDigest;
	private byte[] digest;
	private BigInteger bigInt;
	private String md5Hex;
	@SuppressWarnings("unused")
	private String password;

	public MD5() {
	}

	public String md5Custom(String password) {
		this.password = password;
		digest = new byte[0];
		try {
			messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.reset();
			messageDigest.update(password.getBytes());
			digest = messageDigest.digest();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		bigInt = new BigInteger(1, digest);
		md5Hex = bigInt.toString(16);

		while (md5Hex.length() < 32) {
			md5Hex = "0" + md5Hex;
		}

		return md5Hex;
	}

}
