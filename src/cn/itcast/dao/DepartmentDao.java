package cn.itcast.dao;

import java.util.List;

import cn.itcast.entity.Department;

public interface DepartmentDao {
   
	int findCount();
	List<Department> findByPage(int begin,int pageSize);
	void save(Department department);
}
