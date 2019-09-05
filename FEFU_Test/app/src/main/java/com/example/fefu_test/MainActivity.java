package com.example.fefu_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button fefu_btn;
    private Button comment_btn;
    private Button share_btn;

    private ListView listView;
    private MainList_Adapter mainList_adapter;
    private ArrayList<Main_Listitem> main_listitemArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fefu_btn = findViewById(R.id.fefu_btn);
        comment_btn = findViewById(R.id.comment_btn);
        share_btn = findViewById(R.id.share_btn);

        listView = findViewById(R.id.main_list);
        main_listitemArrayList = new ArrayList<>();

        mainList_adapter = new MainList_Adapter(this, main_listitemArrayList);

        Set_ListItem();

    }

    private void Set_ListItem() {
        main_listitemArrayList.add(new Main_Listitem(R.drawable.user_default, R.drawable.ex_logo, R.drawable.ex_picture1, "user1", "2019.09.04", "광주 어딘가", "....."));
        main_listitemArrayList.add(new Main_Listitem(R.drawable.user_default, R.drawable.ex_logo, R.drawable.ex_picture2, "user2", "2019.09.04", "광주 어딘가", "explain the picture/video"));

        listView.setAdapter(mainList_adapter);
    }
}
