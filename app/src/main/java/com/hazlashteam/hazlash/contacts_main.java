package com.hazlashteam.hazlash;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ScrollView;

import java.lang.reflect.Array;
import java.util.Map;

public class contacts_main extends AppCompatActivity {

    String[] contactsList = new String[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts_main);
        RecyclerView myContactList = (RecyclerView) findViewById(R.id.myContactList);
    }

    private void createContactList(){
        contactsList = new String[]{"Mom","Dad","Sister","Boyfriend","Work","School"};


    }

}
