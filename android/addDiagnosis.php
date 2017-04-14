<?php 
	if($_SERVER['REQUEST_METHOD']=='POST'){
		
		//Getting values
		$pat_id= $_POST['name'];
		$dr_id = $_POST['id'];
		$diagnosis=$_POST['gender'];
		
		//Creating an sql query
		$sql = "INSERT INTO Diagnosis (pat_id,dr_id,description) VALUES ($pat_id,$dr_id,'$diagnosis')";
		
		//Importing our db connection script
		require_once('dbConnect.php');
		
		//Executing query to database
		if(mysqli_query($con,$sql)){
			echo 'diagnosis Added Successfully';
		}else{
			echo 'Could Not Add diagnosis';
		}
		
		//Closing the database 
		mysqli_close($con);
	}
?>