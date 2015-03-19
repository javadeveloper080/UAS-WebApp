 /**
  *
  */
package org.edu.uams.client.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;


public class TypeTableAction extends DispatchAction {
    
    
    
    
    public ActionForward feeTypePage(ActionMapping mapping,ActionForm form,HttpServletRequest req,
            HttpServletResponse res)throws Exception
    {
        
        return mapping.findForward("feeTypePage");
    }
    
    
    
    
}












