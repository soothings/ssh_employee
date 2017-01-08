package cn.itcast.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.jndi.url.dns.dnsURLContext;

import cn.itcast.entity.Department;
import cn.itcast.entity.PageBean;
import cn.itcast.service.DepartmentService;

/**
 * ���Ź����action��
 * @author Administrator
 *
 */
public class DepartmentAction extends ActionSupport implements ModelDriven<Department> {
     
	//ģ������ʹ�õĶ���
	private Department department=new Department();
	
	@Override
	public Department getModel() {
		
		return department;
	}
	
	//��ҳ��ѯ
	private Integer currPage=1;
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	
	//ע�벿�Ź���service
	private DepartmentService departmentService;
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	
	//�ṩһ����ѯ�ķ���
	public String findAll(){
		
	PageBean<Department> pageBean=departmentService.findByPage(currPage);
	//��pageBean����ֵջ
	ActionContext.getContext().getValueStack().push(pageBean);
	
		return "findAll";
	}
	//��ת����Ӳ��ŵ�ҳ��
	public String saveUI(){
		return "saveUI";
	}
	//��Ӳ��ŵ�ִ�з���
	public String save(){
		departmentService.save(department);
		return "saveSuccess";
	}
	

}
