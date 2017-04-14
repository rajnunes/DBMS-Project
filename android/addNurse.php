<?php 
	if($_SERVER['REQUEST_METHOD']=='POST'){
		
		//Getting values
		$name = $_POST['name'];
		$id = $_POST['id'];
		$nur_gender=$_POST['gender'];
		
		//Creating an sql query
		$sql = "INSERT INTO Nurse (nur_name,nur_gender) VALUES ('$name','$nur_gender')";
		
		//Importing our db connection script
		require_once('dbConnect.php');
		
		//Executing query to database
		if(mysqli_query($con,$sql)){
			echo 'Nurse Added Successfully';
		}else{
			echo 'Could Not Add Nurse';
		}
		
		//Closing the database 
		mysqli_close($con);
	}
?>