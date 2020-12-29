package com.belajar;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.GridViewHolder> {
    private ArrayList<Task> tasks = new ArrayList<>();
    private Context context;
    private String mode;
    public TaskAdapter(ArrayList<Task> tasks, Context context,String mode) {
        this.tasks = tasks;
        this.context = context;
        this.mode = mode;
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_layout,parent,false);
        return new GridViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, final int position) {
        final Task task = tasks.get(position);

        if(mode.equalsIgnoreCase(task.status)){
            holder.imgTask.setImageResource(task.img);
            holder.tvName.setText(task.nama);

            holder.btnSelesai.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    task.isDone = true;
                    task.status = "selesai";
                }
            });

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context,editTask.class);
                    intent.putExtra("tasks",tasks);
                    intent.putExtra("index",position);
                    context.startActivity(intent);
                }
            });
        }
        else{
            if(task.isDone){
                holder.btnSelesai.setVisibility(View.INVISIBLE);
            }
            holder.tvName.setVisibility(View.INVISIBLE);
            holder.imgTask.setVisibility(View.INVISIBLE);
            holder.btnSelesai.setVisibility(View.INVISIBLE);
        }

    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView imgTask;
        TextView tvName;
        Button btnSelesai;
        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            imgTask = itemView.findViewById(R.id.imgTask);
            tvName = itemView.findViewById(R.id.tvNameTask);
            btnSelesai = itemView.findViewById(R.id.btnSelesai);
        }
    }

    private interface OnClickCallback{
        void click(Task task);
    }

    private View.OnClickListener onClickListener;

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }
}
