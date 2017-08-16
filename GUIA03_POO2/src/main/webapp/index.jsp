<%@page import="com.sv.udb.control.PersonaCtrl"%>
<%@page import="com.sv.udb.modelo.Persona"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Enviar email</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="webjars/materialize/0.97.3/dist/css/materialize.css">
    </head>
    <body>
        <br/>
        <div class="container">
            <form method="POST" action="EnviarCorreoServ"> 
                <div class="input-field col s12">
                    <select multiple id="para" name="para">
                        <%
                            for(Persona temp : new PersonaCtrl().consTodo())
                            {
                        %>
                        <option value="<%=temp.getMailPers()%>"><%=temp.getNombPers()%></option>
                        <%
                            }
                        %>
                    </select>
                    <label>Para:</label>
                </div>
                <br/>
                <div class="input-field col">
                    <input id="asunto" name="asunto" type="text" class="validate">
                    <label for="asunto">Asunto</label>
                </div>
                <br/>
                <div class="input-field col">
                    <select name="cc" id="cc" class="selectpicker" multiple>
                        <%
                            for(Persona temp : new PersonaCtrl().consTodo())
                            {
                        %>
                        <option value="<%=temp.getMailPers()%>"><%=temp.getNombPers()%></option>
                        <%
                            }
                        %>
                    </select>
                    <label>CC:</label>
                </div>
                <br/>  
                <div class="input-field col">
                    <select name="cco" id="cco" class="selectpicker" multiple>
                        <%
                            for(Persona temp : new PersonaCtrl().consTodo())
                            {
                        %>
                        <option value="<%=temp.getMailPers()%>"><%=temp.getNombPers()%></option>
                        <%
                            }
                        %>
                    </select>
                    <label>CCO:</label>
                </div>

                <div class="row">
                    <div class="row">
                        <div class="input-field col">
                            <textarea id="mensaje" class="materialize-textarea" name="mensaje"></textarea>
                            <label for="mensaje">Mensaje</label>
                        </div>
                    </div>
                </div>
                
                <button class="btn waves-effect waves-light green darken-1" type="submit" value="Enviar" name="btonDenu">Enviar
                    <i class="material-icons right">send</i>
                </button>
              
                <button class="btn waves-effect waves-light red darken-4" type="submit" value="Cancelar" name="btonDenu">Cancelar
                    <i class="material-icons right">close</i>
                </button>
              
            </form>
        </div>
    </body>
    <script type="text/javascript" src="webjars/materialize/0.97.3/dist/js/materialize.js"></script>
</html>
