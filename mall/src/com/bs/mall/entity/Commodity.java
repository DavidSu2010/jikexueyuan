package com.bs.mall.entity;

import java.util.HashSet;
import java.util.Set;

public class Commodity implements java.io.Serializable {  //4、实现串行io接口   hibernate有二级缓存，缓存会将对象写进硬盘，就必须序列化，以及兼容对象在网络中的传输
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer commodityId;    // 1、使用对象Integer，不使用变量类型int
	private String commodityName;
	private Double price;
	private Double agio;
    private Set<Consume> consumes = new HashSet<Consume>();  // 2、commodity商品是1，consume消费是多；一对多关系
	
    public Commodity() {
		// TODO Auto-generated constructor stub
	};  // 3、无参数构建函数，可以不建立
	
	public Commodity(String commodityName,Double price,Double agio,Set<Consume> consumes){
		this.commodityName = commodityName;
		this.price = price;
		this.agio = agio;
		this.consumes = consumes;
	}  // 3、有参数构建函数，可以不建立
    
	public Set<Consume> getConsumes() {
		return consumes;
	}

	public void setConsumes(Set<Consume> consumes) {
		this.consumes = consumes;
	}

	public Integer getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(Integer commodityId) {
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

	public Double getAgio() {
		return agio;
	}

	public void setAgio(Double agio) {
		this.agio = agio;
	}
}
