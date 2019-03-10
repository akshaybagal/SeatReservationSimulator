/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trainressimulator.business;

import com.mycompany.trainressimulator.Data.DAL;
import com.mycompany.trainressimulator.Presentation.ReserveResponse;

/**
 *
 * @author Akshay
 */

public class Reserve {
    
    private String userID = "";
    private String trainID = "";
    private String coachID = "";
    private int noOfSeats = 0;
    private String date = "";
    
    private int code = 0;
    private String status = "";
    
    
    public Reserve(){}
    
    public Reserve(String userID, String trainID, String coachID, String noOfSeats, String date){
        this.userID = userID;
        this.trainID = trainID;
        this.coachID = coachID;
        this.noOfSeats = Integer.parseInt(noOfSeats);
        this.date = date;
    }
    
    public String getUserID(){
        return this.userID;
    }
    
    public String getTrainID(){
        return this.trainID;
    }
    
    public String getCoachID(){
        return this.coachID;
    }
    
    public int getNoOfSeats(){
        return this.noOfSeats;
    }
    
    public String getDate(){
        return date;
    }
    
    public int getCode(){
        return this.code;
    }
    
    public String getStatus(){
        return this.status;
    }
    
    public void setUserID(String userID){
        this.userID = userID;
    }
    
    public void setTrainID(String trainID){
        this.trainID = trainID;
    }
    
    public void setNoOfSeats(int noOfSeats){
        this.noOfSeats = noOfSeats;
    }
    
    public void setDate(String date){
        this.date = date;
    }
    
    public void setCode(int code){
        this.code = code;
    }
    
    public void setStatus(String status){
        this.status = status;
    }
    
    public ReserveResponse reserveSeats(){
        DAL dal = new DAL();
        ReserveResponse response;
        if(dal.reserveSeats(this) == 0){
            this.code = 200;
            this.status = "OK";
        }
        else{
            this.code =  500;
            this.status = "Error";
        }
        response = new ReserveResponse(this);
        return response;
    }
}
