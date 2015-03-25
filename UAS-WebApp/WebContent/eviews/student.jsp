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
        
        <title>Fee Type</title>
        
        <!-- Bootstrap core CSS -->
        <link href="assets/css/bootstrap.css" rel="stylesheet">
        <!--external css-->
        <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
        
        <!-- Custom styles for this template -->
        <link href="assets/css/style.css" rel="stylesheet">
        <link href="assets/css/style-responsive.css" rel="stylesheet">
        
        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
        
        
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
                            <h5><Strong>Add/Edit Fee type</Strong> </h5>
                                  <html:form  styleClass="form-horizontal style-form" action="/studentAction" method="post">
                                
                                <table >
                                    <tr>
                                        <td class="form-field-control">
                                            Admin Number : <html:text  property="admnNum" size="30" styleId="admnNum"  maxlength="10"  />
                                            
                                        </td>	
                                        <td class="form-field-control">
                                            Roll Number :  <html:text  property="rollNum" size="30" styleId="rollNum"  maxlength="100" />
                                        <td>
                                    </tr>
                                     <tr>
                                        <td class="form-field-control">
                                            Student Name : <html:text  property="studentName" size="30" styleId="studentName"  maxlength="10"  />
                                            
                                        </td>	
                                        <td class="form-field-control">
                                            Branch Name :  <html:text  property="branchName" size="30" styleId="branchName"  maxlength="100" />
                                        <td>
                                    </tr>
                                     <tr>
                                        <td class="form-field-control">
                                            Semister : <html:text  property="sem" size="30" styleId="sem"  maxlength="10"  />
                                            
                                        </td>	
                                        <td class="form-field-control">
                                            Roll Number :  <html:text  property="branchName" size="30" styleId="description"  maxlength="100" />
                                        <td>
                                    </tr>
                                </table>
                                <%--<html:hidden name="typeTableForm" property="id" styleId="id"/>--%>
                                <html:hidden property="pageName" styleId="pageName" />
                                <div align="center">
                                    <html:button property="addBtn" styleClass="btn-theme" value="Apply" onclick="validateForm();" />
                                    <html:button property="rsetBtn" styleClass="btn-theme" value="Reset" onclick="rset();" />
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
                                <h4><i class="fa fa-angle-right"></i> Fee type table</h4>
                                <hr>
                                <thead>
                                    <tr>
                                        <th><i class="fa fa-bullhorn"></i> Code</th>
                                        <th class="hidden-phone"><i class="fa fa-question-circle"></i> Description</th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <%--<logic:notEmpty name="typeTableForm" property="typeFormList">--%>
                                        <%--<logic:iterate id="typeTable" name="typeTableForm" property="typeFormList" type="org.edu.uams.server.pojo.FeeTypeEntity">--%>
                                            <tr>
                                                <td>
                                                    <%--<bean:write name="typeTable" property="code"/>--%>
                                                </td>
                                                <td>
                                                    <%--<bean:write name="typeTable" property="description"/>--%>
                                                </td>
                                                <!--<td><button class="btn btn-primary btn-xs" onclick='getEditTypeForm(${typeTable.id});'><i class="fa fa-pencil"></i></button></td>-->
                                            </tr>
                                        <%--</logic:iterate>--%>
                                    <%--</logic:notEmpty>--%>
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
                 // get the form values
                var admnNum = document.getElementById('admnNum').value;
                var rollNum = document.getElementById('rollNum').value;
                var studentName = document.getElementById('studentName').value;
                var branchName = document.getElementById('branchName').value;
                if (admnNum=== null || admnNum ==="") {
                    alert("Please Enter Admin Number");
                    document.getElementById('admnNum').cfocus();
                    return false;
                }
				
               else if (rollNum === null || rollNum ==="") {
                    alert("Please Enter Roll Number");
                    document.getElementById('rollNum').focus();
                    return false;
                }
               else if (studentName === null || studentName ==="") {
                    alert("Please Enter Student Name");
                    document.getElementById('studentName').focus();
                    return false;
                }
                if (branchName === null || branchName ==="") {
                    alert("Please Enter Branch Name");
                    document.getElementById('rollNum').focus();
                    return false;
                }
      
                submitForm();
                     
             }

            function getEditTypeForm(id) {
                alert('Get Editff Type'+id);
                document.getElementById('id').value =id;	
                document.getElementById('pageName').value ="GetEditTypeForm"	
                document.studentForm.action="typeTableAction.do?method=feeTypePage";
                document.studentForm.submit();
            }
    
            function submitForm() {
                var id =document.getElementById('admnNum').value;	
                if(id != null && id>0){
                    document.getElementById('pageName').value ="SubmitEditType"	
                }else{
                    document.getElementById('pageName').value ="SubmitAddType"
                }
                document.studentForm.action="studentAction.do";
                document.studentForm.submit();
            }
	
        
            function rset()
            {	
                alert('reset');
                document.getElementById('code').value="";
                document.getElementById('description').value="";
		
            }
        </script>

    
</body>
</html>
