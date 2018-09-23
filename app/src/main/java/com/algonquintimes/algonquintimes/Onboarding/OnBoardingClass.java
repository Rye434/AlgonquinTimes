package com.algonquintimes.algonquintimes.Onboarding;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.algonquintimes.algonquintimes.Articles.ArticlesActivity;
import com.algonquintimes.algonquintimes.R;
import com.codemybrainsout.onboarder.AhoyOnboarderActivity;
import com.codemybrainsout.onboarder.AhoyOnboarderCard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jason on 2018-03-22.
 *
 * OnBoardingActivity
 * runs onboarding module
 *
 */


public class OnBoardingClass extends AhoyOnboarderActivity {

    public Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mContext = this;

        AhoyOnboarderCard ahoyOnboarderCard1 = new AhoyOnboarderCard("", "", R.drawable.newspaper);
        AhoyOnboarderCard ahoyOnboarderCard2 = new AhoyOnboarderCard("", "", R.drawable.events);
        AhoyOnboarderCard ahoyOnboarderCard3 = new AhoyOnboarderCard("", "", R.drawable.socialmedia);

        ahoyOnboarderCard1.setBackgroundColor(R.color.bordergreen);
        ahoyOnboarderCard2.setBackgroundColor(R.color.bordergreen);
        ahoyOnboarderCard3.setBackgroundColor(R.color.bordergreen);


        List<AhoyOnboarderCard> pages = new ArrayList<>();

        pages.add(ahoyOnboarderCard1);
        pages.add(ahoyOnboarderCard2);
        pages.add(ahoyOnboarderCard3);

        for (AhoyOnboarderCard page : pages) {
            page.setTitleColor(R.color.white);
            page.setDescriptionColor(R.color.grey_200);
        }

        setFinishButtonTitle("Get Started");
        showNavigationControls(false);
        setColorBackground(R.color.black);


        setInactiveIndicatorColor(R.color.grey_600);
        setActiveIndicatorColor(R.color.white);
        setOnboardPages(pages);

    }

    @Override
    public void onFinishButtonPressed() {

        SharedPreferences pref = getSharedPreferences("MyPrefs", mContext.MODE_PRIVATE);
        SharedPreferences.Editor edit = pref.edit();
        edit.putString("log", "true");
        edit.commit();

        startActivity(new Intent(mContext, ArticlesActivity.class)
                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
        finish();
    }
}