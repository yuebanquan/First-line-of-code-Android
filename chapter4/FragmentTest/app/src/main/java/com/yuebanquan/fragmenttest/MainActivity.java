package com.yuebanquan.fragmenttest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(this);
        replaceFragment(new RightFragment());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                replaceFragment(new AnotherRightFragment());
                break;
            default:
                break;
        }
    }

    //动态添加碎片
    private void replaceFragment(Fragment fragment) {
        //获取FragmentManager，在活动中可以直接通过调用getSupportFragmentManager()方法得到
        FragmentManager fragmentManager = getSupportFragmentManager();
        //开启一个事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        //向容器内添加或替换碎片
        transaction.replace(R.id.right_layout, fragment);
        transaction.addToBackStack(null);
        //提交事务
        transaction.commit();
    }
}
