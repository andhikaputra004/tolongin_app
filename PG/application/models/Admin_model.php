<?php

if (!defined('BASEPATH'))
exit('No direct script access allowed');

class Admin_model extends CI_Model
{
	public $table = 'tbl_pengguna';
    public $table2 = 'tbl_penyelenggara';
    public $table3 = 'tbl_bencana';
	public $table4 = 'tbl_donasi';
	public $order = 'ASC';
	function __construct()
    {
        parent::__construct();
	}

	function get_option()
    {
		$query = $this->db->get('tbl_pengguna');
		return $query->result_array();
    }
	
	// insert data
    function insert($data)
    {
        $this->db->insert($this->table, $data);
	}
	
	function getCountDataCrud()
	{
		$this->db->select('*');
		$this->db->from('tbl_pengguna');
		$num_rows = $this->db->count_all_results('');
		return $num_rows;
	}
	
	public function getIdSim()
	{
		$this->db->select_max('id_pengguna');
		$this->db->from('tbl_pengguna');
		$data=$this->db->get('')->row();
		return $data->id;
	}	
	
	function hapus($id)
	{
		$this->db->where('id', $id);
		$this->db->delete('tbl_pengguna');
	}

	
	
	function getData_By_Id($id)
	{
		$this->db->select('*');
		$this->db->from('tbl_pengguna');
		$this->db->where('id_pengguna',$id);
		$data= $this->db->get('')->row();
		return $data;
	}
	
	function updateData($data = array())
	{
		$this->db->where('id', $data['id']);
		$this->db->update('tbl_sim',$data);
	}
	

	// public function get_by_id($id)
	// {
	// 	$this->db->select('a.id, a.judul, a.deskripsi, a.gambar, a.link, a.id_kategori, a.tahun, b.kategori');
	// 	$this->db->from('tbl_sim a');
	// 	$this->db->join('tbl_kategori b','a.id_kategori=b.id_kategori');
	// 	$this->db->where('a.id',$id);
	// 	$query = $this->db->get();
	// 	return $query->row();
	// }
	
	// public function get_by_id_view($id)
	// {
	// 	$this->db->select('a.id, a.judul, a.deskripsi, a.gambar, a.link, a.id_kategori, a.tahun, b.kategori');
	// 	$this->db->from('tbl_sim a');
	// 	$this->db->join('tbl_kategori b','a.id_kategori=b.id_kategori');
	// 	$this->db->where('a.id',$id);
	// 	$query = $this->db->get();
	// 	return $query->row();
	// }
	
	
	// 	//read data
	// 	function get_data_all($number,$offset)
	// 	{
	// 		$this->db->select('a.id, a.judul, a.deskripsi, a.gambar, a.link, a.id_kategori, a.tahun, a.status, b.kategori');
	// 		$this->db->from('tbl_sim a');
	// 		$this->db->join('tbl_kategori b','a.id_kategori=b.id_kategori');
	// 		$query = $this->db->get('',$number,$offset);
	// 		return $query->result();
	// 	}

	function jumlah_data()
	{
		$this->db->select('*');
		$this->db->from('tbl_pengguna');
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