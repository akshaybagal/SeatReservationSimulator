/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trainressimulator.Presentation;

import com.mycompany.trainressimulator.business.Reserve;
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
    
    public ReserveDataResponse(Reserve reserve){
        this.userID = reserve.getUserID();
        this.trainID = reserve.getTrainID();
        this.coachID = reserve.getCoachID();
    }
}
