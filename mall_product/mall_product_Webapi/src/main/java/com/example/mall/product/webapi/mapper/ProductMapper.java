package com.example.mall.product.webapi.mapper;



import com.example.mall.commons.entity.Product;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

@Mapper
public interface ProductMapper {

    @Select("select * from t_product where id = #{id}")
    Product getProduct(Integer id);
    @Select("select * from t_product")
    ArrayList<Product> getAllProduct();
    @Delete("delete from t_product where id = #{id}")
    void deleteById(Integer id);
    @Update("UPDATE t_product SET   title = #{product.title}, sell_point = #{product.sellPoint}, item_type = #{product.itemType}, price = #{product.price} WHERE id = #{product.id}")
    void updateByProduct(@Param("product") Product product);

    @Insert("INSERT INTO t_product (category_id,  title, sell_point, item_type, price) " +
            "VALUES (#{product.categoryId}, #{product.title}, #{product.sellPoint}, #{product.itemType}, #{product.price})")
    int addProduct(@Param("product") Product product);


}
