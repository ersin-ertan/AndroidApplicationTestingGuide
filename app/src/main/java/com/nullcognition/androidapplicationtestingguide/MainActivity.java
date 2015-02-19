package com.nullcognition.androidapplicationtestingguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.nullcognition.testlib.TestLibClass;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends ActionBarActivity {

   TestLibClass testLibClass;
   public static final boolean startCallActivity = true;
   public static final boolean writeExternalFile = true;

   @Override
   protected void onCreate(Bundle savedInstanceState){
	  super.onCreate(savedInstanceState);
	  setContentView(R.layout.activity_main);

	  testLibClass = new TestLibClass();

	  if(writeExternalFile){ writeExternalFile(); }

	  if(startCallActivity){
		 Intent intent = new Intent();
		 intent.setAction(Intent.ACTION_CALL);
		 intent.setData(Uri.parse("tel:555-5555"));
		 startActivity(intent);
	  }

   }

   private void writeExternalFile(){

	  final File dir = Environment.getExternalStorageDirectory();
	  final File file = new File(dir, "test");
	  Log.e("writeExternalFile", "file = " + file);
	  final BufferedOutputStream os;

	  try{
		 os = new BufferedOutputStream(new FileOutputStream(file));
		 os.write("This is a sample".getBytes());
		 os.close();
	  }
	  catch(FileNotFoundException e){
		 e.printStackTrace();
		 SecurityException ex = new SecurityException("Should have detected that android.permission.WRITE_EXTERNAL_STORAGE is required.");
		 String permission = android.Manifest.permission.WRITE_EXTERNAL_STORAGE;
		 android.util.Log.w("writeExternalFile", "contains " + permission + "? :" + ex.getMessage()
																					  .contains(permission));
		 throw new SecurityException("Should have detected that android.permission.WRITE_EXTERNAL_STORAGE is required.");
	  }
	  catch(IOException e){
		 e.printStackTrace();
		 throw new SecurityException("Should have detected that android.permission.WRITE_EXTERNAL_STORAGE is required.");
	  }

   }

   @Override
   public boolean onCreateOptionsMenu(Menu menu){
	  getMenuInflater().inflate(R.menu.menu_main, menu);
	  return true;
   }

   @Override
   public boolean onOptionsItemSelected(MenuItem item){
	  int id = item.getItemId();

	  if(id == R.id.action_settings){
		 Toast.makeText(this, testLibClass.getTest(), Toast.LENGTH_SHORT)
			  .show();
		 return true;
	  }

	  return super.onOptionsItemSelected(item);
   }

   public static void methodThatShouldThrowException() throws Exception{
	  throw new Exception("This is an exception");
   }
}
