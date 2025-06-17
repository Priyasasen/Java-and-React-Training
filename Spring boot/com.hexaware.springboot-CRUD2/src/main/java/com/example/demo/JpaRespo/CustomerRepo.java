package com.example.demo.JpaRespo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Customer;

import jakarta.transaction.Transactional;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer>{

	//@Query("select c from Customer c")
	@Query(value="select * from Customer",nativeQuery= true)
	List<Customer> findAllCustomer();
	
	//@Query("select c from Customer c where c.actno=?")
	@Query(value="select * from Customer where actno=:actno",nativeQuery= true)
	public Customer	findByActJPQL(@Param("actno") int actno);
	
	
	//@Query("SELECT c FROM Customer c WHERE c.name = :name")
	  @Query(value = "SELECT * FROM customer WHERE name = :name", nativeQuery = true)
	Customer findByNameJPQL(@Param("name") String name);
	
	@Modifying
	@Transactional
	//@Query("update Customer c set c.balance = c.balance + :amt where c.actno = :actno")

    @Query(value = "UPDATE customer SET balance = balance + :amt WHERE actno = :actno", nativeQuery = true)
	int deposit1(@Param("actno") int actno, @Param("amt") double amt);
	
	@Transactional
	@Modifying
	@Query(value = "UPDATE customer SET balance = balance - :amt WHERE actno = :actno AND (balance - :amt) >= 1000", nativeQuery = true)
	//@Query("update Customer c set c.balance=c.balance - :amt  where c.actno=:actno and c.balance -:amt >=1000")
	public int withdraw(@Param("actno") int actno, @Param("amt")double amt);
	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM customer WHERE actno = :actno", nativeQuery = true)
	//@Query("DELETE FROM Customer c WHERE c.actno = :actno")
	int deleteByActno(@Param("actno") int actno);

	
}



