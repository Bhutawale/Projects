package com.expenseTracker.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expenseTracker.CustomException.ResourceNotFoundException;
import com.expenseTracker.Dao.Payment_ModeDao;
import com.expenseTracker.Entity.Payment_Mode;

@Service
public class PaymentModeServiceImpl implements PaymentModeService
{
	@Autowired
	private Payment_ModeDao paymentDao;
	
	public Payment_Mode addPaymentMode(Payment_Mode paymentMode) 
	{
		Payment_Mode addPaymentMode = paymentDao.save(paymentMode);
		
		return addPaymentMode;
	}


	public Payment_Mode updatePaymentMode(long id, Payment_Mode paymentMode) 
	{
		Payment_Mode existingPaymentMode = paymentDao.findById(id)
			.orElseThrow(()->new ResourceNotFoundException("Payment Mode Not Found"));
			
		existingPaymentMode.setType(paymentMode.getType());
		
		Payment_Mode updatedPaymentMode = paymentDao.save(existingPaymentMode);
		
		return updatedPaymentMode;
	}

	public void deletePaymentMode(long id) 
	{
		Payment_Mode paymentMode = paymentDao.findById(id)
					.orElseThrow(()->new ResourceNotFoundException("Payment Mode not found"));
		
		paymentDao.delete(paymentMode);
	}

	public Payment_Mode getPaymentModeById(long id) 
	{
		Payment_Mode paymentModeById = paymentDao.findById(id)
			.orElseThrow(()->new ResourceNotFoundException("Payment Mode not Found"));
		
		return paymentModeById;
	}


	public List<Payment_Mode> getAllPaymentModes()
	{
		List<Payment_Mode> allPaymentModes = paymentDao.findAll();
		
		return allPaymentModes;
	}
	
}
