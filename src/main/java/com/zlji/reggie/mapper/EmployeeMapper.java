package com.zlji.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zlji.reggie.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper    // 加上注解并继承后常见的增删改查方法就已经有了
public interface EmployeeMapper extends BaseMapper<Employee> {
}
