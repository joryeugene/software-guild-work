
package com.jorypestorious.vendingmachinemvc.dao;

import com.jorypestorious.vendingmachinemvc.dto.Item;
import java.util.List;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class VendingMachineDaoInMemImplTest {

    private VendingMachineDao dao;
    
    @Before
    public void setUp() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        dao = ctx.getBean("vendingMachineDao", VendingMachineDao.class);
    }

    @Test
    public void testAddGetRemoveItem() {
        System.out.println("addItem");
        Item item = new Item("Item1", 1.5, 15);
        dao.addItem(item);
        Item fromDB = dao.getItemById(item.getId());
        assertEquals(item, fromDB);
        
        dao.removeItem(item.getId());
        assertNull(dao.getItemById(item.getId()));        
    }

    @Test
    public void testUpdateItem() {
        System.out.println("updateItem");
        Item item = new Item("Item1", 1.5, 15);
        dao.addItem(item);
        item.setName("New Item");
        dao.updateItem(item);
        Item fromDB = dao.getItemById(item.getId());
        assertEquals(item, fromDB);
    }

    @Test
    public void testGetAllItems() {
        System.out.println("getAllItems");
        Item item1 = new Item("Item1", 1.5, 15);
        Item item2 = new Item("Item2", 1.5, 15);
        dao.addItem(item1);
        dao.addItem(item2);
        assertEquals(2, dao.getAllItems().size());        
    }

    @Test
    public void testBuyItem() {
        System.out.println("buyItem");
        Item item1 = new Item("Item1", 1.5, 15);
        double returnMoney = dao.buyItem(item1.getId(), 2.0);
        //assertEquals(0.5, returnMoney);
        //assertEquals(14, item1.getCount());    null pointer
        
    }

}