package aplicatie.turism.bucharestguide.Common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import aplicatie.turism.bucharestguide.LoginForm;
import aplicatie.turism.bucharestguide.R;
import aplicatie.turism.bucharestguide.User.UserDashboard;


public class SplashScreen extends AppCompatActivity {


    private static int SPLASH_TIMER = 5000;

    ImageView backgroundImage;
    TextView developedByLine;
    //Animations
    Animation sideAnim, bottomAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_screen);

        backgroundImage = findViewById(R.id.background_image);
        developedByLine = findViewById(R.id.developedbyTV);

        sideAnim = AnimationUtils.loadAnimation(this,R.anim.side_anim);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.buttom_anim);

        backgroundImage.setAnimation(sideAnim);
        developedByLine.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, LoginForm.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_TIMER);
    }
}
