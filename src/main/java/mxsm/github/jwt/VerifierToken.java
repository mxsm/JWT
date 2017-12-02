package mxsm.github.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import mxsm.github.jwt.util.KeyUtil;

/**
 * 签名Token
 * @author ant
 * @Date 2017-12-02
 * Description
 */

public abstract class VerifierToken {

	public static void verifierToken(String token) throws Exception {
		
	    Algorithm algorithm = Algorithm.RSA256(KeyUtil.getRSAPublicKey(), KeyUtil.getRSAPrivateKey());
	    JWTVerifier verifier = JWT.require(algorithm)
	            .withIssuer("auth0")
	            .build();
	     verifier.verify(token);
	}
	
	
}
