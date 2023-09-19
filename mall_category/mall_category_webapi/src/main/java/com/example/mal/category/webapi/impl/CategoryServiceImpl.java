package com.example.mal.category.webapi.impl;


import com.example.mal.category.webapi.mapper.CategoryMapper;
import com.example.mall.category.service.CategoryService;
import com.example.mall.commons.entity.Category;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@DubboService
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> getSubcategoriesById(Integer id) {
        List<Category> subcategories = new ArrayList<>();
        getSubcategories(id, subcategories);

        return subcategories;
    }

    @Override
    public ArrayList<Category> getsuncatebyid(int id) {
        return categoryMapper.getsuncatebyid(id);
    }

    @Override
    public ArrayList<Category> getrootcate() {
        return categoryMapper.getrootcate();
    }

    @Override
    public int insertCate(int id,String name) {
        return categoryMapper.insertCate(id,name);
    }

    @Override
    public int deleteCate(int id) {
        // 递归删除子分类
        categoryMapper.deleteChildCategories(id);

        // 删除指定分类
        categoryMapper.deleteCategoryById(id);

        Integer parentId;
        parentId = categoryMapper.getParentId(id);
        if (parentId != null) {
            // 进行后续操作
            int intValue = parentId.intValue(); // 将Integer转换为int类型
            int childCount = categoryMapper.countChildCategories(intValue);
            if (childCount == 0) {
                // 更新父分类的is_parent字段
                categoryMapper.updateParentStatus(intValue);
            }
        } else {
            // 处理返回值为null的情况
        }

        return 1;
    }

    @Override
    public PageInfo<Category> getallcate(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Category> categoryList=categoryMapper.getallcate();
        return new PageInfo<>(categoryList);
    }

    @Override
    public boolean updateCategoryName(int categoryId, String newName) {
        return categoryMapper.updatecate(categoryId,newName);
    }

    private void getSubcategories(Integer id, List<Category> subcategories) {
        List<Integer> categoryList = categoryMapper.getSubcategoriesById(id);
        if (categoryList != null && !categoryList.isEmpty()) {
            for (Integer categoryId : categoryList) {
                Category category = new Category();
                category.setId(categoryId);
                category.setName(categoryMapper.getCategoryById(categoryId));
                subcategories.add(category);
//                getSubcategories(categoryId, subcategories);
            }
        }
    }
}