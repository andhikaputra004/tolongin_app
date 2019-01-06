<?php

if (!defined('BASEPATH'))
exit('No direct script access allowed');

class verifpenggalangdana_model extends CI_Model
{
	public $table = 'tbl_fotoktp';
	public $table2 = 'tbl_fotonpwp';
	public $order = 'DSC';
	function __construct()
    {
        parent::__construct();
	}

	function get_optionnpwp()
    {
		$query = $this->db->get('tbl_fotonpwp');
		return $query->result_array();
	}

	function get_optionktp()
    {
		$query = $this->db->get('tbl_fotoktp');
		return $query->result_array();
	}

	// insert data
    function insert($data)
    {
		$this->db->insert($this->table, $data);
	}
	
	function save_ktp($ktp){
		$data = array(
	        	'ktp' 	=> $ktp
	       	);  
	    $result= $this->db->insert('tbl_fotoktp',$data);
	    return $result;
	}

	function save_npwp($npwp){
		$data = array(
	        	'npwp' 	=> $npwp
	       	);  
	    $result= $this->db->insert('tbl_fotonpwp',$data);
	    return $result;
	}

	// public function cari($cari)
	// {
	// 	$cek=true;
	// 	$this->db->select('a.id, a.judul, a.deskripsi, a.gambar, a.link, a.id_kategori, a.tahun, a.status, b.kategori');
	// 	$this->db->from('tbl_sim a');
	// 	$this->db->join('tbl_kategori b','a.id_kategori=b.id_kategori');
	// 	$this->db->like("a.judul",$cari);
	// 	$this->db->or_like("a.deskripsi",$cari);
	// 	$this->db->or_like("a.link",$cari);
	// 	$this->db->or_like("b.kategori",$cari);
	// 	$this->db->or_like("a.tahun",$cari);
	// 	$num_rows=$this->db->count_all_results('');
	// 	if($num_rows==0)
	// 	{
	// 		$cek=false;
	// 	}
	// 	return $cek;
	// }
	
	// public function hasilcari($cari)
	// {
	// 	$this->db->select('a.id, a.judul, a.deskripsi, a.gambar, a.link, a.id_kategori, a.tahun, a.status, b.kategori');
	// 	$this->db->from('tbl_sim a');
	// 	$this->db->join('tbl_kategori b','a.id_kategori=b.id_kategori');
	// 	$this->db->like("a.judul",$cari);
	// 	$this->db->or_like("a.deskripsi",$cari);
	// 	$this->db->or_like("a.link",$cari);
	// 	$this->db->or_like("b.kategori",$cari);
	// 	$this->db->or_like("a.tahun",$cari);
	// 	$query = $this->db->get('');
	// 	return $query->result();
	// }
}