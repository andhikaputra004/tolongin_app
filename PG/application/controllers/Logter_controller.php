<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class Logter_controller extends CI_Controller {

    public function __construct()
    {
        parent::__construct();
        $this->load->model('Logter_Model');
        $this->load->library('form_validation');
		$this->load->helper('text');
        $this->load->library('pagination');
    }

    public function index()
	{
        $data['register']=$this->Logter_Model->get_view();
        $this->load->view('register',$data);
	}

	public function insert_pengguna() 
    {
        $id=2;
        $data=array(
            'nama'=>$this->input->post('nama',TRUE),
            'email'=>$this->input->post('email',TRUE),
            'password'=>$this->input->post('password',TRUE),
            'id_role'=>$id);
            $this->Logter_Model->insert($data);
            $this->session->set_flashdata('message', 'Tambah User Berhasil');
            redirect(site_url(''));
        }

     public function aksi_login()
     {
         $email = $this->input->post('email');
         $password = $this->input->post('password');
         $where = array(
                'email' => $email,
                'password' => $password,
                );
            $cek = $this->Logter_Model->cek_login("tbl_pengguna",$where)->num_rows();
            // echo md5($password);
            if($cek > 0){
     
                $data_session = array(
                    'nama' => $email,
                    'status' => "login",
                    // 'id_pengguna'=>$data->id_pengguna
                    );
     
                $this->session->set_userdata($data_session);
     
                redirect(site_url("dashboard"));
     
            }else{
                $this->session->set_flashdata('message', 'Inputan Email Dan kata sandi tidak cocok !');
                redirect(site_url(''));
            }
        }
     
        function logout(){
            $this->session->sess_destroy();
            redirect(site_url(''));
        }
    }