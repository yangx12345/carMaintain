<template>
    <div :style="{'max-width':computedWidth(item)}" style="overflow: hidden;white-space: nowrap;text-overflow: ellipsis;display:inline-block" @click="clickItem(text,record,item)" :class="{'openPageStyle':item.config && item.config.clickEvent}">
        <a-tooltip v-if="item.config && item.config.showTaskTip" placement="top" v-model:visible="record[item.dataIndex+'ShowTip']" style="width:auto">
            <template #title v-if="$store.getters['customData/loadingSp']">
                <LoadingOutlined />
            </template>
            <template  #title v-else @mouseout="imageOut(record,item.dataIndex,text)">
                <p v-if="item.dataIndex==='buyer_nick'" class="tipContent">自动打标：<a-button size="small" type="primary" @click="action({text,item,record,interfaces:'automark',field:'buyer_nick'})">使用</a-button></p>
                <p v-if="item.dataIndex==='buyer_nick'" class="tipContent">订单信息：<a-button v-if="item.dataIndex==='buyer_nick'" size="small" type="primary" @click="action({text,item,record,interfaces:'querytidinfo',field:'buyer_nick'})">使用</a-button></p>
                <p v-if="item.dataIndex==='buyer_nick'" class="tipContent">查账号：<a-button v-if="item.dataIndex==='buyer_nick'" size="small" type="primary" @click="action({text,item,record,interfaces:'querbuyernick',field:'buyer_nick'})">使用</a-button></p>
                <p v-if="item.dataIndex==='tid'" class="tipContent">检测淘客：<a-button v-if="item.dataIndex==='tid'" size="small" type="primary" @click="action({text,item,record,interfaces:'checktaoke',field:'tid'})">使用</a-button></p>
                <p v-if="item.dataIndex==='tid'" class="tipContent">订单信息：<a-button v-if="item.dataIndex==='tid'" size="small" type="primary" @click="action({text,item,record,interfaces:'querytidinfo',field:'tid'})">使用</a-button></p>
                <p v-if="item.dataIndex==='mobile'" class="tipContent">查黑号：<a-button v-if="item.dataIndex==='mobile'" size="small" type="primary" @click="action({text,item,record,interfaces:'querymobile',field:'mobile'})">使用</a-button></p>
            </template>
            <span v-if="item.customData">{{item.customData}}</span>
            <span v-else @mouseover="imageOver(record,item.dataIndex,text)">{{text}}</span>
        </a-tooltip>
        <a-tooltip v-else placement="topLeft" :title="text">
            <span v-if="item.customData">{{item.customData}}</span>
            <span v-else>{{text}}</span>
        </a-tooltip>
        <ModalForAction ref="ModalForAction"></ModalForAction>
    </div>    
</template>
<script>
import {
    isChina
} from '@/utils/validate'
import {
    LoadingOutlined
} from '@ant-design/icons-vue';
import ModalForAction from './modalForAction.vue'
export default {
    name: 'normalRow',
    components: {
        ModalForAction,
        LoadingOutlined
    },
    props: {
        item: {
            type: [Array, Object],
            default: {}
        },
        record: {
            type: [Array, Object],
            default: {}
        },
        text: {
            type: [Array, Object,String,Number],
            default: ""
        },
        tableConfig:{
            type:[Object,Array],
            default:{},
        }
    },
    data(){
        return{
            isChina,
        }
    },
    created() {
    },
    methods: {
        imageOut(record,item,text){
            if(item.config && item.config.showImgTip && text){
                record[item.dataIndex+'ShowTip'] = false;
            }
            return false;
        },
        imageOver(record,item,text){
            if(item.config && text){
                record[item.dataIndex+'ShowTip'] = true;
            }
            return false;
        },
        action({text,field,record,interfaces,item}){
            const ext = {
                ajaxInterface: "mytask",
                ajaxMethod: "POST",
                clickEvent: "actionWhat",
                clickType: "custom",
                modalTitle: "操作列表",
                modalWidth: 1200,
                needCustomDisable: false,
                text: "操作",
                type: "normal",
            }
            this.$refs.ModalForAction.showModal({isAddData:true, modalTitle: ext.modalTitle, modalWidth: ext.modalWidth || 700, ajaxInterface: ext.ajaxInterface, ajaxMethod: ext.ajaxMethod || "POST",extData:{text, config:{interfaces,field},value:record,ext},config:{interfaces,field}});
            // record[item.dataIndex+'ShowTip'] = false;
        },
        clickItem(text,record,item){
            this.$emit('clickItem', text,record,item);
        },
        computedWidth(item){
            if(item.width){
                if(item.config && item.config.isEdit){
                    return item.width-40+"px";   
                }
                return item.width+"px";
            }
            if(item.title.indexOf('备注')!=-1){
                item.width = 120;
                return item.width+"px";
            }
            if(item.title.indexOf('关键')!=-1){
                item.width = 150;
                return 150+"px"
            }
            if(['店铺',"商品","商品ID"].includes(item.title)){
                item.width = 180;
                return 180+"px"
            }
            // if(!this.tableConfig.autoWidth){
            //     item.width = 200
            //     return 200+"px"
            // }
        }
    },
}
</script>
<style>
.tipContent{
    display: flex;
    justify-content: space-between;
}
</style>
