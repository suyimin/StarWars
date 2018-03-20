package com.yalantis.starwarsdemo.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.yalantis.starwarsdemo.R;
import com.yalantis.starwarsdemo.interfaces.GreetingFragmentInterface;

/**
 * Created by Artem Kholodnyi on 11/17/15.
 */
public class GreetingsFragment extends Fragment {
    public final static String TAG = GreetingsFragment.class.getCanonicalName();

    Toolbar mToolbar;
    Button btnSetupProfile;

    private GreetingFragmentInterface mListener;

    public static GreetingsFragment newInstance() {
        return new GreetingsFragment();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mListener = (GreetingFragmentInterface) getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_greetings, container, false);
        mToolbar = (Toolbar) view.findViewById(R.id.toolbar);
        btnSetupProfile = (Button) view.findViewById(R.id.btn_setup_profile);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mToolbar.setNavigationIcon(R.drawable.ic_menu);
        btnSetupProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onSetupProfileClick();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

}
