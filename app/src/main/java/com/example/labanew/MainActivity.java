package com.example.labanew;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ConstraintLayout constraintLayout;
    private Button oneButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void onClick(View view) {
        constraintLayout = (ConstraintLayout) findViewById(R.id.constraintLayout);
        oneButton = (Button) findViewById(R.id.oneButton);
        ConnectivityManager connectivityManager = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {

            oneButton.setVisibility(View.INVISIBLE);

            constraintLayout.setBackground(getDrawable(R.drawable.online));
            Toast toast1 = Toast.makeText(getApplicationContext(),
                    "Подключение есть \n Добро пожаловать в приложение!", Toast.LENGTH_LONG);
            toast1.show();
        } else {
            oneButton.setVisibility(View.INVISIBLE);
            constraintLayout.setBackground(getDrawable(R.drawable.offline));
            Toast toast2 = Toast.makeText(getApplicationContext(),
                    "Нeт подключения. Разрешите доступ и повторите попытку.", Toast.LENGTH_LONG);
            toast2.show();
        }
    }
}