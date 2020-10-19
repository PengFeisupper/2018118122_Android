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

center_horizontal表示水平方向居中对齐，通过android:textSize属性指定文字大小为24sp，通过android:textColor属性指定文字颜色

![Textview](https://github.com/PengFeisupper/2018118122_Android/blob/homework/LinearLayout/%E6%88%AA%E5%9B%BE/Textview.png)

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

指定 android:orientation的值为horizontal，EditText和Button按水平方向排列

![EditText](https://github.com/PengFeisupper/2018118122_Android/blob/homework/LinearLayout/%E6%88%AA%E5%9B%BE/EditText.png)

**Button**

```java
    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        android:orientation="horizontal"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        >
    <Button
        android:id="@+id/button1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_weight="1"
        android:text="课程"/>
        <Button
            android:id="@+id/button2"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="成绩"/>
        <Button
            android:id="@+id/button3"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_weight="1"
            android:text="学生信息"/>
    </LinearLayout>
```

通过android:orientation属性指定为horizontal表示控件按水平排列，通过android:layout_weight的值指定为1，表示会在水平方向平分宽度

```java
        <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
            android:orientation="vertical"
            android:layout_width="0dp"
            android:layout_height="match_parent"
            android:layout_weight="1"
            >
        <Button
            android:id="@+id/button4"
            android:layout_width="match_parent"
            android:layout_height="0dp"
            android:layout_weight="1"
            android:text="课程学分"/>
        <Button
            android:id="@+id/button5"
            android:layout_width="match_parent"
            android:layout_height="0dp"
            android:layout_weight="1"
            android:text="需补考学生"/>
        <Button
            android:id="@+id/button6"
            android:layout_width="match_parent"
            android:layout_height="0dp"
            android:layout_weight="1"
            android:text="需重修学生"/>
        </LinearLayout>
```

通过android:orientation设置控件垂直方向排列android:layout_weight的值指定为1，表示会在垂直方向平分高度

![LinearLayout](https://github.com/PengFeisupper/2018118122_Android/blob/homework/LinearLayout/%E6%88%AA%E5%9B%BE/LinearLayout.png)

**ImageView**

```java
        <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
            android:orientation="vertical"
            android:layout_width="0dp"
            android:layout_height="match_parent"
            android:layout_weight="1"
            >
        <ImageView
        android:id="@+id/image_view1"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:src="@drawable/new_day"
        />
        </LinearLayout>
```

![imageview](https://github.com/PengFeisupper/2018118122_Android/blob/homework/LinearLayout/%E6%88%AA%E5%9B%BE/imageview.png)



