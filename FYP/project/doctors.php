<?php

include_once("connection.php");


$query = "select name,address,specialization,pic from markers";
$result = mysqli_query($con,$query);
while($row = mysqli_fetch_assoc($result))
{
	$data[] = $row;
}
echo json_encode($data);


?>