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
                  // {
                  //   key: 'unit_num',
                  //   value: '单号',
                  //   inputValue: '',
                  //   inputType: 'text',
                  // },
                  {
                    key: 'tid',
                    value: '订单号',
                    inputValue: '',
                    inputType: 'number',
                  },
                ],
              },
            },
            operationConfig: [
              {
                type: 'normal',
                text: '查询淘客订单',
                modalWidth:1000,
                float: 'left',
                icon: 'file-search-line',
                ajaxInterface: 'checktaoke',
                clickEvent: 'searchModal',
                ajaxMethod: 'POST',
                role:[201,301,302],
                extData: [
                  {
                    key:"tid",
                    placeholder:"请输入订单号查询",
                    value:"",
                    callback:"checktaokeCallback",
                  }
                ],
              },
              {
                type: 'export',
                float: 'right',
                icon: 'ri-close-line',
                clickEvent: 'exportData',
              },
            ],
            autoWidth: true, //平均分每列宽度
            ajaxInterface: 'taoke', //接口
            openType: 'modal', //打开编辑或者添加的模式为 弹窗或者页面 "modal" ||"page"
          },
          tableData: [
            {
              align:'center',
              title: '时间',
              rowType: 'text',
              showEditPage: false,
              sliceNum:0, //显示多长，0为显示所有，没有这个属性则按照默认数值截断
              dataIndex: 'create_time',
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
              title: '订单号',
              rowType: 'text',
              ruleType:"orderType",
              showEditPage: false,
              dataIndex: 'tid',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'tid',
              },
            },
            {
              align:'center',
              title: '请求状态',
              ruleType: 'number',
              rowType: 'button',
              showEditPage: true,
              dataIndex: 'is_success',
              config: {
                isEdit: false,
                type: 'button',
                width: '150',
                size: 'default',
                buttonBg: 'green',
                noStyle:true,
                enumType: 'is_success',
                defaultValue: 0,
                value: '',
              },
              slots: {
                customRender: 'is_success',
              },
            },
            {
              align:'center',
              title: '淘客状态',
              ruleType: 'number',
              rowType: 'button',
              showEditPage: true,
              dataIndex: 'is_taoke',
              config: {
                isEdit: false,
                type: 'button',
                width: '150',
                size: 'default',
                noStyle:true,
                buttonBg: 'green',
                enumType: 'is_taoke__2',
                defaultValue: 0,
                value: '',
              },
              slots: {
                customRender: 'is_taoke',
              },
            },
            {
              align:'center',
              title: '备注',
              dataIndex: 'note',
              required: true,
              rowType: 'editColumns',
              showEditPage: true,
              config: {
                isEdit: false,
                type: 'text',
                width: '150',
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
