package com.electricity.repository;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.electricity.entity.Complaint;

@Repository
public interface ElectricityComplaintRepository extends JpaRepository<Complaint, Long> {
    
	@Query("select c from Complaint c where c.complaintStatus in ('NEW','IN PROGRESS')")
	public List<Complaint> fetchAllRecord();
	
	@Transactional
	@Modifying
	@Query("update Complaint set complaintReply=?2, complaintStatus=?3, modifiedBy=?4, modifiedOn=?5 where complaintId=?1")
	public int updateComplaintFromAdmin(Long complaintId, String complaintReply, String complaintStatus, String modifiedBy, LocalDate modifiedOn);
	
	@Query("select c from Complaint c where c.complaintStatus = 'RESOLVED' and c.username = ?1")
	public List<Complaint> fetchResolvedRecord(String username);
	
	@Transactional
	@Modifying
	@Query("update Complaint set complaintDesc=?2, complaintStatus=?3, modifiedBy=?4, modifiedOn=?5 where complaintId=?1")
	public int updateComplaintFromUser(Long complaintId, String complaintDesc, String complaintStatus, String modifiedBy, LocalDate modifiedOn);
}
