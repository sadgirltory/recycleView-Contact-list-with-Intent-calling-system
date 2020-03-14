package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ArrayList<String> mobileNumber = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"OnCreate: started.");
        initImageBitmaps();


    }
    private void initImageBitmaps(){
        Log.d(TAG,"initImageBitmaps:preparing bitmaps");
        mImageUrls.add("https://cdn0.iconfinder.com/data/icons/connection/512/icon-9.png");
        mNames.add("Adrita");
        mobileNumber.add("01716666863");

        mImageUrls.add("https://cdn1.iconfinder.com/data/icons/data-analytics-data-storage-double-color-black-a-7/52/user__person__avatar__man-512.png");
        mNames.add("Tory");
        mobileNumber.add("01742508800");

        mImageUrls.add("https://previews.123rf.com/images/imagecatalogue/imagecatalogue1702/imagecatalogue170206218/71208795-woman-profile-flat-icon-vector-red-symbol-pictogram-is-isolated-on-a-white-background-trendy-flat-st.jpg");
        mNames.add("Orpita");
        mobileNumber.add("01838631521");

        mImageUrls.add("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRnObdXfDd9d1Ll6ZKSJSDAvs30ri3V1eyFY3v8faa2ApfsAcBe");
        mNames.add("Dia");
        mobileNumber.add("01716666863");

        mImageUrls.add("https://cdn1.iconfinder.com/data/icons/social-messaging-ui-color/254000/29-512.png");
        mNames.add("Tonmoy");
        mobileNumber.add("01716666863");

        mImageUrls.add("https://cdn4.iconfinder.com/data/icons/social-messaging-ui-color-and-shapes-3/177800/113-512.png");
        mNames.add("Kollol");

        mImageUrls.add("https://i.ya-webdesign.com/images/customer-icon-png-4.png");
        mNames.add("Zaima");
        mobileNumber.add("01716666863");
        mImageUrls.add("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcRN7tYfKqaqVKpNsBW0CJO9WV1gCfDoMifGZxOpUuoTuYnrGj4k");
        mNames.add("Anondo");
        mobileNumber.add("01716666863");

        initRecyclerView();



    }

    private void initRecyclerView(){
        Log.d(TAG,"initRecyclerView: init recylerview.");
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecylcerViewAdapter adapter = new RecylcerViewAdapter(this, mNames,mImageUrls,mobileNumber);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

}
