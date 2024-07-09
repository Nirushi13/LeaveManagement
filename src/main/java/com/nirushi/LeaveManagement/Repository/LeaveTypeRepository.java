package com.nirushi.LeaveManagement.Repository;

import com.nirushi.LeaveManagement.Entity.LeaveType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveTypeRepository extends JpaRepository<LeaveType,Long> {
}
