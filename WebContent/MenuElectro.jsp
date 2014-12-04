<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="UTF-8">
  <title>Inicio</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" type="text/css" href="css/bootstrap-slate.css">
  <link rel="stylesheet" href="css/bootstrap-responsive.css">
  <link href="css/charisma-app.css" rel="stylesheet">
  <link rel="stylesheet" href="css/estilos.css">
<style type="text/css">
    body {
    padding-bottom: 40px;
    }
    .sidebar-nav {
    padding: 9px 0;
    }
  </style>
</head>
<body>
<%
if(session.getAttribute("usuario")==null){ 
	response.sendRedirect("login.jsp");
	
	} 
else {
String usu= (String)session.getAttribute("usuario");
%>
 
<div class="navbar">
    <div class="navbar-inner">
      <div class="container-fluid">
        <a class="btn btn-navbar" data-toggle="collapse" data-target=".top-nav.nav-collapse,.sidebar-nav.nav-collapse">
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </a>
        <a class="brand" href="index.jsp"><span>SGE</span></a>
        <div class="mi_barra">
        	<h3>Sistema de Gestion de Electrodomesticos</h3>
        </div>
        
        <!-- theme selector starts -->
        <div class="btn-group pull-right theme-container" >
         <a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
            <i class="icon-user"></i><span class="hidden-phone"> <%=usu %></span>
            <span class="caret"></span>
          </a>
          <ul class="dropdown-menu">
            <li><a type="button" href="login.jsp">Cerrar Sesion</a></li>
          </ul>
        </div>
        
        
      </div>
    </div>
  </div>
  <!-- topbar ends -->





<div class="container-fluid">
    <div class="row-fluid">
        
      <!-- left menu starts -->
      <div class="span2 main-menu-span">
        <div  class="well nav-collapse sidebar-nav">
          <ul id="pruebita" class="nav nav-tabs nav-stacked main-menu">
            <li class="nav-header hidden-tablet">Menu Principal</li>
            
            <li><a class="ajax-link"><i class="icon-list-alt"></i><span class="hidden-tablet"> Electrodomesticos</span></a>
            <ul>
                <li><a class="ajax-link" href="ListaElectrodomesticos.jsp">Lista de Electrodomesticos</a></li>
                <li><a class="ajax-link" href="altas.jsp">Altas</a></li>
                <li><a class="ajax-link" href="bajas.jsp">Bajas</a></li>
              </ul>
            </li>
            <li><a class="ajax-link" href="addElectro.jsp"><i class="icon-file"></i><span class="hidden-tablet"> Agregar electro</span></a></li>
            <li><a class="ajax-link" href="CargaTP.jsp"><i class="icon-file"></i><span class="hidden-tablet"> ITEM MENU2</span></a></li>
            <li><a class="ajax-link" href="ModificarAlu.jsp"><i class="icon-pencil"></i><span class="hidden-tablet"> ITEM MENU3</span></a>
            </li>
            <li><a class="ajax-link" href="modificarElectro.jsp"><i class="icon-refresh"></i><span class="hidden-tablet"> Modificar</span></a>
             <ul>
                <li><a class="ajax-link" href="editUsuario.jsp">Usuario</a></li>
                <li><a class="ajax-link" href="editElectro.jsp">Electrodomestico</a></li>
              </ul>
            </li>
            <li><a class="ajax-link"><i class="icon-remove"></i><span class="hidden-tablet"> Dar de baja</span></a>
            <ul>
                <li><a class="ajax-link" href="bajaUsuario.jsp">Usuario</a></li>
                <li><a class="ajax-link" href="bajaElectro.jsp">Electrodomestico</a></li>
              </ul>
            </li>
          </ul>
        </div><!--/.well -->
      </div><!--/span-->
      <!-- left menu ends -->
    <div id="content" class="span10">
      <!-- content starts -->
      <div class="row-fluid sortable">
        <div class="box span12">
          <div class="box-header well" data-original-title>
            <h2><i class="icon-edit"></i> Inicio</h2>
            <div class="box-icon">
              <a href="#" class="btn btn-setting btn-round"><i class="icon-cog"></i></a>
              <a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
              <a href="#" class="btn btn-close btn-round"><i class="icon-remove"></i></a>
            </div>
          </div>
          <div class="box-content">
            <p>
            Bienvenido al Sistema Gestor de Electrodomesticos.
            </p>
            <h3>Novedades</h3><br>
            <div id="myCarousel" class="carousel slide">
  				<div class="carousel-inner">
    				<div class="item active">
    					<img src="img/03.jpg" height="450" width="980">
    				</div>
    				<div class="item"><img src="img/04.jpg" height="450" width="980"></div>
   					 <div class="item"><img src="img/05.jpg" height="450" width="980"></div>
   					 <div class="item"><img src="img/06.jpg" height="450" width="980"></div>
   					 <div class="item"><img src="img/08.jpg" height="450" width="980"></div>
  				</div>
  <!-- Carousel nav -->
  				<a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
  				<a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
			</div>
            
          </div>
        </div>
      </div>
      </div>
      </div>
  </div>

  <script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
  <script src="js/jquery-1.7.2.min.js"></script>
  <script src="js/jquery.cookie.js"></script>
  <script src="js/jquery.history.js"></script>
  <script src="js/charisma.js"></script>




  <!-- jQuery UI -->
  <script src="js/jquery-ui-1.8.21.custom.min.js"></script>
  <!-- transition / effect library -->

  <!-- custom dropdown library -->
  <script src="js/bootstrap-dropdown.js"></script>
  <!-- scrolspy library -->
  
  <!-- library for creating tabs -->
  <script src="js/bootstrap-tab.js"></script>
  <!-- library for advanced tooltip -->
  <script src="js/bootstrap-tooltip.js"></script>
  <!-- popover effect library -->
  <script src="js/bootstrap-popover.js"></script>
  <!-- button enhancer library -->
  <script src="js/bootstrap-button.js"></script>
  <!-- accordion library (optional, not used in demo) -->
  <script src="js/bootstrap-collapse.js"></script>
  <!-- carousel slideshow library (optional, not used in demo) -->
 
  <!-- autocomplete library -->
  <script src="js/bootstrap-typeahead.js"></script>
  <!-- tour library -->
  <script src="js/bootstrap-tour.js"></script>
  <!-- library for cookie management -->
<script src="js/jquery.chosen.min.js"></script>
  <!-- checkbox, radio, and file input styler -->
  <script src="js/jquery.uniform.min.js"></script>
  <!-- plugin for gallery image view -->
  <script src="js/jquery.colorbox.min.js"></script>
  <!-- rich text editor library -->
  <script src="js/jquery.cleditor.min.js"></script>
  <!-- notification plugin -->
  <script src="js/jquery.noty.js"></script>
  <!-- file manager library -->
  <script src="js/jquery.elfinder.min.js"></script>
  <!-- star rating plugin -->
  <script src="js/jquery.raty.min.js"></script>
  <!-- for iOS style toggle switch -->
  <script src="js/jquery.iphone.toggle.js"></script>
  <!-- autogrowing textarea plugin -->
  <script src="js/jquery.autogrow-textarea.js"></script>
  <!-- multiple file upload plugin -->
  <script src="js/jquery.uploadify-3.1.min.js"></script>
  <!-- history.js for cross-browser state change on ajax -->
  <!-- calander plugin -->
  <script src='js/fullcalendar.min.js'></script>
  <!-- data table plugin -->
  <script src='js/jquery.dataTables.min.js'></script>

  <%} %>
</body>
</html>