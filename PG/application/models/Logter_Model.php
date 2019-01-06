<?php if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class Logter_model extends CI_Model 
{

    public $table = 'tbl_pengguna';
    public $order = 'ASC';
    
    function __construct()
    {
        parent::__construct();
	}

    function insert($data)
    {
        $this->db->insert($this->table, $data);
        
    }

    function get_view()
    {
		$query = $this->db->get('tbl_pengguna');
		return $query->result_array();
    }


    function cek_login($table,$where)
    {		
		return $this->db->get_where($table,$where);
	}

}