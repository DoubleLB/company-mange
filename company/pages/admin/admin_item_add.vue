<template>
	<view class="admin-item-add">
		<u-form  :model="form" ref="uForm">
			<u-form-item label="项目名称" label-width="150rpx" >
				<u-input v-model="form.i_name" />
			</u-form-item>
			<u-form-item label="项目描述" label-width="150rpx">
				<u-input v-model="form.i_desc" />
			</u-form-item>
			<u-form-item label="创建时间" label-width="150rpx">
				<u-input v-model="form.i_createTime" />
			</u-form-item>
			<u-form-item label="截止时间" label-width="150rpx">
				<u-input v-model="form.i_finishTime"  />		
			</u-form-item>
			<u-form-item label="项目进度" label-width="150rpx">
				<u-input v-model="form.i_progress"  />
			</u-form-item>
			<u-form-item label="总负责人" label-width="150rpx">
				<u-input v-model="form.i_principal"/>
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
					i_name:'',
					i_desc:'',
					i_createTime:'',
					i_finishTime:'',
					i_progress:'',
					i_principal:''
				}

			};
		},
		onLoad() {

		},
		methods: {
			async execAdd() {
				
				try {
					await this.$u.post('/admin/items/insertItem', this.form);
					this.$u.toast('新增成功');
					this.$u.route('/pages/admin/admin_item');
					// uni.switchTab({
					//     url: '/pages/admin/admin_item'
					//   })
				} catch (err) {
					this.$u.toast('提交失败！');
				}

			}
		}
	}
</script>

<style lang="scss" scoped>
	.admin-item-add {
		padding: 20rpx 40rpx;
	}
</style>
