package com.tweak.sharedpreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.tweak.sharedpreferences.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.textView), new androidx.core.view.OnApplyWindowInsetsListener() {
            @Override
            public WindowInsetsCompat onApplyWindowInsets(View v, WindowInsetsCompat insets) {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            }
        });

        binding.btnMoveText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enteredText = binding.editTextText.getText().toString().trim();
                if (!enteredText.isEmpty()) {
                    binding.textView.setText(enteredText);
                } else {
                    Toast.makeText(MainActivity.this, "Please enter some text!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        binding.save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveText();
            }
        });

        // Load data after UI initialization
        againLoadData();
    }

    private void saveText() {
        String txt = binding.textView.getText().toString();
        SharedPreferences sp = getSharedPreferences("SharedPref", MODE_PRIVATE);  //MOD_PRIVATE: The data is private to your app (no other apps can access it), and ️ only your app can read or write to this preference file.
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("text1", txt);
        editor.putBoolean("switch", binding.switch1.isChecked());
        editor.apply();

        Toast.makeText(this, "Data saved successfully!", Toast.LENGTH_SHORT).show();
    }


    //to get data form Shared Preference and set them on the views
    private void againLoadData() {
        SharedPreferences sp = getSharedPreferences("SharedPref", MODE_PRIVATE);
        String text = sp.getString("text1", null);
        boolean switchOnOff = sp.getBoolean("switch", false);

        if (text != null && !text.isEmpty()) {
            binding.textView.setText(text);
        }

        binding.switch1.setChecked(switchOnOff);
    }
}
