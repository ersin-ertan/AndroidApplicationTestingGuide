package com.nullcognition.androidapplicationtestingguide.chapter04;

import android.content.Context;
import android.text.InputFilter;
import android.text.method.DigitsKeyListener;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.EditText;

/**
 * Created by ersin on 02/03/15 at 1:27 AM
 */
public class EditNumber extends EditText {

   private static final String DEFAULT_FORMAT = "%.2f";

   public EditNumber(Context context){
	  super(context);
	  init();
   }

   public EditNumber(Context context, AttributeSet attrs){
	  super(context, attrs);
	  init();
   }

   public EditNumber(Context context, AttributeSet attrs, int defStyle){
	  super(context, attrs, defStyle);
	  init();
   }

   private void init(){
	  // DigistKeyListener.getInstance(true, true) returns an
	  // instance that accepts digits, sign and decimal point
	  final InputFilter[] filters = new InputFilter[]{DigitsKeyListener.getInstance(true, true)};
	  setFilters(filters);
   }

   public void clear(){
	  setText("");
   }

   public void setNumber(double f){
	  super.setText(String.format(DEFAULT_FORMAT, f));
   }

   public double getNumber(){
	  Log.d("EditNumber", "getNumber() returning value of '" + getText().toString() + "'");
	  return Double.valueOf(getText().toString());
   }

}
