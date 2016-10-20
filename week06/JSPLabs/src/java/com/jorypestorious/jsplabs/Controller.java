package com.jorypestorious.jsplabs;

import com.jorypestorious.jsplabs.dto.Lucky7Report;
import java.util.Random;

public class Controller {
    
    public static Lucky7Report playLucky7s(Lucky7Report lucky) {
        Random r = new Random();
        int currentMoney = lucky.getInitialValue();
        lucky.setMaxValue(currentMoney);
        
        while (currentMoney > 0) {
            lucky.incrementNumOfTurns();
            if (1 + r.nextInt(6) == 1 + r.nextInt(6)) {
                currentMoney +=  4;
                if (lucky.getMaxValue() < currentMoney) {
                    lucky.setMaxValue(currentMoney);
                    lucky.setMaxTurn(lucky.getTotalTurns());
                }
                
            } else {
                currentMoney--;
            }
        }
        
        return lucky;
    }

}
