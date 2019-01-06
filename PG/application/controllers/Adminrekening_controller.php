<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class Adminrekening_controller extends CI_Controller {
    
    public function __construct()
    {
        parent::__construct();
        $this->load->model('Adminrekening_model');
        $this->load->library('form_validation');
		$this->load->helper('text');
        $this->load->library('pagination');
    }
    
    public function view_rekening()
	{
		$jumlah_data = $this->Adminrekening_model->jumlah_data();
		$config['site_url'] = base_url().' /rekening/';
		$config['total_rows'] = $jumlah_data;
		$config['per_page'] = '*';
		$from = $this->uri->segment(3);
		$this->pagination->initialize($config);
        $data['crud_rekening']=$this->Adminrekening_model->get_data_all($config['per_page'],$from);
        //$data['kategori_data']=$this->Admin_model->get_option();
        $this->load->view('admin_rekening',$data);
	}

	public function data_crud()
	{
		$jumlah_data = $this->Adminrekening_model->jumlah_data();
		$config['site_url'] = base_url().'Rekeningweb_controller/rekening/';
		$config['total_rows'] = $jumlah_data;
		$config['per_page'] = '*';
		$from = $this->uri->segment(3);
		$this->pagination->initialize($config);
        $data['crud_rekening']=$this->Adminrekening_model->get_data_all($config['per_page'],$from);
        //$data['kategori_data']=$this->Admin_model->get_option();
        $this->load->view('admin_rekening',$data);
    }
    
    public function insert_rekening()
    {
        $data = array(
            'id_rekening' =>$this->input->post('id_rekening',TRUE),
            'nama_bank' => $this->input->post('nama_bank',TRUE),
            'nomer_rekening' => $this->input->post('nomer_rekening',TRUE),
            'atas_nama' => $this->input->post('atas_nama',TRUE));
            $this->Adminrekening_model->insert($data);
            $this->session->set_flashdata('message', 'Tambah Data Sukses');
            echo json_encode(array("status" => TRUE));
            redirect(site_url('rekening'));
            //pesan yang muncul jika terdapat error dimasukkan pada session flashdata
            $this->session->set_flashdata("pesan", "<div class=\"col-md-12\"><div class=\"alert alert-danger\" id=\"alert\">Gagal upload gambar !!</div></div>");
            redirect(site_url('rekening'));
    }

	public function UpdateData()
	{
        $data=array(
            'id_rekening' =>$this->input->post('id_rekening'),
            'nama_bank' => $this->input->post('nama_bank'),
            'nomer_rekening' => $this->input->post('nomer_rekening'),
            'atas_nama' => $this->input->post('atas_nama'),
        );
            $this->Adminrekening_model->updateData($data);
            redirect('Rekeningweb_controller/view_rekening','refresh');
    }

	public function GetId()
	{
		$id=$this->input->get('id_rekening');
		$this->session->set_flashdata('id_rekening',$id);
	}

	public function hapusData()
	{
        $id=$this->session->flashdata('id_rekening');
       
		$this->Adminrekening_model->hapus($id);
	}

	public function ajax_edit($id_rekening)
	{
        $data = $this->Adminrekening_model->get_by_id($id_rekening);
		echo json_encode($data);
	}
	
	public function ajax_view($id_rekening)
	{
		$data = $this->Adminrekening_model->get_by_id_view($id_rekening);
		echo json_encode($data);
	}
    
    // public function Active($id){
    //     $data=array(
    //         'id' =>$id,
    //         'status' => 1
    //     );
    //     $this->CrudModel->updateData($data);
    //     redirect('Crud_Controller/view_crud','refresh');
    //     echo json_encode(array("status" => TRUE));
    // }

    // public function Deactive($id)
    // { 
    //     $data=array(
    //         'id' =>$id,
    //         'status' => 0
    //     );
    //     $this->CrudModel->updateData($data);
    //     redirect('Crud_Controller/view_crud','refresh');
    //     echo json_encode(array("status" => TRUE));
    // }
	// function caridata(){
    //     $cari=$this->input->post('cari');
    //     if($this->CrudModel->cari($cari))
    //     {
    //         $data['message']="";
	// 		$data['crud_view']=$this->CrudModel->hasilcari($cari); //nama di foreach
	// 		$this->load->view('search_data',$data);//nama di route
	// 	}
    //     else
    //     {
    //         $data['message']="<div class='alert alert-success'>Data tidak ditemukan</div>";
	// 		$data['crud_view']=$this->CrudModel->hasilcari($cari);
	// 		$this->load->view('search_data',$data);
    //         $this->session->set_flashdata('flash_data','');
    //     }
    // }
    
    function _rules()
    {
        $this->form_validation->set_rules('id_rekening', 'id_rekening', 'trim|required');
	    $this->form_validation->set_rules('nama_bank', 'nama_bank', 'trim|required');
        $this->form_validation->set_rules('nomer_rekening', 'nomer_rekening', 'trim|required');
        $this->form_validation->set_rules('atas_nama', 'atas_nama', 'trim|required');
    }

    // // function kategori(){
    // //     $this->CrudModel->get_kategori();
    // //     $this->load->view('view_crud');
    // // }

    // public function getKategori()
    // {
    //     $data['groups'] = $this->CrudModel-get_option();
    //     $this->load->view('view_crud',$data);
    // }

    }
