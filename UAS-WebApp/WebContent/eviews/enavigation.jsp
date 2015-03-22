<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<aside>
    <div id="sidebar"  class="nav-collapse ">
        <!-- sidebar menu start-->
        <ul class="sidebar-menu" id="nav-accordion">
            
            <p class="centered"><a href="profile.html"><img src="assets/img/ui-sam.jpg" class="img-circle" width="60"></a></p>
                
                
              <h5 class="centered"><bean:write name="loginForm" property="name" /></h5>   
                
                
                
                
            <li class="sub-menu">
                <a href="javascript:;"  id="FeeModuleNav">
                    <i class="fa fa-th"></i>
                    <span>Fee Module</span>
                </a>
                    
                <ul class="sub">
                    <li id="FeeTypeNav"><a  href="typeTableAction.do?method=feeTypePage" onclick="highlightNavTree('FeeType');" >Fee Type</a></li>
                    <li><a  href="typeTableAction.do?method=feeCategoryTypePage">Fee Category Type</a></li>
                </ul>
            </li>
            
            
            <li class="sub-menu">
                <a href="javascript:;"  id="FeeModuleNav">
                    <i class="fa fa-th"></i>
                    <span>Hostel</span>
                </a>
                    
                <ul class="sub">
                    <li id="FeeTypeNav"><a  href="typeTableAction.do?method=feeTypePage" onclick="highlightNavTree('FeeType');" >Hostel Type</a></li>
                </ul>
            </li>
            
            
             <li class="sub-menu">
                <a href="javascript:;"  id="FeeModuleNav">
                    <i class="fa fa-th"></i>
                    <span>Transport</span>
                </a>
                    
                <ul class="sub">
                    <li id="FeeTypeNav"><a  href="typeTableAction.do?method=feeTypePage" onclick="highlightNavTree('FeeType');" >Transport Type</a></li>
                </ul>
            </li>
            
             <li class="sub-menu">
                <a href="javascript:;"  id="FeeModuleNav">
                    <i class="fa fa-th"></i>
                    <span>Employee</span>
                </a>
                    
                <ul class="sub">
                    <li id="FeeTypeNav"><a  href="typeTableAction.do?method=feeTypePage" onclick="highlightNavTree('FeeType');" >Employee Profiles</a></li>
                </ul>
            </li>
            
            
             <li class="sub-menu">
                <a href="javascript:;"  id="FeeModuleNav">
                    <i class="fa fa-th"></i>
                    <span>Courses</span>
                </a>
                    
                <ul class="sub">
                    <li id="FeeTypeNav"><a  href="typeTableAction.do?method=feeTypePage" onclick="highlightNavTree('FeeType');" >Course Type</a></li>
                </ul>
            </li>
                
                
                
        </ul>
        <!-- sidebar menu end-->
    </div>
</aside>
    
<script>
    function highlightNavTree(navId) {
        alert('clicked nav tree'+navId);
        if(navId=='FeeType'){
            alert('Inside nav tree ');
          document.getElementById("FeeTypeNav").className="active";
             document.getElementById("FeeModuleNav").className="active";
        }
    }
</script>