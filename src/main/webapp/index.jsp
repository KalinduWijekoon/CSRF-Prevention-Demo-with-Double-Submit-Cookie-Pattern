<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login Page!</h1>
        
        <form method="POST" action="Login">
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
        </form>
    </body>
</html>
