/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trainressimulator.business;

import com.mycompany.trainressimulator.Data.DAL;
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
    
    private int code = 0;
    private String  status = "";
        
    public Route(){}
    
    public Route(String trainID){
        this.trainID = trainID;
    }
    
    public String getTrainID(){
        return this.trainID;
    }
    
    public ArrayList<RouteTrainRoute> getRoute(){
        return this.route;
    }
    
    public int getCode(){
        return this.code;
    }
    
    public String getStatus(){
        return this.status;
    }
    
    public void setTrainID(String trainID){
        this.trainID = trainID;
    }
    
    public void setRoute(ArrayList<RouteTrainRoute> route){
        this.route = route;
    }
    
    public void setCode(int code){
        this.code = code;
    }
    
    public void setStatus(String status){
        this.status = status;
    }
    
    public RouteResponse getResponse(){
         DAL dal = new DAL();
         if(dal.getRouteResponseFromDB(this)==0){
             this.code = 200;
             this.status = "OK";
         }
         else{
             this.code = 500;
             this.status = "Error";
         }
         RouteResponse r = new RouteResponse(this);
         return r;
    }
    
}
