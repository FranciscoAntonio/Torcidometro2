package francisco.com.br.torcidometro;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Evento>eventos=new ArrayList<Evento>();
    List<Banda> bandas1 = new ArrayList<Banda>();
    List<Banda> bandas2 = new ArrayList<Banda>();
    List<Banda> bandas3 = new ArrayList<Banda>();
    EventoAdapter adapterEvento;

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listView = new ListView(this);
        setContentView(listView);

        // Lista de Bandas do Evento SHOW FAP
        bandas1.add(new Banda("Engenheiro do Hawaii","SHOW FAP",0));
        bandas1.add(new Banda("Legião Urbana", "SHOW FAP", 1));
        bandas1.add(new Banda("Scorpions","SHOW FAP",2));
        bandas1.add(new Banda("Capital Inicial","SHOW FAP",3));
        bandas1.add(new Banda("Titãs","SHOW FAP",4));
        bandas1.add(new Banda("Biquine Cavadão","SHOW FAP",5));


        // Lista de Bandas do Evento SHOW FJN
        bandas2.add(new Banda("Engenheiro do Hawaii","SHOW FAP",0));
        bandas2.add(new Banda("Legião Urbana", "SHOW FAP", 1));

        // Lista de Bandas do Evento SHOW UNILEÃO
        bandas3.add(new Banda("Scorpions","SHOW FAP",2));
        bandas3.add(new Banda("Capital Inicial","SHOW FAP",3));

        // Criação da lista de eventos
        eventos.add(new Evento("SHOW FAP","FAP","08/06/2016",bandas1,"22:00"));
        eventos.add(new Evento("SHOW FJN","FJN","08/06/2016",bandas2,"22:00"));
        eventos.add(new Evento("SHOW UNILEÃO","UNILEÃO","08/06/2016",bandas3,"22:00"));

        adapterEvento= new EventoAdapter(this,eventos);
        listView.setAdapter(adapterEvento);

        final Intent intent= new Intent(this,ListaBandas.class);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
               Evento evento=(Evento) adapterView.getItemAtPosition(position);
                intent.putExtra("evento",evento);
                startActivity(intent);

                // Banda banda = (Banda) adapterView.getItemAtPosition(position);
                //intent.putExtra("nomeBanda",banda.nome);
                //startActivity(intent);

              //  Toast.makeText(MainActivity.this,
                    //    banda.nome + "-" + banda.evento, Toast.LENGTH_SHORT).show();

            }
        });

        final int PADDING = 8;
        TextView txtHeader = new TextView(this);
        txtHeader.setBackgroundColor(Color.BLACK);
        txtHeader.setTextColor(Color.WHITE);
        txtHeader.setText(R.string.texto_cabecalho);
        txtHeader.setPadding(PADDING, PADDING, 0, PADDING);
        listView.addHeaderView(txtHeader);

        TextView txtFooter = new TextView(this);
        txtFooter.setText(getResources().getQuantityString(
                R.plurals.texto_rodape,
                adapterEvento.getCount(),
                adapterEvento.getCount()));
        txtFooter.setBackgroundColor(Color.BLACK);
        txtFooter.setTextColor(Color.WHITE);
        txtFooter.setGravity(Gravity.RIGHT);
        txtFooter.setPadding(0, PADDING, PADDING, PADDING);
        listView.addFooterView(txtFooter);

        // EmptyView sรณ funciona com ListActivity...
        listView.setEmptyView(findViewById(android.R.id.empty));
    }

}
