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
                            <h5><Strong>Add/Edit Student Bus Account Details</Strong> </h5>
                                    <html:form  styleClass="" action="/transportModuleAction" method="post">
                                
                                <div class="row">
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <html:text name="transportModuleForm" property="searchText" styleId="searchText" styleClass="form-control" />
                                            <html:button property="searchButton" styleClass="btn-theme" value="Search" onclick="checkValidStudentRollNumber();" />
                                        </div>
                                    </div>
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <label for="rollNum">Student Roll Number & Full Name.</label>
                                            <html:text name="transportModuleForm" property="rollNum" styleId="rollNum"  readonly="true"/>
                                            <html:text name="transportModuleForm" property="studentFullName" styleId="studentFullName"  readonly="true"/>
                                        </div>
                                    </div>         
                                </div>
                                <hr/>
                                <h5><p ><em><strong style="color:blue"><bean:write name="transportModuleForm" property="statusMessage" /></strong></em></p></h5>
                                <div class="row">
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <label for="busSeatNum">Bus seat No.</label>
                                            <html:text  name="transportModuleForm" property="busSeatNum" styleId="busSeatNum" styleClass="form-control"/>
                                        </div>
                                    </div>
                                </div>
                                
                                
                                <div class="row">
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <label for="busRegDate">Reg date</label>
                                            <html:text name="transportModuleForm" property="busRegDate" styleId="busRegDate" styleClass="form-control"/>
                                        </div>
                                    </div>
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <label for="busCancelDate">Cancel date</label>
                                            <html:text name="transportModuleForm" property="busCancelDate" styleId="busCancelDate" styleClass="form-control"/>
                                        </div>
                                    </div>
                                </div>
                                
                                
                                <div class="row">
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <label for="busDetailsId">Bus</label>
                                            <html:select property="busDetailsId" styleId="busDetailsId" styleClass="form-control">
                                                <html:option   value="">Select Bus</html:option>                                                                                                                                                             
                                                <html:optionsCollection name="transportModuleForm" property="busDetailsList" label="busNum" value="id" /> 
                                            </html:select>
                                        </div>
                                    </div>
                                    
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            <label for="areaName">Area name</label>
                                            <html:text name="transportModuleForm" property="areaName" styleId="areaName" styleClass="form-control"/>
                                        </div>
                                    </div>
                                </div>
                                
                                
                                <html:hidden name="transportModuleForm" property="id" styleId="id"/>
                                <html:hidden name="transportModuleForm" property="studentId" styleId="studentId"/>
                                <html:hidden name="transportModuleForm" property="pageName" styleId="pageName" />
                                <html:hidden name="transportModuleForm" property="searchStudent" styleId="searchStudent"/>
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
                            

                            <table class="table table-bordered table-striped table-condensed cf">
                                <h4>Student Bus Account Details Table</h4>
                                <hr>
                                <thead class="cf">
                                    <tr>
                                        <th class="numeric">Roll No.</th>
                                        <th class="numeric">Seat No.</th>
                                        <th class="numeric"> Bus  No. </th>
                                        <th class="numeric">Area </th>
                                        <th class="numeric">Reg date</th>
                                         <th class="numeric">Cancel date</th>
                                        <th></th>
                                    </tr>
                                </thead>
    
                                
                                <tbody>
                                    <logic:notEmpty name="transportModuleForm" property="studentBusAccDetailsList">
                                        <logic:iterate id="transportStudentBusAccTable" name="transportModuleForm" property="studentBusAccDetailsList" type="org.edu.uams.server.pojo.StudentBusAccDetailsEntity">
                                            <tr>
                                                <td class="numeric"><bean:write name="transportStudentBusAccTable" property="student.rollNum"/></td>
                                                <td class="numeric"><bean:write name="transportStudentBusAccTable" property="busSeatNum"/></td>
                                                <td class="numeric"><bean:write name="transportStudentBusAccTable" property="busDetails.busNum"/></td>
                                                <td class="numeric"><bean:write name="transportStudentBusAccTable" property="areaName"/></td>
                                                <td class="numeric"><bean:write name="transportStudentBusAccTable" property="busRegDateTxt"/></td>
                                                <td class="numeric"><bean:write name="transportStudentBusAccTable" property="busCancelDateTxt"/></td>
                                                <td><button class="btn btn-primary btn-xs" onclick='getEditTypeForm(${transportStudentBusAccTable.id});'><i class="fa fa-pencil"></i></button></td>
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
           
            submitForm();
        }


        function getEditTypeForm(id) {
            alert('Get Editff Type'+id);
            document.getElementById('id').value =id;	
            document.getElementById('searchStudent').value ="False"
            document.getElementById('pageName').value ="GetEditTypeForm"	
            document.transportModuleForm.action="transportModuleAction.do?method=studentBusAccDetailsPage";
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
            document.getElementById('searchStudent').value ="False"
            document.transportModuleForm.action="transportModuleAction.do?method=studentBusAccDetailsPage";
            document.transportModuleForm.submit();
        }
	
        
        function reset()
        {	
		
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
        
        $(function() {
            $( "#busRegDate" ).datepicker({
                showOn: "button",
                buttonImage: "images/calendar.gif",
            });
        });
        
        $(function() {
            $( "#busCancelDate" ).datepicker({
                showOn: "button",
                buttonImage: "images/calendar.gif",
            });
        });
        
       function searchForm(){	
        document.getElementById('searchStudent').value ="True"
        document.transportModuleForm.action="transportModuleAction.do?method=studentBusAccDetailsPage";
        document.transportModuleForm.submit();
        }
        
    </script>
    
