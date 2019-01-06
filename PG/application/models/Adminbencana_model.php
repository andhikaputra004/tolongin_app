<?php

if (!defined('BASEPATH'))
exit('No direct script access allowed');

class Adminbencana_model extends CI_Model
{
	public $table = 'tbl_bencana';
	public $order = 'DSC';
	function __construct()
    {
        parent::__construct();
	}

	function get_option()
    {
		$query = $this->db->get('tbl_bencana');
		return $query->result_array();
	}
	

	
	// insert data
    function insert($data)
    {
		 
		$this->db->insert($this->table, $data);
		$this->db->set('tanggal_posting', 'DATE(NOW())', FALSE);
	}
	
	function getCountDataCrud()
	{
		$this->db->select('*');
		$this->db->from('tbl_bencana');
		$num_rows = $this->db->count_all_results('');
		return $num_rows;
	}
	
	public function getIdSim()
	{
		$this->db->select_max('id_bencana');
		$this->db->from('tbl_bencana');
		$data=$this->db->get('')->row();
		return $data->id;
	}	
	
	function hapus($id_bencana)
	{
		$this->db->where('id', $id_bencana);
		$this->db->delete('tbl_bencana');
	}

	
	function getData_By_Id($id_bencana)
	{
		$this->db->select('*');
		$this->db->from('tbl_bencana');
		$this->db->where('id_bencana',$id_bencana);
		$data= $this->db->get('')->row();
		return $data;
	}
	
	function updateData($data = array())
	{
		$this->db->where('id_bencana', $data['id_bencana']);
		$this->db->update('tbl_bencana',$data);
	}
	

	public function get_by_id($id_bencana)
	{
		$this->db->select('id_bencana, judul_bencana, deskripsi_bencana, tanggal_posting, tumnel, total_donasi, unik_donasi');
		$this->db->from('tbl_bencana');
		$this->db->where('id_bencana',$id_bencana);
		$query = $this->db->get();
		return $query->row();
	}
	
	public function get_by_id_view($id_bencana)
	{
		$this->db->select('id_bencana, judul_bencana, deskripsi_bencana, tanggal_posting, tumnel, total_donasi, unik_donasi');
		$this->db->from('tbl_bencana');
		$this->db->where('id_bencana',$id_bencana);
		$query = $this->db->get();
		return $query->row();
	}
	
	
		//read data
	public function get_data_all()
	{
		$this->db->select('id_bencana, judul_bencana, deskripsi_bencana, tanggal_posting, tumnel, total_donasi, unik_donasi');
		$this->db->from('tbl_bencana');
		$this->db->order_by('tanggal_posting','DESC');
    	$query=$this->db->get('');
		return $query->result();
	}

	function jumlah_data()
	{
		$this->db->select('*');
		$this->db->from('tbl_bencana');
		$num_rows = $this->db->count_all_results('');
		return $num_rows;
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