/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.edu.uams.server.util;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.edu.uams.server.api.HasId;

/**
 *
 * @author Pandu.Simbohtu
 */
public class ApplicationUtil {
    
    public static final DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    
    public static void checkUniqueCodeHelper(HasId typeEntity, Long key, HttpServletResponse response) throws IOException {
        if (typeEntity!=null) {
            Long pkKey= typeEntity.getId();
            if (key!=null && key>0 && pkKey.equals(key)) {
                response.getWriter().write("false");
            }else{
                response.getWriter().write("true");
            }
        }else{
            response.getWriter().write("false");
        }
    }
    
    
    public static  Date formatStringToDate(String strDate){
        
        Date date = null;
        if (strDate==null || strDate.isEmpty()) {
            return date;
        }
        try {
            //02-17-2015
            date = dateFormat.parse(strDate);
        } catch (ParseException e) {
          e.printStackTrace();
        }
        return date;
    }
    
    public static  String formatDateToString(Date date){
        
        String strDate = null;
        if (date==null) {
            return strDate;
        }
        strDate = dateFormat.format(date);
        return strDate;
    }
}
