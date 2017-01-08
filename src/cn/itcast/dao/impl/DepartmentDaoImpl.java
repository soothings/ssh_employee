package cn.itcast.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.itcast.dao.DepartmentDao;
import cn.itcast.entity.Department;

public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao {

	@Override
	public int findCount() {
		
		String hql="select count(*) from Department";
	    List<Long> list=this.getHibernateTemplate().find(hql);
		if (list.size()>0) {
			return list.get(0).intValue();
		}
	    
		return 0;
	}

	//分页查询部门
	@Override
	public List<Department> findByPage(int begin, int pageSize) {
		
		DetachedCriteria criteria=DetachedCriteria.forClass(Department.class);
		List<Department> list=this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		
		
		return list;
	}

	@Override
	public void save(Department department) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(department);
	}

}
