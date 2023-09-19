package com.example.mall.product.webapi.service.impl;



import com.example.mall.commons.entity.Product;
import com.example.mall.product.service.ProductService;
import com.example.mall.product.webapi.mapper.ProductMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@DubboService
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductMapper productMapper;

    @Override
    public Product getProduct(Integer id) {
        return productMapper.getProduct(id);
    }

    @Override
    public ArrayList<Product> getAllProduct() {
        return productMapper.getAllProduct();
    }

    @Override
    public void deleteById(Integer id) {
        productMapper.deleteById(id);
    }

    @Override
    public void updateById(Product product) {
        productMapper.updateByProduct(product);
    }

    @Override
    public PageInfo<Product> getAllProduct(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Product> productList=productMapper.getAllProduct();
        return new PageInfo<>(productList);
    }

    @Override
    public int insertProduct(Product product) {
        return productMapper.addProduct(product);
    }


}
