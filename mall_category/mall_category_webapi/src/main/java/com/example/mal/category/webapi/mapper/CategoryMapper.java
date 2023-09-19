package com.example.mal.category.webapi.mapper;


import com.example.mall.commons.entity.Category;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface CategoryMapper {

    List<Integer> getSubcategoriesById(Integer id);
    String getCategoryById(Integer id);

    @Select("select * from t_product_category where parent_id = #{id}")
    ArrayList<Category> getsuncatebyid(int id);

    @Select("select * from t_product_category where parent_id = 0")
    ArrayList<Category> getrootcate();

    int insertCate(@Param("id") int id, @Param("name") String name);

    boolean updatecate(@Param("id") int id, @Param("name") String name);

    @Delete("DELETE FROM t_product_category WHERE id = #{id}")
    int deleteCategoryById(int id);

    @Select("SELECT COUNT(*) FROM t_product_category WHERE parent_id = #{parentId}")
    int countChildCategories(int parentId);

    @Update("UPDATE t_product_category SET is_parent = 0 WHERE id = #{parentId}")
    int updateParentStatus(int parentId);


    default void deleteChildCategories(int parentId) {
        List<Integer> childIds = getChildIds(parentId);
        for (int childId : childIds) {
            // 递归删除子分类的子分类
            deleteChildCategories(childId);
            // 删除子分类
            deleteCategoryById(childId);
        }
    }

    @Select("SELECT id FROM t_product_category WHERE parent_id = #{parentId}")
    List<Integer> getChildIds(int parentId);

    @Select("SELECT parent_id FROM t_product_category WHERE id = #{id}")
    Integer  getParentId(int id);

    @Select("SELECT * FROM t_product_category")
    ArrayList<Category> getallcate();
}
