package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import com.example.myapplication.SubscribedClickListener;


import androidx.fragment.app.Fragment;

import com.example.myapplication.databinding.FragmentPaymentPlanBinding;
import com.google.android.material.navigation.NavigationView;

public class PaymentPlanFragment extends Fragment implements SubscribedClickListener{
    FragmentPaymentPlanBinding binding;
    NavigationView navigationView;
    ImageButton currentPlanBtn,switchPlanBtn;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public PaymentPlanFragment() {

    }

    public static PaymentPlanFragment newInstance(String param1, String param2, SubscribedClickListener listener) {
        PaymentPlanFragment fragment = new PaymentPlanFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        fragment.setSubscribedClickListener(listener);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPaymentPlanBinding.inflate(inflater, container, false);
        View rootView = binding.getRoot();

        currentPlanBtn = binding.currentBtn;
        switchPlanBtn = binding.switchBtn;
        // TODO Change ActivityMain to Home page
        currentPlanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), HomePageActivity.class);
                startActivity(intent);
            }
        });

        // TODO Change ActivityMain to Home page
        switchPlanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String buttonText = "You are currently a Premium member \n Change plan?";
                if (subscribedClickListener != null) {
                    subscribedClickListener.subscribedUser(buttonText);
                }
                Intent intent = new Intent(getActivity(), HomePageActivity.class);
                startActivity(intent);
            }
        });
        return rootView;
    }
    public void subscribedUser(String buttonText) {
    }
    private SubscribedClickListener subscribedClickListener;

    public void setSubscribedClickListener(SubscribedClickListener listener){
        this.subscribedClickListener = listener;
    }
}