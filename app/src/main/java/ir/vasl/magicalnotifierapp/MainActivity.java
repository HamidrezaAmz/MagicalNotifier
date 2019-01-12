package ir.vasl.magicalnotifierapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import ir.vasl.globalEnums.EnumNotificationAction;
import ir.vasl.globalEnums.EnumNotificationType;
import ir.vasl.globalObjects.ActionButton;
import ir.vasl.magicalnotifier.MagicalNotifier;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonSimpleNotification, buttonSimpleNotificationWithAvatar, buttonSimpleNotificationWithAvatarAndButton, buttonBigPictureNotification, buttonBigTextNotification, buttonBigVideoNotification;

    public native String stringFromJNI();

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSimpleNotification = findViewById(R.id.button_simple_notification);
        buttonSimpleNotification.setOnClickListener(this);
        buttonSimpleNotificationWithAvatar = findViewById(R.id.button_simple_notification_with_avatar);
        buttonSimpleNotificationWithAvatar.setOnClickListener(this);
        buttonSimpleNotificationWithAvatarAndButton = findViewById(R.id.button_simple_notification_with_avatar_and_buttons);
        buttonSimpleNotificationWithAvatarAndButton.setOnClickListener(this);
        buttonBigPictureNotification = findViewById(R.id.button_big_picture_notification);
        buttonBigPictureNotification.setOnClickListener(this);
        buttonBigTextNotification = findViewById(R.id.button_big_text_notification);
        buttonBigTextNotification.setOnClickListener(this);
        buttonBigVideoNotification = findViewById(R.id.button_big_video_notification);
        buttonBigVideoNotification.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_simple_notification:
                showSimpleNotification();
                break;
            case R.id.button_simple_notification_with_avatar:
                showSimpleNotificationWithAvatar();
                break;
            case R.id.button_simple_notification_with_avatar_and_buttons:
                showSimpleNotificationWithAvatarAndButton();
                break;
            case R.id.button_big_picture_notification:
                break;
            case R.id.button_big_text_notification:
                break;
            case R.id.button_big_video_notification:
                break;
        }
    }

    private void showSimpleNotification() {

        MagicalNotifier magicalNotifier = new MagicalNotifier.Builder(this)
                .setNotificationType(EnumNotificationType.SIMPLE)
                .setTitle("This is title :p")
                .setSubTitle("This simple notification ;)")
                .show();
    }

    private void showSimpleNotificationWithAvatar() {

        MagicalNotifier magicalNotifier = new MagicalNotifier.Builder(this)
                .setNotificationType(EnumNotificationType.SIMPLE_WITH_AVATAR)
                .setTitle("This is title :p")
                .setSubTitle("This is simple notification with avatar ;)")
                .show();
    }

    private void showSimpleNotificationWithAvatarAndButton() {

        MagicalNotifier magicalNotifier = new MagicalNotifier.Builder(this)
                .setNotificationType(EnumNotificationType.SIMPLE_WITH_AVATAR_AND_BUTTON)
                .setTitle("This is title :p")
                .setSubTitle("This is simple notification with avatar and button ;)")
                .setActionButtonOne(new ActionButton("Update", EnumNotificationAction.OPEN_URL, "https://www.google.com/"))
                .show();
    }

}
