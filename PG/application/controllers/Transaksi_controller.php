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
            'message'=>'transaksi berhasil'
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
}