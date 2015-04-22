/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package org.edu.uams.server.pojo;


import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 *
 * @author Mohammed.Tauseef
 */
@Entity(name = "HosteRoomDetails")
@Table(name = "hostel_room_details")
public class HostelRoomDetailsEntity  implements Serializable {
    private static final long serialVersionUID = 1L;
    
    
    public static final  String FIND_ALL = "SELECT hrd FROM HosteRoomDetails hrd";
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;
    
    @Column(name = "room_name", nullable = false, length = 100)
    private String roomName;
    
    @Column(name = "room_type", nullable = false, length = 100)
    private String roomType;
    
    @Column(name = "room_capacity")
    private Integer roomCapacity;
    
    @Basic(optional = false)
    @Column(name = "room_image")
    private String roomImage;
    
    @Basic(optional = true)
    @Column(name = "room_description")
    private String roomDescription;
    
    @Basic(optional = true)
    @Column(name = "room_price",nullable = false)
    private double roomPrice;
    
    @JoinColumn(name = "hostel_block_id",referencedColumnName = "id")
    @ManyToOne(optional = false)
    private HostelBlockEntity blockEntity;

    public Integer getRoomCapacity() {
        return roomCapacity;
    }

    public void setRoomCapacity(Integer roomCapacity) {
        this.roomCapacity = roomCapacity;
    }
    
    public long getId() {
        return id;
    }

    public HostelBlockEntity getBlockEntity() {
        return blockEntity;
    }

    public void setBlockEntity(HostelBlockEntity blockEntity) {
        this.blockEntity = blockEntity;
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
    
    
    
}