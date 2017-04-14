<?php 
	if($_SERVER['REQUEST_METHOD']=='POST'){
		
		//Getting values
		$name = $_POST['name'];
		$id = $_POST['id'];
		$phone = $_POST['phone'];
		$pat_age=$_POST['age'];
		$address=$_POST['address'];
		$pat_gender=$_POST['gender'];
		
		//Creating an sql query
		$sql = "INSERT INTO Patient (name,phone,pat_age,address,pat_gender) VALUES ('$name','$phone','$pat_age','$address','$pat_gender')";
		
		//Importing our db connection script
		require_once('dbConnect.php');
		
		//Executing query to database
		if(mysqli_query($con,$sql)){
			echo 'Patient Added Successfully';
		}else{
			echo 'Could Not Add Patient';
		}
		
		//Closing the database 
		mysqli_close($con);
	}
?>