<template>
	<view class="user-add">
		<u-form :model="form" ref="uForm">
			<u-form-item label="工号">
				<u-input v-model="form.u_id" />
			</u-form-item>
			<u-form-item label="姓名">
				<u-input v-model="form.u_name" />
			</u-form-item>
			<u-form-item label="性别">
				<u-input v-model="form.u_sex" />
			</u-form-item>			
			<u-form-item label="邮箱">
				<u-input v-model="form.u_email" />
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
			<u-form-item label="手机号" label-width="95rpx" >
				<u-input v-model="form.u_phone"/>
			</u-form-item>
			<u-form-item>
				<u-upload ref="uUpload" @on-success="onUploadUserPicSuccess" @on-remove="onRemoveUserPic"
					:action="action" :auto-upload="false" :max-count="1"></u-upload>
				<u-button @click="uploadImg">确定</u-button>
			</u-form-item>

		</u-form>

		<u-button @click="execAdd" type="primary" style="margin: 0rpx 60rpx;" :ripple="true" shape="circle">提交
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
					u_sex:'',
					u_email: '',
					u_phone: '',
					u_payment: '',
					u_pic: '' ,
					d_name: '', //分类名称
					d_id: '', //分类编号
					r_name:'',//职务
					r_id:''		
				},
				action: this.$u.apiBaseUrl + '/public/upload', //上传地址
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

			};
		},
		onLoad() {
			this.getdList();
			this.getrList();
		},
		methods: {
			async getdList() {
				this.dList = await this.$u.get('/public/d');
			},
			async getrList() {
				this.rList = await this.$u.get('/public/r');
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
			onRemoveUserPic() {
				this.form.u_pic = '';
			},
			uploadImg() {
				this.$refs.uUpload.upload();
			},
			onUploadUserPicSuccess(result) {
				console.log("上传成功返回数据：", result);
				this.form.u_pic = result.data;
			},
			async execAdd() {
				if (!this.form.u_pic) {
					this.$u.toast('请确认图片再提交');
					return;
				}
				try {
					await this.$u.post('/admin/user/insert', this.form);
					this.$u.toast('新增成功');
					this.$u.route('/pages/admin/adminhome');
				} catch (err) {
					this.$u.toast('提交失败！');
				}

			}
		}
	}
</script>

<style lang="scss" scoped>
	.user-add {
		padding: 20rpx 30rpx;
	}
</style>
