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

    private String NOTIFICATION_TITLE = "This notification title";
    private String NOTIFICATION_SUB_TITLE = "This is notification subTitle!";

    Button buttonSimpleNotification;
    Button buttonSimpleNotificationWithAvatar;
    Button buttonSimpleNotificationWithAvatarAndButton;
    Button buttonBigPictureNotification, buttonBigTextNotification;
    Button buttonSmartNotification;
    Button buttonCustomNotification;
    Button buttonWithUpdate;

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
        buttonSmartNotification = findViewById(R.id.button_smart_notification);
        buttonSmartNotification.setOnClickListener(this);
        buttonCustomNotification = findViewById(R.id.button_custom_notification);
        buttonCustomNotification.setOnClickListener(this);
        buttonWithUpdate = findViewById(R.id.button_notification_with_update);
        buttonWithUpdate.setOnClickListener(this);
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
                showBigPictureNotification();
                break;
            case R.id.button_big_text_notification:
                showBigTextNotification();
                break;
            case R.id.button_smart_notification:
                showSmartNotification();
                break;
            case R.id.button_custom_notification:
                showCustomNotification();
                break;
            case R.id.button_notification_with_update:
                showNotificationWithUpdate();
                break;
        }
    }

    private void showSimpleNotification() {

        new MagicalNotifier.Builder(this)
                .setNotificationType(EnumNotificationType.SIMPLE)
                .setTitle(NOTIFICATION_TITLE)
                .setSubTitle(NOTIFICATION_SUB_TITLE)
                .show();
    }

    private void showSimpleNotificationWithAvatar() {

        new MagicalNotifier.Builder(this)
                .setNotificationType(EnumNotificationType.SIMPLE_WITH_AVATAR)
                .setTitle(NOTIFICATION_TITLE)
                .setSubTitle(NOTIFICATION_SUB_TITLE)
                .setLargeIcon(R.drawable.ic_launcher_background)
                .show();
    }

    private void showSimpleNotificationWithAvatarAndButton() {

        new MagicalNotifier.Builder(this)
                .setNotificationType(EnumNotificationType.SIMPLE_WITH_AVATAR_AND_BUTTON)
                .setTitle(NOTIFICATION_TITLE)
                .setSubTitle(NOTIFICATION_SUB_TITLE)
                .setActionButtonOne(new ActionButton("Update", EnumNotificationAction.OPEN_URL, "https://www.google.com/"))
                .show();
    }

    private void showBigPictureNotification() {

        new MagicalNotifier.Builder(this)
                .setNotificationType(EnumNotificationType.BIG_PICTURE)
                .setTitle(NOTIFICATION_TITLE)
                .setSubTitle(NOTIFICATION_SUB_TITLE)
                .setBigPictureUrl("https://www.androidhive.info/wp-content/uploads/2018/09/android-logging-using-timber-min.jpg")
                .show();
    }

    private void showBigTextNotification() {

        new MagicalNotifier.Builder(this)
                .setNotificationType(EnumNotificationType.BIG_TEXT)
                .setTitle(NOTIFICATION_TITLE)
                .setSubTitle(NOTIFICATION_SUB_TITLE)
                .setBigText("One of the most amazing things about Design Support Library is that we can create lively animated UIs with some simple configuration in XML. No code nor deep control about scrolls is required, so the process becomes really easy. We saw that Coordinator Layout is the central point the other components rely on to work properly, and that AppBarLayout helps the toolbar and other components to react to scroll changes. Today, I’ll show you how to use Collapsing Toolbar Layout to create awesome effects in a very easy way.")
                .show();
    }

    private void showSmartNotification() {
        new MagicalNotifier.Builder(this)
                .setTitle(NOTIFICATION_TITLE)
                .setSubTitle(NOTIFICATION_SUB_TITLE)
                .show();
    }

    private void showCustomNotification() {
        new MagicalNotifier.Builder(this)
                .setNotificationType(EnumNotificationType.CUSTOM)
                .setTitle(NOTIFICATION_TITLE)
                .setSubTitle(NOTIFICATION_SUB_TITLE)
                .show();
    }

    private void showNotificationWithUpdate() {

        int notificationId = 8585;
        MagicalNotifier magicalNotifier = new MagicalNotifier.Builder(this)
                .setNotificationId(notificationId)
                .setTitle(NOTIFICATION_TITLE)
                .setSubTitle(NOTIFICATION_SUB_TITLE)
                .show();

        // update
        magicalNotifier.getBuilder().notifyTitle(notificationId, "Title updated ;)");
    }

}
