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