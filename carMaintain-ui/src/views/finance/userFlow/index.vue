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
              selectInput: {
                //带输入框的下拉框配置
                width: 200,
                options: [
                  {
                    key: 'user_id',
                    value: '用户',
                    inputType: 'number',
                    inputValue: '',
                  },
                ],
              },
            },
            operationConfig: [
              //操作栏配置
              {
                type: 'export',
                float: 'right',
                icon: 'ri-close-line',
                clickEvent: 'exportData',
              },
            ],
            autoWidth: false, //平均分每列宽度
            ajaxInterface: 'userfund', //接口
            openType: 'modal', //打开编辑或者添加的模式为 弹窗或者页面 "modal" ||"page"
          },
          tableData: [
            {
              align:'center',
              title: '时间',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'create_time',
              sliceNum:0, //显示多长，0为显示所有，没有这个属性则按照默认数值截断
              config: {
                type: 'datetime',
                value: '',
              },
              slots: {
                customRender: 'create_time',
              },
            },
            {
              align:'center',
              title: '用户',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'user_id',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'user_id',
              },
            },
            {
              align:'center',
              title: '金额',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'money',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'money',
              },
            },
            {
              align:'center',
              title: '余额',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'balance',
              config: {
                type: 'number',
              },
              slots: {
                customRender: 'balance',
              },
            },
            {
              align:'center',
              title: '信息',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'message',
               width:400,
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'message',
              },
            },
            {
              align:'center',
              title: '备注',
              dataIndex: 'note',
              required: true,
              width:400,
              rowType: 'editColumns',
              showEditPage: true,
              config: {
                isEdit: true,
                type: 'text',
                size: 'default',
                value: '',
              },
              slots: {
                customRender: 'note',
              },
            },
            // {
            //   key: 'operation',
            //   // fixed: 'right',
            //   title: '操作',
            //   rowType: 'operation',
            //   dataIndex: 'operation',
            //   operation: true,
            //   operationList: [
            //     //操作列表（按钮啥的）
            //     {
            //       text: '编辑',
            //       clickType: 'edit',
            //       clickEvent: 'editRow',
            //     },
            //     {
            //       text: '删除',
            //       clickType: 'delete',
            //       clickEvent: 'onDelete',
            //       title: '确定要删除此条信息吗？？',
            //     },
            //   ],
            //   slots: {
            //     customRender: 'operation',
            //   },
            // },
          ],
          description: [
            //额外拓展数据
          ],
        },
      }
    },
  }
</script>
