package cn.yunhe.entity;

import java.util.Date;

public class Topic {
	//主贴ID
	private int tid;
	//主贴标题
	private String title;
	//主贴内容
	private String context;
	//发帖时间
	private Date ptime;
	//发帖人，外键，引用user表主键
	private int uid;
	//所属版块，外键，引用block主键
	private int bid;
	
	public  Topic() {
		
	}

	public Topic(int tid, String title, String context, Date ptime, int uid, int bid) {
		super();
		this.tid = tid;
		this.title = title;
		this.context = context;
		this.ptime = ptime;
		this.uid = uid;
		this.bid = bid;
	}

	@Override
	public String toString() {
		return "Topic [tid=" + tid + ", title=" + title + ", context=" + context + ", ptime=" + ptime + ", uid=" + uid
				+ ", bid=" + bid + "]";
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public Date getPtime() {
		return ptime;
	}

	public void setPtime(Date ptime) {
		this.ptime = ptime;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}
	
}
