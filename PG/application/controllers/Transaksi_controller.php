<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Transaksi_controller extends CI_Controller {

    public function __construct()
    {
        parent::__construct();
        $this->load->model('Transaksi_model');
    }

    public function doTransaksi(){
        $dataDonatur = json_decode(file_get_contents('php://input'),true);
        $this->Transaksi_model->insertDonasi($dataDonatur);

        $response=array(
            'success'=>true,
            'message'=>'transaksi berhasil',
            'getTrans' => $this->Transaksi_model->getTransaksi($dataDonatur)
          );
        
    $this->output
    ->set_status_header(200)
    ->set_content_type('application/json', 'utf-8')
    ->set_output(json_encode($response, JSON_PRETTY_PRINT))
    ->_display();
    exit;
    }
    
    public function getHistory(){       
        $dataDonatur = json_decode(file_get_contents('php://input'),true);
        $data=$this->Transaksi_model->getHistory($dataDonatur);
        $response=array(
          'success'=>true,
          'listbencana'=>$data
        );
    
        $this->output
              ->set_status_header(200)
              ->set_content_type('application/json', 'utf-8')
              ->set_output(json_encode($response, JSON_PRETTY_PRINT))
              ->_display();
          exit;
    
        $this->output
        ->set_status_header(200)
        ->set_content_type('application/json', 'utf-8')
        ->set_output(json_encode($response, JSON_PRETTY_PRINT))
        ->_display();
        exit;
    }

    public function updateTransaksi()
    {


    $DataTransaksi = json_decode(file_get_contents('php://input'),true);
    $encodedImage=$DataTransaksi['encoded_image'];
    unset($DataTransaksi['encoded_image']);
  
    $foto=base64_decode($encodedImage);
    $this->Transaksi_model->UpdateTransaksi($DataTransaksi);

      $response=array(
        'status' => true,
        'message'=> "Sukses"
      );

    // //   $fp = fopen($_SERVER['DOCUMENT_ROOT'].'/PG/images/Bukti/'.$DataTransaksi['bukti_pembayaran'].'', 'wb');
    // //   fwrite($fp, $foto);
    // //   fclose($fp);
      
    //     // file_put_contents(APPPATH .$_SERVER['DOCUMENT_ROOT'].'/PG/images/Bukti/'.$DataTransaksi['bukti_pembayaran'].'', 'w');
    file_put_contents($_SERVER['DOCUMENT_ROOT'].'/PG/images/BUKTI/'.$DataTransaksi['bukti_pembayaran'].'.jpg',$encodedImage);
    // echo $foto;
      $this->output
      ->set_status_header(200)
      ->set_content_type('application/json', 'utf-8')
      ->set_output(json_encode($response, JSON_PRETTY_PRINT))
      ->_display();
      exit;
    }
  
}