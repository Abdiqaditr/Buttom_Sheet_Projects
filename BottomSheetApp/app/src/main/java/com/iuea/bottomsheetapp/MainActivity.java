package com.iuea.bottomsheetapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button openBottomSheet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the button
        openBottomSheet = findViewById(R.id.open_bottom_sheet);

        // Open Bottom Sheet when button is clicked
        openBottomSheet.setOnClickListener(v -> {
            MyBottomSheetFragment bottomSheetFragment = new MyBottomSheetFragment();
            bottomSheetFragment.show(getSupportFragmentManager(), "MyBottomSheetFragment");
        });
    }
}
