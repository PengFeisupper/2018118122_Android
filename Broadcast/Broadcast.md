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

```



![发送自定义标准广播](https://github.com/PengFeisupper/2018118122_Android/blob/homework/Broadcast/%E6%88%AA%E5%9B%BE/%E5%8F%91%E9%80%81%E8%87%AA%E5%AE%9A%E4%B9%89%E6%A0%87%E5%87%86%E5%B9%BF%E6%92%AD.png)

