package com.nirushi.LeaveManagement.Controller;

import com.nirushi.LeaveManagement.Entity.LeaveBalance;
import com.nirushi.LeaveManagement.Service.LeaveBalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/leave-balance")
public class LeaveBalanceController {

    @Autowired
    private LeaveBalanceService leaveBalanceService;

    @GetMapping
    public ResponseEntity<List<LeaveBalance>> getLeaveBalanceByEmployeeId(@RequestParam Long employeeId) {
        List<LeaveBalance> leaveBalances = leaveBalanceService.getLeaveBalanceByEmployeeId(employeeId);
        return ResponseEntity.ok(leaveBalances);
    }
}