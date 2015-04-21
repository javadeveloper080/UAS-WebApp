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
        
        <title>Manage Enrolled Students</title>
        
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
                            <h5><Strong>Filter Enrolled Students</Strong> </h5>
                            <html:form  styleClass="" action="/studentEnrollmentAction" method="post">
                                
                               <p><em>Filter By Course and Status</em></p>
                                <div class="row">
                                   <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            Filtering Course :  <html:select  property="applyCourseId"  styleId="applyCourseId"   styleClass="form-control">
                                                <html:option   value="">Select Course</html:option>                                                                                                                                                             
                                                <html:optionsCollection name="studentEnrollmentForm" property="listOfCourses" label="description" value="id" /> 
                                            </html:select>
                                                <html:button property="filterButton" styleClass="btn-theme" value="Filter" onclick="filter(); " />     
                                        </div>
                                    </div>
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                             Filtering Status :  <html:select property="enrollmentStatusType" styleId="enrollmentStatusType" styleClass="form-control">
                                                <html:option  styleClass="form-control" value=""></html:option>                                                                                                                                                             
                                                <html:optionsCollection name="studentEnrollmentForm" property="enrollmentStatusTypeList" label="label" value="value" /> 
                                            </html:select>
                                        </div>
                                    </div>  
                                     
                                </div>
                                <hr />
                                <html:hidden name="studentEnrollmentForm" property="pageName" styleId="pageName" />
                            </html:form>
                        </div>
                    </div><!-- col-lg-12-->      	
                </div><!-- /row -->
                
       
             
                <!-- GRID ELEMENTS -->
                <div class="row mt">
                    <div class="col-md-12">
                        <div class="content-panel">
                                 <font color="red"> <label id="mailSentFailed"/></font> 
                                 <font color="green"> <label id="mailSentSucess"/></font> 
                            <table class="table table-striped table-advance table-hover">
                                <h4><i>Student Enrollment Table</i></h4>
                                <hr>
                                <thead>
                                    <tr>
                                        <th>Enrollment Number</th>
                                        <th>First Name</th>
                                        <th>Last Name</th>
                                        <th>Applied Course Type</th>
                                        <th>Date Enrolled</th>
                                        <th>Grade</th>
                                        <th>Status</th>
                                        <th> </th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <logic:notEmpty name="studentEnrollmentForm" property="studentEnrollmetList">
                                        <logic:iterate id="studentEnrollment" name="studentEnrollmentForm" property="studentEnrollmetList" type="org.edu.uams.server.pojo.StudentEnrollmentEntity">
                                            <tr>
                                                <td><bean:write name="studentEnrollment" property="enrollmentNumber"/></td>
                                                <td><bean:write name="studentEnrollment" property="firstName"/></td>
                                                <td><bean:write name="studentEnrollment" property="lastName"/></td>
                                                <td><bean:write name="studentEnrollment" property="appliedCourseType.description"/></td>
                                                <td><bean:write name="studentEnrollment" property="dateEnrolled"/></td>
                                                <td><bean:write name="studentEnrollment" property="grade"/></td>
                                                <td><bean:write name="studentEnrollment" property="enrollmentStatusType"/></td>
                                                <td><button class="btn btn-info" onclick='accept(${studentEnrollment.id});'>Accept</button></td>
                                                <td><button class="btn btn-info" onclick='reject(${studentEnrollment.id});'>Reject</button></td>
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
    
    <!--script for this page-->
    
    <script >
        
        
        function accept(id) {
            alert("accept")
             $.ajax({
                type: "POST",
                url: "/UAMS-WebApp/studentEnrollmentAction.do?method=sendStatusToStudent",
                data: {
                    "statusMessage": "ACCEPT",
                     "id": id
                },
                success: function (response) {
                     refresh();
                }
            });
        }
        
          function reject(id) {
             $.ajax({
                type: "POST",
                url: "/UAMS-WebApp/studentEnrollmentAction.do?method=sendStatusToStudent",
                data: {
                    "statusMessage": "REJECT",
                    "id": id
                },
                success: function (response) {
                  refresh();
                }
            });
        }
        
        function refresh() {
            document.studentEnrollmentForm.action = "studentEnrollmentAction.do?method=allStudentEnrollmentPage";
            document.studentEnrollmentForm.submit();
        }
        
         function filter() {
            document.studentEnrollmentForm.action = "studentEnrollmentAction.do?method=allStudentEnrollmentPage";
            document.studentEnrollmentForm.submit();
        }
        
        
         function filter() {
                document.getElementById('pageName').value ="FilterType"	
                document.studentEnrollmentForm.action="studentEnrollmentAction.do?method=allStudentEnrollmentPage";
                document.studentEnrollmentForm.submit();
            }

       
    </script>
    
</body>
</html>
