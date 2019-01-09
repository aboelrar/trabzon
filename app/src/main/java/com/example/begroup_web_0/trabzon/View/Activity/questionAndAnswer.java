package com.example.begroup_web_0.trabzon.View.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.example.begroup_web_0.trabzon.Presenter.questionPresenter;
import com.example.begroup_web_0.trabzon.R;
import com.example.begroup_web_0.trabzon.interfacee.questionMvp;

public class questionAndAnswer extends AppCompatActivity implements questionMvp.interfaces.View {
    RecyclerView questionList;
    questionPresenter questionPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_and_answer);
        questionList=(RecyclerView)findViewById(R.id.questionlist);
        questionPresenter=new questionPresenter(questionAndAnswer.this,questionAndAnswer.this,questionList);
        questionPresenter.getData();
    }
}
