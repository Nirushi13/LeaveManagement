package com.nirushi.LeaveManagement.Service;

import com.nirushi.LeaveManagement.Entity.LeaveRequest;
import com.nirushi.LeaveManagement.Repository.LeaveRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LeaveRequestService {

    @Autowired
    private LeaveRequestRepository leaveRequestRepository;

    public LeaveRequest createLeaveRequest(LeaveRequest leaveRequest) {
        return leaveRequestRepository.save(leaveRequest);
    }

    public LeaveRequest updateLeaveRequest(Long id, LeaveRequest leaveRequestDetails) {
        LeaveRequest leaveRequest = leaveRequestRepository.findById(id).orElseThrow(() -> new RuntimeException("Leave Request not found"));
        leaveRequest.setStatus(leaveRequestDetails.getStatus());
        leaveRequest.setReasons(leaveRequestDetails.getReasons());
        leaveRequest.setRequestDate(leaveRequestDetails.getRequestDate());
        leaveRequest.setCreateDate(leaveRequestDetails.getCreateDate());
        leaveRequest.setUpdateDate(leaveRequestDetails.getUpdateDate());
        return leaveRequestRepository.save(leaveRequest);
    }

    public void deleteLeaveRequest(Long id) {
        leaveRequestRepository.deleteById(id);
    }

    public List<LeaveRequest> getAllLeaveRequests() {
        return leaveRequestRepository.findAll();
    }

    public LeaveRequest getLeaveRequestById(Long id) {
        return leaveRequestRepository.findById(id).orElseThrow(() -> new RuntimeException("Leave Request not found"));
    }

    public List<LeaveRequest> getLeaveRequestsByStatus(String status) {
        return leaveRequestRepository.findByStatus(status);
    }

    public List<LeaveRequest> getLeaveRequestsByEmployeeId(Long employeeId) {
        return leaveRequestRepository.findByEmployeeId(employeeId);
    }
}