/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trainressimulator;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author Akshay
 */
public class RouteDataResponse {
    
    @XmlElement
    private String trainID = "";
    
    @XmlElement
    private ArrayList<RouteTrainRoute> route = null;
    
    public RouteDataResponse(){}
    
    public RouteDataResponse(String trainID, ArrayList<RouteTrainRoute> route){
        this.trainID = trainID;
        this.route = route;
    }
    
}
