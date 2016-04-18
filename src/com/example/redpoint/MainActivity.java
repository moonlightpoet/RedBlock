package com.example.redpoint;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

    private int redId;
    private int score = 0;
    private TextView textView1;
    private Button[] buttons = new Button[9];
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        textView1 = (TextView) findViewById(R.id.textView1);
        textView1.setText("当前得分：0");
        buttons[0] = (Button) findViewById(R.id.button0);
        buttons[1] = (Button) findViewById(R.id.button1);
        buttons[2] = (Button) findViewById(R.id.button2);
        buttons[3] = (Button) findViewById(R.id.button3);
        buttons[4] = (Button) findViewById(R.id.button4);
        buttons[5] = (Button) findViewById(R.id.button5);
        buttons[6] = (Button) findViewById(R.id.button6);
        buttons[7] = (Button) findViewById(R.id.button7);
        buttons[8] = (Button) findViewById(R.id.button8);
        
        redId = (int) (Math.random() * 9) % 9;
        buttons[redId].setBackgroundColor(Color.rgb(255, 0, 0));
        
        for (int i = 0; i < 9; i ++) {
        	buttons[i].setOnClickListener(new MyOnClickListener(this, i));
        }
    }
	
	class MyOnClickListener implements OnClickListener {
		
		private Activity context;
		private int id;
		
		public MyOnClickListener(Activity context, int id) {
			this.context = context;
			this.id = id;
		}

		@Override
		public void onClick(View arg0) {
			if (id == redId) {
				score += 10;
				buttons[redId].setBackgroundColor(Color.rgb(238, 238, 238));
				redId = (int) (Math.random() * 9) % 9;
		        buttons[redId].setBackgroundColor(Color.rgb(255, 0, 0));
			} else {
				score -= 10;
			}
			textView1.setText("当前得分：" + score);
		}
		
	}
}
