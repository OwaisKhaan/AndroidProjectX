package com.example.programmers.fyp.MainRecycler;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.programmers.fyp.Doctor_Profile;
import com.example.programmers.fyp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Programmers on 10/02/2018.
 */

public class MainReyclerItemAdapter extends RecyclerView.Adapter<MainReyclerItemAdapter.MainViewHolder> {
    private Context context;
    private ArrayList<MainRecyclerItems> list ;

    public MainReyclerItemAdapter(Context context, ArrayList<MainRecyclerItems> list)
    {
this.context = context;
this.list = list;
    }
    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.from(parent.getContext()).inflate(R.layout.mainactivity_recyclerviewitems,parent,false);
        MainViewHolder mainviewHolder = new MainViewHolder(view);

        return mainviewHolder;
    }

    @Override
    public void onBindViewHolder(MainReyclerItemAdapter.MainViewHolder holder, int position) {
final MainRecyclerItems mainRecyclerItems = list.get(position);
holder.name.setText(mainRecyclerItems.name);
holder.id.setText(Integer.toString(mainRecyclerItems.id));
holder.fee.setText(Integer.toString(mainRecyclerItems.fee));
holder.specialization.setText(mainRecyclerItems.specialization);
holder.location.setText(mainRecyclerItems.address);
        String FullUrl = "http://10.0.2.2/"+mainRecyclerItems.getPic();
        Picasso.with(context)
                .load(FullUrl)
                .placeholder(R.drawable.aaa)
                .into(holder.pic);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Doctor_Profile.class);
                intent.putExtra("MainRecyclerItems",mainRecyclerItems);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MainViewHolder extends RecyclerView.ViewHolder {
        public CardView cardView;
        public ImageView pic;
        public TextView name,specialization,location,id,fee;


        public MainViewHolder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.card_view);
            pic = itemView.findViewById(R.id.imageView);
            name = itemView.findViewById(R.id.name);
            specialization = itemView.findViewById(R.id.specialization);
            location = itemView.findViewById(R.id.location);
            id = itemView.findViewById(R.id.docID);
            fee = itemView.findViewById(R.id.fee);

        }
    }
}
