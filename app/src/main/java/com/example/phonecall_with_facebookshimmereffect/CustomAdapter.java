package com.example.phonecall_with_facebookshimmereffect;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.RecyclerViewHolder>{

    String nameData[], idData[];
    int image[];
    Context context;

    public CustomAdapter(Context ct, String name[], String id[], int image[]){
        context = ct;
        nameData = name;
        idData = id;
        this.image = image;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.student_sample_adapter, parent, false);

        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.nameTextView.setBackground(null);
        holder.nameTextView.setText(nameData[position]);
        holder.idTextView.setBackground(null);
        holder.idTextView.setText(idData[position]);
        holder.imageView.setBackground(null);
        holder.imageView.setImageResource(image[position]);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position == 0) {
                    callHim("01684762673");
                } else if (position == 1) {
                    callHim("01521428631");
                } else if (position == 2) {
                    callHim("01988658168");
                } else if (position == 3) {
                    callHim("01521406500");
                } else if (position == 4) {
                    callHim("01723361557");
                } else if (position == 5) {
                    callHim("01773766303");
                } else if (position == 6) {
                    callHim("01772666487");
                } else if (position == 7) {
                    callHim("01911432556");
                } else if (position == 8) {
                    callHim("01740119568");
                } else if (position == 9) {
                    callHim("01521241279");
                } else if (position == 10) {
                    callHim("01521408011");
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return nameData.length;
    }

    public void callHim(String phoneNumber){
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:"+phoneNumber));

        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.CALL_PHONE}, 1);
        } else {
            context.startActivity(callIntent);
        }
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder{
        TextView nameTextView, idTextView;
        ImageView imageView;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.headerNameID);
            idTextView = itemView.findViewById(R.id.headerStudentID);
            imageView = itemView.findViewById(R.id.imageViewID);
        }
    }
}
