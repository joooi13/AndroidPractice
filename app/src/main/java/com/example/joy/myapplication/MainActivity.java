package com.example.joy.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextInputLayout textInputLayout;
    private EditText mUserNameView;
    private Button snackBtn;
    private BottomNavigationView bottomNavigationView;
    private Button chromeCustomForwardBtn;

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

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.chromecustomview:

                        break;
                }
                return false;
            }
        });

    }

    private void findById() {

        textInputLayout = (TextInputLayout) findViewById(R.id.text_input_message);
        mUserNameView = (EditText) findViewById(R.id.message);
        snackBtn = (Button) findViewById(R.id.snackbarBtn);
        bottomNavigationView= (BottomNavigationView) findViewById(R.id.navigation);
        chromeCustomForwardBtn= (Button) findViewById(R.id.chrome_custom_view);

    }

    private void clickListener() {
        snackBtn.setOnClickListener(this);
        chromeCustomForwardBtn.setOnClickListener(this);
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
        }else if(view.equals(chromeCustomForwardBtn)){
            Intent intent = new Intent(this,RecyclerViewActivity.class);
            startActivity(intent);
        }/*else if(view.equals(chromeCustomForwardBtn)){
            Intent intent = new Intent(this,RecyclerViewActivity.class);
            startActivity(intent);
        }*/
    }
}
