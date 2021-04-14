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
                    key: 'wxpay_name',
                    value: '商户名',
                    inputType: 'text',
                    inputValue: '',
                  },
                ],
              },
              select: [
                {
                  selectKey: '客户',
                  selectType: 'customerapi',
                  requestKey:"customer_id",
                  selectValue: '全部',
                },
              ]
            },
            autoWidth: false, //平均分每列宽度
            ajaxInterface: 'wxmerchant', //接口
            openType: 'modal', //打开编辑或者添加的模式为 弹窗或者页面 "modal" ||"page"
             operationConfig: [
              // 操作栏配置
              {
                type: 'normal',
                text: '添加商户号',
                icon: 'ri-close-line',
                clickEvent: 'blacklist',
                ajaxInterface: 'wxmerchant',
                ajaxMethod: 'POST',
                role:[201],
                extData:[
                  {
                    align:'center',
                    title: '客户',
                    rowType: 'number',
                    ruleType:'number',
                    showEditPage: true,
                    required: true,
                    dataIndex: 'customer_id',
                    config: {
                      type: 'select',
                      enumType: 'customerapi',
                      requestKey: 'customer_id',
                      value: '',
                    },
                    slots: {
                      customRender: 'customer_id',
                    },
                  },
                  {
                    align:'center',
                    title: '商户号',
                    rowType: 'text',
                    showEditPage: true,
                    required: true,
                    dataIndex: 'wxpay_name',
                    config: {
                      type: 'text',
                    },
                    slots: {
                      customRender: 'wxpay_name',
                    },
                  },
                   {
                    align:'center',
                    title: '商户ID',
                    rowType: 'text',
                    showEditPage: true,
                    required: true,
                    dataIndex: 'wxpay_mchid',
                    config: {
                      type: 'text',
                    },
                    slots: {
                      customRender: 'wxpay_mchid',
                    },
                  },
                   {
                    align:'center',
                    title: '商户KEY',
                    rowType: 'text',
                    showEditPage: true,
                    required: true,
                    dataIndex: 'wxpay_apikey',
                    sliceNum:3,
                    config: {
                      type: 'text',
                    },
                    slots: {
                      customRender: 'wxpay_apikey',
                    },
                  },
                   {
                    align:'center',
                    title: '文件路径',
                    rowType: 'text',
                    showEditPage: true,
                    required: true,
                    dataIndex: 'file_path',
                    sliceNum:3,
                    config: {
                      type: 'text',
                    },
                    slots: {
                      customRender: 'file_path',
                    },
                  },
                  {
                    align:'center',
                    title: 'IP',
                    rowType: 'text',
                    showEditPage: true,
                    required: true,
                    dataIndex: 'ip',
                    width:120,
                    sliceNum:3,
                    config: {
                      type: 'text',
                    },
                    slots: {
                      customRender: 'ip',
                    },
                  },
                ]
              },
              // {
              //   type: 'export',
              //   float: 'right',
              //   icon: 'ri-close-line',
              //   clickEvent: 'exportData',
              // },
            ],
          },
          tableData: [
            {
              align:'center',
              title: '创建日期',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'create_date',
              config: {
                type: 'date',
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
              title: '商户名',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'wxpay_name',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'wxpay_name',
              },
            },
            {
              align:'center',
              title: '商户ID',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'wxpay_mchid',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'wxpay_mchid',
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
              title: '昨金额',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'yester_money',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'yester_money',
              },
            },
            {
              align:'center',
              title: '今金额',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'today_money',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'today_money',
              },
            },
            {
              align:'center',
              title: ' 周金额',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'week_money',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'week_money',
              },
            },
            {
              align:'center',
              title: '月金额',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'month_money',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'month_money',
              },
            },
            {
              align:'center',
              title: '总金额',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'sum_money',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'sum_money',
              },
            },
            {
              align:'center',
              title: ' 昨笔数',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'yester_count',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'yester_count',
              },
            },
            {
              align:'center',
              title: ' 今笔数',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'today_count',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'today_count',
              },
            },
            {
              align:'center',
              title: '周笔数',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'week_count',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'week_count',
              },
            },
            {
              align:'center',
              title: '月笔数',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'month_count',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'month_count',
              },
            },
            {
              align:'center',
              title: '总笔数',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'stroke_count',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'stroke_count',
              },
            },
            // {
            //   align:'center',
            //   title: '操作',
            //   rowType: 'text',
            //   showEditPage: false,
            //   dataIndex: 'opera_count',
            //   config: {
            //     type: 'text',
            //   },
            //   slots: {
            //     customRender: 'opera_count',
            //   },
            // },
            {
              align:'center',
              title: '路径',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'file_path',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'file_path',
              },
            },
            {
              align:'center',
              title: '激活状态',
              ruleType: 'number',
              rowType: 'button',
              showEditPage: true,
              dataIndex: 'is_activate',
              config: {
                isEdit: false,
                type: 'button',
                width: '150',
                size: 'default',
                noStyle:true,
                buttonBg: 'green',
                enumType: 'is_activate',
                defaultValue: 1,
                value: '',
              },
              slots: {
                customRender: 'is_activate',
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
