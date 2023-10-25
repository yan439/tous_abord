package fr.isika.cda.projet3.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import paypal.PaypalResult;


@ManagedBean(name="PaypalController")
@SessionScoped
public class PaypalController {
	
	private PaypalResult result = new PaypalResult();
	
	public PaypalResult getResult() {
		return result;
		
	}
	
}
