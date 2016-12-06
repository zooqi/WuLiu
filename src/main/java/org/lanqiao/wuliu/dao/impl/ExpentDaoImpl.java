/**
 * 
 */
package org.lanqiao.wuliu.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.lanqiao.wuliu.bean.Expent;
import org.lanqiao.wuliu.bean.Goods;

/**
 * 财务管理
 * 
 * @author 杨明静
 *
 */
public class ExpentDaoImpl extends BaseDaoImpl {

	/**
	 * 添加支出
	 * 
	 * @param emp
	 * @return
	 */
	public int expInsert(Expent expent) {
		String sql = "INSERT expent(expEmpNum,expEmpName,expFunction,expMoney,expDate,expRemark) VALUES(?,?,?,?,?,?)";
		Object[] params = new Object[] { expent.getExpEmpNum(),
				expent.getExpEmpName(), expent.getExpFunction(),
				expent.getExpMoney(), expent.getExpDate(),
				expent.getExpRemark() };
		return cud(sql, params);
	}

	/**
	 * 删除信息
	 * 
	 * @param expId
	 *            支出Id
	 * @return 返回删除记录数
	 */
	public int expDelete(int expId) {
		String sql = "DELETE FROM expent WHERE expId=?";
		Object[] params = new Object[] { expId };
		return cud(sql, params);
	}

	/**
	 * 更新信息
	 * 
	 * @param expId
	 *            支出Id
	 * @return 返回更新记录数
	 */
	public int expUpdate(Expent expent, int expId) {
		String sql = "UPDATE expent SET expEmpNum=?,expEmpName=?,expFunction=?,expMoney=?,expDate=?,expRemark=? WHERE expId=?";
		Object[] params = new Object[] { expent.getExpEmpNum(),
				expent.getExpEmpName(), expent.getExpFunction(),
				expent.getExpMoney(), expent.getExpDate(),
				expent.getExpRemark(), expId };
		return cud(sql, params);
	}

	/**
	 * 查找信息
	 * 
	 * @param pageCurrentFirst
	 *            第一条记录
	 * @param pageRows
	 *            一页记录数
	 * @param expentReach
	 * @return 返回一个arraylist集合
	 */
	public ArrayList<Expent> expSelect(int pageCurrentFirst, int pageRows,
			Expent expReach) {
		ArrayList<Expent> list = new ArrayList<Expent>();

		StringBuffer sql = new StringBuffer(
				"SELECT expEmpNum,expEmpName,expFunction,expMoney,expDate,expRemark FROM expent WHERE 1=1 ");
		if (expReach.getExpEmpNum() != null
				&& !expReach.getExpEmpNum().equals("")) {
			sql.append("AND expEmpNum like '%").append(expReach.getExpEmpNum())
					.append("%' ");
		}
		if (expReach.getExpEmpName() != null
				&& !expReach.getExpEmpName().equals("")) {
			sql.append("AND expEmpName like '%")
					.append(expReach.getExpEmpName()).append("%' ");
		}
		if (expReach.getExpFunction() != null
				&& !expReach.getExpFunction().equals("")) {
			sql.append("AND expFunction like '%")
					.append(expReach.getExpFunction()).append("%' ");
		}
		if (expReach.getExpDate() != null && !expReach.getExpDate().equals("")) {
			sql.append("AND expDate like '%").append(expReach.getExpDate())
					.append("%' ");
		}
		sql.append(" ORDER BY expId LIMIT ?, ?");
		ResultSet rs = select(sql.toString(), new Object[] { pageCurrentFirst,
				pageRows });
		System.out.println(sql);
		try {
			while (rs.next()) {
				Expent expent = new Expent();
				expent.setExpEmpNum(rs.getString(1));
				expent.setExpEmpName(rs.getString(2));
				expent.setExpFunction(rs.getString(3));
				expent.setExpMoney(rs.getDouble(4));
				expent.setExpDate(rs.getDate(5));
				expent.setExpRemark(rs.getString(6));
				list.add(expent);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 统计支出表的记录数
	 * 
	 * @return 返回总记录数
	 */
	public int expcount() {
		String sql = "SELECT COUNT(expId) FROM expent";
		ResultSet rs = select(sql);
		int count = 0;
		try {
			while (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
}