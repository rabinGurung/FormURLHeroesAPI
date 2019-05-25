package com.softwarica.formurlheroesapi;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.StrictMode;
import android.renderscript.ScriptGroup;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class RecyclerAdapter  extends RecyclerView.Adapter<RecyclerAdapter.Viewhold> {
    private Context context;
    private List<Employee> list;

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
    private void StrictMode(){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }
    @Override
    public void onBindViewHolder(@NonNull Viewhold parent, int i) {
        if(!list.isEmpty()){
            parent.name.setText(list.get(i).getName());
            parent.desc.setText(list.get(i).getDesc());
            StrictMode();
            String path = MainActivity.ServerURL+"uploads/"+list.get(i).getImage();
            System.out.println(path);
            try {
                URL uri = new URL(path);
                Bitmap bit = BitmapFactory.decodeStream((InputStream)uri.getContent());
                parent.imageView.setImageBitmap(bit);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Viewhold extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView name,desc;
        public Viewhold(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.yourimage);
            name = itemView.findViewById(R.id.profilename);
            desc = itemView.findViewById(R.id.profiledescription);
        }
    }
}
