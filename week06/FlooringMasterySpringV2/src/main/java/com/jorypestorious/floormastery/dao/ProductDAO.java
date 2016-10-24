package com.jorypestorious.floormastery.dao;

import com.jorypestorious.floormastery.dto.Product;
import java.util.List;

public interface ProductDAO {
    
    List<Product> run(String productFile);

}
