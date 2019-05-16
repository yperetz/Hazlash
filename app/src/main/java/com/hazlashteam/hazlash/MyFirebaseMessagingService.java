package com.hazlashteam.hazlash;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.io.IOException;
import java.net.URL;
import java.util.Map;

public class MyFirebaseMessagingService extends FirebaseMessagingService {


    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        super.onMessageReceived(remoteMessage);
        RemoteMessage.Notification notification = remoteMessage.getNotification();
        Map<String,String> data = remoteMessage.getData();
       sendNotification(notification,data);

        }

        private void sendNotification(RemoteMessage.Notification notification,Map<String,String> data){
            NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this,"channel_id");
            try{
                String picture_url = data.get("picture_url");
                if(picture_url != null && !"".equals(picture_url)){
                    URL url = new URL(picture_url);
                    Bitmap bigPicture = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                    notificationBuilder.setStyle(
                            new NotificationCompat.BigPictureStyle().bigPicture(bigPicture).setSummaryText(notification.getBody()));
                }
            }
            catch (IOException e){
                e.printStackTrace();
            }
            NotificationManager  notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(0,notificationBuilder.build());
        }


}
