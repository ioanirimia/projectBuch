package aplicatie.turism.bucharestguide.User;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.CaseMap;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import aplicatie.turism.bucharestguide.R;

public class Point_Activity_Description extends AppCompatActivity {

    private TextView tvtitle, tvdescription, tvCategory;
    private ImageView imgthumb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_point___description);

        tvtitle = findViewById(R.id.pointsTitle);
        tvdescription = findViewById(R.id.pointsDescription);
        tvCategory = findViewById(R.id.pointsCategory);
        imgthumb = findViewById(R.id.pointThumbnail);

        Intent intent = getIntent();
        String Title = intent.getExtras().getString("PointTitle");
        String Category = intent.getExtras().getString("Category");
        String Description = intent.getExtras().getString("Description");
        int Thumbnail = intent.getExtras().getInt("Thumbnail");

        tvCategory.setText(Category);
        tvtitle.setText(Title);
        tvdescription.setText(Description);
        imgthumb.setImageResource(Thumbnail);
    }
}
