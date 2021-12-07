package com.example.plasma5.Adapters;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.plasma5.DataModels.RequestDataModel;
import com.example.plasma5.R;

import java.util.List;

public class RequestAdapter extends RecyclerView.Adapter<RequestAdapter.myviewholder> {

    RequestDataModel[]dataModels;

    public RequestAdapter(List<RequestDataModel> dataModels, Context context) {
        this.dataModels = dataModels.toArray(new RequestDataModel[0]); 
        this.context = context;
    }

    Context context;

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.request_item_layout,parent,false);
        return new myviewholder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {

        RequestDataModel requestDataModel=dataModels[position];
        holder.tv.setText(requestDataModel.getName());
        holder.tv.setText(requestDataModel.getStrEmail());
        Glide.with(holder.img.getContext()).load("https://plasmainda.000webhostapp.com/images/"+requestDataModel.getImage()).into(holder.img);



    }

    @Override
    public int getItemCount() {
        return dataModels.length;
    }

    public class myviewholder extends RecyclerView.ViewHolder {

        ImageView  img;
        TextView tv;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            img = (ImageView)itemView.findViewById(R.id.image);
            tv = (TextView)itemView.findViewById(R.id.message);

        }
    }
}
