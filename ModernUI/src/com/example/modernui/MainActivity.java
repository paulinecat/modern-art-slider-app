package com.example.modernui;

import java.util.ArrayList;

import android.support.v7.app.ActionBarActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
	private ArrayList<TextView> list = new ArrayList<TextView>();
	private int[] listColor = new int[8];
	private SeekBar bar = null;
	private int color1 = Color.parseColor("#E74C3C");
	private int color2 = Color.parseColor("#FF8D76");
	private int color3 = Color.parseColor("#15415E");
	private int color4 = Color.parseColor("#1C6B8E");
	private int white = Color.parseColor("#ffffff");
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        generateView();
        
        bar = (SeekBar) findViewById(R.id.color_bar);
        bar.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){

        	/* As the user slides the seekbar, the hue of all TextViews will change*/
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				for(int i = 0; i < list.size(); i++){
					setColorFilter(list.get(i), bar.getProgress(), listColor[i]);
				}
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {

			}
        	
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.more_info) {
        	AlertDialog.Builder builder = new AlertDialog.Builder(this);
        	
        	builder.setMessage(R.string.dialog_message)
            	.setTitle(R.string.dialog_title)
            	.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener(){
            		public void onClick(DialogInterface dialog, int id) {          			
            			String url = "http://www.moma.org/";
            			Intent intent = new Intent(Intent.ACTION_VIEW);
            			intent.setData(Uri.parse(url));
            			startActivity(intent);
                    }
            	})
            	.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener(){
            		public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
            	});
        	
        	AlertDialog dialog = builder.create();
        	dialog.show();
        	
        	return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    public void generateView(){

    	/* Defines each TextView */
    	final TextView view1 = new TextView(this);
    	view1.setBackgroundColor(color3);
    	view1.setId(1);
    	listColor[0] = color3;
    	
    	final TextView view2 = new TextView(this);
    	view2.setBackgroundColor(color1);
    	view2.setId(2);
    	listColor[1] = color1;
    	
    	final TextView view3 = new TextView(this);
    	view3.setBackgroundColor(color2);
    	view3.setId(3);
    	listColor[2] = color2;
    	
    	final TextView view4 = new TextView(this);
    	view4.setBackgroundColor(color2);
    	view4.setId(4);
    	listColor[3] = color2;
    	
    	final TextView view5 = new TextView(this);
    	view5.setBackgroundColor(white);
    	view5.setId(5);
    	listColor[4] = white;
    	
    	final TextView view6 = new TextView(this);
    	view6.setBackgroundColor(color3);
    	view6.setId(6);
    	listColor[5] = color3;
    	
    	final TextView view7 = new TextView(this);
    	view7.setBackgroundColor(color4);
    	view7.setId(7);
    	listColor[6] = color4;
    	
    	final TextView view8 = new TextView(this);
    	view8.setBackgroundColor(color1);
    	view8.setId(8);
    	listColor[7] = color1;
    	
    	/* Sets each TextView's size and location */
    	final RelativeLayout main = (RelativeLayout) findViewById(R.id.color_layout);
    	ViewTreeObserver viewTreeObserver = main.getViewTreeObserver();
    	viewTreeObserver.addOnGlobalLayoutListener(new OnGlobalLayoutListener(){

			@Override
			public void onGlobalLayout() {
				int horizUnit = main.getMeasuredWidth() / 4;
				int vertUnit = main.getMeasuredHeight() / 8;
				
				RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(horizUnit - 20, vertUnit - 20);
		    	params1.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
		    	params1.addRule(RelativeLayout.ALIGN_PARENT_TOP);
		    	params1.setMargins(10, 10, 10, 10);
		    	view1.setLayoutParams(params1);
		    	
		    	RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(horizUnit - 20, vertUnit * 4);
		    	params2.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
		    	params2.addRule(RelativeLayout.BELOW, view1.getId());
		    	params2.setMargins(10, 0, 10, 0);
		    	view2.setLayoutParams(params2);
		    	
		    	RelativeLayout.LayoutParams params3 = new RelativeLayout.LayoutParams(horizUnit - 20, vertUnit - 10);
		    	params3.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
		    	params3.addRule(RelativeLayout.BELOW, view2.getId());
		    	params3.setMargins(10, 10, 10, 0);
		    	view3.setLayoutParams(params3);
		    	
		    	RelativeLayout.LayoutParams params4 = new RelativeLayout.LayoutParams(horizUnit * 3 - 10, vertUnit * 4 - 20);
		    	params4.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		    	params4.addRule(RelativeLayout.ALIGN_PARENT_TOP);
		    	params4.setMargins(0, 10, 10, 10);
		    	view4.setLayoutParams(params4);
		    	
		    	RelativeLayout.LayoutParams params5 = new RelativeLayout.LayoutParams(horizUnit - 10, vertUnit * 2);
		    	params5.addRule(RelativeLayout.LEFT_OF, view6.getId());
		    	params5.addRule(RelativeLayout.BELOW, view4.getId());
		    	params5.setMargins(0, 0, 10, 0);
		    	view5.setLayoutParams(params5);
		    	
		    	RelativeLayout.LayoutParams params6 = new RelativeLayout.LayoutParams(horizUnit * 2 - 10, vertUnit * 2);
		    	params6.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		    	params6.addRule(RelativeLayout.BELOW, view4.getId());
		    	params6.setMargins(0, 0, 10, 0);
		    	view6.setLayoutParams(params6);
		    	
		    	RelativeLayout.LayoutParams params7 = new RelativeLayout.LayoutParams(horizUnit * 3 - 20, vertUnit * 2 - 20);
		    	params7.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
		    	params7.addRule(RelativeLayout.BELOW, view3.getId());
		    	params7.setMargins(10, 10, 10, 10);
		    	view7.setLayoutParams(params7);
		    	
		    	RelativeLayout.LayoutParams params8 = new RelativeLayout.LayoutParams(horizUnit - 10, vertUnit * 2 - 20);
		    	params8.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
		    	params8.addRule(RelativeLayout.BELOW, view6.getId());
		    	params8.setMargins(0, 10, 10, 10);
		    	view8.setLayoutParams(params8);
			}
    		
    	});
    	
    	/* Stores each view in a list */
    	list.add(view1);
    	list.add(view2);
    	list.add(view3);
    	list.add(view4);
    	list.add(view5);
    	list.add(view6);
    	list.add(view7);
    	list.add(view8);
    	
    	/* Adds Views to parent RelativeLayout */
    	main.addView(view1);
    	main.addView(view2);
    	main.addView(view3);
    	main.addView(view4);
    	main.addView(view5);
    	main.addView(view6);
    	main.addView(view7);
    	main.addView(view8);
    }
    
    /* Changes Hue */
    public void setColorFilter(TextView view, int progress, int color){
    	float hueUnit = 360 / 100;
    	float[] hsv = new float[3];
    	Color.colorToHSV(color, hsv);
    	
    	float hue = hsv[0] + progress * hueUnit;
    	if (hue > 360) hue -= 360;
    	
    	hsv[0] = hue;
    
    	view.setBackgroundColor(Color.HSVToColor(hsv));
    }
}
