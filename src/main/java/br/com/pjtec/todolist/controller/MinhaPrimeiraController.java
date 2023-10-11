package br.com.pjtec.todolist.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/primeiraRota")
//http://localhost:8080/------
public class MinhaPrimeiraController {

	/*
	 * Métodos de requisição/acesso do HTTP
	 * GET - Buscar uma informação
	 * POST - Adicionar um dado/informação
	 * PUT - Alterar um dado/info
	 * DELETE - Remover um dado
	 * PATCH - Alterar somente uma parte da informação/dado 
	 * */
	//Método (Funcionalidade) de uma classe
	@GetMapping("/primeiroMetodo")
	public String primeiraMensagem() {
		return "Funcionou";
	}
}
