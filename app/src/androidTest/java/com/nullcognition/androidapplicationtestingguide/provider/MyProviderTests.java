package com.nullcognition.androidapplicationtestingguide.provider;

import android.test.ProviderTestCase2;

import com.nullcognition.androidapplicationtestingguide.MyProvider;

/**
 * Created by ersin on 19/02/15 at 12:24 AM
 */
public class MyProviderTests extends ProviderTestCase2<MyProvider> {


   /**
	* Constructor.
	*
	* @param providerClass     The class name of the provider under test
	* @param providerAuthority The provider's authority string
	*/
   public MyProviderTests(Class<MyProvider> providerClass, String providerAuthority){
	  super(providerClass, providerAuthority);
   }
}

