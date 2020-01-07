package com.example.app_deepanshu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerView_teacher {
    public Context mcontext;
    private TeacherAdapter mteachersAdapter;
    public void setConfig(RecyclerView recyclerView, Context context,List<Display_teach> teachs,List<String>keys){
        mcontext= context;
        mteachersAdapter=new TeacherAdapter(teachs,keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mteachersAdapter);
    }

class TeacherItemView extends RecyclerView.ViewHolder{
    private TextView mName;
    private TextView mMobile;
    private TextView memail;
    private TextView maddress;
    private TextView Adhaar;
    private TextView State;

    private String key;
    public TeacherItemView(ViewGroup parent){
        super(LayoutInflater.from(mcontext)
                .inflate(R.layout.teacher_list_item,parent,false));

        mName=(TextView) itemView.findViewById(R.id.Name);
        mMobile=(TextView) itemView.findViewById(R.id.mobile1);
        memail=(TextView) itemView.findViewById(R.id.e_mail);
        maddress=(TextView) itemView.findViewById(R.id.address);
        Adhaar=(TextView)itemView.findViewById(R.id.Adhaar);
        State=(TextView) itemView.findViewById(R.id.state);
    }
    public void bind(Display_teach teach , String key){
        mName.setText(teach.getName());
        memail.setText(teach.getEmail());
        mMobile.setText(teach.getMobile_number());
        maddress.setText(teach.getAddress());
        Adhaar.setText(teach.getAadhar());
        State.setText(teach.getState());
    }
}
class TeacherAdapter extends RecyclerView.Adapter<TeacherItemView>{
    private List<Display_teach> mteacherList;
    private List<String> mkeys;

    public TeacherAdapter(List<Display_teach> mteacherList, List<String> mkeys) {
        this.mteacherList = mteacherList;
        this.mkeys = mkeys;
    }

    @NonNull
    @Override
    public TeacherItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TeacherItemView(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull TeacherItemView holder, int position) {

        holder.bind(mteacherList.get(position),mkeys.get(position));
    }

    @Override
    public int getItemCount() {
        return mteacherList.size();
    }
}

}
