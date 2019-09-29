package cn.yunhe.dao;
/**
 * 用户数据层
 */

import cn.yunhe.entity.Reply;
import cn.yunhe.entity.Topic;
import cn.yunhe.entity.User;

public interface UserDao {
	//用户登录
	User login(String username,String passward,int flag);
	//用户注册
	int regist(String username, String pwd);
	//发送帖子
	int sendTopic(Topic topic);
	//回复帖子
	int reply(Reply reply);
	//用户管理
	int admin(int uid);
	//删除帖子
	int delePost(int tid);
	
	
	
}
