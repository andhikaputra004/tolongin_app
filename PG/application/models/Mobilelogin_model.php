<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class Mobilelogin_model extends CI_Model {

  public $table = 'tbl_pengguna';
  public $table2 = 'tbl_donatur';
  public $order = 'ASC';
    
    function __construct()
    {
        parent::__construct();
  }
  
  public function getDataPengguna($datalogin)
  {
    $this->db->select('*');
    $this->db->from('tbl_pengguna');
    $this->db->where('email',$datalogin['email']);
    $this->db->where('password',$datalogin['password']);
    $data = $this->db->get('')->row_array();
    $num_rows = $this->db->count_all_results('');
    if($num_rows==0)
    {
        return NULL;
    }
    else
      return $data;
  }

  public function getDataDonatur($logindonatur)
  {
    $this->db->select('*');
    $this->db->from('tbl_donatur');
    $this->db->where('nama_donatur',$logindonatur['nama_donatur']);
    // $this->db->where('password',$logindonatur['password']);
    $data = $this->db->get('')->row_array();
    $num_rows = $this->db->count_all_results('');
    if($num_rows==0)
    {
        return NULL;
    }
    else
      return $data;
  }

  public function cekEmail($email)
  {
    $this->db->select('*');
    $this->db->from('tbl_pengguna');
    $this->db->where('email',$email['email']);
    $num_rows=$this->db->count_all_results('');
    if($num_rows==0)
    {
      return true;
    }
    else {
      return false;
    }
  }

  public function cekPengguna($input)
  {
    $this->db->select('*');
    $this->db->from('tbl_pengguna');
    $this->db->where('nama',$input['nama']);
    // $data = $this->db->get('')->row_array();
    $num_rows=$this->db->count_all_results('');
    if($num_rows==0)
    {
      return true;
    }
    else {
      return false;
    }
  }

  public function cekDonatur($nama)
  {
    $this->db->select('*');
    $this->db->from('tbl_donatur');
    $this->db->where('nama_donatur',$nama);
    $num_rows=$this->db->count_all_results('');
    if($num_rows==0)
    {
      return true;
    }
    else {
      return false;
    }
  }

  function insertDonatur($dataDonatur)
  {
      // $this->db->set('status','1');
      // $this->db->set('id_role','3');
      $this->db->insert('tbl_donatur', $dataDonatur);
  }

  public function updatePengguna($DataPengguna)
  {
    $this->db->where('id_pengguna',$DataPengguna['id_pengguna']);
    $this->db->update('tbl_pengguna',$DataPengguna);
  }


  
  public function insertPengguna($input)
  {      
    $this->db->set('status','1');
    $this->db->set('id_role','3');
    $this->db->insert('tbl_pengguna',$input);
  }

  // public function getIdDonatur()
  // {
  //   $this->db->select_max('id_donatur');
  //   $this->db->from('tbl_donatur');
  //   $data=$this->db->get('')->row();
  //   return $data->id_donatur;
  // }

  // public function insertPengguna($DataPengguna)
  // {
  //   $this->db->insert('tbl_donatur',$DataPengguna);
  // }

  // public function insertPengguna($DataPengguna)
  // {
  //   $this->db->insert('tbl_pengguna',$DataPengguna);
  // }

  // public function updatePengguna($DataPengguna)
  // {
  //   $this->db->where('id_pengguna',$DataPengguna['id_pengguna']);
  //   $this->db->update('tbl_pengguna',$DataPengguna);
  // }

  // public function getCountPengguna()
  // {
  //   $this->db->select('*');
  //   $this->db->from('tbl_pengguna');
  //   $this->db->where('status','1');
  //   $countPengguna=$this->db->count_all_results('');
  //   return $countPengguna;
  // }

  // public function getListPengguna($number,$offset)
  // {
  //   $this->db->select('*');
  //   $this->db->from('tbl_pelanggan');
  //   $this->db->where('status','1');
  //   $this->db->limit($number,$offset);
  //   $query=$this->db->get('');
  //   return $query->result();
  // }

  // public function getCountSearchPelanggan($keyword)
  // {
  //   $this->db->select('*');
  //   $this->db->from('tbl_pelanggan');
  //   $this->db->where('status','1');
  //   $this->db->like('nama_lengkap',$keyword);
  //   $countKatering=$this->db->count_all_results('');
  //   return $countKatering;
  // }

  // public function getListSearchPelanggan($keyword,$number,$offset)
  // {
  //   $this->db->select('*');
  //   $this->db->from('tbl_pelanggan');
  //   $this->db->where('status','1');
  //   $this->db->like('nama_lengkap',$keyword);
  //   $this->db->limit($number,$offset);
  //   $query=$this->db->get('');
  //   return $query->result();
  // }

  // public function getPelangganById($id_pelangan){
  //   $this->db->select('*');
  //   $this->db->from('tbl_pelanggan');
  //   $this->db->where('id_pelanggan',$id_pelangan);
  //   $pelanggan=$this->db->get('')->row_array();
  //   return $pelanggan;
  // }
}