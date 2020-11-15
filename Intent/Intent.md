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

向下一个活动传递数据：

MainActivity:

```java
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = "Hello SecondActivity";
                Intent intent=new  Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("extra_data",data);
                startActivity(intent);
            }
        });
```

通过putExtra（）方法传递了一个字符串，接收了两个参数，一个参数是键，用于后面从intent取值，第二个才是真正要传递的数据。

SecondActivity

```java
public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
        Intent intent = getIntent();
        String data =intent.getStringExtra("extra_data");
        Log.d("SecondActivity",data);
    }
}
```

通过getIntent()方法获取到用于启动SecondActivity的intent，然后调用getStringExtra()方法，传入相应的键值，就可以得到传递的数据了。

![传递数据](https://github.com/PengFeisupper/2018118122_Android/blob/homework/Intent/%E4%BC%A0%E9%80%92%E6%95%B0%E6%8D%AE/%E6%88%AA%E5%9B%BE/%E4%BC%A0%E9%80%92%E6%95%B0%E6%8D%AE.png)

##### 返回数据：

MainActivity:

```java
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new  Intent(MainActivity.this,SecondActivity.class);
                startActivityForResult(intent,1);
            }
        });
```

使用startActivityForResult()方法启动SecondACtivity，传入1.

```java

    protected  void onActivityResult(int requestCode, int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String returnedData = data.getStringExtra("data_return");
                    Log.d("FirstActivity", returnedData);
                }
                break;
            default:
        }
    }
```

onActivityResult（)方法有三个参数，第一个参数是requsetCode，请求码，第二个参数resultCode，返回数据时传入的处理结果，第三个参数data，携带着返回数据的intent。

SecondActivity：

```java
public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
        Button button2 = (Button) findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent();
                intent.putExtra("data_return","Hello MainActivity");
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}

                                                 
```

setResult（）方法接收两参数，第一个参数用于向上一个活动返回处理结果，第二个参数把带有数据的intent传递回去，然后调用finish（）来销毁当前活动。

```java
    public void onBackPressed(){
        Intent intent =new Intent();
        intent.putExtra("data_return","Hello MainActivity");
        setResult(RESULT_OK,intent);
        finish();
    }
}

```

按下Back键回到MainActivity ，返回数据。

![返回数据](https://github.com/PengFeisupper/2018118122_Android/blob/homework/Intent/%E8%BF%94%E5%9B%9E%E6%95%B0%E6%8D%AE/%E6%88%AA%E5%9B%BE/%E8%BF%94%E5%9B%9E%E6%95%B0%E6%8D%AE1.png)