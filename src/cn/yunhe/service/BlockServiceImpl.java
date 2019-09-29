package cn.yunhe.service;

import java.util.List;

import cn.yunhe.dao.BlockDao;
import cn.yunhe.dao.BlockDaoImpl;
import cn.yunhe.entity.Block;

public class BlockServiceImpl implements BlockService {
	BlockDao blockdao = new  BlockDaoImpl();

	/**
	 * 查看版块
	 */
	@Override
	public List<Block> queryBlock() {
		return blockdao.queryBlock();
	}
	/**
	 * 根据指定ID删除版块
	 */
	@Override
	public int delBlock(int bid) {
		return blockdao.delBlock(bid);
	}
	/**
	 * 增加版块
	 */
	@Override
	public Block addBlock(String bname) {
		return  blockdao.addBlock(bname);
	}
}
