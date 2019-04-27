package hackahealth.diatel;

import android.content.Context;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import adapters.FragmentPagerVpAdapter;
import fragments.glu_guide_fragments.SlideFiveFragment;
import fragments.glu_guide_fragments.SlideFourFragment;
import fragments.glu_guide_fragments.SlideOneFragment;
import fragments.glu_guide_fragments.SlideSevenFragment;
import fragments.glu_guide_fragments.SlideSixFragment;
import fragments.glu_guide_fragments.SlideThreeFragment;
import fragments.glu_guide_fragments.SlideTwoFragment;
import general.SharedPrefHandler;

public class GlucometerGuideActivity extends AppCompatActivity {

    Context context;
    ViewPager vp_slides;
    List<Fragment> fragments = new ArrayList<>();
    LinearLayout ll_next_fragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glucometer_guide);
        findViews();
        onClick();
        initPager();

    }

    private void initPager() {
        fragments.add(SlideOneFragment.newInstance());
        fragments.add(SlideTwoFragment.newInstance());
        fragments.add(SlideThreeFragment.newInstance());
        fragments.add(SlideFourFragment.newInstance());
        fragments.add(SlideFiveFragment.newInstance());
        fragments.add(SlideSixFragment.newInstance());
        fragments.add(SlideSevenFragment.newInstance());
        vp_slides.setAdapter(new FragmentPagerVpAdapter(getSupportFragmentManager(), fragments, new String[]{}));
    }

    private void findViews() {
        vp_slides = findViewById(R.id.vp_slides);
        ll_next_fragment = findViewById(R.id.ll_next_fragment);
    }

    private void onClick() {
        ll_next_fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (vp_slides.getCurrentItem() == 5){
                    ll_next_fragment.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            finish();
                        }
                    });
                    vp_slides.setCurrentItem(vp_slides.getCurrentItem()+1);
                }else{
                    vp_slides.setCurrentItem(vp_slides.getCurrentItem()+1);
                }

            }
        });
    }

    public Context getContext() {
        return context;
    }

}
