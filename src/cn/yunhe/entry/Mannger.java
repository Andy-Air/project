package cn.yunhe.entry;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import cn.yunhe.controller.AdminController;
import cn.yunhe.controller.BlockController;
import cn.yunhe.controller.UserController;
import cn.yunhe.entity.ActiveCustom;
import cn.yunhe.entity.Custom;
import cn.yunhe.entity.Reply;
import cn.yunhe.entity.Topic;
import cn.yunhe.entity.User;
import cn.yunhe.utils.DBUtils;

public class Mannger {
	static Scanner sc = new Scanner(System.in);
	static UserController userCon = new UserController();
	static BlockController blockCon = new BlockController();
	static AdminController adminCon = new AdminController();
	/**
	 *   主程序
	 */
	public static void init() {
		System.out.println("----------------欢迎进入某某论坛----------------");
		System.out.println("1 管理员登录\t 2 普通用户登录\t 3 注册 \t 4退出");
		System.out.println("请输入您想要的操作：");
		 int num = sc.nextInt();
		 int flag = 1;
		 switch (num) {
		case 1:
			flag = 0;
			login(flag);
			
			break;
		case 2:
			login(flag);
			break;
		case 3:
			regist();
			break;

		default:
			System.out.println("欢迎下次光临");
			break;
		}
	}
	/**
	 * 登录方法
	 * @param flag
	 */
	public static void login(int flag) {
		System.out.println("输入您的用户名");
		String username = sc.next();
		System.out.println("输入您的密码");
		String password = sc.next();
		userCon.login(username, password, flag);
		
	}
	/**
	 * 注册方法
	 */
	public static void regist() {
		System.out.println("输入您的用户名");
		String username = sc.next();
		System.out.println("输入您的密码");
		String pwd = sc.next();
		System.out.println("再次输入您的密码");
		String repwd = sc.next();
		if (username!=null && pwd!=null) {
			if (!pwd.equals(repwd)) {
				System.out.println("俩次密码不一致，请重新输入");
				regist();
			}else {
				
				userCon.register(username, pwd, repwd);
			}
			
		}
		
		
	}
	/**
	 * 用户菜单
	 */
	
	public static void userMenu() {
		System.out.println("请输入您的选项：");
		System.out.println("1 查看帖子\t 2 发送主贴\t 3 回复帖子\t 4 删除帖子 \t 5退出");
		int num = sc.nextInt();
		switch (num) {
		case 1:
			selectTopic();
			System.out.println("按任意键返回上级");
			int sum = sc.nextInt();
			if (sum==1) {
				userMenu();
			}else {
				userMenu();
			}
			
			break;
		case 2:
			choseMenu("发帖");
			break;
		case 3:
			choseMenu("回帖");
			break;
		case 4:
			choseMenu("删除");
			break;
		case 5:
			System.out.println("欢迎下次光临");
			break;

		default:
			System.out.println("输入无效，请重新输入：");
			userMenu();
			break;
		}
	}
	/**
	 * 管理员菜单
	 */
	public static void adminMenu() {
		System.out.println("请输入您的操作：");
		System.out.println("1 用户管理\t\t 2 版块管理\t  3 统计汇总\t 4 退出");
		int num = sc.nextInt();
		switch (num) {
		case 1:
			choseMenu1("用户管理");
			break;
		case 2:
			choseMenu1("版块管理");
			
			break;
		case 3:
			choseMenu1("统计汇总");
			break;
		case 4:
			System.out.println("欢迎下次光临");
			
			break;

		default:
			System.out.println("输入无效");
			adminMenu();
			break;
		}
	}
	
