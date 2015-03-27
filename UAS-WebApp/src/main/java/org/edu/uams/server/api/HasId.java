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
public interface HasId extends Serializable{
    
    public long getId();
    
    public void setId(long id);
    
}
