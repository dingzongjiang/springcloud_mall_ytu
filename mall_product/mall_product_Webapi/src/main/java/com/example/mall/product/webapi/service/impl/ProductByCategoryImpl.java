package com.example.mall.product.webapi.service.impl;



import com.example.mall.commons.entity.ProductByCategory;
import com.example.mall.product.service.ProductByCategoryService;
import com.example.mall.product.webapi.mapper.ProductByCategoryMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@DubboService
public class ProductByCategoryImpl implements ProductByCategoryService {

    @Resource
    private ProductByCategoryMapper productByCategoryMapper;

    @Override
    public ArrayList<ProductByCategory> getProductByCategoryid(int id) {

        return productByCategoryMapper.getProductsByCategoryId(id);
    }

    @Override
    public PageInfo<ProductByCategory> getProductByCategoryidPage(int id, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<ProductByCategory> productList;
        if (id == 0) {
            productList = productByCategoryMapper.getAllProduct();
        } else {
            productList = productByCategoryMapper.getProductsByCategoryId(id);
        }
        return new PageInfo<>(productList);
    }

    @Override
    public ArrayList<ProductByCategory> getAllProductByCategory() {
        return productByCategoryMapper.getAllProduct();
    }

//    @Override
//    public List<ProductByCategory> list() {
//        TaskResultExample taskResultExample = new TaskResultExample();
//        taskResultExample.setOrderByClause("id");
//        return productByCategoryMapper.selectByExample(taskResultExample);
//    }

    @Override
    public PageInfo<ProductByCategory> findProductByPage(int pageNum, int pageSize, int search) {
        PageHelper.startPage(pageNum, pageSize);

        List<ProductByCategory> productList = productByCategoryMapper.getProductsByCategoryId(search);

//        PageInfo<ProductByCategory> pageInfo = new PageInfo<>(productList);
//        return new Page<>(productList, pageInfo.getTotal());
        return new PageInfo<>(productList);
    }


}
