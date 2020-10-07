四种启动模式：
一、标准模式（standard）
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
运行程序，然后在activity_main界面连续点击两次按钮可以看到logcat中打印的信息如下图所示：

image-20201007145405894

每点击一次按钮就会创建出一个新的MainActivity实例。
