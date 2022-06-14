<?php




require_once('konek.php');



$id_user = $_POST['id_user'];
$nama = $_POST['nama'];
$no_hp = $_POST['no_hp'];
$alamat = $_POST['alamat'];
$email = $_POST['email'];
$password = $_POST['password'];

$query = "INSERT INTO user (id_user, nama, no_hp, alamat, email, password) VALUES ('$id_user','$nama', '$no_hp', '$alamat', '$email', '$password')";
$sql = mysqli_query($db_connect, $query);

if($sql){
    echo json_encode ( array('pesan ' => 'data berhasil ditambahkan!'));
} else {
    echo json_encode (array ('pesan ' => 'gagal merubah data'));
}


?>