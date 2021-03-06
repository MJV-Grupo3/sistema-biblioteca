package mjv.sistemabiblioteca.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mjv.sistemabiblioteca.dto.CadastroDto;
import mjv.sistemabiblioteca.model.cadastro.Cadastro;
import mjv.sistemabiblioteca.service.CadastroService;

@RestController
@RequestMapping(path = "/cadastros")
public class CadastroController {

	@Autowired
	private CadastroService cadastroService;

	@PostMapping
	public Integer cadastrarUsuario(@Valid @RequestBody CadastroDto cadastro) {
		return cadastroService.cadastrarUsuario(cadastro).getId();
	}

	@GetMapping("/todos")
	public List<Cadastro> listarUsuarios() {
		return cadastroService.buscarTodosUsuarios();
	}

	@GetMapping("/id")
	public Cadastro buscarUsuarioId(@RequestParam Integer id) {
		return cadastroService.buscarUsuarioId(id);
	}

	@GetMapping("/cpf")
	public Cadastro buscarUsuarioCpf(@RequestParam String cpf) {
		return cadastroService.buscaUsuarioCpf(cpf);
	}

	@GetMapping("/login")
	public Cadastro buscarUsuarioLogin(@RequestParam String login) {
		return cadastroService.buscaUsuarioLogin(login);
	}

}
