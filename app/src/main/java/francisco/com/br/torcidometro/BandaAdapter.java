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
public class BandaAdapter extends BaseAdapter{

    Context ctx;
    List<Banda> bandas;

    public BandaAdapter(Context ctx, List<Banda> bandas) {
        this.ctx = ctx;
        this.bandas = bandas;
    }

    @Override
    public int getCount() {
        return bandas.size();
    }

    @Override
    public Object getItem(int position) {
        return bandas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 1 passo
        Banda banda = bandas.get(position);
        // 2 passo
        ViewHolder holder=null;
        if(convertView == null){
            convertView = LayoutInflater.from(ctx).inflate(R.layout.item_banda,null);
            holder= new ViewHolder();
            holder.imgLogo= (ImageView)convertView.findViewById(R.id.imgLogo);
            holder.txtNomeBanda= (TextView)convertView.findViewById(R.id.txtBanda);
            holder.txtEvento= (TextView)convertView.findViewById(R.id.txtEvento);
            convertView.setTag(holder);
        }
        else{
            holder=(ViewHolder)convertView.getTag();
        }


        // 3 passo

        Resources res= ctx.getResources();
        TypedArray logos= res.obtainTypedArray(R.array.logos);

        holder.imgLogo.setImageDrawable(logos.getDrawable(banda.id));
        holder.txtNomeBanda.setText(banda.nome);
        holder.txtEvento.setText(banda.evento);


        // 4 passo
        return convertView;
    }

    static class ViewHolder{
        ImageView imgLogo;
        TextView txtNomeBanda;
        TextView txtEvento;
    }
}
