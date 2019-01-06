<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class verifpenggalangdana_controller extends CI_Controller {
    
    public function __construct()
    {
        parent::__construct();
        $this->load->model('verifpenggalangdana_model');
        $this->load->library('form_validation');
		$this->load->helper('text');
        $this->load->library('pagination');
    }
    

	public function GetId()
	{
		$id=$this->input->get('id_penggalangdana');
		$this->session->set_flashdata('id_penggalangdana',$id);
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
    
    function do_upload(){
        $config['upload_path']="./assets/images";
        $config['allowed_types']='gif|jpg|png';
        $config['encrypt_name'] = TRUE;
        
        $this->load->library('upload',$config);
	    if($this->upload->do_upload("file")){
	        $data = $this->upload->data();

	        //Resize and Compress Image
            $config['image_library']='gd2';
            $config['source_image']='./assets/images/'.$data['file_name'];
            $config['create_thumb']= FALSE;
            $config['maintain_ratio']= FALSE;
            $config['quality']= '60%';
            $config['width']= 600;
            $config['height']= 400;
            $config['new_image']= './assets/images/'.$data['file_name'];
            $this->load->library('image_lib', $config);
            $this->image_lib->resize();

	        $title= $this->input->post('title');
	        $image= $data['file_name']; 
	        
	        $result= $this->upload_model->save_upload($title,$image);
	        echo json_decode($result);
        }

     }
}