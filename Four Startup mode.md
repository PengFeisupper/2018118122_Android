## 四种**启动模式**：

### 一、标准模式（standard）

```java
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("FirstActivity",this.toString());
        setContentView(R.layout.activity_main);
        Button startNormalActivity = (Button) findViewById(R.id.start_normal_activity);
        Button startDialogActivity = (Button) findViewById(R.id.start_dialog_activity);
        startNormalActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        startDialogActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity.class); //创建MainActivity实例
                startActivity(intent);
            }
        });
    }
```

运行程序，然后在activity_main界面连续点击两次按钮可以看到logcat中打印的信息如下图所示：

![image-20201007145405894](https://github.com/PengFeisupper/2018118122_Android/blob/homework/Four%20Startup%20mode/%E6%A0%87%E5%87%86%E6%A8%A1%E5%BC%8F/%E6%88%AA%E5%9B%BE/%E6%A0%87%E5%87%86%E6%A8%A1%E5%BC%8F.png)

每点击一次按钮就会创建出一个新的MainActivity实例。此时返回栈会存在2个MainActivity实例，需要连按Back键才能回到最开始的那个界面。

### 二、单顶模式（singleTop）：

```java
 <activity android:name=".MainActivity"
            android:launchMode="singleTop">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
```

点击按钮，查看logcat会看到已经创建了一个MainActivity实例：

![单项模式1-1](https://github.com/PengFeisupper/2018118122_Android/blob/homework/Four%20Startup%20mode/%E5%8D%95%E9%A1%B6%E6%A8%A1%E5%BC%8F/%E6%88%AA%E5%9B%BE/%E5%8D%95%E9%A1%B6%E6%A8%A1%E5%BC%8F1-1.png)

之后不管点击点击几次按钮都不会有新的打印信息出现，因为目前MainActivity已经处于返回栈的栈顶，每当想要再启动一个MainActivity时都要直接使用栈顶的活动，因此MainActivity也只有一个实例，仅按一次Back键就可以返回最开始的界面。

不过当MainActivity不是处于栈顶位置时，这时再启动MainActivity，还是会创建新的实例的。

修改代码，点击启动的是NormalActivity或DialogActivity

```java
       Button startNormalActivity = (Button) findViewById(R.id.start_normal_activity);
        Button startDialogActivity = (Button) findViewById(R.id.start_dialog_activity);
        startNormalActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,NormalActivity.class);
                startActivity(intent);
            }
        });
        startDialogActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DialogActivity.class);
                startActivity(intent);
            }
        });
```

在NormalActivity和DialogActivity界面点击按钮进入的是MainActivity

```java
         Button startMainActivity = (Button) findViewById(R.id.start_main_activity);
         startMainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NormalActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
```

```java
        Button startMainActivity = (Button) findViewById(R.id.start_main_activity);

        startMainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DialogActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
```



在MainActivity界面点击按钮选择进入Normalactivity，然后在NormalActivity界面点击按钮又会重新进入MainActivity,然后在MainActivity界面点击按钮进入DialogActivity，再DialogAcctivity点击按钮又会重新进入MainActivity。

![单顶模式1-2](https://github.com/PengFeisupper/2018118122_Android/blob/homework/Four%20Startup%20mode/%E5%8D%95%E9%A1%B6%E6%A8%A1%E5%BC%8F/%E6%88%AA%E5%9B%BE/%E5%8D%95%E9%A1%B6%E6%A8%A1%E5%BC%8F1-2.png)

![单顶模式1-4](https://github.com/PengFeisupper/2018118122_Android/blob/homework/Four%20Startup%20mode/%E5%8D%95%E9%A1%B6%E6%A8%A1%E5%BC%8F/%E6%88%AA%E5%9B%BE/%E5%8D%95%E9%A1%B6%E6%A8%A1%E5%BC%8F1-4.png)

在NormalActivity启动MainActivity时，栈顶活动已经变成了NormalActivity，此时会创建一个新的MainActivity实例，在MainActivity启动DialogActivity时，栈顶活动又变成了MainActivity，然后在DialogActivity启动，栈顶活动变成了DialogActivity，再创建了一个新的MainActivity实例。最后在DialogActivity启动MainActivity时，栈顶活动又变成了MainActivity，此时按下Back键会回到DialogActivity，再按下Back键又会回到MainActivity，然后按两次Back键会依次回到NormalActivity和MainActivity，最后按Back键才会退出程序。