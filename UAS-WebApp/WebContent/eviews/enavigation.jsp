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
                <a href="javascript:;" <c:if test="${requestScope.userModule != null}"> class="active"</c:if>>
                    <i class="fa fa-th"></i>
                    <span>User Module</span>
                </a>
                    
                <ul class="sub">
                    <li <c:if test="${requestScope.userTypePage != null}"> class="active"</c:if> ><a  href="typeTableAction.do?method=userTypePage">User Type</a></li>
                    <li <c:if test="${requestScope.usersPage != null}"> class="active"</c:if>><a  href="userAction.do?method=usersPage">Users</a></li>
                </ul>
            </li>
            
            <li class="sub-menu">
                 <a href="javascript:;" <c:if test="${requestScope.hostelModule != null}"> class="active"</c:if>>
                    <i class="fa fa-th"></i>
                    <span>Hostel</span>
                </a>
                    
                <ul class="sub">
                    <li <c:if test="${requestScope.hostelBlockPage != null}"> class="active"</c:if> ><a  href="typeTableAction.do?method=feeTypePage">Hostel Block</a></li>
                </ul>
                    
                    
                <ul class="sub">
                    <li <c:if test="${requestScope.hostelRoomsPage != null}"> class="active"</c:if> ><a  href="typeTableAction.do?method=feeTypePage">Hostel Rooms</a></li>
                </ul>
            </li>
            
            
             <li class="sub-menu">
                  <a href="javascript:;" <c:if test="${requestScope.transportModule != null}"> class="active"</c:if>>
                    <i class="fa fa-th"></i>
                    <span>Transport</span>
                </a>
                     
                <ul class="sub">
                    <li <c:if test="${requestScope.busFacultyPage != null}"> class="active"</c:if> ><a  href="transportModuleAction.do?method=busFacultyPage">Bus Faculty</a></li>
                </ul>
                
                 <ul class="sub">
                    <li <c:if test="${requestScope.busDetailsPage != null}"> class="active"</c:if> ><a  href="transportModuleAction.do?method=busDetailsPage">Bus Details</a></li>
                </ul>
                
                 <ul class="sub">
                    <li <c:if test="${requestScope.studentBusAccDetailsPage != null}"> class="active"</c:if> ><a  href="transportModuleAction.do?method=studentBusAccDetailsPage">Student Bus Acc</a></li>
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
                
            <li class="sub-menu">
                <a href="javascript:;"  <c:if test="${requestScope.studentModule != null}"> class="active"</c:if>>
                    <i class="fa fa-th"></i>
                    <span>Student</span>
                </a>

                <ul class="sub">
                    <li  <c:if test="${requestScope.studentDetails != null}"> class="active"</c:if> ><a  href="studentAction.do?method=studentPage">Student Details</a></li>
                </ul>
                <ul class="sub">
                    <li  <c:if test="${requestScope.studentAdd != null}"> class="active"</c:if> ><a  href="studentAddressAction.do?method=studentAdressPage">Student Address</a></li>
                </ul>
                <ul class="sub">
                    <li  <c:if test="${requestScope.studentFee != null}"> class="active"</c:if> ><a  href="studentFee.do">Student Fee</a></li>
                </ul>
                <ul class="sub">
                    <li  <c:if test="${requestScope.studentQlfDetails != null}"> class="active"</c:if> ><a  href="studentQlfAction.do?method=studentQualificationPage">Student Qualification</a></li>
                </ul>
            </li>
                
        </ul>
        <!-- sidebar menu end-->
    </div>
</aside>
   
