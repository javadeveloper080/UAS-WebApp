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
        
        <title>Student Profile</title>
        
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
                        <h5><Strong>Manage Student Profile</Strong> </h5>
                                <html:form  styleClass="" action="/studentAction.do?method=studentPage" method="post" styleId="studentForm">
                             <p><em>To Edit/Update Student Profile,Search By Roll Number.</em></p>
                            <!-- Search functionalities  -->
                            <div class="row">
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        <html:text name="studentForm" property="searchText" styleId="searchText" styleClass="form-control" />
                                        <html:button property="searchButton" styleClass="btn-theme" value="Search" onclick="checkValidStudentRollNumber();" />
                                    </div>
                                </div>
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        <label for="rollNum">Student Roll Number & Full Name.</label>
                                        <html:text name="studentForm" property="rollNum" styleId="rollNum"  readonly="true"/>
                                        <html:text name="studentForm" property="studentFullName" styleId="studentFullName"  readonly="true"/>
                                    </div>
                                </div>         
                            </div>
                                <hr />
                                <h5><p ><em><strong style="color:blue"><bean:write name="studentForm" property="statusMessage" /></strong></em></p></h5>
                            <div class="row">
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        Admission Number : <html:text  property="admnNum"  styleId="admnNum"   styleClass="form-control" />
                                    </div>
                                </div>
                                
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        Roll Number :  <html:text  property="rollNum"  styleId="rollNum"   styleClass="form-control"/>
                                    </div>
                                </div>
                            </div>
                            
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
                                            <html:optionsCollection name="studentForm" property="genderTypeList" label="label" value="value" /> 
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
                            
                            <div class="row">
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        Nationality : <html:text  property="nationality"  styleId="nationality"  styleClass="form-control" />
                                    </div>
                                </div>
                                
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        <label for="seatCategoryType">Seat Category Type.</label>
                                        <html:select property="seatCategoryType" styleId="seatCategoryType" styleClass="form-control">
                                            <html:option  styleClass="form-control" value=""></html:option>                                                                                                                                                             
                                            <html:optionsCollection name="studentForm" property="seatCategoryTypeList" label="label" value="value" /> 
                                        </html:select>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="row">
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        Father Name : <html:text  property="fatherName"  styleId="fatherName"   styleClass="form-control"/>
                                    </div>
                                </div>
                                
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        Mother Name: <html:text  property="motherName"  styleId="motherName"   styleClass="form-control" />
                                    </div>
                                </div>
                            </div>
                        
                        
                        <div class="row">
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <div class="form-group">
                                    Father occupation  : <html:text  property="fatherOccup"  styleId="fatherOccup"   styleClass="form-control"/>
                                </div>
                            </div>
                            <div class="col-xs-6 col-sm-6 col-md-6">
                                <div class="form-group">
                                    Mother occupation: <html:text  property="motherOccup"  styleId="motherOccup"   styleClass="form-control" />
                                </div>
                            </div>
                        </div>
                        
                        <html:hidden name="studentForm" property="id" styleId="id"/>
                        <html:hidden name="studentForm" property="studentId" styleId="studentId"/>
                        <html:hidden name="studentForm" property="pageName" styleId="pageName" />
                        
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
        var firstName = document.getElementById('firstName').value;
        var lastName = document.getElementById('lastName').value;
        var motherName = document.getElementById('motherName').value;
        var fatherName = document.getElementById('fatherName').value;
        var mobile = document.getElementById('studentMob').value;
        var dob = document.getElementById('dob').value;
        var genderType = document.getElementById('genderType').value;
        if (admnNum === null || admnNum === "") {
            alert("Please Enter Admin Number");
            document.getElementById('admnNum').cfocus();
            return false;
        }

        else if (rollNum === null || rollNum === "") {
            alert("Please Enter Roll Number");
            document.getElementById('rollNum').focus();
            return false;
        }
        else if (firstName === null || firstName === "") {
            alert("Please Enter Student First Name");
            document.getElementById('firstName').focus();
            return false;
        }
        if (lastName === null || lastName === "") {
            alert("Please Enter Student Last Name");
            document.getElementById('lastName').focus();
            return false;
        }
        if (fatherName === null || fatherName === "") {
            alert("Please Enter Father Name");
            document.getElementById('fatherName').focus();
            return false;
        }
        if (motherName === null || motherName === "") {
            alert("Please Enter Mother");
            document.getElementById('motherName').focus();
            return false;
        }
        if (mobile === null || mobile === "") {
            alert("Please Enter Mobile");
            document.getElementById('studentMob').focus();
            return false;
        }
        if (dob === null || dob === "") {
            alert("Please Enter Date Of Birth");
            document.getElementById('dob').focus();
            return false;
        }
        if (genderType === null || genderType === "") {
            alert("Please Select gender type");
            document.getElementById('genderType').focus();
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
        document.studentForm.action = "studentAction.do?method=studentPage";
        document.studentForm.submit();
    }


    function reset() {
        document.getElementById("studentForm").reset();
    }
    
    function checkValidStudentRollNumber() {
        var   searchText= document.getElementById('searchText').value;
        if (searchText== null || searchText =="") {
            alert("Please Enter Roll Number in Search Box");
            document.getElementById('searchText').focus();
            return false;
        }
            
        alert('Search with RollNum : '+searchText);
				
        $.ajax({
            type: "POST",
            url: "/UAMS-WebApp/studentAction.do?method=findByStudentRollNumber",
            data: {
                "rollNum": searchText
            },
                    
            success: function(response){
                if(response=='false'){
                    alert('There is No Student found with this RollNumber :'+searchText);
                    document.getElementById('rollNum').focus();
                    return false;
                }
                else{
                    searchForm();
                }
            }
        });
    }
    
    function searchForm(){	
        document.studentForm.action="studentAction.do?method=studentPage";
        document.studentForm.submit();
    }
    
    $(function () {
        $("#dob").datepicker({
            showOn: "button",
            buttonImage: "images/calendar.gif",
        });
    });
</script>

