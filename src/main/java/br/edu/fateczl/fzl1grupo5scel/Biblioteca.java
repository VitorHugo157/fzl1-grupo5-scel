package br.edu.fateczl.fzl1grupo5scel;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    List<Livro> livros = new ArrayList<>();

    public void save(Livro livro) {
        if(livro != null) {
            livros.add(livro);
        }
    }

    public boolean isbnJaCadastrado(String isbn) {
        if(livros != null) {
            for (Livro livro : livros) {
                if (livro.getIsbn().equalsIgnoreCase(isbn)) {
                    System.out.println("ISBN ja cadastrado!");
                    return true;
                }
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

    public List<Livro> getLivros() {
        return livros;
    }

    public int size() {
        return this.livros.size();
    }
}
