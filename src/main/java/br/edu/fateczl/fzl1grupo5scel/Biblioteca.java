package br.edu.fateczl.fzl1grupo5scel;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    List<Livro> livros = new ArrayList<>();

    public void cadastrarLivro(Livro livro) {
    }

    public boolean isbnJaCadastrado(String isbn) {
        return false;
    }

    public boolean isbnEmBranco(String isbn) {
        return false;
    }

    public boolean tituloEmBranco(String titulo) {
        return false;
    }

    public boolean autorEmBranco(String autor) {
        return false;
    }
}
