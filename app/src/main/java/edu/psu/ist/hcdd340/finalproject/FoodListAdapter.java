package edu.psu.ist.hcdd340.finalproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

public class FoodListAdapter extends
        RecyclerView.Adapter<FoodListAdapter.FoodViewHolder> {
    private final FoodData[] mFoodList;
    private final LayoutInflater mInflater;

    public FoodListAdapter(Context context, FoodData[] mFoodList) {
        this.mFoodList = mFoodList;
        mInflater = LayoutInflater.from(context);

    }

    @NonNull
    @Override
    public FoodListAdapter.FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.food_list_item, parent, false);
        return new FoodViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodListAdapter.FoodViewHolder holder, int position) {
        FoodData food = mFoodList[position];
        holder.foodImageView.setImageResource(food.getProfileImage());
        holder.foodTitleView.setText(food.getFoodName());
        holder.foodPhoneView.setText(food.getPhone());
        holder.foodEmailView.setText(food.getEmail());
    }

    @Override
    public int getItemCount() {
        return mFoodList.length;
    }

    class FoodViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView foodTitleView;
        public final ImageView foodImageView;
        public final TextView foodEmailView;
        public final TextView foodPhoneView;
        final FoodListAdapter mAdapter;

        public FoodViewHolder(@NonNull View itemView, FoodListAdapter adapter) {
            super(itemView);
            foodTitleView = itemView.findViewById(R.id.food_list_title_id);
            foodImageView = itemView.findViewById(R.id.food_list_image_id);
            foodEmailView = itemView.findViewById(R.id.campus_list_email);
            foodPhoneView = itemView.findViewById(R.id.campus_list_phone);
            this.mAdapter = adapter;

            foodTitleView.setOnClickListener(this);
            foodImageView.setOnClickListener(this);
            foodEmailView.setOnClickListener(this);
            foodPhoneView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            // Get the position of the item that was clicked.
            int mPosition = getLayoutPosition();
            // Use that to access the affected item in mWordList.
            String food = mFoodList[mPosition].getFoodName();
            Snackbar.make(foodTitleView,
                    food + " clicked!",
                    Snackbar.LENGTH_SHORT).show();

        }
    }
}



