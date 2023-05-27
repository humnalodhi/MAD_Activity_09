package com.example.mad_activity_09;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private int result;

    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences("CalculatorPrefs", MODE_PRIVATE);

        // Retrieve the saved result value
        result = sharedPreferences.getInt("result", 0);

        // Set up the result TextView
        resultTextView = findViewById(R.id.resultTextView);
        resultTextView.setText(String.valueOf(result));

        // Set up the add and subtract buttons
        Button addButton = findViewById(R.id.addButton);
        Button subtractButton = findViewById(R.id.subtractButton);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int value = Integer.parseInt(resultTextView.getText().toString());
                result = value + 1;
                resultTextView.setText(String.valueOf(result));
                saveResult();
            }
        });

        subtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int value = Integer.parseInt(resultTextView.getText().toString());
                result = value - 1;
                resultTextView.setText(String.valueOf(result));
                saveResult();
            }
        });
    }

    private void saveResult() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("result", result);
        editor.apply();
    }
}
