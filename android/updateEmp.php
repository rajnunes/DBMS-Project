<?php 
	if($_SERVER['REQUEST_METHOD']=='POST'){
		$id = $_POST['id'];
		$name = $_POST['name'];
		//$desg = $_POST['desg'];
		//$sal = $_POST['salary'];
		
		require_once('dbConnect.php');
		
		$sql = "UPDATE Patient SET name = '$name' WHERE id = $id;";
		
		if(mysqli_query($con,$sql)){
			echo 'Patient Updated Successfully';
		}else{
			echo 'Could Not Update Patient Try Again';
		}
		
		mysqli_close($con);
	}
?>