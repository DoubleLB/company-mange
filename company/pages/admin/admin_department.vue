<template>
	<view class="admin-item">

		<u-sticky offset-top="1100" style="margin-left: auto; margin-right: 120rpx; width: 0rpx;height: 0rpx;">
			<u-button style="width: 100rpx;height: 100rpx;" type="primary" shape="circle" :ripple="true" @click="toAdd"><u-icon name="plus" color="#ffffff" size="38"></u-icon></u-button>
		</u-sticky>

		<view class="admin-item-list" v-for="ditem in departmentList" :key="ditem.d_id">

			<view @click="toDepartment(ditem)" class="vd1">
				<view style="font-weight: bold;font-size: 30rpx;display:flex;flex-direction: raw;margin: 20rpx 0 5rpx 0 ;">
					<view style="margin-right: 30rpx;font-size: 38rpx;font-weight: bold;">{{ditem.d_name}}</view>
					<view style="margin:10rpx 20rpx 0 auto;"><u-icon name="map" color="#2979ff" size="28"></u-icon>{{ditem.d_location}}</view>
				</view>
				<u-line color="green" hair-line="true" margin="15rpx 0rpx 10rpx 0rpx" />

			</view>
		</view>
		
		
	</view>
</template>

<script>
	export default {
		data() {
			return {
				departmentList: [{
						d_id: 1,
						d_name: '技术部',
						d_location:'三楼第二间办公室'
					},
					{
						d_id: 2,
						d_name: '财务部',
						d_location:'三楼第一间办公室'
					},
					{
						d_id: 3,
						d_name: '运维部',
						d_location:'三楼第三间办公室'
					}
				]
			}
		},
		onLoad() {
			this.getItemList();
		},
		methods: {
			async getItemList() {
				this.departmentList = await this.$u.get('/admin/department/list'); //这是一个耗时的ajax请求,await表是一直阻塞，直到获取响应数据
			},
			//跳转到新增
			toAdd() {
				console.log("跳转新增...");
				this.$u.route('/pages/admin/admin_department_add');
			},
			//带参跳转至部门员工
			toDepartment(ditem){
				console.log(ditem);
				
				//将对象转为json字符串
				const jsonStr = JSON.stringify(ditem);
				console.log(jsonStr);
				
				//对字符串进行字符串编码
				const str = encodeURIComponent(jsonStr);
				console.log(str);
				
				this.$u.route({
					url:'pages/admin/admin_department_user',
					params:{
						ditem:str
					}
				});
			}
		}

	}
</script>

<style>
	.admin-item-list {
		margin: 10rpx 40rpx 20rpx 40rpx;
		display: flex;
		flex-direction: raw;

		border: 4px rgba(222, 222, 222, .3) solid;
		border-radius: 40rpx;
		box-shadow: 10px 10px 5px #d9d9d9;
	}
	.vd1{
		display:flex;
		flex-direction: column;
		justify-content:center;
		margin:10rpx 50rpx;
		flex: auto;
	}
</style>
