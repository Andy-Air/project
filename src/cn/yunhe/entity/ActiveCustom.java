package cn.yunhe.entity;

public class ActiveCustom {
	/**
	 * 总活跃数
	 */
	private int total;
	/**
	 * 用户名称
	 */
	private String uname;
	
	public ActiveCustom() {};
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}
	 
}
