package com.raymond.memorymonster;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import java.util.ArrayList;
import java.util.Random;

public class ServiceC extends Service {

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

//                    Log.d("ServiceC", "run: " + s);

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
