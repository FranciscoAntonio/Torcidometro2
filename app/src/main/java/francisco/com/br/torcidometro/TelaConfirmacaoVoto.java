package francisco.com.br.torcidometro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TelaConfirmacaoVoto extends AppCompatActivity {

    TextView txtNomeBanda;
    Intent intent;
    String nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_confirmacao_voto);

        txtNomeBanda= (TextView)findViewById(R.id.txtNomeBanda);

        intent=getIntent();
        nome=intent.getStringExtra("nomeBanda");

        txtNomeBanda.setText("Você votou na Banda "+ nome);

    }
}
