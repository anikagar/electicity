package com.electricity.repository;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.electricity.entity.User;

@Repository
public interface ElectricityUserRepository extends JpaRepository<User, String> {

	@Query("select userId from User where rownum = 1 order by userId desc ") 
	public String getMaxId();
    
	@Query("select userId from User where username = ?1")
	public String exists(String username);
	
	@Transactional
	@Modifying
	@Query("update User set password = ?2, modifiedBy = ?3, modifiedOn = ?4 where userId = ?1")
	public void updatePassword(String userId, String password, String ModifiedBy, LocalDate modifiedOn);
	
	@Query("select password from User where userId = ?1")
	public String getPassword(String userId);
	
	@Query("select username from User")
	public List<String> fetchAllUsername();

}
