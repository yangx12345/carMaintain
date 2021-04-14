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
                    inputType: 'number',
                    inputValue: '',
                  },
                  {
                    key: 'nick_name',
                    value: '微信昵称',
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
            },
            operationConfig: [
              //操作栏配置
              // {
              //   type: 'normal',
              //   text: '用户查询',
              //   float: 'left',
              //   icon: 'ri-close-line',
              //   ajaxInterface: 'user',
              //   clickEvent: 'blacklist',
              //   ajaxMethod: 'POST',
              //   extData: [
              //     {
              //       title: '状态',
              //       ruleType: 'number',
              //       required: true,
              //       dataIndex: 'is_black',
              //       rowType: 'button',
              //       showEditPage: true,
              //       config: {
              //         isEdit: true,
              //         type: 'button',
              //         width: '150',
              //         size: 'default',
              //         buttonBg: 'green',
              //         enumType: 'is_black__1',
              //         defaultValue: 0,
              //         value: '',
              //       },
              //     },
              //     {
              //       title: '用户',
              //       showEditPage: true,
              //       ruleType: 'number', //编辑时的类型
              //       required: true,
              //       rowType: 'editColumns',
              //       dataIndex: 'uuid',
              //       config: {
              //         type: 'number',
              //         width: '100',
              //         size: 'default',
              //         // min: 0,
              //         // max: 1000,
              //       },
              //     },
              //     {
              //       title: '几级',
              //       showEditPage: true,
              //       ruleType: 'number', //编辑时的类型
              //       required: true,
              //       rowType: 'editColumns',
              //       dataIndex: 'level',
              //       config: {
              //         isEdit: false, //是否可以修改
              //         type: 'number',
              //         width: '100',
              //         size: 'default',
              //         min: 0,
              //         max: 1000,
              //       },
              //     },
              //     {
              //       key: 'mobile',
              //       title: '备注',
              //       rowType: 'text',
              //       showEditPage: true,
              //       ruleType: 'text', //编辑时的类型
              //       dataIndex: 'note',
              //       config: {
              //         type: 'text',
              //       },
              //     },
              //   ],
              // },
              {
                type: 'export',
                float: 'right',
                icon: 'ri-close-line',
                clickEvent: 'exportData',
              },
            ],
            autoWidth: true, //平均分每列宽度
            ajaxInterface: 'userinfo', //接口
            openType: 'modal', //打开编辑或者添加的模式为 弹窗或者页面 "modal" ||"page"
          },
          tableData: [
              {
              //表格数据
              align:'center',
              title: '时间',
              rowType: 'text',
              width:190,
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
            // {
            //   title: '公众号',
            //   rowType: 'text',
            //   showEditPage: false,
            //   dataIndex: 'customer',
            //   slots: {
            //     customRender: 'customer',
            //   },
            // },
            {
              align:'center',
              title: '用户',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'user_id',
              slots: {
                customRender: 'user_id',
              },
            },
            {
              align:'center',
              title: '昨提交单',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'yester_sub_count',
              slots: {
                customRender: 'yester_sub_count',
              },
            },
            {
              align:'center',
              title: '今提交单',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'today_sub_count',
              slots: {
                customRender: 'today_sub_count',
              },
            },
            {
              align:'center',
              title: '周提交单',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'week_sub_count',
              slots: {
                customRender: 'week_sub_count',
              },
            },
            {
              align:'center',
              title: '月提交单',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'month_sub_count',
              slots: {
                customRender: 'month_sub_count',
              },
            },
            {
              align:'center',
              title: '总提交单',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'sum_sub_count',
              slots: {
                customRender: 'sum_sub_count',
              },
            },
            {
              align:'center',
              title: '昨领单',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'yester_count',
              slots: {
                customRender: 'yester_count',
              },
            },
            {
              align:'center',
              title: '今领单',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'today_count',
              slots: {
                customRender: 'today_count',
              },
            },
            {
              align:'center',
              title: '周领单',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'week_count',
              slots: {
                customRender: 'week_count',
              },
            },
            {
              align:'center',
              title: '月领单',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'month_count',
              slots: {
                customRender: 'month_count',
              },
            },
            {
              align:'center',
              title: '总领单',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'sum_count',
              slots: {
                customRender: 'sum_count',
              },
            },
          ],
        },
      }
    },
  }
</script>
