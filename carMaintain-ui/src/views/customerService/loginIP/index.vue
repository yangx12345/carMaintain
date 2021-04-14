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
              inputText: [
                {
                  key: 'login_ip',
                  value: '登录IP',
                  inputType: 'text',
                  inputValue: '',
                },
              ],
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
            ajaxInterface: 'serviceloginip', //接口
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
              title: '登录IP',
              rowType: 'text',
              showEditPage: true,
              required:true,
              sliceNum:0,
              dataIndex: 'login_ip',
              config: {
                type: 'text',
                width:"200",
                orderBy:"exp_date",
              },
              slots: {
                customRender: 'login_ip',
              },
            },
            {
              align:'center',
              title: '过期时间',
              rowType: 'editColumns',
              showEditPage: true,
              required:true,
              dataIndex: 'exp_date',
              sliceNum:0,
              config: {
                isEdit:true,
                type: 'dateAdd',
              },
              slots: {
                customRender: 'exp_date',
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
          description: [
            //额外拓展数据
          ],
        },
      }
    },
  }
</script>
