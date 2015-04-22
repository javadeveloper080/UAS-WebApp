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
                            <h5><Strong>Add/Edit Program Level type</Strong> </h5>
                                    <html:form  styleClass="" action="/typeTableAction" method="post">
                                
                                
                                
                                <div class="row">
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            Code: <html:text  property="code"  styleId="code"   styleClass="form-control" />
                                        </div>
                                    </div>
                                    
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            Description:  <html:text  property="description"  styleId="description"   styleClass="form-control"/>
                                        </div>
                                    </div>
                                </div>
                                
                                <html:hidden name="typeTableForm" property="id" styleId="id"/>
                                <html:hidden name="typeTableForm" property="pageName" styleId="pageName" />
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
                                <h4><i>Program Level type table</i> </h4>
                                <hr>
                                <thead>
                                    <tr>
                                        <th><i>Code</i></th>
                                        <th><i>Description</i></th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <logic:notEmpty name="typeTableForm" property="typeFormList">
                                        <logic:iterate id="typeTable" name="typeTableForm" property="typeFormList" type="org.edu.uams.server.pojo.ProgramLevelTypeEntity">
                                            <tr>
                                                <td><bean:write name="typeTable" property="code"/></td>
                                                <td><bean:write name="typeTable" property="description"/></td>
                                                <td><button class="btn btn-primary btn-xs" onclick='getEditTypeForm(${typeTable.id});'><i class="fa fa-pencil"></i></button></td>
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
    
   
    <script>
            
            
        function validateForm() {
//            alert("Validate Form Values");
            // get the form values
            var code = document.getElementById('code').value;
            var description = document.getElementById('description').value;
                
            if (code== null || code =="") {
                alert("Please Enter Code");
                document.getElementById('code').focus();
                return false;
            }
				
            if (description == null || description =="") {
                alert("Please Enter Description");
                document.getElementById('description').focus();
                return false;
            }
      
            var id =document.getElementById('id').value;	
            $.ajax({
                type: "POST",
                url: "/UAMS-WebApp/typeTableAction.do?method=checkUniqueCode",
                data: {
                    "code": code,
                    "pageName": "ProgramLevelType",
                    "id": id
                },
                    
                success: function(response){
                    if(response=='true'){
                        alert('Code is '+code+' present');
                        document.getElementById('code').focus();
                        return false;
                    }
                    else{
                        submitForm();
                    }
                },
                error: function(e){
                    alert('Error: ' + e);
                    return false;
                }
            });
        }


        function getEditTypeForm(id) {
//            alert('Get Editff Type'+id);
            document.getElementById('id').value =id;	
            document.getElementById('pageName').value ="GetEditTypeForm"	
            document.typeTableForm.action="typeTableAction.do?method=programLevelTypePage";
            document.typeTableForm.submit();
        }
    
        function submitForm() {
            alert('Submit Form');
            var id =document.getElementById('id').value;	
            if(id != null && id>0){
                document.getElementById('pageName').value ="SubmitEditType"	
            }else{
                document.getElementById('pageName').value ="SubmitAddType"
            }
            document.typeTableForm.action="typeTableAction.do?method=programLevelTypePage";
            document.typeTableForm.submit();
        }
	
        
        function reset()
        {	
            document.getElementById('code').value="";
            document.getElementById('description').value="";
            document.getElementById('id').value="0";
            document.getElementById('pageName').value="";
		
        }
    </script>
    
    
    
