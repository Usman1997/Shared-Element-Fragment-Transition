package com.example.fragmentanimation.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.transition.Fade;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fragmentanimation.DetailsTransition;
import com.example.fragmentanimation.R;

public class SplashFragment extends Fragment {
    ImageView imageView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_splash,container,false);
        imageView = (ImageView) view.findViewById(R.id.ivLogo);
        Handler handler = new Handler();
        final HomeFragment homeFragment = new HomeFragment();
        homeFragment.setSharedElementEnterTransition(new DetailsTransition());
        homeFragment.setEnterTransition(new Fade());
        setExitTransition(new Fade());
        homeFragment.setSharedElementReturnTransition(new DetailsTransition());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .addSharedElement(imageView, "logo_transition")
                        .replace(R.id.container, homeFragment)
                        .addToBackStack(null)
                        .commit();
            }
        },3000);

        return view;
    }
}
