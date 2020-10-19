### UI设计--LinearLayout (线性布局)

**Textview**

```java
<TextView
        android:id="@+id/text_view"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:gravity="center_horizontal"
        android:textSize="24sp"
        android:textColor="#00ff00"
        android:text="学生成绩管理系统"/>
```

center_horizontal表示水平方向居中对齐

**EditText**

```java
    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        android:orientation="horizontal"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        >
        <EditText
            android:id="@+id/input_message1"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:hint="输入想要搜索的内容"/>
        <Button
            android:id="@+id/source"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:text="搜索"/>

    </LinearLayout>
```

指定 android:orientation="horizontal"的值为horizontal，EditText和Button按水平方向排列

**Button**

```java
    android:orientation="vertical"
```

通过android:orientation设置控件水平方向排列

```java

   <Button
        android:id="@+id/button1"
        android:layout_width="wrap_content"
        android:layout_height="0dp"
        android:layout_weight="1"
        android:text="我的课程" />
    <Button
        android:id="@+id/button2"
        android:layout_width="wrap_content"
        android:layout_height="0dp"
        android:layout_weight="1"
        android:text="我的学分" />

    <Button
        android:id="@+id/button3"
        android:layout_width="wrap_content"
        android:layout_height="0dp"
        android:layout_weight="1"
        android:text="我的成绩" />

    <Button
        android:id="@+id/button"
        android:layout_width="wrap_content"
        android:layout_height="0dp"
        android:layout_weight="1"
        android:text="不及格科目" />
```

android:layout_weight的值指定为1，表示会在垂直方向平分高度

![LinearLayout](https://github.com/PengFeisupper/2018118122_Android/blob/homework/LinearLayout/%E6%88%AA%E5%9B%BE/LinearLayout.png)

**ImageView**

```java
    <ImageView
        android:id="@+id/image_view"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:src="@drawable/new_day"
        />
```

![imageview](https://github.com/PengFeisupper/2018118122_Android/blob/homework/LinearLayout/%E6%88%AA%E5%9B%BE/imageview.png)

**ProgressBar**

```java
    <ProgressBar
        android:id="@+id/progress_bar"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        />
```

![ProgressBar](https://github.com/PengFeisupper/2018118122_Android/blob/homework/LinearLayout/%E6%88%AA%E5%9B%BE/ProgressBar.png)

