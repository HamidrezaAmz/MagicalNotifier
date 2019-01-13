package ir.vasl.magicalnotifier;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;

import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import ir.vasl.GlideApp;
import ir.vasl.Utils.PublicFunctions;
import ir.vasl.globalEnums.EnumNotificationType;
import ir.vasl.globalObjects.ActionButton;

import static ir.vasl.Utils.PublicValues.NOTIFICATION_CHANNEL_ID;
import static ir.vasl.Utils.PublicValues.NOTIFICATION_CHANNEL_NAME;
import static ir.vasl.Utils.PublicValues.NOTIFICATION_CHANNEL_SIMPLE;

/**
 * Created by HamidReza on 12,January,2019
 * Happy Coding ;)
 */
public class MagicalNotifier {

    private Context context;
    private int smallIcon = -1;
    private int largeIcon = -1;
    private ActionButton actionButtonOne = null;
    private ActionButton actionButtonTwo = null;
    private ActionButton actionButtonThree = null;
    private EnumNotificationType notificationType;
    private String title;
    private String subTitle;
    private String avatar;
    private String button;
    private String bigPictureUrl;
    private String bigText;
    private String bigVideoUrl;

    public MagicalNotifier() {
    }

    public MagicalNotifier(Context context, int smallIcon, int largeIcon, ActionButton actionButtonOne, ActionButton actionButtonTwo, ActionButton actionButtonThree, EnumNotificationType notificationType, String title, String subTitle, String avatar, String button, String bigPictureUrl, String bigText, String bigVideoUrl) {
        this.context = context;
        this.smallIcon = smallIcon;
        this.largeIcon = largeIcon;
        this.actionButtonOne = actionButtonOne;
        this.actionButtonTwo = actionButtonTwo;
        this.actionButtonThree = actionButtonThree;
        this.notificationType = notificationType;
        this.title = title;
        this.subTitle = subTitle;
        this.avatar = avatar;
        this.button = button;
        this.bigPictureUrl = bigPictureUrl;
        this.bigText = bigText;
        this.bigVideoUrl = bigVideoUrl;
    }

    public static class Builder {

        private Context context;
        private int smallIcon = -1;
        private int largeIcon = -1;
        private ActionButton actionButtonOne = null;
        private ActionButton actionButtonTwo = null;
        private ActionButton actionButtonThree = null;
        private EnumNotificationType notificationType = EnumNotificationType.SMART;
        private String title;
        private String subTitle;
        private String avatar;
        private String button;
        private String bigPictureUrl;
        private String bigText;
        private String bigVideoUrl;

        public Builder(Context context) {
            this.context = context;
        }

        public Builder setSmallIcon(int smallIcon) {
            this.smallIcon = smallIcon;
            return this;
        }

        public Builder setLargeIcon(int largeIcon) {
            this.largeIcon = largeIcon;
            return this;
        }

        public Builder setActionButtonOne(ActionButton actionButtonOne) {
            this.actionButtonOne = actionButtonOne;
            return this;
        }

        public Builder setActionButtonTwo(ActionButton actionButtonTwo) {
            this.actionButtonTwo = actionButtonTwo;
            return this;
        }

        public Builder setActionButtonThree(ActionButton actionButtonThree) {
            this.actionButtonThree = actionButtonThree;
            return this;
        }

