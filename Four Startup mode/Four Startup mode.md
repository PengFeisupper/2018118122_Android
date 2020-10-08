## 四种**启动模式**：

[一]: 	"标准模式"



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

### 三、单任务模式（singleTask）

修改MainActivity的启动模式：

```java
       <activity android:name=".MainActivity"
            android:launchMode="singleTask">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
```

MainActivity的onRestart方法

```java
    protected  void onRestart() {
        super.onRestart();
        Log.d("MainActivity","onRestart");
    }
```

NormalActivity的onDestroy方法

```java
   protected  void onDestroy() {
        super.onDestroy();
        Log.d("NormalActivity","onDestroy");
    }
```

![单任务模式](https://github.com/PengFeisupper/2018118122_Android/blob/homework/Four%20Startup%20mode/%E5%8D%95%E4%BB%BB%E5%8A%A1%E6%A8%A1%E5%BC%8F/%E6%88%AA%E5%9B%BE/%E5%8D%95%E4%BB%BB%E5%8A%A1%E6%A8%A1%E5%BC%8F.png)

在 NormalActivity 中启动 MainActivity 时，会发现返回栈中已经存在一个 MainActivity 的实例，并且是在 NormalActivity 的下面，于是 NormalActivity 会从返回栈中出栈，而 MainActivity 重新成为了栈顶活动，因此MainActivity 的 onRestart()方法和 NormalActivity 的 onDestroy()方法会得到执行。 现在返回栈中应该只剩下一个 MainActivity 的实例了，按一下 Back 键就可以退出程序。

### 四、单实例模式（singleInstance）:

在AndroidManifest.xml文件修改NormalActivity活动的启动模式

```java
        <activity android:name=".MainActivity"
            android:launchMode="singleInstance">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
```

修改MainActivity中onCreate方法打印日志信息，打印单前返回栈的id

```java
Log.d(TAG,"Task id is "+ getTaskId());
```

修改NormalActivity中onCrreate方法打印当前返回栈的id，然后修改了按钮点击事件，用于启动DialogActivity

```java
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("NormalActivity","Task id is "+ getTaskId());
        setContentView(R.layout.normal_layout);
        Button startMainActivity = (Button) findViewById(R.id.start_main_activity);

        startMainActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NormalActivity.this, DialogActivity.class);
                startActivity(intent);
            }
        });
    }
```

在DialogActivity打印当前栈的id

```java
Log.d("DialogActivity","Task id is "+ getTaskId());
```

![单实例模式](https://github.com/PengFeisupper/2018118122_Android/blob/homework/Four%20Startup%20mode/%E5%8D%95%E5%AE%9E%E4%BE%8B%E6%A8%A1%E5%BC%8F/%E6%88%AA%E5%9B%BE/%E5%8D%95%E5%AE%9E%E4%BE%8B%E6%A8%A1%E5%BC%8F.png)

NormalActivity放在一个单独栈里，MainActivity和DialogActivity放在另一个栈里，当在DialogActivity的界面按下Back键，DialogActivity会从返回栈出栈，此时MainActivity就成了栈顶活动，所以在DialogActivity界面按Back键直接返回到MainActivity。然后在MainActivity界面按下Back键，此时栈已经空了，于是就显示了另一个返回栈的栈顶活动，即NormalActivity.最后再按下Back键，此时所有栈都空了，也就退出程序了。

