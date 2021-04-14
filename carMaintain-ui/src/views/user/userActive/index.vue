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
                    key: 'user_id',
                    value: '用户',
                    inputType: 'number',
                    inputValue: '',
                  },
                  {
                    key: 'buyer_nick',
                    value: '买家昵称',
                    inputType: 'text',
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
                    key: 'tid',
                    value: '订单号',
                    inputType: 'number',
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
              // {
              //   type: 'export',
              //   float: 'right',
              //   icon: 'ri-close-line',
              //   clickEvent: 'exportData',
              // },
            ],
            autoWidth: true, //平均分每列宽度
            ajaxInterface: 'useractive', //接口
            openType: 'modal', //打开编辑或者添加的模式为 弹窗或者页面 "modal" ||"page"
          },
          tableData: [
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
              title: '公众号',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'nick_name',
              slots: {
                customRender: 'nick_name',
              },
            },
            {
              align:'center',
              title: '时段',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'time_frame',
              slots: {
                customRender: 'time_frame',
              },
            },
            // {
            //   title: '是否新用户',
            //   rowType: 'text',
            //   showEditPage: false,
            //   dataIndex: 'is_newuser',
            //   slots: {
            //     customRender: 'is_newuser',
            //   },
            // },
          ],
        },
      }
    },
  }
</script>
