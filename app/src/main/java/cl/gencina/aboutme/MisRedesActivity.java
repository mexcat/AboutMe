package cl.gencina.aboutme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

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
            Intent intentWhatsapp = new Intent(Intent.ACTION_DIAL, Uri.parse("https://api.whatsapp.com/send?phone=+56933855169"));
            startActivity(intentWhatsapp);
        });

        binding.btnCall.setOnClickListener(v ->
        {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+56933855169"));
            startActivity(intent);

        });

        binding.btnEmail.setOnClickListener(v -> sendEmail());

    }

    protected void sendEmail() {
        String[] TO = {"gencina2@gmail.com"};
        String[] CC = {""};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setType("text/plain");
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Contacto desde mi app");
        emailIntent.putExtra(Intent.EXTRA_TEXT, binding.etvEmailBody.getText());

        startActivity(Intent.createChooser(emailIntent, "Enviando..."));
        finish();
    }

}