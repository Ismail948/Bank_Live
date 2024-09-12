package com.javawhizz.App.customer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
	
	@Autowired
	InterfaceforJPARepo repo;

	public Account createaccount(Account account) {
		Account account_saved=repo.save(account);
		return account_saved;
		
	}
	
	public List<Account> getallacc() {
		return repo.findAll();
	}

	public Account getaccbyacnum(long acc_num) {
		Optional<Account> abc= repo.findById(acc_num);
		if(abc.isEmpty()) {
			throw new RuntimeException("Account not found with this Account number");
		}
		return abc.get();
	}

	public Account deposit(long acc_num, Double amount) {
        Optional<Account> optionalAccount = repo.findById(acc_num);
        if (optionalAccount.isEmpty()) {
            throw new RuntimeException("Invalid Account Number");
        }

        Account account = optionalAccount.get();
        Double currentBalance = account.getAcc_bal();
        Double updatedBalance = currentBalance + amount;
        account.setAcc_bal(updatedBalance);

        return repo.save(account);
    }

    // Other methods like getaccbyacnum, withdraw, etc.

	public Account withdraw(long acc_num, Double amount) {
		Optional<Account> object =repo.findById(acc_num);
		if(object.isEmpty()) {
			throw new RuntimeException("Enter Valid Account Number");
		}
		Account presentbal=object.get();
		Double totalbal=presentbal.getAcc_bal()-amount;
		presentbal.setAcc_bal(totalbal);
		repo.save(presentbal);
		return presentbal;
		
	}
	public boolean deleteAccount(long accNum) {
        if (repo.existsById(accNum)) {
            repo.deleteById(accNum);
            return true;
        } else {
            return false;
        }
    }

	public void deleteacc(long acc_num) {
		Optional<Account> object =repo.findById(acc_num);
		if(object.isEmpty()) {
			throw new RuntimeException("Enter Valid Account Number");
		}
		repo.deleteById(acc_num);
	}


}
