### RecyclerView

首先，在app/build.gradle文件中的dependencies闭包中添加：

```java
         implementation 'androidx.recyclerview:recyclerview:1.0.0'
```

修改activity_main.xml文件

```java
        <androidx.recyclerview.widget.RecyclerView
            android:id="@+id/recycler_view"
            android:layout_width="match_parent"
            android:layout_height="match_parent" />
```

然后为RecyclerView准备一个适配器,新建FruitAdapter类

```java
package com.example.recycleviewtest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {
    private List<Fruit> mFruitList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        View fruitView;
        ImageView fruitImage;
        TextView fruitName;
        public  ViewHolder(View view) {
            super(view);
            fruitView = view;
            fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
            fruitName = (TextView) view.findViewById(R.id.fruit_name);
        }
    }
    public  FruitAdapter(List<Fruit> fruitList) {
        mFruitList = fruitList;
    }
    public  ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fruit_item,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.fruitView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Fruit fruit =mFruitList.get(position);
                Toast.makeText(v.getContext(),"you clicked view"+fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });
        holder.fruitImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Fruit fruit = mFruitList.get(position);
                Toast.makeText(v.getContext(),"you clicked image"+fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });
        return  holder;
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        Fruit fruit = mFruitList.get(position);
        holder.fruitImage.setImageResource(fruit.getImageId());
        holder.fruitName.setText(fruit.getName());

    }
    public  int getItemCount(){
        return  mFruitList.size();
    }
}

```



MainActivity

```java
package com.example.recycleviewtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        StaggeredGridLayoutManager layoutManager = new
                StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        FruitAdapter adapter = new FruitAdapter(fruitList);
        recyclerView.setAdapter(adapter);
    }
    private void initFruits() {
        for (int i = 0; i < 2; i++) {
            Fruit apple =new Fruit(getRamdomLengthName("Apple"),R.drawable.apple_pic);
            fruitList.add(apple);
            Fruit banana =new Fruit(getRamdomLengthName("Banana"),R.drawable.banana_pic);
            fruitList.add(banana);
            Fruit orange =new Fruit(getRamdomLengthName("Orange"),R.drawable.orange_pic);
            fruitList.add(orange);
            Fruit watermelon =new Fruit(getRamdomLengthName("Watermelon"),R.drawable.watermelon_pic);
            fruitList.add(watermelon);
            Fruit pear =new Fruit(getRamdomLengthName("Pear"),R.drawable.pear_pic);
            fruitList.add(pear);
            Fruit grape =new Fruit(getRamdomLengthName("Grape"),R.drawable.grape_pic);
            fruitList.add(grape);
            Fruit pineapple =new Fruit(getRamdomLengthName("Pineapple"),R.drawable.pineapple_pic);
            fruitList.add(pineapple);
            Fruit strawberry =new Fruit(getRamdomLengthName("Strawberry"),R.drawable.strawberry_pic);
            fruitList.add(strawberry);
            Fruit cherry =new Fruit(getRamdomLengthName("Cherry"),R.drawable.cherry_pic);
            fruitList.add(cherry);
            Fruit mango =new Fruit(getRamdomLengthName("Mango"),R.drawable.mango_pic);
            fruitList.add(mango);

        }

    }
    private  String getRamdomLengthName(String name) {
        Random random = new Random();
        int length = random.nextInt(20) + 1;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append(name);
        }
        return builder.toString();
    }
}
```

首先，在onCreate()方法中，创建一个StaggeredGridLayoutManager的实例。StaggeredGridLayoutManager的构造函数接收两个参数，第一个参数用于指定布局的列数，传入3表示会把布局分为3列：第二个参数用于指定布局的排列方向，传入StaggerredGridLayoutManager.VERTICAL表示会让布局纵向排列。

getRadomLengthName()使用Random对象来创造一个1到20的随机数，然后将参数中传入的字符串随机重复几遍，

initFruits()方法中每个水果的名字都改成调用getRadomLengthName()这个方法来生成，这样就能保证各水果名字的长短差距都比较大，子项的高度也就各不相同了

