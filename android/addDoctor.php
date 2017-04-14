<?php 
	if($_SERVER['REQUEST_METHOD']=='POST'){
		
		//Getting values
		$name = $_POST['name'];
		$id = $_POST['id'];
		$designation=$_POST['designation'];
		$doc_gender=$_POST['gender'];
		
		//Creating an sql query
		$sql = "INSERT INTO Doctor (dr_name,dr_gender,designation) VALUES ('$name','$doc_gender','$designation')";
		
		//Importing our db connection script
		require_once('dbConnect.php');
		
		//Executing query to database
		if(mysqli_query($con,$sql)){
			echo 'Doctor Added Successfully';
		}else{
			echo 'Could Not Add Doctor';
		}
		
		//Closing the database 
		mysqli_close($con);
	}
?>