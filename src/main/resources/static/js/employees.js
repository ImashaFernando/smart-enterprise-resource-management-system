function deleteEmployee(id) {
    Swal.fire({
        title: 'Delete Employee?',
        text: 'This employee record will be permanently deleted.',
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#4B5EFC',
        cancelButtonColor: '#6c757d',
        confirmButtonText: 'Delete',
        cancelButtonText: 'Cancel',
        reverseButtons: true
    }).then((result) => {
        if (result.isConfirmed) {
            window.location.href = "/employees/delete/" + id;
        }
    });
    const searchBox = document.querySelector(".search-box");

    if (searchBox) {

        searchBox.addEventListener("keyup", function () {

            clearTimeout(window.searchTimer);

            window.searchTimer = setTimeout(() => {

                this.form.submit();

            }, 500);

        });

    }
}