package com.nullcognition.androidapplicationtestingguide.chapter04;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import com.nullcognition.androidapplicationtestingguide.R;

/**
 * Created by ersin on 02/03/15 at 1:32 AM
 */


public class TemperatureConverterActivity extends Activity {

   /**
	* Changes fields values when text changes applying the corresponding method.
	*/
   public class TemperatureChangedWatcher implements TextWatcher {

	  private final EditNumber              mSource;
	  private final EditNumber              mDest;
	  private       TemperatureConverter.OP mOp;

	  public TemperatureChangedWatcher(TemperatureConverter.OP op){
		 if(op == TemperatureConverter.OP.C2F){
			this.mSource = mCelsius;
			this.mDest = mFahrenheit;
		 }
		 else{
			this.mSource = mFahrenheit;
			this.mDest = mCelsius;
		 }
		 this.mOp = op;
	  }

	  /* (non-Javadoc)
	 * @see android.text.TextWatcher#afterTextChanged(android.text.Editable)
	 */
	  public void afterTextChanged(Editable s){
		 // TODO Auto-generated method stub

	  }

	  /* (non-Javadoc)
	 * @see android.text.TextWatcher#beforeTextChanged(java.lang.CharSequence, int, int, int)
	 */
	  public void beforeTextChanged(CharSequence s, int start, int count, int after){
		 // TODO Auto-generated method stub

	  }

	  /* (non-Javadoc)
	 * @see android.text.TextWatcher#onTextChanged(java.lang.CharSequence, int, int, int)
	 */
	  public void onTextChanged(CharSequence s, int start, int before, int count){
		 if(! mDest.hasWindowFocus() || mDest.hasFocus() || s == null){
			return;
		 }

		 final String str = s.toString();
		 if("".equals(str)){
			mDest.setText("");
			return;
		 }

		 try{
			final double temp = Double.parseDouble(str);
			final double result = (mOp == TemperatureConverter.OP.C2F) ? TemperatureConverter.celsiusToFahrenheit(temp) : TemperatureConverter.fahrenheitToCelsius(temp);
			final String resultString = String.format("%.2f", result);
			mDest.setNumber(result);
			mDest.setSelection(resultString.length());
		 }
		 catch(NumberFormatException e){
			// WARNING
			// this is generated while a number is entered,
			// for example just a '-'
			// so we don't want to show the error
		 }
		 catch(Exception e){
			mSource.setError("ERROR: " + e.getLocalizedMessage());
		 }
	  }

   }

   private EditNumber mCelsius;
   private EditNumber mFahrenheit;

   /**
	* Called when the activity is first created.
	*/
   @Override
   public void onCreate(Bundle savedInstanceState){
	  super.onCreate(savedInstanceState);
	  setContentView(R.layout.main);

	  mCelsius = (EditNumber)findViewById(R.id.celsius);
	  mFahrenheit = (EditNumber)findViewById(R.id.fahrenheit);

	  mCelsius.addTextChangedListener(new TemperatureChangedWatcher(TemperatureConverter.OP.C2F));
	  mFahrenheit.addTextChangedListener(new TemperatureChangedWatcher(TemperatureConverter.OP.F2C));
   }

}
