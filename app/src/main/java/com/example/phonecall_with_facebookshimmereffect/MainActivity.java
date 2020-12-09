package com.example.phonecall_with_facebookshimmereffect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerButton;
import com.romainpiel.shimmer.ShimmerTextView;

public class MainActivity extends AppCompatActivity{

    Button nextpage;
    ShimmerTextView textViewShimmer;
    Shimmer shimmer;
    RecyclerView recyclerView;
    String name[], id[];
    int [] image = {R.drawable.discount, R.drawable.shuka, R.drawable.alamin, R.drawable.hani, R.drawable.himel,
            R.drawable.masud, R.drawable.ragib, R.drawable.me, R.drawable.mit, R.drawable.rinku, R.drawable.kabila};
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = getResources().getStringArray(R.array.student_Name_array);
        id = getResources().getStringArray(R.array.student_Id_array);
        nextpage = findViewById(R.id.nextPageID);
        recyclerView = findViewById(R.id.recyclerViewID);

        textViewShimmer = findViewById(R.id.headlineID);
        shimmer = new Shimmer();
        shimmer.start(textViewShimmer);

        customAdapter = new CustomAdapter(MainActivity.this, name, id, image);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }
}
