package com.cek.bpjs.online;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.ads.InterstitialAd;


public class native_adapter extends  RecyclerView.Adapter<native_holder> {

    //deklarasi variable context

    private final Context context;

//tambahan list nama detail

   private String[] name={"REGISTRASI BPJS","LUPA AKUN / PIN BPJS","LOGIN BPJSTK","REGISTRASI EPS","LOGIN EPS",
            "REGISTRASI SIP","LOGIN SIP","REGISTRASI ASURANSI RUMAH SAKIT","LOGIN ASURANSI RUMAH SAKIT"};

//tambahan list detail

   private String[] lis={"Daftar BPJS online","Lupa pin BPJS ketenagakerjaan","Login untuk checking data status kepesertaan BPJS","Daftar Electronic Payment System","Login Electronic Payment System",
            "Daftar Sistem Informasi Pelaporan Peserta","Login Sistem Informasi Pelaporan Peserta","Daftar Rumah Sakit Trauma Center","Login Rumah Sakit Trauma Center"};


   private int[] imageView = {
           R.drawable.boson,
            R.drawable.beranda,
           R.drawable.beranda,
            R.drawable.boson,
            R.drawable.beranda,
           R.drawable.boson,
           R.drawable.beranda,
           R.drawable.boson,
            R.drawable.beranda,


   };

    // menampilkan list item dalam bentuk text dengan tipe data string dengan variable name

    LayoutInflater inflater;
    public native_adapter(Context context) {
        this.context=context;
        inflater= LayoutInflater.from(context);
    }

    @Override
    public native_holder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.native_item, viewGroup, false);
        native_holder viewHolder = new native_holder(v);
        return viewHolder;
    }


        @Override
        public void onBindViewHolder(native_holder holder, int i) {
            holder.tv1.setText(name[i]);
            holder.tv1.setOnClickListener(clickListener);
            holder.tv1.setTag(holder);

            holder.tv2.setText(lis[i]);
            holder.tv2.setOnClickListener(clickListener);
            holder.tv2.setTag(holder);

            holder.imageView.setImageResource(imageView[i]);
            holder.imageView.setOnClickListener(clickListener);
            holder.imageView.setTag(holder);
        }



    View.OnClickListener clickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
//member aksi saat cardview diklik berdasarkan posisi tertentu
            native_holder vholder = (native_holder) v.getTag();

            int position = vholder.getPosition();
// MEMBERI KLIK
            if (position == 0 && position < getItemCount())
            {
                Intent intent = new Intent(context , regbpjs.class);
                context.startActivity(intent);


            }
            if (position == 1 && position < getItemCount()) {
                Intent intent = new Intent(context, lupa_pin.class);
                context.startActivity(intent);

            }
            if (position == 2 && position < getItemCount()) {
                Intent intent = new Intent(context, loginbpjs.class);
                context.startActivity(intent);

            }
            if (position == 3 && position < getItemCount()) {
                Intent intent = new Intent(context, reg_eps.class);
                context.startActivity(intent);


            }
            if (position == 4 && position < getItemCount()) {
                Intent intent = new Intent(context, log_eps.class);
                context.startActivity(intent);
            }
            if (position == 5 && position < getItemCount()) {
                Intent intent = new Intent(context, reg_sip.class);
                context.startActivity(intent);
            }
            if (position == 6 && position < getItemCount()) {
                Intent intent = new Intent(context, log_sip.class);
                context.startActivity(intent);
            }
            if (position == 7 && position < getItemCount()) {
                Intent intent = new Intent(context, reg_mitra.class);
                context.startActivity(intent);
            }
            if (position == 8 && position < getItemCount()) {
                Intent intent = new Intent(context, log_mitra.class);
                context.startActivity(intent);
            }
        }
    };

    @Override
    public int getItemCount() {
        return name.length;
    }
}