package com.example.app_deepanshu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AttendanceAdapter extends RecyclerView.Adapter<AttendanceAdapter.ViewHolder> {

private ArrayList<AttendanceModel>attendanceModels=new ArrayList<>();
private Context context;
    public  AttendanceAdapter(Context context, ArrayList<AttendanceModel>attendanceModels){
this.attendanceModels=attendanceModels;
this.context=context;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.students_list_item, viewGroup, false);
        return new AttendanceAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        viewHolder.names.setText(attendanceModels.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return attendanceModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private  TextView names;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            names=(TextView)itemView.findViewById(R.id.name);
        }
    }
}
