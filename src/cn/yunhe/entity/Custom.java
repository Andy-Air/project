package cn.yunhe.entity;

public class Custom {
	//帖子总数量
	private int total;
	//版块名称
	private String name;
	public Custom() {};
	
	public Custom(int total, String name) {
		this.total = total;
		this.name = name;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
