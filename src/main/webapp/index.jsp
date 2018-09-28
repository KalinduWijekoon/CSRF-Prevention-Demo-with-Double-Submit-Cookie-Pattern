<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <script src="js/jquery-2.2.4.js"></script>
        <script type="text/javascript">
            
            function generateToken() {
                  var text = "";
                  var possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
                  for (var i = 0; i < 50; i++) {
                    text += possible.charAt(Math.floor(Math.random() * possible.length));
                }
                  return text;
                }
            var token = generateToken();
            document.cookie = "CSRFCookie="+token+";path=/";
                        
            function getCookie(cname) {
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
            var csrfcookie = getCookie("CSRFCookie");
            
            $(document).ready(function(){
            window.onload = function() {
                
                $('#token').val(csrfcookie);

            }});

        </script>

        
    </head>
    <body>
        <h1>Login Page!</h1>
        
        <form method="post" action="SessionDemo">
            <table border="0" cellpadding="2" cellspacing="2">
                <tr>
                    <td>Username</td>
                    <td><input type="text" name="username" value="admin" /></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="password" value="admin" /></td>
                </tr>
                
                <tr>
                    <td>&nbsp;</td>
                    <td><input type="submit" name="buttn" value="Login" /></td>

                </tr>
            </table>
            <input type="hidden" id="token" name="token" value="a"/>
        </form>
    </body>
</html>
