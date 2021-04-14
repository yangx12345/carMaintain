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
                    value: '插入用户',
                    inputType: 'number',
                    inputValue: '',
                  },
                  {
                    key: 'source_user_id',
                    value: '来源用户',
                    inputType: 'text',
                    inputValue: '',
                  },
                  {
                    key: 'unit_num',
                    value: '单号',
                    inputType: 'text',
                    inputValue: '',
                  },
                ],
              },
              select: [
                {
                  //下拉框配置
                  selectKey: '佣金类型',
                  selectType: 'comm_type',
                  selectValue: '全部',
                },
                {
                  //下拉框配置
                  selectKey: '状态',
                  selectType: 'state__22',
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
            ajaxInterface: 'commission', //接口
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
              title: '用户',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'user_id',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'user_id',
              },
            },
            {
              align:'center',
              title: '单号',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'unit_num',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'unit_num',
              },
            },
            {
              align:'center',
              title: '类型',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'comm_type',
              config: {
                type: 'number',
              },
              slots: {
                customRender: 'comm_type',
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
              title: '状态',
              ruleType: 'number',
              rowType: 'button',
              showEditPage: true,
              dataIndex: 'state',
              config: {
                isEdit: false,
                type: 'button',
                width: '150',
                size: 'default',
                buttonBg: 'green',
                enumType: 'state',
                defaultValue: 0,
                value: '',
              },
            },
            {
              align:'center',
              key: 'note',
              title: '备注',
              dataIndex: 'note',
              required: true,
              rowType: 'editColumns',
              showEditPage: true,
              config: {
                isEdit: true,
                type: 'text',
                width: '150',
                size: 'default',
                value: '',
              },
              slots: {
                customRender: 'note',
              },
            },
            {
              align:'center',
              title: '激活',
              ruleType: 'number',
              rowType: 'button',
              showEditPage: true,
              dataIndex: 'is_activate',
              config: {
                isEdit: false,
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
