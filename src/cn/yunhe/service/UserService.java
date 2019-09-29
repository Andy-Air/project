package cn.yunhe.service;

import java.sql.ResultSet;

import cn.yunhe.entity.Reply;
import cn.yunhe.entity.Topic;
import cn.yunhe.entity.User;

/**
 * 用户服务层
 * @author Administrator
 *
 */
public interface UserService {
	    //用户登录
		User login(String username,String password,int flag);
		//用户注册
		int regist(String username, String pwd);
		//发送帖子
		int sendTopic(Topic topic);
		//回复帖子
		int reply(Reply reply);
		//用户管理
		int admin(int uid);
		//删除主贴
		int delePost(int tid);
		
}
