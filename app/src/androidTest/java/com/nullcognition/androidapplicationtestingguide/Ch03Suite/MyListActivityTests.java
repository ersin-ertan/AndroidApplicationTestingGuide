package com.nullcognition.androidapplicationtestingguide.Ch03Suite;

import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.widget.ListView;

import com.nullcognition.androidapplicationtestingguide.MyListActivity;

/**
 * Created by ersin on 20/02/15 at 8:27 PM
 */
public class MyListActivityTests extends ActivityInstrumentationTestCase2<MyListActivity> {

   private MyListActivity mActivity;
   private ListView       mListView;

   public MyListActivityTests(){
	  this("MyListActivityTests");
   }

   public MyListActivityTests(String name){
	  super(MyListActivity.class);
	  setName(name);
   }

   protected void setUp() throws Exception{
	  super.setUp();

	  mActivity = getActivity();
	  mListView = mActivity.getListView();
   }

   protected void tearDown() throws Exception{
	  super.tearDown();
   }

   public void testListScrolling(){
	  mListView.scrollTo(0, 0);
	  TouchUtils.dragQuarterScreenUp(this, mActivity);
	  TouchUtils.dragQuarterScreenUp(this, mActivity); // scroll is unfountenetly non-deterministic because of (see below)...
	  TouchUtils.tapView(this, mListView);

	  final int expectedItemPosition = 9; // 7,8,9...
	  final int actualItemPosition = mListView.getFirstVisiblePosition();
	  assertEquals("Wrong position", expectedItemPosition, actualItemPosition); // wrong position, could be because screen size, style on tabs, etc.

	  final String expected = "Argentina";
	  final String actual = mListView.getAdapter()
									 .getItem(expectedItemPosition)
									 .toString();
	  assertEquals("Wrong content", actual, expected);
   }
}
