package francisco.com.br.torcidometro;

import android.app.ListActivity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Renato on 08/06/2016.
 */
public class Evento implements Serializable {

    public String nome;
    public String local;
    public String dia;
    public List<Banda> bandas;
    public String hora;


    public Evento(String nome, String local, String dia, List<Banda> bandas, String hora) {
        this.nome = nome;
        this.local = local;
        this.dia = dia;
        this.bandas = bandas;
        this.hora = hora;
    }
}
