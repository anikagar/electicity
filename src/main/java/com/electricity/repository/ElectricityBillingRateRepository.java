package com.electricity.repository;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.electricity.entity.BillingRateDetail;

@Repository
public interface ElectricityBillingRateRepository extends JpaRepository<BillingRateDetail, Long>{
	
	  @Query("select brd from BillingRateDetail brd")
      public List<BillingRateDetail> fetchBillingRateDetails();
	  
	  @Query("select brd.billingRateDetailId from BillingRateDetail brd where brd.currentInd = 'Y'")
	  public List<Long> fetchLatestBillingRateDetailId();
	  
	  @Transactional
	  @Modifying
	  @Query("update BillingRateDetail set currentInd = ?2, modifiedBy = ?3, modifiedOn = ?4 where billingRateDetailId = ?1")
	  public void updateEffectiveEndDate(Long billingRateDetailId, String currentInd, String modifiedBy, LocalDate modifiedOn);
	  
	  @Query("select pricePerUnit from BillingRateDetail where currentInd = 'Y'")
	  public double fetchPerUnitPrice();
	  
	  @Query("select dueDays from BillingRateDetail where currentInd = 'Y'")
	  public Long fetchDueDays();
}
