/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package org.edu.uams.server.api;

import java.io.Serializable;

/**
 *
 * @author Mohammed.Tauseef
 */
public interface Type extends Serializable{
    
    public long getId();
    
    public void setId(long id);
    
    public String getCode() ;
    
    public void setCode(String code);
    
    public String getDescription();
    
    public void setDescription(String description);
    
}
