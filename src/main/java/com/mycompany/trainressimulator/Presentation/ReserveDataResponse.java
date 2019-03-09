/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trainressimulator.Presentation;

import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author Akshay
 */
public class ReserveDataResponse {
    
    @XmlElement
    public String userID = "";
    
    @XmlElement
    public String trainID = "";
    
    @XmlElement
    public String coachID = "";
    public ReserveDataResponse(){}
    
    public ReserveDataResponse(String userID, String trainID, String coachID){
        this.userID = trainID;
        this.trainID = trainID;
        this.coachID = coachID;
    }
}
