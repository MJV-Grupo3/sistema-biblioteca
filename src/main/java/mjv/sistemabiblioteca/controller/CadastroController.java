package mjv.sistemabiblioteca.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mjv.sistemabiblioteca.model.cadastro.Cadastro;
import mjv.sistemabiblioteca.service.CadastroService;

@RestController
@RequestMapping(path = "/cadastros")
public class CadastroController {

	@Autowired
	private CadastroService cadastroService;

	@PostMapping
	public void postCadastrarUsuario(@RequestBody Cadastro cadastro) {
		cadastroService.cadastrarUsuario(cadastro);
	}

	@GetMapping("/todos")
	public List<Cadastro> getListarUsuarios() {
		return cadastroService.buscarTodosUsuarios();
	}

	@GetMapping("/id")
	public Optional<Cadastro> getUsuarioId(@RequestParam Integer id) {
		return cadastroService.buscarUsuarioId(id);
	}

	@GetMapping("/cpf")
	public Optional<Cadastro> getUsuarioCpf(@RequestParam String cpf) {
		return cadastroService.buscaUsuarioCpf(cpf);
	}

	@GetMapping("/login")
	public Optional<Cadastro> getUsuarioLogin(@RequestParam String login) {
		return cadastroService.buscaUsuarioLogin(login);
	}

}
