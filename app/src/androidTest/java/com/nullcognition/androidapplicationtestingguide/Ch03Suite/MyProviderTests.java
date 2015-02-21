package com.nullcognition.androidapplicationtestingguide.Ch03Suite;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.test.ProviderTestCase2;
import android.test.suitebuilder.annotation.Suppress;

import com.nullcognition.androidapplicationtestingguide.MyProvider;

/**
 * Created by ersin on 19/02/15 at 12:24 AM
 */
public class MyProviderTests extends ProviderTestCase2<MyProvider> {

   private MyProvider myProvider;

   public MyProviderTests(){this("MyProvider");}

   public MyProviderTests(Class<MyProvider> providerClass, String providerAuthority){
	  super(providerClass, providerAuthority);

   }

   public MyProviderTests(String name){
	  super(MyProvider.class, MyProvider.authority);
	  setName(name);
   }

   protected void setUp() throws Exception{
	  super.setUp();

	  setContext(getMockContext());
	  myProvider = getProvider();
   }

   protected void tearDown() throws Exception{
	  super.tearDown();
   }

   public void testQuery(){
	  Uri uri = Uri.withAppendedPath(MyProvider.contentUri, "dummy");
	  final Cursor c = myProvider.query(uri, null, null, null, null);
	  final int expected = 2;
	  final int actual = c.getCount();
	  assertEquals(expected, actual);
   }

   @Suppress
   public void testInsertUsingContentResolver(){
	  final ContentValues values = new ContentValues();

	  values.put("_id", 3);
	  values.put("name", "Pluto");

	  final Uri newUri = getMockContentResolver().insert(Uri.withAppendedPath(MyProvider.contentUri, "dummy"), values);
	  assertNotNull(newUri);
   }

}

