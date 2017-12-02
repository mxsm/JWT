package mxsm.github.jwt.util;

import java.io.IOException;

import org.junit.Test;

public class KeyUtilTest {

	@Test
	public void testGetPublicKey ( ) {
		
		try {
			System.out.println(KeyUtil.getPublicKey());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test
	public void testGetPrivateKey ( ) {
		try {
			System.out.println(KeyUtil.getPrivateKey());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
