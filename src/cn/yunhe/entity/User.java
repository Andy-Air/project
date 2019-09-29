package cn.yunhe.entity;

public class User {
	//用户id
   private  int uid;
   //用户名字
   private String uname;
   //用户密码
   private String upass;
   //用户状态0为正常，1为禁用
   private int state;
   //用户标识0表示管理员，1表示用户
   private int flag;
   
   public User() {}

public User( String uName, String uPass, int state, int flag) {

	this.uname = uName;
	this.upass = uPass;
	this.state = state;
	this.flag = flag;
}

public int getUid() {
	return uid;
}

public void setUid(int uid) {
	this.uid = uid;
}

public String getUname() {
	return uname;
}

public void setUname(String uname) {
	this.uname = uname;
}

public String getUpass() {
	return upass;
}

public void setUpass(String upass) {
	this.upass = upass;
}

public int getState() {
	return state;
}

public void setState(int state) {
	this.state = state;
}

public int getFlag() {
	return flag;
}

public void setFlag(int flag) {
	this.flag = flag;
}

@Override
public String toString() {
	return "User [uid=" + uid + ", uname=" + uname + ", upass=" + upass + ", state=" + state + ", flag=" + flag + "]";
}
   
   
   
}
