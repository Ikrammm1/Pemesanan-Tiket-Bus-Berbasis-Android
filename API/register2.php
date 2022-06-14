<?php

require_once('konek.php');
if($_SERVER["REQUEST_METHOD"] === 'POST'){
    
    $nama = $_REQUEST['nama'];
    $no_hp = $_REQUEST['no_hp'];
    $email = $_REQUEST['email'];
    $password = $_REQUEST['password'];
    $alamat = $_REQUEST['alamat'];
    

    $query = "INSERT INTO user ( nama, no_hp, email, password, alamat) VALUES ('$nama', '$no_hp', '$email', '$password', '$alamat')";
    $result = $db_connect->query($query);

    if ($result == 1)
    {
        $data["message"] = "data saved successfully";
        $data["status"] = "Ok";
    }
    else
    {
        $data["message"] = "data not saved successfully";
        $data["status"] = "error";    
    }
}
else
{
    $data["message"] = "Format not supported";
    $data["status"] = "error";    
}
    echo json_encode($data);