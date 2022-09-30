<template>
	<view class="user-add">
		<u-form :model="form" ref="uForm">
			<u-form-item label="工号" >
				<u-input v-model="form.u_id" disabled="true" />
			</u-form-item>
			<u-form-item label="姓名">
				<u-input v-model="form.u_name" disabled="true" />
			</u-form-item>
			<u-form-item label="邮箱">
				<u-input v-model="form.u_email" disabled="true" />
			</u-form-item>
			<u-form-item label="部门">
				<u-input v-model="form.d_name" type="select" @click="dListShow = true" />
				<u-select v-model="dListShow" :list="dList" @confirm="ondListConfirm" value-name="d_id"
					label-name="d_name"></u-select>
			</u-form-item>
			<u-form-item label="职务">
				<u-input v-model="form.r_name" type="select" @click="rListShow = true" />
				<u-select v-model="rListShow" :list="rList" @confirm="onrListConfirm" value-name="r_id"
					label-name="r_name"></u-select>
			</u-form-item>
			<u-form-item label="薪资">
				<u-input v-model="form.u_payment"/>
			</u-form-item>
			<u-form-item label="手机">
				<u-input v-model="form.u_phone" disabled="true" />
			</u-form-item>

		</u-form>

		<u-button @click="execEdit" type="primary" style="margin: 60rpx 30rpx;" :ripple="true" shape="circle">提交
		</u-button>
		
		

	</view>
</template>

<script>
	export default {
		data() {
			return {
				form: {
					u_id:'',
					u_name: '',
					u_email: '',
					u_phone: '',
					u_payment: '',
					u_pic: '' ,
					d_name: '', //分类名称
					d_id: '', //分类编号
					r_name:'',//职务
					r_id:''		
				},
				//分类选择器的列表数据
				dList: [{
						d_id: 1,
						d_name: '分类1'
					},
					{
						d_id: 2,
						d_name: '分类2'
					},
					{
						d_id: 3,
						d_name: '分类3'
					}
				],
				dListShow: false, //分类选择器是否可见
				
				rList: [{
						r_id: 1,
						r_name: '分类1'
					},
					{
						r_id: 2,
						r_name: '分类2'
					},
					{
						r_id: 3,
						r_name: '分类3'
					}
				],
				rListShow: false, //分类选择器是否可见

				confirmShow: false,
				confirmContent: '111',

			};
		},
		onLoad(params) {
			//获取传递的json字符串
			this.form = JSON.parse(decodeURIComponent(params.user));
			console.log(this.form);
			
			this.getdList();
			this.getrList();
		},
		
		methods: {
			
			async getdList() {
				this.dList = await this.$u.get('/public/d');
				
				// const theD = this.dList.find(dls => dls.d_id == this.form.d_id); //寻找符合条件的分类
				// console.log("测试theD",theD);
				// this.form.d_name = theD.d_name;
			},
			async getrList() {
				this.rList = await this.$u.get('/public/r');
				
				// const theR = this.rList.find(rls => rls.r_id == this.form.r_id); //寻找符合条件的分类
				// this.form.r_name = theR.r_name;
			},
			ondListConfirm(selectedArr) {
				console.log("", selectedArr);
				this.form.d_name = selectedArr[0].label;
				this.form.d_id = selectedArr[0].value;
			},
			onrListConfirm(selectedArr) {
				console.log("", selectedArr);
				this.form.r_name = selectedArr[0].label;
				this.form.r_id = selectedArr[0].value;
			},
			
			async execEdit(){
				await this.$u.post('admin/user/updata', this.form);
				this.$u.toast('编辑成功!');
				this.$u.route('/pages/admin/adminhome');
				// uni.switchTab({
				//     url: '/pages/admin/admin_user'
				//   })
			}
			
		}
	}
</script>

<style lang="scss" scoped>
	.user-add {
		padding: 20rpx 30rpx;
	}
</style>
