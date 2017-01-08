package cn.itcast.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.itcast.dao.DepartmentDao;
import cn.itcast.entity.Department;
import cn.itcast.entity.PageBean;
import cn.itcast.service.DepartmentService;

@Transactional
public class DepartmentServiceImpl implements DepartmentService {

	//ע��servicedao
	private DepartmentDao departmentDao;
	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}
	
	//��ҳ��ѯ���ֵķ���
	@Override
	public PageBean<Department> findByPage(Integer currPage) {
		
		PageBean<Department> pageBean=new PageBean<Department>();
		//��װ��ǰҳ��
		pageBean.setCurrPage(currPage);
		//��װÿҳ��ʾ��¼��
		int pageSize=3;
		pageBean.setPageSize(pageSize);
		//��װ�ܼ�¼��
		int totalCount=departmentDao.findCount();
		pageBean.setTotalCount(totalCount);
		//��װ��ҳ��
		double tc=totalCount;
		Double num=Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());

		//��װÿҳ��ʾ������
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
