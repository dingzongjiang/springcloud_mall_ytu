package com.example.mall.product.webapi.controller;

import com.example.mall.commons.entity.Product;
import com.example.mall.commons.entity.ProductByCategory;
import com.example.mall.commons.result.Result;
import com.example.mall.product.service.ProductByCategoryService;
import com.example.mall.product.service.ProductService;
import com.github.pagehelper.PageInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*", maxAge = 3600)   //允许跨域访问
public class ProductController {

    @Resource
    private ProductService productService;

    @Resource
    private ProductByCategoryService productByCategoryService;

    @GetMapping("/all/{pageNum}/{pageSize}")
    public ResponseEntity<PageInfo<Product>> getAllProductPage(@PathVariable(value = "pageSize") int pageSize,
                                                               @PathVariable(value = "pageNum") int pageNum) {
        PageInfo<Product> product = productService.getAllProduct(pageNum, pageSize);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/all")
    public ResponseEntity<ArrayList<Product>> getAllProduct() {
        ArrayList<Product> product = productService.getAllProduct();
        return ResponseEntity.ok(product);
    }

    @GetMapping("/getProduct")
    public Product getProduct(@RequestParam("id") Integer id) {
        return productService.getProduct(id);
    }


    @GetMapping("/category/{id}")
    public ArrayList<ProductByCategory> getProductBycategoryid(@PathVariable("id") Integer id) {
        if (id == 0)
            return productByCategoryService.getAllProductByCategory();
        return productByCategoryService.getProductByCategoryid(id);
    }

    @GetMapping("/category/{id}/{pageNum}/{pageSize}")
    public ResponseEntity<PageInfo<ProductByCategory>> getProductBycategoryidPage(@PathVariable("id") Integer id,
                                                                                  @PathVariable(value = "pageSize") int pageSize,
                                                                                  @PathVariable(value = "pageNum") int pageNum) {
        PageInfo<ProductByCategory> product = productByCategoryService.getProductByCategoryidPage(id,pageNum, pageSize);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Integer id) {
        productService.deleteById(id);
        return Result.success();
    }

    @PostMapping("/add")
    public Result<?> insertproduct(@RequestBody Product product) {
        productService.insertProduct(product);
        return Result.success();
    }

    @PutMapping("/change")
    public Result<?> ChangeGoods(@RequestBody Product product) {
        productService.updateById(product);
        return Result.success();
    }

}
