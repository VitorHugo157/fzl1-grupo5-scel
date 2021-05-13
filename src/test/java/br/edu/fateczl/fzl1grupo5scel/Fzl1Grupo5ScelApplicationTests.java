package br.edu.fateczl.fzl1grupo5scel;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class Fzl1Grupo5ScelApplicationTests {

	Biblioteca biblioteca = new Biblioteca();

	@Test
	void contextLoads() {
	}

	@Test
	public void CT01_CadastrarLivroComSucesso() {
		Livro livro = new Livro("0001", "Banco de Dados", "Christopher J. Date");
		biblioteca.save(livro);
		assertEquals(1, biblioteca.size());
	}

	@Test
	public void CT02_IsbnJaCadastrado() {
		Livro livro = new Livro("0001", "Banco de Dados", "C. J. Date");
		biblioteca.save(livro);
		boolean isIsbnCadastrado = biblioteca.isbnJaCadastrado(livro.getIsbn());
		assertTrue(isIsbnCadastrado);
	}

	@Test
	public void CT03_IsbnEmBranco() {
		Livro livro = new Livro("", "Banco de Dados", "C. J. Date");
		//biblioteca.save(livro);
		boolean isIsbnEmBranco = biblioteca.isbnEmBranco(livro.getIsbn());
		assertTrue(isIsbnEmBranco);
	}

	@Test
	public void CT04_TituloEmBranco() {
		Livro livro = new Livro("0001", "", "C. J. Date");
		//biblioteca.save(livro);
		boolean isTituloEmBranco = biblioteca.tituloEmBranco(livro.getTitulo());
		assertTrue(isTituloEmBranco);
	}

	@Test
	public void CT05_AutorEmBranco() {
		Livro livro = new Livro("0001", "Banco de Dados", "");
		//biblioteca.save(livro);
		boolean isAutorEmBranco = biblioteca.autorEmBranco(livro.getAutor());
		assertTrue(isAutorEmBranco);
	}

	@Test
	public void CT06_IsbnInvalido() {
		Livro livro = new Livro("", "Banco de Dados", "C. J. Date");
		biblioteca.save(livro);
		String isbnInvalido = biblioteca.isbnInvalido(livro.getIsbn());
		// Testando com 0 caracter
		assertEquals("ISBN deve ter 4 caracteres", isbnInvalido);
		// Testando com 1 caracter
		livro.setIsbn("1");
		isbnInvalido = biblioteca.isbnInvalido(livro.getIsbn());
		assertEquals("ISBN deve ter 4 caracteres", isbnInvalido);
		// Testando com 2 caracteres
		livro.setIsbn("12");
		isbnInvalido = biblioteca.isbnInvalido(livro.getIsbn());
		assertEquals("ISBN deve ter 4 caracteres", isbnInvalido);
		// Testando com 3 caracteres
		livro.setIsbn("123");
		isbnInvalido = biblioteca.isbnInvalido(livro.getIsbn());
		assertEquals("ISBN deve ter 4 caracteres", isbnInvalido);
		// Testando com 5 caracteres
		livro.setIsbn("12345");
		isbnInvalido = biblioteca.isbnInvalido(livro.getIsbn());
		assertEquals("ISBN deve ter 4 caracteres", isbnInvalido);
	}

	@Test
	public void CT07_TituloInvalido() {
		Livro livro = new Livro("1234", "", "C. J. Date");
		biblioteca.save(livro);
		String tituloInvalido = biblioteca.tituloInvalido(livro.getTitulo());
		// Testando com 0 caracter
		assertEquals("Titulo deve ter entre 1 e 50 caracteres", tituloInvalido);
		// Testando com 51 caracteres
		livro.setTitulo("123456789012345678901234567890123456789012345678901");
		tituloInvalido = biblioteca.tituloInvalido(livro.getTitulo());
		assertEquals("Titulo deve ter entre 1 e 50 caracteres", tituloInvalido);
	}

	@Test
	public void CT08_AutorInvalido() {
		Livro livro = new Livro("1234", "Banco de Dados", "");
		biblioteca.save(livro);
		String autorInvalido = biblioteca.autorInvalido(livro.getAutor());
		// Testando com 0 caracter
		assertEquals("Autor deve ter entre 1 e 50 caracteres", autorInvalido);
		// Testando com 51 caracters
		livro.setTitulo("123456789012345678901234567890123456789012345678901");
		autorInvalido = biblioteca.autorInvalido(livro.getAutor());
		assertEquals("Autor deve ter entre 1 e 50 caracteres", autorInvalido);
	}

}
