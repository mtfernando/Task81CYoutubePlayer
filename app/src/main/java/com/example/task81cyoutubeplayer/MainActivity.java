package com.example.task81cyoutubeplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText urlEditText;
    Button playButton;
    String url, videoCode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        urlEditText = findViewById(R.id.urlEditText);
        playButton = findViewById(R.id.playButton);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Getting URL from EditText
                url = urlEditText.getText().toString();
                Pattern compiledPattern = Pattern.compile("(?<=v=).*?(?=&|$)",Pattern.CASE_INSENSITIVE);
                Matcher matcher = compiledPattern.matcher(url);
                if(matcher.find()) {
                    videoCode = matcher.group().toString();
                }
                else{
                    System.out.println("Error!");
                }
                Intent intent = new Intent(MainActivity.this, PlayActivity.class);
                intent.putExtra("videoCode", videoCode);

                startActivity(intent);
            }
        });
    }
}