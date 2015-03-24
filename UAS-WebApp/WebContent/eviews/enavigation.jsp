<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<aside>
    <div id="sidebar"  class="nav-collapse ">
        <!-- sidebar menu start-->
        <ul class="sidebar-menu" id="nav-accordion">
            
            <p class="centered"><a href="profile.html"><img src="assets/img/ui-sam.jpg" class="img-circle" width="60"></a></p>
                
                
              <h5 class="centered"><bean:write name="loginForm" property="name" /></h5>   
                
                
                
                
            <li class="sub-menu">
                <a href="javascript:;" <c:if test="${requestScope.feeModule != null}"> class="active"</c:if>>
                    <i class="fa fa-th"></i>
                    <span>Fee Module</span>
                </a>
                    
                <ul class="sub">
                    <li <c:if test="${requestScope.feeTypePage != null}"> class="active"</c:if> ><a  href="typeTableAction.do?method=feeTypePage">Fee Type</a></li>
                    <li <c:if test="${requestScope.feeCategoryTypePage != null}"> class="active"</c:if>><a  href="typeTableAction.do?method=feeCategoryTypePage">Fee Category Type</a></li>
                </ul>
            </li>
            
            
            <li class="sub-menu">
                <a href="javascript:;"  >
                    <i class="fa fa-th"></i>
                    <span>Hostel</span>
                </a>
                    
                <ul class="sub">
                    <li ><a  href="typeTableAction.do?method=feeTypePage">Hostel Type</a></li>
                </ul>
            </li>
            
            
             <li class="sub-menu">
                <a href="javascript:;"  >
                    <i class="fa fa-th"></i>
                    <span>Transport</span>
                </a>
                    
                <ul class="sub">
                    <li ><a  href="typeTableAction.do?method=feeTypePage">Transport Type</a></li>
                </ul>
            </li>
            
            
             <li class="sub-menu">
               <a href="javascript:;" <c:if test="${requestScope.courseModule != null}"> class="active"</c:if>>
                    <i class="fa fa-th"></i>
                    <span>Courses</span>
                </a>
                    
                <ul class="sub">
                    <li <c:if test="${requestScope.degreeTypePage != null}"> class="active"</c:if> ><a  href="typeTableAction.do?method=degreeTypePage">Degree Type</a></li>
                </ul>
                
                 <ul class="sub">
                    <li <c:if test="${requestScope.courseTypePage != null}"> class="active"</c:if> ><a  href="typeTableAction.do?method=courseTypePage">Course Type</a></li>
                </ul>
            </li>
            
            
              <li class="sub-menu">
                <a href="javascript:;"  >
                    <i class="fa fa-th"></i>
                    <span>Employee</span>
                </a>
                    
                <ul class="sub">
                    <li ><a  href="typeTableAction.do?method=feeTypePage">Employee Profiles</a></li>
                </ul>
            </li>
                
                
                
        </ul>
        <!-- sidebar menu end-->
    </div>
</aside>
   
