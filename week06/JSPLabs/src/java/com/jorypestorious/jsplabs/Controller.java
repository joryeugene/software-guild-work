package com.jorypestorious.jsplabs;

import com.jorypestorious.jsplabs.dto.FactorizorReport;
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
    
    public static FactorizorReport factorize(FactorizorReport num) {
        int inputNum = num.getNum(),
            sum = 0;
        
        for (int i = 1; i <= inputNum/2; i++) {
            if (inputNum % i == 0) {
                num.addFactor(i);
                sum += i;
            }
        }
        
        if (inputNum == sum) num.setPerfect(true);
        
        if (inputNum + sum == inputNum + 1) num.setPrime(true);
        
        return num;
    }

}
