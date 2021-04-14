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
                      key: 'mobile',
                      value: '手机号',
                      inputType: 'number',
                      inputValue: '',
                  },
                  {
                      key: 'username',
                      value: '姓名',
                      inputValue: '',
                      inputType: 'text',
                  },
                  {
                      key: 'idcard_code',
                      value: '身份证号',
                      inputValue: '',
                      inputType: 'text',
                  },
                  {
                      key: 'wechat_qq',
                      value: '微信/QQ',
                      inputValue: '',
                      inputType: 'text',
                  },
                  {
                      key: 'note',
                      value: '备注',
                      inputValue: '',
                      inputType: 'text',
                  },
                ],
              },
              select: [
                {
                  selectKey: '激活状态',
                  selectType: 'is_activate',
                  selectValue: '全部',
                },
              ],
            },
            operationConfig: [
              {
                type: 'normal',
                icon: 'ri-close-line',
                clickEvent: 'addData',
              },
              {
                type: 'normal',
                text: '上传文件',
                float: 'right',
                icon: 'ri-close-line',
                ajaxInterface: 'blacklist',
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
                      uploadUrl: '/blacklist/',
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
            ajaxInterface: 'blacklist', //接口
            openType: 'modal', //打开编辑或者添加的模式为 弹窗或者页面 "modal" ||"page"
          },
          tableData: [
            {
              //表格数据
              align:'center',
              title: '创建时间',
              rowType: 'text',
              showEditPage: false,
              required:false,
              ellipsis: true,
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
              align:'center',
              title: '买家昵称',
              rowType: 'text',
              ellipsis: true,
              showEditPage: true,
              required:false,
              dataIndex: 'buyer_nick',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'buyer_nick',
              },
            },
            {
              //表格数据
              align:'center',
              title: '手机号',
              rowType: 'text',
              showEditPage: true,
              ellipsis: true,
              required:false,
              dataIndex: 'mobile',
              config: {
                type: 'text',
                value: '',
              },
              slots: {
                customRender: 'mobile',
              },
            },
            {
              align:'center',
              title: '姓名',
              ellipsis: true,
              rowType: 'text',
              showEditPage: true,
              required:false,
              dataIndex: 'username',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'username',
              },
            },
            {
              align:'center',
              title: '身份证号',
              rowType: 'text',
              showEditPage: true,
              ellipsis: true,
              required:false,
              dataIndex: 'idcard_code',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'idcard_code',
              },
            },
            {
              align:'center',
              title: '微信/QQ',
              rowType: 'text',
              showEditPage: true,
              ellipsis: true,
              required:false,
              dataIndex: 'wechat_qq',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'wechat_qq',
              },
            },
            {
              align:'center',
              title: '备注',
              rowType: 'text',
              showEditPage: true,
              ellipsis: true,
              required:false,
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
              title: '激活状态',
              ruleType: 'number',
              rowType: 'button',
              showEditPage: true,
              ellipsis: true,
              dataIndex: 'is_activate',
              config: {
                isEdit: true,
                type: 'button',
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
                },
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
