package tugas.tambahan.mybinus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button editBtn;
    private Button aboutBtn;
    public TextView textNama, textEmail, textNoHP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textNama = findViewById(R.id.textNama);
        textEmail = findViewById(R.id.textEmail);
        textNoHP = findViewById(R.id.textNoHP);

        refreshData();

        Intent intent = getIntent();
        String nama = intent.getStringExtra("nama");
        String email = intent.getStringExtra("email");
        String nomorHP = intent.getStringExtra("nomorHP");

        textNama.setText("Nama: " + nama);
        textEmail.setText("Email: " + email);
        textNoHP.setText("Nomor Handphone: " + nomorHP);

        editBtn = findViewById(R.id.editButton);
        aboutBtn = findViewById(R.id.aboutButton);

        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProfile();
            }
        });

        aboutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAbout();
            }
        });
    }

    public void openProfile() {
        Intent profileIntent = new Intent(this, ProfileActivity.class);
        startActivity(profileIntent);
    }

    public void openAbout() {
        Intent aboutIntent = new Intent(this, AboutUsActivity.class);
        startActivity(aboutIntent);
    }

    private void refreshData() {
        SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);
        String nama = sharedPreferences.getString("nama", "");
        String email = sharedPreferences.getString("email", "");
        String nomorHP = sharedPreferences.getString("nomorHP", "");

        textNama.setText("Nama" + nama);
        textEmail.setText("Email: " + email);
        textNoHP.setText("Nomor HP: " + nomorHP);
    }
}