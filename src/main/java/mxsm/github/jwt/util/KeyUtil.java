package mxsm.github.jwt.util;

import java.io.IOException;
import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;

/**
 * 加载密钥工具类
 * @author ant
 * @Date 2017-12-02
 * Description
 */

public abstract class KeyUtil {

	public static final String UTF_8 = "UTF-8";
	
	public static final String KEY_RSA = "RSA";
	
	private static RSAPublicKey publicKey;
	
	private static RSAPrivateKey privateKey;
	
	static {
		try {
			X509EncodedKeySpec publicSpec = new X509EncodedKeySpec(Base64.decodeBase64(KeyUtil.getPublicKey().getBytes(KeyUtil.UTF_8)));
			publicKey = (RSAPublicKey)KeyFactory.getInstance(KEY_RSA).generatePublic(publicSpec);
			PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(Base64.decodeBase64(KeyUtil.getPrivateKey().getBytes(KeyUtil.UTF_8)));
		    privateKey = (RSAPrivateKey)KeyFactory.getInstance(KEY_RSA).generatePrivate(keySpec);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private static List<String> getFileString(String fileName) throws IOException{
		List<String> list = null;
		
		try {
			list = IOUtils.readLines(KeyUtil.class.getClassLoader().getResourceAsStream(fileName), "UTF-8");
		} catch (IOException e) {
			throw e;
		}
		
		if(null == list || list.size() == 0) {
			return new ArrayList<>();
		}
		return list;
	}
	
	
	/**
	 * 获取公钥
	 * @return
	 */
	public static String getPublicKey() throws IOException{
		
		List<String> list = getFileString("pub.key");
		StringBuilder publicKey = new StringBuilder();
		for(String item : list) {
			if(item.startsWith("---")) {
				continue;
			}
			publicKey.append(item).append("\n");
		}
		return publicKey.toString();
	}
	
	
	/**
	 * 获取私钥
	 * @return
	 */
	public static String getPrivateKey() throws IOException{
		
		List<String> list = getFileString("pri.key");
		StringBuilder publicKey = new StringBuilder();
		for(String item : list) {
			if(item.startsWith("---")) {
				continue;
			}
			publicKey.append(item).append("\n");
		}
		return publicKey.toString();

	}
	
	public static RSAPublicKey getRSAPublicKey() {
		return publicKey;
	}
	
	public static RSAPrivateKey  getRSAPrivateKey() {
		return privateKey;
	}
}
