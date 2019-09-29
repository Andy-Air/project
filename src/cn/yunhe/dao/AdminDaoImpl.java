package cn.yunhe.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.yunhe.entity.ActiveCustom;
import cn.yunhe.entity.Custom;
import cn.yunhe.utils.DBUtils;

public class AdminDaoImpl implements AdminDao{
	
	/**
	 * 查询版块对应的总帖数
	 */
	@Override
	public List<Custom> queryCustomList() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Custom> cuslist = new ArrayList<Custom>();
		try {
			String sql = "select count(tid) total,bname from t_topic topic left join t_block block on topic.bid = block.bid group by topic.bid";
			//获取连接对象
			conn = DBUtils.getConnection();
			//获取预编译对象
			ps = conn.prepareStatement(sql);
			//执行查询操作
			rs = ps.executeQuery();
			if (rs!=null) {
				while (rs.next()) {
					Custom cu = new Custom();
					cu.setName(rs.getString(2));
					cu.setTotal(rs.getInt(1));
					cuslist.add(cu);
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, ps, rs);
		}
		
		return cuslist;
	}
	/**
	 * 用户活跃度
	 */
	@Override
	public List<ActiveCustom> actList() {
		Connection conn = null;
		PreparedStatement ps = null;
		List<ActiveCustom> list = new ArrayList<ActiveCustom>();
		ResultSet rs = null;
		try {
			String sql = "select * from v_active";
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				//用一个对象接受数据
				ActiveCustom cu = new ActiveCustom();
				cu.setTotal(rs.getInt(1));				
				cu.setUname(rs.getString(3));
				list.add(cu);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, ps, rs);
		}
		
		return list;
	}

}
