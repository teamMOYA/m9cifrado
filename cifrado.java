package cifrado;

import java.security.Key;
import java.security.MessageDigest;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class descifrado {

	public static void main(String[] args) {
		byte[] encriptedData = { (byte) 0xEC, (byte) 0xC4, (byte) 0xD5, (byte) 0x89, 0x02, (byte) 0xE3, (byte) 0xD5, (byte) 0xCC, 0x5E, (byte) 0xC6, (byte) 0xAF,
				0x6C, 0x61, (byte) 0x8B, (byte) 0xC2, (byte) 0xA5};

		SecretKey key=null;
		byte[] decriptedData=null;

		for (int i=0;i<=5000;i++){
			key = keyGen(String.valueOf(i));
			decriptedData = decriptData(encriptedData,key);

			System.out.println(String.valueOf(i) + ": " + new String(decriptedData));
		}




	}
public static SecretKey keyGen(String i){
	SecretKey sKey = null;
	int key_sice = 192;
	try {
		 byte[] data = i.getBytes("UTF-8");
		 MessageDigest md = MessageDigest.getInstance("SHA-256");
		 byte[] hash = md.digest(data);
		 byte[] key = Arrays.copyOf(hash, key_sice/8);
		 sKey = new SecretKeySpec(key, "AES");
		 } catch (Exception ex) {
		 System.err.println("Error generant la clau:" + ex);
		 }
	return sKey;

}

	public static byte[] decriptData(byte[] data, Key key) {
		byte[] decriptedData = null;
		try {
			Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");

			cipher.init(Cipher.DECRYPT_MODE, key);
			decriptedData = cipher.doFinal(data);
		} catch (Exception ex) {
			System.err.println("Error descifrando: " + ex);
		}
		return decriptedData;
	}
}
