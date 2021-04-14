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
              // selectInput: {
              //   //带输入框的下拉框配置
              //   width: 200,
              //   options: [
              //     {
              //       key: 'uuid',
              //       value: '做单用户',
              //       inputType: 'number',
              //       inputValue: '',
              //     },
              //   ],
              // },
              select: [
                {
                  selectKey: '商家',
                  selectType: 'merchantapi',
                  requestKey:"merchant_id",
                  selectValue: '全部',
                },
                 {
                  selectKey: '店铺',
                  selectType: 'shopapi',
                  requestKey:"shop_id",
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
                extData: [
                  {
                    title: '状态',
                    ruleType: 'number',
                    required: true,
                    dataIndex: 'is_black',
                    rowType: 'button',
                    showEditPage: true,
                    config: {
                      isEdit: true,
                      type: 'button',
                      width: '150',
                      size: 'default',
                      buttonBg: 'green',
                      enumType: 'is_black__1',
                      // defaultValue: 0,
                      value: '',
                    },
                  },
                  {
                    title: '用户',
                    showEditPage: true,
                    ruleType: 'number', //编辑时的类型
                    required: true,
                    rowType: 'editColumns',
                    dataIndex: 'uuid',
                    config: {
                      type: 'number',
                      width: '100',
                      size: 'default',
                      min: 0,
                      max: 1000,
                    },
                  },
                  {
                    title: '几级',
                    showEditPage: true,
                    ruleType: 'number', //编辑时的类型
                    required: true,
                    rowType: 'editColumns',
                    dataIndex: 'level',
                    config: {
                      isEdit: false, //是否可以修改
                      type: 'number',
                      width: '100',
                      size: 'default',
                      min: 0,
                      max: 1000,
                    },
                  },
                  {
                    key: 'mobile',
                    title: '备注',
                    rowType: 'text',
                    showEditPage: true,
                    ruleType: 'text', //编辑时的类型
                    dataIndex: 'note',
                    config: {
                      type: 'text',
                    },
                  },
                ],
              },
            ],
            autoWidth: false, //平均分每列宽度
            ajaxInterface: 'shopfund', //接口
            openType: 'modal', //打开编辑或者添加的模式为 弹窗或者页面 "modal" ||"page"
          },
          tableData: [
            {
              align:'center',
              title: '日期',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'create_date',
              sliceNum:0, //显示多长，0为显示所有，没有这个属性则按照默认数值截断
              config: {
                type: 'datetime',
                value: '',
              },
              slots: {
                customRender: 'create_date',
              },
            },
            {
              align:'center',
              title: '商家',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'merchant_name',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'merchant_name',
              },
            },
            {
              align:'center',
              title: '店铺',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'shop_name',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'shop_name',
              },
            },
            {
              align:'center',
              title: '本金',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'advances',
              config: {
                type: 'number',
              },
              slots: {
                customRender: 'advances',
              },
            },
            {
              align:'center',
              title: '佣金',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'commission',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'commission',
              },
            },
            {
              align:'center',
              title: '礼品金',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'gift_money',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'gift_money',
              },
            },
            {
              align:'center',
              title: '水金',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'mer_comm',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'mer_comm',
              },
            },
            {
              align:'center',
              title: '单量',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'work_count',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'work_count',
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
                isEdit: true,
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
