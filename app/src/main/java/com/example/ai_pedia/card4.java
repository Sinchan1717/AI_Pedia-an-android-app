package com.example.ai_pedia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class card4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card4);
    }
    public void myWeb(View v)
    {
        openUrl("https://www.notion.so/product/ai?gspk=dml2ZWt2YXJtYTc0OTA&gsxid=nzfJzAmlji5v&pscd=affiliate.notion.so&utm_medium=vivekvarma7490&utm_source=affl");
    }
    public void openUrl(String url)
    {
        Uri uri = Uri.parse(url);
        Intent i1 =new Intent(Intent.ACTION_VIEW,uri);
        startActivity(i1);
    }
}