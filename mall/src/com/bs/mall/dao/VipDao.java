package com.bs.mall.dao;

import java.util.List;

import com.bs.mall.entity.Consume;
import com.bs.mall.entity.Vip;

public interface VipDao {
   public int addVip(Vip vip);
   
   List<Vip> findAll();
   
   int getTotal();
   
   int saveConsume(Consume consume);
   
   List<Consume> findAllPaging(int currentPage,int pageSize);
   
   Vip get(int id);
}
