package com.bs.mall.service.impl;

import java.util.List;

import com.bs.mall.dao.VipDao;
import com.bs.mall.entity.Consume;
import com.bs.mall.entity.Vip;
import com.bs.mall.service.VipService;

public class VipServiceImpl implements VipService {

	private VipDao vipDao;
	
	@Override
	public int addVip(Vip vip) {
		// TODO Auto-generated method stub
		return vipDao.addVip(vip);
	}

	@Override
	public List<Vip> findAll() {
		// TODO Auto-generated method stub
		return vipDao.findAll();
	}

	@Override
	public Vip getVip(int id) {
		// TODO Auto-generated method stub
		return vipDao.get(id);
	}

	@Override
	public int saveConsume(Consume consume) {
		// TODO Auto-generated method stub
		return vipDao.saveConsume(consume);
	}

	@Override
	public List<Consume> findAllPaging(int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		List<Consume> clist =  vipDao.findAllPaging(currentPage, pageSize);
		return clist;
	}

	@Override
	public int getTotal() {
		// TODO Auto-generated method stub
		return vipDao.getTotal();
	}

	public VipDao getVipDao() {
		return vipDao;
	}

	public void setVipDao(VipDao vipDao) {
		this.vipDao = vipDao;
	}
	
}
