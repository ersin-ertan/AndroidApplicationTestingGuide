package com.nullcognition.androidapplicationtestingguide;

import junit.framework.TestCase;

/**
 * Created by ersin on 14/02/15 at 11:03 PM
 */

// this class is a fixture, any public void methods prefixed with test will be run

// @LargeTest, small, medium can be used to group tests to be run by the test runner
   // test for right and wrong values

   // assert with assertEquals(), assertFalse(), assertNotNull(), assertNotSame(), assertNull()
// assertSame(), assertTrue(), fail() and the android extended MoreAsserts and ViewAsserts

   // Mock objects to mimc objects for isolated functionality tests, android.test.mock
   // MockApplication, MockContentProvider, MockContentResolver, MockContext, MockCursor,
   // MockDialogInterface, MockPackageManager, MockResources where every method generates
   // UnsupportedOperationException, extend to cerate real mock objects

   // UI tests - special annotation @UIThreadTest via Activity.runOnUiThread(Runnable r)
   // TouchUtils to generate events to send to views like, click, drag, long click, scroll, tap, touch

   // types of tests: integration, acceptance, behaviour driven, performance, system, instrumentation

   /* Using the android.test.InstrumentationTestRunner

<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
	package="com.example.aatg.sample.test" // and the package name suffix
	android:versionCode="1" android:versionName="1.0">

		<application android:icon="@drawable/icon"
		android:label="@string/app_name">

		<uses-library android:name="android.test.runner" /> // note this

		</application>

		<uses-sdk android:minSdkVersion="7" />

		<instrumentation
			android:targetPackage="com.example.aatg.sample"
			android:name="android.test.InstrumentationTestRunner"
			android:label="Sample Tests" />

		<uses-permission android:name="android.permission.INJECT_EVENTS" /> // and this permission

</manifest>
   * */

public class MyUnitTests extends TestCase{

   private int i;

   public MyUnitTests(String string){

	  super(string);
   }

   // setup occurs before every test

   protected  void setUp() throws Exception{
	  super.setUp();
	  i = 9;
   }

   // called as a finalization, to release resources, called after every test
   // entire tree of test instances are built in the first pass and executed on second,
   // the test runner has strong references to all tests, so gc does not occur until the end
   // of all the tests running, the device may be out of memory if not torn down correctly,
   // causing sub sequent tests to fail

   protected  void tearDown() throws Exception{

   super.tearDown();
   }

   // grouped preconditions, for organization not for ordering(will not run first)

   public void testPreConditions(){}

   public void testSomeThing(){

	  fail("not implemented yet");
   }

}
