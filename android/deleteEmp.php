<?php 
	$id = $_POST['id'];
	
	require_once('dbConnect.php');
	
	$sql = "DELETE FROM Patient WHERE id=$id;";
	
	if(mysqli_query($con,$sql)){
		echo 'Patient Deleted Successfully';
	}else{
		echo 'Could Not Delete Patient Try Again';
	}
	
	mysqli_close($con);
?>