package cn.yunhe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 用户数据实现类
 */
import cn.yunhe.entity.Reply;
import cn.yunhe.entity.Topic;
import cn.yunhe.entity.User;
import cn.yunhe.utils.DBUtils;

public class UserDaoImpl implements UserDao {

	/**
	 * 查询的目的：
	 * 		1.用于判断用户是否存在做登录使用
	 * 		2.存储用户的信息用户之后的操作使用 查看个人信息
	 */
	@Override
	public User login(String username, String password,int flag) {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		try {
			String sql = "select uid,uname,upass,state,flag from t_user where uname=? and upass=? and flag=?";
			//获取连接对象
			connection = DBUtils.getConnection();
			//获取预编译对象
			ps = connection.prepareStatement(sql);
			//设置参数
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setInt(3, flag);
			//执行查询操作
			rs = ps.executeQuery();
			if (rs!=null) {
				while(rs.next()) {
					//将获取到的值封装在一个user对象中
					user = new User();
					user.setUid(rs.getInt(1));
					user.setUname(rs.getString(2));
					user.setUpass(rs.getNString(3));
					user.setState(rs.getInt(4));
					user.setFlag(rs.getInt(5));
					
				}
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		 
		return user;
	}
/**
 * 注册
 */
	@Override
	public int regist(String username, String pwd) {
		
		String sql = "insert into t_user (uname,upass,state,flag) values(?,?,0,1)";
		Object[] objects = {username,pwd};
		int result = DBUtils.cudPre(sql, objects);
		return result;
	}
	/**
	 * 发送帖子
	 */

	@Override
	public int sendTopic(Topic topic) {
		String sql = "insert into t_topic (title,context,ptime,uid,bid) values(?,?,?,?,?)";
		Object[] objects = {topic.getTitle(),topic.getContext(),topic.getPtime(),topic.getUid(),topic.getBid()};
		int result = DBUtils.cudPre(sql, objects);
		return result;
	}

	/**
	 * 回复帖子
	 */
	@Override
	public int reply(Reply reply) {
		String sql = "insert into t_reply (title,context,ptime,uid,tid) values(?,?,?,?,?)";
		Object[] objects = {reply.getTitle(),reply.getContext(),reply.getPtime(),reply.getUid(),reply.getTid()};
		int result = DBUtils.cudPre(sql, objects);
		return result;
	}
	
	/**
	 * 用户管理
	 */
	@Override
	public int admin(int uid) {
		String sql = "update t_user set state = 1 where uid = ? ";
		Object[] objects = {uid};
		int result =  DBUtils.cudPre(sql, objects);
		return result;
	}
	/**
	 * 删除主贴
	 */
	@Override
	public int delePost(int tid) {
		String sql = " DELETE FROM t_topic WHERE tid = ? ";
		Object[] objects = {tid};
		int result =  DBUtils.cudPre(sql, objects);
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
