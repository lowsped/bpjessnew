package com.cek.bpjs.online;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.NativeExpressAdView;

public class native_holder extends RecyclerView.ViewHolder {

            public ImageView imageView;
            public TextView tv1;
            public TextView tv2;
    public NativeExpressAdView nativeAdview;

            public native_holder(View itemView) {
                super(itemView);
                nativeAdview = (NativeExpressAdView) itemView.findViewById(R.id.adView5);
                imageView = (ImageView)itemView.findViewById(R.id.daftar_icon);
                tv1 = (TextView)itemView.findViewById(R.id.daftar_judul);
                tv2 = (TextView)itemView.findViewById(R.id.daftar_deskripsi);
            }



    }
