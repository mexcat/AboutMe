package cl.gencina.aboutme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.bumptech.glide.Glide;

import cl.gencina.aboutme.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Glide.with(this).load("https://media.licdn.com/dms/image/C4E03AQGljR7Dp4C8sQ/profile-displayphoto-shrink_800_800/0/1528395270624?e=1693440000&v=beta&t=9795h95gT94apmANBkbA1sjHScqGkUidib2GTxnKSI8").into(binding.ivMiImagen);

        binding.btnMisRedes.setOnClickListener(v -> {
            Intent goTo = new Intent(this, MisRedesActivity.class);
            startActivity(goTo);
        });
    }
}