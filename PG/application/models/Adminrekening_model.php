<?php

if (!defined('BASEPATH'))
exit('No direct script access allowed');

class Adminrekening_model extends CI_Model
{
	public $table = 'tbl_rekening';
	public $order = 'ASC';
	function __construct()
    {
        parent::__construct();
	}

	function get_option()
    {
		$query = $this->db->get('tbl_rekening');
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
		$this->db->from('tbl_rekening');
		$num_rows = $this->db->count_all_results('');
		return $num_rows;
	}
	
	public function getIdSim()
	{
		$this->db->select_max('id_rekening');
		$this->db->from('tbl_rekening');
		$data=$this->db->get('')->row();
		return $data->id;
	}	
	
	function hapus($id)
	{
		$this->db->where('id_rekening', $id);
		$this->db->delete('tbl_rekening');
	}

	function getData_By_Id($id)
	{
		$this->db->select('*');
		$this->db->from('tbl_rekening');
		$this->db->where('id_rekening',$id);
		$data= $this->db->get('')->row();
		return $data;
	}
	
	function updateData($data = array())
	{
		$this->db->where('id_rekening', $data['id_rekening']);
		$this->db->update('tbl_rekening',$data);
	}
	

	public function get_by_id($id_rekening)
	{
		$this->db->select('id_rekening, nama_bank, nomer_rekening, atas_nama');
		$this->db->from('tbl_rekening');
		$this->db->where('id_rekening',$id_rekening);
		$query = $this->db->get();
		return $query->row();
	}
	
	public function get_by_id_view($id_rekening)
	{
		$this->db->select('id_rekening, nama_bank, nomer_rekening, atas_nama');
		$this->db->from('tbl_rekening');
		$this->db->where('id_rekening',$id_rekening);
		$query = $this->db->get();
		return $query->row();
	}
	
	
		//read data
		public function get_data_all()
		{
			$this->db->select('id_rekening, nama_bank, image_bank, nomer_rekening, atas_nama');
            $this->db->from('tbl_rekening');
    		$query=$this->db->get('');
			return $query->result();
		}

	public function jumlah_data()
	{
		$this->db->select('*');
		$this->db->from('tbl_rekening');
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