package com.dacasa.nyimbozakristo;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

public class NyimboFr extends FragmentActivity {
   @Override
    public void onCreate(Bundle savedInstanceState){
       super.onCreate(savedInstanceState);
       if (savedInstanceState == null){
           getSupportFragmentManager().beginTransaction()
                   .add(android.R.id.content, new NyimboFragment()).commit();
       }
   }


}
