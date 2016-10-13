package com.jorypestorious.floormastery.dto;

import java.text.DecimalFormat;

public class Order {
    
    private final DecimalFormat dpercent = new DecimalFormat("##0.00%");
    private final DecimalFormat df = new DecimalFormat("##0.00");
    
    private final int orderNumber;
    private String customer;
    private TaxRate taxRate;
    private Product productType;
    private double area;
    
    private double materialCost;
    private double laborCost;
    private double taxCost;
    private double totalCost;

    public Order (int orderNumber, String customer, TaxRate taxRate, Product productType, double area) {
        this.orderNumber = orderNumber;
        this.customer = customer;
        this.taxRate = taxRate;
        this.productType = productType;
        this.area = area;
        
    }
    
    public int getOrderNumber() {
        return orderNumber;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public TaxRate getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(TaxRate taxRate) {
        this.taxRate = taxRate;
    }

    public Product getProductType() {
        return productType;
    }

    public void setProductType(Product productType) {
        this.productType = productType;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getMaterialCost() {
        materialCost = area * productType.getMaterialCostPerSquareFoot();
        return materialCost;
    }

    public double getLaborCost() {
        laborCost = area * productType.getLaborCostPerSquareFoot();
        return laborCost;
    }

    public double getTaxCost() {
        taxCost = ( getMaterialCost() + getLaborCost() ) * taxRate.getTaxRate();
        return taxCost;
    }

    public double getTotalCost() {
        totalCost = getTaxCost() + getMaterialCost() + getLaborCost();
        return totalCost;
    }
    
    private String getTaxRatePercentage() {
        return dpercent.format(taxRate.getTaxRate());
    }
    
    @Override
    public String toString() {
        return "Order# " + orderNumber + " - " + customer + " (" + taxRate.getStateCode() + " " + getTaxRatePercentage() + ") " + 
                productType.getType() + " : " + df.format(area) + "ft²" + "\n" +
                "(Cost per ft²: $" + productType.getMaterialCostPerSquareFoot() + " | Labor Cost per ft²: $" + productType.getLaborCostPerSquareFoot() + ")\n" +
                "Material Cost: $" + df.format(getMaterialCost()) + ", Labor Cost: $ " + df.format(getLaborCost()) + "\n" +
                "Tax: $" + df.format(getTaxCost()) + "\n" +
                "Total: $" + df.format(getTotalCost());
    }
    
    public String writeToFile() {
        return orderNumber + "," + customer + "," + taxRate.getStateCode() + "," + (taxRate.getTaxRate() * 100) + "," + 
                productType.getType() + "," + df.format(area) + "," + productType.getMaterialCostPerSquareFoot() + "," + 
                productType.getLaborCostPerSquareFoot() + "," + df.format(getMaterialCost()) + "," + df.format(getLaborCost()) + "," + 
                df.format(getTaxCost()) + "," + df.format(getTotalCost());
    }
       
}
