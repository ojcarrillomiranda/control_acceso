$(document).ready(function () {
    $('#tabla_persona').DataTable({
        dom: 'lfBrtip',
        "language": {
            "lengthMenu": "Mostrar _MENU_ resgistros",
            "zeroRecords": "No se encontraron resultados",
            "info": "Mostrando registros del _START_ al _END_  de un total de  _TOTAL_ registros",
            "infoEmpty": "Mostrando registros del 0 al 0 de un total de 0 registros",
            "infoFiltered": "(Filtrado de un total de _MAX_ registros)",
            "sSearch": "Buscar",
            "oPaginate": {
                "sFirst": "Primero",
                "sLast": "Ultimo",
                "sNext": "	&#10145;",
                "sPrevious": "	&#11013;",
            },
            "sProcessing": "Procesando..."
        },
        responsive: true, "lengthChange": true, "autoWidth": true,
        buttons: [{
            extend: "pdf",
            text: '<button class="btn btn-white text-white font-weight-bold btn-crear p-1">Pdf <i class="fas fa-file-pdf"></i></button>'
        },
            {
                extend: "excel",
                text: '<button class="btn btn-white text-white font-weight-bold btn-crear p-1">Xls <i class="fas fa-file-excel"></i></button>'
            }
        ]
    });
});

if ("th:${guardar != null}"){
    console.log("llego despues de guardar")
}