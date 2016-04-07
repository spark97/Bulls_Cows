package com.example.harshitshah.bulls_cows;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
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
import java.util.Locale;
import java.util.Random;

/**
 * Created by Harshit Shah on 13/03/2016.
 */
public class frag_play_game extends Fragment implements View.OnClickListener{
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        final EditText guess = (EditText)getActivity().findViewById(R.id.guess);
        outState.putString("guess",guess.getText().toString());
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        EditText guess = (EditText)this.getActivity().findViewById(R.id.guess);
    }

    @Nullable

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable final Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_frag_play_game, container, false);
        SharedPreferences settings = getActivity().getSharedPreferences("settings", Context.MODE_PRIVATE);
        SharedPreferences highscore = getActivity().getSharedPreferences("highscores", Context.MODE_PRIVATE);
        if(savedInstanceState!=null)
        {
            onViewStateRestored(savedInstanceState);
        }
        final int difficulty = settings.getInt("difficulty", 4);
        TextView hs = (TextView)view.findViewById(R.id.hs);
        int high = (highscore.getInt(String.valueOf(difficulty),0));
        hs.setText("High Score: " + String.valueOf(high));
        SharedPreferences.Editor edit = highscore.edit();
        Button check = (Button)view.findViewById(R.id.check);
        Button newgame = (Button)view.findViewById(R.id.newgame);
        EditText guess = (EditText)view.findViewById(R.id.guess);
        newgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
                startActivity(new Intent(getActivity(), MainActivity.class));
            }
        });
        TextView showdiff = (TextView)view.findViewById(R.id.difficulty);
        showdiff.setText(difficulty + " Digit Number");
        startgame(view, difficulty, savedInstanceState);
        return view ;
    }
    public void startgame(View view, final int difficulty,Bundle savedInstanceState)
    {
        if(savedInstanceState!=null)
        {
            final EditText guess = (EditText)view.findViewById(R.id.guess);
            guess.setText(savedInstanceState.getString("guess"));
        }
        ListView lv = (ListView)view.findViewById(R.id.lv);
       final ArrayList results = new ArrayList<String>();
        final ArrayAdapter adapter = new ArrayAdapter(getContext(),R.layout.listview,R.id.lvtext,results);
        lv.setAdapter(adapter);
        final SharedPreferences highscore = getActivity().getSharedPreferences("highscores", Context.MODE_PRIVATE);
        final SharedPreferences.Editor edit = highscore.edit();
        final int[] steps = {0};
        final TextView step = (TextView) view.findViewById(R.id.steps);
        step.setText(String.valueOf(steps[0])+" Steps");
        int temp;
        int number;
        Random random = new Random();
        while(true) {
            temp=0;
            int hash[] = new int[255];
            int i;
            for(i=0;i<=9;i++)
            {
                hash[i]=0;
            }
            number = random.nextInt() % (int)Math.pow(10, difficulty);
            if(number<0)
                number=number*(-1);
                number += (int)Math.pow(10,difficulty-1);
            if(number<0)
                number=number*(-1);
            final String numbertext = String.valueOf(number);
            if(numbertext.indexOf('0')!=-1)
                continue;
            for(i=0;i<=difficulty-1;i++)
            {
                if(hash[numbertext.charAt(i)]==1)
                {
                    temp=1;
                }
                else
                {
                    hash[numbertext.charAt(i)]=1;
                }
            }
            if(temp==1)
                continue;
            else
                break;
        }
        //Toast.makeText(view.getContext(),String.valueOf(number),Toast.LENGTH_SHORT).show();
        TextView hs = (TextView)view.findViewById(R.id.hs);
        final String numbertext = String.valueOf(number);
        final EditText guess = (EditText)view.findViewById(R.id.guess);
        guess.setText("");
        Button check = (Button)view.findViewById(R.id.check);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String guesstext = guess.getText().toString();
                if (guesstext.equals("")) {
                    Toast.makeText(v.getContext(), "Please Enter Your Guess", Toast.LENGTH_LONG).show();
                } else {
                    if (guesstext.length() != difficulty) {
                        Toast.makeText(v.getContext(), "Please Enter A "+difficulty+" Digit Guess", Toast.LENGTH_LONG).show();
                    } else {
                        int i, hash[] = new int[255];
                        int temp = 0;
                        for (i = 0; i <= 9; i++)
                            hash[i] = 0;
                        for (i = 0; i <= difficulty-1; i++) {
                            if (hash[guesstext.charAt(i)] == 1)
                                temp = 1;
                            else
                                hash[guesstext.charAt(i)] = 1;
                        }

                        if (temp == 1)
                            Toast.makeText(v.getContext(), "Digits should not repeat", Toast.LENGTH_SHORT).show();

                        else {
                            temp = 0;
                            if(guesstext.indexOf("0")!=-1)
                            {
                                Toast.makeText(v.getContext(), "Number Should Not Contain 0", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                if (guesstext.equals(numbertext)) {
                                    steps[0]++;
                                    step.setText(String.valueOf(steps[0]) + " Steps");
                                    Toast.makeText(v.getContext(), "Correct Guess", Toast.LENGTH_SHORT).show();
                                    if (highscore.getInt(String.valueOf(difficulty), 0) == 0) {
                                        edit.putInt(String.valueOf(difficulty), steps[0]);
                                        edit.commit();
                                    } else if (steps[0] < highscore.getInt(String.valueOf(difficulty), 0)) {
                                        edit.putInt(String.valueOf(difficulty), steps[0]);
                                        edit.commit();
                                    }
                                    getActivity().finish();
                                    startActivity(new Intent(getActivity(), MainActivity.class));
                                } else {
                                    steps[0]++;
                                    step.setText(String.valueOf(steps[0]) + " Steps");
                                    int bulls = 0, cows = 0;
                                    for (i = 0; i <= difficulty - 1; i++) {
                                        if (guesstext.charAt(i) == numbertext.charAt(i))
                                            bulls++;
                                    }
                                    for (i = 0; i <= difficulty - 1; i++) {
                                        if (guesstext.charAt(i) != numbertext.charAt(i) && numbertext.indexOf(guesstext.charAt(i)) != -1)
                                            cows++;
                                    }
                                    adapter.insert(guesstext + "          " + bulls + " Bulls : " + cows + " Cows", 0);
                                    //finalTts2.speak(guesstext + "          " + bulls + " Bulls : " + cows + " Cows", TextToSpeech.QUEUE_FLUSH, null);
                                }
                            }
                        }
                    }
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
    }
}
