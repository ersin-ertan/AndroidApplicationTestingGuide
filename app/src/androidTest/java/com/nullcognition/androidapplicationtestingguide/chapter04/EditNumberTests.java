package com.nullcognition.androidapplicationtestingguide.chapter04;

import android.test.AndroidTestCase;

/**
 * Created by ersin on 02/03/15 at 1:19 AM
 */
public class EditNumberTests extends AndroidTestCase {

   private EditNumber editNumber;

   public EditNumberTests(){
	  this("EditNumberTests");
   }

   public EditNumberTests(String name){
	  setName(name);
   }

   protected void setUp() throws Exception{
	  super.setUp();

	  editNumber = new EditNumber(getContext());
	  editNumber.setFocusable(true);
   }

   protected void tearDown() throws Exception{
	  super.tearDown();
   }

   public final void testEditNumberContext(){
	  assertNotNull(editNumber);
   }

   public final void testClear(){
	  final String value = "123.45";
	  editNumber.setText(value);
	  editNumber.clear();
	  String expectedString = "";
	  String actualString = editNumber.getText()
									   .toString();
	  assertEquals(expectedString, actualString);
   }

   public final void testSetNumber(){
	  editNumber.setNumber(123.45);
	  final String expected = "123.45";
	  final String actual = editNumber.getText()
									   .toString();
	  assertEquals(expected, actual);
   }

   public final void testGetNumber(){
	  editNumber.setNumber(123.45);
	  final double expected = 123.45;
	  final double actual = editNumber.getNumber();
	  assertEquals(expected, actual);
   }


}
