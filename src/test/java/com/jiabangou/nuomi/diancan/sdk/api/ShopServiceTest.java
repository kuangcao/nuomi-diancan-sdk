package com.jiabangou.nuomi.diancan.sdk.api;

import com.jiabangou.nuomi.diancan.sdk.exception.NuomiErrorException;
import com.jiabangou.nuomi.diancan.sdk.model.Table;
import com.jiabangou.nuomi.diancan.sdk.model.TableCategory;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 商店服务
 * Created by freeway on 16/9/8.
 */
public class ShopServiceTest extends ServiceTest {

    static final Long shopId = 3494770L;
    static final Long tpShopId = 3L;

    @Test
    public void testBind() throws NuomiErrorException {
        diancanClient.getShopService().bind(shopId , tpShopId);
    }

    @Test
    public void testSyncTablesAndCategories() throws NuomiErrorException {
        List<TableCategory> categories = new ArrayList<>();
        TableCategory category1 = new TableCategory();
        category1.setId(1L);
        category1.setName("大厅");
        category1.setShopId(tpShopId);
        categories.add(category1);
        TableCategory category2 = new TableCategory();
        category2.setId(2L);
        category2.setName("包间");
        category2.setShopId(tpShopId);
        categories.add(category2);

        TableCategory category3 = new TableCategory();
        category3.setId(3L);
        category3.setName("外摆");
        category3.setShopId(tpShopId);
        categories.add(category2);

        List<Table> tables = new ArrayList<>();
        Table table1 = new Table();
        table1.setCategoryId(1L);
        table1.setId(1L);
        table1.setMaximumCapacity(4);
        table1.setMinimumCapacity(1);
        table1.setName("1号桌");
        table1.setShopId(tpShopId);
        tables.add(table1);

        Table table2 = new Table();
        table2.setCategoryId(2L);
        table2.setId(2L);
        table2.setMaximumCapacity(4);
        table2.setMinimumCapacity(1);
        table2.setName("雅1");
        table2.setShopId(tpShopId);
        tables.add(table2);

        Table table3 = new Table();
        table3.setCategoryId(3L);
        table3.setId(3L);
        table3.setMaximumCapacity(4);
        table3.setMinimumCapacity(2);
        table3.setName("外1");
        table3.setShopId(tpShopId);
        tables.add(table3);

        diancanClient.getShopService().syncTablesAndCategories(tpShopId, tables, categories);
    }

}
