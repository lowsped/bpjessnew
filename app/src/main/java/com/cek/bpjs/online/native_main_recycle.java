package com.cek.bpjs.online;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class native_main_recycle extends AppCompatActivity {


    InterstitialAd mInterstitialAd;

        //deklarasi variabel reyclerview
        RecyclerView recyclerView;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.native_main);


            mInterstitialAd = new InterstitialAd(this);
            mInterstitialAd.setAdUnitId("ca-app-pub-1142409875326374/6834885522");


            AdView mAdView = (AdView) findViewById(R.id.adView5);
            AdRequest adRequest = new AdRequest.Builder().build();
            mAdView.loadAd(adRequest);
            mInterstitialAd.loadAd(adRequest);



            recyclerView= (RecyclerView) findViewById(R.id.recycler_view);
            //menampilkan reyclerview yang ada pada file layout dengan id reycler view

            native_adapter adapter=new native_adapter(this);
            //membuat adapter baru untuk reyclerview
            recyclerView.setAdapter(adapter);
            //menset nilai dari adapter
            recyclerView.setHasFixedSize(true);
            //menset setukuran
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            //menset layoutmanager dan menampilkan daftar/list
            //dalam bentuk linearlayoutmanager pada class saat ini


                }
            }
