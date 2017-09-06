package cc.walker.qyweixin.msg.req;

public class ScanCodeInfo {

	private String ScanType;
	private String ScanResult;

	public String getScanType() {
		return ScanType;
	}

	public void setScanType(String scanType) {
		ScanType = scanType;
	}

	public String getScanResult() {
		return ScanResult;
	}

	public void setScanResult(String scanResult) {
		ScanResult = scanResult;
	}
}
