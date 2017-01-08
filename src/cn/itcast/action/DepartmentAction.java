package cn.itcast.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.jndi.url.dns.dnsURLContext;

import cn.itcast.entity.Department;
import cn.itcast.entity.PageBean;
import cn.itcast.service.DepartmentService;

/**
 * 部门管理的action类
 * @author Administrator
 *
 */
public class DepartmentAction extends ActionSupport implements ModelDriven<Department> {
     
	//模型驱动使用的对象
	private Department department=new Department();
	
	@Override
	public Department getModel() {
		
		return department;
	}
	
	//分页查询
	private Integer currPage=1;
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	
	//注入部门管理service
	private DepartmentService departmentService;
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	
	//提供一个查询的方法
	public String findAll(){
		
	PageBean<Department> pageBean=departmentService.findByPage(currPage);
	//将pageBean存入值栈
	ActionContext.getContext().getValueStack().push(pageBean);
	
		return "findAll";
	}
	//跳转到添加部门的页面
	public String saveUI(){
		return "saveUI";
	}
	//添加部门的执行方法
	public String save(){
		departmentService.save(department);
		return "saveSuccess";
	}
	

}
