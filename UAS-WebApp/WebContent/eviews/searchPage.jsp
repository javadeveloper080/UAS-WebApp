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
        
        <title>Search Page</title>
        
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
                            <input type="text" id="search" name="search" class="search" />
                            <input type="button" value="Seach" id="showTable"/>
                        </div>
                    </div><!-- col-lg-12-->      	
                </div> <!--  /row -->
                
                
                
                
                <!-- GRID ELEMENTS -->
                <div class="row mt">
                    <div class="col-md-12">
                        <div class="content-panel">
                            <table class="table table-striped table-advance table-hover" id="searchResTable">
                                <h4><i class="fa fa-angle-right"></i> Search Results Table</h4>
                                <hr>
                                <thead>
                                    <tr>
                                        <th scope="col"><i class="fa fa-bullhorn"></i> First name</th>
                                        <th scope="col"><i class="fa fa-bullhorn"></i> Last name</th>
                                    </tr>
                                </thead>
                                
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
    
    <link href="http://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css" rel="stylesheet">
    <script src="http://code.jquery.com/jquery-1.10.2.js"></script>
    <script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
    
    
    
    
    <!--external css-->
    <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    
    <!-- Custom styles for this template -->
    <link href="assets/css/style.css" rel="stylesheet">
    <link href="assets/css/style-responsive.css" rel="stylesheet">
    
    
    <!--common script for all pages-->
    <script src="assets/js/common-scripts.js"></script>
    
    
    <!-- Bootstrap core CSS -->
    <!--    <link href="assets/css/bootstrap.css" rel="stylesheet">-->
    <script src="assets/css/bootstrap.min.css"></script>
    
    
    <!--script for this page-->
    
    <script>
            
        
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
            });      
        });
        
       
                
       
        
        
    </script>
    
</body>
</html>
