/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.trainressimulator.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
//import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.mycompany.trainressimulator.Presentation.Coach;
import com.mycompany.trainressimulator.Global;
import com.mycompany.trainressimulator.Presentation.RouteTrainRoute;
import com.mycompany.trainressimulator.Presentation.Train;
import com.mycompany.trainressimulator.business.Reserve;
import com.mycompany.trainressimulator.business.Route;
import java.sql.CallableStatement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
/**
 *
 * @author Akshay
 */
public class DAL {
    
    public DAL(){}
    
    public ArrayList<Train> getResponseFromDB(String srcStation, String destStation, String date){
        ResultSet rs = null;
        ArrayList<Train> trains = null;
        Set<String> set = null;
        boolean flag =false;
        
        try(Connection conn = DriverManager.getConnection(Global.getDBURL())){
            
            String query = "{ call SAS_SEARCH_TRAINLIST(?,?)}";
            CallableStatement cstmt = conn.prepareCall(query);
            cstmt.setString("SRC_STATION", srcStation);
            cstmt.setString("DST_STATION", destStation);
            flag = cstmt.execute();
            if(flag == true){
                rs = cstmt.getResultSet();
                trains = new ArrayList<Train>();
                set = new LinkedHashSet<String>();
                Train t = null;
                Coach c = null;
                int cnt = 0;
                if(rs != null){
                    while(rs.next()){
                        if(set.add(rs.getString("TRAIN_ID"))){
                            t = new Train();
                            t.trainID = rs.getString("TRAIN_ID");
                            t.trainRouteURL = Global.getRouteURL(t.trainID);
                            t.trainNo = rs.getString("TRAIN_NO");
                            t.trainName = rs.getString("TRAIN_NAME");
                            t.trainSrcName = rs.getString("TRAIN_SOURCE_NAME");
                            t.trainDestName = rs.getString("TRAIN_DEST_NAME");
                            t.startTime = rs.getString("DEPARTURE_TIME");
                            t.endTime = rs.getString("ARRIVAL_TIME");
                            t.distance = rs.getDouble("DISTANCE");
                            trains.add(t);
                            cnt++;
                        }
                        c = new Coach();
                        c.coachId = rs.getString("COACH_ID");
                        c.coachName = rs.getString("COACH_NAME");
                        c.coachCapacity = rs.getInt("COACH_CAPACITY");
                        c.fare = rs.getDouble("FARE");
                        Train tmp = trains.get(cnt-1);
                        if(tmp!=null)
                            tmp.coach.add(c);
                    }
                }
            }
        }catch(Exception e){
            trains = null;
            //Log the Exception.
        }
        return trains;
    }
    
    public int getRouteResponseFromDB(Route routeObj){
        int statusCode = -1;
        ArrayList<RouteTrainRoute> route = new ArrayList<RouteTrainRoute>();
        RouteTrainRoute tRoute = null;
        try(Connection conn = DriverManager.getConnection(Global.getDBURL())){
            
            String query = "{ call SAS_GET_TRAIN_ROUTE(?)}";
            CallableStatement cstmt = conn.prepareCall(query);
            cstmt.setString("TRAIN_ID", routeObj.getTrainID());
            if(cstmt.execute()){
                ResultSet result = cstmt.getResultSet();
                if(result != null){
                    while(result.next()){
                        tRoute = new RouteTrainRoute(
                                result.getInt("STATION_NO_FROM_SOURCE"),
                                result.getString("STATION_ID"),
                                result.getDouble("DISTANCE"),
                                result.getString("ARRIVAL_TIME"),
                                result.getString("DEPARTURE_TIME")
                        );
                        route.add(tRoute);
                        statusCode = 0;
                    }
                }
            }
        }catch(Exception e){
            statusCode = -1;
        }
        routeObj.setRoute(route);
        return statusCode;
    }
    
    public int reserveSeats(Reserve data){
        int statusCode = -1;
        boolean flag = false;
               
        try(Connection conn = DriverManager.getConnection(Global.getDBURL())){
            String query = "{ call SAS_RESERVE_SEATS(?,?,?,?,?)}";
            CallableStatement cs = conn.prepareCall(query);
            cs.setString("USER_ID", data.getUserID());
            cs.setString("TRAIN_ID", data.getTrainID());
            cs.setString("COACH_ID", data.getCoachID());
            cs.setInt("NO_OF_SEATS", data.getNoOfSeats());
            cs.setString("DATE", data.getDate());
            flag = cs.execute();
            if(flag == true){
                ResultSet rs = cs.getResultSet();
                if(rs != null){
                    while(rs.next()){
                        statusCode = rs.getInt("RESULT");
                    }
                }
            }
        }catch(Exception e)
        {
            // Log the exception
            statusCode = -1;
        }
        return statusCode;
    }
}
