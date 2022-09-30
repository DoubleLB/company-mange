<template>
	<view class="department-add">
		<u-form :model="form" ref="uForm">
			<u-form-item label="部门名称" labelWidth="140rpx">
				<u-input v-model="form.d_name" />
			</u-form-item>
			<u-form-item label="所在位置" labelWidth="140rpx">
				<u-input v-model="form.d_location" />
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
					d_name: '', 
					d_location: ''
				},

			};
		},
		onLoad() {
			
		},
		methods: {
			
			async execAdd() {
				try {
					await this.$u.post('/admin/department/insert', this.form);
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
	.department-add {
		padding: 20rpx 30rpx;
	}
</style>
