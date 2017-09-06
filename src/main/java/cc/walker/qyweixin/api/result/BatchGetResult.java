package cc.walker.qyweixin.api.result;

import java.util.List;

/**
 * 获取异步任务结果
 * 
 * @author walker
 * @date 2016-09-14
 */
public class BatchGetResult implements Result {

	private Integer errcode;
	private String errmsg;
	/**
	 * 任务状态，整型，1表示任务开始，2表示任务进行中，3表示任务已完成 
	 */
	private Integer status;
	/**
	 * 操作类型，字节串，目前分别有：
	 *	1. sync_user(增量更新成员)
	 *	2. replace_user(全量覆盖成员)
	 *	3. replace_party(全量覆盖部门) 
	 */
	private String type;
	/**
	 * 任务运行总条数
	 */
	private Integer total;
	/**
	 * 目前运行百分比，当任务完成时为100 
	 */
	private Integer percentage;
	/**
	 * 预估剩余时间（单位：分钟），当任务完成时为0 
	 */
	private Integer remaintime;
	/**
	 * 详细的处理结果，具体格式参考下面说明。当任务完成后此字段有效
	 */
	private List<BatchResult> result;

	public Integer getErrcode() {
		return errcode;
	}

	public void setErrcode(Integer errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getPercentage() {
		return percentage;
	}

	public void setPercentage(Integer percentage) {
		this.percentage = percentage;
	}

	public Integer getRemaintime() {
		return remaintime;
	}

	public void setRemaintime(Integer remaintime) {
		this.remaintime = remaintime;
	}

	public List<BatchResult> getResult() {
		return result;
	}

	public void setResult(List<BatchResult> result) {
		this.result = result;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	@Override
	public boolean isSucceed() {
		return errcode == 0;
	}

}
