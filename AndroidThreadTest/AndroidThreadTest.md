### 在子线程中更新UI+异步消息机制

activity_main.xml

```java
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <Button
        android:id="@+id/change_text"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Change Text" />

    <TextView
        android:id="@+id/text"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_centerInParent="true"
        android:text="Hello world!"
        android:textSize="20sp" />

</RelativeLayout>
```

定义了两个控件，TextView用于屏幕正中央显示一个Hello World 字符串，BUtton用于改变TextView中显示的内容。

**MainActivity：**

```java
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int UPDATE_TEXT = 1;
    private static final int  END_TEXT = 2;

    private  TextView text;

    private Handler handler = new Handler() {

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case UPDATE_TEXT:
                    // 在这里可以进行UI操作
                    Pa tmp;
                    tmp =((Pa) msg.obj);
                    text.setText("我是子线程："+tmp.getTid()+"\n  我的值是："+tmp.getCounter());
                    break;
                case END_TEXT:

                default:
                    break;
            }
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.text);
        Button changeText = (Button) findViewById(R.id.change_text);
        changeText.setOnClickListener(this);
        text.setText("我是："+0);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.change_text:
                DemoThread thread1 = new DemoThread();
                Log.d("子线程号：", " "+ thread1.getId()) ;
                try {
                    //Thread.sleep(1000);
                    thread1.start();
                }catch (Exception e){

                }
               // Log.d("子线程号：", " "+ thread1.getId()) ;
                Log.d("主线程号：", " " + Thread.currentThread().getId());
               // text.setText("我是："+counter);
                break;
        }
    }

    class DemoThread extends Thread{
        private  int counter = 0;
        @Override
        public void run() {
            while(true){
                counter++;
                Message message = new Message();
                message.what = UPDATE_TEXT;
                message.obj =new Pa(Thread.currentThread().getId(),counter);
                handler.sendMessage(message); // 将Message对象发送出去
                try {
                    Thread.sleep(6000);
                }catch (Exception e){
                        break;
                }
            }
            Message message = new Message();
            message.what = END_TEXT;
        }
    }

    class Pa {
        private  long tid;
        private  int counter;
        public Pa(long tid, int counter){
            this.tid = tid;
            this.counter = counter;
        }

        public int getCounter() {
            return counter;
        }

        public long getTid() {
            return tid;
        }
    }
}

```

先定义了一个整形常量UPDATE_TEXT，用于更新TextView这个动作。然后新增一个Handler对象，并重写父类的andlerMessage（）方法，在这里对具体的Message进行处理。对Message的what字段的值进行判断，如果UPDATE_TEXT，就将TextView显示的内容成“我是子线程：  我的值是：”

在主线程当中创建一个Handler对象，并重写handlerMessage（）方法。然后当子线程中需要进行UI操作时，就创建一个Message对象，并通过Hadler将这条消息发送出去。之后这条消息会被添加到MessageQueue的队列中等待被处理，而Looper则会一直尝试从MessageQueue中取出待处理消息，最后分发回Handler的handlerMessage（）方法中，由于Handler是在主线程中创建的，所以此时handlerMessage（）方法中的代码也会在主线程中运行