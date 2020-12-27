#### 服务

**启动和停止服务**

**MyService**

```java
    public void onCreate() {
        super.onCreate();
        Log.d("MyService", "onCreate executed");
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);
        Notification notification = new NotificationCompat.Builder(this)
                .setContentTitle("我的通知")
                .setContentText("普通服务开启了")
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                .setContentIntent(pi)
                .build();
        startForeground(1, notification);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("MyService", "onStartCommand executed");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("MyService", "onDestroy executed");
    }
```

AndroidMainfest.xml

```java
    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">
        <activity android:name=".MainActivity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>

        <service
            android:name=".MyService"
            android:enabled="true"
            android:exported="true" />
        <service android:name=".MyIntentService" />
    </application>
```

![startService](https://github.com/PengFeisupper/2018118122_Android/blob/homework/ServiceTest/%E6%88%AA%E5%9B%BE/startService.png)

![ServiceTest](https://github.com/PengFeisupper/2018118122_Android/blob/homework/ServiceTest/%E6%88%AA%E5%9B%BE/Service.png)

![stopService](https://github.com/PengFeisupper/2018118122_Android/blob/homework/ServiceTest/%E6%88%AA%E5%9B%BE/stopService.png)

**绑定服务**

**MyService**

```java
public class MyService extends Service {

    public MyService() {
    }

    private DownloadBinder mBinder = new DownloadBinder();

    class DownloadBinder extends Binder {

        public void startDownload() {

            Log.d("MyService", "startDownload executed");
        }

        public int getProgress() {
            Log.d("MyService", "getProgress executed");
            return 0;
        }

    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }
```

创建一个DownloadBinder的实例，然后在onBind（）方法中返回了这个实例



