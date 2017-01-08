package cn.itcast.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.itcast.entity.Employee;
import cn.itcast.service.EmployeeService;

/**
 * Ա�������action
 * @author Administrator
 *
 */

public class EmployeeAction extends ActionSupport implements ModelDriven<Employee> {
    
	//ģ������ʹ�õĶ���
	private Employee employee=new Employee();
	@Override
	public Employee getModel() {
		// TODO Auto-generated method stub
		return employee;
	}
	
	//ע��ҵ�����
	private EmployeeService employeeService;
	
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	
	/**
	 * ��¼ִ�еķ���
	 * @return
	 */
	public String login(){
		
		//����ҵ���ķ���
		Employee existEmployee=employeeService.login(employee);
		if (existEmployee==null) {
			//��¼ʧ��
			this.addActionError("�û������������!");
			return INPUT;
		}else {
			//��¼�ɹ�,����Session��
			ActionContext.getContext().getSession().put("existEmployee", existEmployee);
			return SUCCESS;
		}
		
		
		
		
		//System.out.println("loginִ����");
		
	}


	
	
}
