package com.expenseTracker.Service;

import java.util.List;

import com.expenseTracker.Entity.Payment_Mode;

public interface PaymentModeService 
{
	Payment_Mode addPaymentMode(Payment_Mode paymentMode);
	
	Payment_Mode updatePaymentMode(long id,Payment_Mode paymentMode);
	
	void deletePaymentMode(long id);
	
	Payment_Mode getPaymentModeById(long id);
	
	List<Payment_Mode> getAllPaymentModes();
	
}
