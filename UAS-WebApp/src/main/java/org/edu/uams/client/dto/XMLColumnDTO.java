/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.edu.uams.client.dto;


public class XMLColumnDTO {
  private String columnName;
  private String columnType;
  
  public XMLColumnDTO(String columnName, String columnType) {
    this.columnName = columnName;
    this.columnType = columnType;
  }

  public String getColumnName() {
    return this.columnName;
  }

  public String getColumnType() {
    return this.columnType;
  }
}
