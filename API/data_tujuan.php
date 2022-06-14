<?php

require_once('konek.php');

$query = "SELECT * FROM rute";
$sql = mysqli_query($db_connect, $query);

if($sql){
    $result = array(); 
    while($row = mysqli_fetch_array($sql)){
        array_push($result, array(
           'id_rute' => $row['id_rute'],
           'rute' => $row['rute'],
           'harga_rute' => $row['harga_rute'],
           

        ));

    } 

    echo json_encode ( array('Rute' =>$result));
}

?>