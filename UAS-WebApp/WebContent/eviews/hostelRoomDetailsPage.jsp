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
                            <h5><Strong>Add/Edit Hostel Room</Strong> </h5>
                                    <html:form  styleClass="" action="/hostelRoomDetailAction" method="post">
                                
                                <div class="row">
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            Room Name :  <html:text name="hostelRoomDetailsForm" property="roomName" styleId="roomName" styleClass="form-control"/>
                                        </div>
                                    </div>
                                    
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            Room Type  :  <html:text name="hostelRoomDetailsForm" property="roomType" styleId="roomType" styleClass="form-control"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            Room Image :   <html:text name="hostelRoomDetailsForm" property="roomImage" styleId="roomImage" styleClass="form-control"/>
                                        </div>
                                    </div>
                                    
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            Description  :  <html:text name="hostelRoomDetailsForm" property="roomDescription" styleId="roomDescription" styleClass="form-control"/>
                                        </div>
                                    </div>
                                </div>
                                
                                <div class="row">
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            Room Price :  <html:text name="hostelRoomDetailsForm" property="roomPrice" styleId="roomPrice" styleClass="form-control"/>
                                        </div>
                                    </div>
                                    
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            Room Capacity  : <html:text name="hostelRoomDetailsForm" property="roomCapacity" styleId="roomCapacity" styleClass="form-control"/>
                                        </div>
                                    </div>
                                </div>
                                
                                <div class="row">
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <label for="hBlockId">Hostel :</label>
                                            <html:select  styleClass="form-control" property="hBlockId" styleId="hBlockId">
                                                <html:option value="0">Select a hostel</html:option>
                                                <html:optionsCollection   name="hostelRoomDetailsForm"
                                                                  property="blockEntitys" label="name" value="id" />
                                            </html:select>
                                        </div>
                                    </div>
                                    
                                </div>
                                
                                
                                <html:hidden name="hostelRoomDetailsForm" property="id" styleId="id"/>
                                <html:hidden name="hostelRoomDetailsForm" property="pageName" styleId="pageName" />
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
                                <h4><i class="fa fa-angle-right"></i> Hostel Rooms</h4>
                                <hr>
                                <thead>
                                    <tr>
                                        <th><i class="fa fa-bullhorn"></i>Room Name</th>
                                        <th><i class="fa fa-bullhorn"></i> Room Type </th>
                                        <th><i class="fa fa-bullhorn"></i> Description</th>
                                        <th><i class="fa fa-bullhorn"></i> Room Price</th>
                                        <th><i class="fa fa-bullhorn"></i> Room Capacity</th>
                                        <th><i class="fa fa-bullhorn"></i> Hostel Name</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <logic:notEmpty name="hostelRoomDetailsForm" property="roomDetailsEntitys">
                                        <logic:iterate id="roomDetailTable" name="hostelRoomDetailsForm" property="roomDetailsEntitys" type="org.edu.uams.server.pojo.HostelRoomDetailsEntity">
                                            <tr>
                                                <td><bean:write name="roomDetailTable" property="roomName"/></td>
                                                <td><bean:write name="roomDetailTable" property="roomType"/></td>
                                                <td><bean:write name="roomDetailTable" property="roomDescription"/></td>
                                                <td><bean:write name="roomDetailTable" property="roomPrice"/></td>
                                                <td><bean:write name="roomDetailTable" property="roomCapacity"/></td>
                                                <td><bean:write name="roomDetailTable" property="hblockName"/></td>
                                                <td><button class="btn btn-primary btn-xs" onclick='getEditTypeForm(${roomDetailTable.id});'><i class="fa fa-pencil"></i></button></td>
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
            var name = document.getElementById('roomName').value;
                
            if (name== null || name =="") {
                alert("Please Hostel Name");
                document.getElementById('roomName').focus();
                return false;
            }
				
            submitForm();
        }


        function getEditTypeForm(id) {
            alert('Get Editff Type'+id);
            document.getElementById('id').value =id;	
            document.getElementById('pageName').value ="GetEditTypeForm"	
            document.hostelRoomDetailsForm.action="hostelRoomDetailAction.do?method=hostelRoomPage";
            document.hostelRoomDetailsForm.submit();
        }
    
        function submitForm() {
            alert('Submit Form');
            var id =document.getElementById('id').value;	
            if(id != null && id>0){
                document.getElementById('pageName').value ="SubmitEditType"	
            }else{
                document.getElementById('pageName').value ="SubmitAddType"
            }
            document.hostelRoomDetailsForm.action="hostelRoomDetailAction.do?method=hostelRoomPage";
            document.hostelRoomDetailsForm.submit();
        }
	
        
        function reset()
        {	
            alert('reset');
                        document.getElementById('rooName').value="";
            //            document.getElementById('description').value="";
            //            document.getElementById('id').value="0";
            //            document.getElementById('pageName').value="";
		
        }
        
    </script>
    
</body>
</html>
