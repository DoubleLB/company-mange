<template>
	<view class="user">
		
		<view class="user-list">
			
			<u-sticky style="padding:20rpx 40rpx;">
				<u-button type="primary" shape="circle" :ripple="true" @click="toAdd" >新增员工</u-button>
			</u-sticky>
			
			<view class="user-list-item" v-for="user in userList" :kye="user.u_id">
				
				<!-- 左侧图片 -->
				<view style="width:20%;margin-right:75rpx;margin-top: 40rpx;">
					<u-image @click="toUpdate(user.u_id)" shape="circle" width="150rpx" height="150rpx" :src="$u.apiBaseUrl+'/public/img/'+user.u_pic"></u-image>
				</view>
				
				<!-- 右侧信息 -->
				<view style="display:flex;flex-direction: column;justify-content:center;">
					<view style="font-weight: bold;font-size: 30rpx;">员工号：{{user.u_id}}</view>
					<!-- style="font-size:40rpx;font-weight: bold;margin-bottom: 10rpx;" -->
					<view>姓  名：{{user.u_name}}</view>
					<!-- style="font-size:18rpx;color:#888888;margin-bottom: 30rpx;" -->
					<view>邮  箱：{{user.u_email}}</view>	
					<!-- style="font-size:38rpx;font-weight: bold;color:red;" -->
					<view>部  门：{{user.d_name}}</view>
					<view>职  务：{{user.r_name}}</view>
					<view>薪  资：{{user.u_payment}}</view>
					<view>手机号：{{user.u_phone}}</view>
				</view>
			</view>
		</view>	
	</view>
	
</template>

<script>
	export default{
		data(){
			return{
				userList:[],
			}
		},
		onLoad(){
			this.getUserList();
		},
		methods: {
			async getUserList(){
				this.userList = await this.$u.get('/admin/user');//这是一个耗时的ajax请求,await表是一直阻塞，直到获取响应数据
			},
			//跳转到增加页
			toUpdate:function(para1){
				// console.log('跳转至新增........');
				this.$u.route('/pages/user/user_img_update?id='+para1);//路由跳转
				// console.log(para1);
			},
			//跳转到新增
			toAdd(){
				console.log("跳转新增...");
				this.$u.route('/pages/user/user-add');
			},
		}
		
	}
</script>

<style>
	.user-list-item{
		margin: 60rpx 40rpx 60rpx 40rpx;
		
		display:flex; 
		flex-direction: row; 
	}
</style>