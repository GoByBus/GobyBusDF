package gobybusenterprise.gobybus;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class StartGame extends AppCompatActivity {

    int metros = 500;

    CountDownTimer mCountDownTimer;
    long mInitialTime = DateUtils.DAY_IN_MILLIS * 2 +
            DateUtils.HOUR_IN_MILLIS * 9 +
            DateUtils.MINUTE_IN_MILLIS * 3 +
            DateUtils.SECOND_IN_MILLIS * 42;
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_game);

        ImageButton button1 = (ImageButton) findViewById(R.id.Buttonloja1);
        ImageButton button2 = (ImageButton) findViewById(R.id.Buttonloja2);
        ImageButton button3 = (ImageButton) findViewById(R.id.Buttonloja3);
        ImageButton button4 = (ImageButton) findViewById(R.id.Buttonloja4);


        TextView textoDistanciaMetros = (TextView) findViewById(R.id.TextViewDistanciaMetros);
        textoDistanciaMetros.setText(" " + metros + " metros");

        button1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent myIntent = new Intent(StartGame.this, AcertoGame.class);
                startActivity(myIntent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent myIntent = new Intent(StartGame.this, AcertoGame.class);
                startActivity(myIntent);
            }
        });

        button3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent myIntent = new Intent(StartGame.this, AcertoGame.class);
                startActivity(myIntent);
            }
        });

        button1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent myIntent = new Intent(StartGame.this, AcertoGame.class);
                startActivity(myIntent);
            }
        });
    }

    @Override
    protected void onResume() {
/*        final TextView textoDistanciaMetros = (TextView) findViewById(R.id.TextViewDistanciaMetros);
        mCountDownTimer = new CountDownTimer(mInitialTime, 1000) {
            StringBuilder time = new StringBuilder();
            @Override
            public void onFinish() {
                mTextView.setText(DateUtils.formatElapsedTime(0));
                textoDistanciaMetros.setText(" " + metros + " metros");
            }
            @Override
            public void onTick(long millisUntilFinished) {
                time.setLength(0);
                // Use days if appropriate
                if(millisUntilFinished > DateUtils.DAY_IN_MILLIS) {
                    long count = millisUntilFinished / DateUtils.DAY_IN_MILLIS;
                    if(count > 1)
                        time.append(count).append(" days ");
                    else
                        time.append(count).append(" day ");

                    millisUntilFinished %= DateUtils.DAY_IN_MILLIS;
                }
                time.append(DateUtils.formatElapsedTime(Math.round(millisUntilFinished / 1000d)));
                mTextView.setText(time.toString());
            }
        }.start();*/

        super.onResume();
    }


}
