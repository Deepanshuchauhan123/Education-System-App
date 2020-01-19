package com.example.app_deepanshu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ActivitiesAdapter extends RecyclerView.Adapter<ActivitiesAdapter.ViewHolder> {

    private ArrayList<ActivitiesModel>activitiesModels=new ArrayList<>();
    private Context context;


    public ActivitiesAdapter(Context context, ArrayList<ActivitiesModel> activitiesModels){
        this.activitiesModels=activitiesModels;
        this.context=context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.activities_list_item, parent, false);
        return new ActivitiesAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.notice1.setText(activitiesModels.get(position).getNotice());
        holder.venue1.setText(activitiesModels.get(position).getVenue());
        holder.stud1.setText(activitiesModels.get(position).getStudent());
        holder.teach1.setText(activitiesModels.get(position).getTeacher());
    }

    @Override
    public int getItemCount() {
        return activitiesModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView notice1,venue1,stud1,teach1;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            notice1=(TextView)itemView.findViewById(R.id.notice);
            venue1=(TextView)itemView.findViewById(R.id.venue);
            stud1=(TextView)itemView.findViewById(R.id.student);
            teach1=(TextView)itemView.findViewById(R.id.teacher);
        }
    }
}
