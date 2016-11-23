package com.example.yujoi.myapplication;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final TextInputLayout textInputLayout = (TextInputLayout) findViewById(R.id.text_input_message);
        final EditText mUserNameView = (EditText) findViewById(R.id.message);

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

        final Button snackBtn = (Button) findViewById(R.id.snackbarBtn);
        snackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Snackbar snackbar = Snackbar.make(snackBtn, "Snackbar!", Snackbar.LENGTH_INDEFINITE);
                snackbar.setAction("TAP", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        snackbar.dismiss();
                    }
                }).show();

            }
        });

    }
}
