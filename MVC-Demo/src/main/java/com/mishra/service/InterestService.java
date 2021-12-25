package com.mishra.service;

import com.mishra.model.InterestModel;

/*it's our service class which process the data using model
and provide result in a model*/
public class InterestService {
 public InterestModel compute(int amount, int time) {
	
	 //processing data
	 int rate=10;
	 if(time <5) {
		 rate=8;
	 }
	 int interest=(amount*time*rate)/100;
	 int netamount=amount+interest;
	 
	 //stores data in model
	 InterestModel model= new InterestModel();
	 model.setAmount(amount);
	 model.setTime(time);
	 model.setRate(rate);
	 model.setNetAmount(netamount);
	 model.setInterest(interest);
	 
	 //returning model to controller
	 return model;
 }
}
