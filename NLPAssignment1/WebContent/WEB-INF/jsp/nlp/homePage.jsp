<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script type="text/jacascript" src="js/jquery-3.3.1.min.js"></script>
<style type="text/css">

<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>

#input, #suggested{
    margin-right:10px;
    float:left;
}

#suggested ul{
    background-color: darkgrey;
    width: 120px;
    height: 300px;
    overflow-y: scroll;
    border-radius: 5px;
}
#suggested ul li{
    list-style-type: none;
    height: 30px;
    padding-top: 1px;
    font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
    font-size: 16px;
}
#suggested ul li:hover{
    background-color:beige;
    cursor: pointer;
}
</style>


<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
* {box-sizing: border-box;}

body {
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}

.topnav {
  overflow: hidden;
  background-color: #e9e9e9;
}

.topnav a {
  float: left;
  display: block;
  color: black;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.topnav a:hover {
  background-color: #ddd;
  color: black;
}

.topnav a.active {
  background-color: #2196F3;
  color: white;
}

.topnav .search-container {
  float: right;
}

.topnav input[type=text] {
  padding: 6px;
  margin-top: 8px;
  font-size: 17px;
  border: none;
}

.topnav .search-container button {
  float: right;
  padding: 6px 10px;
  margin-top: 8px;
  margin-right: 16px;
  background: #ddd;
  font-size: 17px;
  border: none;
  cursor: pointer;
}

.topnav .search-container button:hover {
  background: #ccc;
}

@media screen and (max-width: 600px) {
  .topnav .search-container {
    float: none;
  }
  .topnav a, .topnav input[type=text], .topnav .search-container button {
    float: none;
    display: block;
    text-align: left;
    width: 100%;
    margin: 0;
    padding: 14px;
  }
  .topnav input[type=text] {
    border: 1px solid #ccc;  
  }
}

shadow-textarea textarea.form-control::placeholder {
    font-weight: 300;
}
.shadow-textarea textarea.form-control {
    padding-left: 0.8rem;
}
</style>



</head>
<body>
<center>
<pre>
<h2>NLP Class Assignment Utpal Garain(Guide)</h2>
<h3>Author:Dipayan Das
Roll:CS1726
M.Tech-CS
</h3>
</pre>
</center>

	<div class="container">
       <div class="form-group shadow-textarea">
        <textarea  id="textinp" name="textinp" class="form-control z-depth-1" placeholder="Write Something Here"></textarea>
        </div>
        <div id="suggested"></div>
    

</div>




</html>


<script>
function get_last_word(words) {
    var n = words.split(" ");
    return n[n.length - 1];
}
function IsPunctuation(c)
{
    var cc = c.charCodeAt(0);
    if ( ( cc >= 20 && cc <= 0x2F ) ||
        ( cc >= 0x3A && cc <= 0x40 ) ||
        ( cc >= 0x5B && cc <= 0x60 ) ||
        ( cc >= 0x7B && cc <= 0x7E ) ){
            return true ;
        }
        return false ;
}

$(document).ready(function(){
    $('#textinp').keyup(function(){
        var text = $(this).val();
        $('#suggested').fadeOut();
        if(text != '' && (text[text.length-1] == " " || IsPunctuation(text[text.length - 1]))){
            var last_word = get_last_word(text.trim());
            last_word = last_word.toLowerCase();
            console.log("last word " + last_word)
            $.ajax({
                type : "POST",
                url: "wordList",
                data:{query:last_word},
                success:function(data)
                {
                    console.log(data)
                    $('#suggested').fadeIn();
                    $('#suggested').html(data);
                }
            });
        }
    });

    $(document).on('click', 'li', function(){
        var current_val =  $('#textinp').val()
        $('#textinp').val(current_val + $(this).text());
        $('#suggested').fadeOut();
        $('#textinp').focus();
    });
});

</script>