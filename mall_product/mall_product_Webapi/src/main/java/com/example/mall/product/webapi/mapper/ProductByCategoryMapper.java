package com.example.mall.product.webapi.mapper;



import com.example.mall.commons.entity.ProductByCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;


@Mapper
public interface ProductByCategoryMapper {

    @Select("WITH RECURSIVE cte AS (" +
            "  SELECT id FROM t_product_category WHERE id = #{categoryId}" +
            "  UNION ALL" +
            "  SELECT t_product_category.id FROM t_product_category INNER JOIN cte ON t_product_category.parent_id = cte.id" +
            ")" +
            "SELECT t_product.image, t_product.price, t_product.title, t_product.id " +
            "FROM t_product " +
            "WHERE t_product.category_id IN (SELECT id FROM cte)")
    ArrayList<ProductByCategory> getProductsByCategoryId(Integer categoryId);

    @Select("select t_product.image, t_product.price, t_product.title, t_product.id from t_product")
    ArrayList<ProductByCategory> getAllProduct();
}
