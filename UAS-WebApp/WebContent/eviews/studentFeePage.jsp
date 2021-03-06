<%@taglib uri="/WEB-INF/tld/struts-html.tld" prefix="html"%>
<%@taglib uri="/WEB-INF/tld/struts-logic.tld" prefix="logic"%>
<%@taglib uri="/WEB-INF/tld/struts-bean.tld" prefix="bean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN" "http://www.w3.org/TR/REC-html40/loose.dtd">
<!DOCTYPE html>

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
                                            <label for="rollNum">Student Roll Number & Full Name.</label>
                                            <html:text name="studentFeeForm" property="rollNum" styleId="rollNum"  readonly="true"/>
                                            <html:text name="studentFeeForm" property="studentName" styleId="studentName"  readonly="true"/>
                                        </div>
                                          <font color="red"> <label id="validateRollNum"/></font> 
                                    </div>         
                                </div>
                                
                                <div class="row">    
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <label for="paymentType">Payment Type :</label>
                                            <html:select property="paymentType" styleId="paymentType" styleClass="form-control">
                                                <html:option  styleClass="form-control" value=""></html:option>                                                                                                                                                             
                                                <html:optionsCollection name="studentFeeForm" property="paymentTypeList" label="label" value="value" /> 
                                            </html:select>
                                            <font color="red"> <label id="validatePaymentType"/></font> 
                                        </div>
                                    </div> 
                                    
                                    
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                                      
                                            <label for="feeTypeId">Fee Type :</label>
                                            <html:select  styleClass="form-control" property="feeTypeId" styleId="feeTypeId" onchange="myFunction()">
                                                <html:option value="0">Select fee type</html:option>
                                                <html:optionsCollection   name="studentFeeForm"
                                                                          property="feeTypeList" label="code" value="id" />
                                            </html:select>
                                            <label id="selectedFeeAmount"/>
                                             <font color="red"> <label id="validateFeeType"/></font> 
                                        </div>
                                    </div>
                                </div>
                                
                                <div class="row">
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            Paid Amount: <html:text  property="paidAmount"  styleId="paidAmount"   styleClass="form-control" />
                                            <font color="red"> <label id="validatePaidAmount"/></font> 
                                        </div>
                                    </div>
                                    
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            Balance Amount: <html:text  property="balanceAmount"  styleId="balanceAmount"   styleClass="form-control" />
                                           <font color="red"> <label id="validateBalanceAmount"/></font> 
                                        </div>
                                    </div>
                                </div>
                                
                                
                                <div class="row">
                                    
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            Fee Payment Date : <html:text  property="feePaymentDate"  styleId="feePaymentDate"   styleClass="form-control"/>
                                          <font color="red"> <label id="validateFeePaymentDate"/></font> 
                                        </div>
                                    </div>
                                    
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            Discount Type: <html:text  property="discountType"  styleId="discountType"   styleClass="form-control" />
                                          <font color="red"> <label id="validateDiscountType"/></font> 
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
                                 <font color="red"> <label id="mailSentFailed"/></font> 
                                 <font color="green"> <label id="mailSentSucess"/></font> 
                            <table class="table table-striped table-advance table-hover">
                                <h4><i>Student Fee Table</i></h4>
                                <hr>
                                <thead>
                                    <tr>
                                        <th> Roll Number</th>
                                        <th> Student Name</th>
                                        <th> Payment Type</th>
                                        <th> Paid Amount</th>
                                        <th>Balance Amount</th>
                                        <th> Fee Payment Date</th>
                                        <th> </th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <logic:notEmpty name="studentFeeForm" property="studentFeeList">
                                        <logic:iterate id="studentFee" name="studentFeeForm" property="studentFeeList" type="org.edu.uams.server.pojo.StudentFeeEntity">
                                            <tr>
                                                <td><bean:write name="studentFee" property="rollNum"/></td>
                                                <td><bean:write name="studentFee" property="studentName"/></td>
                                                <td><bean:write name="studentFee" property="paymentType"/></td>
                                                <td><bean:write name="studentFee" property="paidAmount"/></td>
                                                <td><bean:write name="studentFee" property="balanceAmount"/></td>
                                                <td><bean:write name="studentFee" property="feePaymentDate"/></td>
                                                <td><button class="btn btn-primary btn-xs" onclick='getEditTypeForm(${studentFee.id});'><i class="fa fa-pencil"></i></button></td>
                                                <td><button class="btn btn-info" onclick='sendFeeCopy(${studentFee.id});'>Send</button></td>
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
    
    <script >
        
        function myFunction() {
          
            var feeTypeId = document.getElementById("feeTypeId").value;
            var paymentType = document.getElementById("paymentType").value;
            
            
            $.ajax({
                type: "POST",
                url: "/UAMS-WebApp/typeTableAction.do?method=getFeeTypeAmount",
                data: {
                    "id": feeTypeId
                },
                success: function(response){
                    document.getElementById("selectedFeeAmount").innerHTML = "Selected Fee Amount: " + response;
                    if(paymentType!=null && paymentType=='FULL'){
                        document.getElementById("paidAmount").value = response;
                    }
                }
            });
        }


        function validateForm() {
            var rollNum=document.getElementById('rollNum').value;
            var paidAmount=document.getElementById('paidAmount').value;
            var feePaymentDate=document.getElementById('feePaymentDate').value;
            var feeTypeId=document.getElementById('feeTypeId').value;
            
            var paymentType=document.getElementById('paymentType').value;
            var paidAmount=document.getElementById('paidAmount').value;
            var balanceAmount=document.getElementById('balanceAmount').value;
            
            if (rollNum == null || rollNum == "") {
                document.getElementById('searchText').focus();
                document.getElementById("validateRollNum").innerHTML = "Please Enter Student Roll Number";
                return false;
            }
            if (paymentType == null || paymentType == "") {
                document.getElementById("validatePaymentType").innerHTML = "Please Select Payment Type";
                document.getElementById('paymentType').focus();
                return false;
            }
            
            if (feeTypeId == null || feeTypeId == "" ||feeTypeId == "0") {
                document.getElementById("validateFeeType").innerHTML = "Please Select Fee Type";
                document.getElementById('feeTypeId').focus();
                return false;
            }
            
            if (paidAmount == null || paidAmount == "" || paidAmount == "0.0") {
                document.getElementById("validatePaidAmount").innerHTML = "Please Enter Paid Amount";
                document.getElementById('paidAmount').focus();
                return false;
            }
            
            if (paymentType=="PARTIAL") {
                if (balanceAmount === null || balanceAmount === "" || balanceAmount == "0.0") {
                    document.getElementById("validateBalanceAmount").innerHTML = "Please Enter Balance Amount";
                    document.getElementById('balanceAmount').focus();
                    return false;
                }
            }
            
            if (feePaymentDate == null || feePaymentDate == "") {
                document.getElementById("validateFeePaymentDate").innerHTML = "Please Enter Fee Payment Date";
                document.getElementById('feePaymentDate').focus();
                return false;
            }
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
        
        function sendFeeCopy(id) {
                  document.getElementById("mailSentFailed").innerHTML = "";
                   document.getElementById("mailSentSucess").innerHTML =  "";
             $.ajax({
                type: "POST",
                url: "/UAMS-WebApp/studentFeeAction.do?method=sendFeePaidCopyToStudent",
                data: {
                    "id": id
                },
                success: function (response) {
                    if (response == 'false') {
                       document.getElementById("mailSentFailed").innerHTML = "Fee Copy Sent Failed";
                    }
                    else {
                        document.getElementById("mailSentSucess").innerHTML = "Fee Copy Sent Sucesfully";
                    }
                }
            });
        }
    

        function submitForm() {
            alert('Submit Form');
            var id = document.getElementById('id').value;
            
            if (id != null && id > 0) {
                document.getElementById('pageName').value = "SubmitEditType";
            } else {
                document.getElementById('pageName').value = "SubmitAddType";
            }
            document.getElementById('searchText').value = "";
            document.studentFeeForm.action = "studentFeeAction.do?method=studentFeePage";
            document.studentFeeForm.submit();
        }


        function rset()
        {
            document.getElementById('searchText').value = "";
            document.getElementById('rollNum').value = "";
            document.getElementById('paidAmount').value = "0.0";
            document.getElementById('feePaymentDate').value = "";
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
    
