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



