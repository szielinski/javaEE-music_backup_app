package ie.dit.backupapp.utils;

import org.jboss.security.auth.spi.Util;

/**
 * Password Generator used to manually convert plaintext passwords into appropriate digests.
 */
public class PasswordGenerator {

	public static void main(String [] args) {
		String password = "test";
		System.out.println(PasswordGenerator.generate(password));
	}

	public static String generate(String password) {
		return Util.createPasswordHash("SHA-256", "BASE64", null, null, password);
	}
}