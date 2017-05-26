package com.esp.mcbooks;

import android.content.Intent;
import android.graphics.PointF;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import me.dm7.barcodescanner.zbar.Result;
import me.dm7.barcodescanner.zbar.ZBarScannerView;


public class ScanQRCodeActivity extends AppCompatActivity implements ZBarScannerView.ResultHandler{

    private static final String TAG = "ScanQR";
    private ZBarScannerView zbarScannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_qrcode);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        toolbar.setTitle("Scan QR Code");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScanQRCodeActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });

        zbarScannerView = (ZBarScannerView) findViewById(R.id.scanqr_zbar);

    }

    @Override
    protected void onResume() {
        super.onResume();
        zbarScannerView.setResultHandler(this);
        zbarScannerView.startCamera();
    }

    @Override
    protected void onPause() {
        super.onPause();
        zbarScannerView.stopCamera();
    }

    @Override
    public void handleResult(Result result) {
        Toast.makeText(this, "Contents = " + result.getContents() +
                ", Format = " + result.getBarcodeFormat().getName(), Toast.LENGTH_SHORT).show();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                zbarScannerView.resumeCameraPreview(ScanQRCodeActivity.this);
            }
        }, 2000);
    }

}
