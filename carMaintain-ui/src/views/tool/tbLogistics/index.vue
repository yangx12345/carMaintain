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
                    key: 'tid',
                    value: '订单号',
                    inputType: 'number',
                    inputValue: '',
                  },
                ],
              },
              select: [
                {
                  //下拉框配置
                  selectKey: '签收状态',
                  selectType: 'is_sign',
                  selectValue: '全部',
                },
              ],
            },
            operationConfig: [
              {
                type: 'export',
                float: 'right',
                icon: 'ri-close-line',
                clickEvent: 'exportData',
              },
            ],
            autoWidth: true, //平均分每列宽度
            ajaxInterface: 'taobaologisticsinfo', //接口
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
              title: '节点',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'action',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'action',
              },
            },
            {
              align:'center',
              title: '运送信息',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'status_desc',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'status_desc',
              },
            },
            {
              align:'center',
              title: '运送时间',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'status_time',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'status_time',
              },
            },
            {
              align:'center',
              title: '签收状态',
              ruleType: 'number',
              rowType: 'button',
              showEditPage: true,
              dataIndex: 'is_sign',
              config: {
                isEdit: false,
                type: 'button',
                width: '150',
                size: 'default',
                buttonBg: 'green',
                enumType: 'is_sign',
                defaultValue: 0,
                value: '',
                noStyle:true,
              },
              slots: {
                customRender: 'is_sign',
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
