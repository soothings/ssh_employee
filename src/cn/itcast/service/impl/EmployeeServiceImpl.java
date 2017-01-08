package cn.itcast.service.impl;

import cn.itcast.dao.EmployeeDao;
import cn.itcast.entity.Employee;
import cn.itcast.service.EmployeeService;

/**
 * 员工管理的业务层实现类
 * @author Administrator
 *
 */
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao employeeDao;
	
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	
	
	
	@Override
	public Employee login(Employee employee) {
		Employee existEmployee=employeeDao.findByUsernameAndPassword(employee);
		return existEmployee;
	}
}
