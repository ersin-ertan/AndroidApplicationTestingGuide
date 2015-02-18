package com.nullcognition.androidapplicationtestingguide;

import android.os.Debug;

import junit.framework.TestCase;

// android.test.suitebuilder.SmokeTestSuiteBuilder with @Smoke
// smoke tests are used for high level testing, like the build and running of the program, and more general and is for expected working components

// @FlakyTest(tolerance=4) on InstrumentationTestCase class' test methods to retry on failures
// @UIThreadTest for ITC method for ui, or use
/*	mActivity.runOnUIThread(new Runnable() {
		public void run() {
		// do somethings
		}
	});
*/

// @Suppress on class or method that should not be included in the test

// tests can also be run from the command line - by group or all, custom annotations for tests can be created
public class Chapter02 extends TestCase {

   private static final boolean DEBUG = true;

   public Chapter02(){this("Chapter02");}

   public Chapter02(String name){ super(name);}


   @Override
   protected void setUp() throws Exception{
	  super.setUp();

	  if ( DEBUG ) { // programmatic break point
		 Debug.waitForDebugger();
	  }
   }

   @Override
   protected void tearDown() throws Exception{
	  super.tearDown();
   }
}
