<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class LogterMobile_controller extends CI_Controller {

  public function __construct()
  {
    parent::__construct();
      $this->load->model('Mobilelogin_model');
  }

  public function Login_mobile()
  {
    $datalogin=json_decode(file_get_contents('php://input'),true);
    // $email=$this->input->post('email');
    // $password=md5($this->input->post('password'));
    $DataPengguna=$this->Mobilelogin_model->getDataPengguna($datalogin);
    if($DataPengguna==NULL)
    {
        $response=array(
            'success'=>false,
            'message'=>'Email/katasandi salah',
            // 'anu'=>$password 
          );
    }
    else {
      $response=array(
        'success'=>true,
        'role'=>'admin',
        'message'=>'berhasil masuk',
        'datapengguna'=> $DataPengguna
      );
    }

    $this->output
    ->set_status_header(200)
    ->set_content_type('application/json', 'utf-8')
    ->set_output(json_encode($response, JSON_PRETTY_PRINT))
    ->_display();
    exit;
  }

  public function RegisterDonatur()
  {
    $input = json_decode(file_get_contents('php://input'),true);
    if($this->Mobilelogin_model->cekEmail($input))
    {
      $this->Mobilelogin_model->insertPengguna($input);

      $response=array(
        'success'=>true,
        'message'=>'registrasi berhasil'
      );
    }
    else {
      $response=array(
        'success'=>false,
        'message'=>'Email sudah terdaftar'
      );
    }

    $this->output
    ->set_status_header(200)
    ->set_content_type('application/json', 'utf-8')
    ->set_output(json_encode($response, JSON_PRETTY_PRINT))
    ->_display();
    exit;
  }


  public function RegisterPengguna()
  {
    $input = json_decode(file_get_contents('php://input'),true);
    if($this->Mobilelogin_mobile->zcekPengguna($input))
    {
      $this->Mobilelogin_mobile->insertPengguna($DataPelanggan);
      // $Pelanggan=$this->Mobilelogin_mobile->getDataPelanggan($DataPelanggan);

      $response=array(
        'success'=>true,
        'message'=>'registrasi berhasil'
        // 'datapelanggan'=>$Pelanggan
      );
    }
    else {
      $response=array(
        'success'=>false
        // 'message'=>$Pelanggan
      );
    }

    $this->output
    ->set_status_header(200)
    ->set_content_type('application/json', 'utf-8')
    ->set_output(json_encode($response, JSON_PRETTY_PRINT))
    ->_display();
    exit;
  }
  public function GantiPassword()
  {
    $DataPengguna = json_decode(file_get_contents('php://input'),true);

    $this->Mobilelogin_model->updatePengguna($DataPengguna);

    $response=array(
      'message'=>'katasandi berhasil diubah'
    );

    $this->output
      ->set_status_header(200)
      ->set_content_type('application/json', 'utf-8')
      ->set_output(json_encode($response, JSON_PRETTY_PRINT))
      ->_display();
    exit;
  }

}
