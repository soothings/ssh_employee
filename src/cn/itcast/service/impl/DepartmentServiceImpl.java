package cn.itcast.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.itcast.dao.DepartmentDao;
import cn.itcast.entity.Department;
import cn.itcast.entity.PageBean;
import cn.itcast.service.DepartmentService;

@Transactional
public class DepartmentServiceImpl implements DepartmentService {

	//注入servicedao
	private DepartmentDao departmentDao;
	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}
	
	//分页查询部分的方法
	@Override
	public PageBean<Department> findByPage(Integer currPage) {
		
		PageBean<Department> pageBean=new PageBean<Department>();
		//封装当前页数
		pageBean.setCurrPage(currPage);
		//封装每页显示记录数
		int pageSize=3;
		pageBean.setPageSize(pageSize);
		//封装总记录数
		int totalCount=departmentDao.findCount();
		pageBean.setTotalCount(totalCount);
		//封装总页数
		double tc=totalCount;
		Double num=Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());

		//封装每页显示的数据
		int begin=(currPage-1)*pageSize;
		List<Department> list=departmentDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		
		
		return pageBean;
	}

	@Override
	public void save(Department department) {
		// TODO Auto-generated method stub
		departmentDao.save(department);
	}
	
	
}
