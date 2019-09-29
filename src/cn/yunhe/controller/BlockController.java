package cn.yunhe.controller;



import java.util.List;

import cn.yunhe.entity.Block;
import cn.yunhe.entry.Mannger;
import cn.yunhe.service.BlockService;
import cn.yunhe.service.BlockServiceImpl;


public class BlockController {
	
	BlockService blockService = new BlockServiceImpl();
	

	/**
	 * 增加版块
	 */
	public void addBlock(String bname) {
		Block block = blockService.addBlock(bname);
		if (block==null) {
			System.out.println("请重新输入版块名称：");
			Mannger.addBlock();
		}else {
			System.out.println("添加"+bname +"成功");
		}
		
	}
	/**
	 * 查看版块
	 */
	public void querBlock() {
		List<Block> blockList = blockService.queryBlock();
		System.out.println("版块ID\t\t版块名称");
		for (Block b : blockList) {
			System.out.println(b.getBid()+"\t\t\t"+b.getBname());
		}
	}
	/**
	 * 根据指定ID删除版块
	 */
	public void deleBlock(int bid) {
		int result = blockService.delBlock(bid);
		if (result==1) {
			System.out.println("删除成功");
		}else {
			System.out.println("删除失败");
		}
	}
}
