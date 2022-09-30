<template>
	<!-- 一 -->
	<view class="content-item">
		<image src="/static/index/bg4.jpg" style="width: 100%;border-radius: 20rpx;"></image>
		<view class="user-info">
			<view>
				<image src="/static/index/1.jpg" style="height: 80px;width: 80px;border-radius: 50%;"></image>
			</view>
			<view class="name">
				<text style="font-weight: bold;font-size: 40rpx;margin:30rpx 0rpx 0rpx 53rpx;">你好，管理员</text>
			</view>
			
		</view>
		<text class="t1" @click="toQuite">退出</text>
	</view>

	<!-- 二-->
	<view class="content-item">
		<view class="title">
			<text>项目信息</text>
		</view>
		<view class="content-show">
			<view class="order-tab">
				<u-icon name="list-dot " color="#000000" :size="46" @click="$u.route('/pages/admin/admin_item')"></u-icon>
				<text class="order-title">所有项目</text>
			</view>
			<view class="order-tab">
				<u-icon name="hourglass-half-fill" :size="46" @click="$u.route('/pages/admin/admin_item_preparing')"></u-icon>
				<text class="order-title">准备中</text>
			</view>

			<view class="order-tab">
				<u-icon name="rewind-right" :size="46" @click="$u.route('/pages/admin/admin_item_processing')"></u-icon>
				<text class="order-title">进行中</text>
			</view>
			<view class="order-tab">
				<u-icon name="checkmark-circle" :size="46" @click="$u.route('/pages/admin/admin_item_finished')"></u-icon>
				<text class="order-title">已完成</text>
			</view>
			
		</view>
	</view>

	<!-- 三 -->
	<view class="content-item">
		<view class="title">
			<text>员工信息</text>
		</view>
		<view class="content-show">
			<view class="service-item">
				<u-icon name="account" :size="46" @click="$u.route('/pages/admin/admin_user')"></u-icon>
				<text class="order-title">所有员工</text>
			</view>
			 <view class="service-item">
				<u-icon name="grid" :size="46" @click="$u.route('/pages/admin/admin_department')"></u-icon>
				<text class="order-title">部门</text>
			</view>
			 <view class="service-item">
				<u-icon name="level" :size="46" @click="$u.route('/pages/admin/admin_role')"></u-icon>
				<text class="order-title">职位</text>
			</view>
			<view class="service-item">
				<u-icon name="man-add" :size="46" @click="$u.route('/pages/admin/admin_user_add')"></u-icon>
				<text class="order-title">加入成员</text>
			</view>
		</view>
	</view>

</template>

<script>
	export default{
		methods:{
		toQuite(){
			//管理员登录界面
			this.$u.route('pages/adminlogin/adminlogin');
		}
	}
	}
	
</script>

<style>
	.container {
		width: 100%;
	}

	.profile {
		width: 100%;
	}

	.user-info {
		position: absolute;
		top: 100px;
		left: 30px;
		display: flex;
		align-items: center;

	}

	.user-info .name {
		display: flex;
	}
	.t1{
		position: absolute;
		top: 10rpx;
		right: 25rpx;
		color: #919293;
	}

	.content-item {
		display: flex;
		margin: 10px;
		flex-direction: column;
		border-radius: 4px;
		background-color: #FFFFFF;
		justify-content: space-around;
	}

	.content-item .title {
		padding: 15px;
		color: #5A5B5C;
		font-size: 16px;
		font-weight: bold;
	}

	.content-show {
		display: flex;
		flex-direction: row;
		justify-content: space-around;
		align-items: center;
	}

	.money-item {
		display: flex;
		flex-direction: column;
		align-items: center;
		padding: 20px;
	}

	.service-item {
		display: flex;
		flex-direction: column;
		align-items: center;
		padding: 20px;
	}

	.service-item .service-text {
		font-size: 12px;
		color: #919293;
	}

	.order-tab {
		display: flex;
		flex-direction: column;
		align-items: center;
		padding: 15px;
	}

	.order-title {
		font-size: 14px;
		padding-top: 10px;
		color: #919293;
		padding-bottom: 8px;
	}
</style>
