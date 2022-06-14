<?php

require_once('konek.php');
$id_user = $_POST['id_user'];

$query = "SELECT *, (rute.harga_rute + kategori.harga_kategori) 
AS Total 
FROM (
    `rute`, 
    `kategori`, 
    bus, user) 
    JOIN `transaksi`
     ON `transaksi`.`id_user` = `user`.`id_user` 
     AND `transaksi`.`id_rute` = `rute`.`id_rute` 
     AND `transaksi`.`id_kategori` = `kategori`.`id_kategori` 
     AND `transaksi`.`id_bus` = `bus`.`id_bus` 
     WHERE `transaksi`.`id_user` = '$id_user' AND `transaksi`.`id_rute` = `rute`.`id_rute` 
     AND `transaksi`.`id_kategori` = `kategori`.`id_kategori` 
     AND `transaksi`.`id_bus` = `bus`.`id_bus` ORDER by id_transaksi DESC;";
$sql = mysqli_query($db_connect, $query);

if($sql){
    $result = array(); 
    while($row = mysqli_fetch_array($sql)){
        array_push($result, array(
            'id_transaksi' => $row['id_transaksi'],
            'id_user' => $row['id_user'],
           'nama_pembeli' => $row['nama_pembeli'],
           'id_kategori' => $row['id_kategori'],
           'kategori' => $row['kategori'],
           'id_rute' => $row['id_rute'],
           'rute' => $row['rute'],
           'id_bus' => $row['id_bus'],
           'nama_bus' => $row['nama_bus'],
           'keberangkatan' => $row['keberangkatan'],
           'jam' => $row['jam'],
           'status' => $row['status'],
           'harga_rute' => $row['harga_rute'],
           'harga_kategori' => $row['harga_kategori'],
           'Total' =>$row['Total']

        ));

    } 

    echo json_encode(array('Transaksi' =>$result));
}


?>