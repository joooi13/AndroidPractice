package com.example.joy.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    private TextInputLayout textInputLayout;
    private EditText mUserNameView;
    private Button snackBtn;
    private Button customTabsBtn;
    private Button webViewBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findById();
        clickListener();

        mUserNameView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == EditorInfo.IME_ACTION_SEND) {
                    String user_name = textView.getText().toString();
                    if (TextUtils.isEmpty(user_name)) {
                        textInputLayout.setError("This field is required.");
                    } else if (user_name.length() > 10) {
                        textInputLayout.setError("This field is less than 10.");
                    } else {
                        textInputLayout.setError("IDが入力されていません！");
                    }
                    return true;
                }
                return false;
            }
        });

    }

    private void findById() {

        textInputLayout = (TextInputLayout) findViewById(R.id.text_input_message);
        mUserNameView = (EditText) findViewById(R.id.message);
        snackBtn = (Button) findViewById(R.id.snackbarBtn);
        customTabsBtn = (Button) findViewById(R.id.customTabsBtn);
        webViewBtn = (Button) findViewById(R.id.webViewBtn);


    }

    private void clickListener() {

        snackBtn.setOnClickListener(this);
        customTabsBtn.setOnClickListener(this);
        webViewBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (view.equals(snackBtn)) {
            final Snackbar snackbar = Snackbar.make(snackBtn, "Snackbar!", Snackbar.LENGTH_INDEFINITE);
            snackbar.setAction("TAP", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    snackbar.dismiss();
                }
            }).show();
        } else if (view.equals(customTabsBtn)) {

            Intent intent = new Intent(this, CustomTabActivity.class);
            startActivity(intent);

        } else if (view.equals(webViewBtn)) {

        }
    }
}
