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

### Here we go for implementation

1. Simple notification

```java
new MagicalNotifier.Builder(this)
                .setNotificationType(EnumNotificationType.SIMPLE)
                .setTitle(NOTIFICATION_TITLE)
                .setSubTitle(NOTIFICATION_SUB_TITLE)
                .show();
```

![Simple notification](https://raw.githubusercontent.com/HamidrezaAmz/MagicalNotifier/master/notification_simple.jpg "Simple notification")

2. Simple notification with avatar (res)

```java
new MagicalNotifier.Builder(this)
                .setNotificationType(EnumNotificationType.SIMPLE_WITH_AVATAR)
                .setTitle(NOTIFICATION_TITLE)
                .setSubTitle(NOTIFICATION_SUB_TITLE)
                .setLargeIcon(R.drawable.ic_avatar)
                .show();
```
![Simple notification with avatar](https://raw.githubusercontent.com/HamidrezaAmz/MagicalNotifier/master/notification_simple_with_avatar.jpg "Simple notification with avatar")



