package com.beebrainy.servicesex.client.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.beebrainy.servicesex.R;
import com.beebrainy.servicesex.client.services.download.DownloadResultReceiver;
import com.beebrainy.servicesex.client.services.download.DownloadService;
import com.beebrainy.servicesex.client.services.misc.LogService;

public class MainActivity extends AppCompatActivity implements DownloadResultReceiver.Receiver,
        View.OnClickListener {

    private EditText edtPageNo;
    private Button btnSubmit, btnLoggingService, btnMusicService;

    DownloadResultReceiver mReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtPageNo = findViewById(R.id.edtPageNo);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnLoggingService = findViewById(R.id.btnLoggingService);
        btnMusicService = findViewById(R.id.btnMusicService);

        btnSubmit.setOnClickListener(this);
        btnLoggingService.setOnClickListener(this);
        btnMusicService.setOnClickListener(this);
    }

    @Override
    public void onReceiveResult(int resultCode, Bundle resultData) {
        Log.d(MainActivity.class.getSimpleName(), "ResultCode:" + resultCode + " Bundle data:" +
                resultData);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSubmit: {
                if (!edtPageNo.getText().toString().equals("")) {
                    Intent intent = new Intent(Intent.ACTION_SYNC, null, MainActivity.this,
                            DownloadService.class);
                    mReceiver = new DownloadResultReceiver(new Handler());
                    mReceiver.setReceiver(MainActivity.this);
                    intent.putExtra("page_no", Integer.parseInt(edtPageNo.getText().toString()));
                    intent.putExtra("request_id", Integer.parseInt(edtPageNo.getText().toString()));
                    intent.putExtra("receiver", mReceiver);
                    intent.putExtra("url", "https://reqres.in/api/users?page=2");
                    startService(intent);
                }
                break;
            }
            case R.id.btnLoggingService: {
                startService(new Intent(this, LogService.class));
                break;
            }
            case R.id.btnMusicService: {
                startActivity(new Intent(this, MusicActivity.class));
                break;
            }
        }
    }
}
