package com.jiabangou.nuomi.diancan.sdk.api;

import com.alibaba.fastjson.JSON;
import com.jiabangou.nuomi.diancan.sdk.exception.NuomiErrorException;
import com.jiabangou.nuomi.diancan.sdk.model.Dish;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
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
            add("http://i2.xygcdn.com/login/xyglogo.jpg");
        }});
        dish.setDishThumbImages(new ArrayList<String>() {{
            add("http://i2.xygcdn.com/login/xyglogo.jpg");
        }});
        dish.setId("1");
        dish.setIncreaseUnit(1);
        dish.setName("蕨根粉丝");
        dish.setOnlineState(Dish.ONLINE_STATE_ONLINE);
        dish.setSortId(1);
        dish.setPrice(120);
        dish.setSellUnit(1);
        dish.setTpShopId("3");
        dish.setUnit("碗");
        dish.setScore(5);
        dish.setDishComment(Collections.emptyList());
        dish.setDishAttrs(Collections.emptyList());

        dishes.add(dish);

        Dish dish2 = new Dish();
        dish2.setCategoryName("凉菜");
        dish2.setDesc("松花皮蛋");
        dish2.setDishImages(new ArrayList<String>() {{
            add("http://i2.xygcdn.com/login/xyglogo.jpg");
        }});
        dish2.setDishThumbImages(new ArrayList<String>() {{
            add("http://i2.xygcdn.com/login/xyglogo.jpg");
        }});
        dish2.setId("2");
        dish2.setIncreaseUnit(1);
        dish2.setName("松花皮蛋");
        dish2.setOnlineState(Dish.ONLINE_STATE_ONLINE);
        dish2.setSortId(1);
        dish2.setPrice(120);
        dish2.setSellUnit(1);
        dish2.setTpShopId("3");
        dish2.setUnit("盘");
        dish2.setScore(5);
        dish2.setDishComment(Collections.emptyList());
        dish2.setDishAttrs(Collections.emptyList());
        dishes.add(dish2);

        System.out.println(JSON.toJSON(dishes).toString());
        diancanClient.getDishService().uploadDishes(dishes);
    }

    @Test
    public void testOnline() throws NuomiErrorException {
        diancanClient.getDishService().online("1", "1");
    }

    @Test
    public void testSellOut() throws NuomiErrorException {
        diancanClient.getDishService().sellOut("1", "1");
    }

    @Test
    public void testOffline() throws NuomiErrorException {
        diancanClient.getDishService().offline("1", "1");
    }

    @Test
    public void testDelete() throws NuomiErrorException {
        diancanClient.getDishService().delete("1", "1");
    }
}
