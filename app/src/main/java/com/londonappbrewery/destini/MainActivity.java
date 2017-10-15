package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    private TextView mStoryTextView;
    private Button mButton1;
    private Button mButton2;
    private int mStoryIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mStoryTextView = (TextView) findViewById(R.id.storyTextView);
        mButton1 = (Button) findViewById(R.id.buttonTop);
        mButton2 = (Button) findViewById(R.id.buttonBottom);

        // CHECK TO SEE IF AN INSTANCE STATE IS SAVED
        if(savedInstanceState != null){
         mStoryIndex = savedInstanceState.getInt("GameIndex");
            // IF THE STORY INDEX IS 0 THE GAME IS AT THE END NO NEED TO RESET TEXT
         if(mStoryIndex != 0){
             setGameText(mStoryIndex);
         }
        }


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // IF BUTTON ONE IS PUSHED CHANGE THE TEXT AND BUTTONS
                if(mButton1.getText() == getResources().getString(R.string.T1_Ans1)){
                    mStoryIndex = 3;
                }else if(mButton1.getText() == getResources().getString(R.string.T3_Ans1)){
                    mStoryIndex = 6;
                    /// NEED TO ADD END GAME SEQUENCE
                }else if(mButton1.getText() == getResources().getString(R.string.T2_Ans1)){
                    mStoryIndex = 3;
                }
                setGameText(mStoryIndex);
            }
        });



        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mButton2.getText() == getResources().getString(R.string.T1_Ans2)){
                    mStoryIndex = 2;
                }else if(mButton2.getText() == getResources().getString(R.string.T2_Ans2)){
                    mStoryIndex = 4;
                }else if(mButton2.getText() == getResources().getString(R.string.T3_Ans2)){
                    mStoryIndex = 5;
                }else{
                    finish();
                }
                setGameText(mStoryIndex);
            }
        });

    }

    private void setGameText(int storyIndex){
        if(storyIndex == 1){
            mStoryTextView.setText(R.string.T1_Story);
            mButton1.setText(R.string.T1_Ans1);
            mButton2.setText(R.string.T1_Ans2);
        }else if(storyIndex == 2){
            mStoryTextView.setText(R.string.T2_Story);
            mButton1.setText(R.string.T2_Ans1);
            mButton2.setText(R.string.T2_Ans2);
        }else if(storyIndex == 3){
            mStoryTextView.setText(R.string.T3_Story);
            mButton1.setText(R.string.T3_Ans1);
            mButton2.setText(R.string.T3_Ans2);
        }else if(storyIndex == 4){
            mStoryTextView.setText(R.string.T4_End);
            endGame();
        }else if(storyIndex == 5){
            mStoryTextView.setText(R.string.T5_End);
            endGame();
        }else if(storyIndex == 6){
            mStoryTextView.setText(R.string.T6_End);
            endGame();
        }
    }

    private void endGame(){
        mStoryIndex = 0;
        mButton1.setVisibility(View.INVISIBLE);
        mButton2.setText("Close App");
    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("GameIndex", mStoryIndex);
    }


}
