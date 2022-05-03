<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/style.css" rel="stylesheet">
    <title>CPSC-304 Project</title>
</head>
<body>
<center class="center" >

    <h3>Customer Portal Login</h3>
    <form method="POST" action="form">
        <table>
            <tr>
                <td>Email: </td>
                <td>
                    <input type="text" name="email" id="email">
                </td>
            </tr>
            <tr>
                <td>Password: </td>
                <td>
                    <input type="password" name="password" id="password">
                </td>
            </tr>
            <tr>
                <td>
                    <a href="orderFood.html"><input type="submit" name="submit" value="Login" id="submit" ></a>
                </td>
            </tr>
        </table>

        <a href="signUp.html"><input type="submit" name="sign-up" value="Sign-up" id="sign-up"></a>
    </form>
</center>
</body>
</html>