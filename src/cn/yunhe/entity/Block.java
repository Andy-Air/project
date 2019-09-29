package cn.yunhe.entity;

public class Block {
	//版块id
	private int bid;
	//版块名字
	private String bname;
	
	
	public  Block() {}


	public Block(int bid, String bname) {
		
		this.bid = bid;
		this.bname = bname;
	}


	@Override
	public String toString() {
		return "Block [bid=" + bid + ", bname=" + bname + "]";
	}


	public int getBid() {
		return bid;
	}


	public void setBid(int bid) {
		this.bid = bid;
	}


	public String getBname() {
		return bname;
	}


	public void setBname(String bname) {
		this.bname = bname;
	}
	
	
	
}
