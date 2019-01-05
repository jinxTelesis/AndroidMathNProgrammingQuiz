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

public class Question1Activity extends AppCompatActivity {

    private SharedPreferences myPrefs;

    // uses dialogs to confirm answers
    // the checkboxes will only be selectable one at a time
    // uses prefs rather than passing the data between activities


    private CheckBox cb1Left, cb2Left, cb1Right, cb2Right;
    private Button q1Submit; // the question isn't for collision reasons
    // it is to remind me where I am

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);

        // happy with the naming convection this was very easy to follow

        cb1Left = (CheckBox) findViewById(R.id.checkBoxQ1L1);
        cb2Left = (CheckBox) findViewById(R.id.checkBoxQ1L2);
        cb1Right = (CheckBox) findViewById(R.id.checkBoxQ1R1);
        cb2Right = (CheckBox) findViewById(R.id.checkBoxQ1R2);
        q1Submit = (Button) findViewById(R.id.ButtonQ1Sub);

        q1Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Question1Activity.this);
                builder.setMessage("Are you sure about your answer?").setPositiveButton("Yes", dialogClickListener)
                        .setNegativeButton("No", dialogClickListener).show(); // show a little too verbose?
            }
        });
    }

    // ****************************************************
    // dialog to ask if they are certain about their answer

    DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            switch(which)
            {
                case DialogInterface.BUTTON_POSITIVE:
                    myPrefs = getSharedPreferences(Constant.PREFS_ANSWERS,0);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    if(cb1Left.isChecked())
                    {
                        editor.putInt("Q1", 20);
                        editor.apply();
                    }
                    else
                    {
                        editor.putInt("Q1", 0);
                        editor.apply();
                    }

                    Intent i = new Intent(Question1Activity.this, Question2Activity.class);
                    startActivity(i);
                    finish();
                    break;


                case DialogInterface.BUTTON_NEGATIVE:
                    break;

            }
        }
    };

    // this is to change the checkboxes so only one is selected at a time

    public void onCheckboxClicked(View view)
    {
        switch(view.getId()){

            case R.id.checkBoxQ1L1:
                cb2Left.setChecked(false);
                cb1Right.setChecked(false);
                cb2Right.setChecked(false);
                break;


            case R.id.checkBoxQ1L2:
                cb1Left.setChecked(false);
                cb1Right.setChecked(false);
                cb2Right.setChecked(false);
                break;

            case R.id.checkBoxQ1R1:
                cb1Left.setChecked(false);
                cb2Left.setChecked(false);
                cb2Right.setChecked(false);
                break;

            case R.id.checkBoxQ1R2:
                cb1Left.setChecked(false);
                cb2Left.setChecked(false);
                cb1Right.setChecked(false);
                break;


        }
    }
}
