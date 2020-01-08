package com.example.app_deepanshu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SubAdapter extends RecyclerView.Adapter<SubAdapter.ViewHolder> {

    private ArrayList<Subject_Model_Teach> subject_model_teaches=new ArrayList<>();
    private Context context;
    public SubAdapter(Context context, ArrayList<Subject_Model_Teach> subject_model_teaches) {

        this.subject_model_teaches=subject_model_teaches;
        this.context=context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.schemes_list_item, parent, false);
        return new SubAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.subjects.setText(subject_model_teaches.get(position).getSubject());
        holder.classs.setText(subject_model_teaches.get(position).getClas());
        holder.stream.setText(subject_model_teaches.get(position).getStream());
        holder.batch.setText(subject_model_teaches.get(position).getBatch());
    }
    @Override
    public int getItemCount() {
        return subject_model_teaches.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView subjects,classs,stream,batch;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            subjects=(TextView)itemView.findViewById(R.id.one);
            classs=(TextView)itemView.findViewById(R.id.two);
            stream=(TextView)itemView.findViewById(R.id.three);
            batch=(TextView)itemView.findViewById(R.id.four);
        }
    }
}
