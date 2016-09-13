package com.jorypestorious.pbd.variables;

public class VariablesAndNames {
    public static void main(String[] args) {
        int cars, drivers, passengers, cars_not_driven, cars_driven;
        double space_in_a_car, carpool_capacity, average_passengers_per_car;

        // assigning 100 to the int variable cars
        cars = 100;
        // assigning 4 to this double variable... will come out as 4.0 regardless
        space_in_a_car = 4;
        // assigning 30 to this int variable
        drivers = 30;
        // assigning 90 to this int variable
        passengers = 90;
        // 100 - 30
        cars_not_driven = cars - drivers;
        // 30
        cars_driven = drivers;
        // 30 * 4
        carpool_capacity = cars_driven * space_in_a_car;
        // 90 / 30 
        average_passengers_per_car = passengers / cars_driven;


        System.out.println( "There are " + cars + " cars available." );
        System.out.println( "There are only " + drivers + " drivers available." );
        System.out.println( "There will be " + cars_not_driven + " empty cars today." );
        System.out.println( "We can transport " + carpool_capacity + " people today." );
        System.out.println( "We have " + passengers + " to carpool today." );
        System.out.println( "We need to put about " + average_passengers_per_car + " in each car." );
    }
}
