package com.expenseTracker.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expenseTracker.Entity.Payment_Mode;
import com.expenseTracker.Service.PaymentModeService;

@RestController
@RequestMapping("/api/paymentMode")
public class PaymentModeController 
{
	@Autowired
	private  PaymentModeService paymentService;
	
	@PostMapping("/addPaymentMode")
	public ResponseEntity<?> addPaymentMode(@RequestBody Payment_Mode paymentMode)
	{
		Payment_Mode addPaymentMode = paymentService.addPaymentMode(paymentMode);
		
		return ResponseEntity.status(HttpStatus.OK).body(addPaymentMode);
	}
	
	@PutMapping("/updatePaymentMode/{id}")
	public ResponseEntity<?> updatePaymentMode(@PathVariable long id,@RequestBody Payment_Mode paymentMode)
	{
		Payment_Mode updatedPaymentMode = paymentService.updatePaymentMode(id, paymentMode);
		
		return ResponseEntity.status(HttpStatus.OK).body(updatedPaymentMode);
	}
	
	@DeleteMapping("/deletePaymentMode/{id}")
	public ResponseEntity<?> deletePaymentMode(@PathVariable long id)
	{
		paymentService.deletePaymentMode(id);
		
		return ResponseEntity.status(HttpStatus.OK).body("Payment Mode Deleted Successfully");
	}
	
	@GetMapping("/getPaymentModeById/{id}")
	public ResponseEntity<?> getPaymentModeById(@PathVariable long id)
	{
		Payment_Mode paymentModeById = paymentService.getPaymentModeById(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(paymentModeById);
	}
	
	@GetMapping("/getAllPaymentModes")
	public ResponseEntity<?> getAllPaymentModes()
	{
		List<Payment_Mode> allPaymentModes = paymentService.getAllPaymentModes();
		
		return ResponseEntity.status(HttpStatus.OK).body(allPaymentModes);
	}
}
