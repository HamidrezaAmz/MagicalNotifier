package ir.vasl.globalObjects;

import ir.vasl.globalEnums.EnumNotificationAction;

/**
 * Created by HamidReza on 12,January,2019
 * Happy Coding ;)
 */
public class ActionButton {

    private int icon = -1;
    private String title;
    private EnumNotificationAction EnumNotificationAction;
    private String targetUrl;

    public ActionButton(String title) {
        this.title = title;
    }

    public ActionButton(int icon, String title) {
        this.icon = icon;
        this.title = title;
    }

    public ActionButton(String title, ir.vasl.globalEnums.EnumNotificationAction enumNotificationAction) {
        this.title = title;
        EnumNotificationAction = enumNotificationAction;
    }

    public ActionButton(String title, ir.vasl.globalEnums.EnumNotificationAction enumNotificationAction, String targetUrl) {
        this.title = title;
        EnumNotificationAction = enumNotificationAction;
        this.targetUrl = targetUrl;
    }

    public ActionButton(int icon, String title, ir.vasl.globalEnums.EnumNotificationAction enumNotificationAction) {
        this.icon = icon;
        this.title = title;
        EnumNotificationAction = enumNotificationAction;
    }

    public ActionButton(int icon, String title, ir.vasl.globalEnums.EnumNotificationAction enumNotificationAction, String targetUrl) {
        this.icon = icon;
        this.title = title;
        EnumNotificationAction = enumNotificationAction;
        this.targetUrl = targetUrl;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public EnumNotificationAction getEnumNotificationAction() {
        return EnumNotificationAction;
    }

    public void setEnumNotificationAction(EnumNotificationAction enumNotificationAction) {
        EnumNotificationAction = enumNotificationAction;
    }

    public String getTargetUrl() {
        return targetUrl;
    }

    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
    }
}
