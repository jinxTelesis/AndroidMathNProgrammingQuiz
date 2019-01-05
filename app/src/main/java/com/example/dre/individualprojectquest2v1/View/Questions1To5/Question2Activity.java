package com.example.dre.individualprojectquest2v1.View.Questions1To5;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.example.dre.individualprojectquest2v1.Constants.Constant;
import com.example.dre.individualprojectquest2v1.R;

public class Question2Activity extends AppCompatActivity {

    // uses dialogs to confirm answers
    // the checkboxes will only be selectable one at a time
    // uses prefs rather than passing the data between activities

    private SharedPreferences myprefs;
    // really liked the naming
    // easier to wire than past Java projects
    private CheckBox cb1Left, cb2Left, cb3Left, cb1Right, cb2Right, cb3Right;
    private Button q2Submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);

        cb1Left = (CheckBox) findViewById(R.id.checkBoxQ2L1);
        cb2Left = (CheckBox) findViewById(R.id.checkBoxQ2L2);
        cb3Left = (CheckBox) findViewById(R.id.checkBoxQ2L3);
        cb1Right = (CheckBox) findViewById(R.id.checkBoxQ2R1);
        cb2Right = (CheckBox) findViewById(R.id.checkBoxQ2R2);
        cb3Right = (CheckBox) findViewById(R.id.checkBoxQ2R3);

        q2Submit = (Button) findViewById(R.id.ButtonQ2Sub);

        q2Submit.setOnClickListener(new View.OnClickListener() { // make this invisible after make new button
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Question2Activity.this);
                builder.setMessage("Are you sure about your answer?").setPositiveButton("yes", dialogClickListner)
                        .setNegativeButton("No", dialogClickListner).show();

                //builder.setMessage("Are you sure about your answer?").setPositiveButton("Yes", dialogClickListener)
                //                        .setNegativeButton("No", dialogClickListener).show(); // show a little too verbose?
            }
        });

    }

    // ****************************************************
    // dialog to ask if they are certain about their answer

    DialogInterface.OnClickListener dialogClickListner = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            switch (which) {

                case DialogInterface.BUTTON_POSITIVE:
                    myprefs = getSharedPreferences(Constant.PREFS_ANSWERS,0);
                    SharedPreferences.Editor editor = myprefs.edit();

                    if(cb1Left.isChecked()) // 6 points
                    {
                        editor.putInt("Q2A1", 6);
                        editor.apply();
                    }
                    else
                    {
                        editor.putInt("Q2A1", 0);
                        editor.apply();
                    }

                    if(cb3Left.isChecked()) // 7 points
                    {
                        editor.putInt("Q2A2", 7);
                        editor.apply();
                    }
                    else
                    {
                        editor.putInt("Q2A2", 0);
                        editor.apply();
                    }

                    if(cb2Right.isChecked()) // 7 points
                    {
                        editor.putInt("Q2A3", 7);
                        editor.apply();
                    }
                    else
                    {
                        editor.putInt("Q2A3", 0);
                        editor.apply();
                    }

                    //editor.apply();

                    Intent intent = new Intent(Question2Activity.this, Question3Activity.class);
                    startActivity(intent);
                    finish();
                    break;


                case DialogInterface.BUTTON_NEGATIVE:
                    //ToDo
                    break;
            }
        }
    };
}
