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
                      key: 'buyer_nick',
                      value: '买家昵称',
                      inputValue: '',
                      inputType: 'text',
                  },
                  {
                      key: 'user_id',
                      value: '用户',
                      inputType: 'number',
                      inputValue: '',
                  },
                  {
                      key: 'item_name',
                      value: '商品名',
                      inputType: 'text',
                      inputValue: '',
                  },
                  {
                      key: 'receiver_name',
                      value: '收货姓名',
                      inputValue: '',
                      inputType: 'text',
                  },
                  {
                      key: 'receiver_mobile',
                      value: '收货手机号',
                      inputValue: '',
                      inputType: 'text',
                  },
                  {
                      key: 'all_address',
                      value: '收货所有地址',
                      inputValue: '',
                      inputType: 'text',
                  },
                  {
                      key: 'receiver_address',
                      value: '收货详情地址',
                      inputValue: '',
                      inputType: 'text',
                  },
                  {
                      key: 'ip',
                      value: 'IP',
                      inputValue: '',
                      inputType: 'text',
                  },
                ],
              },
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
              // {
              //   type: 'normal',
              //   icon: 'ri-close-line',
              //   clickEvent: 'addData',
              // },
              {
                type: 'normal',
                text: '添加复购',
                icon: 'ri-close-line',
                ajaxInterface: 'accountmerchantarea',
                clickEvent: 'blacklist',
                role:[201,301,302],
                ajaxMethod: 'POST',
                extData: [
                   {
                    //表格数据
                    title: '复购时间',
                    rowType: 'text',
                    showEditPage: true,
                    required:true,
                    dataIndex: 'create_date',
                    config: {
                      type: 'date',
                      value: '',
                    },
                    slots: {
                      customRender: 'create_date',
                    },
                  },
                  {
                    title: '商家',
                    ruleType:"number",
                    showEditPage: true,
                    required:true,
                    dataIndex: 'merchant_name',
                    config: {
                      displayItem: ['shop_name'], //选择完之后显示谁！以这个属性判断某个属性是否需要与其联动！
                      changeRequestAPI: { shop_name: 'shopapi' }, //下拉改变时，数据也以这个名字存放在store、enum的地方
                      type: 'select',
                      enumType: 'merchantapi',
                      requestKey: 'merchant_id',
                      value: '',
                    },
                  },
                  {
                    title: '店铺',
                    ruleType:"number",
                    showEditPage: true,
                    required:false,
                    dataIndex: 'shop_name',
                    config: {
                      hidden:true,
                      displayItem: ['item_name'], //选择完之后显示谁！以这个属性判断某个属性是否需要与其联动！
                      changeRequestAPI: { item_name: 'itemapi' }, //下拉改变时，数据也以这个名字存放在store、enum的地方
                      type: 'select',
                      enumType: 'shopapi',
                      requestKey: 'shop_id',
                      value: '',
                    },
                  },
                  {
                    title: '商品',
                    ruleType:"number",
                    showEditPage: true,
                    required:false,
                    dataIndex: 'item_name',
                    config: {
                      hidden:true,
                      // displayItem: ['item_name'], //选择完之后显示谁！以这个属性判断某个属性是否需要与其联动！
                      // changeRequestAPI: { item_name: 'itemapi' }, //下拉改变时，数据也以这个名字存放在store、enum的地方
                      type: 'select',
                      enumType: 'itemapi',
                      requestKey: 'item_id',
                      value: '',
                    },
                  },
                  {
                    align:'center',
                    title: '买家昵称',
                    rowType: 'text',
                    showEditPage: true,
                    required:true,
                    dataIndex: 'buyer_nick',
                    config: {
                      type: 'text',
                    },
                  },
                  {
                    align:'center',
                    title: '收货手机号',
                    rowType: 'text',
                    showEditPage: true,
                    dataIndex: 'receiver_mobile',
                    config: {
                      type: 'number',
                    },
                  },
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
            ajaxInterface: 'accountmerchantarea', //接口
            openType: 'modal', //打开编辑或者添加的模式为 弹窗或者页面 "modal" ||"page"
          },
          tableData: [
            {
              //表格数据
              align:'center',
              title: '时间',
              rowType: 'text',
              showEditPage: false,
              ellipsis: true,
              dataIndex: 'create_time',
              width:190,
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
              title: '商家',
              rowType: 'text',
              showEditPage: false,
              ellipsis: true,
              dataIndex: 'merchant_name',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'merchant_name',
              },
            },
            {
              //表格数据
              align:'center',
              title: '店铺',
              width:100,
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'shop_name',
              ellipsis: true,
              config: {
                type: 'text',
                value: '',
              },
              slots: {
                customRender: 'shop_name',
              },
            },
            // {
            //   align:'center',
            //   title: '等级',
            //   rowType: 'text',
            //   showEditPage: false,
            //   dataIndex: 'security_level',
            //   config: {
            //     type: 'number',
            //   },
            //   slots: {
            //     customRender: 'security_level',
            //   },
            // },
            {
              align:'center',
              title: '商品',
              rowType: 'text',
              width:100,
              showEditPage: false,
              ellipsis: true,
              dataIndex: 'item_name',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'item_name',
              },
            },
                  {
                    align:'center',
                    title: '单号',
                    rowType: 'text',
                    showEditPage: false,
                    ellipsis: true,
                    required: true,
                    dataIndex: 'unit_num',
                    sliceNum:3,
                    config: {
                      type: 'text',
                    },
                    slots: {
                      customRender: 'unit_num',
                    },
                  },
            {
              align:'center',
              title: '领取用户',
              rowType: 'text',
              showEditPage: true,
              ellipsis: true,
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
              title: '提交用户',
              rowType: 'text',
              showEditPage: true,
              ellipsis: true,
              dataIndex: 'preside_user_id',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'preside_user_id',
              },
            },
            {
              align:'center',
              title: '买家昵称',
              rowType: 'text',
              showEditPage: true,
              required:true,
              ellipsis: true,
              dataIndex: 'buyer_nick',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'buyer_nick',
              },
            },
            {
              align:'center',
              title: '收货姓名',
              ellipsis: true,
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'receiver_name',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'receiver_name',
              },
            },
            {
              align:'center',
              title: '收货手机号',
              ellipsis: true,
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'receiver_mobile',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'receiver_mobile',
              },
            },
            {
              align:'center',
              title: '收货所有地址',
              rowType: 'text',
              showEditPage: false,
              ellipsis: true,
              dataIndex: 'all_address',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'all_address',
              },
            },
            {
              align:'center',
              title: '收货详情地址',
              rowType: 'text',
              showEditPage: false,
              ellipsis: true,
              dataIndex: 'receiver_address',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'receiver_address',
              },
            },
            {
              align:'center',
              title: 'IP',
              rowType: 'text',
              showEditPage: false,
              ellipsis: true,
              dataIndex: 'ip',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'ip',
              },
            },
            // {
            //   align:'center',
            //   title: '打散编码',
            //   rowType: 'text',
            //   showEditPage: false,
            //   dataIndex: 'scatter_num',
            //   config: {
            //     type: 'text',
            //   },
            //   slots: {
            //     customRender: 'scatter_num',
            //   },
            // },
            {
              align:'center',
              title: '激活状态',
              ruleType: 'number',
              rowType: 'button',
              ellipsis: true,
              showEditPage: false,
              dataIndex: 'is_activate',
              config: {
                isEdit: true,
                type: 'button',
                size: 'default',
                buttonBg: 'green',
                enumType: 'is_activate',
                defaultValue: 0,
                value: '',
              },
              slots: {
                customRender: 'is_activate',
              },
            },
            {
              key: 'operation',
              // fixed: 'right',
              title: '操作',
              rowType: 'operation',
              dataIndex: 'operation',
              operation: true,
              operationList: [
                //操作列表（按钮啥的）
                // {
                //   text: '编辑',
                //   clickType: 'edit',
                //   clickEvent: 'editRow',
                // },
                {
                  text: '删除',
                  clickType: 'delete',
                  clickEvent: 'onDelete',
                  title: '确定要删除此条信息吗？？',
                },
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