	/**
	 * 发送主贴
	 */
	public static void sendTopic() {
		Topic topic = new Topic();
		System.out.println("输入您的标题名：");
		topic.setTitle(sc.next());		
		System.out.println("输入您的内容：");
		topic.setContext(sc.next());
		queryBlock();
		System.out.println("输入您所在的版块：");
		topic.setBid(sc.nextInt());
		topic.setUid(userCon.user.getUid());	
		topic.setPtime(new Date());
		userCon.sendTopics(topic);
		
	}
	/**
	 * 版块管理
	 */
	public  static void blockAdmin() {
		System.out.println("1 查看版块\t 2 增加版块\t 3 删除版块\t 4返回主菜单");
		int num = sc.nextInt();
		switch (num) {
		case 1:
			queryBlock();
			System.out.println("按任意数字返回上级");
			int key = sc.nextInt();
			if (key!=100000) {
				blockAdmin();
			}else {
				blockAdmin();
			}
			break;
		case 2:
			addBlock();
			System.out.println("按1继续增加版块      按其他任意数字返回上级");
			int keys = sc.nextInt();
			if (keys==1) {
				addBlock();	
			}else {
				blockAdmin();
			}
			blockAdmin();
			break;
		case 3:
			adminMenu();
			break;

		default:
			break;
		}
	}
	
	
	/**
	 * 增加版块
	 */
	public static void addBlock() {
		System.out.println("请输入要增加版块的名称：");
		String bname = sc.next();
		blockCon.addBlock(bname);
	}
	/**
	 * 查看版块
	 */
	public static void queryBlock() {
		blockCon.querBlock();
	}
	
	
	/**
	 * 管理用户
	 */
	public static void admin() {
		System.out.println("请输入您想要禁用的用户ID：");
		int uid = sc.nextInt();
		userCon.admin(uid);
		
		
	}
	/**
	 * 查看用户
	 */
	
