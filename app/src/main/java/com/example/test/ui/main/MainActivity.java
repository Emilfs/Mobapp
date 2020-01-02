package com.example.test.ui.main;

import android.Manifest;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;

import com.example.test.R;
import com.example.test.data.income.ApiService;
import com.example.test.data.income.Gold;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    public static final String CHANNEL_1_ID = "channel1";
    private static final int uniqueID = 45612;

    private NotificationManagerCompat notificationManager;

    private int CAMERA_PERMISSION_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        //NativeConnection connection = new NativeConnection();
        //int hasil = connection.div(120, 4);
        //int hasil = getGoldPrice();

        createNotificationChannels();
        notificationManager = NotificationManagerCompat.from(this);

        Button buttonRequest = findViewById(R.id.permissionButton);
        buttonRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)  {
                if (ContextCompat.checkSelfPermission(MainActivity.this,
                        Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(MainActivity.this, "You have already granted this permission!", Toast.LENGTH_SHORT).show();
                } else {
                    requestCameraPermission();
                }
            }
        });
    }

    private void requestCameraPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {
            new AlertDialog.Builder(this)
                    .setTitle("Permission Needed")
                    .setMessage("This permission is needed")
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions(MainActivity.this, new String[] {Manifest.permission.CAMERA}, CAMERA_PERMISSION_CODE);
                        }
                    })
                    .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .create().show();
        } else {
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.CAMERA}, CAMERA_PERMISSION_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == CAMERA_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void createNotificationChannels(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel1 = new NotificationChannel(
                    CHANNEL_1_ID,
                    "Channel 1",
                    NotificationManager.IMPORTANCE_HIGH
            );
            channel1.setDescription("This is Channel 1");

            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel1);
        }
    }

    public void sendOnChannel1(View v) {
        String title = "Connected";
        String message = "Getting Gold Price..";

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_1_ID)
                .setSmallIcon(R.drawable.notif_icon)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .build();
        notificationManager.notify(1, notification);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }

    public void getGoldPrice() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.indogold.com/ajax/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);
        Single<Gold> gold = apiService.getGoldData(0);
        gold.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((new SingleObserver<Gold>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        //compositeDisposable.add(d);
                    }

                    @Override
                    public void onSuccess(Gold gold) {
                        int hasil = gold.getData().get(0).get(1);
                        TextView tv = findViewById(R.id.tv_jni_result);
                        tv.setText(hasil);
                    }
                    @Override
                    public void onError(Throwable e) {
                        // show error
                    }
                }));
//        int goldPrice = gold.getData().get(0).get(0);
//
//        return goldPrice;
    }

//    @Override
//    protected void onDestroy() {
//        if (!compositeDisposable.isDisposed()) {
//            compositeDisposable.dispose();
//        }
//        super.onDestroy();
//    }
}
