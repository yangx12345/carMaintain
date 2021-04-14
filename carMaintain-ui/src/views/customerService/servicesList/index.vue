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
              selectInput: {
                //带输入框的下拉框配置
                width: 200,
                options: [
                  {
                      key: 'service_name',
                      value: '客服名',
                      inputType: 'text',
                      inputValue: '',
                  },
                  {
                      key: 'mobile',
                      value: '手机号',
                      inputValue: '',
                      inputType: 'number',
                  },
                ],
              },
              select: [
                 {
                  selectKey: '角色',
                  selectType: 'role__2',
                  selectValue: '全部',
                },
              ],
            },
            operationConfig: [
              //操作栏配置
              {
                text:"添加客服",
                type: 'normal',
                icon: 'ri-close-line',
                ajaxInterface: 'service',
                clickEvent: 'blacklist',
                ajaxMethod: 'POST',
                extData: [
                  {
                    title: '手机号',
                    showEditPage: true,
                    ruleType: 'text', //编辑时的类型
                    required: true,
                    rowType: 'editColumns',
                    dataIndex: 'mobile',
                    config: {
                      type: 'text',
                    },
                  },
                  {
                    title: '客服名',
                    showEditPage: true,
                    ruleType: 'text', //编辑时的类型
                    required: true,
                    rowType: 'editColumns',
                    dataIndex: 'service_name',
                    config: {
                      type: 'text',
                    },
                  },
                  {
                    title: '密码',
                    showEditPage: true,
                    ruleType: 'text', //编辑时的类型
                    required: true,
                    rowType: 'editColumns',
                    dataIndex: 'password',
                    config: {
                      type: 'text',
                    },
                  },     
                    {
                      title: '角色',
                      ruleType: 'number',
                      rowType: 'button',
                      showEditPage: true,
                      required:true,
                      dataIndex: 'role',
                      config: {
                        type: 'button',
                        width: '150',
                        size: 'default',
                        enumType: 'role__2',
                        defaultValue: 302,
                        value: '',
                        orderBy:"hb_max_money",
                      },
                    },  
                    // {
                    //   align:'center',
                    //   title: '验证IP',
                    //   ruleType: 'number',
                    //   rowType: 'button',
                    //   showEditPage: true,
                    //   dataIndex: 'check_ip',
                    //   config: {
                    //     isEdit: false,
                    //     type: 'button',
                    //     width: '150',
                    //     size: 'default',
                    //     enumType: 'check_ip',
                    //     defaultValue: 0,
                    //     value: '',
                    //   },
                    //   slots: {
                    //     customRender: 'check_ip',
                    //   },
                    // },
                    {
                      align:'center',
                      title: '日红包数',
                      rowType: 'text',
                      showEditPage: true,
                      dataIndex: 'hb_count',
                      config: {
                        type: 'number',
                        defaultValue:100,
                      },
                      slots: {
                        customRender: 'hb_count',
                      },
                    },
                    {
                      align:'center',
                      title: '红包最大金额',
                      rowType: 'text',
                      showEditPage: true,
                      dataIndex: 'hb_max_money',
                      config: {
                        type: 'number',
                        defaultValue:200,
                      },
                      slots: {
                        customRender: 'hb_max_money',
                      },
                    },           
                ],
              },
              // {
              //   type: 'export',
              //   float: 'right',
              //   icon: 'ri-close-line',
              //   clickEvent: 'exportData',
              // },
            ],
            autoWidth: false, //平均分每列宽度
            ajaxInterface: 'service', //接口
            openType: 'modal', //打开编辑或者添加的模式为 弹窗或者页面 "modal" ||"page"
          },
          tableData: [
             {
               align:'center',
              title: '日期',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'create_date',
              sliceNum:0, //显示多长，0为显示所有，没有这个属性则按照默认数值截断
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
              title: '手机号',
              rowType: 'text',
              ruleType:"number",
              showEditPage: true,
              required:true,
              dataIndex: 'mobile',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'mobile',
              },
            },
            {
              align:'center',
              title: '客服名',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'service_name',
              config: {
                type: 'number',
              },
              slots: {
                customRender: 'service_name',
              },
            },
            {
              align:'center',
              title: '角色',
              ruleType: 'number',
              rowType: 'button',
              showEditPage: true,
              dataIndex: 'role',
              config: {
                isEdit: false,
                type: 'button',
                width: '150',
                noStyle:true,
                size: 'default',
                enumType: 'role__1',
                defaultValue: 0,
                value: '',
              },
              slots: {
                customRender: 'role',
              },
            },
            {
              align:'center',
              title: '验证IP',
              ruleType: 'number',
              rowType: 'button',
              showEditPage: true,
              dataIndex: 'check_ip',
              config: {
                isEdit: true,
                type: 'button',
                width: '150',
                size: 'default',
                buttonBg: 'green',
                enumType: 'check_ip',
                defaultValue: 1,
                value: '',
              },
              slots: {
                customRender: 'check_ip',
              },
            },
            {
              align:'center',
              title: '日红包数',
              rowType: 'editColumns',
              showEditPage: true,
              dataIndex: 'hb_count',
              config: {
                isEdit:true,
                type: 'number',
              },
              slots: {
                customRender: 'hb_count',
              },
            },
            {
              align:'center',
              title: '红包最大金额',
              rowType: 'editColumns',
              showEditPage: true,
              dataIndex: 'hb_max_money',
              config: {
                isEdit:true,
                type: 'double',
              },
              slots: {
                customRender: 'hb_max_money',
              },
            },
            // {
            //   title: '密码',
            //   rowType: 'text',
            //   showEditPage: false,
            //   dataIndex: 'password',
            //   config: {
            //     type: 'text',
            //   },
            //   slots: {
            //     customRender: 'password',
            //   },
            // },
            
            {
              align:'center',
              title: '最后登录时间',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'last_login',
              sliceNum:0, //显示多长，0为显示所有，没有这个属性则按照默认数值截断
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'last_login',
              },
            },
            {
              align:'center',
              title: '最后登录IP',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'last_login_ip',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'last_login_ip',
              },
            },
            {
              align:'center',
              title: '最后登录地址',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'real_addres_name',
              sliceNum:0, //显示多长，0为显示所有，没有这个属性则按照默认数值截断
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'real_addres_name',
              },
            },
            // {
            //   title: '随机数',
            //   rowType: 'text',
            //   showEditPage: false,
            //   dataIndex: 'rand_num',
            //   config: {
            //     type: 'text',
            //   },
            //   slots: {
            //     customRender: 'rand_num',
            //   },
            // },
            {
              title: '激活状态',
              ruleType: 'number',
              rowType: 'button',
              showEditPage: true,
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
            // {
            //   title: '逻辑删除',
            //   rowType: 'text',
            //   showEditPage: false,
            //   dataIndex: 'is_delete',
            //   config: {
            //     type: 'text',
            //   },
            //   slots: {
            //     customRender: 'is_delete',
            //   },
            // },
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
