package edu.rosehulman.covidtracer.auth;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SecurityConstants {

	public static final String SECRET = getSecret();
	public static final long EXPIRATION_TIME = 900_000; // 15 mins
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";
	public static final String SIGN_UP_URL = "/api/services/controller/user";
	
	private static String getSecret() {
		Scanner reader;
		String secret = "";
		try {
			reader = new Scanner(new File("src/main/resources/application.properties"));
			for(int i = 0; i < 8; i++) {
				reader.next();
			}
			secret = reader.next().replace("secret=", "");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return secret;
	}
	
}