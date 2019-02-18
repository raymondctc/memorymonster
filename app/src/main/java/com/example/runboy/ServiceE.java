package com.example.runboy;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

public class ServiceE extends Service {

    private ArrayList<String> strings = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();

        new Thread(){
            String s = "1";
            @Override
            public void run() {
                while (true) {
                    s += "" + new Random().nextInt() + new byte[1024000];

//                    Log.d("ServiceE", "run: " + s);

                    strings.add(s);
                }
            }
        }.start();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
