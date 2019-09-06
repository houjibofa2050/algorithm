package com.apollo.demo.controller;

import java.io.UnsupportedEncodingException;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class JAVA3DES {
	private static BASE64Encoder base64 = new BASE64Encoder();
	private static BASE64Decoder base64d = new BASE64Decoder();

	private static String DES = "Des";
	private static String DESEDE = "DESede";
	private static String DESBLOWFISH = "Blowfish";
	private static String ALGORITHM = DESEDE;
	private static String MODEL_PAD = "DESede/CBC/NoPadding";
	private final static String ENCODING = "GBK";

	private static final Logger logger = LoggerFactory.getLogger(JAVA3DES.class);

	public static String desEncrypt(String input,String cipher_key,byte[] iv) {

		String enStr = "";
		try{
			DESedeKeySpec p8ksp = new DESedeKeySpec(base64d.decodeBuffer(cipher_key));
			Key key = SecretKeyFactory.getInstance(ALGORITHM).generateSecret(p8ksp);
			SecretKeySpec myKey = new SecretKeySpec(key.getEncoded(), ALGORITHM);

			input = padding(input);
			byte[] plainBytes = (byte[]) null;
			Cipher cipher = null;
			byte[] cipherText = (byte[]) null;

			plainBytes = input.getBytes(ENCODING);
			cipher = Cipher.getInstance(MODEL_PAD);

			IvParameterSpec ivspec = new IvParameterSpec(iv);
			cipher.init(1, myKey, ivspec);
			cipherText = cipher.doFinal(plainBytes);

			enStr = base64.encode(cipherText);

		}catch(Exception e){
			logger.info("¼ÓÃÜÅ×³öÒì³££¡",e);

		}

		return enStr;

	}

	public static String desDecrypt(String cipherText,String cipher_key,byte[] iv) throws Exception {

		String deStr = "";
		try{
			DESedeKeySpec p8ksp = new DESedeKeySpec(base64d.decodeBuffer(cipher_key));
			Key key = SecretKeyFactory.getInstance(ALGORITHM).generateSecret(p8ksp);
			SecretKeySpec myKey = new SecretKeySpec(key.getEncoded(), ALGORITHM);

			Cipher cipher = null;
			byte[] inPut = base64d.decodeBuffer(cipherText);
			cipher = Cipher.getInstance(MODEL_PAD);

			IvParameterSpec ivspec = new IvParameterSpec(iv);
			cipher.init(2, myKey, ivspec);
			byte[] output = removePadding(cipher.doFinal(inPut));

			deStr = new String(output, ENCODING);
		}catch(Exception e){
			logger.info("½âÃÜÅ×³öÒì³££¡",e);
			throw e;
		}

		return deStr;

	}

	/**
	 *
	 * @param str
	 * @return
	 */
	public static String padding(String str) {
		byte[] oldByteArray;
		try {
			oldByteArray = str.getBytes(ENCODING);
			int numberToPad = 8 - oldByteArray.length % 8;
			byte[] newByteArray = new byte[oldByteArray.length + numberToPad];
			System.arraycopy(oldByteArray, 0, newByteArray, 0, oldByteArray.length);
			for (int i = oldByteArray.length; i < newByteArray.length; ++i) {
				newByteArray[i] = 0;
			}
			return new String(newByteArray, ENCODING);
		} catch (UnsupportedEncodingException e) {
			System.out.println("Crypter.padding UnsupportedEncodingException");
		}
		return null;
	}

	/**
	 *
	 * @param oldByteArray
	 * @return
	 */
	public static byte[] removePadding(byte[] oldByteArray) {
		int numberPaded = 0;
		for (int i = oldByteArray.length; i >= 0; --i) {
			if (oldByteArray[(i - 1)] != 0) {
				numberPaded = oldByteArray.length - i;
				break;
			}
		}

		byte[] newByteArray = new byte[oldByteArray.length - numberPaded];
		System.arraycopy(oldByteArray, 0, newByteArray, 0, newByteArray.length);

		return newByteArray;
	}
}
