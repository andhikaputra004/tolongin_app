<?php
defined('BASEPATH') OR exit('No direct script access allowed');

/*
| -------------------------------------------------------------------------
| URI ROUTING
| -------------------------------------------------------------------------
| This file lets you re-map URI requests to specific controller functions.
|
| Typically there is a one-to-one relationship between a URL string
| and its corresponding controller class/method. The segments in a
| URL normally follow this pattern:
|
|	example.com/class/method/id/
|
| In some instances, however, you may want to remap this relationship
| so that a different class/function is called than the one
| corresponding to the URL.
|
| Please see the user guide for complete details:
|
|	https://codeigniter.com/user_guide/general/routing.html
|
| -------------------------------------------------------------------------
| RESERVED ROUTES
| -------------------------------------------------------------------------
|
| There are three reserved routes:
|
|	$route['default_controller'] = 'welcome';
|
| This route indicates which controller class should be loaded if the
| URI contains no data. In the above example, the "welcome" class
| would be loaded.
|
|	$route['404_override'] = 'errors/page_missing';
|
| This route will tell the Router which controller/method to use if those
| provided in the URL cannot be matched to a valid route.
|
|	$route['translate_uri_dashes'] = FALSE;
|
| This is not exactly a route, but allows you to automatically route
| controller and method names that contain dashes. '-' isn't a valid
| class or method name character, so it requires translation.
| When you set this option to TRUE, it will replace ALL dashes in the
| controller and method URI segments.
|
| Examples:	my-controller/index	-> my_controller/index
|		my-controller/my-method	-> my_controller/my_method
*/
$route['default_controller'] = 'welcome';
$route['404_override'] = '';
$route['translate_uri_dashes'] = FALSE;
$route['insertpengguna']='Logter_controller/insert_pengguna';
$route['login']='Logter_controller/aksi_login';
$route['register']='Logter_controller/index';
$route['logoutaction']='Logter_controller/logout';

$route['dashboard']='Dashboard_controller/view_crud';

$route['bencana']='Adminbencana_controller/view_bencana';
$route['insert_bencana']='Adminbencana_controller/insert_bencana';
$route['getidBencana']['GET']='Adminbencana_controller/GetId';

$route['pengguna']='Adminpengguna_controller/view_pengguna';
$route['insert_pengguna']='Adminpengguna_controller/insert_pengguna';
$route['getidPengguna']['GET']='Adminpengguna_controller/GetId';
$route['updatepengguna']['POST']='Adminpengguna_controller/UpdateData';
$route['delete_pengguna']['GET']='Adminpengguna_controller/hapusData';

$route['penggalangdana']='Adminpenggalangdana_controller/view_penggalangdana';
$route['insert_penggalangdana']='Adminpenggalangdana_controller/insert_penggalangdana';
$route['getidPenggalangdana']['GET']='Adminpenggalangdana_controller/GetId';
$route['updatepenggalangdana']['POST']='Adminpenggalangdana_controller/UpdateData';
$route['delete_penggalangdana']['GET']='Adminpenggalangdana_controller/hapusData';


$route['rekening']='Adminrekening_controller/view_rekening';
$route['insert_rekening']='Adminrekening_controller/insert_rekening';
$route['getidRekening']['GET']='Adminrekening_controller/GetId';
$route['updaterekening']['POST']='Adminrekening_controller/UpdateData';
$route['delete_rekening']['GET']='Adminrekening_controller/hapusData';


//mobile
//login-register
$route['loginmobile']['POST']='LogterMobile_controller/Login_mobile';
$route['Register_Donatur']['POST'] = 'LogterMobile_controller/RegisterDonatur';

$route['ganti_password']['PUT'] = 'LogterMobile_controller/GantiPassword';


$route['do_transaksi']['POST'] = 'transaksi_controller/doTransaksi';

//bencana
$route['List_bencana']['GET'] = 'BencanaMobile_Controller/GetListBencana';
$route['IDList_bencana']['POST'] = 'BencanaMobile_Controller/GetBencanaId';

$route['getHistory']['POST'] = 'Transaksi_controller/getHistory';

$route['transaksi/update']['POST']='transaksi_controller/updateTransaksi';