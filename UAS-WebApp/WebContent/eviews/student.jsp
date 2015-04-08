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
                        <h5><Strong>Add/Edit Fee type</Strong> </h5>
                                <html:form  styleClass="form-horizontal style-form" action="/studentAction" method="post" styleId="studentFrom">

                            <div class="row">
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        Admin Number : <html:text  property="admnNum"  styleId="admnNum"   styleClass="form-control" />
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
                                        Sex : <html:select  property="genderType" styleId="genderType" styleClass="form-control" >
                                            <html:option value="MALE">Male</html:option>
                                            <html:option value="FEMALE">Female</html:option>
                                        </html:select>
                                    </div>

                                </div>
                            </div>

                            <div class="row">
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        Mobile No : <html:text  property="mobile"  styleId="mobile"  styleClass="form-control" />
                                    </div>

                                </div>
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">

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
                                        Mother : <html:text  property="motherName"  styleId="motherName"   styleClass="form-control" />
                                    </div>

                                </div>
                            </div>

                            <!--html:text  property="branchName" size="30" styleId="description"  maxlength="100" /-->
                            <html:hidden property="pageName" styleId="pageName" />
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
        var admnNum = document.getElementById('admnNum').value;
        var rollNum = document.getElementById('rollNum').value;
        var firstName = document.getElementById('firstName').value;
        var lastName = document.getElementById('lastName').value;
        var motherName = document.getElementById('motherName').value;
        var fatherName = document.getElementById('fatherName').value;
        var mobile = document.getElementById('mobile').value;
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
            document.getElementById('mobile').focus();
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

    function getEditTypeForm(id) {
        alert('Get Editff Type' + id);
        document.getElementById('id').value = id;
        document.getElementById('pageName').value = "GetEditTypeForm"
        document.studentForm.action = "typeTableAction.do?method=feeTypePage";
        document.studentForm.submit();
    }

    function submitForm() {
        var id = document.getElementById('admnNum').value;
        if (id != null && id > 0) {
            document.getElementById('pageName').value = "SubmitEditType"
        } else {
            document.getElementById('pageName').value = "SubmitAddType"
        }
        document.studentForm.action = "studentAction.do";
        document.studentForm.submit();
    }


    function reset() {
        document.getElementById("studentFrom").reset();
    }
    $(function () {
        $("#dob").datepicker({
            showOn: "button",
            buttonImage: "images/calendar.gif",
        });
    });
</script>

