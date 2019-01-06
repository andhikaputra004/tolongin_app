<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class BencanaMobile_Controller extends CI_Controller {

  public function __construct()
  {
    parent::__construct();
      $this->load->model('MobileBencana_model');
  }

  public function GetListBencana()
  {
    $data=$this->MobileBencana_model->getDataBencana();
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

  public function GetBencanaId()
  {
    $idBencana=json_decode(file_get_contents('php://input'),true);
    $data=$this->MobileBencana_model->getDataBencanabyId($idBencana);
    $response=array(
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