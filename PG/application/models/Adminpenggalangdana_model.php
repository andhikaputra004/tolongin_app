<?php

if (!defined('BASEPATH'))
exit('No direct script access allowed');

class Adminpenggalangdana_model extends CI_Model
{
	public $table = 'tbl_penggalangdana';
	public $table2 = 'tbl_pengguna';
	public $order = 'ASC';
	function __construct()
    {
        parent::__construct();
	}

	function get_option()
    {
		$query = $this->db->get('tbl_penggalangdana');
		return $query->result_array();
	}
	
	// insert data
    function insert($data)
    {
        $this->db->insert($this->table, $data);
	}

	//read data
	public function get_data_all()
	{
		$this->db->select('a.id_penggalangdana, a.nama_foto, a.nama_bank, a.nomer_rekening, a.nama_penggalangdana, a.id_pengguna, a.alamat, a.telepon, b.email');
		$this->db->from('tbl_penggalangdana a');
		$this->db->join('tbl_pengguna b','a.id_pengguna=b.id_pengguna');
		$query=$this->db->get('');
		return $query->result();
	}
	
	function getCountDataCrud()
	{
		$this->db->select('*');
		$this->db->from('tbl_penggalangdana');
		$num_rows = $this->db->count_all_results('');
		return $num_rows;
	}
	
	public function getIdSim()
	{
		$this->db->select_max('id_penggalangdana');
		$this->db->from('tbl_penggalangdana');
		$data=$this->db->get('')->row();
		return $data->id;
	}	
	
	function hapus($id)
	{
		$this->db->where('id_penggalangdana', $id);
		$this->db->delete('tbl_penggalangdana');
	}

	function getData_By_Id($id_penggalangdana)
	{
		$this->db->select('*');
		$this->db->from('tbl_penggalangdana');
		$this->db->where('id_penggalangdana',$id_penggalangdana);
		$data= $this->db->get('')->row();
		return $data;
	}
	
	function updateData($data = array())
	{
		$this->db->where('id_penggalangdana', $data['id_penggalangdana']);
		$this->db->update('tbl_penggalangdana',$data);
	}
	

	public function get_by_id($id_penggalangdana)
	{
		$this->db->select('a.id_penggalangdana, a.nama_foto, a.nama_bank, a.nomer_rekening, a.nama_penggalangdana, a.id_pengguna, a.alamat, a.telepon, a.foto_ktp, b.email, a.foto_npwp');
		$this->db->from('tbl_penggalangdana a');
		$this->db->where('a.id_penggalangdana',$id_penggalangdana);
		$this->db->join('tbl_pengguna b','a.id_pengguna=b.id_pengguna');
		$query = $this->db->get();
		return $query->row();
	}
	
	public function get_by_id_view($id_penggalangdana)
	{
		$this->db->select('id_penggalangdana, nama_foto, nama_bank, nomer_rekening, nama_penggalangdana, id_pengguna, alamat, telepon, foto_ktp, email, foto_npwp');
		$this->db->from('tbl_penggalangdana');
		$this->db->where('id_penggalangdana',$id_penggalangdana);
		$query = $this->db->get();
		return $query->row();
	}
	

	function jumlah_data()
	{
		$this->db->select('*');
		$this->db->from('tbl_penggalangdana');
		$num_rows = $this->db->count_all_results('');
		return $num_rows;
	}

	// public function get_tbl_penggalangdana()
	// {
	// 	$this->db->get_where('tbl_penggalangdana',array('id_penggalangdana'))->row();
	// }

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