package aplicatie.turism.bucharestguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.opengl.EGLDisplay;
import android.opengl.ETC1;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import aplicatie.turism.bucharestguide.User.User;

public class LoginForm extends AppCompatActivity {

    EditText edtID, edtPassword;
    Button btnSignIn;
    private static final String TAG = "LoginForm";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);

        edtPassword = findViewById(R.id.passwordET);
        edtID = findViewById(R.id.idET);
        btnSignIn = findViewById(R.id.signINBTN);

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference userRef = database.getReference("User");

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                userRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        // Get user info
                        User user = dataSnapshot.child(edtID.getText().toString()).getValue(User.class);
                        if(user.getPassword().equals(edtPassword.getText().toString())){
                            Toast.makeText(LoginForm.this, "Succes", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(LoginForm.this, "Fail", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

    }

    public void signupActivity(View view) {
        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);
    }
}
