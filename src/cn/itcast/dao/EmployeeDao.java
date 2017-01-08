package cn.itcast.dao;

import cn.itcast.entity.Employee;

public interface EmployeeDao {
   
	Employee findByUsernameAndPassword(Employee employee);
}
