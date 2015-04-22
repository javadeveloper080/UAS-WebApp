<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>

        
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
                                
                                <p><em>To Add New Student Profile,Search Enrollment Number</em></p>
                                <div class="row">
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <html:text name="studentForm" property="enrollmentNumSearch" styleId="enrollmentNumSearch" styleClass="form-control" />
                                            <html:button property="enrollmentNumSearchButton" styleClass="btn-theme" value="Search" onclick="checkValidStudentEnrollmentNumber();" />
                                        </div>
                                    </div>
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <label for="enrollmentNumber">Student Enrollment Number</label>
                                            <html:text name="studentForm" property="enrollmentNumber" styleId="enrollmentNumber"  readonly="true"/>
                                        </div>
                                    </div>         
                                </div>
                                
                                <hr />
                                <p><em>To Edit/Update Student Profile,Search By Roll Number.</em></p>
                                <!-- Search functionalities  -->
                                <div class="row">
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <html:text name="studentForm" property="studentRollNumSearch" styleId="studentRollNumSearch" styleClass="form-control" />
                                            <html:button property="searchButton" styleClass="btn-theme" value="Search" onclick="checkValidStudentRollNumber();" />
                                        </div>
                                    </div>
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <label for="rollNum">Student Roll Number & Full Name.</label>
                                            <html:text name="studentForm" property="studentRollNum" styleId="studentRollNum"  readonly="true"/>
                                            <html:text name="studentForm" property="studentFullName" styleId="studentFullName"  readonly="true"/>
                                        </div>
                                    </div>         
                                </div>
                                <hr />
                                <h5><p ><em><strong style="color:blue"><bean:write name="studentForm" property="statusMessage" /></strong></em></p></h5>
                                
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
                                    <html:button property="rset" styleClass="btn-theme" value="Reset" onclick="reset();" />
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
            var enrollmentNumber = document.getElementById('enrollmentNumber').value;
            var firstName = document.getElementById('firstName').value;
            var lastName = document.getElementById('lastName').value;
            var motherName = document.getElementById('motherName').value;
            var fatherName = document.getElementById('fatherName').value;
            var mobile = document.getElementById('studentMob').value;
            var dob = document.getElementById('dob').value;
            var genderType = document.getElementById('genderType').value;
            var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
         
         
            var nationality = document.getElementById('nationality').value;
            var seatCategoryType = document.getElementById('seatCategoryType').value;
         
         
  
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
        
            if (genderType === null || genderType === "") {
                alert("Please Select gender type");
                document.getElementById('genderType').focus();
                return false;
            }
         
         
            if (enrollmentNumber === null || enrollmentNumber === "") {
                alert("Please Enter Enrollment Number");
                document.getElementById('enrollmentNumber').cfocus();
                return false;
            }
        
            if (mobile === null || mobile === "") {
                alert("Please Enter Mobile");
                document.getElementById('studentMob').focus();
                return false;
            }
        
            if(isNaN(mobile)){
                alert('Please Enter Numeric value for Mobile');
                document.getElementById('studentMob').focus;
                return false;

            }
        
         
            if (email === null || email === "") {
                alert("Please Enter Email");
                document.getElementById('email').focus();
                return false;
            }
        
            if (!filter.test(email.value)) {
                alert('Please provide a valid email address');
                document.getElementById('email').focus;
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

      
            if (nationality === null || nationality === "") {
                alert("Please Enter Nationality");
                document.getElementById('nationality').focus();
                return false;
            }
            if (seatCategoryType === null || seatCategoryType === "") {
                alert("Please Enter Nationality");
                document.getElementById('nationality').focus();
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
            document.getElementById('enrollmentNumSearch').value = "";
            document.studentForm.action = "studentAction.do?method=studentPage";
            document.studentForm.submit();
        }


        function reset() {
            alert('reset')
            //document.getElementById("studentForm").reset();
        }
    
        function checkValidStudentRollNumber() {
            document.getElementById('enrollmentNumSearch').value = "";
            var   searchText= document.getElementById('studentRollNumSearch').value;
            if (searchText== null || searchText =="") {
                alert("Please Enter Roll Number in Search Box");
                document.getElementById('studentRollNumSearch').focus();
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
                        document.getElementById('studentRollNumSearch').focus();
                        return false;
                    }
                    else{
                        searchExistingForm();
                    }
                }
            });
        }
    
        function checkValidStudentEnrollmentNumber() {
            var   searchText= document.getElementById('enrollmentNumSearch').value;
            if (enrollmentNumSearch== null || enrollmentNumSearch =="") {
                alert("Please Enter Enrollment Number in Search Box");
                document.getElementById('enrollmentNumSearch').focus();
                return false;
            }
            
            alert('Search with Enrollment Number : '+searchText);
				
            $.ajax({
                type: "POST",
                url: "/UAMS-WebApp/studentAction.do?method=findByStudentEnrollmentNumber",
                data: {
                    "enrollmentNumSearch": searchText
                },
                    
                success: function(response){
                    if(response=='EnrollmentNoFound'){
                        alert('There is No Student found with this Enrollment Number :'+searchText);
                        document.getElementById('enrollmentNumSearch').focus();
                        return false;
                    }else if(response=='true'){
                        searchNewForm();
                    }
                    else if(response!=null){
                        alert('The Enrollment number  already has a student profile with this Rollnumber:'+response);
                        document.getElementById('enrollmentNumSearch').focus();
                        return false;
                    }
                }
            });
        }
    
        function searchExistingForm(){	
            document.studentForm.action="studentAction.do?method=studentPage";
            document.studentForm.submit();
        }
    
        function searchNewForm(){	
            var   enrollmentNumSearch= document.getElementById('enrollmentNumSearch').value;
            document.getElementById('enrollmentNumSearch').value = enrollmentNumSearch;
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
    
