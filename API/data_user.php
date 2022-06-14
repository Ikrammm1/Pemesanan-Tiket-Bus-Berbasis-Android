<?php

require_once('konek.php');

$query = "SELECT * FROM user";
$sql = mysqli_query($db_connect, $query);

if($sql){
    $result = array(); 
    while($row = mysqli_fetch_array($sql)){
        array_push($result, array(
           'id_user' => $row['id_user'],
           'nama' => $row['nama'],
           'no_hp' => $row['no_hp'],
           'email' => $row['email'],
           'password' => $row['password'],

        ));

    } 

    echo json_encode(array('User' =>$result));
}

?>