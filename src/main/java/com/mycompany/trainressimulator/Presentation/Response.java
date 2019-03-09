/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trainressimulator.Presentation;

import com.mycompany.trainressimulator.Presentation.MetaResponse;
import com.mycompany.trainressimulator.Presentation.Train;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Akshay
 */
@XmlRootElement
public class Response {
    
    @XmlElement
    private MetaResponse meta = null;
    
    @XmlElement
    private DataResponse data = null;
    
    public Response(){}
    public Response(int code, String status, ArrayList<Train> trains,String s, String d){
        this.meta = new MetaResponse(code,status);
        this.data = new DataResponse(trains,s,d);
    }
}
