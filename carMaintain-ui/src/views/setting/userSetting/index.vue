<template>
    <div>
        <a-tabs>
            <a-tab-pane v-for="(Pitem,index) in panel" :key="index">
                <template #tab>
                    <span>
                        {{Pitem.panelName}}
                    </span>
                </template>
                <a-form ref="ruleForm" :rules="rules" autocomplete="off" :model="columnsValue" :label-col="labelCol" :wrapper-col="wrapperCol">
                    <div v-for="(col,colIndex) in Pitem.panelContain" :key="colIndex">
                        <div v-if="col.config && !col.config.hidden">
                            <!-- 普通输入框 -->
                            <a-form-item v-if="col.config.type=='text'|| col.config.type=='password' || !col.config.type" :required="col.required" :ref="col.dataIndex" :label="col.title" :name="col.dataIndex">
                                <a-input v-model:value="columnsValue[col.dataIndex]" :type="col.config.type?col.config.type:'text'" :style="{'width':col.config.width?col.config.width+'px':null}" :name="col.config.type=='password'?'new-password':''" :disabled="col.config.disabled?true:false" @blur="inputchange(col)" />
                            </a-form-item>

                            <!-- 多行输入框 -->
                            <a-form-item v-if="col.config.type=='textarea'" :required="col.required" :ref="col.dataIndex" :label="col.title" :name="col.dataIndex">
                                <a-textarea
                                    v-model:value="columnsValue[col.dataIndex]"
                                    @blur="inputchange(col)"
                                    :auto-size="col.config.textareaConfig?col.config.textareaConfig:{ minRows: 3, maxRows: 5 }"
                                />
                            </a-form-item>
                            
                            <!-- 数字输入框 -->
                            <a-form-item v-if="col.config.type=='number'" :required="col.required?true:undefined" :ref="col.dataIndex" :label="col.title" :name="col.dataIndex">
                                <a-input-number :min="col.config.min" :step="col.config.double?0.1:1"  :style="{'width':'200px'}" :max="col.config.max" v-model:value="columnsValue[col.dataIndex]" @blur="inputchange(col)" />

                                <a-button v-if="col.config.showGetItem" @click="getiteminfo(col.dataIndex,columnsValue[col.dataIndex])" style="margin-left: 15px;" type="primary" :loading="getiteminfoLoading">
                                    获取数据
                                </a-button>

                                <a-tooltip v-if="!col.config.dontShowQuestion" placement="right" :title="col.config.question?col.config.question:col.title">
                                    <QuestionCircleOutlined class="questionIcon" />
                                </a-tooltip>
                            </a-form-item>

                            <!-- 下拉选择框 -->
                            <a-form-item v-else-if="col.config.type=='select'" :required="col.required?true:undefined" :label="col.title" :name="col.config.requestKey || col.dataIndex">
                                <a-select v-model:value="col.config.value" showSearch allowClear placeholder="全部" @change="inputchange(col,colIndex)">
                                    <a-select-option :value="selectItem" v-for="(selectItem,selectIndex) in enumObj.Enum.enumType[col.config.enumType]" :key="selectIndex">
                                        {{selectItem}}
                                    </a-select-option>
                                </a-select>
                            </a-form-item>

                            <!-- 多选框 -->
                            <a-form-item v-else-if="col.config.type=='switch'" :required="col.required" :label="col.title" :name="col.dataIndex" @change="inputchange(col)">
                                <a-checkbox-group v-model:value="col.config.value">
                                    <a-checkbox :value="i" v-for="(k,i) in enumObj.Enum.enumType[col.config.enumType]" :key="i">
                                        {{k}}
                                    </a-checkbox>
                                </a-checkbox-group>
                            </a-form-item>

                            <!-- 单选框 -->
                            <a-form-item v-else-if="col.config.type=='button'" :required="col.required" :label="col.title" :name="col.dataIndex">
                                <a-radio-group v-model:value="col.config.value" @change="inputchange(col)">
                                    <a-radio :value="selectItem" v-for="(selectItem,selectIndex) in enumObj.Enum.enumType[col.config.enumType]" :key="selectIndex">
                                        {{selectItem}}
                                    </a-radio>
                                </a-radio-group>
                                <a-tooltip v-if="!col.config.dontShowQuestion" placement="right" :title="col.config.question?col.config.question:col.title">
                                    <QuestionCircleOutlined class="questionIcon" />
                                </a-tooltip>
                            </a-form-item>

                            <!-- 日期选择 -->
                            <a-form-item v-else-if="col.config.type=='date'" :required="col.required" :label="col.title" :name="col.dataIndex">
                                <a-date-picker v-model:value="columnsValue[col.dataIndex]" type="date" placeholder="选择日期" style="width: 100%;" @change="dateOK(col)" />
                            </a-form-item>

                            <!-- 时间选择 -->
                            <a-form-item v-else-if="col.config.type=='datetime'" :required="col.required" :label="col.title" :name="col.dataIndex">
                                <a-date-picker show-time v-model:value="columnsValue[col.dataIndex]" type="datetime" placeholder="选择时间" style="width: 100%;" @change="inputchange(col)" @ok="dateOK(col)" />
                            </a-form-item>
                        </div>
                    </div>
                </a-form>
            </a-tab-pane>
            <template #tabBarExtraContent>
                <a-button style="width:200px;margin-bottom: 50px;" @click="submitChange" type="primary">提交修改</a-button>
            </template>
        </a-tabs>
    </div>
