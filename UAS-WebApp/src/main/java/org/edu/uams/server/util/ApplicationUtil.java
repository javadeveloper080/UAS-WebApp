/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.edu.uams.server.util;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.edu.uams.server.api.HasId;
import org.edu.uams.server.api.Type;

/**
 *
 * @author Pandu.Simbohtu
 */
public class ApplicationUtil {
    
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
}
