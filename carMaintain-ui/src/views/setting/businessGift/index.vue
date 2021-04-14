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
                    key: 'gift_name',
                    value: '礼品名',
                    inputType: 'text',
                    inputValue: '',
                  },
                  {
                    key: 'code',
                    value: '礼品代号',
                    inputType: 'number',
                    inputValue: '',
                  },
                ],
              },
            },
            operationConfig: [
              //操作栏配置
              {
                type: 'normal',
                icon: 'ri-close-line',
                clickEvent: 'addData',
              },
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
            autoWidth: true, //平均分每列宽度
            ajaxInterface: 'gift', //接口
            openType: 'modal', //打开编辑或者添加的模式为 弹窗或者页面 "modal" ||"page"
          },
          tableData: [
            {
              align:'center',
              title: '礼品名',
              rowType: 'text',
              showEditPage: true,
              required:true,
              dataIndex: 'gift_name',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'gift_name',
              },
            },
            {
              align:'center',
              title: '礼品代号',
              rowType: 'text',
              required:true,
              showEditPage: true,
              dataIndex: 'code',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'code',
              },
            },
            {
              align:'center',
              title: '金额',
              rowType: 'text',
              required:true,
              ruleType:"number",
              showEditPage: true,
              dataIndex: 'money',
              config: {
                type: 'number',
              },
              slots: {
                customRender: 'money',
              },
            },
            {
              align:'center',
              title: '激活',
              ruleType: 'number',
              rowType: 'button',
              required:true,
              showEditPage: true,
              dataIndex: 'is_activate',
              config: {
                isEdit: true,
                type: 'button',
                width: '150',
                size: 'default',
                buttonBg: 'green',
                enumType: 'is_activate',
                defaultValue:1,
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
          description: [
            //额外拓展数据
          ],
        },
      }
    },
  }
</script>
