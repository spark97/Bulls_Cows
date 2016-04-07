package com.example.harshitshah.bulls_cows;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.harshitshah.bulls_cows.R;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

/**
 * Created by Harshit Shah on 13/03/2016.
 */
public class highscores extends Fragment{
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
    }

    @Nullable

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.highscores, container, false);
        SharedPreferences highscore = getActivity().getSharedPreferences("highscores", Context.MODE_PRIVATE);
        TextView hs4 = (TextView)view.findViewById(R.id.hs4);
        hs4.setText(String.valueOf(highscore.getInt(String.valueOf(4), 0)));
        TextView hs5 = (TextView)view.findViewById(R.id.hs5);
        hs5.setText(String.valueOf(highscore.getInt(String.valueOf(5), 0)));
        TextView hs6 = (TextView)view.findViewById(R.id.hs6);
        hs6.setText(String.valueOf(highscore.getInt(String.valueOf(6), 0)));
        TextView hs7 = (TextView)view.findViewById(R.id.hs7);
        hs7.setText(String.valueOf(highscore.getInt(String.valueOf(7), 0)));
        TextView hs8 = (TextView)view.findViewById(R.id.hs8);
        hs8.setText(String.valueOf(highscore.getInt(String.valueOf(8), 0)));
        return view ;
    }
}
