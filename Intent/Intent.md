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



