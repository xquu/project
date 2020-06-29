import Swal from 'sweetalert'
import './toast.css'
export default {
    //使用原生的swal调用此方法
    swal:Swal,

    success: function (message) {
      Swal({
        icon: 'success',
       // title: message,
          text: message,
        buttons: false,
        timer: 1000
      })
    },

    error: function (message) {
      Swal({
        icon: 'error',
       // title: message,
          text: message,
        buttons: false,
        timer: 1000
      })
    },

    warning: function (message) {
      Swal({
        icon: 'warning',
      //  title: message,
          text: message,
        buttons: false,
        timer: 1000
      })
    },

    loading: function () {
        Swal({
            // text: "正在加载",
             icon: "/static/image/loading/pika.gif",
             button:false,
             closeOnEsc: false,
             closeOnClickOutside: false,
             className: 'swal-loading'
         })
    },

    confirm: function (message, callback) {
        Swal({
            title: "确定?",
            text: message,
            icon: "warning",
            buttons: ["取 消", "确 定"],
            dangerMode: true
        }).then((willDelete) => {
            if (willDelete) {
               if(callback){
                   callback()
               }
            }
        })
    },
    //Swal.close()方法无效，这里利用延时关闭属性，设置10毫秒后自动关闭。
    close: function () {
        Swal({
            button:false,
            className: 'swal-close',
            timer: 10
        })
    }
}
