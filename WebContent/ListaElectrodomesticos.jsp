<%@page import="negocio.ControladorElectrodomesticoNegocio"%>
<%@page import="datos.CatalogoElectrodomestico"%>
<%@page import="models.Electrodomestico"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Listado Datos Alumnos</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/bootstrap-slate.css">
    <link rel="stylesheet" href="css/bootstrap-responsive.css">
    <link href="css/charisma-app.css" rel="stylesheet">
	<link href="css/jquery-ui-1.8.21.custom.css" rel="stylesheet">
	<link href='css/fullcalendar.css' rel='stylesheet'>
	<link href='css/fullcalendar.print.css' rel='stylesheet'  media='print'>
	<link href='css/chosen.css' rel='stylesheet'>
	<link href='css/uniform.default.css' rel='stylesheet'>
	<link href='css/colorbox.css' rel='stylesheet'>
	<link href='css/jquery.cleditor.css' rel='stylesheet'>
	<link href='css/jquery.noty.css' rel='stylesheet'>
	<link href='css/noty_theme_default.css' rel='stylesheet'>
	<link href='css/elfinder.min.css' rel='stylesheet'>
	<link href='css/elfinder.theme.css' rel='stylesheet'>
	<link href='css/jquery.iphone.toggle.css' rel='stylesheet'>
	<link href='css/opa-icons.css' rel='stylesheet'>
	<link href='css/uploadify.css' rel='stylesheet'>
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
	if(session.getAttribute("usuario")==null)
	response.sendRedirect("login.jsp");
