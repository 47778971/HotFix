package com.lj.hotfixtest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.lj.hotfix.AndFixManager;

public class MainActivity extends Activity {

    private TextView textView;
    private Button setContentButton;
    private Button fixButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setContentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("new content");
            }
        });

        fixButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AndFixManager.with().addPatch(getExternalCacheDir().getPath() + "/patch/");
            }
        });
    }

    private void initView() {
        setContentButton = findViewById(R.id.set_content_button);
        fixButton = findViewById(R.id.fix_bug_button);
    }

}
