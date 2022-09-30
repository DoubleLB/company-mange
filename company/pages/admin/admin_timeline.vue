<template>
	
	<view class="zong">
		<view class="user_box" style="width: 80%; margin: 40rpx auto;">
			
			<view v-if="userList.length==0" style="color: #8e8b8d;font-size: 50rpx;margin: 50% auto 0 22%;">
				该项目还没有进展
			</view>
			<view v-if="userList.length!=0" class="user_for" v-for="list in userList" :key="userList.ig_id">
				<!-- 左侧进度线 -->
				<view class="line_box">
						<!-- 圆 -->
					<view class="line_radio" :style="{ 'background' :'#8e8b8d' , 'border' : 'solid 6rpx #b9b7b6'}"></view>
						<!-- 线 -->
					<view class="line_for" v-for="item in 3" :style="{ 'background' : '#8e8b8d'}"></view>
				</view>
					
				<!-- 右侧内容 -->
				<view class="right_box"  :style="{ 'color' :'#8e8b8d'}">
					<view class="title">{{list.u_name}} <text style="margin-left: 20rpx;" >{{list.ig_date}}</text></view>
					<view class="desc">
						<u-icon name="checkmark-circle" color="#00D600" size="45"></u-icon>&nbsp;
						{{list.ig_desc}}
					</view>
				</view>
			</view> 
			
		</view>
	</view>
</template>
<script>
	export default {
		name: '',
		props: {
			
		},
		data(){
			return{
				userList: [
					// {
					// 	ig_id:'1',
					// 	u_name:'张三',
					// 	ig_date:'2022-05-29',
					// 	ig_desc:'完成了该项目的第一部分'
					// },{
					// 	ig_id:'2',
					// 	u_name:'李四',
					// 	ig_date:'2022-05-30',
					// 	ig_desc:'完成了该项目的第二部分'				
					// }
					
				]
			}
		},
		onLoad(params) {
			//获取传递的json字符串
			this.form = JSON.parse(decodeURIComponent(params.item));
			console.log(this.form);
					
			 this.getuserList();
		},
		
		methods:{
			async getuserList(){
				this.userList = await this.$u.post('/admin/progress/list',this.form);
				console.log("测试==========",this.userList);
			},
		},
	}
</script>
<style>
	.user_for{
		display: flex;
	}
	.item_year {
		font-size: 34rpx;
		height: 50rpx;
	}
	.line_for {
		width: 4rpx;
		height: 24rpx;
		margin: 0 20rpx 10rpx;
		background-color:#559DFF;
	}
	.line_radio {
		width: 20rpx;
		height: 20rpx;
		border-radius: 50%;
		position: relative;
		left: 50%;
		transform: translateX(-50%);
		top: 0;
	}
	.right_box {
		padding: 0rpx 20rpx 20rpx 20rpx;
	}
	.desc{
		font-size: 30rpx;
		color: #8e8b8d;
		display: flex;
		margin-top: 20rpx;
		align-items: center;
		
	}
	image{
		margin-right: 20rpx;
		width: 34rpx;
		height: 34rpx;
		border-radius: 50%;
	}
</style>