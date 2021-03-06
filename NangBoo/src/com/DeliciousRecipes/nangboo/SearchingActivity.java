package com.DeliciousRecipes.nangboo;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class SearchingActivity extends Activity{
	
	Button back, search;
	EditText searchingBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.activity_searching);
	    
	    //�׸�����
		LinearLayout layout = (LinearLayout)findViewById(R.id.action_bar_searching);
		layout.setBackgroundResource(MainActivity.settingPref.getInt("THEME", R.color.yellow));
		EditText editText = (EditText) findViewById(R.id.searching_bar);
		editText.setBackgroundResource(MainActivity.settingPref.getInt("THEME", R.color.yellow));
		
		
	    Intent intent = getIntent();
		Bundle inputData = intent.getBundleExtra("SEARCHING_INGREDIENT");
		
		String initialText = inputData.getString("INGREDIENT");

		back = (Button) findViewById(R.id.back_button_searching);
		search = (Button) findViewById(R.id.searching_button);
	    searchingBar = (EditText) findViewById(R.id.searching_bar);
	    
	    searchingBar.setText(initialText);
	    
	    
	    back.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {				
				finish();
			}
			
		});
	    
	    search.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {	
				String addURL = "";
	            // TODO Auto-generated method stub
	            try {
	               addURL = URLEncoder.encode (searchingBar.getText().toString(), "UTF-8");
	            } catch (UnsupportedEncodingException e) {
	               // TODO Auto-generated catch block
	               e.printStackTrace();
	            }
	            String recipeSearchingURL = "http://allrecipes.kr/m/recipes/search/list?text=" 
	                                 + addURL;
				
				Bundle bundleData = new Bundle();
				bundleData.putString("URL", recipeSearchingURL);

				Intent intent = new Intent(SearchingActivity.this, WebviewActivity.class);
				intent.putExtra("SEARCHING_URL", bundleData);
				startActivity(intent);
				
				
				
			}
			
		});
	    
	    
	}

}
