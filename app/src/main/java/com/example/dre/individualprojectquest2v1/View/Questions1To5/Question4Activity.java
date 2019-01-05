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

public class Question4Activity extends AppCompatActivity {


    // uses dialogs to confirm answers
    // the checkboxes will only be selectable one at a time
    // uses prefs rather than passing the data between activities
    private Button q4Submit;
    private CheckBox cb1Left, cb2Left, cb1Right, cb2Right;
    private SharedPreferences myPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question4);

        cb1Left = (CheckBox) findViewById(R.id.checkBoxQ4L1);
        cb2Left = (CheckBox) findViewById(R.id.checkBoxQ4L2);
        cb1Right = (CheckBox) findViewById(R.id.checkBoxQ4R1);
        cb2Right = (CheckBox) findViewById(R.id.checkBoxQ4R2);

        q4Submit = (Button) findViewById(R.id.ButtonQ4Sub);

        q4Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Question4Activity.this);
                builder.setMessage("Are you sure about your answer?").setPositiveButton("yes", dialogClickListner)
                        .setNegativeButton("No", dialogClickListner).show();
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
                    myPrefs = getSharedPreferences(Constant.PREFS_ANSWERS,0);
                    SharedPreferences.Editor editor = myPrefs.edit();
                    if(cb2Right.isChecked())
                    {
                        editor.putInt("Q4", 20);
                        editor.apply();
                    }
                    else
                    {
                        editor.putInt("Q4", 0);
                        editor.apply();
                    }

                    Intent intent = new Intent(Question4Activity.this, Question5Activity.class);
                    startActivity(intent);
                    finish();
                    break;


                case DialogInterface.BUTTON_NEGATIVE:
                    //ToDo
                    break;
            }
        }
    };

    // this is to change the checkboxes so only one is selected at a time

    public void onCheckboxClicked(View view)
    {
        switch (view.getId())
        {
            case R.id.checkBoxQ4L1:
                cb2Left.setChecked(false);
                cb1Right.setChecked(false);
                cb2Right.setChecked(false);
                break;

            case R.id.checkBoxQ4L2:
                cb1Left.setChecked(false);
                cb1Right.setChecked(false);
                cb2Right.setChecked(false);
                break;

            case R.id.checkBoxQ4R1:
                cb1Left.setChecked(false);
                cb2Left.setChecked(false);
                cb2Right.setChecked(false);
                break;

            case R.id.checkBoxQ4R2:
                cb1Left.setChecked(false);
                cb2Left.setChecked(false);
                cb1Right.setChecked(false);
                break;

        }
    }
}
