#### Intent

##### 显式intent：

MainActivity

```java
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });
```



##### 隐式intent：

AndroidMainfest.xml

```java
        <activity android:name=".SecondActivity">
            <intent-filter>
                <action android:name="com.example.secondactivity.ACTION_START" />
                <category android:name="android.intent.category.DEFAULT" />
                <category android:name="com.example.secondactivity.MY_CATEGORY" />
            </intent-filter>
        </activity>
```

指明了当前活动可以响com.example.secondactivity.ACTION_START这个action



MainActivity

```java
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent ("com.example.secondactivity.ACTION_START");
                intent.addCategory("com.example.secondactivity.MY_CATEGORY");
                startActivity(intent);
            }
        });
```

##### 访问网址：

```java
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
            }
        });
```

指定了intent的action是Intent。ACTION_VIEW,然后通过Uri。parse（）方法，将一个网址字符串解析成一个Uri对象，再调用setData（）方法将这个Uri对象传递出去。setData（）接收一个Uri对象，主要用于指定当前intent正在操作的数据，而这些数据通常是以字符串的形式传入到Uri.parse()方法中解析产生的。

##### data标签:

```java
        <activity android:name=".ThirdActivity">
            <intent-filter tools:ignore="AppLinkUrlError">
               <action android:name="android.intent.action.VIEW" />
              <category android:name="android.intent.category.DEFAULT" />
               <data android:scheme="http"/>
            </intent-filter>
        </activity>
```

在<data>标签中通过android:scheme指定了数据的协议必须是http协议。