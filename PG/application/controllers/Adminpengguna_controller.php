<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class Adminpengguna_controller extends CI_Controller {
    
    public function __construct()
    {
        parent::__construct();
        $this->load->model('Adminpengguna_model');
        $this->load->library('form_validation');
		$this->load->helper('text');
        $this->load->library('pagination');
    }
    
    public function view_pengguna()
	{
		$jumlah_data = $this->Adminpengguna_model->jumlah_data();
		$config['site_url'] = base_url().' /penggunadana/';
		$config['total_rows'] = $jumlah_data;
		$config['per_page'] = '*';
		$from = $this->uri->segment(3);
		$this->pagination->initialize($config);
        $data['crud_pengguna']=$this->Adminpengguna_model->get_data_all($config['per_page'],$from);
        $this->load->view('admin_pengguna',$data);
	}

	public function data_crud()
	{
		$jumlah_data = $this->Adminpengguna_model->jumlah_data();
		$config['site_url'] = base_url().'Penggunaweb_controller/pengguna/';
		$config['total_rows'] = $jumlah_data;
		$config['per_page'] = '*';
		$from = $this->uri->segment(3);
		$this->pagination->initialize($config);
        $data['crud_pengguna']=$this->Adminpengguna_model->get_data_all($config['per_page'],$from);
        $this->load->view('admin_pengguna',$data);
    }
    
    public function insert_pengguna() 
    {
        $id=2;
		$data = array(
        'id_pengguna' =>$this->input->post('id_pengguna',TRUE),
        'email' => $this->input->post('email',TRUE),
        'password'=>$this->input->post('password',TRUE),
        'nama' => $this->input->post('nama',TRUE),
        'id_role'=>$id);
        $this->Adminpengguna_model->insert($data);
        $this->session->set_flashdata('message', 'Tambah Data Sukses');
        echo json_encode(array("status" => TRUE));
        redirect(site_url('pengguna'));
        //pesan yang muncul jika terdapat error dimasukkan pada session flashdata
        $this->session->set_flashdata("pesan", "<div class=\"col-md-12\"><div class=\"alert alert-danger\" id=\"alert\">Gagal upload gambar !!</div></div>");
        redirect(site_url('pengguna'));
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

	public function UpdateData()
	{
        $data=array(
            'id_pengguna' =>$this->input->post('id_pengguna'),
            'password'=>md5($this->input->post('password')),
        );
            $this->Adminpengguna_model->updateData($data);
            redirect('Penggunaweb_controller/view_pengguna','refresh');
    }

	public function GetId()
	{
		$id=$this->input->get('id_pengguna');
		$this->session->set_flashdata('id_pengguna',$id);
	}

	public function hapusData()
	{
        $id=$this->session->flashdata('id_pengguna');
    	$this->Adminpengguna_model->hapus($id);
	}

	public function ajax_edit($id_pengguna)
	{
        $data = $this->Adminpengguna_model->get_by_id($id_pengguna);
		echo json_encode($data);
	}
	
	public function ajax_view($id_pengguna)
	{
		$data = $this->Adminpengguna_model->get_by_id_view($id_pengguna);
		echo json_encode($data);
	}
	
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
    
    // function _rules()
    // {
    //     $this->form_validation->set_rules('judul', 'judul', 'trim|required');
	//     $this->form_validation->set_rules('gambar', 'gambar', 'trim|required');
    //     $this->form_validation->set_rules('deskripsi', 'deskripsi', 'trim|required');
    //     $this->form_validation->set_rules('link', 'link', 'trim|required');
	//     $this->form_validation->set_rules('id_kategori', 'id_kategori', 'trim|required');
    //     $this->form_validation->set_rules('tahun', 'tahun', 'trim|required');
    // }

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
