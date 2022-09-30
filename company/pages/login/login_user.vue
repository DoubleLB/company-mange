<template>
	<view class="wrap">
		<view class="top"></view>
		<view class="content">
			<view class="title">欢迎登录</view>
			<u-form-item>
				<u-input v-model="username" placeholder="请输入用户名" />
			</u-form-item>
			<u-form-item>
				<u-input type="password" v-model="password" placeholder="请输入密码" />
			</u-form-item>
			<u-gap height="80"></u-gap>
			<button @click="submit" class="getSmsCode">登录</button>
			<view class="alternative">
				<view class="password" @click="passwordLogin()">忘记密码</view>
				<view class="issue" @click="loginBy()">遇到问题</view>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				username: '',
				password: ''
			}
		},
		computed: {

		},
		onLoad() {

		},
		methods: {
			submit() {
								
						this.$u.post('/admin/login',{
							username:this.username,
							password:this.password
						}).then(res => {
							this.$u.route('/pages/user/user');		
						});	
							
						}
			// submit() {
				
		// 		this.$u.post('/admin/login',{
		// 				"username": this.username,
		// 				"password": this.password,
		// 			}).then(res => {

		// 			if (res.code == 0) {
		// 				this.$u.route({
		// 					type: 'switchTab',
		// 					url: '/pages/user/user'
		// 				})
		// 			} else {
						
		// 				uni.showToast({
		// 					title: '用户名或密码错误！',
		// 					icon: 'none',
		// 				})
		// 			};
		// 		}).catch(err => {
		// 			uni.showToast({
		// 				title: '用户名或密码错误异常！',
		// 				icon: 'none',
		// 			})
		// 		})
		// 	},
		// 	loginBy(type) {
		// 		this.$u.toast('开发中，敬请期待');
		// 	},
		// 	goPage(url) {
		// 		this.$u.route({
		// 			url: url
		// 		})
		// 	},
			
		
		
		 }
	};
</script>

<style lang="scss" scoped>
	.wrap {
		font-size: 28rpx;

		.content {
			width: 600rpx;
			margin: 0 auto;
			padding-top: 80rpx;

			.title {
				text-align: left;
				font-size: 60rpx;
				font-weight: 500;
				margin-bottom: 100rpx;
			}

			input {
				text-align: left;
				margin-bottom: 10rpx;
				padding-bottom: 6rpx;
			}

			.tips {
				color: $u-type-info;
				font-size: 20rpx;
				margin-bottom: 60rpx;
				margin-top: 30rpx;
			}

			.getSmsCode {
				background-color: rgb(253, 243, 208);
				color: $u-tips-color;
				border: none;
				font-size: 30rpx;
				padding: 12rpx 0;

				&::after {
					border: none;
				}
			}

			.alternative {
				color: $u-tips-color;
				display: flex;
				justify-content: space-between;
				margin-top: 30rpx;
			}
		}

		.bottom {
			.loginType {
				display: flex;
				padding: 260rpx 150rpx 150rpx 150rpx;
				justify-content: space-between;

				.item {
					display: flex;
					flex-direction: column;
					align-items: center;
					color: $u-content-color;
					font-size: 28rpx;
				}
			}

			.hint {
				padding: 20rpx 40rpx;
				font-size: 20rpx;
				color: $u-tips-color;

				.link {
					color: $u-type-warning;
				}
			}
		}
	}
</style>

