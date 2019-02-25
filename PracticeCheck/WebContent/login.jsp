<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
              <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
              <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
              <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

<head>
    <title>Grizzly Store</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="styles/main.css">
    <link rel="stylesheet" href="styles/bootstrap.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
    <script src="scripts/main.js"></script>
    <script src="scripts/bootstrap.js"></script>
</head>

<body>
    <div class="container-fluid m">
        <div class="row align-items-center">
            <div class="col-6 mx-auto">
                <div class="text-center">
                    <div class="col-12">
                        <img src="images/logo.png" width="50%"/>
                    </div><br>
                    <h1 class="display-4 font-size-lg" id="grizzly">GRIZZLY STORE</h1>
                    <hr style="height:2px;border:none;background-color:lightgray;"><br>
                    <form action="add-product.html" class="form-group">
                    <div class="lead col-4 mx-auto">
                        <input type="text" placeholder="&nbsp;&nbsp;Username" class="form-control form-rounded" />
                    </div><br>
                    <div class="lead col-6 mx-auto">
                        <button type="submit" class="btn btn-secondary rounded-circle"><span style="color:black">Login</span></button>
                    </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>

</html>