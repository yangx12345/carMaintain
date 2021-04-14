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
                  key: 'nick_name',
                  value: '微信公众号',
                  inputType: 'text',
                  inputValue: '',
                },
              ],
            },
            autoWidth: true, //平均分每列宽度
            ajaxInterface: 'wechatpub', //接口
            openType: 'modal', //打开编辑或者添加的模式为 弹窗或者页面 "modal" ||"page"
          },
          tableData: [
            {
              align:'center',
              title: '公众昵称',
              rowType: 'text',
              showEditPage: true,
              required: true,
              dataIndex: 'nick_name',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'nick_name',
              },
            },
            {
              align:'center',
              title: '头像',
              dataIndex: 'head_img',
              ruleType: 'string', //编辑时的类型
              rowType: 'img',
              showEditPage: true,
              required: true,
              config: {
                type: 'img',
                width: 60,
                height: 60,
                clickEvent: 'showImg',
                uploadUrl: '/uploadpictures',
                fileList: [],
                previewVisible: false,
                previewImage: '',
                accept: 'image/png,image/jpg,image/jpeg',
              },
              slots: {
                customRender: 'head_img',
              },
            },
            {
              align:'center',
              title: '公众号类型',
              rowType: 'text',
              showEditPage: true,
              required: true,
              ruleType:"number",
              dataIndex: 'service_type_info',
              config: {
                type: 'number',
              },
              slots: {
                customRender: 'service_type_info',
              },
            },
            {
              align:'center',
              title: '认证类型',
              rowType: 'text',
              showEditPage: true,
              required: true,
              ruleType:"number",
              dataIndex: 'verify_type_info',
              config: {
                type: 'number',
              },
              slots: {
                customRender: 'verify_type_info',
              },
            },
            {
              align:'center',
              title: '原始 ID',
              rowType: 'text',
              showEditPage: true,
              required: true,
              dataIndex: 'user_name',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'user_name',
              },
            },
            {
              align:'center',
              title: 'authorizer_appid',
              rowType: 'text',
              showEditPage: true,
              required: true,
              dataIndex: 'authorizer_appid',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'authorizer_appid',
              },
            },
            {
              align:'center',
              title: 'authorizer_refresh_token',
              rowType: 'text',
              showEditPage: true,
              required: true,
              dataIndex: 'authorizer_refresh_token',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'authorizer_refresh_token',
              },
            },
            {
              align:'center',
              title: '主体名称',
              rowType: 'text',
              showEditPage: true,
              required: true,
              dataIndex: 'principal_name',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'principal_name',
              },
            },
            {
              align:'center',
              title: '公众微信号',
              rowType: 'text',
              showEditPage: true,
              required: true,
              dataIndex: 'alias',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'alias',
              },
            },
            {
              align:'center',
              title: '开通状况',
              rowType: 'text',
              showEditPage: true,
              required: true,
              dataIndex: 'business_info',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'business_info',
              },
            },
            {
              align:'center',
              title: '公众二维码',
              dataIndex: 'qrcode_url',
              ruleType: 'string', //编辑时的类型
              rowType: 'img',
              showEditPage: true,
              required: true,
              config: {
                type: 'img',
                width: 60,
                height: 60,
                clickEvent: 'showImg',
                uploadUrl: '/uploadpictures',
                fileList: [],
                previewVisible: false,
                previewImage: '',
                accept: 'image/png,image/jpg,image/jpeg',
              },
              slots: {
                customRender: 'qrcode_url',
              },
            },
            {
              align:'center',
              title: '权限集',
              rowType: 'text',
              showEditPage: false,
              dataIndex: 'func_info',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'func_info',
              },
            },
             {
               align:'center',
              title: '邮箱',
              rowType: 'text',
              showEditPage: true,
              required: true,
              dataIndex: 'email',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'email',
              },
            },
             {
               align:'center',
              title: '密码',
              rowType: 'text',
              showEditPage: true,
              required: true,
              dataIndex: 'password',
              config: {
                type: 'text',
              },
              slots: {
                customRender: 'password',
              },
            },
             {
               align:'center',
              title: 'openid',
              rowType: 'text',
              showEditPage: true,
              required: true,
              width:120,
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
              title: '激活状态',
              ruleType: 'number',
              rowType: 'button',
              showEditPage: true,
              required: true,
              dataIndex: 'is_activate',
              config: {
                isEdit: false,
                type: 'button',
                orderBy:"code",
                width: '150',
                noStyle:true,
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
            //   align:'center',
            //   key: 'operation',
            //   // fixed: 'right',
            //   title: '操作',
            //   rowType: 'operation',
            //   dataIndex: 'operation',
            //   operation: true,
            //   operationList: [
                //操作列表（按钮啥的）
                // {
                //   text: '编辑',
                //   clickType: 'edit',
                //   clickEvent: 'editRow',
                // },
                // {
                //   text: '删除',
                //   clickType: 'delete',
                //   clickEvent: 'onDelete',
                //   title: '确定要删除此条信息吗？？',
                // },
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
