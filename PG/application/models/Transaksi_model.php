<?php

if (!defined('BASEPATH'))
exit('No direct script access allowed');

class Transaksi_model extends CI_Model
{
	function insertDonasi($data)
    {
        $this->db->insert('tbl_transaksi', $data);
    }
    
    function getHistory($dataTransaksi){
        
        $DataBencana =[];
        $this->db->select('a.id_transaksi,a.id_pengguna,a.id_bencana,a.nominal,b.judul_bencana,b.deskripsi_bencana');
        $this->db->from('tbl_transaksi a');
        $this->db->join('tbl_bencana b','a.id_bencana = b.id_bencana');
        $this->db->where('id_pengguna',$dataTransaksi['id_pengguna']);
        $DataBencana = $this->db->get('')->result_array();
        return $DataBencana;    
    }

    public function cekTransaksi($dataTransaksi)
  {
    $this->db->select('a.id_bencana,a.id_transaksi,a.id_pengguna,a.nominal,b.judul_bencana,b.deskripsi_bencana');
    $this->db->from('tbl_transaksi a');
    $this->db->join('tbl_bencana b','a.id_bencana=b.id_bencana');
    $this->db->where('id_pengguna',$dataTransaksi['id_pengguna']);     
    $num_rows=$this->db->count_all_results('');
    if($num_rows==0)
    {
      return true;
    }
    else {
      return false;
    }
  }


}