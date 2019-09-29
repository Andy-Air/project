package cn.yunhe.service;

import java.util.List;

import cn.yunhe.dao.AdminDao;
import cn.yunhe.dao.AdminDaoImpl;
import cn.yunhe.entity.ActiveCustom;
import cn.yunhe.entity.Custom;

public class AdminServiceImpl  implements AdminService{
	AdminDao admindao =  new AdminDaoImpl();
	/**
	 * 查询版块对应的总帖数
	 */
	@Override
	public List<Custom> queryCustomList() {
		return admindao.queryCustomList();
	}
	/**
	 * 用户活跃度
	 */
	@Override
	public List<ActiveCustom> actList() {
		return admindao.actList();
	}

}
