<?php
	include "connect.php";
	$username = $_GET["username"];
	$query="SELECT * FROM user where email = '$username'";
	$data=mysqli_query($conn,$query);
	if(mysqli_num_rows($data)!=0)
	{
		echo("exist");
	}
	else
	{
		echo("notexist");
	}
?>
