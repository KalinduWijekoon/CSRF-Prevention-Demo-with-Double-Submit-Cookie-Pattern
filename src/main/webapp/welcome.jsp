<%-- 
    Document   : welcome
    Created on : Sep 27, 2018, 9:39:43 PM
    Author     : KALINDU
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
        
        <script src="js/jquery-2.2.4.js"></script>
        <script type="text/javascript">
                        
            function getCookie(cname){
                var name = cname + "=";
                var decodedCookie = decodeURIComponent(document.cookie);
                var ca = decodedCookie.split(';');
                for(var i = 0; i <ca.length; i++) {
                    var c = ca[i];
                    while (c.charAt(0) === ' ') {
                        c = c.substring(1);
                    }
                    if (c.indexOf(name) === 0) {
                        return c.substring(name.length, c.length);
                    }
                }
                return "";
            }
            var csrfcookie = getCookie("CSRF_Token");
            
            $(document).ready(function(){
            window.onload = function() {
                
                $('#token').val(csrfcookie);
            }});
        </script>
        
    </head>
    <body>
        <h1>Registration Form</h1>
        <form method="post" action="SessionDemo">
            <table border="0" cellpadding="2" cellspacing="2">
                <tr>
                    <td>First Name</td>
                    <td><input type="text" name="fname" /></td>
                </tr>
                <tr>
                    <td>Last Name</td>
                    <td><input type="text" name="lname" /></td>
                </tr>
                
                <tr>
                    <td>&nbsp;</td>
                    <td><input type="submit" name="buttn" value="Submit" /></td>

                </tr>
            </table>
            <input type="hidden" id="token" name="token" value="a"/>
        </form>
    </body>
</html>
