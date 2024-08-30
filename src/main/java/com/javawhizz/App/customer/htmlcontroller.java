package com.javawhizz.App.customer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

@Controller
public class htmlcontroller {

	@Autowired
	AccountService accountservice;
	
	@GetMapping("/")
	public String frontpage() {
		return "front.html";
	}
	 @GetMapping("/createAcc")
	    public String createAcc() {
			return "createAcc";
	    }
	 
	 @GetMapping("/getaccnum/{acc_num}")
	    public String accdetails(@PathVariable long acc_num, Model model) {
	        Account acctail = accountservice.getaccbyacnum(acc_num);
	        model.addAttribute("acctail", acctail);
	        return "accdetail"; 
	    }
	 @GetMapping("/delete")
	    public String accdelete() {
	        return "deleteAcc"; 
	    }
	 @DeleteMapping("/delete/{acc_num}")
	    public ResponseEntity<Void> deleteAccount(@PathVariable long acc_num) {
	        boolean isDeleted = accountservice.deleteAccount(acc_num);
	        if (isDeleted) {
	            return ResponseEntity.ok().build();
	        } else {
	            return ResponseEntity.status(404).build();
	        }
	    }
	@GetMapping("/accdetails/delete/{acc_num}")
	public String deletedSuccesfully() {
		return "front";
	}
	@GetMapping("/getaccnum")
	public String getaccnum() {
		return "getaccnum.html";
	}
	
	  @GetMapping("/getaccnum/deposited/{acc_num}/{amount}")
	    public String deposit(@PathVariable long acc_num, @PathVariable Double amount,Model model) {
		 Account acctail = accountservice.deposit(acc_num,amount);
		 model.addAttribute("acctail", acctail);
	     return "redirect:/getaccnum"+"/"+acc_num; 
	}
	  
	  @GetMapping("/getaccnum/withdrawn/{acc_num}/{amount}")
	    public String withdraw(@PathVariable long acc_num, @PathVariable Double amount,Model model) {
		 Account acctail = accountservice.withdraw(acc_num,amount);
		 model.addAttribute("acctail", acctail);
		 return "redirect:/getaccnum"+"/"+acc_num; 
	}
	  @PostMapping("/createAccount")
	    public String createAccount(@ModelAttribute Account request) {
	        accountservice.createaccount(request);
	        return "redirect:/createAcc/successful/" + request.getAcc_num();
	    }

	    @GetMapping("/createAcc/successful/{acc_num}")
	    public String abcd(@PathVariable long acc_num, Model model) {
	        Account account = accountservice.getaccbyacnum(acc_num);
	        model.addAttribute("acctail", account);
	        return "sucacc.html";
	    }
	  
	
}
