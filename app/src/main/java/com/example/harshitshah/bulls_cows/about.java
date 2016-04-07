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
public class about extends Fragment{
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
    }

    @Nullable

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.about,container,false);
        TextView instructions = (TextView)view.findViewById(R.id.instructions);
        String ins =" 1.  The game is usually played with digits ranging from 4 to 8. "+"\n"+" 2.  The digits can be set in terms of difficulty."+"\n"+" 3.  The device generates a random number. The digits are all different and do not contain 0."+"\n"+" 4.  Then the player try to guess the number to which the device responds the number of matches."+"\n"+" 5.  If the matching digits are in their right positions, they are bulls, if in different positions, they are cows."+"\n"+" 6.  Example:"+"\n"+" Secret number: 4271"+"\n"+" Opponent's try: 4329"+"\n"+" Answer: 1 bull and 1 cows"+"\n"+" (The bull is 4, the cow is 2.)";
        instructions.setText(ins);
        return view;
    }
}

