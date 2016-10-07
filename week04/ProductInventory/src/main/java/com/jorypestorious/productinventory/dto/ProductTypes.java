package com.jorypestorious.productinventory.dto;

public enum ProductTypes { //////////////// Need to add need Product subclasses here ////////////////
    
    Ball,
    Racquet,
    Shoe,
    General;
    
    public static String[] toStringArray() {
    ProductTypes[] productTypes = values();
    String[] productTypeStrings = new String[productTypes.length];

    for (int i = 0; i < productTypes.length; i++) {
        productTypeStrings[i] = productTypes[i].name();
    }

    return productTypeStrings;
}

}
