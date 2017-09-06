package cc.walker.qyweixin.api;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import cc.walker.qyweixin.api.req.Department;
import cc.walker.qyweixin.api.result.DepartListResult;
import cc.walker.qyweixin.token.AccessToken;
import cc.walker.qyweixin.token.TokenManager;

public class TestContactsApi {
	
	@Before
	public void init() {
		AccessToken at = new AccessToken();
		at.setAccess_token("ZFPW2BPRjSS1vzyK_LN9bdU881A69bbGcluxQyAZ3U-vxvbd8Z3NFgVQ4EIV7Jt7");
		TokenManager.setAt(at);
	}

	@Test
	public void testListDepartment() {
		DepartListResult result = ContactsApi.listDepartment(331);
		List<Department> list = result.getDepartment();
		for (Department d : list) {
			System.out.println(d.getId() + "---" + d.getName());
		}
	}

}
