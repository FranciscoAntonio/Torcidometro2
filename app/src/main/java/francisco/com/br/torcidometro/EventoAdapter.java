package francisco.com.br.torcidometro;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Renato on 08/06/2016.
 */
public class EventoAdapter extends BaseAdapter{
    Context ctx;
    List<Evento> eventos;

    public EventoAdapter(Context ctx, List<Evento> eventos) {
        this.ctx = ctx;
        this.eventos = eventos;
    }

    @Override
    public int getCount() {
        return eventos.size();
    }

    @Override
    public Object getItem(int position) {
        return eventos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 1 passo
        Evento evento = eventos.get(position);
        // 2 passo
        ViewHolder holder=null;
        if(convertView == null){
            convertView = LayoutInflater.from(ctx).inflate(R.layout.item_evento,null);
            holder= new ViewHolder();
            holder.txtNomeEvento= (TextView)convertView.findViewById(R.id.txtNomeEvento);
            holder.txtLocalEvento= (TextView)convertView.findViewById(R.id.txtLugarEvento);
            convertView.setTag(holder);
        }
        else{
            holder=(ViewHolder)convertView.getTag();
        }


        // 3 passo

        Resources res= ctx.getResources();
        TypedArray logos= res.obtainTypedArray(R.array.logos);


        holder.txtNomeEvento.setText(evento.nome);
        holder.txtLocalEvento.setText(evento.local);


        // 4 passo
        return convertView;
    }

    static class ViewHolder{
        TextView txtNomeEvento;
        TextView txtLocalEvento;
    }
}
