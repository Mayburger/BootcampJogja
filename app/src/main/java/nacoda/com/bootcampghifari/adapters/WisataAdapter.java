package nacoda.com.bootcampghifari.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import nacoda.com.bootcampghifari.R;
import nacoda.com.bootcampghifari.asynctask.AsyncTaskLoadImage;
import nacoda.com.bootcampghifari.fonts.Fonts;
import nacoda.com.bootcampghifari.gson.GsonWisata;

/**
 * Created by Mayburger on 4/19/2017.
 */

public class WisataAdapter extends RecyclerView.Adapter<WisataAdapter.ViewHolder> {

    private Context context;
    private List<GsonWisata.Data> dataWisata;

    public WisataAdapter(Context context, List<GsonWisata.Data> dataWisata) {
        this.context = context;
        this.dataWisata = dataWisata;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_wisata, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.tvNamaWisata.setText(dataWisata.get(position).nama_pariwisata);
        Fonts.RobotoLight(context, holder.tvNamaWisata);
        new AsyncTaskLoadImage(holder.ivGambarWisata, context).execute(dataWisata.get(position).gambar_pariwisata);

    }

    @Override
    public int getItemCount() {
        return dataWisata.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvNamaWisata;
        ImageView ivGambarWisata;

        public ViewHolder(View itemView) {
            super(itemView);

            tvNamaWisata = itemView.findViewById(R.id.tvNamaWisata);
            ivGambarWisata = itemView.findViewById(R.id.ivGambarWisata);


        }
    }
}
