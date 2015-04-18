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
        
        <title>Student Enrollment</title>
        
        <!-- Bootstrap core CSS -->
        <link href="assets/css/bootstrap.css" rel="stylesheet">
        <!--external css-->
        <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
        <link rel="stylesheet" type="text/css" href="assets/js/gritter/css/jquery.gritter.css" />
        
        <!-- Custom styles for this template -->
        <link href="assets/css/style.css" rel="stylesheet">
        <link href="assets/css/style-responsive.css" rel="stylesheet">
        
        <link href="http://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css" rel="stylesheet">
        
        
        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
        
    <section id="container" >
        <!-- **********************************************************************************************************************************************************
        TOP BAR CONTENT & NOTIFICATIONS
        *********************************************************************************************************************************************************** -->
        <!--header start-->
        <header class="header black-bg">
            <!--logo start-->
            <a href="" class="logo"><b>University Admission & Maintenance System</b></a>
            <!--logo end-->
        </header>
        <!--header end-->
        
        
        <!-- **********************************************************************************************************************************************************
     MAIN SIDEBAR MENU
     *********************************************************************************************************************************************************** -->
        <!--sidebar start-->
        <aside>
            <div id="sidebar"  class="nav-collapse ">
                <!-- sidebar menu start-->
                <ul class="sidebar-menu" id="nav-accordion">
                    
                    <p class="centered"><img src="assets/img/menu_pic.png" class="img-responsive" width="200"></p>
                    <h2 class="centered">UAMS</h2>
                    
                    <li class="mt">
                        <a href="loginAction.do?method=loginPage">
                            <i class="fa fa-dashboard"></i>
                            <span>Login</span>
                        </a>
                    </li>
                    
                </ul>
                <!-- sidebar menu end-->
            </div>
        </aside>
        <!--sidebar end-->
        
        
        <!-- **********************************************************************************************************************************************************
        MAIN CONTENT
        *********************************************************************************************************************************************************** -->
        <!--main content start-->
        <section id="main-content">
            
            <section class="wrapper base-min-height">
                
                <!-- BASIC FORM ELEMENTS -->
                <div class="row mt">
                    <div class="col-lg-12">
                        <div class="form-panel">
                            <h1><Strong>Student Enrollment</Strong> </h1>
                                    <html:form  styleClass="" action="/studentEnrollment" method="post" styleId="studentEnrollmentForm">
                                <h3><em>Student enrollment helps a student apply for a course in university</em></h3>
                                <hr />
                                
                                <h5><p ><em><strong style="color:blue"><bean:write name="studentEnrollmentForm" property="statusMessage" /></strong></em></p></h5>
                                
                                <div class="row">
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            First Name  : <html:text  property="firstName"  styleId="firstName"   styleClass="form-control"/>
                                        </div>
                                    </div>
                                    
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            Last Name :  <html:text  property="lastName"  styleId="lastName"  styleClass="form-control"/>
                                        </div>
                                    </div>
                                </div>
                                
                                
                                <div class="row">
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            Date Of Birth : <html:text  property="dob"  styleId="dob"   styleClass="form-control"/>
                                        </div>
                                    </div>
                                    
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <label for="genderType">Gender.</label>
                                            <html:select property="genderType" styleId="genderType" styleClass="form-control">
                                                <html:option  styleClass="form-control" value=""></html:option>                                                                                                                                                             
                                                <html:optionsCollection name="studentEnrollmentForm" property="genderTypeList" label="label" value="value" /> 
                                            </html:select>
                                        </div>
                                    </div>
                                </div>
                                
                                
                                <div class="row">
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            Mobile No : <html:text  property="studentMob"  styleId="studentMob"  styleClass="form-control" />
                                        </div>
                                    </div>
                                    
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            E-Mail : <html:text  property="email"  styleId="email"  styleClass="form-control" />
                                        </div>
                                    </div>
                                </div>
                                
                                <hr>
                                <div class="row">
                                    
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            Last Graduated Program Level Type :  <html:select  property="graduatedProgramLevelTypeId"  styleId="graduatedProgramLevelTypeId"   styleClass="form-control">
                                                <html:option   value="">Select Degree</html:option>                                                                                                                                                             
                                                <html:optionsCollection name="studentEnrollmentForm" property="listOfProgamLevelTypes" label="description" value="id" /> 
                                            </html:select>
                                        </div>
                                    </div>
                                    
                                </div>       
                                
                                
                                <div class="row">
                                    
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            Last Graduated Course :  <html:select  property="lastGraduatedCourseId"  styleId="lastGraduatedCourseId"   styleClass="form-control">
                                                <html:option   value="">Select Course</html:option>                                                                                                                                                             
                                                <html:optionsCollection name="studentEnrollmentForm" property="listOfCourses" label="description" value="id" /> 
                                            </html:select>
                                        </div>
                                    </div>
                                    
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            Grade :  <html:text  property="grade"  styleId="grade"  styleClass="form-control"/>
                                        </div>
                                    </div>
                                    
                                </div>
                                
                                <hr>
                                
                                <div class="row">
                                    
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            Applying Degree :  <html:select  property="appliedProgramLevelTypeId"  styleId="appliedProgramLevelTypeId"   styleClass="form-control">
                                                <html:option   value="">Select Degree</html:option>                                                                                                                                                             
                                                <html:optionsCollection name="studentEnrollmentForm" property="listOfProgamLevelTypes" label="description" value="id" /> 
                                            </html:select>
                                        </div>
                                    </div>
                                    
                                </div>       
                                
                                <div class="row">
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            
                                            Applying Course :  <html:select  property="applyCourseId"  styleId="applyCourseId"   styleClass="form-control">
                                                <html:option   value="">Select Course</html:option>                                                                                                                                                             
                                                <html:optionsCollection name="studentEnrollmentForm" property="listOfCourses" label="description" value="id" /> 
                                            </html:select>
                                        </div>
                                       
                                        
                                    </div>
                                    
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            Enrolled Date  : <html:text  property="dateEnrolled"  styleId="dateEnrolled"   styleClass="form-control"/>
                                        </div>
                                    </div>
                                </div>
                                
                                <html:hidden name="studentEnrollmentForm" property="id" styleId="id"/>
                                <html:hidden name="studentEnrollmentForm" property="pageName" styleId="pageName" />
                                
                                <div align="center">
                                    <html:button property="addBtn" styleClass="btn-theme" value="Apply" onclick="validateForm();" />
                                    <html:button property="rsetBtn" styleClass="btn-theme" value="Reset" onclick="reset();" />
                                </div> 
                                
                                
                            </html:form>
                        </div>
                    </div><!-- col-lg-12-->      	
                </div><!-- /row -->
                
            </section><! --/wrapper -->
        </section><!-- /MAIN CONTENT -->
        <!--main content end-->
        
        
        <!--footer start-->
        
        
        <footer class="site-footer">
            <div class="text-center">
                2015 - UMAS
            </div>
        </footer>
        <!--footer end-->
        
    </section>
    
    
    
    <!--script for this page-->
    <!-- js placed at the end of the document so the pages load faster -->
    <script src="assets/js/jquery.js"></script>
    <script src="assets/js/jjquery-1.8.3.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script class="include" type="text/javascript" src="assets/js/jquery.dcjqaccordion.2.7.js"></script>
    <script src="assets/js/jquery.scrollTo.min.js"></script>
    <script src="assets/js/jquery.nicescroll.js" type="text/javascript"></script>
    
    
    <!--common script for all pages-->
    <script src="assets/js/common-scripts.js"></script>
    
    <!--script for this page-->
    <script type="text/javascript" src="assets/js/gritter/js/jquery.gritter.js"></script>
    <script type="text/javascript" src="assets/js/gritter-conf.js"></script>
    <script src="http://code.jquery.com/jquery-1.10.2.js"></script>
    <script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
    
    <!--script for this page-->
    
    <script>


        function validateForm() {
            // get the form values
            var dateEnrolled = document.getElementById('dateEnrolled').value;
            var grade = document.getElementById('grade').value;
            var mobile = document.getElementById('studentMob').value;
            var email = document.getElementById('email');
            var firstName = document.getElementById('firstName').value;
            var lastName = document.getElementById('lastName').value;
            var dob = document.getElementById('dob').value;
            var genderType = document.getElementById('genderType').value;
            
                    var applyCourseId = document.getElementById('applyCourseId').value;
            var appliedProgramLevelTypeId = document.getElementById('appliedProgramLevelTypeId').value;
            var lastGraduatedCourseId = document.getElementById('lastGraduatedCourseId').value;
            var graduatedProgramLevelTypeId = document.getElementById('graduatedProgramLevelTypeId').value;
              
              
            var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
            
          
            if (firstName === null || firstName === "") {
                alert("Please Enter Student First Name");
                document.getElementById('firstName').focus();
                return false;
            }
            if (lastName === null || lastName === "") {
                alert("Please Enter Student Last Name");
                document.getElementById('lastName').focus();
                return false;
            }
        
            if (dob === null || dob === "") {
                alert("Please Enter Date Of Birth");
                document.getElementById('dob').focus();
                return false;
            }
          
            if (dateEnrolled === null || dateEnrolled === "") {
                alert("Please Enter Date Enrolled");
                document.getElementById('dateEnrolled').focus();
                return false;
            }
            if (grade === null || grade === "") {
                alert("Please Enter grade");
                document.getElementById('grade').focus();
                return false;
            }
            
            if(isNaN(mobile)){
                alert('Please Enter Numeric value for Mobile');
                document.getElementById('studentMob').focus;
                return false;

            }
            
            if (email === null || email === "") {
                alert("Please Email grade");
                document.getElementById('email').focus();
                return false;
            }
        
        
      
            if (!filter.test(email.value)) {
                alert('Please provide a valid email address');
                document.getElementById('email').focus;
                return false;
            } 
            
            if (genderType === null || genderType === "") {
                alert("Please Select gender type");
                document.getElementById('genderType').focus();
                return false;
            }
      
            if (applyCourseId === null || applyCourseId === "") {
                alert("Please Select Applying Course");
                document.getElementById('applyCourseId').focus();
                return false;
            }
            
             if (appliedProgramLevelTypeId === null || appliedProgramLevelTypeId === "") {
                alert("Please Select Applying Program Level Type");
                document.getElementById('appliedProgramLevelTypeId').focus();
                return false;
            }
            
            if (graduatedProgramLevelTypeId === null || graduatedProgramLevelTypeId === "") {
                alert("Please Select Last Attended Program Level Type");
                document.getElementById('graduatedProgramLevelTypeId').focus();
                return false;
            }
            
            if (lastGraduatedCourseId === null || lastGraduatedCourseId === "") {
                alert("Please Select Last Graduated Course");
                document.getElementById('lastGraduatedCourseId').focus();
                return false;
            }
            submitForm();

        }

        function submitForm() {
            document.getElementById('pageName').value = "SubmitAddType"
            document.studentEnrollmentForm.action = "studentEnrollment.do?method=studentEnrollmentPage";
            document.studentEnrollmentForm.submit();
        }


        function reset() {
            document.getElementById("studentEnrollmentForm").reset();
        }


        $(function () {
            $("#dateEnrolled").datepicker({
                showOn: "button",
                buttonImage: "images/calendar.gif",
            });
        });
        
        $(function () {
            $("#dob").datepicker({
                showOn: "button",
                buttonImage: "images/calendar.gif",
            });
        });
        
        
        
    </script>
    
