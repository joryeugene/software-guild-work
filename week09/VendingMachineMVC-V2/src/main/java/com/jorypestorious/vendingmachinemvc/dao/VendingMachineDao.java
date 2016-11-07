package com.jorypestorious.vendingmachinemvc.dao;

import com.jorypestorious.vendingmachinemvc.dto.Item;
import java.util.List;
import java.util.Map;

public interface VendingMachineDao {

    public Item addItem(Item item);

    public void removeItem(int id);

    public void updateItem(Item item);

    public List<Item> getAllItems();

    public Item getItemById(int id);
    
}
