#### Material Design

##### Toolbar

指定一个不带ActionBar的主题

```java
<resources>
    <!-- Base application theme. -->
    <style name="AppTheme" parent="Theme.AppCompat.Light.NoActionBar">//表示浅色主题
        <!-- Customize your theme here. -->
        <item name="colorPrimary">@color/colorPrimary</item>
        <item name="colorPrimaryDark">@color/colorPrimaryDark</item>
        <item name="colorAccent">@color/colorAccent</item>
    </style>

</resources>
```

定义了一个Toolbar控件，由appcompat-v7库提供。使用了android:popupTheme属性，单独将弹出的菜单项指定成了淡色主题。而且还可以兼容Android5.0以下的系统

**Activity.xml**

```
<?xml version="1.0" encoding="utf-8"?>
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app ="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <android.support.v7.widget.Toolbar
        android:id="@+id/toolbar"
        android:layout_width="match_parent"
        android:layout_height="?attr/actionBarSize"
        android:background="@color/colorPrimary"
        android:theme="@style/ThemeOverlay.AppCompat.Dark.ActionBar"
        app:popupTheme="@style/ThemeOverlay.AppCompat.Light"/>

</FrameLayout>
```

Mainactivity:

```

```





![Toolbar](https://github.com/PengFeisupper/2018118122_Android/blob/homework/MaterialDesign/%E6%88%AA%E5%9B%BE/%E6%89%B9%E6%B3%A8%202020-11-30%20171104.png)

