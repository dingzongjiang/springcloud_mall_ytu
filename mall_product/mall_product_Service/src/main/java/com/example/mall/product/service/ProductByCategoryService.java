package com.example.mall.product.service;



import com.example.mall.commons.entity.ProductByCategory;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.ArrayList;

public interface ProductByCategoryService {

    ArrayList<ProductByCategory> getProductByCategoryid(@PathVariable("id") int id);

    PageInfo<ProductByCategory> getProductByCategoryidPage(@PathVariable("id") int id,int pageNum, int pageSize);

    ArrayList<ProductByCategory> getAllProductByCategory();

    PageInfo<ProductByCategory> findProductByPage(int pageNum, int pageSize, int search);

//    Page<ProductByCategory> findProductByPage(int pageNum, int pageSize, int search);
}
