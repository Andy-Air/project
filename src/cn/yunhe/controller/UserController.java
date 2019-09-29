package cn.yunhe.controller;

import java.sql.ResultSet;

import cn.yunhe.entity.Reply;
import cn.yunhe.entity.Topic;
import cn.yunhe.entity.User;
import cn.yunhe.entry.Mannger;
import cn.yunhe.service.UserService;
import cn.yunhe.service.UserServiceImpl;

public class UserController {
	UserService userService = new UserServiceImpl();
	public static User user;
	
	/**
	 * 用户登录
	 * @param username
	 * @param password
	 * @param flag
	 */
	public void login(String username, String password,int flag) {
		
		if (username!=null && password!=null) {
			 user = userService.login(username, password, flag);
			if (user!=null) {
				System.out.println("欢迎尊敬的"+user.getUname()+"用户");
				if (flag==0) {
					Mannger.adminMenu();
				}else {
					Mannger.userMenu();
				}
			}else {
				System.out.println("登录失败，请重新检查用户名和密码");
				Mannger.login(flag);
			}
		}
		
	}
	/**
	 * 用户注册
	 * @param username
	 * @param pwd
	 * @param repwd
	 */
	public void register(String username, String pwd, String repwd) {
		int result = userService.regist(username, pwd);
		if (result==1) {
			System.out.println("注册成功");
			Mannger.userMenu();
		}else {
			System.out.println("注册失败");
			Mannger.regist();
			
			
		}
	
	}
	/**
	 * 发送主贴
	 */
	public void sendTopics(Topic topic) {		
		int result = userService.sendTopic(topic);
		if (result==1) {
			System.out.println("发送成功");
		}else {
			System.out.println("发送失败");
		}
		
	}
	/**
	 * 用户管理
	 */
	public void admin(int uid) {
		int result = userService.admin(uid);
		if (result==1) {
			System.out.println("禁用成功");
			
		}else {
			System.out.println("禁用失败");
		}
		
	}
	/**
	 * 回复帖子
	 */
	public void reply(Reply reply) {
		int result = userService.reply(reply);
		if (result==1) {
			System.out.println("回复成功");
		}else {
			System.out.println("回复失败");
		}
	}
	
	/**
	 * 删除主贴
	 */
	
	public void delePost(int tid) {
		int result = userService.delePost(tid);
		if (result==1) {
			System.out.println("删除成功");
		}else {
			System.out.println("删除失败");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
