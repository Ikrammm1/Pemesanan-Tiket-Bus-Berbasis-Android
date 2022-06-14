<?php

require_once('konek.php');
parse_str(file_get_contents('php://input'), $value);

    $id_transaksi = $value['id_transaksi'];
   

$query = "DELETE FROM transaksi WHERE  id_transaksi='$id_transaksi'";
$sql = mysqli_query($db_connect, $query);

if($sql){
    echo json_encode ( array('pesan ' => 'data berhasil dihapus!'));
} else {
    echo json_encode (array ('pesan ' => 'gagal menghapus data'));
}

?>