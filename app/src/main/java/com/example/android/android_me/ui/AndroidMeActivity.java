/*
* Copyright (C) 2017 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*  	http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.example.android.android_me.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

// This activity will display a custom Android image composed of three body parts: head, body, and legs
public class AndroidMeActivity extends AppCompatActivity {

    private static final String EXTRA_HEAD_POSITION = "com.example.android.android_me.head_position";
    private static final String EXTRA_BODY_POSITION = "com.example.android.android_me.body_position";
    private static final String EXTRA_LEGS_POSITION = "com.example.android.android_me.legs_position";

    public static Intent getStartIntent(Context context, int headPosition, int bodyPosition,
                                        int legsPosition) {

        Intent intent = new Intent(context, AndroidMeActivity.class);
        intent.putExtra(EXTRA_HEAD_POSITION, headPosition);
        intent.putExtra(EXTRA_BODY_POSITION, bodyPosition);
        intent.putExtra(EXTRA_LEGS_POSITION, legsPosition);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_me);

        // Only create new fragments when there is no previously saved state
        if(savedInstanceState == null) {

            int headPosition = getIntent().getIntExtra(EXTRA_HEAD_POSITION, 0);
            int bodyPosition = getIntent().getIntExtra(EXTRA_BODY_POSITION, 0);
            int legsPosition = getIntent().getIntExtra(EXTRA_LEGS_POSITION, 0);

            // TODO (5) Retrieve list index values that were sent through an intent; use them to display the desired Android-Me body part image
                // Use setListindex(int index) to set the list index for all BodyPartFragments

            // Create a new head BodyPartFragment
            BodyPartFragment headFragment = new BodyPartFragment();

            // Set the list of image id's for the head fragment and set the position to the second image in the list
            headFragment.setImageIds(AndroidImageAssets.getHeads());
            headFragment.setListIndex(headPosition);

            // Add the fragment to its container using a FragmentManager and a Transaction
            FragmentManager fragmentManager = getSupportFragmentManager();

            fragmentManager.beginTransaction()
                    .add(R.id.head_container, headFragment)
                    .commit();

            // Create and display the body and leg BodyPartFragments

            BodyPartFragment bodyFragment = new BodyPartFragment();
            bodyFragment.setImageIds(AndroidImageAssets.getBodies());
            bodyFragment.setListIndex(bodyPosition);
            fragmentManager.beginTransaction()
                    .add(R.id.body_container, bodyFragment)
                    .commit();

            BodyPartFragment legFragment = new BodyPartFragment();
            legFragment.setImageIds(AndroidImageAssets.getLegs());
            legFragment.setListIndex(legsPosition);
            fragmentManager.beginTransaction()
                    .add(R.id.leg_container, legFragment)
                    .commit();
        }

    }
}
