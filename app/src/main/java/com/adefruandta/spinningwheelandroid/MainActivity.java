package com.adefruandta.spinningwheelandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import java.util.concurrent.ThreadLocalRandom;

import com.adefruandta.spinningwheel.SpinningWheelView;

public class MainActivity extends AppCompatActivity implements SpinningWheelView.OnRotationListener<String> {

    private SpinningWheelView wheelView;

    private ImageButton rotate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wheelView = (SpinningWheelView) findViewById(R.id.wheel);

        rotate = (ImageButton) findViewById(R.id.rotate);

        wheelView.setItems(R.array.dummy);
        wheelView.setOnRotationListener(this);

        rotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int randomNum = ThreadLocalRandom.current().nextInt(30, 99 + 1);

                // max angle 50
                // duration 10 second
                // every 50 ms rander rotation
                wheelView.rotate(randomNum, 4000, randomNum);
            }
        });
    }

    @Override
    public void onRotation() {
        Log.d("XXXX", "On Rotation");
    }

    @Override
    public void onStopRotation(String item) {
        Toast.makeText(this, item, Toast.LENGTH_LONG).show();
    }
}
