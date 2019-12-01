import org.apache.commons.codec.digest.DigestUtils;

public class Pruebas {

	public static void main(String[] args) {

		//Contraseñas originales del fichero users.csv
		String password = "fran.1234";
		String password2 = "1234.4321";
		String password3 = "Fran.7777";
		String password4 = "Fran.6969.Fran";
		
		String md5 = DigestUtils.md5Hex(password).toUpperCase();
		String md52 = DigestUtils.md5Hex(password2).toUpperCase();
		String md53 = DigestUtils.md5Hex(password3).toUpperCase();
		String md54 = DigestUtils.md5Hex(password4).toUpperCase();
		
		System.out.println("Password cifrado: " + md5);
		System.out.println("Password cifrado: " + md52);
		System.out.println("Password cifrado: " + md53);
		System.out.println("Password cifrado: " + md54);

	}

}
