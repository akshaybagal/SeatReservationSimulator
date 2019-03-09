/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trainressimulator.Presentation;

/**
 *
 * @author Akshay
 */
public class RouteTrainRoute {
    public int stationNoFromSource = 0;
    public String stationID = "";
    public double distance = 0.0;
    public String arrivalTime = "";
    public String departureTime = "";
    
    public RouteTrainRoute(){}
    
    public RouteTrainRoute(int stationNoFromSource, String stationID,double distance, String arrivalTime, String departureTime){
    
        this.stationNoFromSource = stationNoFromSource;
        this.stationID = stationID;
        this.distance = distance;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        
    }
}
