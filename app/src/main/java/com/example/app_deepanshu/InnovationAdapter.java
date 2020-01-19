package com.example.app_deepanshu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class InnovationAdapter extends RecyclerView.Adapter<InnovationAdapter.ViewHolder> {

  private ArrayList<InnovationModel> innovationModels=new ArrayList<>();
  private Context context;

    public InnovationAdapter(Context context, ArrayList<InnovationModel> innovationModels) {
   this.innovationModels=innovationModels;
   this.context=context;
    }

    @NonNull
    @Override
    public InnovationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =LayoutInflater.from(parent.getContext()).inflate(R.layout.innovation_list_item, parent, false);
        return new InnovationAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InnovationAdapter.ViewHolder holder, int position) {

        holder.prob_title.setText(innovationModels.get(position).getProbTitle());
        holder.sol_title.setText(innovationModels.get(position).getSolTitle());
        holder.tech.setText(innovationModels.get(position).getTechnique());
    }

    @Override
    public int getItemCount() {
        return innovationModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView prob_title,sol_title,tech;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            prob_title=(TextView)itemView.findViewById(R.id.pt);
            sol_title=(TextView)itemView.findViewById(R.id.st);
            tech=(TextView)itemView.findViewById(R.id.tech);
        }
    }
}
