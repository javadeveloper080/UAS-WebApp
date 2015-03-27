package org.edu.uams.server.business;

import java.util.ArrayList;
import java.util.List;
import org.edu.uams.server.api.FacultyType;
import org.edu.uams.server.pojo.BusFacultyEntity;


public class BusFacultyDao extends AbstractDao<BusFacultyEntity> {
    
    public BusFacultyDao() {
        super(BusFacultyEntity.class);
    }
    
    
    @Override
    public List<BusFacultyEntity> findAll() {
        return super.findListByQuery(BusFacultyEntity.FIND_ALL, null);
    }
    
    public List<BusFacultyEntity> findUnAssignedFaculty() {
        return super.findListByQuery(BusFacultyEntity.FIND_UN_ASSIGNED_FACULTY, null);
    }
    
    
    public List<BusFacultyEntity> findUnAssignedDrivers() {
        List<BusFacultyEntity> busFacultyEntityList=new ArrayList<>();
        
        List<BusFacultyEntity> unAssignedFacultyList=this.findUnAssignedFaculty();
        if (unAssignedFacultyList!=null && !unAssignedFacultyList.isEmpty()) {
            for (BusFacultyEntity busFacultyEntity : busFacultyEntityList) {
                  if (busFacultyEntity.getFacultyType().equals(FacultyType.DRIVER)) {
                    busFacultyEntityList.add(busFacultyEntity);
                }
            }
        }
        
        return busFacultyEntityList;
    }
    
    
    
    public List<BusFacultyEntity> findUnAssignedCleaners() {
        List<BusFacultyEntity> busFacultyEntityList=new ArrayList<>();
        
        List<BusFacultyEntity> unAssignedFacultyList=this.findUnAssignedFaculty();
        if (unAssignedFacultyList!=null && !unAssignedFacultyList.isEmpty()) {
            for (BusFacultyEntity busFacultyEntity : busFacultyEntityList) {
                if (busFacultyEntity.getFacultyType().equals(FacultyType.CLEANER)) {
                    busFacultyEntityList.add(busFacultyEntity);
                }
            }
        }
        return busFacultyEntityList;
    }
    
    
}
