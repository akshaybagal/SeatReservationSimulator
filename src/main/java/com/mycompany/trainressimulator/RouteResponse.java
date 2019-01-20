/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trainressimulator;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Akshay
 */
@XmlRootElement
public class RouteResponse {
    
    @XmlElement
    public MetaResponse meta = null;
    
    @XmlElement
    public RouteDataResponse data = null;
    
    public RouteResponse(){}
    
    public RouteResponse(int code, String status,String trainID, ArrayList<RouteTrainRoute> route){
        meta = new MetaResponse(code, status);
        data = new RouteDataResponse(trainID, route);
    
    }
    
    
}
