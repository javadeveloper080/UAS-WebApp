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
                            <h5><Strong>Add/Edit Student Address</Strong> </h5>
                                    <html:form  styleClass="" action="/studentAddressAction" method="post" styleId="studentAddressForm">
                                
                                
                                <div class="row">
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <html:text name="studentAddressForm" property="searchText" styleId="searchText" styleClass="form-control" />
                                            <html:button property="searchButton" styleClass="btn-theme" value="Search" onclick="checkValidStudentRollNumber();" />
                                        </div>
                                    </div>
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <label for="addrLine1">Student Roll Number & Full Name.</label>
                                            <html:text name="studentAddressForm" property="rollNum" styleId="rollNum"  readonly="true"/>
                                            <html:text name="studentAddressForm" property="studentFullName" styleId="studentFullName"  readonly="true"/>
                                        </div>
                                    </div>         
                                    
                                    
                                </div>
                                
                                <div class="row">
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <label for="addressType">Address Type.</label>
                                            <html:select property="addressType" styleId="addressType" styleClass="form-control">
                                                <html:option  styleClass="form-control" value=""></html:option>                                                                                                                                                             
                                                <html:optionsCollection name="studentAddressForm" property="addressTypeList" label="label" value="value" /> 
                                            </html:select>
                                        </div>
                                    </div>
                                    
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <label for="addrLine1">Address Line1.</label>
                                            <html:text name="studentAddressForm" property="addrLine1" styleId="addrLine1" styleClass="form-control"/>
                                        </div>
                                    </div>
                                </div>
                                
                                
                                
                                <div class="row">
                                    
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <label for="addrLine2">Address Line2.</label>
                                            <html:text  name="studentAddressForm" property="addrLine2" styleId="addrLine2" styleClass="form-control"/>
                                        </div>
                                    </div>
                                    
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <label for="addrLine3">Address Line3.</label>
                                            <html:text name="studentAddressForm" property="addrLine3" styleId="addrLine3" styleClass="form-control"/>
                                        </div>
                                    </div>
                                </div>
                                
                                <div class="row">
                                    
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <label for="addrLine4">Address Line4.</label>
                                            <html:text  name="studentAddressForm" property="addrLine4" styleId="addrLine4" styleClass="form-control"/>
                                        </div>
                                    </div>
                                    
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <label for="city">City.</label>
                                            <html:text name="studentAddressForm" property="city" styleId="city" styleClass="form-control"/>
                                        </div>
                                    </div>
                                </div>
                                
                                <div class="row">
                                    
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <label for="stateName">State name.</label>
                                            <html:text  name="studentAddressForm" property="stateName" styleId="stateName" styleClass="form-control"/>
                                        </div>
                                    </div>
                                    
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <label for="country">Country.</label>
                                            <html:text name="studentAddressForm" property="country" styleId="country" styleClass="form-control"/>
                                        </div>
                                    </div>
                                </div>
                                
                                
                                <div class="row">
                                    
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <label for="zipCode">Zip code.</label>
                                            <html:text  name="studentAddressForm" property="zipCode" styleId="zipCode" styleClass="form-control" />
                                        </div>
                                    </div>
                                </div>
                                
                                
                                <html:hidden name="studentAddressForm" property="id" styleId="id"/>
                                <html:hidden name="studentAddressForm" property="studentId" styleId="studentId"/>
                                <html:hidden name="studentAddressForm" property="pageName" styleId="pageName" />
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
                                <h4>Student address table</h4>
                                <hr>
                                
                                <thead>
                                    <tr>
                                        <th scope="col"><i>Student Roll Number</i></th>
                                        <th scope="col"><i>Student Full Name</i></th>
                                        <th scope="col"><i>Address Type</i></th>
                                        <th scope="col"><i>Address Line1</i></th>
                                        <th scope="col"><i>Zip Code</i></th>
                                        <th scope="col"></th>
                                    </tr>
                                </thead>
                                
                                <tbody>
                                    <logic:notEmpty name="studentAddressForm" property="studentAddressList">
                                        <logic:iterate id="studentAddressTable" name="studentAddressForm" property="studentAddressList" type="org.edu.uams.server.pojo.StudentAddressEntity">
                                            <tr>
                                                <td>
                                                    <bean:write name="studentAddressTable" property="student.rollNum"/>
                                                </td>
                                                
                                                <td>
                                                    <bean:write name="studentAddressTable" property="student.studentFullName"/>
                                                </td>
                                                
                                                <td>
                                                    <bean:write name="studentAddressTable" property="addressType"/>
                                                </td>
                                                <td>
                                                    <bean:write name="studentAddressTable" property="addrLine1"/>
                                                </td>
                                                <td>
                                                    <bean:write name="studentAddressTable" property="zipCode"/>
                                                </td>
                                                <td><button class="btn btn-primary btn-xs" onclick='getEditTypeForm(${studentAddressTable.id});'><i class="fa fa-pencil"></i></button></td>
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
            // get the form values
                
            var addressType = document.getElementById('addressType').value;
            var addrLine1 = document.getElementById('addrLine1').value;
            var city = document.getElementById('city').value;
            var zipCode = document.getElementById('zipCode').value;
            var country = document.getElementById('country').value;
            var rollNum = document.getElementById('rollNum').value;
            
            if (addressType === null || addressType ==="") {
                alert("Please select a AddressType");
                document.getElementById('addressType').focus();
                return false;
            }
            if (addrLine1 === null || addrLine1 ==="") {
                alert("Please Enter  Address Line1");
                document.getElementById('addrLine1').focus();
                return false;
            }
            
            if (zipCode === null || zipCode ==="") {
                alert("Please Enter zipCode ");
                document.getElementById('zipCode').focus();
                return false;
            }
            
            if (country === null || country ==="") {
                alert("Please Enter country ");
                document.getElementById('country').focus();
                return false;
            }
               
				
            if (rollNum === null || rollNum ==="") {
                alert("Please Enter Roll Number");
                document.getElementById('rollNum').focus();
                return false;
            }
            
            if (city=== null || city ==="") {
                alert("Please Enter city Name ");
                document.getElementById('city').cfocus();
                return false;
            }
      
            submitForm();
                     
        }

        function getEditTypeForm(id) {
            alert('Get Editff Type'+id);
            document.getElementById('id').value =id;	
            document.getElementById('pageName').value ="GetEditTypeForm"	
            document.studentAddressForm.action="studentAddressAction.do?method=studentAdressPage";
            document.studentAddressForm.submit();
        }
    
        function submitForm() {
            
            
            var id =document.getElementById('id').value;	
            if(id != null && id>0){
                document.getElementById('pageName').value ="SubmitEditType"	
            }else{
                document.getElementById('pageName').value ="SubmitAddType"
            }
            document.getElementById('searchText').value =document.getElementById('rollNum').value ;
            document.studentAddressForm.action="studentAddressAction.do?method=studentAdressPage";
            document.studentAddressForm.submit();
        }
	
        
        function reset(){	
            document.getElementById("studentAddressForm").reset();
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
            document.studentAddressForm.action="studentAddressAction.do?method=studentAdressPage";
            document.studentAddressForm.submit();
        }
       
    </script>
    
    
