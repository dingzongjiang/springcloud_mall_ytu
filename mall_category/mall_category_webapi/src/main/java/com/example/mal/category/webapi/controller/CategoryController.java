package com.example.mal.category.webapi.controller;



import com.example.mall.category.service.CategoryService;
import com.example.mall.commons.entity.Category;
import com.example.mall.commons.result.Result;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/category")
@CrossOrigin(origins = "*", maxAge = 3600)   //允许跨域访问
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/by")
    public ResponseEntity<?> getSubcategoriesById(@RequestParam("id") String id) {
        try {
            Integer categoryId = Integer.parseInt(id);
            List<Category> subcategories = categoryService.getSubcategoriesById(categoryId);
            List<List<Map<String, Object>>> categoryList = new ArrayList<>();
            List<Map<String, Object>> currentGroup = new ArrayList<>();
            for (Category category : subcategories) {
                Map<String, Object> categoryJson = new HashMap<>();
                categoryJson.put("id", category.getId());
                categoryJson.put("name", category.getName());
                currentGroup.add(categoryJson);
                if (currentGroup.size() == 8) {
                    categoryList.add(currentGroup);
                    currentGroup = new ArrayList<>();
                }
            }
            if (!currentGroup.isEmpty()) {
                categoryList.add(currentGroup);
            }
            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("categoryList", categoryList);
            return ResponseEntity.ok(responseBody);
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body("Invalid category ID");
        }
    }

    @GetMapping("/root")
    public ArrayList<Category> getrootcate() {
        return categoryService.getrootcate();
    }

    @DeleteMapping("/delete/{id}")
    public Result<?> deletecate(@PathVariable int id) {
        return Result.success(categoryService.deleteCate(id));
    }

    @GetMapping("/data/{cid}")
    public ArrayList<Category> getcatedatabyid(@PathVariable int cid) {
        return categoryService.getsuncatebyid(cid);
    }

    @PostMapping("/add/{parentid}")
    public Result<?> insertproduct(@PathVariable int parentid, @RequestBody Map<String, String> request) {
        String name = request.get("name");
        return Result.success(categoryService.insertCate(parentid, name));
    }

    @GetMapping("/all/{pageNum}/{pageSize}")
    public ResponseEntity<PageInfo<Category>> getAllCates(@PathVariable(value = "pageSize") int pageSize,
                                                      @PathVariable(value = "pageNum") int pageNum) {
        PageInfo<Category> cates = categoryService.getallcate(pageNum,pageSize);
        return ResponseEntity.ok(cates);
    }

    @PutMapping("/update/{categoryid}")
    public Result<?> updateCategoryName(@PathVariable int categoryid, @RequestBody Map<String, String> request) {
        String newName = request.get("name");
        return Result.success(categoryService.updateCategoryName(categoryid, newName));
    }

}