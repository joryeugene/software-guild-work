package com.jorypestorious.floormastery.dao;

import java.util.List;

public interface OrderFilesDAO {
    
    List<String> getOrderListFileNames();
    
    void saveOrderListFileNames(List<String> orderListFileNames);

}
