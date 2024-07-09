package com.nirushi.LeaveManagement.Service;

import com.nirushi.LeaveManagement.Entity.LeaveType;
import com.nirushi.LeaveManagement.Repository.LeaveTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveTypeService {

    @Autowired
    private LeaveTypeRepository leaveTypeRepository;

    public LeaveType createLeaveType(LeaveType leaveType){
        return leaveTypeRepository.save(leaveType);
    }

    public LeaveType updateLeaveType(Long id,LeaveType leaveTypeDetails){
        LeaveType leaveType=leaveTypeRepository.findById(id).orElseThrow(()->new RuntimeException("LeaveType Not Found"));
        leaveType.setTypeName(leaveTypeDetails.getTypeName());
        leaveType.setDescription(leaveTypeDetails.getDescription());
        leaveType.setAfterYearLeave(leaveTypeDetails.getAfterYearLeave());
        return leaveTypeRepository.save(leaveType);
    }

    public void deleteLeaveType(Long id) {
        leaveTypeRepository.deleteById(id);
    }

    public List<LeaveType> getAllLeaveTypes() {
        return leaveTypeRepository.findAll();
    }

    public LeaveType getLeaveTypeById(Long id) {
        return leaveTypeRepository.findById(id).orElseThrow(() -> new RuntimeException("Leave Type not found"));
    }
}
