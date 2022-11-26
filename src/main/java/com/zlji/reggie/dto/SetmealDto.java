package com.zlji.reggie.dto;

import com.zlji.reggie.entity.Setmeal;
import com.zlji.reggie.entity.SetmealDish;
import com.zlji.reggie.entity.Setmeal;
import lombok.Data;
import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
