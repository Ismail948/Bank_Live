package com.javawhizz.App.customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InterfaceforJPARepo extends JpaRepository<Account,Long>{//Account is Entity and Long is the datatype of Primary key

}
