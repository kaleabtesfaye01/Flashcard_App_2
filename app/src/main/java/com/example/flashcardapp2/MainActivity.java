package com.example.flashcardapp2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView question = findViewById(R.id.flashcard_question);
        TextView answer = findViewById(R.id.flashcard_answer);
        ImageView add = findViewById(R.id.add_button);

        question.setOnClickListener(v -> {
            question.setVisibility(View.INVISIBLE);
            answer.setVisibility(View.VISIBLE);
        });

        add.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddCardActivity.class);
            MainActivity.this.startActivityForResult(intent, 100);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 100 & resultCode == RESULT_OK) {

            TextView question = findViewById(R.id.flashcard_question);
            TextView answer = findViewById(R.id.flashcard_answer);

            String string1 = data.getExtras().getString("question");
            String string2 = data.getExtras().getString("answer");

            question.setText(string1);
            answer.setText(string2);
        }
    }
}