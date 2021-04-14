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
                    key: 'customer_name',
                    value: '客户名',
                    inputType: 'text',
                    inputValue: '',
                  },
                  {
                    key: 'mobile',
                    value: '手机号',
                    inputType: 'number',
                    inputValue: '',
                  },
                ],
              },
              
            },
            operationConfig: [
              // 操作栏配置
              {
                type: 'normal',
                icon: 'ri-close-line',
                role:[201],
                clickEvent: 'addData',
              },
              // {
              //   type: 'export',
              //   float: 'right',
              //   icon: 'ri-close-line',
              //   clickEvent: 'exportData',
              // },
            ],
            autoWidth: false, //平均分每列宽度
            ajaxInterface: 'customer', //接口
            openType: 'modal', //打开编辑或者添加的模式为 弹窗或者页面 "modal" ||"page"
          },
          tableData: [
            {
              align:'center',
              title: '创建日期',
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
              showEditPage: true,
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
              title: '手机号',
              rowType: 'text',
              required:true,
              showEditPage: true,
              dataIndex: 'mobile',
              config: {
                type: 'number',
              },
              slots: {
                customRender: 'mobile',
              },
            },
            {
              align:'center',
              title: '累计充值',
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
              title: '总提现额',
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
              title: '计费剩余',
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
              title: '计费消费',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'bill_consumer_money',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'bill_consumer_money',
              },
            },
            {
              align:'center',
              title: '提现次数',
              rowType: 'text',
              showEditPage: true,
              required:true,
              dataIndex: 'withd_count',
              config: {
                type: 'number',
                defaultValue:2,
                orderBy:"every_money"
              },
              slots: {
                customRender: 'withd_count',
              },
            },
            {
              align:'center',
              title: '日限额',
              rowType: 'text',
              showEditPage: true,
              required:true,
              dataIndex: 'everyday_money',
              config: {
                type: 'number',
                defaultValue:10000,
              },
              slots: {
                customRender: 'everyday_money',
              },
            },
            {
              align:'center',
              title: '剩余限额',
              rowType: 'text',
              showEditPage: true,
              required:true,
              dataIndex: 'surplus_everyday_money',
              config: {
                type: 'number',
                defaultValue:10000,
              },
              slots: {
                customRender: 'surplus_everyday_money',
              },
            },
            {
              align:'center',
              title: '最大金额',
              rowType: 'text',
              showEditPage: true,
              required:true,
              dataIndex: 'max_money',
              config: {
                type: 'number',
                defaultValue:300,
              },
              slots: {
                customRender: 'max_money',
              },
            },
            {
              align:'center',
              title: '商户号',
              ruleType: 'number',
              rowType: 'button',
              showEditPage: true,
              required:true,
              dataIndex: 'is_wxmerchant',
              config: {
                isEdit: false,
                type: 'button',
                width: '150',
                noStyle:true,
                size: 'default',
                buttonBg: 'green',
                enumType: 'is_wxmerchant',
                defaultValue: 0,
                value: '',
                orderBy:"service_count"
              },
              slots: {
                customRender: 'is_wxmerchant',
              },
            },
            {
              align:'center',
              title: '公众号',
              ruleType: 'number',
              rowType: 'button',
              showEditPage: true,
              required:true,
              dataIndex: 'is_wechatpub',
              config: {
                isEdit: false,
                type: 'button',
                width: '150',
                size: 'default',
                noStyle:true,
                buttonBg: 'green',
                enumType: 'is_wechatpub',
                defaultValue: 0,
                value: '',
                orderBy:"service_count"
              },
              slots: {
                customRender: 'is_wechatpub',
              },
            },
            {
              align:'center',
              title: '红包类型',
              ruleType: 'number',
              rowType: 'button',
              showEditPage: true,
              required:true,
              dataIndex: 'is_redpacket',
              config: {
                isEdit: false,
                type: 'button',
                width: '150',
                size: 'default',
                noStyle:true,
                buttonBg: 'green',
                enumType: 'is_redpacket',
                defaultValue: 0,
                value: '',
                orderBy:"service_count"
              },
              slots: {
                customRender: 'is_redpacket',
              },
            },
            {
              align:'center',
              title: '激活状态',
              ruleType: 'number',
              rowType: 'button',
              showEditPage: false,
              dataIndex: 'is_activate',
              config: {
                isEdit: true,
                type: 'button',
                width: '150',
                size: 'default',
                buttonBg: 'green',
                enumType: 'is_activate',
                defaultValue: 1,
                value: '',
              },
              slots: {
                customRender: 'is_activate',
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
          description: [
           
            // {
            //   align:'center',
            //   title: '剩余',
            //   rowType: 'text',
            //   showEditPage: false,
            //   dataIndex: 'surplus_money',
            //   config: {
            //     type: 'text',
            //   },
            //   slots: {
            //     customRender: 'surplus_money',
            //   },
            // },
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
              title: '昨笔数',
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
             {
              align:'center',
              title: '万率比',
              rowType: 'text',
              required:true,
              showEditPage: true,
              dataIndex: 'every_money',
              config: {
                type: 'number',
                defaultValue:60,
              },
              slots: {
                customRender: 'every_money',
              },
            },
            {
              align:'center',
              title: '工位数',
              rowType: 'text',
              showEditPage: true,
              required:true,
              dataIndex: 'service_count',
              config: {
                type: 'number',
                defaultValue:3,
              },
              slots: {
                customRender: 'service_count',
              },
            },
            {
              align:'center',
              title: '昨消费',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'bill_yester_money',
              config: {
                type: 'number',
              },
              slots: {
                customRender: 'bill_yester_money',
              },
            },
            {
              align:'center',
              title: '今消费',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'bill_today_money',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'bill_today_money',
              },
            },
             {
              align:'center',
              title: '周消费',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'bill_week_money',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'bill_week_money',
              },
            },
            {
              align:'center',
              title: '月消费',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'bill_month_money',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'bill_month_money',
              },
            },
            {
              align:'center',
              title: '日消费',
              rowType: 'text',
              showEditPage: true,
              required:true,
              dataIndex: 'bill_max_money',
              config: {
                type: 'number',
                defaultValue:500,
                orderBy:"max_money"
              },
              slots: {
                customRender: 'bill_max_money',
              },
            },
          ],
        },
      }
    },
  }
</script>
