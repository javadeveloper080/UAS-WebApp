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
                            <h5><Strong>Add/Edit Bus Faculty</Strong> </h5>
                                    <html:form  styleClass="" action="/transportModuleAction" method="post">
                                
                                <div class="row">
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            First name :  <html:text name="transportModuleForm" property="firstName" styleId="firstName" styleClass="form-control"/>
                                        </div>
                                    </div>
                                    
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            Last name  :  <html:text name="transportModuleForm" property="lastName" styleId="lastName" styleClass="form-control"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            Address Line1 :   <html:text name="transportModuleForm" property="addrLine1" styleId="addrLine1" styleClass="form-control"/>
                                        </div>
                                    </div>
                                    
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            Address Line2  :  <html:text name="transportModuleForm" property="addrLine2" styleId="addrLine2" styleClass="form-control"/>
                                        </div>
                                    </div>
                                </div>
                                
                                <div class="row">
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            Address Line4 :  <html:text name="transportModuleForm" property="addrLine4" styleId="addrLine4" styleClass="form-control"/>
                                        </div>
                                    </div>
                                    
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            City  : <html:text name="transportModuleForm" property="city" styleId="city" styleClass="form-control"/>
                                        </div>
                                    </div>
                                </div>
                                
                                <div class="row">
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            State :  <html:text name="transportModuleForm" property="stateName" styleId="stateName" styleClass="form-control"/>
                                        </div>
                                    </div>
                                    
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            Zip code  :<html:text name="transportModuleForm" property="zipCode" styleId="zipCode" styleClass="form-control"/>
                                        </div>
                                    </div>
                                </div>
                                
                                <div class="row">
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            Mobile :  <html:text name="transportModuleForm" property="mobile" styleId="mobile" styleClass="form-control"/>
                                        </div>
                                    </div>
                                    
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <label for="facultyType">Faculty type.</label>
                                            <html:select property="facultyType" styleId="facultyType" styleClass="form-control">
                                                <html:option  styleClass="form-control" value=""></html:option>                                                                                                                                                             
                                                <html:optionsCollection name="transportModuleForm" property="facultyTypeList" label="label" value="value" /> 
                                            </html:select>
                                        </div>
                                    </div>
                                    
                                </div>
                                
                                <div class="row">
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            License Number : <html:text name="transportModuleForm" property="licenseNum" styleId="licenseNum" styleClass="form-control"/>
                                        </div>
                                    </div>
                                    
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            License  expiry date  : <html:text name="transportModuleForm" property="licenseExpiryDate" styleId="licenseExpiryDate" styleClass="form-control"/>
                                        </div>
                                    </div>
                                </div>
                                
                                
                                <html:hidden name="transportModuleForm" property="id" styleId="id"/>
                                <html:hidden name="transportModuleForm" property="pageName" styleId="pageName" />
                                <div align="center">
                                    <html:button property="addBtn" styleClass="btn-theme" value="Apply" onclick="validateForm();" />
                                    <html:button property="resetBtn" styleClass="btn-theme" value="Reset" onclick="reset();" />
                                </div> 
                                
                                
                            </html:form>
                        </div>
                    </div><!-- col-lg-12-->      	
                </div> <!--  /row -->
                
                
                
                
                <!-- GRID ELEMENTS -->
                <div class="row mt">
                    <div class="col-md-12">
                        <div class="content-panel">
                            <table class="table table-striped table-advance table-hover">
                                <h4><i> Bus Faculty Table</i></h4>
                                <hr>
                                <thead>
                                    <tr>
                                        <th><i > First name</i></th>
                                        <th><i > Last name</i></th>
                                        <th><i > Address</i> </th>
                                        <th><i > Mobile</i></th>
                                        <th><i > License expiry Date</i></th>
                                        <th><i > Faculty Type</i></th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <logic:notEmpty name="transportModuleForm" property="busFacultyList">
                                        <logic:iterate id="transportFacultyTable" name="transportModuleForm" property="busFacultyList" type="org.edu.uams.server.pojo.BusFacultyEntity">
                                            <tr>
                                                <td><bean:write name="transportFacultyTable" property="firstName"/></td>
                                                <td><bean:write name="transportFacultyTable" property="lastName"/></td>
                                                <td><bean:write name="transportFacultyTable" property="addrLine1"/></td>
                                                <td><bean:write name="transportFacultyTable" property="mobile"/></td>
                                                <td><bean:write name="transportFacultyTable" property="licenceExpiryDate"/></td>
                                                <td><bean:write name="transportFacultyTable" property="facultyType"/></td>
                                                <td><button class="btn btn-primary btn-xs" onclick='getEditTypeForm(${transportFacultyTable.id});'><i class="fa fa-pencil"></i></button></td>
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
            
            
        function validateForm() {
            alert("Validate Form Values");
            // get the form values
            var lastName = document.getElementById('lastName').value;
            var firstName = document.getElementById('firstName').value;
                
            if (lastName== null || lastName =="") {
                alert("Please Last name");
                document.getElementById('lastName').cfocus();
                return false;
            }
				
            if (firstName == null || firstName =="") {
                alert("Please Enter First name");
                document.getElementById('firstName').focus();
                return false;
            }
      
            submitForm();
        }


        function getEditTypeForm(id) {
            alert('Get Editff Type'+id);
            document.getElementById('id').value =id;	
            document.getElementById('pageName').value ="GetEditTypeForm"	
            document.transportModuleForm.action="transportModuleAction.do?method=busFacultyPage";
            document.transportModuleForm.submit();
        }
    
        function submitForm() {
            alert('Submit Form');
            var id =document.getElementById('id').value;	
            if(id != null && id>0){
                document.getElementById('pageName').value ="SubmitEditType"	
            }else{
                document.getElementById('pageName').value ="SubmitAddType"
            }
            document.transportModuleForm.action="transportModuleAction.do?method=busFacultyPage";
            document.transportModuleForm.submit();
        }
	
        
        function reset()
        {	
            alert('reset');
            //            document.getElementById('code').value="";
            //            document.getElementById('description').value="";
            //            document.getElementById('id').value="0";
            //            document.getElementById('pageName').value="";
		
        }
        
        $(function() {
            $( "#licenseExpiryDate" ).datepicker({
                showOn: "button",
                buttonImage: "images/calendar.gif",
            });
        });
                
       
        
        
    </script>
    
