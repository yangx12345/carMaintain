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
                    key: 'tid',
                    value: '订单号',
                    inputValue: '',
                    inputType: 'number',
                  },
                ],
              },
              select: [
                {
                  selectKey: '店铺',
                  selectType: 'shopapi',
                  requestKey:"shop_id",
                  selectValue: '全部',
                },
              ]
            },
            operationConfig: [
              {
                type: 'normal',
                text: '上传备注',
                float: 'right',
                icon: 'ri-close-line',
                ajaxInterface: 'taobaonote',
                clickEvent: 'blacklist',
                ajaxMethod: 'POST',
                paramsType:"file",
                extData: [
                  {
                    key: 'mobile',
                    title: '上传文件',
                    rowType: 'uploadFile',
                    ruleType:"file",
                    required: true,
                    showEditPage: true,
                    dataIndex: 'file',
                    config: {
                      fileList:[],
                      type: 'uploadFile',
                      uploadUrl: '/taobaonote/',
                      accept:
                        'application/vnd.ms-excel,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet,.csv',
                      acceptType: 'excel',
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
            autoWidth: false, //平均分每列宽度
            ajaxInterface: 'taobaonote', //接口
            openType: 'modal', //打开编辑或者添加的模式为 弹窗或者页面 "modal" ||"page"
          },
          tableData: [
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
              title: '订单号',
              rowType: 'text',
              ruleType:"orderType",
              showEditPage: false,
              dataIndex: 'tid',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'tid',
              },
            },
            {
              align:'center',
              title: '插旗颜色',
              ruleType: 'number',
              rowType: 'select',
              showEditPage: true,
              dataIndex: 'flag',
              config: {
                isEdit: false,
                type: 'select',
                autoColor:true,
                size: 'default',
                enumType: 'flag',
                defaultValue: 0,
                value: '',
              },
              slots: {
                customRender: 'flag',
              },
            },
            {
              align:'center',
              title: '备注信息',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'memo',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'memo',
              },
            },
            {
              align:'center',
              title: '请求状态',
              ruleType: 'number',
              rowType: 'button',
              showEditPage: true,
              dataIndex: 'is_success',
              config: {
                isEdit: false,
                type: 'button',
                width: '150',
                size: 'default',
                buttonBg: 'green',
                enumType: 'is_success',
                noStyle:true,
                defaultValue: 0,
                value: '',
              },
              slots: {
                customRender: 'is_success',
              },
            },
            {
              align:'center',
              title: '信息',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'message',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'message',
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
