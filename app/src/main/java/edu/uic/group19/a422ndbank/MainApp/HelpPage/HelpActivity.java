package edu.uic.group19.a422ndbank.MainApp.HelpPage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

import edu.uic.group19.a422ndbank.Models.FAQ;
import edu.uic.group19.a422ndbank.R;

public class HelpActivity extends AppCompatActivity implements HelpPageAdapter.OnCellClickedListener {

    RecyclerView recyclerView;
    ArrayList<FAQ> questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        loadQuestions();

        recyclerView = (RecyclerView) findViewById(R.id.faqRecyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new HelpPageAdapter(this, questions, this));

    }

    private void loadQuestions(){
        questions = new ArrayList<>();
        questions.add(new FAQ("Why did i get this app", "You got this app because it is the best banking app you will ever use and everyone in the world uses it"));
        questions.add(new FAQ("What do i do with this app", "You can see your accounts, recent transactions, pay some bills and more!!"));
        questions.add(new FAQ("How do i know you guys wont steal all of my info?", "You just need to trust us.  But the fact is we wouldnt want to steal your info becaues if word got out that we stole info we would be out of business"));
        questions.add(new FAQ("Who made this AMAZING BEAUTIFUL APP???", "Some of the greatest minds at the school of Engineering called University of Illinois!!"));
    }

    @Override
    public void onCellClicked(int pos) {
        Intent intent = new Intent(this, QuestAnswerActivity.class);
        intent.putExtra("question", questions.get(pos).getQuestion());
        intent.putExtra("answer", questions.get(pos).getAnswer());
        startActivity(intent);

    }
}
