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
        
        <title>Fee Category Type</title>
        
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
        
        <script>
            
            
            function checkUniqueCode() {
                // get the form values
                var name = document.getElementById('code').value;
                alert('Submit Form'+name);
                $.ajax({
                    type: "POST",
                    url: "/UAS_WebApp/typeTableAction.do?method=checkUniqueCode",
                    data: {
                        "code": name,
                        "pageName": "FeeCategoryType"
                    },
                    success: function(response){
                        if(response=='true'){
                            alert('Code is present');
                            document.getElementById('code').focus();
                            return false;
                        }
                        return true;
                    },
                    error: function(e){
                        alert('Error: ' + e);
                        return false;
                    }
                });
            }


            function getEditTypeForm(id) {
                alert('Get Editff Type'+id);
                document.getElementById('id').value =id;	
                document.getElementById('pageName').value ="GetEditTypeForm"	
                document.typeTableForm.action="typeTableAction.do?method=feeCategoryTypePage";
                document.typeTableForm.submit();
            }
    
            function submitForm() {
                alert('Submit Form');
                var code = document.getElementById('code').value;
                var description = document.getElementById('description').value;
                
                if (code== null || code =="") {
                    alert("Please Enter Code");
                    document.getElementById('code').cfocus();
                    return false;
                }
				
                if (description == null || description =="") {
                    alert("Please Enter Description");
                    document.getElementById('description').focus();
                    return false;
                }
                if(!checkUniqueCode()){
                    return false;
                }
                
           
                
                var id =document.getElementById('id').value;	
                if(id != null && id>0){
                    document.getElementById('pageName').value ="SubmitEditType"	
                }else{
                    document.getElementById('pageName').value ="SubmitAddType"
                }
                document.typeTableForm.action="typeTableAction.do?method=feeCategoryTypePage";
                document.typeTableForm.submit();
            }
	
        
            function rset()
            {	
                alert('reset');
                document.getElementById('code').value="";
                document.getElementById('description').value="";
		
            }
        </script>
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
                            <h5><Strong>Add/Edit Fee Category type</Strong> </h5>
                                    <html:form  styleClass="form-horizontal style-form" action="/typeTableAction" method="post">
                                <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label"><Strong>Code</Strong></label>
                                    <div class="col-sm-10">
                                        <html:text name="typeTableForm" property="code" size="30" styleId="code" styleClass="form-control" maxlength="10" 
                                                   />
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-2 col-sm-2 control-label"><Strong>Description</Strong></label>
                                    <div class="col-sm-10">
                                        <html:text name="typeTableForm" property="description" size="30" styleId="description" styleClass="form-control" maxlength="100" />
                                    </div>
                                </div>  
                                <html:hidden name="typeTableForm" property="id" styleId="id"/>
                                <html:hidden name="typeTableForm" property="pageName" styleId="pageName" />
                                <div align="center">
                                    <html:button property="addBtn" styleClass="btn-theme" value="Apply" onclick="submitForm();" />
                                    <html:button property="rsetBtn" styleClass="btn-theme" value="Rset" onclick="rset();" />
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
                                <h4><i class="fa fa-angle-right"></i> Advanced Table</h4>
                                <hr>
                                <thead>
                                    <tr>
                                        <th><i class="fa fa-bullhorn"></i> Code</th>
                                        <th class="hidden-phone"><i class="fa fa-question-circle"></i> Description</th>
                                        <th></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <logic:notEmpty name="typeTableForm" property="typeFormList">
                                        <logic:iterate id="typeTable" name="typeTableForm" property="typeFormList" type="org.edu.uams.server.pojo.FeeCategoryTypeEntity">
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
    
    <!-- js placed at the end of the document so the pages load faster -->
    <script src="assets/js/jquery.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script class="include" type="text/javascript" src="assets/js/jquery.dcjqaccordion.2.7.js"></script>
    <script src="assets/js/jquery.scrollTo.min.js"></script>
    <script src="assets/js/jquery.nicescroll.js" type="text/javascript"></script>
    
    
    <!--common script for all pages-->
    <script src="assets/js/common-scripts.js"></script>
    
    <!--script for this page-->
    
    <script>
        //custom select box

        $(function(){
            $('select.styled').customSelect();
        });

    </script>
    
</body>
</html>
