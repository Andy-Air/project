package cn.yunhe.entity;

import java.util.Date;

public class Reply {
	//回帖ID
	private int rid;
	//回帖标题
	private String title;
	//回帖内容
	private String context;
	//回帖时间
	private Date ptime;
	//回帖人，外键，引用user表主键
	private int uid;
	//所属主贴，外键，引用Topic主键
	private int tid;
	
	public Reply() {
		
	}

	public Reply(int rid, String title, String context, Date ptime, int uid, int tid) {
		super();
		this.rid = rid;
		this.title = title;
		this.context = context;
		this.ptime = ptime;
		this.uid = uid;
		this.tid = tid;
	}

	@Override
	public String toString() {
		return "Reply [rid=" + rid + ", title=" + title + ", context=" + context + ", ptime=" + ptime + ", uid=" + uid
				+ ", tid=" + tid + "]";
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
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

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}
	
	
}