        public Builder setNotificationType(EnumNotificationType notificationType) {
            this.notificationType = notificationType;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setSubTitle(String subTitle) {
            this.subTitle = subTitle;
            return this;
        }

        public Builder setAvatar(String avatar) {
            this.avatar = avatar;
            return this;
        }

        public Builder setButton(String button) {
            this.button = button;
            return this;
        }

        public Builder setBigPictureUrl(String bigPictureUrl) {
            this.bigPictureUrl = bigPictureUrl;
            return this;
        }

        public Builder setBigText(String bigText) {
            this.bigText = bigText;
            return this;
        }

        public Builder setBigVideoUrl(String bigVideoUrl) {
            this.bigVideoUrl = bigVideoUrl;
            return this;
        }

        public MagicalNotifier build() {
            return new MagicalNotifier(context, smallIcon, largeIcon, actionButtonOne, actionButtonTwo, actionButtonThree, notificationType, title, subTitle, avatar, button, bigPictureUrl, bigText, bigVideoUrl);
        }

        public MagicalNotifier show() {
            switch (notificationType) {
                case SIMPLE:
                    showSimpleNotification();
                    break;
                case SIMPLE_WITH_AVATAR:
                    showSimpleNotificationWithAvatar();
                    break;
                case SIMPLE_WITH_AVATAR_AND_BUTTON:
                    showSimpleNotificationWithAvatarAndButton();
                    break;
                case BIG_PICTURE:
                    showBigPictureNotification();
                    break;
                case BIG_TEXT:
                    showBigTextNotification();
                    break;
                case undefined:
                case SMART:
                    showSmartNotification();
                    break;
            }

            return new MagicalNotifier(context, smallIcon, largeIcon, actionButtonOne, actionButtonTwo, actionButtonThree, notificationType, title, subTitle, avatar, button, bigPictureUrl, bigText, bigVideoUrl);
        }

        private void showSimpleNotification() {
            if (smallIcon == -1)
                smallIcon = R.drawable.ic_default_notification;

            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context, NOTIFICATION_CHANNEL_SIMPLE)
                    .setSmallIcon(smallIcon)
                    .setContentTitle(title)
                    .setContentText(subTitle)
                    .setPriority(NotificationCompat.PRIORITY_HIGH);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                int color = 0x008000;
                mBuilder.setColor(color);
            }

            NotificationManager mNotificationManager =
                    (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                NotificationChannel channel = new NotificationChannel(NOTIFICATION_CHANNEL_ID,
                        NOTIFICATION_CHANNEL_NAME,
                        NotificationManager.IMPORTANCE_HIGH);
                mNotificationManager.createNotificationChannel(channel);
                mBuilder.setChannelId(NOTIFICATION_CHANNEL_ID);
            }

            // notificationId is a unique int for each notification that you must define
            mNotificationManager.notify(PublicFunctions.getNotificationID(), mBuilder.build());
        }

