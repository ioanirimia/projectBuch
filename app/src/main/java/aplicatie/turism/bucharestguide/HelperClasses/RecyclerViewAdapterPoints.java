package aplicatie.turism.bucharestguide.HelperClasses;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import aplicatie.turism.bucharestguide.R;
import aplicatie.turism.bucharestguide.User.Point_Activity_Description;
import aplicatie.turism.bucharestguide.User.Points;

public class RecyclerViewAdapterPoints extends RecyclerView.Adapter<RecyclerViewAdapterPoints.MyViewHolder> {


    private Context mContext;
    private List<Points> mData;

    public RecyclerViewAdapterPoints(Context mContext, List<Points> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardview_points, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.tv_points_title.setText(mData.get(position).getTitle());
        holder.img_points_thumbnail.setImageResource(mData.get(position).getThumbnail());

        //Click Listener

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(mContext, Point_Activity_Description.class);


                intent.putExtra("PointTitle", mData.get(position).getTitle());
                intent.putExtra("Category", mData.get(position).getCategory());
                intent.putExtra("Description", mData.get(position).getDescription());
                intent.putExtra("Thumbnail", mData.get(position).getThumbnail());
                mContext.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_points_title;
        ImageView img_points_thumbnail;
        CardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_points_title = itemView.findViewById(R.id.pointTitleTV);
            img_points_thumbnail = itemView.findViewById(R.id.pointIMGV);
            cardView = itemView.findViewById(R.id.cardViewIDPointsOfInterests);
        }
    }
}
