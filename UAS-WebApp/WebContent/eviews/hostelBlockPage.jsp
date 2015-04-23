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
                                        Address Line4  :  <html:text name="hostelBlockForm" property="addrLine3" styleId="addrLine3" styleClass="form-control"/>
                                    </div>
                                </div>
                                
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        Address Line4 :  <html:text name="hostelBlockForm" property="addrLine4" styleId="addrLine4" styleClass="form-control"/>
                                    </div>
                                </div>
                                
                                
                            </div>
                            
                            <div class="row">
                                
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        City  : <html:text name="hostelBlockForm" property="city" styleId="city" styleClass="form-control"/>
                                    </div>
                                </div>
                                
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        State :  <html:text name="hostelBlockForm" property="stateName" styleId="stateName" styleClass="form-control"/>
                                    </div>
                                </div>
                                
                            </div>
                            
                            <div class="row">
                                
                                <div class="col-xs-6 col-sm-6 col-md-6">
                                    <div class="form-group">
                                        Zip code  :<html:text name="hostelBlockForm" property="zipCode" styleId="zipCode" styleClass="form-control"/>
                                    </div>
                                </div>
                                
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
                                    <th><i >Name</i> </th>
                                    <th><i >Address</i>  </th>
                                    <th><i >Faculty Mobile</i></th>
                                    <th><i >Faculty Name</i> </th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <logic:notEmpty name="hostelBlockForm" property="blockEntitys">
                                    <logic:iterate id="hostelBlockTable" name="hostelBlockForm" property="blockEntitys" type="org.edu.uams.server.pojo.HostelBlockEntity">
                                        <tr>
                                            <td><bean:write name="hostelBlockTable" property="name"/></td>
                                            <td><bean:write name="hostelBlockTable" property="addrLine1"/></td>
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
        var addrLine1 = document.getElementById('addrLine1').value;
        var city = document.getElementById('city').value;
        var mobile = document.getElementById('mobile').value;
        var inchargeName = document.getElementById('inchargeName').value;
        
        var zipCode = document.getElementById('zipCode').value;
        var stateName = document.getElementById('stateName').value;
             
                
        if (name== null || name =="") {
            alert("Please Enter Hostel Name");
            document.getElementById('name').focus();
            return false;
        }
            
        if (addrLine1== null || addrLine1 =="") {
            alert("Please Enter Address Line1");
            document.getElementById('addrLine1').focus();
            return false;
        }
            
        if (city== null || city =="") {
            alert("Please Enter city");
            document.getElementById('city').focus();
            return false;
        }
            
        if (mobile== null || mobile =="") {
            alert("Please Enter Mobile");
            document.getElementById('name').focus();
            return false;
        }
            
        if (inchargeName== null || inchargeName =="") {
            alert("Please Enter In chargeName");
            document.getElementById('inchargeName').focus();
            return false;
        }
            
        if(isNaN(mobile)){
            alert('Please Enter Numeric value for Mobile');
            document.getElementById('mobile').focus;
            return false;

        }
        
        if (zipCode== null || zipCode =="") {
            alert("Please Enter zipCode");
            document.getElementById('zipCode').focus();
            return false;
        }
        
        if (stateName== null || stateName =="") {
            alert("Please Enter stateName");
            document.getElementById('stateName').focus();
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
