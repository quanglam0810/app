<?php
	include "connect.php";
	$json = $_POST['json'];
	$data = json_decode($json,true);
	foreach ($data as $value) {
		$Email = $value['email'];
		$Password = $value['password'];
		$Phonenumber = $value['phonenumber'];
		$query = "INSERT INTO user (email, password, phonenumber)
					VALUES ('$Email', '$Password', '$Phonenumber')";
		$Dta = mysqli_query($conn,$query);
	}
	if ($Dta) {
		echo "1";
	}else {
		echo "0";
	}
?>
