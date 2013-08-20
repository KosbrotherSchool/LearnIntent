package com.example.learnintent;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityA extends Activity {
	
	public final static String EXTRA_MESSAGE = "ActivityA.MESSAGE";
	private EditText mEditText;
	private Button mButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_a);
		
		mButton = (Button)findViewById(R.id.main_button);
		mButton.setOnClickListener(new Button.OnClickListener(){ 
            @Override
            public void onClick(View v) {
            	// add action here
            	sendMessage();
            }         

        });
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void sendMessage() {
	    Intent intent = new Intent(this, ActivityB.class);
	    mEditText = (EditText) findViewById(R.id.main_edittext);
	    String message = mEditText.getText().toString();
	    intent.putExtra(EXTRA_MESSAGE, message);
	    startActivity(intent);
	}
}
