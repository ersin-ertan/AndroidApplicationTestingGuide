package com.nullcognition.androidapplicationtestingguide.chapter04.fixture;

import com.nullcognition.androidapplicationtestingguide.chapter04.TemperatureConverter;

/**
 * Created by ersin on 02/03/15 at 1:17 AM
 */
public class TemperatureConverterCelsiusToFahrenheitFixture {

   private double celsius;

   public void setCelsius(double celsius){

	  this.celsius = celsius;
   }

   public String fahrenheit() throws Exception {

	  try {
		 return String.valueOf(TemperatureConverter.celsiusToFahrenheit(celsius));
	  }
	  catch (RuntimeException e) {
		 return e.getLocalizedMessage();
	  }

   }

}
