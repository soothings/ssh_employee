package cn.itcast.service;

import cn.itcast.entity.Employee;

/**
 * 员工管理的业务层接口
 * @author Administrator
 *
 */
public interface EmployeeService {

	Employee login(Employee employee);
}
