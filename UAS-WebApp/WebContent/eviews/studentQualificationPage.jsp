<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>

<!-- Bootstrap core CSS -->
<link href="assets/css/bootstrap.css" rel="stylesheet">
<!--external css-->
<link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />

<!-- Custom styles for this template -->
<link href="assets/css/style.css" rel="stylesheet">
<link href="assets/css/style-responsive.css" rel="stylesheet">

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
                        <h5><Strong>Add/Edit Student Qualification</Strong> </h5>
                                <html:form  styleClass="form-horizontal style-form" action="/studentAction?method=studentQualificationPage" method="post" styleId="studentQlfForm">

                            <div class="row">
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        Degree Name Institution  : <html:text  property="degNameInstitution"  styleId="degNameInstitution"   styleClass="form-control"/>
                                    </div>
                                </div>
                              <div class="row">
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        Degree Medium  : <html:text  property="degMedium"  styleId="degMedium"   styleClass="form-control"/>
                                    </div>
                                </div>
                                    
                                    <div class="row">
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        Degree Division  : <html:text  property="degDivision"  styleId="degDivision"   styleClass="form-control"/>
                                    </div>
                                </div>
                                    
                            <div class="row">
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        Degree Percentage : <html:text  property="degPercentage"  styleId="degPercentage"   styleClass="form-control" />
                                    </div>
                                </div>

                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        Degree Year Of Pass :  <html:text  property="degYearOfPass"  styleId="degYearOfPass"   styleClass="form-control"/>
                                    </div>
                                </div>

                            </div>
                                    
                            <div class="row">
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        Diploma Name Institution  : <html:text  property="dipNameInstitution"  styleId="dipNameInstitution"   styleClass="form-control"/>
                                    </div>
                                </div>
                              <div class="row">
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        Diploma Medium  : <html:text  property="dipMedium"  styleId="dipMedium"   styleClass="form-control"/>
                                    </div>
                                </div>
                                    
                                    <div class="row">
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        Diploma Division  : <html:text  property="dipDivision"  styleId="dipDivision"   styleClass="form-control"/>
                                    </div>
                                </div>
                                    
                            <div class="row">
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        Diploma Percentage : <html:text  property="dipPercentage"  styleId="dipPercentage"   styleClass="form-control" />
                                    </div>
                                </div>

                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        Diploma Year Of Pass :  <html:text  property="dipYearOfPass"  styleId="dipYearOfPass"   styleClass="form-control"/>
                                    </div>
                                </div>

                            </div>

                            <div class="row">
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        Inter Name Institution  : <html:text  property="intrInstitutionName"  styleId="intrInstitutionName"   styleClass="form-control"/>
                                    </div>
                                </div>
                              <div class="row">
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        Inter Medium  : <html:text  property="intrMedium"  styleId="intrMedium"   styleClass="form-control"/>
                                    </div>
                                </div>
                                    
                                    <div class="row">
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        Inter Division  : <html:text  property="intrDivision"  styleId="intrDivision"   styleClass="form-control"/>
                                    </div>
                                </div>
                                    
                            <div class="row">
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        Inter Percentage : <html:text  property="intrPercentage"  styleId="intrPercentage"   styleClass="form-control" />
                                    </div>
                                </div>

                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        Inter Year Of Pass :  <html:text  property="intrYearOfPass"  styleId="intrYearOfPass"   styleClass="form-control"/>
                                    </div>
                                </div>

                            </div>

                            <div class="row">
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        Secondary Name Institution  : <html:text  property="secondaryInstitutionName"  styleId="secondaryInstitutionName"   styleClass="form-control"/>
                                    </div>
                                </div>
                              <div class="row">
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        Secondary Medium  : <html:text  property="sMedium"  styleId="sMedium"   styleClass="form-control"/>
                                    </div>
                                </div>
                                    
                                    <div class="row">
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        Secondary Division  : <html:text  property="sdivision"  styleId="sdivision"   styleClass="form-control"/>
                                    </div>
                                </div>
                                    
                            <div class="row">
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        Secondary Percentage : <html:text  property="spercentage"  styleId="spercentage"   styleClass="form-control" />
                                    </div>
                                </div>

                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        Secondary Year Of Pass :  <html:text  property="syearOfPass"  styleId="syearOfPass"   styleClass="form-control"/>
                                    </div>
                                </div>

                            </div>

                            <div class="row">
                                
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <label for="registrationNum">Student :</label>
                                            <html:select  styleClass="form-control" property="studentId" styleId="studentId">
                                                <html:option value="0">Select a user</html:option>
                                                <html:optionsCollection   name="studentQlfForm"
                                                                  property="listOfStudents" label="fullName" value="id" />
                                            </html:select>
                                        </div>
                                    </div>
                            </div>        

                            
                            <!--html:text  property="branchName" size="30" styleId="description"  maxlength="100" /-->
                            <html:hidden property="pageName" styleId="pageName" />
                            <html:hidden property="id" styleId="id" />
                            <div align="center">
                                <html:button property="addBtn" styleClass="btn-theme" value="Apply" onclick="validateForm();" />
                                <html:button property="rsetBtn" styleClass="btn-theme" value="Reset" onclick="reset();" />
                            </div> 


                        </html:form>
                    </div>
                </div><!-- col-lg-12-->      	
            </div><!-- /row -->


            <!-- GRID ELEMENTS -->
           
               <!-- GRID ELEMENTS -->
                <div class="row mt">
                    <div class="col-md-12">
                        <div class="content-panel">
                            

                            <table class="table table-bordered table-striped table-condensed cf">
                                <h4>Student Details </h4>
                                <hr>
                                <thead class="cf">
                                    <tr>
                                        <th class="numeric">Degree Name Institution</th>
                                        <th class="numeric">Degree Medium</th>
                                        <th class="numeric">Degree Division </th>
                                        <th class="numeric">Degree Percentage </th>
                                        <th class="numeric">Degree Year Of Pass</th>
                                        <th class="numeric">Diploma Name Institution</th>
                                        <th class="numeric">Diploma Medium</th>
                                        <th class="numeric">Diploma Division</th>
                                        <th class="numeric">Diploma Percentage</th>
                                        <th class="numeric">Diploma Year Of Pass</th>
                                        <th class="numeric">Inter Institution Name</th>
                                        <th class="numeric">Inter Medium</th>
                                        <th class="numeric">Inter Division</th>
                                        <th class="numeric">Inter Percentage</th>
                                        <th class="numeric">Inter Year Of Pass</th>
                                        <th class="numeric">Secondary Institution Name</th>
                                        <th class="numeric">Secondary Medium</th>
                                        <th class="numeric">Secondary Division</th>
                                        <th class="numeric">Secondary Percentage</th>
                                        <th class="numeric">Secondary Year Of Pass</th>
                                    </tr>
                                </thead>
    
                                
                                <tbody>
                                    <logic:notEmpty name="studentQlfForm" property="listOfStudentQlfs">
                                        <logic:iterate id="student" name="studentQlfForm" property="listOfStudentQlfs" >
                                            <tr>
                                                <td class="numeric"><bean:write name="student" property="degNameInstitution"/></td>
                                                <td class="numeric"><bean:write name="student" property="degMedium"/></td>
                                                <td class="numeric"><bean:write name="student" property="degDivision"/></td>
                                                <td class="numeric"><bean:write name="student" property="degPercentage"/></td>
                                                <td class="numeric"><bean:write name="student" property="degYearOfPass"/></td>
                                                <td class="numeric"><bean:write name="student" property="dipNameInstitution"/></td>
                                                <td class="numeric"><bean:write name="student" property="dipMedium"/></td>
                                                <td class="numeric"><bean:write name="student" property="dipDivision"/></td>
                                                <td class="numeric"><bean:write name="student" property="dipPercentage"/></td>
                                                <td class="numeric"><bean:write name="student" property="dipYearOfPass"/></td>
                                                <td class="numeric"><bean:write name="student" property="intrInstitutionName"/></td>
                                                <td class="numeric"><bean:write name="student" property="intrMedium"/></td>
                                                <td class="numeric"><bean:write name="student" property="intrDivision"/></td>
                                                <td class="numeric"><bean:write name="student" property="intrPercentage"/></td>
                                                <td class="numeric"><bean:write name="student" property="intrYearOfPass"/></td>
                                                <td class="numeric"><bean:write name="student" property="secondaryInstitutionName"/></td>
                                                <td class="numeric"><bean:write name="student" property="sMedium"/></td>
                                                <td class="numeric"><bean:write name="student" property="sdivision"/></td>
                                                <td class="numeric"><bean:write name="student" property="syearOfPass"/></td>
                                                
                                                <td><button class="btn btn-primary btn-xs" onclick='getEditTypeForm(${student.id});'><i class="fa fa-pencil"></i></button></td>
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
        // get the form values
        var intrInstitutionName = document.getElementById('intrInstitutionName').value;
        var intrMedium = document.getElementById('intrMedium').value;
        var intrDivision = document.getElementById('intrDivision').value;
        var intrPercentage = document.getElementById('intrPercentage').value;
        var intrYearOfPass = document.getElementById('intrYearOfPass').value;
        var fatherName = document.getElementById('fatherName').value;
        var secondaryInstitutionName = document.getElementById('secondaryInstitutionName').value;
        var sMedium = document.getElementById('sMedium').value;
        var sdivision = document.getElementById('sdivision').value;
        if (intrInstitutionName === null || intrInstitutionName === "") {
            alert("Please Enter Inter Institution Name");
            document.getElementById('intrInstitutionName').cfocus();
            return false;
        }

        else if (intrMedium === null || intrMedium === "") {
            alert("Please Enter Inter Medium");
            document.getElementById('intrMedium').focus();
            return false;
        }
        else if (intrDivision === null || intrDivision === "") {
            alert("Please Enter Inter Division");
            document.getElementById('intrDivision').focus();
            return false;
        }
        if (intrPercentage === null || intrPercentage === "") {
            alert("Please Enter Inter Percentage");
            document.getElementById('intrPercentage').focus();
            return false;
        }
         if (fatherName === null || fatherName === "") {
            alert("Please Enter Father Name");
            document.getElementById('fatherName').focus();
            return false;
        }
        if (intrYearOfPass === null || intrYearOfPass === "") {
            alert("Please Enter Inter Year Of Pass");
            document.getElementById('intrYearOfPass').focus();
            return false;
        }
         if (secondaryInstitutionName === null || secondaryInstitutionName === "") {
            alert("Please Enter Secondary Institution Name");
            document.getElementById('secondaryInstitutionName').focus();
            return false;
        }
        if (sMedium === null || sMedium === "") {
            alert("Please Enter Second Medium");
            document.getElementById('sMedium').focus();
            return false;
        }
        if (sdivision === null || sdivision === "") {
            alert("Please Select gender type");
            document.getElementById('sdivision').focus();
            return false;
        }

        submitForm();

    }

    function getEditTypeForm(id) {
        alert('Get Editff Type' + id);
        document.getElementById('id').value = id;
        document.getElementById('pageName').value = "GetEditTypeForm"
        document.studentQlfForm.action = "studentQlfAction.do?method=studentQualificationPage";
        document.studentQlfForm.submit();
    }

    function submitForm() {
        var id = document.getElementById('id').value;
        if (id != null && id > 0) {
            document.getElementById('pageName').value = "SubmitEditType"
        } else {
            document.getElementById('pageName').value = "SubmitAddType"
        }
        document.studentQlfForm.action = "studentQlfAction.do?method=studentQualificationPage";
        document.studentQlfForm.submit();
    }


    function reset() {
        document.getElementById("studentQlfForm").reset();
    }
</script>

