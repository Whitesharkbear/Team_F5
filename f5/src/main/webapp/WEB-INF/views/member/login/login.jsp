<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Account Login</title>
        <!--  meta tags -->
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="../favicon.ico">

        <!--================= Include All Styles ==================-->
        <link rel="stylesheet" type="text/css" href="/f5/resources/css/member/login/bootstrap.css" />
        <link rel="stylesheet" type="text/css" href="/f5/resources/css/member/login/font-awesome.css" />
        <!-- main styles-->
        <link rel="stylesheet" type="text/css" href="/f5/resources/css/member/login/styles.css" />
        <script src="/f5/resources/js/jquery-3.6.0.min.js"></script>
        <script type="text/javascript">
    	$(document).ready(function(){
    		$('#btnLogin').on('click',function(){
    			member_login_form.submit();
    		});
    	});
        </script>
    </head>
    <!--==================== body ======================= -->

    <body>

        <!--================= Main Wrapper ==================-->

            
            <div class="login-form">
                <form name = "member_login_form" action="login.do" method="post">
                    <div class="login-form-title"><img alt="" src="/f5/resources/images/mainlogo2.png"></div>
                    <div class="form-group">
                        <label for="InputUserEmail1">Username</label>
                        <input type="email" class="form-control" id="InputUserEmail1" name="memberId"/>
                    </div>
                    <div class="form-group">
                        <label for="InputPassword">Password</label>
                        <input type="password" class="form-control" id="InputPassword" name="memberPass">
                    </div>
                    <div class="form-group forgo-remember">
                        <div class="form-check">
                            <input type="checkbox" class="form-check-input" id="CheckBox">
                            <label class="form-check-label" for="CheckBox">Remember me </label>
                        </div>

                        <div class="forgot-password">
                            <a href="#" class="txt1"> Forget me</a>
                        </div>
                    </div>
                    <button type="button" id = "btnLogin"  class="btn btn-primary custom-btn">S U B M I T</button>

                </form>

                <div class="or">간편로그인</div>

                <div class="social-login">
                    <a href="#" class="social-item facebook-color">
                        <i class="fa fa-facebook-f" aria-hidden="true"></i>
                    </a>
                    <a href="#" class="social-item twitter-color">
                        <i class="fa fa-twitter" aria-hidden="true"></i>
                    </a>
                    <a href="#" class="social-item google-color">
                        <i class="fa fa-google" aria-hidden="true"></i>
                    </a>
                    <a href="#" class="social-item pinterest-color">
                        <i class="fa fa-pinterest" aria-hidden="true"></i>
                    </a>
                </div>


            </div>

        </div>
        <!--================= Div End ==================-->

        <!--================= Include All JS ==================-->
        <script src="/f5/resources/js/jquery-3.6.0.min.js"></script>
        <!-- Bootstrap v4.3.1-->
        <script src="/f5/resources/js/member/bootstrap.min.js"></script>
    </body>

</html>