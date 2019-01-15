[![](https://jitpack.io/v/HamidrezaAmz/MagicalNotifier.svg)](https://jitpack.io/#HamidrezaAmz/MagicalNotifier)
[![API](https://img.shields.io/badge/API-17%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=17)

# MagicalNotifier
This is a helper library for showing notifications on android devices in an easy way ;)



## Getting Started

These instructions will help you to use this library inside your projects

### Prerequisites

This library was built with **androidX**, so you should migrate into androidX to use this library with out any problem. For migration you can use [Migrating to AndroidX](https://developer.android.com/jetpack/androidx/migrate)

### Installing

Step 1. Add the JitPack repository to your build file,
Add it in your root build.gradle at the end of repositories:

```gradle
allprojects {
        repositories {
            ...
            maven { url 'https://jitpack.io' }
        }
    }
```

Step 2. Add the dependency

```gradle
dependencies {
    implementation 'com.github.HamidrezaAmz:MagicalNotifier:v1.0.2'
}
```

### Properties

| Variables | Description |
| --- | --- |
| `title` | Title of notification |
| `subTitle` | sub-title of notification  |
| `smallIcon` | This use as small icon of notification, **should be andrid res address** |
| `largeIcon` | This use as large icon of notification (Avatar), **should be andrid res address** |
| `actionButtonOne` | First action button of notification |
| `actionButtonTwo` | Second action button of notification |
| `actionButtonThree` | Third action button of notification |
| `bigPictureUrl` | Big picture **url**, notification will show after downloading picture |
| `bigText` | Big text variable, you can set big text into it |
| `EnumNotificationType` | If you want to use assumption notification types you can use **EnumNotificationType** |

### Here we go for implementation

1. Simple notification

```java
new MagicalNotifier.Builder(this)
                .setNotificationType(EnumNotificationType.SIMPLE)
                .setTitle(NOTIFICATION_TITLE)
                .setSubTitle(NOTIFICATION_SUB_TITLE)
                .show();
```

![notification](https://raw.githubusercontent.com/HamidrezaAmz/MagicalNotifier/master/ScreenShots/notification_simple.jpg "notification")

2. Simple notification with avatar (res)

```java
new MagicalNotifier.Builder(this)
                .setNotificationType(EnumNotificationType.SIMPLE_WITH_AVATAR)
                .setTitle(NOTIFICATION_TITLE)
                .setSubTitle(NOTIFICATION_SUB_TITLE)
                .setLargeIcon(R.drawable.ic_avatar)
                .show();
```
![notification](https://raw.githubusercontent.com/HamidrezaAmz/MagicalNotifier/master/ScreenShots/notification_simple_with_avatar.jpg "notification")

3. Simple notification with avatar and button (button action can open link)

```java
new MagicalNotifier.Builder(this)
                .setNotificationType(EnumNotificationType.SIMPLE_WITH_AVATAR_AND_BUTTON)
                .setTitle(NOTIFICATION_TITLE)
                .setSubTitle(NOTIFICATION_SUB_TITLE)
                .setLargeIcon(R.drawable.ic_avatar)
                .setActionButtonOne(new ActionButton("Update", EnumNotificationAction.OPEN_URL, "https://www.google.com/"))
                .show();
```
![notification](https://raw.githubusercontent.com/HamidrezaAmz/MagicalNotifier/master/ScreenShots/notification_simple_with_avatar_and_button.jpg "notification")

4. Notification with big picture

```java
new MagicalNotifier.Builder(this)
                .setNotificationType(EnumNotificationType.BIG_PICTURE)
                .setTitle(NOTIFICATION_TITLE)
                .setSubTitle(NOTIFICATION_SUB_TITLE)
                .setBigPictureUrl("https://www.androidhive.info/wp-content/uploads/2018/09/android-logging-using-timber-min.jpg")
                .show();
```
![notification](https://raw.githubusercontent.com/HamidrezaAmz/MagicalNotifier/master/ScreenShots/notification_big_picture.jpg "notification")


5. Notification with big text

```java
new MagicalNotifier.Builder(this)
                .setNotificationType(EnumNotificationType.BIG_TEXT)
                .setTitle(NOTIFICATION_TITLE)
                .setSubTitle(NOTIFICATION_SUB_TITLE)
                .setBigText("One of the most amazing things about Design Support Library is that we can create lively animated UIs with some simple configuration in XML. No code nor deep control about scrolls is required, so the process becomes really easy. We saw that Coordinator Layout is the central point the other components rely on to work properly, and that AppBarLayout helps the toolbar and other components to react to scroll changes. Today, I’ll show you how to use Collapsing Toolbar Layout to create awesome effects in a very easy way.")
                .show();
```
![notification](https://raw.githubusercontent.com/HamidrezaAmz/MagicalNotifier/master/ScreenShots/notification_big_text.jpg "notification")

6. Notification Smart, I recommend to use this type of notification, you can set any property that you want, then notification check your inputs and decide what to show, so you can mix notification facilities with each other. For example look at this code snippet

```java
new MagicalNotifier.Builder(this)
                .setTitle(NOTIFICATION_TITLE)
                .setSubTitle(NOTIFICATION_SUB_TITLE)
                .setBigPictureUrl("https://www.androidhive.info/wp-content/uploads/2018/09/android-logging-using-timber-min.jpg")
                .setActionButtonOne(new ActionButton("Update", EnumNotificationAction.OPEN_URL, "https://www.google.com/"))
                .show();
```

![notification](https://raw.githubusercontent.com/HamidrezaAmz/MagicalNotifier/master/ScreenShots/notification_smart.jpg "notification")
