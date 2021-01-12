package activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ntd.shopping.R;

import util.CheckInternetConnection;

public class loading extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        Thread myThread = new Thread(){
            @Override
            public void run(){
                try {
                    //CheckInternetConnection.ShowToast_Short(getApplicationContext(),"Login Success");
                    sleep(1000);
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);

                    finish ();
                } catch (InterruptedException e)
                { e.printStackTrace();}

            }
        };
        myThread.start();
    }
}
