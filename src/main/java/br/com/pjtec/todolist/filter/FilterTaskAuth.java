package br.com.pjtec.todolist.filter;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import at.favre.lib.crypto.bcrypt.BCrypt;
import br.com.pjtec.todolist.user.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class FilterTaskAuth extends OncePerRequestFilter {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		//O que p Once per Request Filter faz.
		
		
		//Ele pegar a autenticação (usuario e senha)
		var authorization = request.getHeader("Authorization");
		
		
		var authEncoded = authorization.substring("Basic".length()).trim();
		
		byte[] authDecode = Base64.getDecoder().decode(authEncoded);
		var authString = new String(authDecode);
		
		
		
		String[] credentials = authString.split(":");
		String username = credentials[0];
		String password = credentials[1];
		// Validar usuário
		var user = this.userRepository.findByUserName(username);
		if (user == null) {
			response.sendError(401, "Usuário sem autorização ou não existe!");
		}else {
			 // Validar senha
		var passwordVerify = BCrypt.verifyer().verify(password.toCharArray(), user.getPassword());
		if(passwordVerify.verified) {
			filterChain.doFilter(request, response);
		}else {
			response.sendError(401);
		}
			 // E dar acesso caso exista usuario
			 
		}
		

	}

}
