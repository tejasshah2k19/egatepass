package com.util;

public class OtpGenerator {

	public static Integer otpNumeric() {
		return (int) (Math.random() * 100000);
	}

	public static String otpAlphaNumeric(int size) {

		String source = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		String otp = "";
		for (int i = 1; i <= size; i++) {

			int index = (int) (Math.random() * source.length());
			otp = otp + source.charAt(index);// qAc5r
		}

		return otp;
	}
	
	
	public static void main(String[] args) {
		System.out.println(OtpGenerator.otpAlphaNumeric(7));
		System.out.println(OtpGenerator.otpAlphaNumeric(17));
		System.out.println(OtpGenerator.otpAlphaNumeric(6));
		
	} 
	
}
