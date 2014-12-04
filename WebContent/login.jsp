<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<title>Login</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css" href="css/bootstrap-slate.css">
	<link rel="stylesheet" href="css/bootstrap-responsive.css">
	<link href="css/charisma-app.css" rel="stylesheet">
	<link rel="stylesheet" href="css/estilos.css">
	  
	
	
</head>
<body>
<% session.invalidate(); %>
		<div class="navbar">
    <div class="navbar-inner">
      <div class="container-fluid">
        <a class="btn btn-navbar" data-toggle="collapse" data-target=".top-nav.nav-collapse,.sidebar-nav.nav-collapse">
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </a>
       
        
        <div class="mi_barra">
        	<h3>Login test for java_tp1</h3>
        </div>
        
        
      </div>
    </div>
  </div>
	<div class="container-fluid">
		<div class="row-fluid">
		
			<div class="row-fluid">
				<div class="span12 center login-header">
					<h1>Welcome</h1>
				</div><!--/span-->
			</div><!--/row-->
	
			<div class="row-fluid">
				<div class="well span5 center login-box">
					<div class="alert alert-info">
						Login with username and password
					</div>
						<form name="datos" id="datos" action="ServletLogin" class="form-horizontal" method="post" onsubmit="return validar();">
								<fieldset>
									<div class="input-prepend" >
										<span class="add-on"><i class="icon-user"></i></span><input class="input-large span10" name="username" id="username" type="text" placeholder="usuario" />
									</div>
									<div class="clearfix"></div>

									<div class="input-prepend" >
										<span class="add-on"><i class="icon-lock"></i></span><input class="input-large span10" name="password" id="password" type="password" placeholder="contraseña" />
									</div>
									<div class="clearfix"></div>

									<p class="center span5">
									<button type="submit" class="btn btn-primary">Entrar</button>
									</p>
								</fieldset>

						</form>
				</div>
		</div>	
		</div>			
	</div>

	<link rel="stylesheet" href="js/jquery.js">
	<link rel="stylesheet" href="js/bootstrap.js">
	<script type="text/javascript">
	function validar()
    {
        var fallo = false;
        var falta = "";
       
       
        if (datos.username.value == "") {
            falta += "Falta ingresar Usuario \n";
            fallo = true;
        }

        if (datos.password.value == "") {
            falta += "Falta ingresar contrase�a \n";
            fallo = true;
        }


        if (fallo) {
            alert(falta);
            return false;
        }
        else {
         
            return true;
        }
    }
	</script>
	
	
	

</body>
</html>