package com.ujia.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 序列工厂
 * 
 * @author xx
 *
 */
public class SeqFactory {
	
	private static final String prefix="ujia";
	private static final int idLength = 25;// 25 - 32

	/**
	 * 25位id
	 *
	 * @return
	 */
	public static String createId() {

		return prefix+createSeq();
	}
	
	public static String createSeq() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmssSSSS-");
		String format = sdf.format(new Date());
		
		
		return format + (new Random().nextDouble()+"").substring(2, idLength-19);//n位随机数
	}
	
}
