<template>
  <ATable :tableMessage="tableMessage"></ATable>
</template>

<script>
  import ATable from '@/components/tableComponent.vue'
  import redPacket from './../redPacket/index.vue'
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
              isWeek:true,//是否搜索一周的时间范围
              selectInput: {
                //带输入框的下拉框配置
                width: 200,
                options: [
                  {
                      key: 'activity_name',
                      value: '活动名称',
                      inputValue: '',
                      inputType: 'text',
                  },
                  {
                      key: 'id',
                      value: '活动ID',
                      inputValue: '',
                      inputType: 'number',
                  },
                ],
              },
              select: [
                {
                  selectKey: '生成客服',
                  selectType: 'serviceapi',
                  requestKey:"service_id",
                  selectValue: '全部',
                },
              ]
            },
            operationConfig: [
               {
                type: 'normal',
                icon: 'ri-close-line',
                clickEvent: 'addData',
                role:[201,301,302],
                paramsType:"file",
                extData:[
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
                      uploadUrl: '/taobaoaccount/',
                      accept:
                        'application/vnd.ms-excel,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet,.csv',
                      acceptType: 'excel',
                    },
                  },
                ]
              },
              {
                type: 'export',
                float: 'right',
                icon: 'ri-close-line',
                clickEvent: 'exportData',
              },
            ],
            autoWidth: false, //平均分每列宽度
            ajaxInterface: 'redpacketactivity', //接口
            openType: 'modal', //打开编辑或者添加的模式为 弹窗或者页面 "modal" ||"page"
          },
          tableData: [
            {
              //表格数据
              align:'center',
              title: '创建时间',
              rowType: 'text',
              showEditPage: false,
              required: true,
              ellipsis:true,
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
              title: '生成客服',
              rowType: 'text',
              showEditPage: false,
              ellipsis:true,
              required: true,
              dataIndex: 'service_name',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'service_name',
              },
            },
            {
              align:'center',
              title: '活动ID',
              rowType: 'text',
              showEditPage: false,
              required: true,
              dataIndex: 'id',
              config: {
                type: 'text',
                value: '',
              },
              slots: {
                customRender: 'id',
              },
            },
            
             {
              align:'center',
              title: '活动名称',
              rowType: 'text',
              showEditPage: true,
              required: true,
              dataIndex: 'activity_name',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'activity_name',
              },
            },
             {
              align:'center',
              title: '汇总金额',
              rowType: 'text',
              showEditPage: false,
              required: true,
              dataIndex: 'sum_money',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'sum_money',
              },
            },
             {
              align:'center',
              title: '已领金额',
              rowType: 'text',
              showEditPage: false,
              required: true,
              dataIndex: 'receive_money',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'receive_money',
              },
            },
             {
              align:'center',
              title: '红包数量',
              rowType: 'text',
              showEditPage: false,
              required: true,
              dataIndex: 'sum_redpacket',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'sum_redpacket',
              },
            },
             {
              align:'center',
              title: '已领红包',
              rowType: 'text',
              showEditPage: false,
              required: true,
              dataIndex: 'receive_redpacket',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'receive_redpacket',
              },
            },
             {
              align:'center',
              title: '结束时间',
              rowType: 'editColumns',
              ruleType:"text",
              showEditPage: true,
              required: true,
              dataIndex: 'end_time',
              config: {
                isEdit:true,
                type: 'datetimeAdd',
              },
              slots: {
                customRender: 'end_time',
              },
            },
            {
              align:'center',
              title: '红包状态',
              ruleType: 'number',
              rowType: 'button',
              showEditPage: false,
              ellipsis:true,
              required: true,
              dataIndex: 'state',
              config: {
                isEdit: true,
                type: 'button',
                buttonBg: 'red',
                enumType: 'state__7',
                defaultValue: 0,
                value: '',
              },
              slots: {
                customRender: 'state',
              },
            },
            {
              align:'center',
              key: 'note',
              title: '备注',
              dataIndex: 'note',
              required: false,
              ellipsis:true,
              rowType: 'editColumns',
              showEditPage: true,
              config: {
                isEdit: true,
                orderBy:"is_activate",
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
              title: '激活状态',
              ruleType: 'number',
              rowType: 'button',
              showEditPage: false,
              required: true,
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
                  text: '导出订单',
                  clickType: 'custom',
                  clickEvent: 'custom_export',
                  ajaxInterface: 'redpacket',
                  params:{
                    redpacketactivity_id:"id",
                  },
                  extData:{}
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
        },
      }
    },
    mounted() {
      let otherCol = redPacket.data().tableMessage.tableData.concat(redPacket.data().tableMessage.description)
      let temp = this.tableMessage.tableData.find(x=>x.dataIndex=='operation')
      temp.operationList[0].extData = otherCol
    },
  }
</script>
