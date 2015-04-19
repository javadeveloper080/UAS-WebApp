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

        <title>Student Fee</title>

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
                            <h5><Strong>Manage Student Fee </Strong> </h5>
                                    <html:form  styleClass="" action="/studentFeeAction.do?method=studentFeePage" method="post">

                                <div class="row">
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <html:text name="studentFeeForm" property="searchText" styleId="searchText" styleClass="form-control" />
                                            <html:button property="searchButton" styleClass="btn-theme" value="Search" onclick="checkValidStudentRollNumber();" />
                                        </div>
                                    </div>
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <label for="addrLine1">Student Roll Number & Full Name.</label>
                                            <html:text name="studentFeeForm" property="rollNum" styleId="rollNum"  readonly="true"/>
                                            <html:text name="studentFeeForm" property="studentName" styleId="studentName"  readonly="true"/>
                                        </div>
                                    </div>         
                                </div>

                              
                                <div class="row">
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            Total Amount: <html:text  property="totalAmount"  styleId="totalAmount"   styleClass="form-control" />
                                        </div>
                                    </div>

                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            Fee Payment Date : <html:text  property="feePaymentDate"  styleId="feePaymentDate"   styleClass="form-control"/>
                                        </div>
                                    </div>

                                </div>
                                <div class="row">
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            Discount Type: <html:text  property="discountType"  styleId="discountType"   styleClass="form-control" />
                                        </div>
                                    </div>

                                   <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            Fee Name:  <html:text  property="feeName"  styleId="feeName"   styleClass="form-control"/>
                                        </div>
                                    </div>

                                </div>

                                <div class="row">
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <label for="feeTypeId">Fee Type:</label>
                                            <html:select  styleClass="form-control" property="feeTypeId" styleId="feeTypeId">
                                                <html:option value="0">Select fee type</html:option>
                                                <html:optionsCollection   name="studentFeeForm"
                                                                          property="feeTypeEntitys" label="code" value="id" />
                                            </html:select>
                                        </div>
                                    </div>

                                </div>

                                <html:hidden name="studentFeeForm" property="id" styleId="id"/>
                                <html:hidden name="studentFeeForm" property="feeTypeId" styleId="feeTypeId"/>
                                <html:hidden name="studentFeeForm" property="studentId" styleId="studentId"/>
                                <html:hidden name="studentFeeForm" property="pageName" styleId="pageName" />
                                <div align="center">
                                    <html:button property="addBtn" styleClass="btn-theme" value="Apply" onclick="validateForm();" />
                                    <html:button property="rsetBtn" styleClass="btn-theme" value="Reset" onclick="rset();" />
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
                                <h4><i>Student Fee Table</i></h4>
                                <hr>
                                <thead>
                                    <tr>
                                        <th> Roll Number</th>
                                        <th> Fee Name</th>
                                        <th> Total Amount:</th>
                                        <th> Fee Payment Date</th>
                                        <th> Discount Type</th>
                                        <th> Student Name</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <logic:notEmpty name="studentFeeForm" property="studentFeeEntitys">
                                        <logic:iterate id="studentFee" name="studentFeeForm" property="studentFeeEntitys" type="org.edu.uams.server.pojo.FeeCategoryTypeEntity">
                                            <tr>
                                                <td><bean:write name="studentFee" property="rollNum"/></td>
                                                <td><bean:write name="studentFee" property="feeName"/></td>
                                                <td><bean:write name="studentFee" property="totalAmount"/></td>
                                                <td><bean:write name="studentFee" property="feePaymentDate"/></td>
                                                <td><bean:write name="studentFee" property="discountType"/></td>
                                                <td><bean:write name="studentFee" property="studentName"/></td>
                                                <td><button class="btn btn-primary btn-xs" onclick='getEditTypeForm(${studentFee.id});'><i class="fa fa-pencil"></i></button></td>
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

    <script>


                                                    function validateForm() {
                                                        
                                                        submitForm();
                                                    }

                                                    function searchForm() {
                                                        document.studentFeeForm.action = "studentFeeAction.do?method=studentFeePage";
                                                        document.studentFeeForm.submit();
                                                    }
                                                    function getEditTypeForm(id) {
                                                        alert('Get Editff Type' + id);
                                                        document.getElementById('id').value = id;
                                                        document.getElementById('pageName').value = "GetEditTypeForm"
                                                        document.studentFeeForm.action = "studentFeeAction.do?method=studentFeePage";
                                                        document.studentFeeForm.submit();
                                                    }

                                                    function submitForm() {
                                                        alert('Submit Form');
                                                        var id = document.getElementById('id').value;
                                                        if (id != null && id > 0) {
                                                            document.getElementById('pageName').value = "SubmitEditType"
                                                        } else {
                                                            document.getElementById('pageName').value = "SubmitAddType"
                                                        }
                                                        document.studentFeeForm.action = "studentFeeAction.do?method=studentFeePage";
                                                        document.studentFeeForm.submit();
                                                    }


                                                    function rset()
                                                    {
                                                        alert('reset');
                                                        document.getElementById('searchText').value = "";
                                                        document.getElementById('rollNum').value = "";
                                                        document.getElementById('feeName').value = "";
                                                        document.getElementById('totalAmount').value = "0.0";
                                                        document.getElementById('feePaymentDate').value = "";
                                                        document.getElementById('discountType').value = "";
                                                        document.getElementById('studentName').value = "";
                                                        document.getElementById('feeTypeId').value = "0";
                                                        document.getElementById('id').value = "0";
                                                        document.getElementById('pageName').value = "";

                                                    }
                                                    $(function () {
                                                        $("#feePaymentDate").datepicker({
                                                            showOn: "button",
                                                            buttonImage: "images/calendar.gif",
                                                        });
                                                    });

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
                                                            url: "/UAMS-WebApp/studentFeeAction.do?method=studentFeePage",
                                                            data: {
                                                                "searchText": searchText
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
    </script>

</body>
</html>
