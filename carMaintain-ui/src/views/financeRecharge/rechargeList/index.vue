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
                  selectKey: '状态',
                  selectType: 'state__3',
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
            ajaxInterface: 'payment/bankpay', //接口
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
              title: '客户名',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'customer_name',
              config: {
                type: 'text',
                value: '',
              },
              slots: {
                customRender: 'customer_name',
              },
            },
            {
              align:'center',
              title: '付款户名',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'pay_username',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'pay_username',
              },
            },
            {
              align:'center',
              title: '付款账号',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'pay_account',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'pay_account',
              },
            },
            {
              align:'center',
              title: '支付金额',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'pay_money',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'pay_money',
              },
            },
            {
              align:'center',
              title: '实际金额',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'account_money',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'account_money',
              },
            },
            {
              align:'center',
              title: '付款时间',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'pay_time',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'pay_time',
              },
            },
            {
              align:'center',
              title: '收款账号',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'receipt_account',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'receipt_account',
              },
            },
            {
              align:'center',
              title: '付款截图',
              dataIndex: 'pay_url',
              ruleType: 'string', //编辑时的类型
              rowType: 'img',
              showEditPage: false,
              required: false,
              config: {
                type: 'img',
                width: 60,
                height: 60,
                showImgTip:true,
                clickEvent: 'showImg',
                uploadUrl: '/uploadpictures',
                fileList: [],
                previewVisible: false,
                previewImage: '',
                accept: 'image/png,image/jpg,image/jpeg',
              },
              slots: {
                customRender: 'pay_url',
              },
            },
            {
              align:'center',
              title: '审核时间',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'audit_time',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'audit_time',
              },
            },
            {
              align:'center',
              title: '备注',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'note',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'note',
              },
            },
            {
              align:'center',
              title: '状态',
              ruleType: 'number',
              rowType: 'button',
              showEditPage: false,
              dataIndex: 'state',
              config: {
                isEdit: false,
                type: 'button',
                width: '150',
                noStyle:true,
                size: 'default',
                buttonBg: 'green',
                enumType: 'state__3',
                defaultValue: 0,
                value: '',
              },
              slots: {
                customRender: 'state',
              },
            },
            {
              align:'center',
              key: 'operation',
              title: '操作',
              rowType: 'operation',
              dataIndex: 'operation',
              operation: true,
              role:[201],
              operationList: [
                //操作列表（按钮啥的）
                {
                  text: '审核',
                  clickType: 'verify',
                  clickEvent: 'editRow',
                  condition:"record['state']==0",
                  extData: [
                    {
                      align:'center',
                      title: '商户号',
                      rowType: 'number',
                      ruleType:"number",
                      showEditPage: true,
                      required: true,
                      dataIndex: 'wxmerchant_name',
                      config: {
                        type: 'select',
                        enumType: 'wxmerchantapi',
                        requestKey: 'wxmerchant_id',
                        value: '',
                      },
                      slots: {
                        customRender: 'wxmerchant_name',
                      },
                    },
                    {
                      title: '支付金额',
                      rowType: 'number',
                      required: true,
                      showEditPage: true,
                      ruleType: 'number', //编辑时的类型
                      dataIndex: 'pay_money',
                      config: {
                        type: 'number',
                      },
                    },
                    {
                      title: '实际金额',
                      rowType: 'number',
                      required: true,
                      showEditPage: true,
                      ruleType: 'number', //编辑时的类型
                      dataIndex: 'account_money',
                      config: {
                        type: 'number',
                      },
                    },
                    {
                      align:'center',
                      title: '状态',
                      ruleType: 'number',
                      rowType: 'button',
                      required: true,
                      showEditPage: true,
                      dataIndex: 'state',
                      config: {
                        isEdit: false,
                        type: 'button',
                        width: '150',
                        noStyle:true,
                        size: 'default',
                        buttonBg: 'green',
                        enumType: 'state__6',
                        defaultValue: 0,
                        value: '',
                      },
                    },
                    {
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
              slots: {
                customRender: 'operation',
              },
            },
          ],
          description: [
            //额外拓展数据
          ],
        },
      }
    },
  }
</script>
