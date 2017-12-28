package com.bs.mall.entity;

public class Consume  implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer consumeId;
	private Vip vipid;
	private String name;
	private Commodity commodityId;
	private String commodityName;
	private Double price;
	private Double practicePrice;

	public Consume() {

	}

	public Integer getConsumeId() {
		return consumeId;
	}

	public void setConsumeId(Integer consumeId) {
		this.consumeId = consumeId;
	}

	public Vip getVipid() {
		return vipid;
	}

	public void setVipid(Vip vipid) {
		this.vipid = vipid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Commodity getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(Commodity commodityId) {
		this.commodityId = commodityId;
	}

	public String getCommodityName() {
		return commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getPracticePrice() {
		return practicePrice;
	}

	public void setPracticePrice(Double practicePrice) {
		this.practicePrice = practicePrice;
	}

	public Consume(Integer consumeId, Vip vipid, String name, Commodity commodityId, String commodityName, Double price,
			Double practicePrice) {
		this.consumeId = consumeId;
		this.vipid = vipid;
		this.name = name;
		this.commodityId = commodityId;
		this.commodityName = commodityName;
		this.price = price;
		this.practicePrice = practicePrice;
	}

}
