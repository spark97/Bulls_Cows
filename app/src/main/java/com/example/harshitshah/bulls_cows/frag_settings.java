package com.example.harshitshah.bulls_cows;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.harshitshah.bulls_cows.R;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

/**
 * Created by Harshit Shah on 13/03/2016.
 */
public class frag_settings extends Fragment implements View.OnClickListener{
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

    }

    @Nullable

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_frag_settings,container,false);
        final EditText username = (EditText) view.findViewById(R.id.username);
        final Button save = (Button)view.findViewById(R.id.save);
        final RadioGroup difficulty_group = (RadioGroup)view.findViewById(R.id.radiogroup);
        SharedPreferences settings = getActivity().getSharedPreferences("settings", Context.MODE_PRIVATE);
        username.setText(settings.getString("username","Guest"));
        final SharedPreferences.Editor edit = settings.edit();
        edit.putInt("difficulty",4);
        difficulty_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
            RadioButton checkedbutton = (RadioButton) view.findViewById(checkedId);
                edit.putInt("difficulty",Integer.parseInt(checkedbutton.getText().toString()));
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user_name="";
                if(username.getText().toString().equals(""))
                {
                    user_name="Guest";
                }
                else
                {
                    user_name=username.getText().toString();
                }
                edit.putString("username", user_name);
                edit.commit();
                startActivity(new Intent(getActivity(),MainActivity.class));
            }
        });
        return view ;
    }
    @Override
    public void onClick(View v) {
    }
}
