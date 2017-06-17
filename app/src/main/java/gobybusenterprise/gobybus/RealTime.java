package gobybusenterprise.gobybus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.gms.maps.GoogleMap;

import gobybusenterprise.gobybus.integracao.OnibusGPSService;

public class RealTime extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_real_time);

        //OnibusGPSService onibusGPSService = new OnibusGPSService();
        //onibusGPSService.plotarPins(null);

        Intent secondActivity = new Intent(this, MapsActivity.class);
        //secondActivity.
        //startActivity(secondActivity);


        ImageButton button = (ImageButton) findViewById(R.id.ButtonIr);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent myIntent = new Intent(RealTime.this, Rota.class);
                RealTime.this.startActivity(myIntent);
            }
        });
    }
}
