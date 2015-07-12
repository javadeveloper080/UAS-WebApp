package org.edu.uams.server.business;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.edu.uams.client.dto.MergeDataSourceDTO;
import org.edu.uams.server.pojo.LetterTemplateEntity;
import org.edu.uams.server.pojo.StudentAddressEntity;
import org.edu.uams.server.pojo.StudentEntity;
import org.edu.uams.server.util.MailMergeHelperBean;
import org.hibernate.Query;


public class LetterTemplateDao extends AbstractDao<LetterTemplateEntity> {
    
    public LetterTemplateDao() {
        super(LetterTemplateEntity.class);
    }
    
    @Override
    public List<LetterTemplateEntity> findAll() {
        return super.findListByQuery(LetterTemplateEntity.FIND_ALL, null);
    }
    
    public LetterTemplateEntity findByCode(String code) {
        Map<String, Object> parmas=new LinkedHashMap<String, Object>();
        parmas.put("code", code);
        return super.findByQuery(LetterTemplateEntity.FIND_BY_CODE, parmas);
    }
    
    
    public void processBatchLetters(LetterTemplateEntity letterTemplateEntity, List<String> list) {
        System.out.println("tauseef"+list);
        
        
    	Query studentQuery = session.createQuery(StudentAddressEntity.FIND_STUDENTS_ADDRESS_ROLL_NUMBERS);
    	studentQuery.setParameterList("rollNumbers", list);
		List studentAddressList = studentQuery.list();
		
		MailMergeHelperBean mailMergeHelperBean=new MailMergeHelperBean();
		
		List<MergeDataSourceDTO> mergeDataSourceDTOList=new ArrayList<>();
		
		if (studentAddressList!=null && !studentAddressList.isEmpty()) {
			for (Object object : studentAddressList) {
				StudentAddressEntity studentAddressEntity=(StudentAddressEntity)object;
				StudentEntity student=studentAddressEntity.getStudent();
				MergeDataSourceDTO mergeDataSourceDTO=new MergeDataSourceDTO(student.getRollNum(), student.getLastName()+","+student.getFirstName(),
						studentAddressEntity.getAddrLine1(),studentAddressEntity.getAddrLine2(), studentAddressEntity.getAddrLine3(),
						studentAddressEntity.getAddrLine4(), studentAddressEntity.getCity(), studentAddressEntity.getStateName(),
						studentAddressEntity.getZipCode(), studentAddressEntity.getCountry(), student.getStudentMob(),
						student.getEmail(), student.getFirstName(),student.getLastName());
				mergeDataSourceDTOList.add(mergeDataSourceDTO);
			}
			
		}
		
		try {
			mailMergeHelperBean.createMergeLetters(mergeDataSourceDTOList,letterTemplateEntity);
		} catch (Exception e) {
			e.printStackTrace();
		}
		

        
        
        
    }
    
}