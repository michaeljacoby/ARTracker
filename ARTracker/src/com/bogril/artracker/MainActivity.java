package com.bogril.artracker;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

    private final Handler teaHandler = new Handler();
    
    Button bCall;
    
    private Runnable teaTask = new Runnable() {
		@Override
		public void run() {
			// TODO Auto-generated method stub			
			bCall.setText("Tea time?");			
		}    	
    };
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);        
        bCall = (Button) findViewById(R.id.bCall);
        bCall.setOnClickListener(hbCall);
        bCall.setText("Testing");
        teaHandler.postDelayed(teaTask, 5000);
    }
    
    OnClickListener hbCall = new OnClickListener(){

		@Override
		public void onClick(View v) {        
			
		}
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    
}
