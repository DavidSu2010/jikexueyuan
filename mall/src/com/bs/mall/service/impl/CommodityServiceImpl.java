package com.bs.mall.service.impl;

import java.util.List;

import com.bs.mall.dao.CommodityDao;
import com.bs.mall.entity.Commodity;
import com.bs.mall.service.CommodityService;

public class CommodityServiceImpl implements CommodityService {
    
	private CommodityDao commodityDao;
	
	@Override
	public int saveCommodity(Commodity commodity) {
		// TODO Auto-generated method stub
		return commodityDao.save(commodity);
	}

	@Override
	public List<Commodity> findAll() {
		// TODO Auto-generated method stub
		return commodityDao.findAll();
	}

	@Override
	public List<Commodity> findAllPaging(int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		return commodityDao.findAllPaging(currentPage, pageSize);
	}

	@Override
	public int getTotal() {
		// TODO Auto-generated method stub
		return commodityDao.getTotal();
	}

	@Override
	public Commodity getComm(int id) {
		// TODO Auto-generated method stub
		return commodityDao.get(id);
	}
    
	public CommodityDao getCommodityDao() {
		return commodityDao;
	}

	public void setCommodityDao(CommodityDao commodityDao) {
		this.commodityDao = commodityDao;
	}
	
}
