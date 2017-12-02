package mxsm.github.jwt;

import org.junit.Test;

public class VerifierTokenTest {

	@Test
	public void testVerifierToken ( ) {
		try {
			VerifierToken.verifierToken(SignToken.signToken());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
