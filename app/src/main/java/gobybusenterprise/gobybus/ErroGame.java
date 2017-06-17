package gobybusenterprise.gobybus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ErroGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_erro_game);


        Button button = (Button) findViewById(R.id.ButtonNovaRodada);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent myIntent = new Intent(ErroGame.this, StartGame.class);
                startActivity(myIntent);
            }
        });

    }
}
