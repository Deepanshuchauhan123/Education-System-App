package com.example.app_deepanshu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.postViewHolder>{

    private Context context;
    private ArrayList<Display_teach> display_teaches=new ArrayList<>();


    public PostAdapter(Context context, ArrayList<Display_teach> display_teaches) {
        this.context = context;
        this.display_teaches = display_teaches;
    }

    @NonNull
    @Override
    public postViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
       View view = layoutInflater.inflate(R.layout.teacher_list_item, parent, false);
        return new postViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull postViewHolder holder, int position) {

        holder.names.setText(display_teaches.get(position).getName());
        holder.email.setText(display_teaches.get(position).getEmail());
        holder.mobile.setText(""+display_teaches.get(position).getMobile_number());
        holder.address.setText(display_teaches.get(position).getAddress());
        holder.Adhaar.setText(""+display_teaches.get(position).getAadhar());
        holder.State.setText(display_teaches.get(position).getState());
    }
    @Override
    public int getItemCount() {
        return display_teaches.size();
    }
    public class postViewHolder extends RecyclerView.ViewHolder {
        TextView names;
        TextView email;
        TextView mobile;
        TextView address;
        TextView Adhaar;
        TextView State;

        public postViewHolder(@NonNull View itemView)
        {
            super(itemView);
            names = itemView.findViewById(R.id.Name);
            email = itemView.findViewById(R.id.e_mail);
            mobile = itemView.findViewById(R.id.mobile1);
            address = itemView.findViewById(R.id.address);
            Adhaar=itemView.findViewById(R.id.Adhaar);
            State=itemView.findViewById(R.id.state);
        }
    }
}
