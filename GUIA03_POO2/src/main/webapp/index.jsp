<%@page import="com.sv.udb.control.PersonaCtrl"%>
<%@page import="com.sv.udb.modelo.Persona"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Enviar email</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
        <link href="https://select2.github.io/dist/css/select2.min.css" rel="stylesheet">
        <script src="https://select2.github.io/dist/js/select2.full.js"></script>
        <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
        <script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>
        <script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/js/mail.js"></script>
        <link rel='stylesheet' href='${pageContext.request.contextPath}/resources/lib/select/bootstrap-select.css'>
        <script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/select/bootstrap-select.js"></script>
        <style>
        </style>
    </head>
    <body>
        <br/>
        <div class="container">
            <div class="row inbox">

                <div class="col-md-9">
                    <div class="panel panel-default">
                        <div class="panel-body message">
                            <p class="text-center">Nuevo Correo</p>
                    <form class="form-horizontal" role="form"method="POST" action="EnviarCorreoServ">
                        <div class="form-group">
                            <label for="email">
                                Para: </label>
                            <div class="input-group">
                                <span class="input-group-addon"><span class="glyphicon glyphicon-envelope"></span>
                                </span>
                                <select class="form-control selectpicker" name="email" multiple title="Ingrese los correos"
                                        data-live-search="true">
                                    <%
                                        for (Persona temp : new PersonaCtrl().consTodo()) {
                                    %>
                                        <option value="<%= temp.getMailPers()%>"><%= temp.getNombPers()%></option>
                                    <%
                                        }
                                    %>
                                </select>
                            </div>
                        </div>
                                    <div class="form-group">
                                    <label for="bcc" class="col-sm-1 control-label">CCO:</label>
                                    <div class="col-sm-11">
                                        <input type="email" class="form-control select2-offscreen" id="bcc" placeholder="Type email" tabindex="-1">
                                    </div>
                                </div>

                            </form>

                            <div class="col-sm-11 col-sm-offset-1">

                                <div class="form-group">
                                        <textarea class="form-control" id="message" name="body" rows="12" placeholder="Cuerpo del e-mail"></textarea>
                                </div>

                                <div class="form-group">	
                                    <input type="submit" name="enviBton" value="Enviar" class="btn btn-sm btn-success" />
                                    <button type="submit" class="btn btn-danger">Descartar</button>
                                </div>
                            </div>	
                        </div>	
                    </div>	
                </div><!--/.col-->		
            </div>
        </div>
    </body>
</html>
