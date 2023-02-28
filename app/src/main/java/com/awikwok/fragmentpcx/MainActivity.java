package com.awikwok.fragmentpcx;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button mButton;
    private boolean isClicked = false;
    TextView content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = findViewById(R.id.button1);
        displayFragment();

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                displayFragment();
            }

        });
    }


    private void displayFragment() {
        SimpleFragment simpleFragment = new SimpleFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager
                .beginTransaction();
        if(!isClicked){
            fragmentTransaction.replace(R.id.fragment_container, new SimpleFragment());
            mButton.setText("Lihat Kelebihan");
            isClicked = true;

        }
        else {
            fragmentTransaction.replace(R.id.fragment_container,new SImpleFragment2());
            mButton.setText("Mantap!");
            isClicked = false;
        }
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
