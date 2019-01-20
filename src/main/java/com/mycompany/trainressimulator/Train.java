/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trainressimulator;

import java.util.ArrayList;

/**
 *
 * @author Akshay
 */
public class Train {
    
    public String trainID = "";
    public String trainNo = "";
    public String trainRouteURL = "";
    public String trainName = "";
    public String trainSrcId = "";
    public String trainDestId = "";
    public double distance = 0;
    public String trainSrcName = "";
    public String trainDestName = "";
    public String trainType = "";
    public String trainDivision = "";
    public String startTime = "";
    public String endTime = "";
    public ArrayList<Coach> coach = new ArrayList<Coach>();
}
