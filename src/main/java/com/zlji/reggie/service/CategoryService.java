package com.zlji.reggie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zlji.reggie.entity.Category;
import com.zlji.reggie.entity.Employee;

public interface CategoryService extends IService<Category> {
    public void remove(Long id);
}
