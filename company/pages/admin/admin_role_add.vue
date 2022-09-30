<template>
	<view class="role-add">
		<u-form :model="form" ref="uForm">
			<u-form-item label="职位名称" labelWidth="140rpx">
				<u-input v-model="form.r_name" />
			</u-form-item>
			<u-form-item label="描述职位" labelWidth="140rpx">
				<u-input v-model="form.r_desc" />
			</u-form-item>
		</u-form>

		<u-button @click="execAdd" type="primary" style="margin: 60rpx 30rpx;" :ripple="true" shape="circle">提交
		</u-button>

	</view>
</template>

<script>
	export default {
		data() {
			return {
				form: {
					r_name: '', 
					r_desc: ''
				},

			};
		},
		onLoad() {
			
		},
		methods: {
			
			async execAdd() {
				try {
					await this.$u.post('/admin/role/insert', this.form);
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
	.role-add {
		padding: 20rpx 30rpx;
	}
</style>
