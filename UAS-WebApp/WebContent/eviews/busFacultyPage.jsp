<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" "http://www.w3.org/TR/REC-html40/loose.dtd">
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="Dashboard">
        <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
        
        <title>Bus Faculty</title>
        
        <!-- Bootstrap core CSS -->
        <link href="assets/css/bootstrap.css" rel="stylesheet">
        <!--external css-->
        <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
        
        <!-- Custom styles for this template -->
        <link href="assets/css/style.css" rel="stylesheet">
        <link href="assets/css/style-responsive.css" rel="stylesheet">
    </head>
    <body>
        
    <section id="container" >
        
        
        <!-- **********************************************************************************************************************************************************
        MAIN CONTENT
        *********************************************************************************************************************************************************** -->
        <!--main content start-->
        <section id="main-content">
            <section class="wrapper">
                
                <!-- BASIC FORM ELEMENTS -->
                <div class="row mt">
                    <div class="col-lg-12">
                        <div class="form-panel">
                            <h5><Strong>Add/Edit Bus Faculty</Strong> </h5>
                                    <html:form  styleClass="form-horizontal style-form" action="/transportModuleAction" method="post">
                                
                                <table >
                                    <tr>
                                        <td class="form-field-control">
                                            First name <html:text name="transportModuleForm" property="firstName" size="30" styleId="firstName" />
                                            
                                        </td>	
                                        <td class="form-field-control">
                                            Last name :  <html:text name="transportModuleForm" property="lastName" size="30" styleId="lastName" />
                                        <td>
                                    </tr>
                                </table>
                                <html:hidden name="transportModuleForm" property="id" styleId="id"/>
                                <html:hidden name="transportModuleForm" property="pageName" styleId="pageName" />
                                <div align="center">
                                    <html:button property="addBtn" styleClass="btn-theme" value="Apply" onclick="validateForm();" />
                                    <html:button property="resetBtn" styleClass="btn-theme" value="Reset" onclick="reset();" />
                                </div> 
                                
                                
                            </html:form>
                        </div>
                    </div><!-- col-lg-12-->      	
                </div><!-- /row -->
                
                
                
                
                <!-- GRID ELEMENTS -->
                <div class="row mt">
                    <div class="col-md-12">
                        <div class="content-panel">
                            <table class="table table-striped table-advance table-hover">
                                <h4><i class="fa fa-angle-right"></i> Bus Faculty Table</h4>
                                <hr>
                                <thead>
                                    <tr>
                                        <th><i class="fa fa-bullhorn"></i> First name</th>
                                        <th><i class="fa fa-bullhorn"></i> Last name</th>
                                        <th><i class="fa fa-bullhorn"></i> Address </th>
                                        <th><i class="fa fa-bullhorn"></i> Mobile</th>
                                        <th><i class="fa fa-bullhorn"></i> License expiry Date</th>
                                        <th><i class="fa fa-bullhorn"></i> Faculty Type</th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <logic:notEmpty name="transportModuleForm" property="busFacultyList">
                                        <logic:iterate id="transportFacultyTable" name="transportModuleForm" property="busFacultyList" type="org.edu.uams.server.pojo.BusFacultyEntity">
                                            <tr>
                                                <td><bean:write name="transportFacultyTable" property="firstName"/></td>
                                                <td><bean:write name="transportFacultyTable" property="lastName"/></td>
                                                <td><bean:write name="transportFacultyTable" property="addrLines"/></td>
                                                <td><bean:write name="transportFacultyTable" property="mobile"/></td>
                                                <td><bean:write name="transportFacultyTable" property="licenceExpiryDate"/></td>
                                                <td><bean:write name="transportFacultyTable" property="facultyType"/></td>
                                                <td><button class="btn btn-primary btn-xs" onclick='getEditTypeForm(${transportFacultyTable.id});'><i class="fa fa-pencil"></i></button></td>
                                            </tr>
                                        </logic:iterate>
                                    </logic:notEmpty>
                                </tbody>
                            </table>
                        </div><!-- /content-panel -->
                    </div><!-- /col-md-12 -->
                </div><!-- /row -->
                
            </section><! --/wrapper -->
        </section><!-- /MAIN CONTENT -->
        
        
        <!--main content end-->
        
    </section>
    
    <!-- js placed at the end of the document so the pages load faster -->
    <script src="assets/js/jquery.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script class="include" type="text/javascript" src="assets/js/jquery.dcjqaccordion.2.7.js"></script>
    <script src="assets/js/jquery.scrollTo.min.js"></script>
    <script src="assets/js/jquery.nicescroll.js" type="text/javascript"></script>
    
    
    <!--common script for all pages-->
    <script src="assets/js/common-scripts.js"></script>
    
    <!--script for this page-->
    
    <script>
            
            
        function validateForm() {
            alert("Validate Form Values");
            // get the form values
            var lastName = document.getElementById('lastName').value;
            var firstName = document.getElementById('firstName').value;
                
            if (lastName== null || lastName =="") {
                alert("Please Last name");
                document.getElementById('lastName').cfocus();
                return false;
            }
				
            if (firstName == null || firstName =="") {
                alert("Please Enter First name");
                document.getElementById('firstName').focus();
                return false;
            }
      
            submitForm();
        }


        function getEditTypeForm(id) {
            alert('Get Editff Type'+id);
            document.getElementById('id').value =id;	
            document.getElementById('pageName').value ="GetEditTypeForm"	
            document.transportModuleForm.action="transportModuleAction.do?method=busFacultyPage";
            document.transportModuleForm.submit();
        }
    
        function submitForm() {
            alert('Submit Form');
            var id =document.getElementById('id').value;	
            if(id != null && id>0){
                document.getElementById('pageName').value ="SubmitEditType"	
            }else{
                document.getElementById('pageName').value ="SubmitAddType"
            }
            document.transportModuleForm.action="transportModuleAction.do?method=busFacultyPage";
            document.transportModuleForm.submit();
        }
	
        
        function reset()
        {	
            alert('reset');
            //            document.getElementById('code').value="";
            //            document.getElementById('description').value="";
            //            document.getElementById('id').value="0";
            //            document.getElementById('pageName').value="";
		
        }
    </script>
    
</body>
</html>
