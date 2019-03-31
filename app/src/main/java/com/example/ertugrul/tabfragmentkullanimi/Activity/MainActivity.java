package com.example.ertugrul.tabfragmentkullanimi.Activity;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.view.ViewPager;
import android.os.Bundle;

import com.example.ertugrul.tabfragmentkullanimi.R;
import com.example.ertugrul.tabfragmentkullanimi.Adapter.SectionsPagerAdapter;

public class MainActivity extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    TabLayout tabLayout;
    AppBarLayout appBarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        appBarLayout=findViewById( R.id.appbar );


        Toolbar toolbar = (Toolbar) findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );

        mSectionsPagerAdapter = new SectionsPagerAdapter( getSupportFragmentManager() );

        mViewPager = (ViewPager) findViewById( R.id.container );

        // TabLayout indislerine tıklayınca,ilgili Fragment sayfalarına bağlama
        //gorevi FragmentAdapter sınıfından sağlandı.
        tabLayout = (TabLayout) findViewById( R.id.tabs );

        tabLayout.addTab( tabLayout.newTab().setText( "Anasayfa" ) );
        tabLayout.addTab( tabLayout.newTab().setText( "Oyunlar" ) );
        tabLayout.addTab( tabLayout.newTab().setText( "Muzik" ) );

        mSectionsPagerAdapter.setTabSayisi( tabLayout.getTabCount() );
        mViewPager.setAdapter( mSectionsPagerAdapter );//fragment sınıflarını gosterebilmemiz olarak belirtilen nesne

        mViewPager.addOnPageChangeListener( new TabLayout.TabLayoutOnPageChangeListener( tabLayout ) );//Tablayout nesnesini viewPager tarafından indisinin degismesi saglandı.
        tabLayout.addOnTabSelectedListener( new TabLayout.ViewPagerOnTabSelectedListener( mViewPager ) );//Tıklanan TabItem'ı indisindeki fragment,ViewPager nesnesi içerisinde
        //gosterilsin.

     mViewPager.setOnPageChangeListener( new ViewPager.OnPageChangeListener() {
         @Override
         public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

         }

         @Override
         public void onPageSelected(int position) {
             if(position==0){
                 appBarLayout.setBackgroundResource( R.drawable.background_home );
             }else if(position ==1){
                 appBarLayout.setBackgroundResource( R.drawable.background_games );
             }else if(position==2){
                 appBarLayout.setBackgroundResource( R.drawable.background_music );
             }
         }

         @Override
         public void onPageScrollStateChanged(int state) {

         }
     } );



    }
}
