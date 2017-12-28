package com.bs.mall.dao;

import java.util.List;

import com.bs.mall.entity.Commodity;

public interface CommodityDao {
    int save (Commodity commodity);
    
    Commodity get(int id);
    
    int getTotal();
    
    List<Commodity> findAll();
    
    List<Commodity> findAllPaging(int currentPage,int pageSize);
    
}
