<?php

if (!defined('BASEPATH'))
exit('No direct script access allowed');

class MobileBencana_model extends CI_Model
{
	public $table = 'tbl_bencana';
	public $order = 'DSC';
	function __construct()
    {
        parent::__construct();
	}

	public function getDataBencana()
  {
    // $DataBencana=[];
    // $this->db->select('*');
    // $this->db->from('tbl_bencana');
    // $DataBencana=$this->db->get('')->result_array();
    // return $DataBencana;

    $DataBencana =[];
    $this->db->select('a.id_bencana ,a.judul_bencana,a.deskripsi_bencana,a.tumnel,c.nomer_rekening,c.nama_penggalangdana,ifnull(SUM(b.nominal)+b.kode_unik,b.kode_unik) as total_donasi');
    $this->db->from('tbl_bencana a');
    $this->db->join('tbl_transaksi b','a.id_bencana = b.id_bencana','left');
    $this->db->join('tbl_penggalangdana c','a.id_penggalangdana = c.id_penggalangdana');
    $this->db->group_by('id_bencana');
    $DataBencana = $this->db->get('')->result_array();
    return $DataBencana;
  }

  public function getHistoryById(){
    $DataBencana=[];
    $this->db->select('*');
    $this->db->from('tbl_bencana');
    
  }

  public function getDataBencanabyId($idBencana)
  {
    $this->db->select('*');
    $this->db->from('tbl_bencana');
    $this->db->where('id_bencana',$idBencana['id_bencana']);
    $DataBencana=$this->db->get('')->row_array();
    $num_rows=$this->db->count_all_results('');
    if($num_rows==0)
    {
      return NULL;
    }
    else
    return $DataBencana;
  }
}