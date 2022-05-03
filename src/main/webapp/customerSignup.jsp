<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/signupstyle.css" rel="stylesheet">
    <title>CPSC-304 Project</title>
</head>
<body>
<center class="center" >

    <h3>Customer Sign-Up</h3>
    <form method="POST" action="CustomerSignup">
        <table>

               <br> <tr>Enter email: </tr><br>
                <tr>
                    <input type="text" id="email" name="email">
                </tr><br>


                <tr>Enter name: </tr><br>
                <tr>
                    <input type="text" id="name" name="name">
                </tr><br>


                <tr>Enter phone number </tr><br>
                <tr>
                    <input type="number" id="phone" name="phone">
                </tr><br>


                <tr>Enter address </tr><br>
                <tr>
                    <input type="text" id="address" name="address">
                </tr><br>


                <tr>Set up password: </tr><br>
                <tr>
                    <input type="password" id="password" name="password">
                </tr><br><br>


                <tr>
                    <input type="submit" name="submit" value="Finish sign up" >
                </tr><br>

        </table>
    </form>
</center>
</body>
</html>