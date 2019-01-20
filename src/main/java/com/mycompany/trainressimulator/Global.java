/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trainressimulator;

/**
 *
 * @author Akshay
 */
public class Global {
    private static String DB_URL = "jdbc:sqlserver://localhost;servername=DESKTOP-HFD38AQ\\SQLEXPRESS;databaseName=RES_SIMULATOR;integratedSecurity=true";
    private static String APP_BASE_URL = "http://localhost:8080/TrainResSimulator/webresources/";
    
    public static String getDBURL(){
        return DB_URL;
    }
    
    public static synchronized String getRouteURL(String trainID){
            StringBuilder sb = new StringBuilder();
            sb.append(APP_BASE_URL);
            sb.append("route/");
            sb.append(trainID);
            return sb.toString();
    }
}
