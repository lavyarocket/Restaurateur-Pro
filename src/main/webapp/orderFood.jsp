<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="style2.css" rel="stylesheet">
    <title>CPSC-304 Project</title>
</head>
<body>
<center class="center" >

    <h3>Order Food</h3>
    <div class="form">
        <table class="select">
            <tr>
                <td>
                <label>Choose a Item:  </label>
                <select name="items" id="items">
                    <option value="Combo1">combo 1</option>
                    <option value="Combo2">combo 2</option>
                    <option value="Combo3">combo 3</option>
                    <option value="Combo4">combo 4</option>
                </select>
                <br><br>

                </td>
            </tr>
            <tr>
                <td> <input class="add" type="button" name="Add" value="Add to cart"></td>
            </tr>


        </table>


    </div>
    <div>
        <textarea class="orderlist" name="orderList" rows="4" cols="50">
Your current order is :
</textarea>
    </div>

    <input type="submit" name="orderNow" value="Order Now">

</center>
</body>
</html>