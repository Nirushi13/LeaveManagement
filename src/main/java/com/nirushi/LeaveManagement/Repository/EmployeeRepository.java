package com.nirushi.LeaveManagement.Repository;

import com.nirushi.LeaveManagement.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
