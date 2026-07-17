function deleteDepartment(id) {

    Swal.fire({
        title: "Delete Department?",
        text: "This department will be permanently deleted.",
        icon: "warning",
        showCancelButton: true,
        confirmButtonColor: "#4B5EFC",
        cancelButtonColor: "#6c757d",
        confirmButtonText: "Delete",
        cancelButtonText: "Cancel"
    }).then((result) => {

        if (result.isConfirmed) {
            window.location.href = "/departments/delete/" + id;
        }

    });

}