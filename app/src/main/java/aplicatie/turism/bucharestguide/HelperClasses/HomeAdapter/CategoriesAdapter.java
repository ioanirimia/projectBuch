package aplicatie.turism.bucharestguide.HelperClasses.HomeAdapter;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import aplicatie.turism.bucharestguide.R;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder> {

    ArrayList<CategoriesHelperClass> categoriesLocations;

    public CategoriesAdapter(ArrayList<CategoriesHelperClass> categoriesLocations) {
        this.categoriesLocations = categoriesLocations;
    }

    @NonNull
    @Override
    public CategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_card_design, parent, false);
        CategoriesViewHolder categoriesViewHolder = new CategoriesViewHolder(view);
        return categoriesViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesViewHolder holder, int position) {
        CategoriesHelperClass categoriesHelperClass = categoriesLocations.get(position);

        holder.image.setImageResource(categoriesHelperClass.getImage());
        holder.title.setText(categoriesHelperClass.getTitle());

    }

    @Override
    public int getItemCount() {
        return categoriesLocations.size();
    }

    public static class CategoriesViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView title;

        public CategoriesViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imagineRestaurant);
            title = itemView.findViewById(R.id.categoryTitle);
        }
    }
}
