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
    
    private String trainID = "";
    private String coachID = "";
    private int noOfSeats = 0;
    private String date = "";
    private String userID = "";
    
    public Reserve(){}
    
    public Reserve(String userID, String trainID, String coachID, String noOfSeats, String date){
        this.userID = userID;
        this.trainID = trainID;
        this.coachID = coachID;
        this.noOfSeats = Integer.parseInt(noOfSeats);
        this.date = date;
    }
    
    public ReserveResponse reserveSeats(){
        DAL dal = new DAL();
        if(dal.reserveSeats(this.userID, this.trainID, this.coachID, this.noOfSeats, this.date) == 0){
            return new ReserveResponse(200,"OK",this.userID, this.trainID, this.coachID);
        }
        return new ReserveResponse(500,"Error","", "", "");
    }
}
