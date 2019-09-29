package cn.yunhe.service;

import java.sql.ResultSet;

import cn.yunhe.dao.UserDao;
import cn.yunhe.dao.UserDaoImpl;
import cn.yunhe.entity.Reply;
import cn.yunhe.entity.Topic;
import cn.yunhe.entity.User;
/**
 * 业务逻辑实现类
 * @author Administrator
 *
 */
public class UserServiceImpl  implements UserService{
		UserDao userDao  = new UserDaoImpl();
	@Override
	public User login(String username, String password, int flag) {
		//根据需求去数据库中拿数据
		User user = userDao.login(username, password, flag);
		return user;
	}
	/**
	 * 用户注册
	 */

	@Override
	public int regist(String username, String pwd) {
		 
		return userDao.regist(username, pwd);
	}

	/**
	 * 发送帖子
	 */
	@Override
	public int sendTopic(Topic topic) {
		
		return userDao.sendTopic(topic);
	}
	/**
	 * 回复帖子
	 */
	@Override
	public int reply(Reply reply) {
		return userDao.reply(reply);
	}
	/**
	 * 用户管理
	 */
	@Override
	public int admin(int uid) {
		
		return userDao.admin(uid);
	}
	@Override
	public int delePost(int tid) {
		
		return userDao.delePost(tid);
	}
	

}
