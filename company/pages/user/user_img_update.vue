<template>
	<view class="user-update">
		<u-form :model="form" ref="uForm">
			<view style="font-size: 35rpx;font-weight: bold;text-align: center;">请选择图片</view>
			<u-form-item style="margin-left: 60rpx;">
				<u-upload ref="uUpload" @on-success="onUploadUserPicSuccess" @on-remove="onRemoveUserPic"
					:action="action" :auto-upload="false" :max-count="1"></u-upload>
				<u-button @click="uploadImg">确定</u-button>
			</u-form-item>

		</u-form>

		<u-button @click="execUpdate" type="primary" style="margin: 60rpx 30rpx;" :ripple="true" shape="circle">提交
		</u-button>

	</view>
</template>

<script>
	export default {
		data() {
			return {
				form: {
					u_id:1,
					u_pic: '' //图片路径
				},
				action: this.$u.apiBaseUrl + '/public/upload', //上传地址


			};
		},
		onLoad(options) {
			this.form.u_id = options.id;
		},
		methods: {
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
			async execUpdate() {
				if (!this.form.u_pic) {
					this.$u.toast('请确认图片再提交');
					return;
				}
				try {
					await this.$u.post('/admin/user/updateImg', this.form);
					this.$u.toast('更新成功');
					this.$u.route('/pages/user/user');
				} catch (err) {
					this.$u.toast('提交失败！');
					
				}

			}
		}
	}
</script>

<style lang="scss" scoped>
	.user-update {
		padding: 20rpx 30rpx;
	}
</style>
