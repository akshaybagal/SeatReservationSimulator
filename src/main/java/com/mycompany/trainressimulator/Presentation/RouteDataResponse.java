/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trainressimulator.Presentation;

import com.mycompany.trainressimulator.business.Route;
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
    
    public RouteDataResponse(Route routeObj){
        this.trainID = routeObj.getTrainID();
        this.route = routeObj.getRoute();
    }
    
}
