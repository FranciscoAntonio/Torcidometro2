package francisco.com.br.torcidometro;

import android.view.View;

import java.io.Serializable;

public class Banda implements Serializable {

    public String nome;
    public String evento;
    public int id;

    public Banda(String nome, String evento, int id) {
        this.nome = nome;
        this.evento = evento;
        this.id = id;
    }
}
