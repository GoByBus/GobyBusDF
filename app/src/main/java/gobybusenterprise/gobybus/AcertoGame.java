package gobybusenterprise.gobybus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class AcertoGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerto_game);

        ImageButton button = (ImageButton) findViewById(R.id.ButtonNovaRodada);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent myIntent = new Intent(AcertoGame.this, StartGame.class);
                startActivity(myIntent);
            }
        });
    }
}
