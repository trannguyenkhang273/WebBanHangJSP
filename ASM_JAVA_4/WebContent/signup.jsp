<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="fonts1/icomoon/style.css">

    <link rel="stylesheet" href="css1/owl.carousel.min.css">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css1/bootstrap.min.css">
    
    <!-- Style -->
    <link rel="stylesheet" href="css1/style.css">

    <title>Login #8</title>
  </head>
  <body>
  

  
  <div class="content">
    <div class="container">
      <div class="row">
        <div class="col-md-6 order-md-2">
          <img src="images1/undraw_file_sync_ot38.svg" alt="Image" class="img-fluid">
        </div>
        <div class="col-md-6 contents">
          <div class="row justify-content-center">
            <div class="col-md-8">
              <div class="mb-4">
              <h3>Sign Up to <strong>Colorlib</strong></h3>
              <p class="mb-4">Lorem ipsum dolor sit amet elit. Sapiente sit aut eos consectetur adipisicing.</p>
            </div>
            ${message}
            <form action="signup" method="post">
              <div class="form-group first">
                <label >Username</label>
                <input type="text" class="form-control" id="username"  name="username">

              </div>
              <div class="form-group first">
                <label >Password</label>
                <input type="password" class="form-control" id="password" name="password">
                
              </div>
              
              <div class="form-group first">
                <label>Fullname</label>
                <input type="text" class="form-control" id="username" name="fullname">
                
              </div>

             <br>	
				<span class="ml-auto"><a href="signin" class="forgot-pass">Sign in</a></span><br> <br> 

              <input type="submit" value="Đăng ký" class="btn text-white btn-block btn-primary">

              <span class="d-block text-left my-4 text-muted"> or sign in with</span>
              
              <div class="social-login">
                <a href="#" class="facebook">
                  <span class="icon-facebook mr-3"></span> 
                </a>
                <a href="#" class="twitter">
                  <span class="icon-twitter mr-3"></span> 
                </a>
                <a href="#" class="google">
                  <span class="icon-google mr-3"></span> 
                </a>
              </div>
            </form>
            </div>
          </div>
          
        </div>
        
      </div>
    </div>
  </div>

  
    <script src="js1/jquery-3.3.1.min.js"></script>
    <script src="js1/popper.min.js"></script>
    <script src="js1/bootstrap.min.js"></script>
    <script src="js1/main.js"></script>
  </body>
</html>