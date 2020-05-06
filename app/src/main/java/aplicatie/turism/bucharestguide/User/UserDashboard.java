package aplicatie.turism.bucharestguide.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

import aplicatie.turism.bucharestguide.HelperClasses.HomeAdapter.CategoriesAdapter;
import aplicatie.turism.bucharestguide.HelperClasses.HomeAdapter.CategoriesHelperClass;
import aplicatie.turism.bucharestguide.HelperClasses.HomeAdapter.FeaturedAdapter;
import aplicatie.turism.bucharestguide.HelperClasses.HomeAdapter.FeaturedHelperClass;
import aplicatie.turism.bucharestguide.R;

public class UserDashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    RecyclerView featRecycler;
    RecyclerView featRecycler2;
    RecyclerView.Adapter adapter;
    RecyclerView.Adapter adapter2;

    //Drawer menu
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_dashboard);

        featRecycler = findViewById(R.id.featured_recyclerRV);
        featRecycler2 = findViewById(R.id.categoriesRV);

        featRecycler();

        //Menu hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);

        //Navigation Drawer
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);

    }


    private void featRecycler() {

        featRecycler.setHasFixedSize(true);
        featRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        featRecycler2.setHasFixedSize(true);
        featRecycler2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        ArrayList<FeaturedHelperClass> featuredLocations = new ArrayList<>();
        ArrayList<CategoriesHelperClass> categoriesLocations = new ArrayList<>();

        featuredLocations.add(new FeaturedHelperClass(R.drawable.casa_poporului, "Casa Poporului"," Casa Poporului with an arhitectural style of Socialist Realism"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.herastrau_park, "Herastrau Park","The biggest park in Bucharest"));
        featuredLocations.add(new FeaturedHelperClass(R.drawable.old_town, "Old Town","The central part of the capital filled with restaurants and bars"));

        categoriesLocations.add(new CategoriesHelperClass(R.drawable.restaurant_img,"Restaurant"));
        categoriesLocations.add(new CategoriesHelperClass(R.drawable.restaurant_img,"Restaurant"));
        categoriesLocations.add(new CategoriesHelperClass(R.drawable.restaurant_img,"Restaurant"));


        adapter = new FeaturedAdapter(featuredLocations);
        featRecycler.setAdapter(adapter);

        adapter2 = new CategoriesAdapter(categoriesLocations);
        featRecycler2.setAdapter(adapter2);

    }

    public void menuIcon(View view) {
        if(drawerLayout.isDrawerVisible(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else drawerLayout.openDrawer(GravityCompat.START);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()){
            case R.id.nav_points_of_interests:
                Intent intent1 = new Intent(getApplicationContext(), PointsOfInterests.class);
                startActivity(intent1);
                break;
            case R.id.nav_restaurants:
                Intent intent2 = new Intent(getApplicationContext(), Restaurants.class);
                startActivity(intent2);
                break;
        }

        return true;
    }


}
