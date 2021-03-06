package com.example.joy.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextInputLayout textInputLayout;
    private EditText mUserNameView;
    private Button snackBtn;
    private BottomNavigationView bottomNavigationView;
    private Button chromeCustomForwardBtn;
    private Button recyclerForwardBtn;
    private Button vectorForwardBtn;
    private Button imageSampleBtn;

    LinearLayout cardLinear;

    @Inject
    Hello mHello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaggerActivityComponent.create().inject(this);

        // helloと出力
        mHello.say();

        findById();
        clickListener();

        cardLinear = (LinearLayout)this.findViewById(R.id.card);
        cardLinear.removeAllViews();

        for(int i = 0; i< 5; i++) {
            LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
            LinearLayout linearLayout = (LinearLayout) inflater.inflate(R.layout.card_view, null);
            CardView cardView = (CardView) linearLayout.findViewById(R.id.cardView);
            TextView textBox = (TextView) linearLayout.findViewById(R.id.textBox);
            textBox.setText("CardView" + i);
            cardView.setTag(i);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(MainActivity.this, String.valueOf(v.getTag()) + "番目のCardViewがクリックされました", Toast.LENGTH_SHORT).show();
                }
            });
            cardLinear.addView(linearLayout,i);
        }

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
                    case R.id.sample1:
                        return true;
                    case R.id.sample2:
                        return true;
                    case R.id.sample3:
                        return true;
                    case R.id.sample4:
                        return true;
                    case R.id.sample5:
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
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        chromeCustomForwardBtn = (Button) findViewById(R.id.chrome_custom_view);
        recyclerForwardBtn = (Button) findViewById(R.id.recyclerViewBtn);
        vectorForwardBtn = (Button) findViewById(R.id.vectorBtn);
        imageSampleBtn = (Button) findViewById(R.id.imageSampleViewBtn);

    }

    private void clickListener() {
        snackBtn.setOnClickListener(this);
        chromeCustomForwardBtn.setOnClickListener(this);
        recyclerForwardBtn.setOnClickListener(this);
        vectorForwardBtn.setOnClickListener(this);
        imageSampleBtn.setOnClickListener(this);
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
        } else if (view.equals(chromeCustomForwardBtn)) {
            Intent intent = new Intent(this, ChromeCustomActivity.class);
            startActivity(intent);
        } else if (view.equals(recyclerForwardBtn)) {
            Intent intent = new Intent(this, RecyclerViewActivity.class);
            startActivity(intent);
        } else if (view.equals(vectorForwardBtn)) {
            Intent intent = new Intent(this, VectorDrawableActivity.class);
            startActivity(intent);
        } else if(view.equals(imageSampleBtn)){
            Intent intent = new Intent(this, ImageSampleActivity.class);
            startActivity(intent);
        }
    }
}
