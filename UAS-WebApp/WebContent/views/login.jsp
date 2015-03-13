<%@page contentType="text/html" pageEncoding="UTF-8"%>

<link rel="shortcut icon" href="../favicon.ico"> 
<link rel="stylesheet" type="text/css" href="css/demo.css" />
<link rel="stylesheet" type="text/css" href="css/style2.css" />
<link rel="stylesheet" type="text/css" href="css/animate-custom.css" />



<div id="wrapper">
    <div id="login" class="animate form">
        
        <form name="loginForm" action="loginAction.do?method=logInAction" method="post" autocomplete="on"> 
            <h1>Log in</h1> 
            <p> 
                <label for="username" class="uname" data-icon="u" > Your email or username </label>
                <input id="userName" name="userName" required="required" type="text" placeholder="myusername or mymail@mail.com"/>
            </p>
            <p> 
                <label for="password" class="youpasswd" data-icon="p"> Your password </label>
                <input id="password" name="password" required="required" type="password" placeholder="eg. X8df!90EO" /> 
            </p>

            <p class="login button"> 
                <input type="submit" value="Login" /> 
            </p>

        </form>
    </div>



</div>  

