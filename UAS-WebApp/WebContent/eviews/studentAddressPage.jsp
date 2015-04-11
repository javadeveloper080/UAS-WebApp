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
        
        <title>Student Address</title>
        
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
                            <h5><Strong>Add/Edit Student Address</Strong> </h5>
                                    <html:form  styleClass="" action="/studentAddressAction" method="post" styleId="studentAddressForm">
                                
                                <div class="row">
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <label for="addrLine1">Address Line1.</label>
                                            <html:select property="addressType" styleId="addressType" styleClass="form-control">
                                                <html:option  styleClass="form-control" value=""></html:option>                                                                                                                                                             
                                                <html:optionsCollection name="studentAddressForm" property="addressTypeList" label="label" value="value" /> 
                                            </html:select>
                                        </div>
                                    </div>
                                    
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <label for="addrLine1">Address Line1.</label>
                                            <html:text name="studentAddressForm" property="addrLine1" styleId="addrLine1" styleClass="form-control"/>
                                        </div>
                                    </div>
                                </div>
                                
                                
                                
                                <div class="row">
                                    
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <label for="addrLine2">Address Line2.</label>
                                            <html:text  name="studentAddressForm" property="addrLine2" styleId="addrLine2" styleClass="form-control"/>
                                        </div>
                                    </div>
                                    
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <label for="addrLine3">Address Line3.</label>
                                            <html:text name="studentAddressForm" property="addrLine3" styleId="addrLine3" styleClass="form-control"/>
                                        </div>
                                    </div>
                                </div>
                                
                                <div class="row">
                                    
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <label for="addrLine4">Address Line4.</label>
                                            <html:text  name="studentAddressForm" property="addrLine4" styleId="addrLine4" styleClass="form-control"/>
                                        </div>
                                    </div>
                                    
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <label for="city">City.</label>
                                            <html:text name="studentAddressForm" property="city" styleId="city" styleClass="form-control"/>
                                        </div>
                                    </div>
                                </div>
                                
                                <div class="row">
                                    
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <label for="stateName">State name.</label>
                                            <html:text  name="studentAddressForm" property="stateName" styleId="stateName" styleClass="form-control"/>
                                        </div>
                                    </div>
                                    
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <label for="country">Country.</label>
                                            <html:text name="studentAddressForm" property="country" styleId="country" styleClass="form-control"/>
                                        </div>
                                    </div>
                                </div>
                                
                                
                                <div class="row">
                                    
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <label for="zipCode">Zip code.</label>
                                            <html:text  name="studentAddressForm" property="zipCode" styleId="zipCode" styleClass="form-control"/>
                                        </div>
                                    </div>
                                </div>
                                
                                <html:hidden name="studentAddressForm" property="id" styleId="id"/>
                                <html:hidden name="studentAddressForm" property="studentId" styleId="studentId"/>
                                <html:hidden name="studentAddressForm" property="pageName" styleId="pageName" />
                                <div align="center">
                                    <html:button property="addBtn" styleClass="btn-theme" value="Apply" onclick="validateForm();" />
                                    <html:button property="rsetBtn" styleClass="btn-theme" value="Reset" onclick="reset();" />
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
                                <h4><i class="fa fa-angle-right"></i>Student address table</h4>
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
                
            var addressType = document.getElementById('addressType').value;
            var addrLine1 = document.getElementById('addrLine1').value;
            var city = document.getElementById('city').value;
            var zipCode = document.getElementById('zipCode').value;
            var country = document.getElementById('country').value;
            
            if (addressType === null || addressType ==="") {
                alert("Please select a AddressType");
                document.getElementById('addressType').focus();
                return false;
            }
            if (addrLine1 === null || addrLine1 ==="") {
                alert("Please Enter  Address Line1");
                document.getElementById('addrLine1').focus();
                return false;
            }
            
            if (zipCode === null || zipCode ==="") {
                alert("Please Enter zipCode ");
                document.getElementById('zipCode').focus();
                return false;
            }
            
            if (country === null || country ==="") {
                alert("Please Enter country ");
                document.getElementById('country').focus();
                return false;
            }
               
				
            if (rollNum === null || rollNum ==="") {
                alert("Please Enter Roll Number");
                document.getElementById('rollNum').focus();
                return false;
            }
            
            if (city=== null || city ==="") {
                alert("Please Enter city Name ");
                document.getElementById('city').cfocus();
                return false;
            }
      
            submitForm();
                     
        }

        function getEditTypeForm(id) {
            alert('Get Editff Type'+id);
            document.getElementById('id').value =id;	
            document.getElementById('pageName').value ="GetEditTypeForm"	
            document.studentAddressForm.action="studentAddressAction.do?method=studentAdressPage";
            document.studentAddressForm.submit();
        }
    
        function submitForm() {
            var id =document.getElementById('rollNum').value;	
            if(id != null ){
                document.getElementById('pageName').value ="SubmitEditType"	
            }else{
                document.getElementById('pageName').value ="SubmitAddType"
            }
          
            document.studentAddressForm.action="studentAddressAction.do?method=studentAdressPage";
            document.studentAddressForm.submit();
        }
	
        
        function reset(){	
            document.getElementById("studentAddressForm").reset();
        }
    </script>
    
    
</body>
</html>
