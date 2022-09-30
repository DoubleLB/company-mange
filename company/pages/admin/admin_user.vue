<template>
	<view class="user">
		
		<view class="user-list">
			
			<view class="user-list-item" v-for="user in userList" :kye="user.u_id" style="border: 4px rgba(222, 222, 222, .3) solid;border-radius: 40rpx;box-shadow: 10px 10px 5px #d9d9d9;">
				
				<!-- 左侧图片 -->
				<view style="width:20%;margin-right:25rpx;margin-top: 35rpx;margin-left: 45rpx;">
					<u-image shape="circle" width="190rpx" height="190rpx" :src="$u.apiBaseUrl+'/public/img/'+user.u_pic"></u-image>
				</view>
				
				<!-- 中侧信息 -->
				<view style="display:flex;flex-direction: column;justify-content:center;margin-left: 100rpx;flex: auto;">
					
					<view style="display:flex;flex-direction: raw;">
						<view style="color: #006600; font-weight: bold;font-size: 40rpx;"><u-icon name="account"></u-icon>  {{user.u_name}}</view>
						&nbsp;
						<view class="v3">{{user.u_id}}</view>
						
					</view>
					<u-line color="red" hair-line="true" margin="2rpx 0rpx 10rpx 0rpx"/>
					
						<view class="v2"><u-icon name="map"  color="#00004D" size="30"></u-icon>{{user.d_name}}</view>
						<view class="v2"><u-icon name="order"  color="#00004D" size="30"></u-icon>{{user.r_name}}</view>
					
					<view class="v1"><u-icon name="rmb"  color="#4A4A4A" size="30"></u-icon>  {{user.u_payment}}</view>
					<view class="v1"><u-icon name="email" color="#8585FF" size="30"></u-icon>  {{user.u_email}}</view>
					<view class="v1"><u-icon name="phone" color="#8585FF" size="30"></u-icon>  {{user.u_phone}}</view>
				</view>
				
				<!-- 右侧图标 -->
				<view style="font-size: 50rpx;color: #BBBBBB;margin-top: 100rpx;" @click="toEdit(user)"><u-icon name="edit-pen"></u-icon></view>
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
			
			//跳转到编辑页
			toEdit(user){
				console.log(user);
				
				//将对象转为json字符串
				const jsonStr = JSON.stringify(user);
				console.log(jsonStr);
				
				//对字符串进行字符串编码
				const str = encodeURIComponent(jsonStr);
				console.log(str);
				
				this.$u.route({
					url:'pages/admin/admin_user_edit',
					params:{
						user:str
					}
				});
			}
		}
		
	}
</script>

<style>
	.user-list-item{
		margin: 20rpx 40rpx 30rpx 40rpx;
		background-color: rgba(204,255,238,.2);
		display:flex; 
		flex-direction: row; 
	}
	.v1{
		font-weight: 600;
		font-size: 28rpx;
	}
	.v2{
		font-weight:800;
	}
	.v3{
		font-weight: 600;
		font-size: 35rpx;
		padding-top: 8rpx;
		margin: 0 5rpx 0 auto;
		/* float: right; */
	}
	
</style>