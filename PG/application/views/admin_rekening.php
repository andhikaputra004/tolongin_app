<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Bootstrap Admin Theme</title>

    <!-- Bootstrap Core CSS -->
    <link href="<?php echo base_url(); ?>aset/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="<?php echo base_url(); ?>aset/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- DataTables CSS -->
    <link href="<?php echo base_url(); ?>aset/vendor/datatables-plugins/dataTables.bootstrap.css" rel="stylesheet">

    <!-- DataTables Responsive CSS -->
    <link href="<?php echo base_url(); ?>aset/vendor/datatables-responsive/dataTables.responsive.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<?php echo base_url(); ?>aset/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="<?php echo base_url(); ?>aset/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
               
                <a class="navbar-brand" href="index.html">SB Admin v2.0</a>
            </div>
            <!-- /.navbar-header -->
            
            <ul class="nav navbar-top-links navbar-right">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-envelope fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-messages">
                        <li>
                            <a href="#">
                                <div>
                                    <strong>John Smith</strong>
                                    <span class="pull-right text-muted">
                                        <em>Yesterday</em>
                                    </span>
                                </div>
                                <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <strong>John Smith</strong>
                                    <span class="pull-right text-muted">
                                        <em>Yesterday</em>
                                    </span>
                                </div>
                                <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <strong>John Smith</strong>
                                    <span class="pull-right text-muted">
                                        <em>Yesterday</em>
                                    </span>
                                </div>
                                <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a class="text-center" href="#">
                                <strong>Read All Messages</strong>
                                <i class="fa fa-angle-right"></i>
                            </a>
                        </li>
                    </ul>
                    <!-- /.dropdown-messages -->
                </li>
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-tasks fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-tasks">
                        <li>
                            <a href="#">
                                <div>
                                    <p>
                                        <strong>Task 1</strong>
                                        <span class="pull-right text-muted">40% Complete</span>
                                    </p>
                                    <div class="progress progress-striped active">
                                        <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">
                                            <span class="sr-only">40% Complete (success)</span>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <p>
                                        <strong>Task 2</strong>
                                        <span class="pull-right text-muted">20% Complete</span>
                                    </p>
                                    <div class="progress progress-striped active">
                                        <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" style="width: 20%">
                                            <span class="sr-only">20% Complete</span>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <p>
                                        <strong>Task 3</strong>
                                        <span class="pull-right text-muted">60% Complete</span>
                                    </p>
                                    <div class="progress progress-striped active">
                                        <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%">
                                            <span class="sr-only">60% Complete (warning)</span>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <p>
                                        <strong>Task 4</strong>
                                        <span class="pull-right text-muted">80% Complete</span>
                                    </p>
                                    <div class="progress progress-striped active">
                                        <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%">
                                            <span class="sr-only">80% Complete (danger)</span>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a class="text-center" href="#">
                                <strong>See All Tasks</strong>
                                <i class="fa fa-angle-right"></i>
                            </a>
                        </li>
                    </ul>
                    <!-- /.dropdown-tasks -->
                </li>
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-bell fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-alerts">
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-comment fa-fw"></i> New Comment
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-twitter fa-fw"></i> 3 New Followers
                                    <span class="pull-right text-muted small">12 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-envelope fa-fw"></i> Message Sent
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-tasks fa-fw"></i> New Task
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-upload fa-fw"></i> Server Rebooted
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a class="text-center" href="#">
                                <strong>See All Alerts</strong>
                                <i class="fa fa-angle-right"></i>
                            </a>
                        </li>
                    </ul>
                    <!-- /.dropdown-alerts -->
                </li>
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
                        </li>
                        <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="<?php echo site_url('logoutaction'); ?>"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li class="sidebar-search">
                            <div class="input-group custom-search-form">
                                <input type="text" class="form-control" placeholder="Search...">
                                <span class="input-group-btn">
                                <button class="btn btn-default" type="button">
                                    <i class="fa fa-search"></i>
                                </button>
                            </span>
                            </div>
                            <!-- /input-group -->
                        </li>
                        <li>
                            <a href="<?php echo base_url('index.php/dashboard');?>"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>
                        </li>
                        <li>
                            <a href="<?php echo base_url('index.php/bencana');?>"><i class="fa fa-table fa-fw"></i> Bencana Alam</a>
                        </li>
                        <li>
                            <a href="<?php echo base_url('index.php/pengguna');?>"><i class="fa fa-table fa-fw"></i> Pengguna</a>
                        </li>
                        <li>
                            <a href="<?php echo base_url('index.php/rekening');?>"><i class="fa fa-table fa-fw"></i> Daftar Rekening</a>
                        </li>
                        <li>
                            <a href="<?php echo base_url('index.php/penggalangdana');?>"><i class="fa fa-table fa-fw"></i> Daftar Penggalang Dana</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-wrench fa-fw"></i> UI Elements<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="panels-wells.html">Panels and Wells</a>
                                </li>
                                <li>
                                    <a href="buttons.html">Buttons</a>
                                </li>
                                <li>
                                    <a href="notifications.html">Notifications</a>
                                </li>
                                <li>
                                    <a href="typography.html">Typography</a>
                                </li>
                                <li>
                                    <a href="icons.html"> Icons</a>
                                </li>
                                <li>
                                    <a href="grid.html">Grid</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-sitemap fa-fw"></i> Multi-Level Dropdown<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="#">Second Level Item</a>
                                </li>
                                <li>
                                    <a href="#">Second Level Item</a>
                                </li>
                                <li>
                                    <a href="#">Third Level <span class="fa arrow"></span></a>
                                    <ul class="nav nav-third-level">
                                        <li>
                                            <a href="#">Third Level Item</a>
                                        </li>
                                        <li>
                                            <a href="#">Third Level Item</a>
                                        </li>
                                        <li>
                                            <a href="#">Third Level Item</a>
                                        </li>
                                        <li>
                                            <a href="#">Third Level Item</a>
                                        </li>
                                    </ul>
                                    <!-- /.nav-third-level -->
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-files-o fa-fw"></i> Sample Pages<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="blank.html">Blank Page</a>
                                </li>
                                <li>
                                    <a href="login.html">Login Page</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Tabel Rekening</h1>
                </div>
                
                <!-- /.col-lg-12 -->
            </div>
                        
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <button class="btn btn-primary btn-round" data-toggle="modal" data-target="#myModalTambah" onclick="clearData()"> Tambah Rekening</button>
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover">
                                    <thead>
                                        <tr>
                                            <th>ID Rekening</th>
                                            <th>Nama Bank</th>
                                            <th>Nomer Rekening</th>
                                            <th>Nama</th>
                                            <th> </th>
                                        </tr>
                                    </thead>
                                    <?php $start = 0; foreach ($crud_rekening as $get_data)
                                            {
                                               ?>
                                    
                                        <tr>
                                        <td><?php echo $get_data->id_rekening ?></td>
                                        <td><?php echo $get_data->nama_bank ?></td>
									    <td><?php echo $get_data->nomer_rekening ?></td>
                                        <td><?php echo $get_data->atas_nama ?></td>
                                        <td class="td-actions text-right">
                                                    <button type="button" rel="tooltip" title="Read More" class="btn btn-info btn-simple btn-xs" data-toggle="modal" data-target="#myModalDetail" onclick="ViewData(<?php echo $get_data->id_rekening ?>)">
                                                        <i class="material-icons">View</i>
                                                    </button>
													<button type="button" rel="tooltip" title="Edit Task" class="btn btn-primary btn-simple btn-xs" data-toggle="modal" data-target="#myModalEdit" onclick="EditData(<?php echo $get_data->id_rekening ?>)">
														<i class="material-icons">edit</i>
													</button>
													<button type="button" rel="tooltip" title="Remove" class="btn btn-danger btn-simple btn-xs" data-toggle="modal" data-target="#myModalHapus" onclick="SaveId(<?php echo $get_data->id_rekening ?>)">
														<i class="material-icons">Delete</i>
													</button>
												    </td>
                                        </tr>
                                        <?php
                                            }
                                                ?>
                                        </table>
                                
                            </div>
                            <!-- /.table-responsive -->
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>

        <!-- Start Modal Edit Data -->
        <div class="modal fade" id="myModalEdit" tabindex="2" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <form class="form" action="<?php echo site_url('updaterekening'); ?>" method="post" enctype="multipart/form-data">
        <div class="modal-dialog">
            <div class="modal-content">
				<div class="modal-header">
                    <h4 class="modal-title">Edit Data</h4>
                    <input type="hidden" name="id_rekening" />
				</div>
				<div class="modal-body">
					<div class="form-group">
                        <label class="control-label">Nama Bank</label>
						<textarea name="nama_bank" class="form-control" rows="5" required></textarea>
                    </div>
                    <div class="form-group">
                        <label class="control-label">Nomer Rekening</label>
						<textarea name="nomer_rekening" class="form-control" rows="1" required></textarea>
                    </div>
                    <div class="form-group">
						<label class="control-label">Atas Nama</label>
                        <textarea name="atas_nama" class="form-control" rows="1" required></textarea>
					</div>
                    <div class="modal-footer">
                        <button type="submit" class="btn btn-primary btn-round">Simpan Data</button>
                        <button type="button" class="btn btn-primary btn-round" data-dismiss="modal">Batal</button>
                    </div>
                </div>
            </div>
        </form>
        </div>
        </div>

        <!-- Sart Modal read Data -->
	    <div class="modal fade" id="myModalDetail" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					<i class="material-icons">clear</i>
				</button>
					<h4 class="modal-title">Detail Data</h4>
				</div>
				<div class="modal-body">
                <div class="form-group">
                        <label class="control-label-absolute">ID Rekening</label>
                        <input type="text" name="id_rekening" class="form-control" disabled>
					</div>
					<div class="form-group">
                        <label class="control-label">Nama Bank</label>
						<textarea name="nama_bank" class="form-control" rows="5" disabled></textarea>
                    </div>
                    <div class="form-group">
                        <label class="control-label">Nomer Rekening</label>
						<textarea name="nomer_rekening" class="form-control" rows="1" disabled></textarea>
                    </div>
                    <div class="form-group">
						<label class="control-label">Atas Nama</label>
                        <textarea name="atas_nama" class="form-control" rows="1" disabled></textarea>
					</div>
				</div>
			</div>
		</div>
	    </div>
                
        <!-- Start Modal Tamhah Data -->
        <form action="<?php echo site_url('insert_rekening');?>" method="post" enctype="multipart/form-data">
	    <div class="modal fade" id="myModalTambah" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">Tambah Rekening</h4>
				</div>
				<div class="modal-body">
					<div class="form-group label-floating">
						<label class="control-label">Nama Bank</label>
						<input type="text" id="nama_bank" name="nama_bank" class="form-control" >
					</div>
					<div class="form-group label-floating">
						<label class="control-label">Nomer Rekening</label>
						<input id="nomer_rekening" type ="number" onKeyPress="if(this.value.length==16) return false;" min="0" name="nomer_rekening" class="form-control" required>
					</div>
					<div class="form-group label-floating">
						<label class="control-label">Atas Nama</label>
						<input type="text" id="atas_nama" name="atas_nama" class="form-control" required>
					</div>
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-primary btn-round">Tambah</button>
					<button type="button" class="btn btn-primary btn-round" data-dismiss="modal">Batal</button>
				</div>
			</div>
		</div>
	    </div>
	    </form>

        <!-- Start Modal hapus Data -->
        <div class="modal fade" id="myModalHapus" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">Peringatan!!!</h4>
				</div>
				<div class="modal-body">
					<p>Apakah anda yakin akan mengahapus Data ini?
					</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default btn-simple" onclick="Delete()">Ya</button>
					<button type="button" class="btn btn-danger btn-simple" data-dismiss="modal">Tidak</button>
				</div>
			</div>
		</div>
	    </div>


    <script type="text/javascript">
                    
    
    function clearData()
    {
        $('[name="id_rekening"]').val("");
        $('[name="nama_bank"]').val("");
        $('[name="nomer_rekening"]').val("");
        $('[name="atas_nama"]').val("");
     }

     function Delete()
    {
        $.ajax({
            type: "GET",
            url: "<?php echo site_url('delete_rekening'); ?>"
            }).done(function( msg ) {
                window.location.href = "<?php echo site_url('rekening'); ?>";
            });
    }

    function EditData(id_rekening)
    {
        $.ajax({
            url : "<?php echo site_url('Rekeningweb_controller/ajax_edit')?>/" + id_rekening,
            type: "GET",
            dataType: "JSON",
            success: function(data)
            {
                $('[name="id_rekening"]').val(data.id_rekening);
                $('[name="nama_bank"]').val(data.nama_bank);
                $('[name="nomer_rekening"]').val(data.nomer_rekening);
                $('[name="atas_nama"]').val(data.atas_nama);
                $('#myModalEdit').modal('show'); // show bootstrap modal when complete loaded
            //$('.modal-title').text('Edit Person'); // Set title to Bootstrap modal title
            },
            error: function (jqXHR, textStatus, errorThrown)
            {
                alert('Error get data from ajax');
                }
                });
    }

    function SaveId(id_rekening)
    {
        $.ajax({
            type: "GET",
            url: "<?php echo site_url('getidRekening'); ?>",
            data: "id_rekening="+id_rekening
            }).done(function( msg ) {

            });
    }
    
    function ViewData(id_rekening)
    {
        $.ajax({
            url : "<?php echo site_url('Rekeningweb_controller/ajax_view')?>/" + id_rekening,
            type: "GET",
            dataType: "JSON",
            success: function(data)
            {
                $('[name="id_rekening"]').val(data.id_rekening);
                $('[name="nama_bank"]').val(data.nama_bank);
                $('[name="nomer_rekening"]').val(data.nomer_rekening);
                $('[name="atas_nama"]').val(data.atas_nama);
                $('#myModalDetail').modal('show'); // show bootstrap modal when complete loaded
            },
            error: function (jqXHR, textStatus, errorThrown)
            {
                alert('Error get data from ajax');
                }
                });
    }

    function AddData(id_rekening)
    {
        $.ajax({
            url : "<?php echo site_url('Rekeningweb_controller/ajax_view')?>/" + id_rekening,
            type: "GET",
            dataType: "JSON",
            success: function(data)
            {
                $('[name="id_rekening"]').val(data.id_rekening);
                $('[name="nama_bank"]').val(data.nama_bank);
                $('[name="nomer_rekening"]').val(data.nomer_rekening);
                $('[name="atas_nama"]').val(data.atas_nama);
                $('#myModalTambah').modal('show'); // show bootstrap modal when complete loaded
            },
            error: function (jqXHR, textStatus, errorThrown)
            {
                alert('Error get data from ajax');
                }
                });
    }
    </script>    
    <!-- /#wrapper -->
    <!-- jQuery -->
    <script src="<?php echo base_url(); ?>aset/vendor/jquery/jquery.min.js"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="<?php echo base_url(); ?>aset/vendor/bootstrap/js/bootstrap.min.js"></script>
    <!-- Metis Menu Plugin JavaScript -->
    <script src="<?php echo base_url(); ?>aset/vendor/metisMenu/metisMenu.min.js"></script>
    <!-- DataTables JavaScript -->
    <script src="<?php echo base_url(); ?>aset/vendor/datatables/js/jquery.dataTables.min.js"></script>
    <script src="<?php echo base_url(); ?>aset/vendor/datatables-plugins/dataTables.bootstrap.min.js"></script>
    <script src="<?php echo base_url(); ?>aset/vendor/datatables-responsive/dataTables.responsive.js"></script>
    <!-- Custom Theme JavaScript -->
    <script src="<?php echo base_url(); ?>aset/dist/js/sb-admin-2.js"></script>
    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
    <script>
    $(document).ready(function() {
        $('#dataTables-example').DataTable({
            responsive: true
        });
    });
    </script>
</body>
</html>