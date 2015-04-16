<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" "http://www.w3.org/TR/REC-html40/loose.dtd">
<!DOCTYPE html>
<html lang="en">
    <head>

        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="Dashboard">
        <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

        <title>Student Enrollment</title>

        <!-- Bootstrap core CSS -->
        <link href="assets/css/bootstrap.css" rel="stylesheet">
        <!--external css-->
        <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />

        <!-- Custom styles for this template -->
        <link href="assets/css/style.css" rel="stylesheet">
        <link href="assets/css/style-responsive.css" rel="stylesheet">
        <!-- js placed at the end of the document so the pages load faster -->
       
        <script  type="text/javascript" src="assets/js/bootstrap.min.js"></script>
        <script src="assets/js/jquery.nicescroll.js" type="text/javascript"></script>

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
                            <h5><Strong>Manage Student Enrollment</Strong> </h5>
                                    <html:form  styleClass="" action="/studentEnrollment" method="post" styleId="studentEnrollmentForm">
                                <p><em>To Edit/Update Student Enrollment,Search By Roll Number.</em></p>
                                <!-- Search functionalities  -->
                                <div class="row">
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <html:text name="studentEnrollmentForm" property="searchText" styleId="searchText" styleClass="form-control" />
                                            <html:button property="searchButton" styleClass="btn-theme" value="Search" onclick="checkValidStudentRollNumber();" />
                                        </div>
                                    </div>
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <label for="rollNum">Student Roll Number & Full Name.</label>
                                            <html:text name="studentEnrollmentForm" property="rollNum" styleId="rollNum"  readonly="true"/>
                                            <html:text name="studentEnrollmentForm" property="studentFullName" styleId="studentFullName"  readonly="true"/>
                                        </div>
                                    </div>         
                                </div>
                                <hr />
                                <div class="row">
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <html:hidden  property="studentId"  styleId="studentId"  />
                                            Course :  <html:select  property="courseId"  styleId="courseId"   styleClass="form-control">
                                                
                                                            <html:option value="0">Select Course</html:option>
                                                            <logic:notEmpty name="studentEnrollmentForm" property="listOfCourses">
                                                                
                                                                    <logic:iterate id="course" name="studentEnrollmentForm" property="listOfCourses" type="org.edu.uams.server.pojo.CourseMasterEntity">
                                                                      <html:option value="${course.id}"><bean:write name="course" property="courseName"/></html:option>
                                                                    </logic:iterate>
                                                                
                                                            </logic:notEmpty>
                                                      </html:select>
                                        </div>
                                    </div>

                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                             Enrolled Date  : <html:text  property="dateEnrolled"  styleId="dateEnrolled"   styleClass="form-control"/>
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            Grade :  <html:text  property="grade"  styleId="grade"  styleClass="form-control"/>
                                        </div>
                                    </div>

                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                           <c:if test="${studentEnrollmentForm.id != null}">
                                               <c:if test="${studentEnrollmentForm.id > 0}">
                                               Your Enrollment Id is <h1>${studentEnrollmentForm.id} </h1>
                                               </c:if>
                                           </c:if>
                                        </div>
                                    </div>
                                </div>


                                <html:hidden name="studentEnrollmentForm" property="id" styleId="id"/>
                                <%--<html:hidden name="studentForm" property="studentId" styleId="studentId"/>--%>
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

    </section>



    <!--script for this page-->

    <script>


        function validateForm() {
            // get the form values
            var studentId = document.getElementById('studentId').value;
            var courseId = document.getElementById('courseId').value;
            var dateEnrolled = document.getElementById('dateEnrolled').value;
            var grade = document.getElementById('grade').value;
            
            if (studentId === null || studentId === "") {
                alert("Please Enter Student ID");
                document.getElementById('studentId').cfocus();
                return false;
            }

            else if (courseId === null || courseId === "") {
                alert("Please Enter Course");
                document.getElementById('courseId').focus();
                return false;
            }
            else if (dateEnrolled === null || dateEnrolled === "") {
                alert("Please Enter Date Enrolled");
                document.getElementById('dateEnrolled').focus();
                return false;
            }
            if (grade === null || grade === "") {
                alert("Please Enter grade");
                document.getElementById('grade').focus();
                return false;
            }
            
            submitForm();

        }

        function submitForm() {
            var id = document.getElementById('id').value;
            if (id != null && id > 0) {
                document.getElementById('pageName').value = "SubmitEditType"
            } else {
                document.getElementById('pageName').value = "SubmitAddType"
            }
            document.studentEnrollmentForm.action = "studentEnrollment.do";
            document.studentEnrollmentForm.submit();
        }


        function reset() {
            document.getElementById("studentEnrollmentForm").reset();
        }

        function checkValidStudentRollNumber() {
            var searchText = document.getElementById('searchText').value;
            if (searchText == null || searchText == "") {
                alert("Please Enter Roll Number in Search Box");
                document.getElementById('searchText').focus();
                return false;
            }

            alert('Search with RollNum : ' + searchText);

            $.ajax({
                type: "POST",
                url: "/UAMS-WebApp/studentEnrollment.do",
                data: {
                    "rollNum": searchText
                },
                success: function (response) {
                    if (response == 'false') {
                        alert('There is No Student found with this RollNumber :' + searchText);
                        document.getElementById('rollNum').focus();
                        return false;
                    }
                    else {
                        searchForm();
                    }
                }
            });
        }

        function searchForm() {
            document.studentEnrollmentForm.action = "studentEnrollment.do";
            document.studentEnrollmentForm.submit();
        }

        $(function () {
            $("#dateEnrolled").datepicker({
                showOn: "button",
                buttonImage: "images/calendar.gif",
            });
        });
        
    </script>