	public static void selectUser() {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<User> list = new ArrayList<User>();
		try {
			String sql = "select uid,uname,state from t_user where flag=1";
			//获取连接对象
			connection = DBUtils.getConnection();			
			ps = connection.prepareStatement(sql);
			//执行查询操作
			rs = ps.executeQuery();
			if (rs!=null) {
				while(rs.next()) {
					
					User user = new User();
					user.setUid(rs.getInt(1));
					user.setUname(rs.getString(2));
					user.setState(rs.getInt(3));
					
					list.add(user);
					
				}System.out.println("用户ID\t\t 用户名称\t\t 用户状态");
				for (User l : list ) {
					
					System.out.println(l.getUid()+"\t\t"+l.getUname()+"\t\t"+l.getState());
				}
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			DBUtils.close(connection, ps, rs);
		}
	
	}
	

	//查看主贴
	public static void selectTopic() {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;		
		List<Topic> list = new ArrayList<Topic>();		
		try {
			String sql = "select tid,title,context from t_topic";
			//获取连接对象
			connection = DBUtils.getConnection();
			//获取预编译对象
			ps = connection.prepareStatement(sql);
			//执行查询操作
			rs = ps.executeQuery();
			if (rs!=null) {
				while (rs.next()) {
					Topic topic = new Topic();
					topic.setTid(rs.getInt(1));
					topic.setTitle(rs.getString(2));
					topic.setContext(rs.getString(3));
					list.add(topic);
				}System.out.println("帖子ID\t 帖子标题\t 帖子内容");
				for (Topic t : list ) {
					System.out.println(t.getTid()+"\t"+t.getTitle()+"\t"+t.getContext());
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(connection, ps, rs);
		}
		
		
	}
	
	//帖子返回上级
	public static void choseMenu(String type) {
		if ("发帖".equals(type)) {			
			//调用发帖方法
			sendTopic();
			System.out.println("1 继续发帖");
		}else if ("回帖".equals(type)) {
			//查看所有帖子
			selectTopic();
			//调用回帖方法
			reply();
			System.out.println("1 继续回帖");
			
		}else if ("删除".equals(type)) {
			delePost();
		}
		System.out.println("2 回到主菜单");
		System.out.println("请输入选择");
		int continueId = sc.nextInt();
		switch(continueId) {
		case 1:
			choseMenu(type);
			break;
		case 2:
			userMenu();
			break;
		}
	}
	/**
	 * 用户管理
	 * @param type
	 */
	public static void choseMenu1(String type){
		if ("用户管理".contains(type)) {
			//查看用户
			selectUser();
			//禁用用户
			admin();
			System.out.println("1 继续禁用");			
		}else if ("版块管理".contains(type)) {
			System.out.println("1 查看版块\t 2 增加版块  \t 3 删除版块 \t 4 退出");
			int sum = sc.nextInt();
			switch (sum) {
			case 1:
				//查看版块
				choseMenu1("查看版块");
				break;
			case 2:
				//增加版块
				choseMenu1("增加版块");
				break;
			case 3:
				//增加版块
				choseMenu1("删除版块");
				break;

			default:
				System.out.println("欢迎下次光临");
				break;
			}
			
			System.out.println("1继续选择");
		}else if ("查看版块".contains(type)) {
			//查看版块
			queryBlock();
			System.out.println("1继续查看");
		}else if ("增加版块".contains(type)) {
			//增加版块
			addBlock();
			System.out.println("1继续增加");
		}else if ("删除版块".contains(type)) {
			//删除版块
			deleBlock();
			System.out.println("1继续删除");
		}else if ("活跃度".contains(type)) {
			seleAct();
			System.out.println("1 继续查看");
		}else if ("统计汇总".contains(type)) {
			System.out.println("1 版块总帖数  2活跃用户排行 ");
			int aum = sc.nextInt();
			switch (aum) {
			case 1:
				choseMenu1("总帖数");
				break;
			case 2:
				choseMenu1("活跃度");
				break;

			default:
				break;
			}
		}else if ("总帖数".contains(type)) {
			seleBolck();
			System.out.println("1继续查看");
		}	
		System.out.println("2 回到主菜单");
		System.out.println("请输入选择");
		int continueId = sc.nextInt();
		switch(continueId) {
		case 1:
			choseMenu1(type);
			break;
		case 2:
			adminMenu();
			break;
		}
		
	}
	/**
	 * 回复帖子
	 */
    public static void reply() {
		Reply reply = new Reply();
		
		System.out.println("请输入您的标题");
		reply.setTitle(sc.next());
		System.out.println("请输入您的内容");
		reply.setContext(sc.next());
		reply.setPtime(new Date());
		selectTopic();
		System.out.println("输入您回复主贴的ID");
		reply.setTid(sc.nextInt());
		reply.setUid(userCon.user.getUid());
		userCon.reply(reply);
	}

    /**
     * 删除主贴
     */
    public static void delePost() {
    	Topic topic = new Topic();
    	User user  = new User();
    	selectTopic();
    	System.out.println("输入您想删除主贴的ID");
    	int tid = sc.nextInt();
    	if (topic.getUid()==user.getUid()) {
    		userCon.delePost(tid);
		}else {
			System.out.println("您输入的不是您自己的帖子，请重新输入");
			delePost();
		}
    	
	}
    /**
     * 根据指定ID删除版块
     */
    public static void deleBlock() {
    	queryBlock();
		System.out.println("输入您想要删除版块的ID");
		int bid = sc.nextInt();
		blockCon.deleBlock(bid);
	}
    
    /**
     * 查看用户活跃度
     */
    public static void seleAct() {
		List<ActiveCustom> list = adminCon.active();
		System.out.println("名称       总活跃度");
		for (ActiveCustom l :list) {
			System.out.println(l.getUname()+"\t" + l.getTotal());
			
		}
		
	}
    /**
     * 	版块对应的总帖数
     * 
     */
    public static void seleBolck() {
		List<Custom> l = adminCon.seleBlock();
		System.out.println("版块名称\t 总帖数");
		for (Custom c : l) {
			System.out.println(c.getName()+"\t" + c.getTotal());
		}
	}
}
