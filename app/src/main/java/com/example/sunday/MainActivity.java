package com.example.sunday;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;

import com.example.sunday.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        a= DataBindingUtil.setContentView(this,R.layout.activity_main);

        a.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a.textView.setText(a.editTextText.getText().toString());
                Toast.makeText(MainActivity.this, a.editTextText.getText().toString(), Toast.LENGTH_SHORT).show();
                Intent x=new Intent(MainActivity.this,MainActivity2.class);
                startActivity(x);

                String s = a.editTextText.getText().toString();
               Toast.makeText(MainActivity.this, s,
                        Toast.LENGTH_SHORT).show();
                a.textView.setText(a.editTextText.getText().toString());

                Intent z = new Intent(MainActivity.this,MainActivity2.class);
                z.putExtra("a",s);

                startActivity(z);


            }
        });


        a.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder art = new AlertDialog.Builder(MainActivity.this);
                art.setTitle("Today is learning day");
                art.setMessage("Sunday also we will learn");
                art.setIcon(android.R.drawable.star_big_on);
                art.setPositiveButton("Positive",null);
                art.setNegativeButton("Neg",null);
                art.setNeutralButton("SDM", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "sdm got clicked !", Toast.LENGTH_SHORT).show();
                    }
                });
                art.show();

            }
        });

        a.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shownofn();
            }
            public void shownofn() {
                NotificationManager notificationManager = (NotificationManager) MainActivity.this.getSystemService(Context.NOTIFICATION_SERVICE);

                int notificationId = 1;
                String channelId = "channel-01";
                String channelName = "Channel Name";
                int importance = NotificationManager.IMPORTANCE_HIGH;

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    NotificationChannel mChannel = new NotificationChannel(
                            channelId, channelName, importance);
                    notificationManager.createNotificationChannel(mChannel);
                }

                NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(MainActivity.this, channelId)
                        .setLargeIcon(BitmapFactory.decodeResource(MainActivity.this.getResources(), android.R.drawable.star_big_on))
                        .setSmallIcon(android.R.drawable.star_big_on).setContentTitle("You can also 'Learn Android'")
                        .setStyle(new NotificationCompat.BigPictureStyle().bigPicture( BitmapFactory.decodeResource(MainActivity.this.getResources(),android.R.drawable.star_big_on)))
                        .setContentText("Contact AndroidManifester today!!");

                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0, intent, PendingIntent.FLAG_MUTABLE);
                mBuilder.setContentIntent(pendingIntent);

                notificationManager.notify(notificationId, mBuilder.build());
            }
        });





    }
}