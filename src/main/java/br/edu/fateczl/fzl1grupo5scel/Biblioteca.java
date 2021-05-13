package br.edu.fateczl.fzl1grupo5scel;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    List<Livro> livros = new ArrayList<>();

    public void cadastrarLivro(Livro livro) {
        livros.add(livro);
    }

    public boolean isbnJaCadastrado(String isbn) {
        for(Livro livro : livros) {
            if(livro.getIsbn().equalsIgnoreCase(isbn)) {
                return true;
            }
        }
        return false;
    }

    public boolean isbnEmBranco(String isbn) {
        return isBlank(isbn);
    }

    public boolean tituloEmBranco(String titulo) {
        return isBlank(titulo);
    }

    public boolean autorEmBranco(String autor) {
        return isBlank(autor);
    }

    private boolean isBlank(String txt) {
        return txt == null || txt.trim().isEmpty();
    }
}
