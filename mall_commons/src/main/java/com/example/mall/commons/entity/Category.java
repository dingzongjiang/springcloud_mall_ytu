package com.example.mall.commons.entity;

import lombok.Data;

import java.util.List;

@Data
public class Category {
    private Integer id;
    private String name;
    private int parentId;
    private int sortOrder;
    private int isParent ;
    private List<Category> childCategories;

    public Category() {
    }

    public Category(Integer id, String name, String parentId, List<Category> childCategories) {
        this.id = id;
        this.name = name;
        this.parentId = Integer.parseInt(parentId);
        this.childCategories = childCategories;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public List<Category> getChildCategories() {
        return childCategories;
    }

    public void setChildCategories(List<Category> childCategories) {
        this.childCategories = childCategories;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parentId='" + parentId + '\'' +
                ", childCategories=" + childCategories +
                '}';
    }
}