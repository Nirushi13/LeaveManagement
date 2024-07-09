package com.nirushi.LeaveManagement.Controller;

import com.nirushi.LeaveManagement.Entity.LeaveType;
import com.nirushi.LeaveManagement.Service.LeaveTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leave-types")
public class LeaveTypeController {

    @Autowired
    private LeaveTypeService leaveTypeService;

    @PostMapping
    public ResponseEntity<LeaveType> createLeaveType(@RequestBody LeaveType leaveType) {
        LeaveType newLeaveType = leaveTypeService.createLeaveType(leaveType);
        return ResponseEntity.status(201).body(newLeaveType);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LeaveType> updateLeaveType(@PathVariable Long id, @RequestBody LeaveType leaveTypeDetails) {
        LeaveType updatedLeaveType = leaveTypeService.updateLeaveType(id, leaveTypeDetails);
        return ResponseEntity.ok(updatedLeaveType);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLeaveType(@PathVariable Long id) {
        leaveTypeService.deleteLeaveType(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<LeaveType>> getAllLeaveTypes() {
        List<LeaveType> leaveTypes = leaveTypeService.getAllLeaveTypes();
        return ResponseEntity.ok(leaveTypes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LeaveType> getLeaveTypeById(@PathVariable Long id) {
        LeaveType leaveType = leaveTypeService.getLeaveTypeById(id);
        return ResponseEntity.ok(leaveType);
    }
}
