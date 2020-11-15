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

