package com.jiabangou.nuomi.diancan.sdk.api;

import com.alibaba.fastjson.JSON;
import com.jiabangou.nuomi.diancan.sdk.exception.NuomiErrorException;
import com.jiabangou.nuomi.diancan.sdk.model.Dish;
import com.jiabangou.nuomi.diancan.sdk.model.DishStatus;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜品服务测试
 * Created by freeway on 16/9/7.
 */
public class DishServiceTest extends ServiceTest {

    @Test
    public void testUploadDishes() throws NuomiErrorException {

        List<Dish> dishes = new ArrayList<>();
        Dish dish = new Dish();
        dish.setCategoryName("凉菜");
        dish.setDesc("蕨根粉丝");
        dish.setDishImages(new ArrayList<String>() {{
            add("https://img.waimai.baidu.com/pb/c644dab340b74e327aa7625c31c6bc5521@s_0,w_297,h_180,q_100");
        }});
        dish.setDishThumbImages(new ArrayList<String>() {{
            add("https://img.waimai.baidu.com/pb/1f556ec01d146179aa763e57eb99cb89e0@s_0,w_172,h_172,q_100");
        }});
        dish.setId("1");
        dish.setIncreaseUnit(1);
        dish.setName("蕨根粉丝");
        dish.setOnlineState(1);
        dish.setSortId(1);
        dish.setPrice(120);
        dish.setSellUnit(1);
        dish.setTpMerchantId("1");
        dish.setUnit("碗");

        dishes.add(dish);
        System.out.println(JSON.toJSON(dishes).toString());
        diancanClient.getDishService().uploadDishes(dishes);
    }


    @Test
    public void testUpdateDishOnlineStatus() throws NuomiErrorException {

        List<DishStatus> dishStatuses = new ArrayList<>();

        DishStatus dishStatus = new DishStatus();
        dishStatus.setId("1");
        dishStatus.setOnlineState(2);
        dishStatus.setTpMerchantId("1");

        dishStatuses.add(dishStatus);
        diancanClient.getDishService().updateDishOnlineStatuses(dishStatuses);
    }
}
