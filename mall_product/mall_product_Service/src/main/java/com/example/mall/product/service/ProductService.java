package com.example.mall.product.service;



import com.example.mall.commons.entity.Product;
import com.github.pagehelper.PageInfo;

import java.util.ArrayList;

public interface ProductService {
    Product getProduct(Integer id);

    ArrayList<Product> getAllProduct();

    void deleteById(Integer id);
    void updateById(Product product);

    PageInfo<Product> getAllProduct(int pageNum, int pageSize);

    int insertProduct(Product product);
}
