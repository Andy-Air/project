package cn.yunhe.dao;

import java.util.List;

import cn.yunhe.entity.ActiveCustom;
import cn.yunhe.entity.Custom;

public interface AdminDao {
	//查询版块对应的总帖数
	List<Custom> queryCustomList();
	//用户的活跃度
	List<ActiveCustom> actList();
}
