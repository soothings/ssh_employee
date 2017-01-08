package cn.itcast.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.itcast.dao.EmployeeDao;
import cn.itcast.entity.Employee;


public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao {

	
	//DAO中根据用户名、密码查询用户
	@Override
	public Employee findByUsernameAndPassword(Employee employee) {
		String hql="from Employee where username = ? and password = ?";
		List<Employee> list= this.getHibernateTemplate().find(hql,employee.getUsername(),employee.getPassword());
		if (list.size()>0) {
			return list.get(0);
		}
		
		return null;
	}

	
	
	
}
