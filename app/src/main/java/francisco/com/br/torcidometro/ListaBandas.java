package francisco.com.br.torcidometro;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class ListaBandas extends AppCompatActivity {

    ListView listView;
    Intent intent;
    BandaAdapter adapter;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listView = new ListView(this);
        setContentView(listView);

        intent = getIntent();
        Evento evento = (Evento) intent.getSerializableExtra("evento");

        adapter = new BandaAdapter(this, evento.bandas);


        intent = new Intent(this, TelaConfirmacaoVoto.class);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                Banda banda = (Banda) adapterView.getItemAtPosition(position);
                intent.putExtra("nomeBanda", banda.nome);
                startActivity(intent);

            }
        });

        final int PADDING = 8;
        TextView txtHeader = new TextView(this);
        txtHeader.setBackgroundColor(Color.BLACK);
        txtHeader.setTextColor(Color.WHITE);
        txtHeader.setText(R.string.texto_cabecalhoBanda);
        txtHeader.setPadding(PADDING, PADDING, 0, PADDING);
        listView.addHeaderView(txtHeader);
        listView.setAdapter(adapter);

        TextView txtFooter = new TextView(this);
        txtFooter.setText(getResources().getQuantityString(
                R.plurals.texto_rodapeBanda,
                adapter.getCount(),
                adapter.getCount()));
        txtFooter.setBackgroundColor(Color.BLACK);
        txtFooter.setGravity(Gravity.RIGHT);
        txtFooter.setTextColor(Color.WHITE);
        txtFooter.setPadding(0, PADDING, PADDING, PADDING);
        listView.addFooterView(txtFooter);

        // EmptyView sรณ funciona com ListActivity...
        listView.setEmptyView(findViewById(android.R.id.empty));
    }
}
