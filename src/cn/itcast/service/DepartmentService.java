package cn.itcast.service;

import cn.itcast.entity.Department;
import cn.itcast.entity.PageBean;

public interface DepartmentService {
   
	PageBean<Department> findByPage(Integer currPage);
	void save(Department department);
}
