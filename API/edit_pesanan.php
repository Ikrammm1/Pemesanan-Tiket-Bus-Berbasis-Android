<?php

require_once('konek.php');
parse_str(file_get_contents('php://input'), $value);

    $id_transaksi = $value['id_transaksi'];
    $status = $value['status'];

$query = "UPDATE transaksi SET status = '$status' WHERE  id_transaksi='$id_transaksi'";
$sql = mysqli_query($db_connect, $query);

if($sql){
    echo json_encode ( array('pesan ' => 'data berhasil diubah!'));
} else {
    echo json_encode (array ('pesan ' => 'gagal merubah data'));
}

?>