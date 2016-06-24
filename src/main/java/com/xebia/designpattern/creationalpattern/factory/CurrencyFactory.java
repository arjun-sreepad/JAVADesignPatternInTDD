package com.xebia.designpattern.creationalpattern.factory;

//Factroy Class code
//Runtime this factory creates the relevant child class based on the name of input country
public class CurrencyFactory {

    public static Currency createCurrency (String country) {
    if (country. equalsIgnoreCase ("India")){
           return new Rupee();
    }else if(country. equalsIgnoreCase ("Singapore")){
           return new SGDDollar();
    }else if(country. equalsIgnoreCase ("US")){
           return new USDollar();
     }
    throw new IllegalArgumentException("No such currency");
    }
}
