<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <title>LogIn</title>
  </head>
  <body>
    
   <section class="h-100 bg-dark">
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col">
        <div class="card card-registration my-4">
          <div class="row g-0">
            <div class="col-xl-6 d-none d-xl-block">
              <img src="registerPic.jpg"
                alt="Sample photo" class="img-fluid m-5"
                style="border-top-left-radius: .25rem; border-bottom-left-radius: .25rem;" />
            </div>
            <div class="col-xl-6">
              <div class="card-body p-md-5 text-black">
                <h3 class="mb-5 text-uppercase" style="text-align: center; color:#178582;"><strong>Register Here</strong></h3>
				<form action="RegisterServlet" method="post"> 
	                <div class="row">
	                  <div class="col-md-6 mb-4">
	                    <div data-mdb-input-init class="form-outline">
	                      <input type="text" placeholder="First Name" class="form-control form-control-lg" name="firstName" required/>
	                    </div>
	                  </div>
	                  
	                  <div class="col-md-6 mb-4">
	                    <div data-mdb-input-init class="form-outline">
	                      <input type="text" placeholder="Last Name" class="form-control form-control-lg" name="lastName" required/>
	                    </div>
	                  </div>
	                </div>
	                
	                 <div data-mdb-input-init class="form-outline mb-4">
	                  <input type="email" placeholder="example@gmail.com" class="form-control form-control-lg" name="email" required/>
	                </div>
	                
	                <div data-mdb-input-init class="form-outline mb-4">
	                  <input type="text" placeholder="Phone No." class="form-control form-control-lg" name="phone" required/>
	                </div>
	                
	                <div data-mdb-input-init class="form-outline mb-4">
	                  <input type="password" class="form-control form-control-lg" placeholder="Password" name="password" required/>
	                </div>
	                
	                 <div data-mdb-input-init class="form-outline mb-4">
	                  <input type="text" placeholder="Address" class="form-control form-control-lg" name="address" required/>
	                </div>
	                
	                 <div data-mdb-input-init class="form-outline mb-4">
	                  <input type="text" placeholder="Pin Code" class="form-control form-control-lg" name="pincode" required/>
	                </div>
	                
	                <div>
	                  <button type="submit" data-mdb-button-init data-mdb-ripple-init class="btn btn-lg ms-2" style="color:black; background-color: #178582">Submit</button>
	                </div>
				</form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
    <!-- Optional JavaScript; choose one of the two! -->

    <!-- Option 1: Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

    <!-- Option 2: Separate Popper and Bootstrap JS -->
    <!--
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    -->
  </body>
</html>