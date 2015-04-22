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
                
                
                <!-- GRID ELEMENTS -->
                <div class="row mt">
                    <div class="col-md-12">
                        <div class="content-panel">
                            <table class="table table-striped table-advance table-hover">
                                <h4><i class="fa fa-angle-right"></i> User type Table</h4>
                                <hr>
                                <thead>
                                    <tr>
                                        <th><i class="fa fa-bullhorn"></i> User Name</th>
                                        <th class="hidden-phone"><i class="fa fa-question-circle"></i> Password</th>
                                        <th class="hidden-phone"><i class="fa fa-question-circle"></i> Email</th>
                                        <th class="hidden-phone"><i class="fa fa-question-circle"></i> Role</th>
                                        <th class="hidden-phone"><i class="fa fa-question-circle"></i> In Active</th>
                                </thead>
                                <tbody>
                                    <logic:notEmpty name="userForm" property="usersList">
                                        <logic:iterate id="users" name="userForm" property="usersList" type="org.edu.uams.server.pojo.UserMasterEntity">
                                            <tr>
                                                <td><bean:write name="users" property="userName"/></td>
                                                <td><bean:write name="users" property="password"/></td>
                                                <td><bean:write name="users" property="email"/></td>
                                                <td><bean:write name="users" property="userType.code"/></td>
                                                <td><bean:write name="users" property="inActiveOn"/></td>
                                                <td><button class="btn btn-primary btn-xs" onclick='getEditTypeForm(${users.id});'><i class="fa fa-pencil"></i></button></td>
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



<!--script for this page-->

<script>

    function isEmail(email) {
        var regex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
        return regex.test(email);
    }
    $(function () {
        $("#inActiveOn").datepicker({
            showOn: "button",
            buttonImage: "images/calendar.gif",
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
</script>

