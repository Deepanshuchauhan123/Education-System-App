package com.example.app_deepanshu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SchemesAdapter extends RecyclerView.Adapter<SchemesAdapter.ViewHolder> {

    private ArrayList<Schemes_Model> schemes_models=new ArrayList<>();
    private Context context;
    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        mListener=listener;
    }
    public SchemesAdapter(Context context, ArrayList<Schemes_Model> schemes_models) {

        this.schemes_models=schemes_models;
        this.context=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.schemes_list_item, parent, false);
        return new SchemesAdapter.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.schemename.setText(schemes_models.get(position).getTitle());
        holder.date.setText(schemes_models.get(position).getCat());
        }

    @Override
    public int getItemCount() {
        return schemes_models.size() ;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView schemename,date;
        public LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            schemename=(TextView)itemView.findViewById(R.id.Namess);
            date=(TextView)itemView.findViewById(R.id.Date);
            linearLayout=(LinearLayout)itemView.findViewById(R.id.linearlayout);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mListener!=null){
                        int position =getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION){
                            mListener.onItemClick(position);
                        }
                    }
                }
            });

        }
    }
}
