import Swal from 'sweetalert'
export default {
    success: function (message) {
      Swal({
        position: 'top-end',
        icon: 'success',
        title: message,
        showConfirmButton: false,
        timer: 3000
      })
    },

    error: function (message) {
      Swal({
        position: 'top-end',
        icon: 'error',
        title: message,
        showConfirmButton: false,
        timer: 3000
      })
    },

    warning: function (message) {
      Swal({
        position: 'top-end',
        icon: 'warning',
        title: message,
        showConfirmButton: false,
        timer: 3000
      })
    },
    swal:function (config) {
        Swal(config)
    }
}
