package com.example.instagram;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

import static androidx.constraintlayout.widget.Constraints.TAG;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    public static ArrayList<String> avatars = new ArrayList<>();
    public static ArrayList<String> names = new ArrayList<>();
    public static ArrayList<String> images = new ArrayList<>();
    public static ArrayList<String> views = new ArrayList<>();
    public static ArrayList<String> descriptions = new ArrayList<>();
    public static ArrayList<Boolean> liked = new ArrayList<>();
    static ViewPager viewPager;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: ");

        initImageBitmaps();

        initFragmentPagerAdapter();

        initBottomNavigation();
    }

    private void initFragmentPagerAdapter(){

        viewPager = findViewById(R.id.viewPager);
        PagerAdapter ViewPagerAdapter = new PagerAdapter(getSupportFragmentManager(), 2);
        viewPager.setAdapter(ViewPagerAdapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Refresh();
                switch (position) {
                    case 0:
                        bottomNavigationView.getMenu().findItem(R.id.nav_home).setChecked(true);
                        break;
                    case 1:
                        bottomNavigationView.getMenu().findItem(R.id.nav_favorite).setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void initBottomNavigation(){
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        viewPager.setCurrentItem(0);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){
                    case R.id.nav_home:
                        //if(!(selectedFragment instanceof HomeFragment)) {
                            viewPager.setCurrentItem(0);
                        //}
                        break;
                    case R.id.nav_favorite:
                        //if(!(selectedFragment instanceof FavoriteFragment)) {
                            viewPager.setCurrentItem(1);
                        //}
                        break;
                }
                return true;
            }
        });
    }


    public static void Refresh(){
        viewPager.getAdapter().notifyDataSetChanged();
    }

    private void ClearAllData(){
        avatars.clear();
        names.clear();
        images.clear();
        descriptions.clear();
        views.clear();
        liked.clear();
    }

    private void initImageBitmaps() {
        Log.d(TAG, "initImageBitmaps: ");

        ClearAllData();

        avatars.add("https://upload.wikimedia.org/wikipedia/commons/9/9a/Cristiano_Ronaldo_Portugal.jpg");
        names.add("cristiano");
        images.add("https://images.daznservices.com/di/library/GOAL/ea/15/cristiano-ronaldo-portugal-2019_1ijno5xe50dz81kfres98dw065.jpg?t=1889555902&quality=60&w=1260");
        descriptions.add("Great game!");
        views.add("11456");
        liked.add(false);

        avatars.add("https://s-cdn.sportbox.ru/images/styles/690_388/fp_fotos/36/dc/751545fd3bb3b09958fcff34661b025f5e6f56659fd38301565428.jpg");
        names.add("neymarjr");
        images.add("https://i.eurosport.com/2020/02/19/2779809-57380197-1600-900.jpg");
        descriptions.add("Joga Bonito");
        views.add("121456");
        liked.add(false);

        avatars.add("https://i.insider.com/5d0375726fc92015a752d867?width=1100&format=jpeg&auto=webp");
        names.add("hazardeden_10");
        images.add("https://img.bleacherreport.net/img/images/photos/003/841/373/hi-res-b745ef1a8e0f2cd37b2a8e8de822f37f_crop_north.jpg?h=533&w=800&q=70&crop_x=center&crop_y=top");
        descriptions.add("Hala Madrid");
        views.add("122356");
        liked.add(false);

        avatars.add("https://thumbor.forbes.com/thumbor/fit-in/416x416/filters%3Aformat%28jpg%29/https%3A%2F%2Fspecials-images.forbesimg.com%2Fimageserve%2F5cfe85694c687b0008593562%2F0x0.jpg%3Fbackground%3D000000%26cropX1%3D19%26cropX2%3D1756%26cropY1%3D210%26cropY2%3D1948");
        names.add("k.mbappe");
        images.add("https://s.ill.in.ua/i/news/630x373/412/412784.jpg");
        descriptions.add("Great win!");
        views.add("324356");
        liked.add(false);

        avatars.add("https://thumbor.forbes.com/thumbor/fit-in/416x416/filters%3Aformat%28jpg%29/https%3A%2F%2Fspecials-images.forbesimg.com%2Fimageserve%2F5cfea7bb4c687b0008593c0a%2F0x0.jpg%3Fbackground%3D000000%26cropX1%3D1554%26cropX2%3D2474%26cropY1%3D240%26cropY2%3D1159");
        names.add("leomessi");
        images.add("https://s.yimg.com/uu/api/res/1.2/RJd4xEs1VP2YSM5mqWdQjA--~B/aD0xNjQzO3c9MjkyMTtzbT0xO2FwcGlkPXl0YWNoeW9u/https://media.zenfs.com/en/pa-sport.com/04e0152e20af11460f92aea145992596");
        descriptions.add("2011 year");
        views.add("3132436");
        liked.add(false);

        avatars.add("https://i.dailymail.co.uk/1s/2020/03/19/00/26143558-0-image-a-9_1584576814488.jpg");
        names.add("paulpogba");
        images.add("https://cdn.newsapi.com.au/image/v1/59f8a792bf7cb64b1a635f7d854baf25");
        descriptions.add("Red devils");
        views.add("5112936");
        liked.add(false);

        avatars.add("https://img.fcbayern.com/image/fetch/f_auto,h_880,q_auto:good,w_660/https://fcbayern.com/binaries/content/gallery/fc-bayern/homepage/saison-19-20/galerien/spiele/fcb-schalke/06_fcb_s04_get_250120.jpg/06_fcb_s04_get_250120.jpg/fcbhippo%3Alargeninetotwelve%3Fv%3D1580118185737");
        names.add("_rl9");
        images.add("https://www.dw.com/image/50158768_303.jpg");
        descriptions.add("Bayern Munich");
        views.add("2222226");
        liked.add(false);

        avatars.add("https://img.championat.com/s/735x490/news/big/w/x/kokorin-vo-vsjom-mire-priostanovili-chempionaty-pochemu-my-dolzhny-vydeljatsja_15842846281104802801.jpg");
        names.add("kokorin9");
        images.add("https://s-cdn.sportbox.ru/images/styles/690_388/fp_fotos/cf/f2/4d10d6effa416ad01b25658edeb1514a5e4b38af6f730841795924.jpg");
        descriptions.add("Easy katka");
        views.add("12106");
        liked.add(false);

        avatars.add("https://talksport.com/wp-content/uploads/sites/5/2019/07/NINTCHDBPICT000507674963.jpg?strip=all&w=960&quality=100");
        names.add("garethbale11");
        images.add("https://en.as.com/en/imagenes/2019/12/29/football/1577633185_536223_noticia_normal.jpg");
        descriptions.add("Road to Istanbul");
        views.add("502106");
        liked.add(false);
    }
}


