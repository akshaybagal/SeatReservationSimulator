/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trainressimulator.business;

import com.mycompany.trainressimulator.DAL.DAL;
import com.mycompany.trainressimulator.Presentation.Response;
import com.mycompany.trainressimulator.Presentation.Train;
import java.util.ArrayList;
import java.util.Set;

/**
 *
 * @author Akshay
 */
public class Search {
    private String srcStation = "";
    private String destStation = "";
    private String date = "";
    private String userId = "";
    private String orig = "";
    private ArrayList<Train> trains = null;
    
    public Search(String srcStation, String destStation, String date){
        this.srcStation = srcStation;
        this.destStation = destStation;
        this.date = date;
    }
    
    public Response getResponse(){
        Response r = null;
        DAL dal = new DAL();
        this.trains = dal.getResponseFromDB(this.srcStation, this.destStation, this.date);
        r = prepareResponse();
        return r;
    }
    
    public Response prepareResponse(){
        Response rsp = null;
        if(this.trains != null){
            rsp = new Response(200,"OK",this.trains,this.srcStation,this.destStation);
        }
        else{
            rsp = new Response(500,"Error",null,this.srcStation,this.destStation);
        }
        return rsp;
    }
}
