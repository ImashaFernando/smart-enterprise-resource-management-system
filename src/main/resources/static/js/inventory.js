// ======================================
// Inventory Delete Confirmation
// ======================================

function deleteInventory(id) {

    Swal.fire({

        title: 'Delete Product?',

        text: "This product will be permanently deleted.",

        icon: 'warning',

        showCancelButton: true,

        confirmButtonColor: '#dc2626',

        cancelButtonColor: '#6b7280',

        confirmButtonText: 'Yes, Delete',

        cancelButtonText: 'Cancel',

        reverseButtons: true

    }).then((result) => {

        if (result.isConfirmed) {

            window.location.href = "/inventory/delete/" + id;

        }

    });

}