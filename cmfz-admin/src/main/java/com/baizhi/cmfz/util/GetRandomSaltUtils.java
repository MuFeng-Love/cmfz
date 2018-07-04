package com.baizhi.cmfz.util;

import java.util.Random;

public class GetRandomSaltUtils {
	public static char[] getRandomChars() {

		char[] chs = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
				.toCharArray();

		char[] code = new char[6];

		Random random = new Random();

		for (int i = 0; i < code.length; i++) {
			code[i] = chs[random.nextInt(chs.length)];
		}

		return code;
	}
}
