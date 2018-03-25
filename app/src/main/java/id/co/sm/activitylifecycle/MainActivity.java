package id.co.sm.activitylifecycle;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnCapture;
    private ImageView imgHelloWorld;
    private Bitmap bitmap;
    private TextView tvHelloWorld;
    private Bundle savedInstanceState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(this, "Activity create", Toast.LENGTH_SHORT).show();
        setContentView(R.layout.activity_main);

    }

    private void showNotification(){
        Intent notificationIntent = new Intent(this, MainActivity.class);

        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                | Intent.FLAG_ACTIVITY_SINGLE_TOP);

        PendingIntent intent = PendingIntent.getActivity(this, 0,
                notificationIntent, 0);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, "lifecycle")
                .setSmallIcon(android.R.drawable.sym_def_app_icon)
                .setContentTitle("Activity Lifecycle")
                .setContentText("onPause")
                .setContentIntent(intent)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0, mBuilder.build());
    }

    private void removeNotification(){
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.cancel(0);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "Activity pause", Toast.LENGTH_SHORT).show();
        showNotification();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "Activity resume", Toast.LENGTH_SHORT).show();
        removeNotification();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Activity start", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "Activity stop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Activity destroy", Toast.LENGTH_SHORT).show();
    }

}
