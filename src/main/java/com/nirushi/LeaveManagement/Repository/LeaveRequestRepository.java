package com.nirushi.LeaveManagement.Repository;

import com.nirushi.LeaveManagement.Entity.LeaveRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeaveRequestRepository extends JpaRepository<LeaveRequest,Long> {
    List<LeaveRequest> findByStatus(String status);
    List<LeaveRequest> findByEmployeeId(Long employeeId);
}
