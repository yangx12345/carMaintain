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
                    inputType: 'text',
                    inputValue: '',
                  },
                  {
                    key: 'tid',
                    value: '订单号',
                    inputType: 'number',
                    inputValue: '',
                  },
                  {
                    key: 'user_id',
                    value: '用户',
                    inputType: 'number',
                    inputValue: '',
                  },
                  {
                    key: 'mobile',
                    value: '手机号',
                    inputType: 'text',
                    inputValue: '',
                  },
                  {
                    key: 'withd_code',
                    value: '提现代号',
                    inputType: 'text',
                    inputValue: '',
                  },
                  {
                    key: 'unit_num',
                    value: '单号',
                    inputType: 'text',
                    inputValue: '',
                  },
                  {
                    key: 'openid',
                    value: 'openid',
                    inputType: 'text',
                    inputValue: '',
                  },
                ],
              },
              select: [
                {
                  //下拉框配置
                  selectKey: '提现类型',
                  selectType: 'withd_type',
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
            autoWidth: false, //平均分每列宽度
            ajaxInterface: 'withdrawal', //接口
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
              title: '微信商户号',
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
              title: '微信公众号',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'nick_name',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'nick_name',
              },
            },
            {
              align:'center',
              title: '用户',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'user_id',
              config: {
                type: 'number',
              },
              slots: {
                customRender: 'user_id',
              },
            },
            {
              align:'center',
              title: 'openid',
              rowType: 'text',
              width:120,
              showEditPage: false,
              dataIndex: 'openid',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'openid',
              },
            },
            {
              align:'center',
              title: '提现code',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'withd_code',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'withd_code',
              },
            },
            {
              align:'center',
              title: '提现类型',
              ruleType: 'number',
              rowType: 'button',
              showEditPage: true,
              dataIndex: 'withd_type',
              config: {
                isEdit: false,
                type: 'button',
                width: '150',
                size: 'default',
                buttonBg: 'green',
                noStyle:true,
                enumType: 'withd_type',
                defaultValue: 0,
                value: '',
              },
              slots: {
                customRender: 'withd_type',
              },
            },
            {
              align:'center',
              title: '总金额',
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
              title: '工资金',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'salary_money',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'salary_money',
              },
            },
             {
               align:'center',
              title: '本金',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'advances',
              config: {
                type: 'text',
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
              title: '评价金',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'comments_money',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'comments_money',
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
              title: '消费金',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'consumer_money',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'consumer_money',
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
              title: '备注',
              dataIndex: 'note',
              required: true,
              rowType: 'editColumns',
              width:120,
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
