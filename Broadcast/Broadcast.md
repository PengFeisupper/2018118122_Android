#### Broadcast

##### 一、发送标准广播

```java
public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"received in MyBoradReceiver",Toast.LENGTH_SHORT).show();

    }
}

```

新建一个MyBroadcastReceiver类，当MyBroadcastReceive收到自定义广播时，就会弹出"received in MyBoradReceiver"的提示。

```java
       <receiver android:name=".MyBroadcastReceiver"
            android:enabled="true"
            android:exported="true">
            <intent-filter>
                <action android:name="com.example.broadcast.MY_BROADCAST"/>
            </intent-filter>
        </receiver>
```

让MyBroadcastReceiver接收一条值com.example.broadcast.MY_BROADCAST的广播。

```java
        Button button =(Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new
                        Intent("com.example.broadcast.MY_BROADCAST");
                sendBroadcast(intent);
            }
        });

```

构建一个个Intent对象，把要发送的广播的值传入，然后调用Context的sendBradcast（）方法将广播发送出去，这时所有监听com.example.broadcast.MY_BROADCAST这条广播的广播接收器就会收到消息

![发送自定义标准广播](https://github.com/PengFeisupper/2018118122_Android/blob/homework/Broadcast/%E6%88%AA%E5%9B%BE/%E5%8F%91%E9%80%81%E8%87%AA%E5%AE%9A%E4%B9%89%E6%A0%87%E5%87%86%E5%B9%BF%E6%92%AD.png)

##### 发送有序广播

```java
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button =(Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new
                        Intent("com.example.broadcast.MY_BROADCAST");
                sendOrderedBroadcast(intent,null);
            }
        });
    }
}
```

```jav
       <receiver android:name=".MyBroadcastReceiver"
            android:enabled="true"
            android:exported="true">
            <intent-filter android:priority="100">
                <action android:name="com.example.broadcast.MY_BROADCAST"/>
            </intent-filter>
        </receiver>
```

```java
  public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"received in MyBroadReceiver",Toast.LENGTH_SHORT).show();
        abortBroadcast();

    }
```

![未截断广播前](https://github.com/PengFeisupper/2018118122_Android/blob/homework/Broadcast/%E6%9C%89%E5%BA%8F%E5%B9%BF%E6%92%AD/%E6%88%AA%E5%9B%BE/3b80ac31144abf85c136ad72368c673.png)

![有序广播](https://github.com/PengFeisupper/2018118122_Android/blob/homework/Broadcast/%E6%9C%89%E5%BA%8F%E5%B9%BF%E6%92%AD/%E6%88%AA%E5%9B%BE/%E6%9C%89%E5%BA%8F%E5%B9%BF%E6%92%AD.png)