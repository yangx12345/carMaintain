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
              inputText: [
                {
                  key: 'service_name',
                  value: '客服名',
                  inputType: 'text',
                  inputValue: '',
                },
              ],
            },
            operationConfig: [
              {
                type: 'export',
                float: 'right',
                icon: 'ri-close-line',
                clickEvent: 'exportData',
              },
            ],
            autoWidth: true, //平均分每列宽度
            ajaxInterface: 'serviceloginrecord', //接口
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
              title: '客服',
              rowType: 'text',
              showEditPage: false,
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
              title: '登录IP',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'login_ip',
              sliceNum:0,
              config: {
                type: 'number',
              },
              slots: {
                customRender: 'login_ip',
              },
            },
            {
              align:'center',
              title: '登录地址',
              rowType: 'text',
              showEditPage: false,
              sliceNum:0, //显示多长，0为显示所有，没有这个属性则按照默认数值截断
              dataIndex: 'real_addres_name',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'real_addres_name',
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
