package mxsm.github.jwt;

import org.junit.Test;

public class SignTokenTest {

	@Test
	public void testSignToken ( ) {
		try {
			System.out.println(SignToken.signToken());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
