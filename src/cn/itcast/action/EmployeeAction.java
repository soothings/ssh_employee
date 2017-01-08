package cn.itcast.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.entity.Employee;
import cn.itcast.service.EmployeeService;

/**
 * 员工管理的action
 * @author Administrator
 *
 */

public class EmployeeAction extends ActionSupport implements ModelDriven<Employee> {
    
	//模型驱动使用的对象
	private Employee employee=new Employee();
	@Override
	public Employee getModel() {
		// TODO Auto-generated method stub
		return employee;
	}
	
	//注入业务层类
	private EmployeeService employeeService;
	
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	
	/**
	 * 登录执行的方法
	 * @return
	 */
	public String login(){
		
		//调用业务层的方法
		Employee existEmployee=employeeService.login(employee);
		if (existEmployee==null) {
			//登录失败
			this.addActionError("用户名或密码错误!");
			return INPUT;
		}else {
			//登录成功,放入Session里
			ActionContext.getContext().getSession().put("existEmployee", existEmployee);
			return SUCCESS;
		}
		
		
		
		
		//System.out.println("login执行了");
		
	}


	
	
}
