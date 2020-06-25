package com.adminsys.link;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.ValidationException;
import java.io.UnsupportedEncodingException;

public class CryptUtil {
	public final static String DESEDE_ECB_NOPADDING = "DESede/ECB/NoPadding";//这里使用  3DES 算法：DESede 
	private static String Key="13572468~!@#abcdefgh$%^&";
	/**
	 * 加密函数
	 * @throws UnsupportedEncodingException 
	 */
	public String encryptXX(String ogString) throws UnsupportedEncodingException {
		//原始字符串按自定义规则填充成新的字符串
		String paddAfString = paddingString(ogString);
		byte[] bytes = paddAfString.getBytes("UTF-8");
		
		byte[] keyA = new byte[24];
		byte[] keyB = Key.getBytes("UTF-8");
		//加密规则数组准备
		System.arraycopy(keyB, 0, keyA, 0, 24);//将源数组keyB从下标0开始的24位长度的数组复制到目标数组keyA,从下标0的位置
		/**
		 * void java.lang.System.arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
		 * @param      src      the source array.源数组
		 * @param      srcPos   starting position in the source array.源数组要复制的起始位置
		 * @param      dest     the destination array.目标数组（将原数组复制到目标数组）
		 * @param      destPos  starting position in the destination data.目标数组起始位置（从目标数组的哪个下标开始复制操作）
		 * @param      length   the number of array elements to be copied.复制源数组的长度
		 */
		byte[] enc = new byte[8];
		//加密
		try {
			//获得加密数据
			enc = encrypt(bytes, keyA, DESEDE_ECB_NOPADDING);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bytes2HexString(enc);//将加密数据转换为string返回
	}
	/**
	 * 解密函数
	 * @throws UnsupportedEncodingException 
	 */
	public String deCryptXX(String enStr) throws ValidationException, UnsupportedEncodingException {
		//将加密后的字符串转换为byte[]
		byte[] bytes = hexString2Bytes(enStr)	;
		if (bytes.length%8!=0) {
			throw new ValidationException("无效");
		}
		byte[] keyA = new byte[24];
		byte[] keyB = Key.getBytes("UTF-8");
		//解密规则数组准备
		System.arraycopy(keyB, 0, keyA, 0, 24);//将源数组keyB从下标0开始的24位长度的数组复制到目标数组keyA,从下标0的位置
		byte[] dec = new byte[8];
		try {
			  dec = decrypt(bytes, keyA, DESEDE_ECB_NOPADDING);//解密
		} catch (Exception e) {
			  e.printStackTrace();
		}
		String s=new String(dec,"UTF-8");
		return antipadding(s);//将解密后字符串按加密前填充的规则消除填充的数据
	}
	/**
	 * 原始字符串填充拼装
	 * @param ogString  原始字符串
	 * @return 重新拼装的字符串 buf
	 * ps:重频规则 字符串转换为byte[]数组后加1取除8的余数len,最后的字符串：len+ogString+(8-len)个0
	 */
	public String paddingString(String ogString) {
		StringBuffer buf = new StringBuffer();
		int len = 0;
		try {
			len = (ogString.getBytes("UTF-8").length+1)%8;//将字符串转换为byte数组后取余数
			if (len>0) {
				len = 8-len;
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		buf.append(len);
		buf.append(ogString);
		for(int i=0;i<len;i++)
			 buf.append('0');
		return buf.toString();
	}
	 /**
	  * 为解密后的数据清除规则化填充的数据
	  * @param url
	  * @return
	  */
	 public static String antipadding(String paddStr){
		 String leng = paddStr.substring(0,1);
		 int len=Integer.parseInt(leng); //获得余数
		 String ogString = paddStr.substring(1,(paddStr.length()-len));
		 return ogString;
	 }
	 /**
	 * 加密
	 * @param src 源数据
	 * @param key 
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public static byte[] encrypt(byte[] src,byte[] key,String name) throws Exception {
		String name1 = name;
		int index = name.indexOf('/');//获得“/”在字符串中第一次出现的位置，无值默认返回-1
		if (index != -1) {
			name = name.substring(0,index);//截取索引0开始index值结束（不包含）的字符串
		}
			SecretKeySpec securekey = new SecretKeySpec(key, name);//根据name算法名称，生成密钥
			//应用程序调用 Cipher的 getInstance 方法并将所请求转换 的名称传递给它，转换具有以下形式：“算法/模式/填充”或“算法”，
			//如： Cipher c = Cipher.getInstance("DES/CBC/PKCS5Padding");
			Cipher cipher = Cipher.getInstance(name1);
			cipher.init(Cipher.ENCRYPT_MODE, securekey);//用密钥初始化此 Cipher
			return cipher.doFinal(src);//foFinal("xx") 加密数据
	}
	/**
	 * 解密
	 * @param src
	 * @param key
	 * @param name
	 * @return
	 * @throws Exception
	 */
	 public static byte[] decrypt(byte[] src, byte[] key, String name) throws Exception {
		  String name1 = name;
		  int index = name.indexOf('/');//获得“/”在字符串中第一次出现的位置，无值默认返回-1
		  if(index != -1)
		   name = name.substring(0, index);//截取索引0开始index值结束（不包含）的字符串
		  SecretKeySpec securekey = new SecretKeySpec(key, name);//根据name算法名称，生成密钥
		  //应用程序调用 Cipher的 getInstance 方法并将所请求转换 的名称传递给它，转换具有以下形式：“算法/模式/填充”或“算法”，
		  //如： Cipher c = Cipher.getInstance("DES/CBC/PKCS5Padding");
		  Cipher cipher = Cipher.getInstance(name1);
		  cipher.init(Cipher.DECRYPT_MODE, securekey);//用密钥初始化此 Cipher
		  return cipher.doFinal(src);//foFinal("xx") 解密数据
		 }
	 /**
	 * 将加密后的byte数组转换为string
	 * @param bytes
	 * @return
	 */
	public static String bytes2HexString(byte[] bytes) {
		String hs = null;
		if (bytes!=null) {
			final int size = bytes.length;
			if (size>0) {
				StringBuilder sBuilder = new StringBuilder();
				for(int i=0;i<size;i++) {
					String tmp = (java.lang.Integer.toHexString(bytes[i] & 0XFF));//把字节（转换成了int）以16进制的方式显示。
					if (tmp.length()==1) {
						sBuilder.append("0"+tmp);
					}else {
						sBuilder.append(tmp);
					}
				}
				hs = sBuilder.toString().toUpperCase();//toUpperCase() 方法将字符串小写字符转换为大写。
			}
		}
		return hs;
		
	}
	/**
	 * 将加密的字符串数据转换为byte[]
	 * @param enStr
	 * @return
	 */
	public static byte[] hexString2Bytes(String enStr) {
		byte[] bytes = null;
		if (enStr!=null) {
			final int size = (enStr.length())/2;
			if (size>0) {
				bytes = new byte[size];
				for(int i=0;i<size;i++) {
					String enStringByte = enStr.substring(i*2,i*2+2);
					byte b = 0;
					try {
						b = (byte) Integer.parseInt(enStringByte,16);//把16进制字符串转10进制int型后再强转byte
					}catch (NumberFormatException e) {
						b = 0;
					}
					bytes[i] = b;
				}
			}
		}
		return bytes;
	}
	
	public static void main(String[] args) throws UnsupportedEncodingException, ValidationException {
		
		String ogString = "123456";
		System.out.println("原始数据："+ogString + "   长度："+ogString .length());
		CryptUtil cryptUtil = new CryptUtil();
		//加密
		String enStr = cryptUtil.encryptXX(ogString );
		System.out.println("加密数据："+ enStr);
		//解密
		String deString = cryptUtil.deCryptXX(enStr);
		System.out.println("解密数据："+deString + "   长度："+deString.length());
	}
}