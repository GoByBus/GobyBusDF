package gobybusenterprise.gobybus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Rota extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rota);


        ImageButton button = (ImageButton) findViewById(R.id.ButtonJogar);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent myIntent = new Intent(Rota.this, StartGame.class);
                startActivity(myIntent);
            }
        });
    }
}
