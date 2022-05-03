<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="style3.css" rel="stylesheet">
    <title>CPSC-304 Project</title>
</head>
<body>
<center class="center" >

    <h3>Order Queue</h3>
    <div class="form">
        <label>Order</label>
    </div>
    <div>
        <textarea class="orderlist" name="orderDetails" rows="4" cols="50">
Please prepare this order :
</textarea>
    </div>
<div>
    <label> Order Status</label><br>
    <br>
    <input type="radio" name="orderStatus" value="Preparing">
    <label>Preparing   </label>
    <input type="radio" name="orderStatus" value="Prepared">
    <label >Prepared   </label>
    <input type="radio" name="orderStatus" value="Served">
    <label >Served   </label>
</div>
    <br>
    <input type="button" name="moreOrder" value="Update">

</center>
</body>
</html>