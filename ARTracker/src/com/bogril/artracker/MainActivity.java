package com.bogril.artracker;

import java.text.SimpleDateFormat;

import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    private static int elapsedTime = 0;
    boolean isTimerRunning = false;
    
    Button bCall;
    TextView tTimer;
    
    

    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);        
        bCall = (Button) findViewById(R.id.bCall);
        bCall.setOnClickListener(hbCall);
        bCall.setText("Start");
        tTimer = (TextView) findViewById(R.id.textTimer);
        tTimer.setText("Click button to start");
    }
    
    
    /** 
     * Returns a formated time HoursH MinutesM SecondsS
     * 
     * @param millis
     * @return
     */
    public static String formatTime(long millis) {
              String formatedTime = "";
              
              long seconds = millis / 1000;
              long minutes = seconds / 60;
              long hours = minutes / 60;
              
              seconds = seconds % 60;
              minutes = minutes % 60;
              hours = hours % 24;

              String sSeconds = String.valueOf(seconds);
              String sMinutes = String.valueOf(minutes);
              String sHours = String.valueOf(hours); 

              
              if (seconds < 10)
            	  sSeconds = "0" + seconds;
              if (minutes < 10)
            	  sMinutes = "0" + minutes;
              if (hours < 10){
              }
              return formatedTime += sHours + ":" + sMinutes + ":" + sSeconds;

    }
    
	
    protected void startTimer(final long time){
    	
    	
    	
    	new CountDownTimer(time, 1000) {


    		
    	     public void onTick(long millisUntilFinished) {
    	         tTimer.setText(formatTime(millisUntilFinished));
    	     }

    	     public void onFinish() {
    	    	 isTimerRunning = false;
    	         tTimer.setText("done!");
    	     }
    	  }.start();
    }
    
	public  Handler teaHandlerUpdater = new Handler(){
		public void handleMessage(Message msg){
			SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss"); 
			((TextView)findViewById (R.id.textTimer)).setText(df.format(elapsedTime));
			//((TextView)findViewById (R.id.textTimer)).setText("hello");
		}
	};
    
    
    

    
    OnClickListener hbCall = new OnClickListener(){

		@Override
		public void onClick(View v) {
			if(bCall.getText() == "Start" && isTimerRunning == false)
			{
				((Button)findViewById (R.id.bCall)).setText("Tea time?");
				startTimer(300000);
				isTimerRunning = true;
			} else if (bCall.getText() == ("Tea time?") && isTimerRunning == false)
			{
				((Button)findViewById (R.id.bCall)).setText("Start");
			} else
			{
				
				
			}
			
		}
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    
}
