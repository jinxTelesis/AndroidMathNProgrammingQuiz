package com.example.dre.individualprojectquest2v1.View.Questions1To5;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.dre.individualprojectquest2v1.Constants.Constant;
import com.example.dre.individualprojectquest2v1.R;

public class Question3Activity extends AppCompatActivity {

    // this uses a seekbar
    // saves to preferences rather than passing
    // to different activites

    private Button q3Submit;
    private SeekBar seekBar;
    private int userAnswer;
    private TextView tVSeekBarNumber;
    private SharedPreferences myPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);

        tVSeekBarNumber = (TextView) findViewById(R.id.textViewQ3Number);
        seekBar = (SeekBar) findViewById(R.id.seekBarQuestion3);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tVSeekBarNumber.setText("Answer = " + seekBar.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



        q3Submit = (Button) findViewById(R.id.ButtonQ3Sub);
        q3Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Question3Activity.this);
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
                    userAnswer = seekBar.getProgress();

                    myPrefs = getSharedPreferences(Constant.PREFS_ANSWERS, 0);
                    SharedPreferences.Editor editor = myPrefs.edit();

                    if(userAnswer == 11)
                    {
                        editor.putInt("Q3",20);
                        editor.apply();
                    }
                    else
                    {
                        editor.putInt("Q3",0);
                        editor.apply();
                    }

                    Intent intent = new Intent(Question3Activity.this, Question4Activity.class);
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
