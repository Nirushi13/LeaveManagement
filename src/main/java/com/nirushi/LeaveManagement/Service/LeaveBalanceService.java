package com.nirushi.LeaveManagement.Service;

import com.nirushi.LeaveManagement.Entity.LeaveBalance;
import com.nirushi.LeaveManagement.Repository.LeaveBalanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveBalanceService {
    @Autowired
    private LeaveBalanceRepository leaveBalanceRepository;

    public List<LeaveBalance> getLeaveBalanceByEmployeeId(Long employeeId) {
        return leaveBalanceRepository.findByEmployeeId(employeeId);
    }
}
