<?php

define('HOST', 'localhost');
define('USER', 'root');
define('PASS', '');
define('DB', 'e-bus');

$db_connect = mysqli_connect(HOST, USER, PASS, DB) or die('gagal koneksi db')
?>