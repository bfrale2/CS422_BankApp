package edu.uic.group19.a422ndbank.MainApp.HelpPage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import edu.uic.group19.a422ndbank.R;

public class QuestAnswerActivity extends AppCompatActivity {

    TextView questionText;
    TextView answerText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quest_answer);

        questionText = (TextView) findViewById(R.id.questionAnswerQuestionText);
        answerText = (TextView) findViewById(R.id.questionAnswerAnswer);

        questionText.setText(getIntent().getStringExtra("question"));
        answerText.setText(getIntent().getStringExtra("answer"));

    }
}
