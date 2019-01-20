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
public class DataResponse {
    
    @XmlElement
    private String s = "";
    
    @XmlElement
    private String d = "";
    
    @XmlElement
    private ArrayList<Train> trainList= null;
    
    public DataResponse(){}
    
    public DataResponse(ArrayList<Train> t, String s, String d){
        this.trainList = t;
        this.s = s;
        this.d = d;
    }
}
