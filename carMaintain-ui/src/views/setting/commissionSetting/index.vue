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
              searchDate: false, //是否显示事件
              isToday: false, //是否是今天
            },
            operationConfig: [
              //操作栏配置
              {
                type: 'normal',
                icon: 'ri-close-line',
                clickEvent: 'addData',
              },
              // {
              //   type: 'export',
              //   float: 'right',
              //   icon: 'ri-close-line',
              //   clickEvent: 'exportData',
              // },
            ],
            autoWidth: true, //平均分每列宽度
            ajaxInterface: 'customermoney', //接口
            openType: 'modal', //打开编辑或者添加的模式为 弹窗或者页面 "modal" ||"page"
          },
          tableData: [
            {
              align:'center',
              title: ' 起始本金',
              rowType: 'text',
              showEditPage: true,
              ruleType:"number",
              required:true,
              dataIndex: 'st_advances',
              config: {
                type: 'number',
                // double:true,
              },
              slots: {
                customRender: 'st_advances',
              },
            },
            {
              align:'center',
              title: '结束本金',
              rowType: 'text',
              showEditPage: true,
              required:true,
              ruleType:"number",
              dataIndex: 'ed_advances',
              config: {
                type: 'number',
                // double:true,
              },
              slots: {
                customRender: 'ed_advances',
              },
            },
            {
              align:'center',
              title: '佣金',
              rowType: 'text',
              showEditPage: true,
              required:true,
              ruleType:"number",
              dataIndex: 'commission',
              config: {
                type: 'number',
                // double:true,
              },
              slots: {
                customRender: 'commission',
              },
            },
            {
              align:'center',
              title: '主持佣金',
              rowType: 'text',
              showEditPage: true,
              required:true,
              ruleType:"number",
              dataIndex: 'preside_comm',
              config: {
                type: 'number',
                // double:true,
              },
              slots: {
                customRender: 'preside_comm',
              },
            },
            {
              align:'center',
              key: 'note',
              title: '备注',
              dataIndex: 'note',
              required: false,
              width:300,
              rowType: 'editColumns',
              showEditPage: true,
              config: {
                isEdit: true,
                type: 'text',
                size: 'default',
                value: '',
              },
              slots: {
                customRender: 'note',
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
