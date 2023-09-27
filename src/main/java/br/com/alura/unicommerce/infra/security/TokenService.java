package br.com.alura.unicommerce.infra.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

import br.com.alura.unicommerce.modelo.Usuario;

@Service
public class TokenService {
	
	@Value("${api.security.token.secret}")
	private String secret;
	
	public String gerarToken(Usuario usuario) {
		System.out.print(secret);
		try {
		    var algoritmo = Algorithm.HMAC256(secret); //HMAC256 Algoritmo que faz a assinatura digital do Token
		    return JWT.create()
		        .withIssuer("unicommerce") //Quem está gerando o Token (API Unicommerce)
		        .withSubject(usuario.getEmail())
		        .withClaim("id", usuario.getId())
		        .withExpiresAt(dataExpiracao())
		        .sign(algoritmo);
		} catch (JWTCreationException exception){
			throw new RuntimeException("Erro ao gerar Token JWT ", exception);
		}
	}
	
	private Instant dataExpiracao() {
		return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
	}
	
	public String getSubject(String tokenJwt) {
		
		try {
			var algoritmo = Algorithm.HMAC256(secret);
		    return JWT.require(algoritmo)
		        // specify an specific claim validations
		        .withIssuer("unicommerce")
		        // reusable verifier instance
		        .build()
		        .verify(tokenJwt)
		        .getSubject();
		} catch (JWTVerificationException exception){
		    throw new RuntimeException("");
		}
		
	}

}
