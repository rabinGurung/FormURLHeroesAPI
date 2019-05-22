package com.softwarica.formurlheroesapi;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class RecyclerAdapter  extends RecyclerView.Adapter<RecyclerAdapter.Viewhold> {
    private Context context;
    private List list = new ArrayList();

    public RecyclerAdapter(Context context, List list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Viewhold onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.selectview,parent,false);
        return  new Viewhold(view);
        }

    @Override
    public void onBindViewHolder(@NonNull Viewhold viewhold, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class Viewhold extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView name,desc;
        public Viewhold(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.profileImage);
            name = itemView.findViewById(R.id.profilename);
            desc = itemView.findViewById(R.id.profiledescription);
        }
    }
}
