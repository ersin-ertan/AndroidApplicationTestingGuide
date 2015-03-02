package com.nullcognition.androidapplicationtestingguide;

import android.test.AndroidTestCase;

// import static android.test.ViewAsserts.assertRightAligned;

// Building blocks of the android sdk

public class Chapter03 extends AndroidTestCase {



   public Chapter03(){}

   public void testSame(){ // is the reference the same, =

	  class S {}

	  S s = new S();
	  S ss = s;

	  assertSame("with a custom message", s, ss);
   }

   public void testAligned(){

	  //assertRightAligned(new View(),new View() , 0);

	  // we can test alignment and positioning
   }

//   public void testUserInterfaceLayout(){
//	  final int margin = 0;
//	  final View origin = mActivity.getWindow()
//								   .getDecorView();
//	  assertOnScreen(origin, mMessage);
//	  assertOnScreen(origin, mCapitalize);
//	  assertRightAligned(mMessage, mCapitalize, margin);
//   }


   // we can assert empty, hashcode, regex, order and more
   // http://developer.android.com/reference/android/test/ViewAsserts.html

   // for regex http://developer.android.com/reference/java/util/regex/package-summary.html

   public void testTouchUtis(){

	  // no need for @UIThreadTest because testtouchuils injects to the right ui thread
	  /*
		  	mListView.scrollTo(0, 0);
			TouchUtils.dragQuarterScreenUp(this, mActivity);
			TouchUtils.dragQuarterScreenUp(this, mActivity);
			TouchUtils.dragQuarterScreenUp(this, mActivity);
			TouchUtils.tapView(this, mListView);




			final int expectedItemPosition = 6;
			final int actualItemPosition = mListView.getFirstVisiblePosition();
			assertEquals("Wrong position",expectedItemPosition, actualItemPosition);
			final String expected = "Anguilla";
			final String actual = mListView.getAdapter().getItem(expectedItemPosition).toString();
			assertEquals("Wrong content", actual, expected);
	   */
   }




























}
