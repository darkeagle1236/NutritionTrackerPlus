package com.thanhfong47.nutritiontracker.exercise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.thanhfong47.nutritiontracker.R;

import java.util.List;

public class ParentExerciseDashboardAdapter extends RecyclerView.Adapter<ParentExerciseDashboardAdapter.CustomViewHolder> {
    private List<ParentExercise> parentExerciseList;
    private Context context;
    private RecyclerView.RecycledViewPool viewPool;
    public ParentExerciseDashboardAdapter(Context context, List<ParentExercise> parentExerciseList){
        this.context = context;
        this.parentExerciseList = parentExerciseList;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

        TextView tvDate;
        RecyclerView rclvExercise;
        CustomViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            tvDate = mView.findViewById(R.id.tvParentDate);
            rclvExercise = mView.findViewById(R.id.rclvChildExercise);
        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_parent_exercise, parent, false);
        viewPool = new RecyclerView.RecycledViewPool();
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CustomViewHolder holder, int position) {
        System.out.println(parentExerciseList.get(holder.getAdapterPosition()).getDate());
        holder.tvDate.setText(parentExerciseList.get(position).getDate());
        holder.rclvExercise.setLayoutManager(new LinearLayoutManager(context,RecyclerView.HORIZONTAL,false));
        holder.rclvExercise.setAdapter(new ExerciseDashboardAdapter(context, parentExerciseList.get(position).getExerciseList()));
        holder.rclvExercise.setRecycledViewPool(viewPool);
    }

    @Override
    public int getItemCount() {
        return parentExerciseList.size();
    }

}
