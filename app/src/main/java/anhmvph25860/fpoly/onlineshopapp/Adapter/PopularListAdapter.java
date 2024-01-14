package anhmvph25860.fpoly.onlineshopapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;

import java.util.ArrayList;

import anhmvph25860.fpoly.onlineshopapp.Activity.DetailActivity;
import anhmvph25860.fpoly.onlineshopapp.Domain.PopularDomain;
import anhmvph25860.fpoly.onlineshopapp.R;

public class PopularListAdapter extends RecyclerView.Adapter<PopularListAdapter.Viewholder> {
    ArrayList<PopularDomain> items;
    Context context;

    public PopularListAdapter(ArrayList<PopularDomain> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public PopularListAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_pop_list, parent, false);
        context = parent.getContext();
        return new Viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularListAdapter.Viewholder holder, int position) {
        holder.tvTitle.setText(items.get(position).getTitle());
        holder.tvFee.setText("$"+items.get(position).getPrice());
        holder.tvScore.setText(""+ items.get(position).getScore());

        int drawableResourceId = holder.itemView.getResources().getIdentifier(items.get(position).getPicURL(),
                "drawable", holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext()).load(drawableResourceId)
                .transform(new GranularRoundedCorners(30, 30, 0, 0))
                .into(holder.pic);

        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(holder.itemView.getContext(), DetailActivity.class);
            intent.putExtra("object", items.get(position));
            holder.itemView.getContext().startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class Viewholder  extends RecyclerView.ViewHolder{
        TextView tvTitle, tvFee, tvScore;
        ImageView pic;
        public Viewholder(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.titleTxt);
            tvFee = itemView.findViewById(R.id.tvFee);
            tvScore = itemView.findViewById(R.id.scoreTxt);
            pic = itemView.findViewById(R.id.pic);
        }
    }
}
