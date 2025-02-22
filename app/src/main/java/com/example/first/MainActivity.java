package com.example.first;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Integer counter = 0;
    private Integer colorCount = 0;

    public void onClickBoxes(View view){
        counter++;
        TextView textView = findViewById(R.id.some);
        textView.setText(counter.toString());
    }
    public void onClickColorChange(View view){
        ConstraintLayout backg = findViewById(R.id.main);
        if(colorCount==3){
            colorCount=1;
        }else{
            colorCount++;
        }
        switch (colorCount){
            case 1:
                backg.setBackgroundColor(Color.parseColor("#ff0000"));
                break;
            case 2:
                backg.setBackgroundColor(Color.parseColor("#ffff00"));
                break;
            case 3:
                backg.setBackgroundColor(Color.parseColor("#00ff00"));
                break;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("LOG", "onCreate");
        Toast.makeText(this, "onCreate()", Toast.LENGTH_LONG).show();
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    @Override
    protected void onStop(){
        super.onStop();
        Toast.makeText(this, "onStop()", Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Toast.makeText(this, "onDestroy()", Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onStart(){
        super.onStart();
        Toast.makeText(this, "onStart()", Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onResume(){
        super.onResume();
        Toast.makeText(this, "onResume()", Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onPause(){
        super.onPause();
        Toast.makeText(this, "onPause()", Toast.LENGTH_LONG).show();
    }
    @Override
    protected void onSaveInstanceState(Bundle outstate){
        super.onSaveInstanceState(outstate);
        outstate.putInt("what", counter);
        outstate.putInt("what2", colorCount);
        Log.d("Instance", "Saved");
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstance){
        super.onRestoreInstanceState(savedInstance);
        if(savedInstance!=null && savedInstance.containsKey("what")){
            counter=savedInstance.getInt("what");
            Log.d("Instance", "Get");
        }
        if(savedInstance!=null && savedInstance.containsKey("what2")){
            colorCount=savedInstance.getInt("what2");
            Log.d("Instance", "Get");
        }
    }

}