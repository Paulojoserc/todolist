package br.com.pjtec.todolist.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	@PostMapping("/")
	public ResponseEntity create(@RequestBody UserModel userModel) {
		//System.out.println(userModel.getName());
		var user = this.userRepository.findByUserName(userModel.getUserName());
		if(user != null) {
			//System.out.println("Usuario Já existeS");
			//Mensagem de erro
			//Status Code
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuario Já existeS");
		}
		var userCreated = this.userRepository.save(userModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
	}
}