else {
	String usu= (String)session.getAttribute("usuario");
	ArrayList <Electrodomestico> vListaElectro;
    ControladorElectrodomesticoNegocio controladorElectro = (ControladorElectrodomesticoNegocio)session.getAttribute("controladorElectro");
   
    vListaElectro = controladorElectro.GetAllEl();
%>
<div class="navbar">
    <div class="navbar-inner">
      <div class="container-fluid">
        <a class="btn btn-navbar" data-toggle="collapse" data-target=".top-nav.nav-collapse,.sidebar-nav.nav-collapse">
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </a>
        <a class="brand" href="index.jsp"> <span>SGE</span></a>
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
            <li><a href="CargaAsistencias.jsp"><i class="icon-font"></i> Cargar Electrodomestico</a>           
            </li>
            <li><a class="ajax-link"><i class="icon-list-alt"></i><span class="hidden-tablet"> Listado Electrodomestico</span></a>
            <ul>
                <li><a class="ajax-link" href="ListadoDatosAlu.jsp">Modificarrrara</a></li>
                <li><a class="ajax-link" href="ListadoAsistencias.jsp">Asistencias</a></li>
                <li><a class="ajax-link" href="ListadoParciales.jsp">Parciales</a></li>
                <li><a class="ajax-link" href="ListadoTP.jsp">Trabajos Practicos</a></li>
              </ul>
            </li>
            <li><a class="ajax-link" href="CargaParciales.jsp"><i class="icon-edit"></i><span class="hidden-tablet"> Cargar Notas Parciales</span></a></li>
            <li><a class="ajax-link" href="CargaTP.jsp"><i class="icon-file"></i><span class="hidden-tablet"> Cargar notas TP</span></a></li>
            <li><a class="ajax-link" href="ModificarAlu.jsp"><i class="icon-pencil"></i><span class="hidden-tablet"> Modificar Datos Alumnos</span></a>
            </li>
            <li><a class="ajax-link" href="ModificarDatosDoc.jsp"><i class="icon-refresh"></i><span class="hidden-tablet"> Modificar Datos Docente</span></a></li>
            <li><a class="ajax-link"><i class="icon-remove"></i><span class="hidden-tablet"> Dar de baja</span></a>
            <ul>
                <li><a class="ajax-link" href="EliminaAlu.jsp">Alumno</a></li>
                <li><a class="ajax-link" href="EliminarComi.jsp">Curso</a></li>
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
            <h2 style=width:300px><i class="icon-edit" ></i> Listado de Electrodomesticos</h2>
            <div class="box-icon">
              <a href="#" class="btn btn-setting btn-round"><i class="icon-cog"></i></a>
              <a href="#" class="btn btn-minimize btn-round"><i class="icon-chevron-up"></i></a>
              <a href="#" class="btn btn-close btn-round"><i class="icon-remove"></i></a>
            </div>
          </div>
          <div class="box-content">
           
              <table class="table table-hover table-striped table-bordered" id="tabla">
                <thead>
                    <tr>
                      <th>
                        ID
                      </th>
                        <th>

                        Descripción
                      </th>
                        <th>
                        Color
                      </th>
                      <th>
                       Peso
                      </th>
                      <th>
                       Consumo
                      </th>
                      <th>
                       Precio
                      </th>
                     
                    </tr> 




                  </thead>
                  <tbody>
                  <%for(int i=0; i<vListaElectro.size();i++){ %>
                    <tr>
                      <td>
                 		<%=vListaElectro.get(i).getIdElect()%>
                      </td>
                       <td>
                        <%=vListaElectro.get(i).getDescripcion() %>
                      </td>
                       <td>
                        <%=vListaElectro.get(i).getColor() %>
                      </td>
                        <td>
						<%=vListaElectro.get(i).getPeso() %>
                      </td>
                      <td>
						<%=vListaElectro.get(i).getConsumoEnergetico() %>
                      </td>
                         <td>
						<%=vListaElectro.get(i).getPreciobase()%>
                      </td>

                    </tr>
					<%} %>
                  </tbody>




               </table>
          	
          </div>
        </div>
      </div>
      </div>
      </div>
  </div>

  
 
  


<!-- jQuery -->
	<script src="js/jquery-1.7.2.min.js"></script>
	<!-- jQuery UI -->
	<script src="js/jquery-ui-1.8.21.custom.min.js"></script>
	<!-- transition / effect library -->
	<script src="js/bootstrap-transition.js"></script>
	<!-- alert enhancer library -->
	<script src="js/bootstrap-alert.js"></script>
	<!-- modal / dialog library -->
	<script src="js/bootstrap-modal.js"></script>
	<!-- custom dropdown library -->
	<script src="js/bootstrap-dropdown.js"></script>
	<!-- scrolspy library -->
	<script src="js/bootstrap-scrollspy.js"></script>
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
	<script src="js/bootstrap-carousel.js"></script>
	<!-- autocomplete library -->
	<script src="js/bootstrap-typeahead.js"></script>
	<!-- tour library -->
	<script src="js/bootstrap-tour.js"></script>
	<!-- library for cookie management -->
	<script src="js/jquery.cookie.js"></script>
	<!-- calander plugin -->
	<script src='js/fullcalendar.min.js'></script>
	<!-- data table plugin -->
	<script src="js/jquery.dataTables.min.js"></script>

	<!-- chart libraries start -->
	<script src="js/excanvas.js"></script>
	<script src="js/jquery.flot.min.js"></script>
	<script src="js/jquery.flot.pie.min.js"></script>
	<script src="js/jquery.flot.stack.js"></script>
	<script src="js/jquery.flot.resize.min.js"></script>
	<!-- chart libraries end -->

	<!-- select or dropdown enhancer -->
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
	<script src="js/jquery.history.js"></script>
	<!-- application script for Charisma demo -->
	<script src="js/charisma.js"></script>

<script>
	$(document).ready( function() {
  $('#tabla').dataTable( {
	  "sDom": "<'row-fluid'<'span6'l><'span6'f>r>t<'row-fluid'<'span12'i><'span12 center'p>>",
		"sPaginationType": "bootstrap",
	  "aLengthMenu": [1,2,5,10],
	    "oLanguage": {
    
      "sSearch":"Buscar:",
      "sInfo":"Mostrando _START_ a _END_ de _TOTAL_ entradas",
      "sZeroRecords":"No se encontraron registros",
      "sInfoFiltered":"(filtrado de _MAX_ entradas)",
      "sInfoEmpty":"Mostrando 0 de 0 entradas",
      "sLengthMenu":     "campos a mostrar por pagina _MENU_",
    	  "oPaginate": {
          "sNext":     "Siguiente",
          "sPrevious": "Anterior"
      }
    }
  } );
} );
</script>
 <%} %> 
</body>
</html>