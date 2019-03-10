/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trainressimulator.Presentation;

import com.mycompany.trainressimulator.Presentation.MetaResponse;
import com.mycompany.trainressimulator.business.Route;
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
    
    public RouteResponse(Route routeObj){
        meta = new MetaResponse(routeObj.getCode(), routeObj.getStatus());
        data = new RouteDataResponse(routeObj);
    }
    
    
}
