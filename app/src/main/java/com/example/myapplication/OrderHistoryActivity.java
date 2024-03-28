package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class OrderHistoryActivity extends AppCompatActivity {

    ArrayList<OrderHistoryModel> orderHistoryModels = new ArrayList<>();

    int[] cardImages = {R.drawable.birthday1,R.drawable.birthday2,R.drawable.getwell1,R.drawable.getwell2,R.drawable.valentine1};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_history);
        RecyclerView recyclerView = findViewById(R.id.mRecyclerView);
        OrderHistory_RecyclerViewAdapter adapter = new OrderHistory_RecyclerViewAdapter(this,
                orderHistoryModels);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        setUpOrderHistoryModels();
    }

    private void setUpOrderHistoryModels() {
        String[] orderStatus = getResources().getStringArray(R.array.order_status);
        String[] deliveryDate = getResources().getStringArray(R.array.deliverey_date);

        for (int i = 0; i<orderStatus.length; i++) {
            orderHistoryModels.add(new OrderHistoryModel(orderStatus[i],
                    deliveryDate[i], cardImages[i] ));
        }
    }
}