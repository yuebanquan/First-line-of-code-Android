package com.yuebanquan.uiwidgertest;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.provider.ContactsContract;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt_show_et;
    private Button bt_show_iv;
    private Button bt_show_pb;
    private Button bt_change_pb;
    private Button bt_show_ad;
    private Button bt_show_pd;

    private EditText editText;
    private ImageView imageView;
    private ProgressBar progressBar1;
    private ProgressBar progressBar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_show_et = (Button) findViewById(R.id.bt_show_et);
        bt_show_iv = (Button) findViewById(R.id.bt_show_iv);
        bt_show_pb = (Button) findViewById(R.id.bt_show_pb);
        bt_change_pb = (Button) findViewById(R.id.bt_change_pb);
        bt_show_ad = (Button) findViewById(R.id.bt_show_ad);
        bt_show_pd = (Button)findViewById(R.id.bt_show_pd);

        editText = (EditText) findViewById(R.id.edit_text);
        imageView = (ImageView) findViewById(R.id.image_view);
        progressBar1 = (ProgressBar) findViewById(R.id.progress_bar1);
        progressBar2 = (ProgressBar) findViewById(R.id.progress_bar2);

        bt_show_et.setOnClickListener(this);
        bt_show_iv.setOnClickListener(this);
        bt_show_pb.setOnClickListener(this);
        bt_change_pb.setOnClickListener(this);
        bt_show_ad.setOnClickListener(this);
        bt_show_pd.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_show_et:
                String inputText = editText.getText().toString();
                Toast.makeText(MainActivity.this, inputText, Toast.LENGTH_SHORT).show();
                break;
            case R.id.bt_show_iv:
                imageView.setImageResource(R.mipmap.ic_launcher_round);
                break;
            case R.id.bt_show_pb:
                if (progressBar1.getVisibility() == View.GONE) {
                    progressBar1.setVisibility(View.VISIBLE);
                } else {
                    progressBar1.setVisibility(View.GONE);
                }
                break;
            case R.id.bt_change_pb:
                int progress = progressBar2.getProgress();
                progress = progress + 10;
                progressBar2.setProgress(progress);
                break;
            case R.id.bt_show_ad:
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("This is Dialog");
                dialog.setMessage("Something important.");
                dialog.setCancelable(false);        //不能用返回键返回
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                dialog.show();
                break;
            case R.id.bt_show_pd:
                ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setTitle("This is ProgressDialog");
                progressDialog.setMessage("loading...");
                progressDialog.setCancelable(true);
                progressDialog.show();
                break;
            default:
                break;
        }
    }
}
