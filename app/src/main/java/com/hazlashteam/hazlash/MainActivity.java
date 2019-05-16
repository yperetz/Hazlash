package com.hazlashteam.hazlash;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private String userInputString = "הכל בסדר";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Button userInput = (Button) findViewById(R.id.getuserinput);
        userInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getUserInput();
            }

        });
    }

    //removeheader


    private void getUserInput() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //builder.setTitle("עדכן הודעה");


        // Set up the input
        final EditText input = new EditText(this);
        // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);
        input.setHint("הכנס את ההודעה");


        // Set up the buttons
        builder.setPositiveButton("עדכן", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                userInputString = input.getText().toString();
                TextView messageToContacts = (TextView) findViewById(R.id.messageToContacts);
                messageToContacts.setText(userInputString);
            }
        });
        builder.setNegativeButton("בטל", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();


    }
    

}
