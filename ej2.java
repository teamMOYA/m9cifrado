
import java.io.FileInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.security.Key;
import java.security.MessageDigest;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Cifrado {
	
  
	//FUNCION QUE PIDE FICHERO Y UNA PASS(STRING) para cifrar fichero
	public static byte[] cifrarFichero(String file, String password) throws FileNotFoundException{
      	byte[] data= null;
		
      	//creamos fichero
	File filec = new File("./src",file);
      	//comprobamos si existe
      	if (filec.exists()){
			//generamos clave
          	keygen(password);
          	//obtenemos datos fichero
          	getBytesFromFile(filec);
          	//ciframos fichero
          	
        }else{
          throw new FileNotFoundException();
        }
	//devolvemos fichero encriptado
      	return data;
    }
  
  	private static SecretKey keygen(String password){
        SecretKey sKey = null;
        int key_sice = 192;
        try {
			byte[] data = password.getBytes("UTF-8");
             MessageDigest md = MessageDigest.getInstance("SHA-256");
             byte[] hash = md.digest(data);
             byte[] key = Arrays.copyOf(hash, key_sice/8);
             sKey = new SecretKeySpec(key, "AES");
		} catch (Exception ex) {
             System.err.println("Error generant la clau:" + ex);
		}
        return sKey;

	}
  	
  	private static Byte[] getBytesFromFile(File file){
    	byte[] bytesArray = new byte[(int) file.length()];
     
      	FileInputStream fis = new FileInputStream(file);
  		fis.read(bytesArray); //read file into bytes[]
  		fis.close();
			
  		return bytesArray;
    }
      
    


}
