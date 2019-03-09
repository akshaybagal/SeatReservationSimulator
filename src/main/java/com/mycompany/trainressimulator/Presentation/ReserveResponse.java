/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trainressimulator.Presentation;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Akshay
 */
@XmlRootElement
public class ReserveResponse {
    
    @XmlElement
    MetaResponse meta = null;
    
    @XmlElement
    ReserveDataResponse data = null;
    
    public ReserveResponse(){}
    
    public ReserveResponse(int code, String status, String userID, String trainID, String coachID){
        meta = new MetaResponse(code, status);
        data = new ReserveDataResponse(userID, trainID, coachID);
    }
}
