package com.nullcognition.androidapplicationtestingguide.Ch03Suite;

import android.os.Debug;
import android.test.suitebuilder.annotation.SmallTest;

import com.nullcognition.androidapplicationtestingguide.MainActivity;

import junit.framework.TestCase;

/**
 * Created by ersin on 25/02/15 at 8:59 PM
 */

public class MyFirstProjectTests extends TestCase {

   private static final boolean DEBUG = false;

   public MyFirstProjectTests(){
	  this("MyFirstProjectTests");
   }

   /**
	* @param name
	*/
   public MyFirstProjectTests(String name){
	  super(name);

	  if(DEBUG){
		 Debug.waitForDebugger();
	  }
   }

   /* (non-Javadoc)
 * @see junit.framework.TestCase#setUp()
 */
   protected void setUp() throws Exception{
	  super.setUp();
   }

   /* (non-Javadoc)
 * @see junit.framework.TestCase#tearDown()
 */
   protected void tearDown() throws Exception{
	  super.tearDown();
   }

   @SmallTest
   public void testSomething(){
	  fail("Not implemented yet");
   }

   @VeryImportantTest
   public void testOtherStuff(){
	  fail("Not implemented yet");
   }

   public void testShouldThrowException(){
	  try{
		 MainActivity.methodThatShouldThrowException();
		 fail("Exception was not thrown");
	  }
	  catch(Exception ex){
		 // do nothing
	  }
   }

   public void testMax(){
	  final int a = 1;
	  final int b = 2;
	  final int expected = b;
	  final int actual = Math.max(a, b);
	  assertEquals("Expection " + expected + " but was " + actual, expected, actual);
   }

}
