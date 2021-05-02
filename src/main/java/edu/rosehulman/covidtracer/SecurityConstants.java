package edu.rosehulman.covidtracer;

public class SecurityConstants {

	public static final String SECRET = "8MRtXCNf62jdf2paZWXi"; // this might not be right actually
	public static final long EXPIRATION_TIME = 900_000; // 15 mins
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";
	public static final String SIGN_UP_URL = "/api/services/controller/user";
	
}
