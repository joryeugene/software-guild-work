package com.jorypestorious.floormastery.dao;

import com.jorypestorious.floormastery.dto.TaxRate;
import java.util.List;

public interface TaxRateDAO {
    
    List<TaxRate> run(String taxFile);

}
