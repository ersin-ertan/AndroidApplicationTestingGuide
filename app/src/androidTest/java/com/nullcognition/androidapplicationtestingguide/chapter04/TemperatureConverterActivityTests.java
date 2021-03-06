package com.nullcognition.androidapplicationtestingguide.chapter04;

import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nullcognition.androidapplicationtestingguide.R;


/**
 * Created by ersin on 02/03/15 at 2:03 AM
 */

// ** chapter04 not working **

public class TemperatureConverterActivityTests extends ActivityInstrumentationTestCase2<TemperatureConverterActivity> {

   private TemperatureConverterActivity mActivity;
   private EditNumber                   mCelsius;
   private EditNumber                   mFahrenheit;
   private TextView                     mCelsiusLabel;
   private TextView                     mFahrenheitLabel;

   public TemperatureConverterActivityTests(){
	  this("TemperatureConverterActivityTests");
   }

   public TemperatureConverterActivityTests(String name){
	  super(TemperatureConverterActivity.class);
	  setName(name);
   }

   protected void setUp() throws Exception{
	  super.setUp();
	  mActivity = getActivity();
	  mCelsiusLabel = (TextView)mActivity.findViewById(R.id.celsius_label);
	  mCelsius = (EditNumber)mActivity.findViewById(R.id.celsius);
	  mFahrenheitLabel = (TextView)mActivity.findViewById(R.id.fahrenheit_label);
	  mFahrenheit = (EditNumber)mActivity.findViewById(R.id.fahrenheit);
   }

   protected void tearDown() throws Exception{
	  super.tearDown();
   }

//	public final void testOnCreateBundle() {
//		fail("Not yet implemented");
//	}

   public final void testPreconditions(){
	  assertNotNull(mActivity);
   }

   public final void testHasInputFields(){
	  assertNotNull(mCelsius);
	  assertNotNull(mFahrenheit);
   }

   public final void testFieldsShouldStartEmpty(){
	  assertEquals("", mCelsius.getText()
							   .toString());
	  assertEquals("", mFahrenheit.getText()
								  .toString());
   }

   public final void testFieldsOnScreen(){
	  final Window window = mActivity.getWindow();
	  final View origin = window.getDecorView();
//	  assertOnScreen(origin, mCelsius);
//	  assertOnScreen(origin, mFahrenheit);
   }

   public final void testAlignment(){
//	  assertLeftAligned(mCelsiusLabel, mCelsius);
//	  assertLeftAligned(mFahrenheitLabel, mFahrenheit);
//	  assertLeftAligned(mCelsius, mFahrenheit);
//	  assertRightAligned(mCelsius, mFahrenheit);
   }

   public final void testCelsiusInputFieldCoverEntireScreen(){
	  final int expected = ViewGroup.LayoutParams.MATCH_PARENT;
	  final ViewGroup.LayoutParams lp = mCelsius.getLayoutParams();
	  assertEquals("mCelsius layout width is not MATCH_PARENT", expected, lp.width);
   }

   public final void testFahrenheitInputFieldCoverEntireScreen(){
	  final int expected = ViewGroup.LayoutParams.MATCH_PARENT;
	  final ViewGroup.LayoutParams lp = mFahrenheit.getLayoutParams();
	  assertEquals("mFahrenheit layout width is not MATCH_PARENT", expected, lp.width);
   }

   public final void testFontSizes(){
	  final float expected = 24.0f;
	  assertEquals(expected, mCelsiusLabel.getTextSize());
	  assertEquals(expected, mFahrenheitLabel.getTextSize());
   }


   public final void testMargins(){
	  LinearLayout.LayoutParams lp;
	  final int expected = 6;
	  lp = (LinearLayout.LayoutParams)mCelsius.getLayoutParams();
	  assertEquals(expected, lp.leftMargin);
	  assertEquals(expected, lp.rightMargin);
	  lp = (LinearLayout.LayoutParams)mFahrenheit.getLayoutParams();
	  assertEquals(expected, lp.leftMargin);
	  assertEquals(expected, lp.rightMargin);
   }

   public final void testJustification(){
	  final int expected = Gravity.RIGHT | Gravity.CENTER_VERTICAL;
	  int actual = mCelsius.getGravity();
	  assertEquals(String.format("Expected 0x%02x but was 0x%02x", expected, actual), expected, actual);
	  actual = mFahrenheit.getGravity();
	  assertEquals(String.format("Expected 0x%02x but was 0x%02x", expected, actual), expected, actual);
   }

   public final void testVirtualKeyboardSpaceReserved(){
	  final int expected = 280;
	  final int actual = mFahrenheit.getBottom();
	  assertTrue(actual <= expected);
   }

   @UiThreadTest
   public final void testFahrenheitToCelsiusConversion(){
	  mCelsius.clear();
	  mFahrenheit.clear();

	  final double f = 32.5;
	  mFahrenheit.requestFocus();
	  mFahrenheit.setNumber(f);
	  mCelsius.requestFocus();
	  final double expectedC = TemperatureConverter.fahrenheitToCelsius(f);
	  final double actualC = mCelsius.getNumber();
	  final double delta = Math.abs(expectedC - actualC);
	  final String msg = "" + f + "F -> " + expectedC + "C but was " + actualC + "C (delta " + delta + ")";

	  assertTrue(msg, delta < 0.005);
   }

   public void testInputFilter() throws Throwable{
	  runTestOnUiThread(new Runnable() {

		 @Override
		 public void run(){
			mCelsius.requestFocus();
		 }
	  });

	  final Double n = - 1.234d;
	  sendKeys("MINUS 1 PERIOD 2 PERIOD 3 PERIOD 4");
	  Object nr = null;
	  try{
		 nr = mCelsius.getNumber();
	  }
	  catch(NumberFormatException e){
		 nr = mCelsius.getText();
	  }

	  final String msg = "-1.2.3.4 should be filtered to " + n +
						 " but is " + nr;
	  assertEquals(msg, n, nr);
   }
}
