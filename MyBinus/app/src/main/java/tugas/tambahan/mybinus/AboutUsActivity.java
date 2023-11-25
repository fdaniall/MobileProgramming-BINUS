package tugas.tambahan.mybinus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AboutUsActivity extends AppCompatActivity {

    private Button homeBtn;
    private Button editBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        homeBtn = findViewById(R.id.homeButton);
        editBtn = findViewById(R.id.editButton);

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHome();
            }
        });

        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProfile();
            }
        });
    }
    public void openHome() {
        Intent homeIntent = new Intent(this, MainActivity.class);
        startActivity(homeIntent);
    }

    public void openProfile() {
        Intent profileIntent = new Intent(this, ProfileActivity.class);
        startActivity(profileIntent);
    }
}