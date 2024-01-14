package anhmvph25860.fpoly.onlineshopapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;

import anhmvph25860.fpoly.onlineshopapp.Adapter.PopularListAdapter;
import anhmvph25860.fpoly.onlineshopapp.Domain.PopularDomain;
import anhmvph25860.fpoly.onlineshopapp.R;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterPupolar;
    private RecyclerView recyclerViewPupolar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRecyclerview();
        bottom_navigation();
    }

    private void bottom_navigation() {
        LinearLayout homeBtn = findViewById(R.id.homeBtn);
        LinearLayout cartBtn = findViewById(R.id.cartBtn);

        homeBtn.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, MainActivity.class)));
        cartBtn.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, CartActivity.class)));
    }

    private void initRecyclerview(){
        ArrayList<PopularDomain> items = new ArrayList<>();
        items.add(new PopularDomain("MacBook Pro 13 M2 Chip", "Discover the new MacBook Pro 13 featuring the powerful M2 chip. This cutting-edge laptop redefines performance and portability. With its sleek design and advanced technology, the MacBook Pro M2 chip is your ultimate compainon for productivity, creativity, and entertainment. Experience seamless multitasking, stunning visuals on the Retina display, and enhanced security with Touch ID. Take your computing experience to the next level with the MacBook Pro 13 M2 Chip."
                , "pic1", 15, 4, 500));
        items.add(new PopularDomain("Ps-5 Digital", "Discover the new MacBook Pro 13 featuring the powerful M2 chip. This cutting-edge laptop redefines performance and portability. With its sleek design and advanced technology, the MacBook Pro M2 chip is your ultimate compainon for productivity, creativity, and entertainment. Experience seamless multitasking, stunning visuals on the Retina display, and enhanced security with Touch ID. Take your computing experience to the next level with the MacBook Pro 13 M2 Chip."
                , "pic2", 10, 4.5, 450));
        items.add(new PopularDomain("Iphone 14", "Discover the new MacBook Pro 13 featuring the powerful M2 chip. This cutting-edge laptop redefines performance and portability. With its sleek design and advanced technology, the MacBook Pro M2 chip is your ultimate compainon for productivity, creativity, and entertainment. Experience seamless multitasking, stunning visuals on the Retina display, and enhanced security with Touch ID. Take your computing experience to the next level with the MacBook Pro 13 M2 Chip."
                , "pic3", 13, 4.2, 800));

        recyclerViewPupolar = findViewById(R.id.view1);
        recyclerViewPupolar.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        adapterPupolar = new PopularListAdapter(items);
        recyclerViewPupolar.setAdapter(adapterPupolar);
    }
}