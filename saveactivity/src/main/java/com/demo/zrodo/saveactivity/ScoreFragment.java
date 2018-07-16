package com.demo.zrodo.saveactivity;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ScoreFragment extends Fragment {

    private static final String TAG = "ScoreFragment_vv";
    private int Score = 0;

    public ScoreFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //不销毁Fragment
       // setRetainInstance(true);


        if (savedInstanceState!=null){
            this.Score=savedInstanceState.getInt("Score");
        }
        Log.d(TAG, "onCreate() called with: savedInstanceState = [" + savedInstanceState + "]");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("Score",this.Score);
        Log.d(TAG, "onSaveInstanceState() called with: outState = [" + outState + "]");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_score, container, false);
        final TextView tv_score = (TextView) view.findViewById(R.id.tv_score);
        Button btn_add = (Button) view.findViewById(R.id.btn_add);
        tv_score.setText(String.valueOf(Score));
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_score.setText(String.valueOf(Score++));
            }
        });
        return view;
    }

}
