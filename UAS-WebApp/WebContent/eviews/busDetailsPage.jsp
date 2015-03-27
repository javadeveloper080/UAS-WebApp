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
        
        <title>Bus Details</title>
        
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
                            <h5><Strong>Add/Edit Bus Details</Strong> </h5>
                                    <html:form  styleClass="form-inline" action="/transportModuleAction" method="post">
                                
                                <div class="form-group">
                                    <div ><label for="registrationNum">Registration number</label></div >
                                    <html:text name="transportModuleForm" property="registrationNum" styleId="registrationNum" styleClass="form-control"/>
                                </div>
                                
                                
                                <div class="form-group">
                                    <div ><label for="chassisNum">Chassis number</label></div >
                                    <html:text name="transportModuleForm" property="chassisNum" styleId="chassisNum" styleClass="form-control"/>
                                </div>
                                
                                
                                <div class="form-group">
                                    <div ><label for="numOfSeats">Number of seats</label></div >
                                    <html:text name="transportModuleForm" property="numOfSeats" styleId="numOfSeats" styleClass="form-control"/>
                                </div>
                                
                                
                                <div class="form-group">
                                    <div ><label for="travelPerDay">Travel per day</label></div >
                                    <html:text name="transportModuleForm" property="travelPerDay" styleId="travelPerDay" styleClass="form-control"/>
                                </div>
                                
                               
                                
                                <div class="form-group">
                                    <div ><label for="driverId">Driver</label></div >
                                    <html:select property="driverId" styleId="driverId">
                                        <html:option  styleClass="form-control" value="">Select Driver</html:option>                                                                                                                                                             
                                        <html:optionsCollection name="transportModuleForm" property="diverList" label="firstName" value="id" /> 
                                    </html:select>
                                </div>
                                
                                
                                  <div class="form-group">
                                    <div ><label for="cleanerOrHelperId">Cleaner</label></div >
                                    <html:select property="cleanerOrHelperId" styleId="cleanerOrHelperId">
                                        <html:option  styleClass="form-control" value="">Select Cleaner</html:option>                                                                                                                                                             
                                        <html:optionsCollection name="transportModuleForm" property="cleanerOrHelperList" label="firstName" value="id" /> 
                                    </html:select>
                                </div>
                                
                                
                                 <div class="form-group">
                                    <div ><label for="coordinatorId">Coordinator</label></div >
                                    <html:select property="coordinatorId" styleId="coordinatorId">
                                        <html:option  styleClass="form-control" value="">Select Coordinator</html:option>                                                                                                                                                             
                                        <html:optionsCollection name="transportModuleForm" property="coordinatorList" label="firstName" value="id" /> 
                                    </html:select>
                                </div>
                                
                                <html:hidden name="transportModuleForm" property="id" styleId="id"/>
                                <html:hidden name="transportModuleForm" property="pageName" styleId="pageName" />
                                <div align="center">
                                    <html:button property="addBtn" styleClass="btn-theme" value="Apply" onclick="validateForm();" />
                                    <html:button property="resetBtn" styleClass="btn-theme" value="Reset" onclick="reset();" />
                                </div> 
                                
                                
                            </html:form>
                        </div>
                    </div><!-- col-lg-12-->      	
                </div> <!--  /row -->
                
                
                
                
                <!-- GRID ELEMENTS -->
                <div class="row mt">
                    <div class="col-md-12">
                        <div class="content-panel">
                            <table class="table table-striped table-advance table-hover">
                                <h4><i class="fa fa-angle-right"></i> Bus Details Table</h4>
                                <hr>
                                <thead>
                                    <tr>
                                        <th><i class="fa fa-bullhorn"></i> Bus number</th>
                                        <th><i class="fa fa-bullhorn"></i> Registration number</th>
                                        <th><i class="fa fa-bullhorn"></i> Chassis Number </th>
                                        <th><i class="fa fa-bullhorn"></i> Travel per day</th>
                                          <th><i class="fa fa-bullhorn"></i> Number of seats</th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <logic:notEmpty name="transportModuleForm" property="busDetailsList">
                                        <logic:iterate id="transportBusDetailsTable" name="transportModuleForm" property="busDetailsList" type="org.edu.uams.server.pojo.BusDetailsEntity">
                                            <tr>
                                                <td><bean:write name="transportBusDetailsTable" property="busNum"/></td>
                                                <td><bean:write name="transportBusDetailsTable" property="registrationNum"/></td>
                                                <td><bean:write name="transportBusDetailsTable" property="chassisNum"/></td>
                                                <td><bean:write name="transportBusDetailsTable" property="travelPerDay"/></td>
                                                <td><bean:write name="transportBusDetailsTable" property="numOfSeats"/></td>
                                                <td><button class="btn btn-primary btn-xs" onclick='getEditTypeForm(${transportBusDetailsTable.id});'><i class="fa fa-pencil"></i></button></td>
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
    
    <link href="http://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css" rel="stylesheet">
    <script src="http://code.jquery.com/jquery-1.10.2.js"></script>
    <script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
    
    
    
 
    <!--external css-->
    <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    
    <!-- Custom styles for this template -->
    <link href="assets/css/style.css" rel="stylesheet">
    <link href="assets/css/style-responsive.css" rel="stylesheet">
    
    
    <!--common script for all pages-->
    <script src="assets/js/common-scripts.js"></script>
    
    
       <!-- Bootstrap core CSS -->
<!--    <link href="assets/css/bootstrap.css" rel="stylesheet">-->
    <script src="assets/css/bootstrap.min.css"></script>

    
    <!--script for this page-->
    
    <script>
            
            
        function validateForm() {
            alert("Validate Form Values");
            // get the form values
           
            submitForm();
        }


        function getEditTypeForm(id) {
            alert('Get Editff Type'+id);
            document.getElementById('id').value =id;	
            document.getElementById('pageName').value ="GetEditTypeForm"	
            document.transportModuleForm.action="transportModuleAction.do?method=busDetailsPage";
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
            document.transportModuleForm.action="transportModuleAction.do?method=busDetailsPage";
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
