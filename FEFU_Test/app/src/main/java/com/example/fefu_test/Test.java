package com.example.fefu_test;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;

public class Test extends AppCompatActivity {

    ShareDialog shareDialog;
    private Button test_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        FacebookSdk.sdkInitialize(getApplicationContext()); // Facebook SDK초기화
        shareDialog = new ShareDialog(this);

        test_btn = findViewById(R.id.test_btn);

        test_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ShareDialog.canShow(ShareLinkContent.class)) {
                    ShareLinkContent content = new ShareLinkContent.Builder()
                            .setContentTitle("공유할 컨텐츠 타이틀")// 링크 컨텐츠 제목
                            .setContentDescription("공유할 컨텐츠 내용")// 링크 컨텐츠 내용
                            .setImageUrl(Uri.parse("공유할 이미지 URL"))// 썸네일 이미지 URL
                            .setContentUrl(Uri.parse("공유할 웹사이트 주소"))
                            .build();

                    shareDialog.show(content, ShareDialog.Mode.FEED);
                }
            }
        });
    }
}
