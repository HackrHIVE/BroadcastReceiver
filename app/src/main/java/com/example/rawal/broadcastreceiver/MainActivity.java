package com.example.rawal.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MyBrdcstRCVR myReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
    }

    public void RegisterBroadcastRCVR(View view) {
        myReceiver = new MyBrdcstRCVR();
        IntentFilter ifilter = new IntentFilter(  );
        ifilter.addAction( "android.provider.Telephony.SMS_RECEIVED" );
        registerReceiver( myReceiver, ifilter );
        Toast.makeText( this, "BroadCast Receivers Registered for SMS", Toast.LENGTH_SHORT ).show();
        Log.i( "Button Clicked : ","BroadCast Receivers Registered for SMS" );
    }

    class MyBrdcstRCVR extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            String message = intent.getData().toString();
            Log.i( "SMS Received : ",message );
            Toast.makeText( MainActivity.this, "SMS Received : "+message, Toast.LENGTH_SHORT ).show();
        }
    }
}
