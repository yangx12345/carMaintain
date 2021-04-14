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
                  selectKey: '充值类型',
                  selectType: 'recharge_type',
                  selectValue: '全部',
                },
                {
                  selectKey: '充值来源',
                  selectType: 'recharge_source',
                  selectValue: '全部',
                },
              ],
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
            autoWidth: true, //平均分每列宽度
            ajaxInterface: 'customerrechargerecord', //接口
            openType: 'modal', //打开编辑或者添加的模式为 弹窗或者页面 "modal" ||"page"
          },
          tableData: [
            {
              align:'center',
              title: '时间',
              rowType: 'text',
              showEditPage: false,
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
              title: '充值金额',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'recharge_money',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'recharge_money',
              },
            },
            {
              align:'center',
              title: '实际充值',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'actual_recharge_money',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'actual_recharge_money',
              },
            },
            {
              align:'center',
              title: '累计金额',
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
              title: '剩余金额',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'surplus_money',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'surplus_money',
              },
            },
            {
              align:'center',
              title: '计费金额',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'bill_money',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'bill_money',
              },
            },
            {
              align:'center',
              title: '剩余计费',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'bill_surplus_money',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'bill_surplus_money',
              },
            },
            {
              align:'center',
              title: '充值类型',
              ruleType: 'number',
              rowType: 'button',
              showEditPage: true,
              dataIndex: 'recharge_type',
              config: {
                isEdit: false,
                type: 'button',
                width: '150',
                noStyle:true,
                size: 'default',
                buttonBg: 'green',
                enumType: 'recharge_type',
                defaultValue: 0,
                value: '',
              },
              slots: {
                customRender: 'recharge_type',
              },
            },
            {
              align:'center',
              title: '充值来源',
              ruleType: 'number',
              rowType: 'select',
              showEditPage: true,
              dataIndex: 'recharge_source',
              config: {
                isEdit: false,
                type: 'select',
                noStyle:true,
                enumType: 'recharge_source',
                defaultValue: 0,
                value: '',
              },
              slots: {
                customRender: 'recharge_source',
              },
            },
            {
              align:'center',
              title: '增减类型',
              ruleType: 'number',
              rowType: 'select',
              showEditPage: true,
              dataIndex: 'type',
              config: {
                isEdit: false,
                type: 'select',
                noStyle:true,
                enumType: 'type__2',
                defaultValue: 0,
                value: '',
              },
              slots: {
                customRender: 'type',
              },
            },
            {
              align:'center',
              key: 'note',
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
