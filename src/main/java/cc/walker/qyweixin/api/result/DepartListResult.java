package cc.walker.qyweixin.api.result;

import java.util.List;

import cc.walker.qyweixin.api.req.Department;

/**
 * 部门列表返回结果
 * @author walker
 *
 */
public class DepartListResult implements Result {
	
	private String errmsg;
	private Integer errcode;
	private List<Department> department;

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public Integer getErrcode() {
		return errcode;
	}

	public void setErrcode(Integer errcode) {
		this.errcode = errcode;
	}

	public List<Department> getDepartment() {
		return department;
	}

	public void setDepartment(List<Department> department) {
		this.department = department;
	}

	@Override
	public boolean isSucceed() {
		return errcode == 0;
	}
	
}
