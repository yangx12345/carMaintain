<template>
<ATable :tableMessage="tableMessage"></ATable>
</template>

<script>
import ATable from '@/components/tableComponent.vue'
export default {
    components: {
        ATable
    },
    data() {
        return {
            tableMessage: {
                config: { //总配置
                    searchConfig: { //搜索配置
                        searchDate: true, //是否显示事件
                        isToday: false, //是否是今天
                        selectInput: { //带输入框的下拉框配置
                            width: 200,
                            options: [{
                                key: 'uuid',
                                value: '做单用户',
                                inputType: 'number',
                                inputValue: ""
                            }],
                        },
                    },
                    operationConfig: [ //操作栏配置
                        // {
                        //     type: 'normal',
                        //     text: "用户查询",
                        //     float: "left",
                        //     icon: 'ri-close-line',
                        //     ajaxInterface: "user",
                        //     clickEvent: "blacklist",
                        //     ajaxMethod: "POST",
                        //     extData: [{
                        //             title: '状态',
                        //             ruleType: "number",
                        //             required: true,
                        //             dataIndex: 'is_black',
                        //             rowType: "button",
                        //             showEditPage: true,
                        //             config: {
                        //                 isEdit: true,
                        //                 type: "button",
                        //                 width: "150",
                        //                 size: "default",
                        //                 buttonBg: "green",
                        //                 enumType: "is_black__1",
                        //                 defaultValue: 0,
                        //                 value: "",
                        //             },
                        //         },
                        //         {
                        //             title: '用户',
                        //             showEditPage: true,
                        //             ruleType: "number", //编辑时的类型
                        //             required: true,
                        //             rowType: "editColumns",
                        //             dataIndex: 'uuid',
                        //             config: {
                        //                 type: "number",
                        //                 width: "100",
                        //                 size: "default",
                        //                 // min: 0,
                        //                 // max: 1000,
                        //             },
                        //         },
                        //         {
                        //             title: '几级',
                        //             showEditPage: true,
                        //             ruleType: "number", //编辑时的类型
                        //             required: true,
                        //             rowType: "editColumns",
                        //             dataIndex: 'level',
                        //             config: {
                        //                 isEdit: false, //是否可以修改
                        //                 type: "number",
                        //                 width: "100",
                        //                 size: "default",
                        //                 min: 0,
                        //                 max: 1000,
                        //             },
                        //         },
                        //         {
                        //             key: "mobile",
                        //             title: '备注',
                        //             rowType: "text",
                        //             showEditPage: true,
                        //             ruleType: "text", //编辑时的类型
                        //             dataIndex: 'note',
                        //             config: {
                        //                 type: "text"
                        //             },
                        //         },
                        //     ]
                        // },
                        {
                            type: 'export',
                            float: "right",
                            icon: 'ri-close-line',
                            clickEvent: "exportData",
                        }
                    ],
                    autoWidth: false, //平均分每列宽度
                    ajaxInterface: "userinfo", //接口
                    openType: "modal", //打开编辑或者添加的模式为 弹窗或者页面 "modal" ||"page"
                },
                tableData: [{
                        title: '时间',
                        key: "create_time",
                        rowType: "text",
                        showEditPage: false,
                        dataIndex: 'create_time',
                        slots: {
                            customRender: 'create_time'
                        },
                    },
                    {
                        title: '用户',
                        rowType: "text",
                        showEditPage: false,
                        dataIndex: 'user_id',
                        slots: {
                            customRender: 'user_id'
                        },
                    },
                    {
                        title: '昨单',
                        rowType: "text",
                        showEditPage: false,
                        dataIndex: 'yester_count',
                        slots: {
                            customRender: 'yester_count'
                        },
                    },
                    {
                        title: '今单',
                        rowType: "text",
                        showEditPage: false,
                        dataIndex: 'today_count',
                        slots: {
                            customRender: 'today_count'
                        },
                    },
                    {
                        title: '周单',
                        rowType: "text",
                        showEditPage: false,
                        dataIndex: 'week_count',
                        slots: {
                            customRender: 'week_count'
                        },
                    },
                    {
                        title: '月单',
                        rowType: "text",
                        showEditPage: false,
                        dataIndex: 'month_count',
                        slots: {
                            customRender: 'month_count'
                        },
                    },
                    {
                        title: '总单量',
                        rowType: "text",
                        showEditPage: false,
                        dataIndex: 'sum_count',
                        slots: {
                            customRender: 'sum_count'
                        },
                    },
                    {
                        title: '今日领取次数',
                        rowType: "text",
                        showEditPage: false,
                        dataIndex: 'today_query_count',
                        slots: {
                            customRender: 'today_query_count'
                        },
                    },
                    {
                        title: '一周领取次数',
                        rowType: "text",
                        showEditPage: false,
                        dataIndex: 'week_query_count',
                        slots: {
                            customRender: 'week_query_count'
                        },
                    },
                    {
                        title: '一月领取次数',
                        rowType: "text",
                        showEditPage: false,
                        dataIndex: 'month_query_count',
                        slots: {
                            customRender: 'month_query_count'
                        },
                    },
                ]
            }
        }
    }
};
</script>
