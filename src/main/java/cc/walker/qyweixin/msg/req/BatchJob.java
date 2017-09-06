package cc.walker.qyweixin.msg.req;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("BatchJob")
public class BatchJob {

	private String JobId;
	private String JobType;
	private String ErrCode;
	private String ErrMsg;

	public String getJobId() {
		return JobId;
	}

	public void setJobId(String jobId) {
		JobId = jobId;
	}

	public String getJobType() {
		return JobType;
	}

	public void setJobType(String jobType) {
		JobType = jobType;
	}

	public String getErrCode() {
		return ErrCode;
	}

	public void setErrCode(String errCode) {
		ErrCode = errCode;
	}

	public String getErrMsg() {
		return ErrMsg;
	}

	public void setErrMsg(String errMsg) {
		ErrMsg = errMsg;
	}

}
