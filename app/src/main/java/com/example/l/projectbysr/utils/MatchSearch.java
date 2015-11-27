package com.example.l.projectbysr.utils;

import net.sourceforge.pinyin4j.PinyinHelper;

public class MatchSearch {

	public static boolean containsPinyin(String name, String search) {
		String pinyin = "";
		name = name.trim().replaceAll("\\s", "").replaceAll("（", "").replaceAll("）", "");
		char[] ch = name.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			String result = PinyinHelper.toHanyuPinyinStringArray(ch[i])[0];
			result = result.substring(0,result.length()-1);
			pinyin += result;
		}
//		System.out.println("pinyin==>"+pinyin);
		if(pinyin.contains(search)){
			return true;
		}
		return false;
	}

	public static boolean containsUpLetters(String name, String search) {
		StringBuffer upLetters = new StringBuffer();
		name = name.trim().replaceAll("\\s", "").replaceAll("（", "").replaceAll("）", "");
		char[] ch = name.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			String result = PinyinHelper.toHanyuPinyinStringArray(ch[i])[0].substring(0,1);
			System.out.println(result);
			upLetters.append(result);
		}
//		System.out.println("upLetter==>"+upLetters);
		if (upLetters.toString().contains(search)) {
			return true;
		}
		return false;
	}
	public static String getFirstCode(String firstName){//获取首字母
		String result = "";
		char[] ch = firstName.toCharArray();
		try {
			result = PinyinHelper.toHanyuPinyinStringArray(ch[0])[0];
			result = result.substring(0,1).toUpperCase();
		}catch (NullPointerException e){
			result = firstName.substring(0,1).toUpperCase();
		}

		return result;
	}
}
