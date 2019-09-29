package cn.yunhe.dao;

import java.sql.ResultSet;
import java.util.List;

import cn.yunhe.entity.Block;

public interface BlockDao {
	    //查看版块
		List<Block> queryBlock();
		//增加版块
		Block addBlock(String bname);
		//根据ID删除指定版块
		int delBlock(int bid);
		
}