        private void showSimpleNotificationWithAvatar() {
            if (smallIcon == -1)
                smallIcon = R.drawable.ic_default_notification;

            if (largeIcon == -1)
                largeIcon = R.drawable.ic_default_large_notification;

            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context, NOTIFICATION_CHANNEL_SIMPLE)
                    .setSmallIcon(smallIcon)
                    .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), largeIcon))
                    .setContentTitle(title)
                    .setContentText(subTitle)
                    .setPriority(NotificationCompat.PRIORITY_HIGH);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                int color = 0xC0C0C0;
                mBuilder.setColor(color);
            }

            NotificationManager mNotificationManager =
                    (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                NotificationChannel channel = new NotificationChannel(NOTIFICATION_CHANNEL_ID,
                        NOTIFICATION_CHANNEL_NAME,
                        NotificationManager.IMPORTANCE_HIGH);
                mNotificationManager.createNotificationChannel(channel);
                mBuilder.setChannelId(NOTIFICATION_CHANNEL_ID);
            }

            // notificationId is a unique int for each notification that you must define
            mNotificationManager.notify(PublicFunctions.getNotificationID(), mBuilder.build());
        }

        private void showSimpleNotificationWithAvatarAndButton() {
            if (smallIcon == -1)
                smallIcon = R.drawable.ic_default_notification;

            if (largeIcon == -1)
                largeIcon = R.drawable.ic_default_large_notification;

            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context, NOTIFICATION_CHANNEL_SIMPLE)
                    .setSmallIcon(smallIcon)
                    .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), largeIcon))
                    .setContentTitle(title)
                    .setContentText(subTitle)
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setAutoCancel(true)
                    .setColor(ContextCompat.getColor(context, R.color.primary));

            if (actionButtonOne != null) {
                switch (actionButtonOne.getEnumNotificationAction()) {
                    case OPEN_URL:
                        Intent notificationIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(actionButtonOne.getTargetUrl()));
                        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, notificationIntent, 0);
                        mBuilder.addAction(actionButtonOne.getIcon(), actionButtonOne.getTitle(), pendingIntent);
                        break;

                    case OPEN_APP:
                        break;
                }
            }

            if (actionButtonTwo != null) {
                switch (actionButtonTwo.getEnumNotificationAction()) {
                    case OPEN_URL:
                        Intent notificationIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(actionButtonTwo.getTargetUrl()));
                        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, notificationIntent, 0);
                        mBuilder.addAction(actionButtonTwo.getIcon(), actionButtonTwo.getTitle(), pendingIntent);
                        break;

                    case OPEN_APP:
                        break;
                }
            }

            if (actionButtonThree != null) {
                // mBuilder.addAction(actionButtonThree.getIcon(), actionButtonThree.getTitle(), null);
                switch (actionButtonThree.getEnumNotificationAction()) {
                    case OPEN_URL:
                        Intent notificationIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(actionButtonThree.getTargetUrl()));
                        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, notificationIntent, 0);
                        mBuilder.addAction(actionButtonThree.getIcon(), actionButtonThree.getTitle(), pendingIntent);
                        break;

                    case OPEN_APP:
                        break;
                }
            }

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                int color = 0xC0C0C0;
                mBuilder.setColor(color);
            }

            NotificationManager mNotificationManager =
                    (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                NotificationChannel channel = new NotificationChannel(NOTIFICATION_CHANNEL_ID,
                        NOTIFICATION_CHANNEL_NAME,
                        NotificationManager.IMPORTANCE_HIGH);
                mNotificationManager.createNotificationChannel(channel);
                mBuilder.setChannelId(NOTIFICATION_CHANNEL_ID);
            }

            // notificationId is a unique int for each notification that you must define
            mNotificationManager.notify(PublicFunctions.getNotificationID(), mBuilder.build());
        }

        private void showBigPictureNotification() {
            if (smallIcon == -1)
                smallIcon = R.drawable.ic_default_notification;

            // NotificationCompat.BigPictureStyle bpStyle = new NotificationCompat.BigPictureStyle();
            // bpStyle.bigPicture(BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_big_picture_default)).build();

            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context, NOTIFICATION_CHANNEL_SIMPLE)
                    .setSmallIcon(smallIcon)
                    .setContentTitle(title)
                    .setContentText(subTitle)
                    .setPriority(Notification.PRIORITY_MAX)
                    .setLights(Color.YELLOW, 1000, 300);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                int color = 0x008000;
                mBuilder.setColor(color);
            }

            GlideApp
                    .with(context)
                    .asBitmap()
                    .load(bigPictureUrl)
                    .centerCrop()
                    .into(new SimpleTarget<Bitmap>() {
                        @Override
                        public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                            NotificationCompat.BigPictureStyle bigPictureStyle = new NotificationCompat.BigPictureStyle().bigPicture(resource);
                            bigPictureStyle.setSummaryText(subTitle);
                            mBuilder.setStyle(bigPictureStyle);

                            NotificationManager mNotificationManager =
                                    (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                NotificationChannel channel = new NotificationChannel(NOTIFICATION_CHANNEL_ID,
                                        NOTIFICATION_CHANNEL_NAME,
                                        NotificationManager.IMPORTANCE_HIGH);
                                mNotificationManager.createNotificationChannel(channel);
                                mBuilder.setChannelId(NOTIFICATION_CHANNEL_ID);
                            }

                            // notificationId is a unique int for each notification that you must define
                            mNotificationManager.notify(PublicFunctions.getNotificationID(), mBuilder.build());
                        }
                    });
        }

        private void showBigTextNotification() {
            if (smallIcon == -1)
                smallIcon = R.drawable.ic_default_notification;

            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context, NOTIFICATION_CHANNEL_SIMPLE)
                    .setSmallIcon(smallIcon)
                    .setContentTitle(title)
                    .setContentText(subTitle)
                    .setStyle(new NotificationCompat.BigTextStyle().bigText(bigText))
                    .setPriority(NotificationCompat.PRIORITY_HIGH);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                int color = 0x008000;
                mBuilder.setColor(color);
            }

            NotificationManager mNotificationManager =
                    (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                NotificationChannel channel = new NotificationChannel(NOTIFICATION_CHANNEL_ID,
                        NOTIFICATION_CHANNEL_NAME,
                        NotificationManager.IMPORTANCE_HIGH);
                mNotificationManager.createNotificationChannel(channel);
                mBuilder.setChannelId(NOTIFICATION_CHANNEL_ID);
            }

            // notificationId is a unique int for each notification that you must define
            mNotificationManager.notify(PublicFunctions.getNotificationID(), mBuilder.build());
        }

        private void showSmartNotification() {
            if (smallIcon == -1)
                smallIcon = R.drawable.ic_default_notification;

            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context, NOTIFICATION_CHANNEL_SIMPLE)
                    .setSmallIcon(smallIcon)
                    .setContentTitle(title)
                    .setContentText(subTitle)
                    .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), largeIcon))
                    .setPriority(NotificationCompat.PRIORITY_HIGH);

            if (largeIcon != -1)
                mBuilder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), largeIcon));

            if (actionButtonOne != null) {
                switch (actionButtonOne.getEnumNotificationAction()) {
                    case OPEN_URL:
                        Intent notificationIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(actionButtonOne.getTargetUrl()));
                        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, notificationIntent, 0);
                        mBuilder.addAction(actionButtonOne.getIcon(), actionButtonOne.getTitle(), pendingIntent);
                        break;

                    case OPEN_APP:
                        break;
                }
            }

            if (actionButtonTwo != null) {
                switch (actionButtonTwo.getEnumNotificationAction()) {
                    case OPEN_URL:
                        Intent notificationIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(actionButtonTwo.getTargetUrl()));
                        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, notificationIntent, 0);
                        mBuilder.addAction(actionButtonTwo.getIcon(), actionButtonTwo.getTitle(), pendingIntent);
                        break;

                    case OPEN_APP:
                        break;
                }
            }

            if (actionButtonThree != null) {
                // mBuilder.addAction(actionButtonThree.getIcon(), actionButtonThree.getTitle(), null);
                switch (actionButtonThree.getEnumNotificationAction()) {
                    case OPEN_URL:
                        Intent notificationIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(actionButtonThree.getTargetUrl()));
                        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, notificationIntent, 0);
                        mBuilder.addAction(actionButtonThree.getIcon(), actionButtonThree.getTitle(), pendingIntent);
                        break;

                    case OPEN_APP:
                        break;
                }
            }

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                int color = 0x008000;
                mBuilder.setColor(color);
            }

            if (bigPictureUrl != "") {

            } else {

                NotificationManager mNotificationManager =
                        (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    NotificationChannel channel = new NotificationChannel(NOTIFICATION_CHANNEL_ID,
                            NOTIFICATION_CHANNEL_NAME,
                            NotificationManager.IMPORTANCE_HIGH);
                    mNotificationManager.createNotificationChannel(channel);
                    mBuilder.setChannelId(NOTIFICATION_CHANNEL_ID);
                }

                // notificationId is a unique int for each notification that you must define
                mNotificationManager.notify(PublicFunctions.getNotificationID(), mBuilder.build());
            }
        }
    }

}
