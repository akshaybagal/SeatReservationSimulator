/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trainressimulator.business;

import com.mycompany.trainressimulator.DAL.DAL;
import com.mycompany.trainressimulator.Presentation.RouteResponse;
import com.mycompany.trainressimulator.Presentation.RouteTrainRoute;
import java.util.ArrayList;

/**
 *
 * @author Akshay
 */
public class Route {
    private String trainID = "";
    private ArrayList<RouteTrainRoute> route = null;
    public Route(){}
    
    public Route(String trainID){
        this.trainID = trainID;
    }
    
    public RouteResponse getResponse(){
         DAL dal = new DAL();
         route = dal.getRouteResponseFromDB(this.trainID);
         RouteResponse r = prepareResponse();
         return r;
    }
    
    public RouteResponse prepareResponse(){
        RouteResponse rsp = null;
        if(this.route != null){
            rsp = new RouteResponse(200, "OK",this.trainID, this.route);
        }
        else{
            rsp = new RouteResponse(500,"Error",this.trainID,null);
        }
        return rsp;
    }
}
