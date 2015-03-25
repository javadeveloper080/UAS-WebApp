/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.org.edu.uams.client.dto;

import java.util.List;

/**
 *
 * @author SARAT
 */
public class DataDTO {
    private List<UserDTO> rows;
    private String oper;

    public List<UserDTO> getRows() {
        return rows;
    }

    public void setRows(List<UserDTO> rows) {
        this.rows = rows;
    }

    public String getOper() {
        return oper;
    }

    public void setOper(String oper) {
        this.oper = oper;
    }
    
    
}
