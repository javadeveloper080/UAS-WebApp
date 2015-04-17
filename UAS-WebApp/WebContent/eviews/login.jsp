<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Dashboard">
    <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

    <title>UAMS</title>

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
  </head>

  <body>

      <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->

	  <div id="login-page">
	  	<div class="container">
	  	
		     
			  
			 <form class="form-login" name="loginForm" action="loginAction.do?method=logInAction" method="post" autocomplete="on"> 
                             <button type="button" class="close" data-dismiss="modal" aria-hidden="true" onclick="closeFormWindow();">×</button>
                        <h2 class="form-login-heading">sign in now</h2>
		        <div class="login-wrap">
                        <input type="text"  class="form-control"  id="userName" name="userName" required="required" placeholder=" or mymail@mail.com"
                                     autofocus/>		            <br>
		                                        <input id="password" name="password" required="required" type="password" class="form-control" placeholder="eg. X8df!90EO" /> 
		            <label class="checkbox">
		                <span class="pull-right">
		                    <a data-toggle="modal" href="login.html#myModal"> Forgot Password?</a>
		
		                </span>
		            </label>
		            <button class="btn btn-theme btn-block" type="submit"><i class="fa fa-lock"></i> SIGN IN</button>
		            <hr>
		           </div>  
		          
		
		       
		<!-- Modal -->
		          <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
		              <div class="modal-dialog">
		                  <div class="modal-content">
		                      <div class="modal-header">
		                          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		                          <h4 class="modal-title">Forgot Password ?</h4>
		                      </div>
		                      <div class="modal-body">
		                          <p>Enter your e-mail address below to reset your password.</p>
		                          <input type="text" id = 'email' name="email" placeholder="Email" autocomplete="off" class="form-control placeholder-no-fix">
		
		                      </div>
                                      
		                      <div class="modal-footer">
		                          <button data-dismiss="modal" class="btn btn-default" type="button">Cancel</button>
                                          <button class="btn btn-theme" type="button" onclick="submitForgotForm();">Submit</button>
		                      </div>
		                  </div>
		              </div>
		          </div>
		          <!-- modal -->
		      </form>	  	
	  	
	  	</div>
	  </div>

    <!-- js placed at the end of the document so the pages load faster -->
    <script src="assets/js/jquery.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>

    <!--BACKSTRETCH-->
    <!-- You can use an image of whatever size. This script will stretch to fit in any screen size.-->
    <script type="text/javascript" src="assets/js/jquery.backstretch.min.js"></script>
    <script>
        $.backstretch("assets/img/login-bg.jpg", {speed: 500});
    </script>
 <script>

    function closeFormWindow(){
        document.loginForm.action = "loginAction.do?method=logOutAction";
            document.loginForm.submit();
    }

    function submitForm() {
        alert("Validate Form Values");
        // get the form values
        var email = document.getElementById('email').value;
        if(isEmail(email))
        {
            
        }else
        {
            document.getElementById('email').focus();
            return;
        }
    }
    
    function submitForgotForm() {
        var email = document.getElementById('email').value;
        if(isEmail(email))
        {
            document.loginForm.email.value = email;
            alert("email"+document.loginForm.email.value);
            document.loginForm.action = "loginAction.do?method=forgotPassWordAction";
            document.loginForm.submit();
        }else
        {
            alert("Please enter correct email format");
            document.getElementById('email').focus();
            return;
        }
    }
    
    function isEmail(email) {
  var regex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
  return regex.test(email);
}
 </script>

  </body>
</html>