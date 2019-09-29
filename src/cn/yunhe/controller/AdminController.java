package cn.yunhe.controller;

import java.util.List;

import cn.yunhe.entity.ActiveCustom;
import cn.yunhe.entity.Custom;
import cn.yunhe.service.AdminService;
import cn.yunhe.service.AdminServiceImpl;

public class AdminController {
	AdminService ads = new AdminServiceImpl();
	/**
	 * 用户活跃度
	 */
	public List<ActiveCustom> active(){
		
		return ads.actList();
		
	}
	
	public List<Custom> seleBlock() {
		return ads.queryCustomList();
		
	}
}
