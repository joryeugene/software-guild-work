package com.jorypestorious.vendingmachinemvc.dao;

import com.jorypestorious.vendingmachinemvc.dto.Item;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class VendingMachineDaoInMemImpl implements VendingMachineDao {
    
    private final Map<Integer, Item> itemMap = new HashMap<>();
    private static int idCounter = 0;

    @Override
    public Item addItem(Item item) {
        item.setId(idCounter);
        idCounter++;
        itemMap.put(item.getId(), item);
        return item;
    }

    @Override
    public void removeItem(int id) {
        itemMap.remove(id);
    }

    @Override
    public void updateItem(Item item) {
        itemMap.put(item.getId(), item);
    }

    @Override
    public List<Item> getAllItems() {
        Collection<Item> c = itemMap.values();
        return new ArrayList(c);
    }

    @Override
    public Item getItemById(int id) {
        return itemMap.get(id);
    }

    @Override
    public double buyItem(int id, double money) {
        Item item = itemMap.get(id);
        if (true) {
            
        } else {
        }
        
        return money;
    }
}
