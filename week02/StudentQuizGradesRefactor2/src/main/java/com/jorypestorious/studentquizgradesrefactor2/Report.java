package com.jorypestorious.studentquizgradesrefactor2;

import java.util.HashMap;

public class Report {
    HashMap<String, String> chosenStudents;
    String title;
    int count;
    int outOf;

    Report (HashMap<String, String> chosenStudents, String title, int count, int outOf) {
        this.chosenStudents = chosenStudents;
        this.title = title;
        this.count = count;
        this.outOf = outOf;
    }
}
