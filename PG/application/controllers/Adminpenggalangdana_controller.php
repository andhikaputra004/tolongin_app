<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class Adminpenggalangdana_controller extends CI_Controller {
    
    public function __construct()
    {
        parent::__construct();
        $this->load->model('Adminpenggalangdana_model');
        $this->load->library('form_validation');
		$this->load->helper('text');
        $this->load->library('pagination');
    }
    
    public function view_penggalangdana()
	{
		$jumlah_data = $this->Adminpenggalangdana_model->jumlah_data();
		$config['site_url'] = base_url().' /penggalangdana/';
		$config['total_rows'] = $jumlah_data;
		$config['per_page'] = '*';
		$from = $this->uri->segment(3);
		$this->pagination->initialize($config);
        $data['crud_penggalangdana']=$this->Adminpenggalangdana_model->get_data_all($config['per_page'],$from);
        $this->load->view('admin_penggalangdana',$data);
	}

	public function data_crud()
	{
		$jumlah_data = $this->Adminpenggalangdana_model->jumlah_data();
		$config['site_url'] = base_url().'Penggunaweb_controller/pengguna/';
		$config['total_rows'] = $jumlah_data;
		$config['per_page'] = '*';
		$from = $this->uri->segment(3);
		$this->pagination->initialize($config);
        $data['crud_penggalangdana']=$this->Adminpenggalangdana_model->get_data_all($config['per_page'],$from);
        $this->load->view('admin_pengguna',$data);
    }

	public function GetId()
	{
		$id=$this->input->get('id_penggalangdana');
		$this->session->set_flashdata('id_penggalangdana',$id);
	}

	public function hapusData()
	{
        $id=$this->session->flashdata('id_penggalangdana');
    	$this->Adminpenggalangdana_model->hapus($id);
	}

	public function ajax_edit($id_penggalangdana)
	{
        $data = $this->Adminpenggalangdana_model->get_by_id($id_penggalangdana);
		echo json_encode($data);
	}
	
	public function ajax_view($id_penggalangdana)
	{
		$data = $this->Adminpenggalangdana_model->get_by_id_view($id_penggalangdana);
		echo json_encode($data);
    }
    
    public function insert_penggalangdana() 
    {
		$data = array(
        'id_penggalangdana' =>$this->input->post('id_penggalangdana',TRUE),
        'nama_bank' => $this->input->post('nama_bank',TRUE),
        'nomer_rekening'=>$this->input->post('nomer_rekening',TRUE),
        'nama_penggalangdana' => $this->input->post('nama_penggalangdana',TRUE),
        'id_pengguna' => $this->input->post('id_pengguna',TRUE),
        'alamat' => $this->input->post('alamat',TRUE),
        'telepon' => $this->input->post('telepon',TRUE)
        );
        $this->Adminpenggalangdana_model->insert($data);
        $this->session->set_flashdata('message', 'Tambah Data Sukses');
        echo json_encode(array("status" => TRUE));
        redirect(site_url('penggalangdana'));
        //pesan yang muncul jika terdapat error dimasukkan pada session flashdata
        $this->session->set_flashdata("pesan", "<div class=\"col-md-12\"><div class=\"alert alert-danger\" id=\"alert\">Gagal upload gambar !!</div></div>");
        redirect(site_url('penggalangdana'));
    }
    
    public function UpdateData()
    {
        // $data['crud_penggalangdana']=$this->Adminpenggalangdana_model->get_tbl_penggalangdana();
        
       
        $nmfile = "file_".time();
		$config['upload_path'] = './images/KTP/';
		$config['allowed_types'] = 'gif|jpg|png|jpeg|bmp'; //type yang dapat diakses bisa anda sesuaikan
		$config['max_size'] = '2048'; //maksimum besar file 2M
		$config['max_width']  = '2000'; //lebar maksimum 1288 px
		$config['max_height']  = '2000'; //tinggi maksimu 768 px
        $config['file_name'] = $nmfile; //nama yang terupload nantinya
        $this->upload->do_upload('foto_ktp');
        $this->load->library('upload', $config);
        
        $nmfile1 = "file_".time();
        $config1['upload_path'] = './images/NPWP/';
		$config1['allowed_types'] = 'gif|jpg|png|jpeg|bmp'; //type yang dapat diakses bisa anda sesuaikan
		$config1['max_size'] = '2048'; //maksimum besar file 2M
		$config1['max_width']  = '2000'; //lebar maksimum 1288 px
		$config1['max_height']  = '2000'; //tinggi maksimu 768 px
        $config1['file_name'] = $nmfile1; //nama yang terupload nantinya
        $this->upload->do_upload('foto_npwp');
        $this->load->library('upload',$config1);
        
        $nmfile2 = "file_".time();
        $config2['upload_path'] = './images/';
		$config2['allowed_types'] = 'gif|jpg|png|jpeg|bmp'; //type yang dapat diakses bisa anda sesuaikan
		$config2['max_size'] = '2048'; //maksimum besar file 2M
		$config2['max_width']  = '2000'; //lebar maksimum 1288 px
		$config2['max_height']  = '2000'; //tinggi maksimu 768 px
        $config2['file_name'] = $nmfile2; //nama yang terupload nantinya
        $this->upload->do_upload('nama_foto');
        $this->load->library('upload',$config2);
        
        if($_FILES['foto_ktp']||['nama_foto']||['foto_npwp'])
        {
            if( ! $this->upload->do_upload())
                {
                    $fotoktp = $this->upload->data();
                    $fotonpwp = $this->upload->data();
                    $namafoto = $this->upload->data();
                    $data = array(
                        'id_penggalangdana' => $this->input->post('id_penggalangdana'),
                        'nama_foto' => $namafoto['file_name'],
                        'nama_bank' => $this->input->post('nama_bank'),
                        'nomer_rekening' => $this->input->post('nomer_rekening'),
                        'nama_penggalangdana' => $this->input->post('nama_penggalangdana'),
                        'id_pengguna' => $this->input->post('id_pengguna'),
                        'alamat' => $this->input->post('alamat'),
                        'telepon' => $this->input->post('telepon'),
                        'nama_penggalangdana' => $this->input->post('nama_penggalangdana'),
                        'foto_ktp' => $fotoktp['file_name'],
                        'foto_npwp' => $fotonpwp['file_name'],
                    );
                    $this->Adminpenggalangdana_model->updateData($data);
                    redirect('Adminpenggalangdana_controller/view_penggalangdana','refresh');
                }
                else{
                    $this->session->set_flashdata('message', 'Gagal upload foto');
                    redirect('Adminpenggalangdana_controller/view_penggalangdana','refresh');
                }
            // }
                    // echo json_encode(array("status" => TRUE));
            }
            else
            {
                $data=array(
                    'id_penggalangdana' => $this->input->post('id_penggalangdana'),
                    'nama_bank' => $this->input->post('nama_bank'),
                    'nomer_rekening' => $this->input->post('nomer_rekening'),
                    'nama_penggalangdana' => $this->input->post('nama_penggalangdana'),
                    'id_pengguna' => $this->input->post('id_pengguna'),
                    'alamat' => $this->input->post('alamat'),
                    'telepon' => $this->input->post('telepon'),
                    'nama_penggalangdana' => $this->input->post('nama_penggalangdana'),
                );
                $this->Adminpenggalangdana_model->updateData($data);
                redirect('Adminpenggalangdana_controller/view_penggalangdana','refresh');
            }
        
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

	// public function UpdateData()
	// {
    //     $data=array(
    //         'id_pengguna' =>$this->input->post('id_pengguna'),
    //         'password'=>md5($this->input->post('password')),
    //     );
    //         $this->Adminpenggalangdana_model->updateData($data);
    //         redirect('Penggunaweb_controller/view_pengguna','refresh');
    // }

}