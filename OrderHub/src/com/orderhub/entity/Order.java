package com.orderhub.entity;

public class Order {

    private int UserID;
    private int OrderID;
    private String orderType;
    private String Symbol;
    private String BoS; //buy or sell
    private int Status; //1 for processing ; 2 for matched ;3 for canceled
    private int Qty;
    private Double Price;
    //optional
    private int FOK; //because mysql does not support boolean we use 0 for false,1 for true

    // Status are default 1 for processing
    //price,FOK are optional so we have 4 constructors
    public Order(int userID, String orderType,String symbol, String boS, int qty) {
        UserID = userID;
        this.orderType = orderType;
        Symbol=symbol;
        BoS = boS;
        Qty = qty;
        Status=1;
        Price = null;
        FOK=0;
    }

    public Order(int userID, String orderType,String symbol, String boS, int qty, Double price) {
        UserID = userID;
        this.orderType = orderType;
        Symbol=symbol;
        BoS = boS;
        Qty = qty;
        Price = price;
        Status =1;
        FOK = 0;
    }

    public Order(int userID, String orderType,String symbol, String boS, int qty, int FOK) {
        UserID = userID;
        this.orderType = orderType;
        Symbol=symbol;
        BoS = boS;
        Qty = qty;
        this.FOK = FOK;
        Status = 1;
        Price =null;
    }

    public Order(int userID, String orderType,String symbol, String boS, int qty, Double price, int FOK) {
        UserID = userID;
        this.orderType = orderType;
        Symbol=symbol;
        BoS = boS;
        Qty = qty;
        Price = price;
        this.FOK = FOK;
        Status=1;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int orderID) {
        OrderID = orderID;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getSymbol() {
        return Symbol;
    }

    public void setSymbol(String symbol) {
        Symbol = symbol;
    }

    public String getBoS() {
        return BoS;
    }

    public void setBoS(String boS) {
        BoS = boS;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public int getQty() {
        return Qty;
    }

    public void setQty(int qty) {
        Qty = qty;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }

    public int getFOK() {
        return FOK;
    }

    public void setFOK(int FOK) {
        this.FOK = FOK;
    }

    public String getOrderTableName(){
        if(this.getBoS()=="BUY")
            return "bidorders";
        else
            return "aksorders";
    }
}
