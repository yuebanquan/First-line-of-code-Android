package com.yuebanquan.listviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private String[] data = {"asdf", "asdfg", "sdfrwe", "hgiru", "dhfkjh", "hguyer",
            "hfr", "hejfdj", "jsdbfjeh", "dsfjioe", "uerrgb", "ehfja", "ehbfe", "uenjgd",
            "berrw", "berg"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, data);
        ListView listView = (ListView)findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }
}
