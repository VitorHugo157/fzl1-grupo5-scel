package br.edu.fateczl.fzl1grupo5scel;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class Fzl1Grupo5ScelApplicationTests {

	Biblioteca biblioteca = new Biblioteca();

	@Test
	void contextLoads() {
	}

	@Test
	public void CT01_CadastrarLivroComSucesso() {
		Livro livro = new Livro("0001", "Banco de Dados", "Christopher J. Date");
		biblioteca.cadastrarLivro(livro);
		assertEquals(1, biblioteca.livros.size());
	}

	@Test
	public void CT02_IsbnJaCadastrado() {
		Livro livro = new Livro("0001", "Banco de Dados", "C. J. Date");
		biblioteca.cadastrarLivro(livro);
		boolean isIsbnCadastrado = biblioteca.isbnJaCadastrado(livro.getIsbn());
		assertTrue(isIsbnCadastrado);
	}

	@Test
	public void CT03_IsbnEmBranco() {
		Livro livro = new Livro("", "Banco de Dados", "C. J. Date");
		biblioteca.cadastrarLivro(livro);
		boolean isIsbnEmBranco = biblioteca.isbnEmBranco(livro.getIsbn());
		assertTrue(isIsbnEmBranco);
	}

	@Test
	public void CT04_TituloEmBranco() {
		Livro livro = new Livro("0001", "", "C. J. Date");
		biblioteca.cadastrarLivro(livro);
		boolean isTituloEmBranco = biblioteca.tituloEmBranco(livro.getTitulo());
		assertTrue(isTituloEmBranco);
	}

	@Test
	public void CT05_AutorEmBranco() {
		Livro livro = new Livro("0001", "Banco de Dados", "");
		biblioteca.cadastrarLivro(livro);
		boolean isAutorEmBranco = biblioteca.autorEmBranco(livro.getAutor());
		assertTrue(isAutorEmBranco);
	}

}
