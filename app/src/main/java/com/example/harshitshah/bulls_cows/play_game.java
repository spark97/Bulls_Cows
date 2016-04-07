package com.example.harshitshah.bulls_cows;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

import static android.widget.Toast.LENGTH_LONG;

/**
 * Created by Harshit Shah on 28/03/2016.
 */
public class play_game extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.play_game,container,false);
        Button check = (Button)view.findViewById(R.id.check);
        Button newgame = (Button)view.findViewById(R.id.newgame);
        EditText guess = (EditText)view.findViewById(R.id.guess);
        newgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startgame(view);
            }
        });
        startgame(view);
        return view ;
    }
    public void startgame(View view)
    {
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
            number = random.nextInt() % 10000;
            if (number < 1000) {
                number += 1000;
            }
            final String numbertext = String.valueOf(number);
            for(i=0;i<=3;i++)
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
        final String numbertext = String.valueOf(number);
        final EditText guess = (EditText)view.findViewById(R.id.guess);
        guess.setText("");
        Button check = (Button)view.findViewById(R.id.check);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String guesstext = guess.getText().toString();
                if(guesstext.equals(""))
                {
                    Toast.makeText(v.getContext(), "Please Enter Your Guess", LENGTH_LONG).show();
                }
                else
                {
                    if(guesstext.length()!= 4)
                    {
                        Toast.makeText(v.getContext(),"Please Enter A 4 Digit Guess", LENGTH_LONG).show();
                    }
                    else {
                        int i, hash[] = new int[255];
                        int temp = 0;
                        for (i = 0; i <= 9; i++)
                            hash[i] = 0;
                        for (i = 0; i <= 3; i++) {
                            if (hash[guesstext.charAt(i)] == 1)
                                temp = 1;
                            else
                                hash[guesstext.charAt(i)] = 1;
                        }
                        if (temp == 1)
                            Toast.makeText(v.getContext(), "Digits should not repeat", Toast.LENGTH_SHORT).show();
                        else {
                            if (guesstext.equals(numbertext)) {
                                Toast.makeText(v.getContext(), "Correct Guess", Toast.LENGTH_SHORT).show();
                                return;
                            } else {
                                int bulls = 0, cows = 0;
                                for (i = 0; i <= 3; i++) {
                                    if (guesstext.charAt(i) == numbertext.charAt(i))
                                        bulls++;
                                }
                                for(i=0;i<=3;i++)
                                {
                                    if(guesstext.charAt(i)!=numbertext.charAt(i) && numbertext.indexOf(guesstext.charAt(i))!=-1)
                                        cows++;
                                }
                                Toast.makeText(v.getContext(), bulls + " Bulls : " + cows + " Cows", LENGTH_LONG).show();
                            }
                        }
                    }
                }
            }
        });
    }
}
