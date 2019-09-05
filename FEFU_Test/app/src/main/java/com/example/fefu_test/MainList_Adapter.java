package com.example.fefu_test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainList_Adapter extends BaseAdapter {

    Context context;
    ArrayList<Main_Listitem> main_listitems;

    private ImageView userimage_view;
    private ImageView location_icon;
    private ImageView userpicture_view;

    private TextView userid_view;
    private TextView date_view;
    private TextView userlocation_view;
    private TextView userText_view;

    private Button fefu_btn;
    private Button comment_btn;
    private Button share_btn;

    public MainList_Adapter(Context context, ArrayList<Main_Listitem> main_listitems) {
        this.context = context;
        this.main_listitems = main_listitems;
    }

    @Override
    public int getCount() {
        return main_listitems.size();
    }

    @Override
    public Object getItem(int i) {
        return this.main_listitems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if(view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.activity_main_listitem, null);

            Connect_LayoutItem(view);
        }

        Set_LayoutItem(i);

        return view;
    }

    private void Connect_LayoutItem(View view) {
        userimage_view = view.findViewById(R.id.userimg_view);
        location_icon = view.findViewById(R.id.location_icon);
        userpicture_view=  view.findViewById(R.id.userpicture_view);

        userid_view = view.findViewById(R.id.userid_view);
        date_view = view.findViewById(R.id.date_view);
        userlocation_view = view.findViewById(R.id.userlocation_view);
        userText_view = view.findViewById(R.id.usertext_view);

        fefu_btn = view.findViewById(R.id.fefu_btn);
        comment_btn = view.findViewById(R.id.comment_btn);
        share_btn = view.findViewById(R.id.share_btn);
    }

    private void Set_LayoutItem(int i) {
        userimage_view.setImageResource(main_listitems.get(i).getUserImage());
        location_icon.setImageResource(main_listitems.get(i).getLocation_icon());
        userpicture_view.setImageResource(main_listitems.get(i).getUserPicture());

        userid_view.setText(main_listitems.get(i).getUserid());
        date_view.setText(main_listitems.get(i).getDate());
        userlocation_view.setText(main_listitems.get(i).getUserLocation());
        userText_view.setText(main_listitems.get(i).getUserText());

        fefu_btn.setOnClickListener(btnClickListener);
        comment_btn.setOnClickListener(btnClickListener);
        share_btn.setOnClickListener(btnClickListener);
    }

    private Button.OnClickListener btnClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.fefu_btn:
                    Toast.makeText(context.getApplicationContext(), "fefu clicked", Toast.LENGTH_SHORT).show();
                    break;

                case R.id.comment_btn:
                    Toast.makeText(context.getApplicationContext(), "comment clicked", Toast.LENGTH_SHORT).show();
                    break;

                case R.id.share_btn:
                    Toast.makeText(context.getApplicationContext(), "share clicked", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };
}
