<template>
    <div>
        <a-card style="width: 800px">
            余额提现说明： <br>
            1、提现只能提现到实名认证人名下支付宝内。 <br>
            2、提现必须通过注册手机验证码。 <br>
            3、注册手机号不能使用者无法余额提现。<br>
        </a-card>
        <div>
            <a-divider orientation="left">支付宝提现</a-divider>
        </div>
        <div>
              <a-form :model="form" :label-col="labelCol" :wrapper-col="wrapperCol">
                <a-form-item label="提现金额">
                    <a-input
                        :style="{'width':'270px','margin-right':'20px'}"
                        v-model:value="form.money"
                        placeholder="请输入付款金额"
                        @change="inputChange('money')"
                    />
                    <span style="color:red">实际到账  {{counted}}</span>
                </a-form-item>
                <a-form-item label="支付宝账号">
                    <a-input v-model:value="form.alibaba" placeholder="请填写您的支付宝账号" />
                </a-form-item>
                <a-form-item label="支付宝姓名">
                    <a-input v-model:value="form.name" />
                </a-form-item> 
                <a-form-item label="手机号码">
                    <a-input v-model:value="form.mobile" />
                </a-form-item> 
                <a-form-item label="验证码">
                    <a-input v-model:value="form.smz" :style="{'width':'270px','margin-right':'20px'}" placeholder="验证码" />
                    <a-button type="primary" @click="onSubmit">
                        获取验证码
                    </a-button>
                </a-form-item>   

                <a-form-item :wrapper-col="{ span: 4, offset: 1 }">
                    <a-button type="primary" @click="onSubmit">
                        提交充值
                    </a-button>
                    <a-button style="margin-left: 10px;">
                        重置
                    </a-button>
                </a-form-item>
            </a-form>
        </div>
    </div>
</template>
<script>
import {
    handleCount,
} from '@/utils/index'
import {
    PlusOutlined,
} from '@ant-design/icons-vue';
export default {
    components: {
        PlusOutlined,
    },
    data(){
        return {
            labelCol: { span: 2 },
            wrapperCol: { span: 6 },
            form: {
                name: '',
                alibaba:"",
                mobile:"",
                smz:"",
                money:"",
            },
            fileList:[],
            counted:"",
        }
    },
    methods: {
        onSubmit() {
            this.$message.info("待开发中")
            console.log('submit!', this.form);
        },
        async inputChange(item){
            this.form[item] = this.form[item].replace(/[^0-9]/ig,"");
            if(this.form[item][0]==0 && this.form[item][1] && this.form[item][1]!='.'){
                this.form[item]=0
            }
            if(this.form[item]!=this.oldValue){
                this.oldValue = this.form[item]
                this.counted = await handleCount(this.form[item],'alipay');
            }
        },
    },
}
</script>