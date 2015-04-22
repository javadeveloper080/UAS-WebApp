/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package org.edu.uams.client.form;


import java.util.List;
import org.edu.uams.server.pojo.*;
import org.apache.struts.action.ActionForm;


/**
 *
 * @author Mohammed.Tauseef
 */
public class HostelRoomDetailsForm  extends ActionForm{

    private long id;
    
    private String pageName;
    
    private String roomName;
    
    private String roomType;
    
    
    private String roomImage;
    
    private String roomDescription;
    
    private double roomPrice;
    
    private List<HostelRoomDetailsEntity> roomDetailsEntitys;
    
    private List<HostelBlockEntity> blockEntitys;
    
    private Long hBlockId;
    
    private String hblockName;
    
    private Integer roomCapacity;

    public String getHblockName() {
        return hblockName;
    }

    public void setHblockName(String hblockName) {
        this.hblockName = hblockName;
    }

    
    public Integer getRoomCapacity() {
        return roomCapacity;
    }

    public void setRoomCapacity(Integer roomCapacity) {
        this.roomCapacity = roomCapacity;
    }

    
    public long getId() {
        return id;
    }

    public List<HostelBlockEntity> getBlockEntitys() {
        return blockEntitys;
    }

    public void setBlockEntitys(List<HostelBlockEntity> blockEntitys) {
        this.blockEntitys = blockEntitys;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getRoomImage() {
        return roomImage;
    }

    public void setRoomImage(String roomImage) {
        this.roomImage = roomImage;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public void setRoomDescription(String roomDescription) {
        this.roomDescription = roomDescription;
    }

    public double getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(double roomPrice) {
        this.roomPrice = roomPrice;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public List<HostelRoomDetailsEntity> getRoomDetailsEntitys() {
        return roomDetailsEntitys;
    }

    public void setRoomDetailsEntitys(List<HostelRoomDetailsEntity> roomDetailsEntitys) {
        this.roomDetailsEntitys = roomDetailsEntitys;
    }

    public Long gethBlockId() {
        return hBlockId;
    }

    public void sethBlockId(Long hBlockId) {
        this.hBlockId = hBlockId;
    }

    public void resetForm() {
        this.id = 0;
        this.pageName = "";
        this.roomName = "";
        this.roomType = "";
        this.roomImage = "";
        this.roomDescription = "";
        this.roomPrice = 0.0;
        this.roomDetailsEntitys = null;
        this.blockEntitys = null;
        this.hBlockId = 0l;
        this.hblockName = "";
        this.roomCapacity = 0;
    }
    
}