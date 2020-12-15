#### Material Design

**Toolbar**

**指定一个不带ActionBar的主题**

**res/values/sysles.xml**

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

定义了一个Toolbar控件，由appcompat-v7库提供。使用了android:popupTheme属性，单独将弹出的菜单项指定成了淡色主题。而且还可以兼容Android5.0以下的系统

**MainActivity:**

```
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
}
```

首先通过findViewById（）得到Toolbar的实例，然后调用setSupportActionBar（）方法将Toolbar的实例传入，既使用了Toolbar，又让它的外观和功能都和ActionBar一致了



![Toolbar](https://github.com/PengFeisupper/2018118122_Android/blob/homework/MaterialDesign/%E6%88%AA%E5%9B%BE/%E6%89%B9%E6%B3%A8%202020-11-30%20171104.png)



#### **Toolbar常用功能：**

**修改标题栏显示的文字内容;**

**AndroidMainfest.xml**

```
    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme" >
        <activity android:name=".MainActivity"
            android:label="Fruits">
```

修改标题为Fruits



