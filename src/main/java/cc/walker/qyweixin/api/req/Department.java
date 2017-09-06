package cc.walker.qyweixin.api.req;

/**
 * 创建部门传入参数
 * 
 * @author walker
 * @date 2016-09-13
 */
public class Department {
	
	/**
	 * 部门名称。长度限制为32个字（汉字或英文字母），字符不能包括\:*?"<>｜
	 */
	private String name;
	/**
	 * 父亲部门id。根部门id为1
	 */
	private Integer parentid;
	/**
	 * 在父部门中的次序值。order值小的排序靠前。
	 */
	private Integer order;
	/**
	 * 部门id，整型。指定时必须大于1，不指定时则自动生成 
	 */
	private Integer id;
	
	public Department() {
		
	}

	public Department(String name, Integer parentid, Integer order) {
		super();
		this.name = name;
		this.parentid = parentid;
		this.order = order;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getParentid() {
		return parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
