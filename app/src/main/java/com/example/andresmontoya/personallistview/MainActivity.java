package com.example.andresmontoya.personallistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Band bands_data[] = new Band[]{
                new Band(R.drawable.ic_launcher, "Muse"),
                new Band(R.drawable.ic_launcher, "SFDK"),
                new Band(R.drawable.ic_launcher, "nirvana"),
                new Band(R.drawable.ic_launcher, "Aerosmith"),
                new Band(R.drawable.ic_launcher, "Guns and roses"),
                new Band(R.drawable.ic_launcher, "Avenged sevenfold"),
                new Band(R.drawable.ic_launcher, "Metallica"),
                new Band(R.drawable.ic_launcher, "Linkin park"),
                new Band(R.drawable.ic_launcher, "Coldplay"),
                new Band(R.drawable.ic_launcher, "Korn"),
                new Band(R.drawable.ic_launcher, "Slipknot"),
                new Band(R.drawable.ic_launcher, "3 doors down"),
                new Band(R.drawable.ic_launcher, "Stone sour")

        };

        BandsAdapter adapter = new BandsAdapter(this, R.layout.listview_item_row, bands_data);
        lv = (ListView) findViewById(R.id.lv);
        View header = (View) getLayoutInflater().inflate(R.layout.list_header_row, null);
        lv.addHeaderView(header);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView v = (TextView) view.findViewById(R.id.tv);
                Toast.makeText(getApplicationContext(), v.getText(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
