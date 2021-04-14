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
              // {
              //   type: 'export',
              //   float: 'right',
              //   icon: 'ri-close-line',
              //   clickEvent: 'exportData',
              // },
            ],
            autoWidth: true, //平均分每列宽度
            ajaxInterface: 'openidtounionid', //接口
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
              title: 'openid',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'openid',
              slots: {
                customRender: 'openid',
              },
            },
            // {
            //   align:'center',
            //   title: 'unionid',
            //   rowType: 'text',
            //   showEditPage: false,
            //   dataIndex: 'unionid',
            //   slots: {
            //     customRender: 'unionid',
            //   },
            // },
            // {
            //   title: 'is_subscribe',
            //   rowType: 'text',
            //   showEditPage: false,
            //   dataIndex: 'is_subscribe',
            //   slots: {
            //     customRender: 'is_subscribe',
            //   },
            // },
          ],
        },
      }
    },
  }
</script>
