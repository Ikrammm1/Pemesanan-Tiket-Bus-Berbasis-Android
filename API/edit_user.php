<?php
require_once('konek.php');

parse_str(file_get_contents('php://input'), $value);


$id_user = $value['id_user'];
$nama = $value['nama'];
$no_hp = $value['no_hp'];
$alamat = $value['alamat'];
$email = $value['email'];
$password = $value['password'];

$query = "UPDATE user SET id_user = '$id_user', nama ='$nama', no_hp='$no_hp', alamat='$alamat', email='$email', password='$password' WHERE id_user='$id_user' ";
$sql = mysqli_query($db_connect, $query);

if($sql){
    echo json_encode ( array('pesan ' => 'data berhasil diubah!'));
} else {
    echo json_encode (array ('pesan ' => 'gagal merubah data'));
}


?>