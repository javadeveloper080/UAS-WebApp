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
        <meta name="author" content="UMAS">
        
        
        <title>UMAS</title>
        
        <!-- Bootstrap core CSS -->
        <link href="assets/css/bootstrap.css" rel="stylesheet">
        <!--external css-->
        <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
        
        <!-- Custom styles for this template -->
        <link href="assets/css/style.css" rel="stylesheet">
        <link href="assets/css/style-responsive.css" rel="stylesheet">
        
    </head>
    
    <body>
        
    <section id="container" >
        
        <header class="header black-bg">
            <div class="sidebar-toggle-box">
                <div class="fa fa-bars tooltips" data-original-title="Toggle Navigation" data-placement="right"></div>
            </div>
            <!--logo start-->
            <a href="" class="logo"><b>UMAS</b></a>
            <!--logo end-->
            
            <div class="top-menu">
                <ul class="nav pull-right top-menu">
                    <li><a class="logout" href="loginAction.do?method=logOutAction">Logout</a></li>
                </ul>
            </div>
        </header>
        <!--header end-->
        
        
        
        
        <!-- **********************************************************************************************************************************************************
        MAIN CONTENT
        *********************************************************************************************************************************************************** -->
        <!--main content start-->
        <section id="main-content">
            <section class="wrapper site-min-height">
                <h3><font size=10 face="verdana" color="blue">Error Page!</h3>
                <div class="row mt">
                    <div class="col-lg-12">
                        <div class="form-panel">
                                <p><font size=8 face="verdana" color="blue"> Oops error !!<font size=6 face="verdana" color="red">&nbsp;<html:errors /></font></p>
                        </div>
                    </div>
                </div>
                
            </section><! --/wrapper -->
        </section><!-- /MAIN CONTENT -->
        
        <!--main content end-->
        <!--footer start-->
        <footer class="site-footer">
            <div class="text-center">2015 - UMAS</div>
        </footer>
        <!--footer end-->
    </section>
    
    
    
    
</body>
</html>
