package com.bs.mall.entity;

import java.util.HashSet;
import java.util.Set;

public class Commodity implements java.io.Serializable {  //4��ʵ�ִ���io�ӿ�   hibernate�ж������棬����Ὣ����д��Ӳ�̣��ͱ������л����Լ����ݶ����������еĴ���
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer commodityId;    // 1��ʹ�ö���Integer����ʹ�ñ�������int
	private String commodityName;
	private Double price;
	private Double agio;
    private Set<Consume> consumes = new HashSet<Consume>();  // 2��commodity��Ʒ��1��consume�����Ƕࣻһ�Զ��ϵ
	
    public Commodity() {
		// TODO Auto-generated constructor stub
	};  // 3���޲����������������Բ�����
	
	public Commodity(String commodityName,Double price,Double agio,Set<Consume> consumes){
		this.commodityName = commodityName;
		this.price = price;
		this.agio = agio;
		this.consumes = consumes;
	}  // 3���в����������������Բ�����
    
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
