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
                            <h5><Strong>Add/Edit Hostel Block</Strong> </h5>
                                    <html:form  styleClass="" action="/hostelBlockAction" method="post">
                                
                                <div class="row">
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            Hostel name :  <html:text name="hostelBlockForm" property="name" styleId="name" styleClass="form-control"/>
                                        </div>
                                    </div>
                                    
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            Incharge Name  :  <html:text name="hostelBlockForm" property="inchargeName" styleId="inchargeName" styleClass="form-control"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            Address Line1 :   <html:text name="hostelBlockForm" property="addrLine1" styleId="addrLine1" styleClass="form-control"/>
                                        </div>
                                    </div>
                                    
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            Address Line2  :  <html:text name="hostelBlockForm" property="addrLine2" styleId="addrLine2" styleClass="form-control"/>
                                        </div>
                                    </div>
                                </div>
                                
                                <div class="row">
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            Address Line4 :  <html:text name="hostelBlockForm" property="addrLine4" styleId="addrLine4" styleClass="form-control"/>
                                        </div>
                                    </div>
                                    
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            City  : <html:text name="hostelBlockForm" property="city" styleId="city" styleClass="form-control"/>
                                        </div>
                                    </div>
                                </div>
                                
                                <div class="row">
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            State :  <html:text name="hostelBlockForm" property="stateName" styleId="stateName" styleClass="form-control"/>
                                        </div>
                                    </div>
                                    
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                            Zip code  :<html:text name="hostelBlockForm" property="zipCode" styleId="zipCode" styleClass="form-control"/>
                                        </div>
                                    </div>
                                </div>
                                
                                <div class="row">
                                    <div class="col-xs-6 col-sm-6 col-md-6">
                                        <div class="form-group">
                                          Incharge  Mobile No :  <html:text name="hostelBlockForm" property="mobile" styleId="mobile" styleClass="form-control"/>
                                        </div>
                                    </div>
                                    
                                </div>
                                
                                
                                <html:hidden name="hostelBlockForm" property="id" styleId="id"/>
                                <html:hidden name="hostelBlockForm" property="pageName" styleId="pageName" />
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
                                <h4><i class="fa fa-angle-right"></i> Hostel Block</h4>
                                <hr>
                                <thead>
                                    <tr>
                                        <th><i class="fa fa-bullhorn"></i> Name</th>
                                        <th><i class="fa fa-bullhorn"></i> Address </th>
                                        <th><i class="fa fa-bullhorn"></i> Faculty Mobile no</th>
                                        <th><i class="fa fa-bullhorn"></i> Faculty Name</th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <logic:notEmpty name="hostelBlockForm" property="blockEntitys">
                                        <logic:iterate id="hostelBlockTable" name="hostelBlockForm" property="blockEntitys" type="org.edu.uams.server.pojo.HostelBlockEntity">
                                            <tr>
                                                <td><bean:write name="hostelBlockTable" property="name"/></td>
                                                <td><bean:write name="hostelBlockTable" property="addrLines"/></td>
                                                <td><bean:write name="hostelBlockTable" property="mobile"/></td>
                                                <td><bean:write name="hostelBlockTable" property="inchargeName"/></td>
                                                <td><button class="btn btn-primary btn-xs" onclick='getEditTypeForm(${hostelBlockTable.id});'><i class="fa fa-pencil"></i></button></td>
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
          //  alert("Validate Form Values");
            // get the form values
            var name = document.getElementById('name').value;
                
            if (name== null || name =="") {
                alert("Please Hostel Name");
                document.getElementById('name').focus();
                return false;
            }
				
            submitForm();
        }


        function getEditTypeForm(id) {
            //alert('Get Editff Type'+id);
            document.getElementById('id').value =id;	
            document.getElementById('pageName').value ="GetEditTypeForm"	
            document.hostelBlockForm.action="hostelBlockAction.do?method=hostelBlockPage";
            document.hostelBlockForm.submit();
        }
    
        function submitForm() {
            alert('Submit Form');
            var id =document.getElementById('id').value;	
            if(id != null && id>0){
                document.getElementById('pageName').value ="SubmitEditType"	
            }else{
                document.getElementById('pageName').value ="SubmitAddType"
            }
            document.hostelBlockForm.action="hostelBlockAction.do?method=hostelBlockPage";
            document.hostelBlockForm.submit();
        }
	
        
        function reset()
        {	
            //alert('reset');
                        document.getElementById('name').value="";
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
