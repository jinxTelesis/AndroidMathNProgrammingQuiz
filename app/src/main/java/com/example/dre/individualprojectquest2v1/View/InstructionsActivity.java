package com.example.dre.individualprojectquest2v1.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.dre.individualprojectquest2v1.R;

public class InstructionsActivity extends AppCompatActivity {

    // just displays instructions and goes back to the directory
    // area

    TextView tvExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);

        tvExit = (TextView) findViewById(R.id.textViewInstructionExit);

        tvExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent retuIntent = new Intent(InstructionsActivity.this, quizSelection.class);
                startActivity(retuIntent);
                finish();

            }
        });
    }
}
