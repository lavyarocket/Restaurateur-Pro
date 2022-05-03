<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/style5.css" rel="stylesheet">
    <title>CPSC-304 Project</title>
</head>
<body>
<center class="center" >

    <h3>Please give your feedback</h3>
    <form class="form">
        <table>

            <br> <tr>Enter feedback title: </tr><br>
            <tr>
                <input type="text" id="itemTitle" name="itemTitle">
            </tr><br>


            <tr>Enter Description: </tr><br>
            <tr>
                <input type="text" id="itemDescription" name="itemDescription">
            </tr><br>


            <br><tr>Enter ratings </tr><br>
            <tr>
                <div>
                    <br>
                    <input type="radio" name="ratings" id="rating1" value="1">
                    <label>1 star  </label>
                    <input type="radio" name="ratings" id="rating2" value="2">
                    <label >2 star   </label>
                    <input type="radio" name="ratings" id="rating3" value="3">
                    <label >3 star   </label>
                    <input type="radio" name="ratings" id="rating4" value="3">
                    <label >4 star   </label>
                    <input type="radio" name="ratings" id="rating5" value="3">
                    <label >5 star</label>
                </div>
            </tr>
            <br><tr>
            <a href="index.html"><input type="submit" id="submitFeedback" name="submitFeedback" value="Submit feedback "></a>
        </tr><br>
        </table>
    </form>

</center>
</body>
</html>