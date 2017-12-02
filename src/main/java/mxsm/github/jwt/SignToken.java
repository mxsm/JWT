package mxsm.github.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import mxsm.github.jwt.util.KeyUtil;

/**
 * 签名Token
 * @author ant
 * @Date 2017-12-02
 * Description
 */

public abstract class SignToken {

	public static String signToken() throws Exception {
		
	    Algorithm algorithm = Algorithm.RSA256(KeyUtil.getRSAPublicKey(), KeyUtil.getRSAPrivateKey());
	    String token = JWT.create()
	            .withIssuer("auth0")
	            .sign(algorithm);
		return token;
	}
	
	
}
