package com.cg.feedback.utility;

import java.util.Random;

public class GeneratePassKey {
	public static String generatePass(String name, String userId) {
		String password = "";
		for(String a : name.split(" ")) {
			int temp = 0;
			for(int b : a.toCharArray())
				temp+=b;
			password+=temp;
		}
		password+="-";
		Random random = new Random();
		for(int i = 0; i<5 ; i++) {
			password+=random.nextInt(10);
		}
		password+="-";
		int temp = 0;
		for(int a : userId.toCharArray()) {
			temp+=a*11;
		}
		password+=temp;
		return password;
	}
}
