package com.example.app_deepanshu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ReportsAdapter extends RecyclerView.Adapter<ReportsAdapter.ViewHolder> {

    private ArrayList<ReportModel>reportModels=new ArrayList<>();
    private Context context;
    public ReportsAdapter(Context context, ArrayList<ReportModel> reportModels) {

        this.context=context;
        this.reportModels=reportModels;
    }

    @NonNull
    @Override
    public ReportsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.report_list_item, parent, false);
        return new ReportsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.name.setText(reportModels.get(position).getName());
        holder.calss.setText(reportModels.get(position).getClas());
        holder.date.setText(reportModels.get(position).getDate());
        holder.behav.setText(reportModels.get(position).getBehaviour());
        holder.sugg.setText(reportModels.get(position).getSuggestions());
    }

    @Override
    public int getItemCount() {
        return reportModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name,calss,date,behav,sugg;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            name=(TextView)itemView.findViewById(R.id.named);
            calss=(TextView)itemView.findViewById(R.id.classd);
            date=(TextView)itemView.findViewById(R.id.dated);
            behav=(TextView)itemView.findViewById(R.id.beh);
            sugg=(TextView)itemView.findViewById(R.id.suggestion);

        }
    }
}
