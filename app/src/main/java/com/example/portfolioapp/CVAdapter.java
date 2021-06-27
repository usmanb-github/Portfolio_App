package com.example.portfolioapp;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CVAdapter extends RecyclerView.Adapter<CVAdapter.CVViewHolder> {

    List<CVItem> mdata;

    public CVAdapter(List<CVItem> mdata) {
        this.mdata = mdata;
    }

    @NonNull
    @Override
    public CVAdapter.CVViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cv, parent, false);
        return new CVViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CVAdapter.CVViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public class CVViewHolder extends RecyclerView.ViewHolder{

        TextView text, description;

        public CVViewHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.title2);
            description = itemView.findViewById(R.id.description);

            itemView.findViewById(R.id.imageView5).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.addCategory(Intent.CATEGORY_BROWSABLE);
                    intent.setData(Uri.parse("https://www.linkedin.com/in/usmanbasharat/"));
                    itemView.getContext().startActivity(intent);
                }
            });

        }
    }
}
