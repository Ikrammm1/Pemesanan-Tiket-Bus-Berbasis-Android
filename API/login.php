<?php

$server = "localhost";
$username = "root";
$password = "";
$database = "e-bus";
$koneksi = mysqli_connect($server, $username, $password, $database);

if(mysqli_connect_errno()){
    echo"gagal koneksi" .mysqli_connect_errno();
}
//ambil data yang dikirim dari android
$email = $_POST["post_email"];
$password = $_POST['post_password'];

//proses periksa username dan password di DB
$query = "SELECT * FROM user WHERE email='$email' AND password = '$password'";
$obj_query = mysqli_query($koneksi, $query);
$data = mysqli_fetch_array($obj_query);
//periksa apakah login sudah benar
if($data){
    echo json_encode(
        array(
            'response' => true,
            'payload' => array(
                "id_user" => $data["id_user"],
                "nama" => $data["nama"],
                "no_hp" => $data["no_hp"],
                "email" => $data["email"],
                "password" => $data["password"],  
                "alamat" => $data["alamat"], 
            )
        )
            );
} else {
    echo json_encode(
        array(
            'response' => false,
            'payload' => null
        )
        );
}



// mengatur tampilan json

header('Content-Type: application/json')

?>