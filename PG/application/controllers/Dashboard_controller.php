<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class Dashboard_controller extends CI_Controller {
    
    public function __construct()
    {
        parent::__construct();
        $this->load->model('Admin_model');
        $this->load->library('form_validation');
		$this->load->helper('text');
        $this->load->library('pagination');
    }
    
    public function view_crud()
	{
		$jumlah_data = $this->Admin_model->jumlah_data();
		$config['site_url'] = base_url().' /view_crud/';
		$config['total_rows'] = $jumlah_data;
		$config['per_page'] = '*';
		$from = $this->uri->segment(3);
		$this->pagination->initialize($config);
        //$data['crud_data']=$this->Admin_model->get_data_all($config['per_page'],$from);
        $data['kategori_data']=$this->Admin_model->get_option();
        $this->load->view('dashboard',$data);
	}

	public function data_crud()
	{
		$jumlah_data = $this->CrudModel->jumlah_data();
		$this->load->library('pagination');
		$config['site_url'] = base_url().'Crud_Controller/view_crud/';
		$config['total_rows'] = $jumlah_data;
		$config['per_page'] = 1;
		$from = $this->uri->segment(3);
		$this->pagination->initialize($config);
		$data['crud_data']=$this->CrudModel->get_data_all($config['per_page'],$from);
		$data['kategori_data']=$this->CrudModel->get_option();
        $this->load->view('curd_view',$data);
    }
    
    public function insert_action() 
    {
		$id=0;
        $this->load->library('upload');
        $this->_rules();
        $nmfile = "file_".time(); //nama file saya beri nama langsung dan diikuti fungsi time
        $config['upload_path'] = './images/'; //path folder
        $config['allowed_types'] = 'gif|jpg|png|jpeg|bmp'; //type yang dapat diakses bisa anda sesuaikan
        $config['max_size'] = '2048'; //maksimum besar file 2M
        $config['max_width']  = '2000'; //lebar maksimum 1288 px
        $config['max_height']  = '2000'; //tinggi maksimu 768 px
        $config['file_name'] = $nmfile; //nama yang terupload nantinya
        $this->upload->initialize($config);
        if($_FILES['gambar']['name'])
        {
            if ($this->upload->do_upload('gambar'))
            {
                $gbr = $this->upload->data();
                $data = array(
                    'id' =>$this->input->post('id',TRUE),
                    'judul' => $this->input->post('judul',TRUE),
                    'deskripsi' => $this->input->post('deskripsi',TRUE),
                    'gambar' =>$gbr['file_name'],
					'link' => $this->input->post('link',TRUE),
                    'id_kategori' => $this->input->post('id_kategori',TRUE),
                    'tahun' => $this->input->post('tahun',TRUE),
                );
                $this->CrudModel->insert($data);
                $this->session->set_flashdata('message', 'Tambah Data Sukses');
                echo json_encode(array("status" => TRUE));
                redirect(site_url('curd_view'));
            }else{
                //pesan yang muncul jika terdapat error dimasukkan pada session flashdata
                $this->session->set_flashdata("pesan", "<div class=\"col-md-12\"><div class=\"alert alert-danger\" id=\"alert\">Gagal upload gambar !!</div></div>");
                redirect(site_url('curd_view'));
            }
        }    
    }
    
    
    public function Active($id){
        $data=array(
            'id' =>$id,
            'status' => 1
        );
        $this->CrudModel->updateData($data);
        redirect('Crud_Controller/view_crud','refresh');
        echo json_encode(array("status" => TRUE));
    }

    public function Deactive($id)
    { 
        $data=array(
            'id' =>$id,
            'status' => 0
        );
        $this->CrudModel->updateData($data);
        redirect('Crud_Controller/view_crud','refresh');
        echo json_encode(array("status" => TRUE));
    }

	public function UpdateData()
	{
        $this->load->library('upload');
        $nmfile = "file_".time();
		$config['upload_path'] = './images/';
		$config['allowed_types'] = 'gif|jpg|png|jpeg|bmp'; //type yang dapat diakses bisa anda sesuaikan
		$config['max_size'] = '2048'; //maksimum besar file 2M
		$config['max_width']  = '2000'; //lebar maksimum 1288 px
		$config['max_height']  = '2000'; //tinggi maksimu 768 px
		$config['file_name'] = $nmfile; //nama yang terupload nantinya
		$this->upload->initialize($config);
        if($_FILES['gambar']['name'])
        {
            if ($this->upload->do_upload('gambar'))
            {
                $gbr = $this->upload->data();
				$data=array(
                    'id' =>$this->input->post('id',TRUE),
                    'judul' => $this->input->post('judul',TRUE),
                    'deskripsi' => $this->input->post('deskripsi',TRUE),
					'link' => $this->input->post('link',TRUE),
                    'id_kategori' => $this->input->post('id_kategori',TRUE),
                    'tahun' => $this->input->post('tahun',TRUE),
                    'gambar' =>$gbr['file_name'],
                );
                //$data['kategori_data']=$this->CrudModel->get_option();
                $this->CrudModel->updateData($data);
                redirect('Crud_Controller/view_crud','refresh');
                echo json_encode(array("status" => TRUE));
            }
            else{
                $this->session->set_flashdata('message', 'Gagal upload foto');
                redirect('Crud_Controller/view_crud','refresh');
            }
        }
        else
        {
            $data=array(
                'id' =>$this->input->post('id'),
                'judul' => $this->input->post('judul'),
                'deskripsi' => $this->input->post('deskripsi'),
				'link' => $this->input->post('link'),
				'tahun' => $this->input->post('tahun'),
                'id_kategori' => $this->input->post('id_kategori'),
            );
            $this->CrudModel->updateData($data);
            redirect('Crud_Controller/view_crud','refresh');
        }
    }

	public function GetId()
	{
		$id=$this->input->get('id');
		$this->session->set_flashdata('id',$id);
	}

	public function hapusData()
	{
        $id=$this->session->flashdata('id');
       
		$this->CrudModel->hapus($id);
	}

	public function ajax_edit($id)
	{
        $data = $this->CrudModel->get_by_id($id);
		echo json_encode($data);
	}
	
	public function ajax_view($id)
	{
		$data = $this->CrudModel->get_by_id_view($id);
		echo json_encode($data);
	}
	
	function caridata(){
        $cari=$this->input->post('cari');
        if($this->CrudModel->cari($cari))
        {
            $data['message']="";
			$data['crud_view']=$this->CrudModel->hasilcari($cari); //nama di foreach
			$this->load->view('search_data',$data);//nama di route
		}
        else
        {
            $data['message']="<div class='alert alert-success'>Data tidak ditemukan</div>";
			$data['crud_view']=$this->CrudModel->hasilcari($cari);
			$this->load->view('search_data',$data);
            $this->session->set_flashdata('flash_data','');
        }
    }
    
    function _rules()
    {
        $this->form_validation->set_rules('judul', 'judul', 'trim|required');
	    $this->form_validation->set_rules('gambar', 'gambar', 'trim|required');
        $this->form_validation->set_rules('deskripsi', 'deskripsi', 'trim|required');
        $this->form_validation->set_rules('link', 'link', 'trim|required');
	    $this->form_validation->set_rules('id_kategori', 'id_kategori', 'trim|required');
        $this->form_validation->set_rules('tahun', 'tahun', 'trim|required');
    }

    // function kategori(){
    //     $this->CrudModel->get_kategori();
    //     $this->load->view('view_crud');
    // }

    public function getKategori()
    {
        $data['groups'] = $this->CrudModel-get_option();
        $this->load->view('view_crud',$data);
    }

}
