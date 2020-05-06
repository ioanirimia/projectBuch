package aplicatie.turism.bucharestguide.User;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import aplicatie.turism.bucharestguide.HelperClasses.RecyclerViewAdapterPoints;
import aplicatie.turism.bucharestguide.R;

public class PointsOfInterests extends AppCompatActivity {

    List<Points> listPoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_points_of_interests);

        listPoints = new ArrayList<>();
        listPoints.add(new Points("Muzeul Antipa","Museum312321312312", "Descriptiosafasfasfasfasfasfasn", R.drawable.antipa));
        listPoints.add(new Points("Casa Poporului","Category Point", "Description", R.drawable.casa_poporului));
        listPoints.add(new Points("Muzeul Taranului Roman","Category Point", "Description", R.drawable.muzeul_taranului_roman));
        listPoints.add(new Points("Palatul Cotroceni","Category Point", "Description", R.drawable.cotroceni));
        listPoints.add(new Points("Parcul Herastrau","Category Point", "Description", R.drawable.herastrau_park));
        listPoints.add(new Points("Piata Universitatii","Category Point", "Description", R.drawable.piata_universitatiijpg));

        RecyclerView myrv = (RecyclerView) findViewById(R.id.recyclerview_id_puncteInteres);
        RecyclerViewAdapterPoints myAdapter = new RecyclerViewAdapterPoints(this, listPoints);
        myrv.setLayoutManager(new GridLayoutManager(this,2));
        myrv.setAdapter(myAdapter);
    }
}
