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

    <h3>Staff Sign-Up</h3>
    <div class="form">
        <table>

            <br> <tr>Enter email: </tr><br>
            <tr>
                <input type="text" name="email">
            </tr><br>


            <tr>Enter name: </tr><br>
            <tr>
                <input type="text" name="Name">
            </tr><br>


            <tr>Enter phone number </tr><br>
            <tr>
                <input type="number" name="phone">
            </tr><br>


            <tr>Select Role </tr><br>
            <tr>
                <select name="role" id="role">
                    <option value="Server">Server</option>
                    <option value="Chef">Chef</option>
                </select>
            </tr><br>


            <tr>Set up password: </tr><br>
            <tr>
                <input type="password" name="password">
            </tr><br><br>


            <tr>
                <input type="submit" name="submit" value="Finish sign up" >
            </tr><br>

        </table>
    </div>
</center>
</body>
</html>