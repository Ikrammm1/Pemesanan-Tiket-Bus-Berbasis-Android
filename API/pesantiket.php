<?php
require_once('konek.php');
// $conn = mysqli_connect('localhost', 'id18158410_root', 'NyANVIF19}1-=eHd', 'id18158410_e_bus');
if($_SERVER["REQUEST_METHOD"] === 'POST'){
    
    $id_user = $_REQUEST['id_user'];
    $id_kategori = $_REQUEST['id_kategori'];
    $id_rute = $_REQUEST['id_rute'];
    $id_bus = $_REQUEST['id_bus'];
    $keberangkatan = $_REQUEST['keberangkatan'];
    $jam = $_REQUEST['jam'];
    $nama_pembeli =  $_REQUEST['nama_pembeli'];
    $status =  $_REQUEST['status'];

    $query = "INSERT INTO transaksi (
        
        id_user,
        id_kategori,
        id_rute,
        id_bus,
        keberangkatan,
        jam,
        nama_pembeli,
        status) 

    VALUES (
        
        '$id_user',
        '$id_kategori',
        '$id_rute',
        '$id_bus',
        '$keberangkatan',
        '$jam',
        '$nama_pembeli',
        '$status')";
    
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
    };
}
else
{
    $data["message"] = "Format not supported";
    $data["status"] = "error";    
}
    echo json_encode($data);