package cl.gencina.aboutme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

import cl.gencina.aboutme.databinding.ActivityMainBinding;
import cl.gencina.aboutme.databinding.ActivityMisRedesBinding;

public class MisRedesActivity extends AppCompatActivity {
    private ActivityMisRedesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMisRedesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.btnLinkedin.setOnClickListener(v ->
        {
            Intent intentLinkedin = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/gencina2/"));
            startActivity(intentLinkedin);
        });

        binding.btnWhattsap.setOnClickListener(v ->
        {
            Intent intentWhatsapp = new Intent(Intent.ACTION_VIEW, Uri.parse("https://api.whatsapp.com/send?phone=+56933855169"));
            startActivity(intentWhatsapp);
        });

        binding.btnEmail.setOnClickListener(v -> sendEmail());

    }

    protected void sendEmail() {
        String[] TO = {"gencina2@gmail.com"};
        String[] CC = {""};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Contacto desde mi app");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Hola me podrias explicar lo siguiente....");

        startActivity(Intent.createChooser(emailIntent, "Enviando..."));
        finish();
    }

}