package com.jorypestorious.hangman;

import com.jorypestorious.hangman.controller.Controller;
import com.jorypestorious.hangman.dao.DAO;

public class Runner {
    public static void main(String[] args) throws InterruptedException {
        new Controller(new DAO()).run();
    }
}