</template>

<script>
import {
    AppleOutlined,
    AndroidOutlined,
    QuestionCircleOutlined
} from '@ant-design/icons-vue';
import {
    getList,
    addData,
} from '@/api/table'
export default {
    data() {
        return {
            enumObj: require('@/utils/enum.js').default,
            rules:{},
            columnsValue: {},
            labelCol: {
                span: 2
            },
            wrapperCol: {
                span: 10
            },
            panel: [
                {
                    panelName: "我的配置",
                    panelContain: [
                        {
                            title: '每日提现次数',
                            showEditPage: true,
                            ruleType: "number", //编辑时的类型
                            required: true,
                            dataIndex: 'withd_count',
                            config: {
                                question:"每日提现次数",
                                type: "number",
                                width: "100",
                                size: "default",
                                min: 0,
                                max: 10,
                            },
                        },
                        {
                            title: '订单过期天数',
                            showEditPage: true,
                            ruleType: "number", //编辑时的类型
                            required: true,
                            dataIndex: 'order_exp_days',
                            config: {
                                type: "number",
                                width: "100",
                                size: "default",
                                min: 0,
                                max: 1000,
                            },
                        },
                        {
                            title: '最大红包金额',
                            showEditPage: true,
                            ruleType: "number", //编辑时的类型
                            required: true,
                            dataIndex: 'max_money',
                            config: {
                                type: "number",
                                width: "100",
                                size: "default",
                                min: 0,
                                max: 5000,
                            },
                        },
                        {
                            title: '提现提交订单',
                            showEditPage: false,
                            required:true,
                            dataIndex: 'sub_tid',
                            ruleType:"number",
                            config: {
                                type: "button",
                                enumType:"sub_tid",
                                value: ""
                            },
                        },
                         {
                            title: '红包链接图片',
                            showEditPage: false,
                            required:true,
                            dataIndex: 'red_packet_type',
                            ruleType:"number",
                            config: {
                                type: "button",
                                enumType:"red_packet_type",
                                value: ""
                            },
                        },
                        {
                            title: '淘客订单提交',
                            showEditPage: false,
                            required:true,
                            dataIndex: 'is_taoke_sub',
                            ruleType:"number",
                            config: {
                                type: "button",
                                enumType:"is_taoke_sub",
                                value: ""
                            },
                        },
                        {
                            title: '自动结算',
                            showEditPage: false,
                            required:true,
                            dataIndex: 'is_autoclear',
                            ruleType:"number",
                            config: {
                                type: "button",
                                enumType:"is_autoclear",
                                value: ""
                            },
                        },
                        {
                            title: '红包过期分钟',
                            showEditPage: true,
                            ruleType: "number", //编辑时的类型
                            required: true,
                            dataIndex: 'hb_exp_min',
                            config: {
                                type: "number",
                                width: "100",
                                size: "default",
                                min: 0,
                                max: 600,
                            },
                        },
                    ]
                },
                // {
                //     panelName: "公众号配置",
                //     panelContain:[]
                // },
                // {
                //     panelName: "商户号配置",
                //     panelContain: [
                //     ]
                // },
            ],
            keyupEvent:function(){},
        }
    },
    mounted() {
        getList("customersettings").then(res=>{
            if(res.data){
                for(var key in res.data){
                    if(res.data[key]!==undefined){
                        this.columnsValue[key] = res.data[key]
                    }else{
                        this.columnsValue[key] = ""
                    }
                }
                this.init();
            }
        })
    },
    methods: {
        
        init() {
            this.enumObj = require('@/utils/enum.js').default
            this.columns = this.panel[0].panelContain
            this.handleData();
            if(window.onkeyup){
                this.keyupEvent = window.onkeyup;
                window.onkeyup = null;
            }
        },
        //以下内容待整合！！！
        handleData() {
            for (let i = 0; i < this.columns.length; i++) {
                let item = this.columns[i];
                try {
                    if(this.columns[i].config.enumType){
                        this.columns[i].config.value = this.enumObj.Enum.enumType[item.config.enumType][this.columnsValue[item.dataIndex]]
                    }
                } catch (e) {
                    console.error("枚举值匹配错误！！请检查这个值是否存在枚举类当中！       ", item.config.enumType);
                    this.$message.error("枚举值匹配错误！！请检查这个值是否存在枚举类当中！       ", item.config.enumType);
                }
                //增加输入规则
                if (item.required) {
                    this.rules[item.config.requestKey || item.dataIndex] = [];
                    if(item.config.type === "number"){
                        item.ruleType = 'number'
                    }
                    if(item.ruleType ==='text'){
                        item.ruleType = 'string'
                    }else if(item.config.type === "button" || item.config.type === "select"){
                        item.ruleType = 'number'
                    }
                    let tempObj = {
                        type: item.ruleType || "string",
                        required: item.required,
                        message: item.title + "的值不合法",
                        trigger: 'blur'
                    };
                    //文件自定义校验方式
                    if(item.ruleType==='file'){
                        delete tempObj.type;
                        tempObj.validator = async (rule, value, callback) => {
                            if (!value) {
                                return Promise.reject('请上传文件');
                            }
                            return Promise.resolve();
                        }
                    }
                    this.rules[item.config.requestKey || item.dataIndex].push(tempObj)
                    if (item.min) {
                        this.rules[item.dataIndex].push({
                            type: item.config.type || "string",
                            min: item.min,
                            message: '最小为' + item.min,
                            trigger: 'change'
                        })
                    }
                    if (item.max) {
                        this.rules[item.dataIndex].push({
                            max: item.max,
                            message: '最大为' + item.max,
                            trigger: 'change'
                        })
                    }
                }
            }
        },
        inputchange(item, itemIndex) {
            if (item.config.type == "button" || item.config.type == "select") {
                this.columnsValue[item.config.requestKey || item.dataIndex] = item.config.value ? parseInt(this.enumObj.Enum.parseEnum(item.config.enumType, item.config.value)) : "";
                if (item.config.displayItem && item.config.value) {
                    this.addPublicData(item);
                }
                //清空的时候
                if(!item.config.value && item.config.displayItem){
                    for (let i = 0; i < this.columns.length; i++) {
                        let displayItemIndex = item.config.displayItem.indexOf(this.columns[i].dataIndex);
                        if(displayItemIndex !=-1){
                            this.columns[i].config.hidden = true;
                            break;
                        }
                    }
                }
            }
            if (item.config.type == "img") {
                this.columnsValue[item.dataIndex] = item.config.fileList[0].response.data.img_key;
            }
            if (item.config.type == "date" || item.config.type == "datetime") {
                if (!this.columnsValue[item.dataIndex]) {
                    this.columnsValue[item.dataIndex] = ""
                }
            }
            if (item.config.type == 'switch') {
                this.columnsValue[item.dataIndex] = item.config.value
            }
            console.log("输入框变动，此时的提交表单", this.columnsValue)
        },
        submitChange(){
            addData("customersettings",this.columnsValue).then(res=>{
                this.$message.success("修改成功！")
            })
        },
        beforeRouteLeave (to, from, next) {
            window.onkeyup = this.keyupEvent;
            next();
        }
    },
    components: {
        AppleOutlined,
        AndroidOutlined,
        QuestionCircleOutlined
    },
};
</script>
<style>
.questionIcon{
    margin-left:20px;font-size:16px
}
</style>