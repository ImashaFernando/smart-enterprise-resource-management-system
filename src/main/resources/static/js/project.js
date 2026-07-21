function deleteProject(id){

    Swal.fire({

        title:'Delete Project?',

        text:'This project will be permanently deleted.',

        icon:'warning',

        showCancelButton:true,

        confirmButtonColor:'#dc2626',

        cancelButtonColor:'#6b7280',

        confirmButtonText:'Yes, Delete',

        cancelButtonText:'Cancel'

    }).then((result)=>{

        if(result.isConfirmed){

            window.location.href="/projects/delete/"+id;

        }

    });

}