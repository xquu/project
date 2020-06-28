<template>
    <div>
        <p>
            <button @click="add()" class="btn btn-white btn-default btn-round">
             <i class="ace-icon fa fa-edit"></i>
             新增
            </button>
            &nbsp;
            <button @click="list(1)" class="btn btn-white btn-default btn-round">
             <i class="ace-icon fa fa-refresh"></i>
             刷新
            </button>
        </p>
        <!-- 分页插件 -->
        <pagination ref="pagination" v-bind:list="list"  v-bind:itemCount="8"></pagination>
        <table id="simple-table" class="table  table-bordered table-hover">
        <thead>
        <tr>
            <th class="center">
                <label class="pos-rel">
                    <input type="checkbox" class="ace"/>
                    <span class="lbl"></span>
                </label>
            </th>
            <th>ID</th>
            <th>名称</th>
            <th>课程ID</th>
            <th>操作</th>
        </tr>
        </thead>

        <tbody>

        <tr v-for="chapter in chapters" v-bind:key="chapter.id">
            <td class="center">
                <label class="pos-rel">
                    <input type="checkbox" class="ace"/>
                    <span class="lbl"></span>
                </label>
            </td>
            <td>{{chapter.id}}</td>
            <td>{{chapter.name}}</td>
            <td>{{chapter.courseId}}</td>
            <td>
                <div class="btn-group">
                    <button class="btn btn-xs btn-info" @click="edit(chapter)">
                        <i class="ace-icon fa fa-pencil bigger-120"></i>
                    </button>
                    <button class="btn btn-xs btn-danger" @click="del(chapter.id)">
                        <i class="ace-icon fa fa-trash-o bigger-120"></i>
                    </button>
                    <button class="btn btn-xs btn-warning">
                        <i class="ace-icon fa fa-flag bigger-120"></i>
                    </button>
                </div>
            </td>
        </tr>

        </tbody>
    </table>

        <div class="modal" id="form-modal" tabindex="-1" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">表单</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form>
                            <div class="form-group">
                                <label>名称</label>
                                <input v-model="chapter.name" class="form-control"  aria-describedby="emailHelp" placeholder="名称">
                                <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                            </div>
                            <div class="form-group">
                                <label>课程ID</label>
                                <input v-model="chapter.courseId" class="form-control" placeholder="课程ID">
                            </div>

                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">取 消</button>&nbsp;
                        <button type="button" class="btn btn-primary" @click="save()">保 存</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    import Pagination from "../../components/pagination.vue";

    export default {
        components: {Pagination},
        name: "chapter",
        data:function(){
            return {
                chapter:{},
                chapters:[]
            }
        },

        mounted() {
           this.$refs.pagination.size = 5
           this.list(1)
        },
        methods:{
            /**
             * 点击【新增】
             */
            add: function() {
                this.chapter = {};
                $("#form-modal").modal("show")
            },

            edit: function(chapter) {
                //使用$.extend 绑定一个空数据，解决vue输入数据绑定更新问题
                this.chapter = $.extend({},chapter)
                $("#form-modal").modal("show")
            },

            list: function (page) {
                this.$axios.post("http://127.0.0.1:9000/business/admin/chapter/list",{
                    page:page,
                    size:this.$refs.pagination.size
                }).then((res)=>{
                    console.log("查询大章结果：",res)
                    let content = res.data.content
                    this.chapters = content.list
                    this.$refs.pagination.render(page, content.total);
                })
            },

            save: function () {
                this.$toast.loading()
                this.$axios.post("http://127.0.0.1:9000/business/admin/chapter/save",
                this.chapter).then((res)=>{
                    console.log("添加大章结果：",res)
                    let response = res.data;
                    if(response.success){
                        $("#form-modal").modal("hide");
                        this.$toast.success("保存成功！")
                        this.list(1);
                    }
                })
            },

            del: function (id){
                console.log(id)
                let toast = this.$toast;
                toast.confirm("删除大章后不可恢复!您确定删除吗？", () => {
                    toast.loading()
                    this.$axios.delete("http://127.0.0.1:9000/business/admin/chapter/delete/"+ id)
                        .then((res)=>{
                            let response = res.data;
                            if(response.success){
                                toast.success("删除成功")
                                this.list(1)
                            }else{
                                toast.error("删除失败!")
                            }
                        })
                })
            }

        }
    }
</script>

<style>

</style>