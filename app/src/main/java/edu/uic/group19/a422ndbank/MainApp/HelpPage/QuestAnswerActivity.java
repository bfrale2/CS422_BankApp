package edu.uic.group19.a422ndbank.MainApp.HelpPage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import edu.uic.group19.a422ndbank.R;

public class QuestAnswerActivity extends AppCompatActivity {

    TextView questionText;
    TextView answerText;
    Button goBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest_answer);

        questionText = (TextView) findViewById(R.id.questionAnswerQuestionText);
        answerText = (TextView) findViewById(R.id.questionAnswerAnswer);
        goBackButton = (Button) findViewById(R.id.goBackButton);

        questionText.setText(getIntent().getStringExtra("question"));
        answerText.setText(getIntent().getStringExtra("answer"));


        goBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}
