package com.gt.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;



/**
 * 
 * 
 * @author raoshijing
 * @email 742434841@qq.com
 * @date 2018-10-31 15:30:02
 */
 @Entity
 @Table(name = "p_entrust_statistics", catalog = "gtcoin")
public class PentrustStatistics implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 627245710027137900L;
	//id
	private Integer id;
	//项目方id
	private Fuser projectId;
	//统计日期（天）
	private String statisticalDate;
	//交易市场id
	private Ftrademapping trademappingId;
	//委托人数
	private Integer mandatorNum;
	//买入（笔）
	private Integer buyNum;
	//卖出（笔）
	private Integer sellNum;
	//买入挂单金额
	private double buyEntrustAmount;
	//卖出挂单金额
	private double sellEntrustAmount;
	//挂单总额
	private double entrustAmount;
	//版本
	private Integer version;
	//创建时间
	private Timestamp createTime;
	//更新时间
	private Timestamp updateTime;
	//交易市场货币对
	private String trademappingStr;
	/**
	 * 设置：id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：id
	 */
	@GenericGenerator(name = "generator", strategy = "identity")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：项目方id
	 */
	public void setProjectId(Fuser projectId) {
		this.projectId = projectId;
	}
	/**
	 * 获取：项目方id
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "project_id")
	public Fuser getProjectId() {
		return projectId;
	}
	/**
	 * 设置：统计日期（天）
	 */
	public void setStatisticalDate(String statisticalDate) {
		this.statisticalDate = statisticalDate;
	}
	/**
	 * 获取：统计日期（天）
	 */
	@Column(name = "statistical_date")
	public String getStatisticalDate() {
		return statisticalDate;
	}
	/**
	 * 设置：交易市场id
	 */
	public void setTrademappingId(Ftrademapping trademappingId) {
		this.trademappingId = trademappingId;
	}
	/**
	 * 获取：交易市场id
	 */
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "trademapping_id")
	public Ftrademapping getTrademappingId() {
		return trademappingId;
	}
	/**
	 * 设置：委托人数
	 */
	public void setMandatorNum(Integer mandatorNum) {
		this.mandatorNum = mandatorNum;
	}
	/**
	 * 获取：委托人数
	 */
	@Column(name = "mandator_num")
	public Integer getMandatorNum() {
		return mandatorNum;
	}
	/**
	 * 设置：买入（笔）
	 */
	public void setBuyNum(Integer buyNum) {
		this.buyNum = buyNum;
	}
	/**
	 * 获取：买入（笔）
	 */
	@Column(name = "buy_num")
	public Integer getBuyNum() {
		return buyNum;
	}
	/**
	 * 设置：卖出（笔）
	 */
	public void setSellNum(Integer sellNum) {
		this.sellNum = sellNum;
	}
	/**
	 * 获取：卖出（笔）
	 */
	@Column(name = "sell_num")
	public Integer getSellNum() {
		return sellNum;
	}
	/**
	 * 设置：买入挂单数
	 */
	public void setBuyEntrustAmount(double buyEntrustAmount) {
		this.buyEntrustAmount = buyEntrustAmount;
	}
	/**
	 * 获取：买入挂单数
	 */
	@Column(name = "buy_entrust_amount")
	public double getBuyEntrustAmount() {
		return buyEntrustAmount;
	}
	/**
	 * 设置：卖出挂单数
	 */
	public void setSellEntrustAmount(double sellEntrustAmount) {
		this.sellEntrustAmount = sellEntrustAmount;
	}
	/**
	 * 获取：卖出挂单数
	 */
	@Column(name = "sell_entrust_amount")
	public double getSellEntrustAmount() {
		return sellEntrustAmount;
	}
	/**
	 * 设置：挂单总额
	 */
	public void setEntrustAmount(double entrustAmount) {
		this.entrustAmount = entrustAmount;
	}
	/**
	 * 获取：挂单总额
	 */
	@Column(name = "entrust_amount")
	public double getEntrustAmount() {
		return entrustAmount;
	}
	/**
	 * 设置：版本
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}
	/**
	 * 获取：版本
	 */
	@Version
	@Column(name = "version")
	public Integer getVersion() {
		return version;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	@Column(name = "create_time")
	public Timestamp getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：修改时间
	 */
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：修改时间
	 */
	@Column(name = "update_time")
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	
	@Transient
	public String getTrademappingStr() {
		return trademappingId.getFvirtualcointypeByFvirtualcointype2().getfShortName()
				+"/"+trademappingId.getFvirtualcointypeByFvirtualcointype1().getfShortName();
	}
	public void setTrademappingStr(String trademappingStr) {
		this.trademappingStr = trademappingStr;
	}
}
