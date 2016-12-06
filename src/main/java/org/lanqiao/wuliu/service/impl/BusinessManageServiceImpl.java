package org.lanqiao.wuliu.service.impl;

import java.util.ArrayList;

import org.lanqiao.wuliu.bean.Goods;
import org.lanqiao.wuliu.bean.Logistics;
import org.lanqiao.wuliu.dao.impl.BusinessManage;

public class BusinessManageServiceImpl {

	BusinessManage bm = new BusinessManage();

	/**
	 * 添加货物信息
	 * 
	 * @param goods
	 *            货物对象
	 * @return 返回int
	 */
	public int goInsert(Goods goods) {
		return bm.goInsert(goods);
	}

	/**
	 * 添加物流信息
	 * 
	 * @param logistics
	 *            物流对象
	 * @return 插入的记录数
	 */
	public int loAdd(Logistics logistics) {
		return bm.loAdd(logistics);
	}

	/**
	 * 统计goods表的记录数
	 * 
	 * @return 返回int
	 */
	public int goCount() {
		return bm.goCount();
	}

	/**
	 * 更新物品清单数据
	 * 
	 * @param goods
	 *            物品清单对象
	 * @param goId
	 *            物品清单Id
	 * @return 返回int
	 */
	public int goUpda(Goods goods, int goId) {
		return bm.goUpda(goods, goId);
	}

	/**
	 * 获取物流信息列表(发货和到货)
	 * 
	 * @param currentPage
	 *            当前页
	 * @param rowsPerPage
	 *            每页记录数
	 * @param srhLicence
	 *            车牌号关键字
	 * @param srhDate
	 *            日期字符串(yyyy-MM-dd)
	 * @return 物流信息列表
	 */
	public ArrayList<Goods> goReach(int goType, int currentPage, int rowsPerPage, String srhLicence,
			String srhDateStr) {
		return bm.goReach(goType, currentPage, rowsPerPage, srhLicence, srhDateStr);
	}

	/**
	 * 删除物流单
	 * 
	 * @param goId
	 *            物流Id
	 * @return 返回int
	 */
	public int goDele(int goId) {
		return bm.goDele(goId);
	}

	public int goInput(Goods goods) {
		return 0;
	}

}