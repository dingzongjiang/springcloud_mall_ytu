package com.example.mall.category.service;


import com.example.mall.commons.entity.Category;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

public interface CategoryService {

    List<Category> getSubcategoriesById(Integer id);

    ArrayList<Category> getsuncatebyid(int id);

    ArrayList<Category> getrootcate();

    int insertCate(int id,String name);

    int deleteCate(int id);

    PageInfo<Category> getallcate(int pageNum, int pageSize);

    boolean updateCategoryName(int categoryId, String newName);
}