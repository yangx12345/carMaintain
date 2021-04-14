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
                    key: 'item_name',
                    value: '商品',
                    inputType: 'text',
                    inputValue: '',
                  },
                  {
                    key: 'num_iid',
                    value: '商id',
                    inputType: 'number',
                    inputValue: '',
                  },
                  // {
                  //   key: 'itemsame_num_iid',
                  //   value: '同类商品id',
                  //   inputType: 'number',
                  //   inputValue: '',
                  // },
                ],
              },
              select: [
                {
                  //下拉框配置
                  selectKey: '打标状态',
                  selectType: 'is_mark_success',
                  selectValue: '全部',
                },
              ],
            },
            operationConfig: [
               {
                type: 'normal',
                text: '淘宝打标',
                float: 'left',
                icon: 'ri-close-line',
                ajaxInterface: 'mark',
                clickEvent: 'blacklist',
                ajaxMethod: 'POST',
                role:[201,301,302],
                extData: [
                  {
                    title: '关键词',
                    showEditPage: true,
                    required: true,
                    ruleType:"text",
                    dataIndex: 'kd',
                    config: {
                      type: 'text',
                      placeholder:"输入关键词",
                    },
                  },
                  {
                    title: '商品链接',
                    showEditPage: true,
                    required: true,
                    ruleType:"text",
                    dataIndex: 'num_iid',
                    config: {
                      type: 'text',
                      placeholder:"商品的链接地址，电脑端的链接",
                    },
                  },
                  {
                    title: '买家昵称',
                    showEditPage: true,
                    required: true,
                    dataIndex: 'buyer_nick',
                    config: {
                      type: 'textarea',
                      placeholder:"一行一个买家昵称",
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
            ajaxInterface: 'taobaomark', //接口
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
                type: 'number',
              },
              slots: {
                customRender: 'shop_name',
              },
            },
            {
              align:'center',
              title: '商品',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'item_name',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'item_name',
              },
            },
            {
              align:'center',
              title: '同类商品',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'itemsame_name',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'itemsame_name',
              },
            },
            {
              align:'center',
              title: '商品ID',
              rowType: 'text',
              ruleType:"number",
              required: true,
              dataIndex: 'num_iid',
              showEditPage:true,
              config: {
                type: 'number',
                width:"200",
                clickEvent:"openPage",
                openPageName:"https://detail.tmall.com/item.htm?",
                paramName:["id"],
                paramValue:["num_iid"],
                showGetItem:true,
              },
              slots: {
                customRender: 'num_iid',
              },
            },
            {
              align:'center',
              title: '买家昵称',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'buyer_nick',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'buyer_nick',
              },
            },
            {
              align:'center',
              title: '关键词',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'kd',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'kd',
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
                noStyle:true,
                buttonBg: 'green',
                enumType: 'is_success',
                defaultValue: 0,
                value: '',
              },
              slots: {
                customRender: 'is_success',
              },
            },
            {
              align:'center',
              title: '打标状态',
              ruleType: 'number',
              rowType: 'button',
              showEditPage: true,
              dataIndex: 'is_mark_success',
              config: {
                isEdit: false,
                type: 'button',
                width: '150',
                size: 'default',
                noStyle:true,
                buttonBg: 'green',
                enumType: 'is_mark_success',
                defaultValue: 0,
                value: '',
              },
              slots: {
                customRender: 'is_mark_success',
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
