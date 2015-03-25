/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.org.edu.uams.client.action;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import main.java.org.edu.uams.client.dto.DataDTO;
import main.java.org.edu.uams.client.dto.UserDTO;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author SARAT
 */
public class JSONDataAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        UserDTO fromUI = new UserDTO();
        fromUI.setCustomerID(request.getParameter("customerID"));
        fromUI.setId(request.getParameter("customerID"));
        fromUI.setCompanyName(request.getParameter("companyName"));
        fromUI.setPhone(request.getParameter("phone"));
        fromUI.setPostalCode(request.getParameter("postalCode"));
        fromUI.setCity(request.getParameter("city"));
        
        UserDTO user = new UserDTO();
        user.setCustomerID("ALFKI");
        user.setCompanyName("Alfreds Futterkiste");
        user.setPhone("030-0074321");
        user.setPostalCode("12209");
        user.setCity("Berlin");
        
        List<UserDTO> list =new ArrayList<UserDTO>();
        if (request.getParameter("oper") == null) {
            list.add(user);
            list.add(user);
            list.add(user);
            list.add(user);
            
        }else{
            list.add(fromUI);
        }
        DataDTO dTO =new DataDTO();
        dTO.setRows(list);
        if(request.getParameter("oper")!=null && request.getParameter("oper").equals("add")){
            dTO.setOper("add");
        }
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json");
        mapper.writeValue(response.getWriter(), dTO);
        
        return null;
    }
}
