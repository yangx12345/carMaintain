<template>
  <ATable :tableMessage="tableMessage"></ATable>
</template>

<script>
  import ATable from '@/components/tableComponent.vue'
  export default {
    components: {
      ATable,
    },
    data() {
      return {
        tableMessage: {
          config: {
            //总配置
            searchConfig: {
              //搜索配置
              searchDate: true, //是否显示事件
              isToday: false, //是否是今天
              select: [
                {
                  selectKey: '客户',
                  selectType: 'customerapi',
                  requestKey:"customer_id",
                  selectValue: '全部',
                },
              ]
            },
            // operationConfig: [
            //   // 操作栏配置
            //   {
            //     type: 'normal',
            //     icon: 'ri-close-line',
            //     role:[201],
            //     clickEvent: 'addData',
            //   },
            //   {
            //     type: 'export',
            //     float: 'right',
            //     icon: 'ri-close-line',
            //     clickEvent: 'exportData',
            //   },
            // ],
            autoWidth: false, //平均分每列宽度
            ajaxInterface: 'customerinfo', //接口
            openType: 'modal', //打开编辑或者添加的模式为 弹窗或者页面 "modal" ||"page"
          },
          tableData: [
            {
              align:'center',
              title: '创建时间',
              rowType: 'text',
              showEditPage: false,
              sliceNum:0,
              dataIndex: 'create_date',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'create_date',
              },
            },
            {
              align:'center',
              title: '客户名',
              rowType: 'text',
              showEditPage: false,
              required:true,
              dataIndex: 'customer_name',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'customer_name',
              },
            },
            {
              align:'center',
              title: '日打标数',
              rowType: 'text',
              showEditPage: true,
              required:true,
              dataIndex: 'mark_num',
              config: {
                type: 'number',
                defaultValue:5,
              },
              slots: {
                customRender: 'mark_num',
              },
            },
            {
              align:'center',
              title: '剩余打标',
              required:true,
              rowType: 'text',
              showEditPage: true,
              dataIndex: 'surplus_mark_num',
              config: {
                type: 'number',
                defaultValue:5,
              },
              slots: {
                customRender: 'surplus_mark_num',
              },
            },
            {
              align:'center',
              title: '日淘客数',
              required:true,
              rowType: 'text',
              showEditPage: true,
              dataIndex: 'taoke_num',
              config: {
                type: 'number',
                defaultValue:50,
              },
              slots: {
                customRender: 'taoke_num',
              },
            },
            {
              align:'center',
              title: '剩余淘客',
              rowType: 'text',
              required:true,
              showEditPage: true,
              dataIndex: 'surplus_taoke_num',
              config: {
                type: 'number',
                defaultValue:50,
              },
              slots: {
                customRender: 'surplus_taoke_num',
              },
            },
            {
              align:'center',
              title: '日账号数',
              rowType: 'text',
              showEditPage: true,
              dataIndex: 'query_num',
              required:true,
              config: {
                type: 'number',
                defaultValue:20,
              },
              slots: {
                customRender: 'query_num',
              },
            },
            {
              align:'center',
              title: '剩余账号',
              rowType: 'text',
              showEditPage: true,
              required:true,
              dataIndex: 'surplus_query_num',
              config: {
                type: 'number',
                defaultValue:20,
              },
              slots: {
                customRender: 'surplus_query_num',
              },
            },
            {
              align:'center',
              key: 'operation',
              // fixed: 'right',
              title: '操作',
              rowType: 'operation',
              dataIndex: 'operation',
              operation: true,
              operationList: [
                //操作列表（按钮啥的）
                {
                  text: '编辑',
                  clickType: 'edit',
                  clickEvent: 'editRow',
                  role:[201],
                },
                // {
                //   text: '删除',
                //   clickType: 'delete',
                //   clickEvent: 'onDelete',
                //   title: '确定要删除此条信息吗？？',
                // },
              ],
              slots: {
                customRender: 'operation',
              },
            },
          ],
        },
      }
    },
  }
</script>
