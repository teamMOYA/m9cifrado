package cifrado;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

import javax.crypto.SecretKey;

public class MainEj2 {

	public static void main(String[] args) {
		byte[] cifrado;
		byte[] descifrado;

		String pass = "HOLA";
		String file = "./src/cifrado/ok.txt";

		try {
			//ciframos el fichero
			cifrado = Cifrado.encriptFile(file, pass);
			SecretKey skey = Cifrado.keygen("HOLA");
			//guardamos fichero
			guardarFichero(file + ".aes", cifrado);

			//parte 2
			//
			file.length();
			System.out.println(file.substring(file.length()-4, file.length()));

	      	//borramos fichero y guardamos con otro nombre



		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}


	public static



	public static String leerFichero(String file) throws IOException{
		BufferedReader lector = null;
		String linea = "";

		lector = new BufferedReader(new FileReader(file));

		while ((linea += lector.readLine()) != null) {
			linea += System.lineSeparator();

		}
		return linea;
	}

	public static void guardarFichero(String File, byte[] data){
		InputStream origen = null;
		OutputStream destino = null;
		try {
			destino = new FileOutputStream(File);

			destino.write(data);

		}catch (Exception e) {
			System.out.println("gg");
		}finally{
			try {
		        destino.close();
			} catch (Exception e2) {
				System.out.println("gg2");
			}

		}
	}


}
