package com.nirushi.LeaveManagement.Repository;

import com.nirushi.LeaveManagement.Entity.LeaveBalance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeaveBalanceRepository extends JpaRepository<LeaveBalance,Long> {
    List<LeaveBalance> findByEmployeeId(Long employeeId);
}
