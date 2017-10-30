package com.cek.bpjs.online;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private baruadapter mAdapter;
    private ArrayList<String> listCountry;
    private ArrayList<String> listdetail;
    private ArrayList<Integer> listFlag;
    private GridView gridView;
    InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.activity_main);
        prepareList();

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-1142409875326374/6834885522");


        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mInterstitialAd.loadAd(adRequest);

        mAdapter = new baruadapter(this,listCountry, listdetail, listFlag);
        // Set custom adapter to gridview
        gridView = (GridView) findViewById(R.id.gridView1);
        gridView.setAdapter(mAdapter);

        // Implement On Item click listener
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                final Intent intent;
                switch(position)
                {
                    case 0:
                        intent =  new Intent(getApplicationContext(), native_main_recycle.class);
                        if (mInterstitialAd.isLoaded()) {
                            mInterstitialAd.show();
                        }
                        break;
                    case 1:
                        intent =  new Intent(getApplicationContext(), daftar.class);
                        if (mInterstitialAd.isLoaded()) {
                            mInterstitialAd.show();
                        }
                        break;
                    case 2:
                        intent =  new Intent(getApplicationContext(), cek.class);
                        if (mInterstitialAd.isLoaded()) {
                            mInterstitialAd.show();
                        }
                        break;
                    case 3:
                        intent =  new Intent(getApplicationContext(), faskes.class);
                        if (mInterstitialAd.isLoaded()) {
                            mInterstitialAd.show();
                        }
                        break;
                    case 4:
                        intent =  new Intent(getApplicationContext(), monitoring.class);
                        if (mInterstitialAd.isLoaded()) {
                            mInterstitialAd.show();
                        }
                        break;
                    case 5:
                        intent =  new Intent(getApplicationContext(), alamat.class);
                        if (mInterstitialAd.isLoaded()) {
                            mInterstitialAd.show();
                        }
                        break;
                    case 6:
                        intent =  new Intent(getApplicationContext(), telp.class);
                        if (mInterstitialAd.isLoaded()) {
                            mInterstitialAd.show();
                        }
                        break;
                    default:
                        intent =  new Intent(getApplicationContext(), daftar_usaha.class);
                        if (mInterstitialAd.isLoaded()) {
                            mInterstitialAd.show();
                        }
                        break;
                }
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        if (id == R.id.share) {
            Intent share = new Intent(android.content.Intent.ACTION_SEND);
            share.setType("text/plain");
            share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);

            // Add data to the intent, the receiving app will decide
            // what to do with it.
            share.putExtra(Intent.EXTRA_SUBJECT, "Download aplikasi BPJS Kesehatan Dan Ketenagakerjaan");
            share.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=com.cek.bpjs.online");

            startActivity(Intent.createChooser(share, "Share Aps!"));
        }


        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intentu= new Intent(MainActivity.this,about.class);
            startActivity(intentu);
            Toast.makeText(this, "about", Toast.LENGTH_LONG).show();
            return true;
        }

        if (id == R.id.more) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/developer?id=pemikir%20versi%20baru"));
            startActivity(intent);
            Toast.makeText(this, "more aps", Toast.LENGTH_LONG).show();
            return true;
        }


        return super.onOptionsItemSelected(item);
    }


    boolean doubleBackToExitPressedOnce = false;
    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Press back again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }

    public void prepareList()
    {
        listCountry = new ArrayList<String>();
        listCountry.add("cek data BPJS ketenagakerjaan anda disini");
        listCountry.add("daftarkan diri anda dengan BPJS online");
        listCountry.add("cek BPJS, tagihan, iuran, tunggakan dll");
        listCountry.add("fasilitas kesehatan lihat disini memudahkan anda");
        listCountry.add("kontrol dan pantau BPJS anda secara rutin");
        listCountry.add("cek alamat kantor BPJS disekitar anda");
        listCountry.add("Health Facilities Information System (H.F.I.S)");
        listCountry.add("daftarkan usaha anda agar tercatat dikantor pusat");


        listdetail = new ArrayList<String>();
        listdetail.add("BPJS KETENAGAKERJAAN");
        listdetail.add("DAFTAR BPJS KESEHATAN");
        listdetail.add("CEK KARTU BPJS");
        listdetail.add("FASILITAS KESEHATAN");
        listdetail.add("MONITORING");
        listdetail.add("ALAMAT BPJS");
        listdetail.add("FASKES H.F.I.S");
        listdetail.add("USAHA ANDA");


        listFlag = new ArrayList<Integer>();
        listFlag.add(R.drawable.tenagah);
        listFlag.add(R.drawable.regis);
        listFlag.add(R.drawable.carif);
        listFlag.add(R.drawable.faske);
        listFlag.add(R.drawable.monitor);
        listFlag.add(R.drawable.alamat);
        listFlag.add(R.drawable.telp);
        listFlag.add(R.drawable.usah);

    }
}
