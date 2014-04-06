package com.kure.musicplayer.activities;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.kure.musicplayer.MainActivity;
import com.kure.musicplayer.R;
import com.kure.musicplayer.kMP;

/**
 * Direct sub menu for the Main Menu, showing other
 * sub menus related to Music, such as "Artists", "Albums"
 * and "All Songs".
 * 
 */
public class MusicMenuActivity extends Activity
	implements OnItemClickListener {

	/**
	 * All the possible items the user can select on this menu.
	 * 
	 * Will be initialized with default values on `onCreate`.
	 */
	public static ArrayList<String> items = new ArrayList<String>();

	/**
	 * List that will be populated with all the items.
	 * 
	 * Look for it inside the res/layout xml files.
	 */
	ListView listView;
	
	/**
	 * Called when the activity is created for the first time.
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_menu);
	
		// Adding all possible items on the menu.
		items.add(getString(R.string.menu_music_playlists));
		items.add(getString(R.string.menu_music_artists));		
		items.add(getString(R.string.menu_music_albums));
		items.add(getString(R.string.menu_music_genres));
		items.add(getString(R.string.menu_music_songs));
		
		// List to be populated with items
		listView = (ListView)findViewById(R.id.activity_main_menu_list);
		
		// Adapter that will convert from Strings to List Items
		final ArrayAdapter<String> adapter = new ArrayAdapter<String>
				(this, android.R.layout.simple_list_item_1, items);
		
		// Filling teh list with all the items
		listView.setAdapter(adapter);
		
		listView.setOnItemClickListener(this);
	}

	/**
	 * Will react to the user selecting an item.
	 */
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

		// We can only handle the user choice from now on
		// if we've successfuly scanned the songs from the
		// device.
		if (! kMP.songs.isInitialized())
			return;
		
		// Gets the string value of the current item and
		// compares to all possible items.
		String currentItem = listView.getItemAtPosition(position).toString();
		
		if (currentItem == getString(R.string.menu_music_playlists)) {
			
		}
		else if (currentItem == getString(R.string.menu_music_artists)) {
			
		}
		else if (currentItem == getString(R.string.menu_music_albums)) {
			
		}		
		else if (currentItem == getString(R.string.menu_music_songs)) {
			startActivity(new Intent(this, MainActivity.class));
		}
		else if (currentItem == getString(R.string.menu_music_genres)) {
			
		}
		else {
			
		}
	}
	
	/**
	 * When destroying the Activity.
	 */
	@Override
	protected void onDestroy() {
		super.onDestroy();
		
		// Need to clear all the items otherwise
		// they'll keep adding up.
		items.clear();
	}
}
