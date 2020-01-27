package com.thanhfong47.nutritiontracker.exercise;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.thanhfong47.nutritiontracker.R;

import java.util.List;

public class ExerciseDashboardAdapter extends RecyclerView.Adapter<ExerciseDashboardAdapter.CustomViewHolder> implements ExerciseDashboardContract.View {
    private List<Exercise> exerciseList;
    private Context context;
    private ExerciseDashboardContract.Presenter presenter;
    public ExerciseDashboardAdapter(Context context, List<Exercise> exerciseList){
        this.context = context;
        this.exerciseList = exerciseList;
    }

    @Override
    public Context getContext() {
        return context;
    }

    @Override
    public void initUI(View view) {

    }

    @Override
    public void setDataToRecyclerView(List<ParentExercise> parentExerciseList) {

    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

        TextView tvExerciseName,tvUserInput,tvCalories,tvDuration;
        ImageView ivDelete;
        CustomViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            tvExerciseName = mView.findViewById(R.id.tvExerciseName);
            tvUserInput = mView.findViewById(R.id.tvUserInput);
            tvCalories = mView.findViewById(R.id.tvCalories);
            tvDuration = mView.findViewById(R.id.tvDuration);
            ivDelete = mView.findViewById(R.id.ivDelete);
        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_exercise_vertical, parent, false);
        presenter = new ExerciseDashboardPresenterImpl(this);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CustomViewHolder holder, int position) {
        holder.tvExerciseName.setText(exerciseList.get(position).getName());
        holder.tvCalories.setText("Calories burned : "+exerciseList.get(position).getNfCalories());
        holder.tvDuration.setText("Duration : " + exerciseList.get(position).getDurationMin()+" (mins)");
        holder.tvUserInput.setText("("+exerciseList.get(position).getUserInput() +")");
        holder.ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case DialogInterface.BUTTON_POSITIVE:
                                presenter.deleteExercise(exerciseList.get(holder.getAdapterPosition()));
                                exerciseList.remove(holder.getAdapterPosition());
                                notifyDataSetChanged();
                                break;

                            case DialogInterface.BUTTON_NEGATIVE:
                                //No button clicked
                                break;
                        }
                    }
                };

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("Are you sure?").setPositiveButton("Yes", dialogClickListener)
                        .setNegativeButton("No", dialogClickListener).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return exerciseList.size();
    }

}