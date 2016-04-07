package com.example.harshitshah.bulls_cows;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.method.LinkMovementMethod;
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
public class developer extends Fragment{
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
    }

    @Nullable

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.developer,container,false);
        TextView me = (TextView)view.findViewById(R.id.me);
        String abtme="Pursuing Bachelor Of Technology Degree (Currently in 2nd Year) In Computer Science And Engineering"+"\n\n"+"Motilal Nehru National Institute Of Technology, Allahabad"+"\n\n"+"Email:harshitshahmnnit@gmail.com";
        me.setText(abtme);
       /* TextView fb = (TextView)view.findViewById(R.id.facebook);
        String facebook = "<a href=\"http://www.facebook.com/harshit.shah.507\">Facebook</a>";
        fb.setText(Html.fromHtml(facebook));
        fb.setClickable(true);
        fb.setMovementMethod(LinkMovementMethod.getInstance());*/
        return view;
    }
}

