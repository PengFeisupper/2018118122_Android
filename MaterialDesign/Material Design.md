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

##### 添加action按钮：

**menu/toolbar.xml**

```
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">
    <item
        android:id="@+id/backup"
        android:icon="@drawable/ic_backup"
        android:title="Backup"
        app:showAsAction="always" />
    <item
        android:id="@+id/delete"
        android:icon="@drawable/ic_delete"
        android:title="Delete"
        app:showAsAction="ifRoom" />
    <item
        android:id="@+id/setting"
        android:icon="@drawable/ic_setting"
        android:title="Settings"
        app:showAsAction="never" />

</menu>
```

通过<item>标签定义action按钮，android：id用于指定按钮的id,android:icon 用于指定按钮的图标，android:title用于指定按钮的文字。接着使用app:showAsAction来指定按钮的显示位置，always表示永远显示在Toolbar中，如果屏幕空间不够则不显示;IfRoom表示屏幕空间足够的情况下显示在Toolbar中，不够的话就显示在菜单中；never则表示永远显示在菜单中。Toolbar中的action按钮只会显示图标，菜单中的action按钮只会显示文字。

*MainActivity：*

```java
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case  R.id.backup:
                Toast.makeText(this,"You clickd Backup",Toast.LENGTH_SHORT).show();
                break;
            case  R.id.delete:
                Toast.makeText(this,"You clicked Delete",Toast.LENGTH_SHORT).show();
                break;
            case R.id.setting:
                Toast.makeText(this,"You clicked Settings",Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }
```

在onCreateOptionsMenus()方法中加载了toolbar.xml这个菜单文件，然后在onOptionsItemSelected（）方法中处理各个按钮的点击事件。