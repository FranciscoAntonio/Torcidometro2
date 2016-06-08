package francisco.com.br.torcidometro;

import java.io.Serializable;

public class Livro implements Serializable {
    public String titulo;
    public String categoria;
    public String autor;
    public int ano;
    public int paginas;
    public String capa;

    public Livro(){
    }

    public Livro(String titulo, String categoria, String autor, int ano, int paginas, String capa){
        this.ano = ano;
        this.autor = autor;
        this.capa = capa;
        this.categoria= categoria;
        this.titulo = titulo;
    }

    @Override
    public String toString(){
        return titulo;
    }

}
