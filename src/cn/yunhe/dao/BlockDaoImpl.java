package cn.yunhe.dao;

import java.nio.channels.NonWritableChannelException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.yunhe.dao.BlockDao;
import cn.yunhe.entity.Block;
import cn.yunhe.utils.DBUtils;

public class BlockDaoImpl  implements BlockDao{

	/**
	 * 查看版块
	 */
	@Override
	public List<Block> queryBlock() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Block> blockList = new ArrayList<Block>();
		
		try {
			String sql = "select bid,bname from t_block";
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Block block = new Block();
				block.setBid(rs.getInt(1));
				block.setBname(rs.getString(2));
				blockList.add(block);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(conn, ps, rs);
		}
		
		return blockList;
	}
	/**
	 * 增加版块
	 */

	@Override
	public Block addBlock(String bname) {
		Block block = null;
		String sql = "insert into t_block(bname) values(?)";
		int result = DBUtils.cudPre(sql, bname);
		if(result == 1) {
			block = new Block();
			block.setBname(bname);
		}
		return block;
	}

	/**
	 * 根据指定ID删除版块
	 */
	@Override
	public int delBlock(int bid) {
		String sql = "delete from t_block where bid = ?";
		int result = DBUtils.cudPre(sql, bid);	
		return result;
	}

}
