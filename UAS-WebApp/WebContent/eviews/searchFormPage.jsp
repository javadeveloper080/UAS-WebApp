<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" "http://www.w3.org/TR/REC-html40/loose.dtd">
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta content="utf-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="Dashboard">
        <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

        <title>Fee Category Type</title>

        <!-- Bootstrap core CSS -->
        <!--    <link href="assets/css/bootstrap.css" rel="stylesheet">-->
        <script src="assets/css/bootstrap.min.css"></script>
        
        <!--external css-->
        <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />

        <!-- Custom styles for this template -->
        <link href="assets/css/style.css" rel="stylesheet">
        <link href="assets/css/style-responsive.css" rel="stylesheet">
        
        <link href="http://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css" rel="stylesheet"/>

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

                <!-- FIRST BASIC FORM ELEMENTS -->
                <div class="row mt">
                    <div class="col-lg-12">
                        <div class="form-panel">
                            <input type="text" id="search" name="search" class="search" />
                            <input type="button" value="Seach" id="showTable"/>
                        </div>
                    </div><!-- col-lg-12-->      	
                </div> <!--  /row -->
                
                <!-- BASIC FORM ELEMENTS -->
                <div class="row mt">
                    <div class="col-lg-12">
                        <div class="form-panel">

                            <h5><Strong>Add/Edit User type</Strong> </h5>
                             <html:form  styleClass="" action="/userAction" method="post">
                                
                                
                                <div class="row">
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <label for="registrationNum">User Name:</label>
                                            <html:text name="userForm" property="userName" styleClass="form-control" styleId="userName"  maxlength="50"  />
                                        </div>
                                    </div>
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <label for="chassisNum">Password:</label>
                                            <html:password name="userForm" property="password" styleClass="form-control" styleId="password"  maxlength="50"  />
                                        </div>
                                    </div>
                                </div>
                                        
                               <div class="row">
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <label for="registrationNum">Re Enter Password:</label>
                                            <html:password name="userForm" property="password" styleClass="form-control" styleId="password1"  maxlength="50"  />
                                        </div>
                                    </div>
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <label for="chassisNum">Email:</label>
                                            <html:text name="userForm" property="email" styleClass="form-control" styleId="email"  maxlength="100"  />
                                        </div>
                                    </div>
                                </div>
                                        
                                <div class="row">
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <label for="registrationNum">User Role:</label>
                                            <html:select  styleClass="form-control" property="userTypeId" styleId="userTypeId">
                                                <html:option value="0">Select a user type</html:option>
                                                <html:optionsCollection   name="userForm"
                                                                  property="userTypeList" label="code" value="id" />
                                            </html:select>
                                        </div>
                                    </div>
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <label for="chassisNum">In Active :</label>
                                            <html:text name="userForm" property="inActiveOn" styleClass="form-control " styleId="inActiveOn" />
                                        </div>
                                    </div>
                                </div>

                                <html:hidden name="userForm" property="id" styleId="id"/>
                                <html:hidden name="userForm" property="pageName" styleId="pageName" />
                                <div align="center">
                                    <html:button property="addBtn" styleClass="btn-theme" value="Apply" onclick="validateForm();" />
                                    <html:button property="rsetBtn" styleClass="btn-theme" value="Reset" onclick="rset();" />
                                </div> 
                            </html:form>


                        </div>
                    </div><!-- col-lg-12-->      	


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
    
    
    <script src="http://code.jquery.com/jquery-1.10.2.js"></script>
    <script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
    
  
    
    
    <!--common script for all pages-->
    <script src="assets/js/common-scripts.js"></script>
    
    

    <!--script for this page-->

    <script>

                    function isEmail(email) {
                        var regex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
                        return regex.test(email);
                    }
                    $(function () {
                        $("#inActiveOn").datepicker({
//                                                                showOn: "button",
//                                                                buttonImage: "images/calendar.gif",
                        });
                    });

                    function validateForm() {
                        alert("Validate Form Values");
                        // get the form values
                        var userName = document.getElementById('userName').value;
                        var password = document.getElementById('password').value;
                        var password1 = document.getElementById('password1').value;
                        var inActiveOn = document.getElementById('inActiveOn').value;
                        var email = document.getElementById('email').value;
                        var id = document.getElementById('id').value;

                        if (userName == null || userName == "") {
                            alert("Please Enter userName");
                            document.getElementById('userName').cfocus();
                            return false;
                        }

                        if (password == null || password == "") {
                            alert("Please Enter password");
                            document.getElementById('password').focus();
                            return false;
                        }

                        if (password1 == null || password1 == "") {
                            alert("Please Re Enter password");
                            document.getElementById('password1').focus();
                            return false;
                        }

                        if (password != password1) {
                            alert("Password is not matching, Please Re Enter password");
                            document.getElementById('password1').focus();
                            return false;
                        }
                        if (email == null || email == "")
                        {
                            alert("Please Enter email");
                            document.getElementById('email').focus();
                            return false;
                        } else if (!isEmail(email))
                        {
                            alert("Please enter correct email format");
                            document.getElementById('email').focus();
                            return false;
                        }

                        $.ajax({
                            type: "POST",
                            url: "/UAMS-WebApp/userAction.do?method=usersPage",
                            data: {
                                "userName": userName,
                                "pageName": "checkUniqueUserName",
                                "id": id,
                                "inActiveOn": inActiveOn,
                                "email": email
                            },
                            success: function (response) {
                                if (response == 'true') {
                                    alert('Code is ' + userName + ' present');
                                    document.getElementById('userName').focus();
                                    return false;
                                }
                                else {
                                    submitForm();
                                }
                            },
                            error: function (e) {
                                alert('Error: ' + e);
                                return false;
                            }
                        });
                    }


                    function getEditTypeForm(id) {
                        alert('Get Editff Type' + id);
                        document.getElementById('id').value = id;
                        document.getElementById('pageName').value = "GetEditTypeForm"
                        document.userForm.action = "userAction.do?method=usersPage";
                        document.userForm.submit();
                    }

                    function submitForm() {
                        alert('Submit Form');
                        var id = document.getElementById('id').value;
                        if (id != null && id > 0) {
                            document.getElementById('pageName').value = "SubmitEditType"
                        } else {
                            document.getElementById('pageName').value = "SubmitAddType"
                        }
                        document.userForm.action = "userAction.do?method=usersPage";
                        document.userForm.submit();
                    }


                    function rset()
                    {
                        alert('reset');
                        document.getElementById('userName').value = "";
                        document.getElementById('password').value = "";
                        document.getElementById('email').value = "";
                        document.getElementById('password1').value = "";
                        document.getElementById('userTypeId').value = 0;
                        document.getElementById('id').value = "0";
                        document.getElementById('pageName').value = "";
                        document.getElementById('inActiveOn').value = "";

                    }
                    
            $(document).ready(function() {
            $("#tablediv").hide();
            $("#showTable").click(function(event){
                var name = document.getElementById("search").value;
                $.get( "/UAMS-WebApp/transportModuleAction.do?method=getAllbusFacultyPage", { busNum: name,registrationNum:1} )
                        .done(function( responseJson ) {
                            if(responseJson!=null){
                        $("#searchResTable").find("tr:gt(0)").remove();
                        var table1 = $("#searchResTable");
                        $.each(responseJson, function(key,value) { 
                            var rowNew = $("<tr><td></td><td></td><td></td><td></td><td></td><td></td></tr>");
                            rowNew.children().eq(0).text(value['firstName']); 
                            rowNew.children().eq(1).text(value['lastName']); 
                            rowNew.appendTo(table1);
                        });
                    }
                });
                $("#tablediv").show();    
                if(responseJson!=null){
                $.each(responseJson, function(key,value) { 
                            var rowNew = $("<tr><td></td><td></td><td></td><td></td><td></td><td></td></tr>");
                            rowNew.children().eq(0).text(value['firstName']); 
                            rowNew.children().eq(1).text(value['lastName']); 
                            rowNew.appendTo(table1);
                        });
                    }
            });      
        });
    </script>

</body>
</html>
