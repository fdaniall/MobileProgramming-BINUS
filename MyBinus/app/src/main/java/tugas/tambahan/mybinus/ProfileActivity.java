package tugas.tambahan.mybinus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity {

    private Button homeBtn;
    private Button aboutBtn;
    private Button saveBtn;

    private EditText editNama, editEmail, editNoHP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        editNama = findViewById(R.id.editNama);
        editEmail = findViewById(R.id.editEmail);
        editNoHP = findViewById(R.id.editNoHP);

        homeBtn = findViewById(R.id.homeButton);
        aboutBtn = findViewById(R.id.aboutButton);
        saveBtn = findViewById(R.id.saveButton);

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHome();
            }
        });

        aboutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAbout();
            }
        });

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("nama", editNama.getText().toString());
                editor.putString("email", editEmail.getText().toString());
                editor.putString("nomorHP", editNoHP.getText().toString());
                editor.apply();

                Toast.makeText(ProfileActivity.this, "Data saved", Toast.LENGTH_SHORT).show();

                Log.d("ProfileActivity", "Data tersimpan - Nama: " + editNama.getText().toString());
                Log.d("ProfileActivity", "Data tersimpan - Email: " + editEmail.getText().toString());
                Log.d("ProfileActivity", "Data tersimpan - NomorHP: " + editNoHP.getText().toString());

                Intent homeIntent = new Intent(ProfileActivity.this, MainActivity.class);
                homeIntent.putExtra("nama", editNama.getText().toString());
                homeIntent.putExtra("email", editEmail.getText().toString());
                homeIntent.putExtra("nomorHP", editNoHP.getText().toString());
                startActivity(homeIntent);

                editNama.setHint(editNama.getText().toString());
                editEmail.setHint(editEmail.getText().toString());
                editNoHP.setHint(editNoHP.getText().toString());
            }
        });
    }

    public void openHome() {
        Intent homeIntent = new Intent(this, MainActivity.class);
        startActivity(homeIntent);
    }

    public void openAbout() {
        Intent aboutIntent = new Intent(this, AboutUsActivity.class);
        startActivity(aboutIntent);
    }
}
