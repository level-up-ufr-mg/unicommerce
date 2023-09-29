package br.com.alura.util.service.infra.services;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

import br.com.alura.util.domain.usuario.Usuario;

@Service
public class TokenServices {

	@Value("${br.com.alura.util.Infra.Security}")
	private String secret;
	
	
	public String gerarToken(Usuario usuario) { 
		try {
            var algoritmo = Algorithm.HMAC256(secret);
            return JWT.create()
                .withIssuer("API Voll.med")
                .withSubject(usuario.getLogin())
                .withExpiresAt(dataExpiracao())
                .sign(algoritmo);
        } catch (JWTCreationException exception){
            throw new RuntimeException("erro ao gerrar token jwt", exception);
        }        
    }

	
	
	
	public  String getSubjet(String  tokenJwt) {
		
		try {
            var algoritmo = Algorithm.HMAC256(secret);
            return JWT.require(algoritmo)
                .withIssuer("API Voll.med")
                .build()
                .verify(tokenJwt)
                .getSubject();
        } catch (JWTCreationException exception){
            throw new RuntimeException("token Jwt Invaido ou expirado ", exception);
        }        
		
	}
	
	
	
	
    private Instant dataExpiracao() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
	
	
}
