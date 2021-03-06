package mjv.sistemabiblioteca.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mjv.sistemabiblioteca.dto.LivroDto;
import mjv.sistemabiblioteca.model.locacao.Livro;
import mjv.sistemabiblioteca.service.LivroService;

@RestController
@RequestMapping(path = "/livros")
public class LivroController {
	
	@Autowired
	private LivroService livroService;
	
	@PostMapping
	public void cadastrarLivro(@Valid @RequestBody LivroDto livro) {
		livroService.cadastrarLivro(livro);
	}

	@GetMapping("/todos")
	public Iterable<Livro> listarLivros() {
		return livroService.buscarTodosLivros();
	}
	
	@GetMapping("/id")
	public Livro buscarLivroId(@RequestParam Integer id) {
		return livroService.buscarId(id);
	}
	
	@GetMapping("/isbn")
	public Livro buscarLivroIsbn(@RequestParam String isbn) {
		return livroService.buscarIsbn(isbn);
	}
}
