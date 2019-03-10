/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trainressimulator.Presentation;

import com.mycompany.trainressimulator.business.Reserve;
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
    
    public ReserveResponse(Reserve reserve){
        meta = new MetaResponse(reserve.getCode(),reserve.getStatus());
        data = new ReserveDataResponse(reserve);
    }
}
