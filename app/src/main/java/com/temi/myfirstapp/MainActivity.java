package com.temi.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.robotemi.sdk.Robot;
import com.robotemi.sdk.listeners.OnRobotReadyListener;

public class MainActivity extends AppCompatActivity implements OnRobotReadyListener {

    Button btnFront, btnRight, btnLeft, btnBack;
    private Robot robot = Robot.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFront = findViewById(R.id.button1);
        btnRight = findViewById(R.id.button2);
        btnLeft = findViewById(R.id.button3);
        btnBack = findViewById(R.id.button4);

        btnFront.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //robot.skidJoy(1,0, true);
            }
        });

        btnRight.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                robot.turnBy(90);
                //robot.skidJoy(1,0, true);
            }
        });

        btnLeft.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                robot.turnBy(-90);
                //robot.skidJoy(1,0,true);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                robot.turnBy(180);
                //robot.skidJoy(1,0,true);
            }
        });
    }

    protected void onStart() {
        super.onStart();
        robot.addOnRobotReadyListener(this);
    }

    protected void onStop() {
        super.onStop();
        robot.removeOnRobotReadyListener(this);
    }

    @Override
    public void onRobotReady(boolean isReady) {
        if (isReady) {
            try {
                final ActivityInfo activityInfo = getPackageManager().getActivityInfo(getComponentName(), PackageManager.GET_META_DATA);
                robot.onStart(activityInfo);
            } catch (PackageManager.NameNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}