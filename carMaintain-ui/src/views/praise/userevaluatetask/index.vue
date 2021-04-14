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
            autoWidth: false, //平均分每列宽度
            ajaxInterface: 'userevaluatetask', //接口
            openType: 'modal', //打开编辑或者添加的模式为 弹窗或者页面 "modal" ||"page"
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
                    key: 'item_name',
                    value: '商品名',
                    inputType: 'text',
                    inputValue: '',
                  },
                  {
                    key: 'task_id',
                    value: '任务ID',
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
                {
                  selectKey: '提现状态',
                  selectType: 'refund_state__1',
                  selectValue: '全部',
                },
                {
                  selectKey: '提交状态',
                  selectType: 'state__5',
                  selectValue: '全部',
                },
              ],
            },
            operationConfig: [
              {
                type: 'export',
                role:[201,301,302],
                float: 'right',
                icon: 'ri-close-line',
                clickEvent: 'exportData',
                extData: [],
              },
            ]
          },
          tableData: [
            
            {
              align:'center',
              title: '时间',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'create_time',
              config: {
                type: 'datetime',
                value: '',
              },
              slots: {
                customRender: 'create_time',
              },
            },
            
            // {
            //   align:'center',
            //   title: '公众号',
            //   rowType: 'text',
            //   showEditPage: false,
            //   required: true,
            //   dataIndex: 'nick_name',
            //   config: {
            //     type: 'text',
            //   },
            //   slots: {
            //     customRender: 'nick_name',
            //   },
            // },
            {
              align:'center',
              title: '店铺',
              rowType: 'number',
              ruleType:"number",
              showEditPage: true,
              required: true,
              dataIndex: 'shop_name',
              width:100,
              config: {
                displayItem: ['item_name'], //选择完之后显示谁！以这个属性判断某个属性是否需要与其联动！
                changeRequestAPI: { item_name: 'itemapi' }, //下拉改变时，数据也以这个名字存放在store、enum的地方
                type: 'select',
                enumType: 'shopapi',
                requestKey: 'shop_id',
                value: '',
              },
              slots: {
                customRender: 'shop_name',
              },
            },
            {
              align:'center',
              title: '商品',
              rowType: 'number',
              ruleType:'number',
              showEditPage: true,
              required: true,
              dataIndex: 'item_name',
              width:100,
              sliceNum:5,
              config: {
                hidden: true, //是否显示,true=>隐藏 else false =>显示
                type: 'select',
                enumType: 'itemapi',
                requestKey: 'item_id',
                value: '',
              },
              slots: {
                customRender: 'item_name',
              },
            },
            {
              align:'center',
              title: '任务ID',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'evaluate_task_id',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'evaluate_task_id',
              },
            },
            {
              align:'center',
              title: '用户',
              rowType: 'text',
              showEditPage: true,
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
              title: 'openid',
              rowType: 'text',
              showEditPage: false,
              width:120,
              required: true,
              dataIndex: 'openid',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'openid',
              },
            },
            {
              align:'center',
              title: '买家昵称',
              rowType: 'text',
              showEditPage: true,
              dataIndex: 'buyer_nick',
              config: {
                type: 'textarea',
                placeholder:"一行一个买家昵称",
                orderBy:"commission",
              },
              slots: {
                customRender: 'buyer_nick',
              },
            },
            {
              align:'center',
              title: '单号',
              rowType: 'text',
              showEditPage: true,
              required: true,
              dataIndex: 'unit_num',
              config: {
                type: 'textarea',
              },
              slots: {
                customRender: 'unit_num',
              },
            },
            {
              align:'center',
              title: '佣金',
              rowType: 'text',
              showEditPage: true,
              required: true,
              dataIndex: 'commission',
              config: {
                type: 'text',
                orderBy:"superaddition_comments"
              },
              slots: {
                customRender: 'commission',
              },
            },
            {
              align:'center',
              title: '提现状态',
              ruleType: 'number',
              rowType: 'button',
              showEditPage: false,
              required: true,
              dataIndex: 'refund_state',
              config: {
                isEdit: false,
                type: 'button',
                width: '150',
                size: 'default',
                noStyle:true,
                buttonBg: 'green',
                enumType: 'refund_state__1',
                defaultValue: 0,
                value: '',
              },
              slots: {
                customRender: 'refund_state',
              },
            },
            {
              align:'center',
              title: '状态',
              ruleType: 'number',
              rowType: 'select',
              showEditPage: false,
              required: true,
              dataIndex: 'state',
              config: {
                isEdit: true,
                type: 'select',
                width: '150',
                size: 'default',
                buttonBg: 'green',
                enumType: 'state__5',
                defaultValue: 0,
                value: '',
              },
              slots: {
                customRender: 'state',
              },
            },
            {
              align:'center',
              title: '评价',
              dataIndex: 'high_praise',
              ruleType: 'string', //编辑时的类型
              rowType: 'img',
              showEditPage: false,
              required: true,
              config: {
                type: 'img',
                width: 30,
                height: 30,
              showImgTip:true,
                clickEvent: 'showImg',
                uploadUrl: '/uploadpictures',
                fileList: [],
                previewVisible: false,
                previewImage: '',
                accept: 'image/png,image/jpg,image/jpeg',
              },
              slots: {
                customRender: 'high_praise',
              },
            },
            {
              align:'center',
              title: '追评',
              dataIndex: 'add_high_praise',
              ruleType: 'string', //编辑时的类型
              rowType: 'img',
              showEditPage: false,
              required: true,
              config: {
                type: 'img',
                width: 30,
                height: 30,
              showImgTip:true,
                clickEvent: 'showImg',
                uploadUrl: '/uploadpictures',
                fileList: [],
                previewVisible: false,
                previewImage: '',
                accept: 'image/png,image/jpg,image/jpeg',
              },
              slots: {
                customRender: 'add_high_praise',
              },
            },
            {
              align:'center',
              title: 'IP',
              rowType: 'text',
              showEditPage: true,
              required: false,
              dataIndex: 'ip',
              config: {
                type: 'textarea',
              },
              slots: {
                customRender: 'ip',
              },
            },
            {
              align:'center',
              title: '过期时间',
              rowType: 'text',
              showEditPage: true,
              required: false,
              dataIndex: 'task_time',
              config: {
                type: 'textarea',
              },
              slots: {
                customRender: 'task_time',
              },
            },
            {
              align:'center',
              title: '备注',
              dataIndex: 'note',
              required: false,
              width:100,
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
            // {
            //   align:'center',
            //   // fixed: 'right',
            //   title: '操作',
            //   width: 150,
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
        },
      }
    },
  }
</script>
