<template>
	<view class="item">

		<view class="admin-item">

			<view class="admin-item-list" v-for="item in itemPreList" :kye="item.i_id"
				style="border: 4px rgba(222, 222, 222, .3) solid;border-radius: 40rpx;box-shadow: 10px 10px 5px #d9d9d9;">

				<!-- 左侧信息 -->
				<view style="display:flex;flex-direction: column;justify-content:center;margin-left: 50rpx;flex: auto;">
					<view style="font-weight: bold;font-size: 30rpx;display:flex;flex-direction: raw;margin: 20rpx 0 5rpx 0 ;">
						<view style="margin-right: 30rpx;font-size: 38rpx;">{{item.i_name}}</view>
						<view style="margin:10rpx 20rpx 0 auto;">{{item.u_name}}</view>
					</view>
					<u-line color="green" hair-line="true" margin="0rpx 0rpx 0rpx 0rpx" />
					<view style="display:flex;flex-direction: raw;margin: 30rpx 0;">
						<view>{{item.i_createTime}}</view>&nbsp;
						&nbsp;至&nbsp;&nbsp;&nbsp;
						<view>{{item.i_finishTime}}</view>
					</view>

					<view style="margin-top: 10rpx;color: #3d85c6;">状态：{{item.i_progress}}
						<u-icon @click="toTimeLine(item)" name="file-text" color="#3d85c6" size="34"></u-icon>
					</view>
					<view style="display:flex;flex-direction: raw;">
						<view class="yesORno" @click="toAgree(item)">同意：<u-icon name="checkmark" color="#0ccf1f" size="38"></u-icon></view>
						
					</view>
				</view>

				<!-- 右侧图标 -->
				<view style="font-size: 50rpx;color: #BBBBBB;margin-top: 80rpx;" @click="toSerach(item)">
					<u-icon name="search"></u-icon>
				</view>
			</view>
		</view>
	</view>

</template>

<script>
	export default {
		data() {
			return {
				itemPreList: [],
			}
		},
		onLoad() {
			this.getPreItemList();

		},
		methods: {

			async toAgree(item) {
				try {
					console.log(item);
					await this.$u.post('/admin/items/agree', item);
					
					this.$u.toast('该项目成功启动');
					 this.$u.route('/pages/admin/adminhome');
					
				} catch (err) {
					this.$u.toast('此人已经在负责其他项目！');
				}
			
			},

			async getPreItemList() {
				this.itemPreList = await this.$u.get('/admin/items/list1'); //这是一个耗时的ajax请求,await表是一直阻塞，直到获取响应数据
			},


			//跳转到编辑页
			toSerach(item) {
				console.log(item);

				//将对象转为json字符串
				const jsonStr = JSON.stringify(item);
				console.log(jsonStr);

				//对字符串进行字符串编码
				const str = encodeURIComponent(jsonStr);
				console.log(str);

				this.$u.route({
					url: 'pages/admin/admin_item_user',
					params: {
						item: str
					}
				});
			},
			//跳转到新增
			toAdd() {
				console.log("跳转新增...");
				this.$u.route('/pages/admin/admin_item_add');
			},
			toTimeLine(item) {

				console.log(item);

				//将对象转为json字符串
				const jsonStr = JSON.stringify(item);
				console.log(jsonStr);

				//对字符串进行字符串编码
				const str = encodeURIComponent(jsonStr);
				console.log(str);

				this.$u.route({
					url: 'pages/admin/admin_timeline',
					params: {
						item: str
					}
				});
			}

		}

	}
</script>

<style>
	.admin-item-list {
		margin: 10rpx 40rpx 60rpx 40rpx;
		display: flex;
		flex-direction: raw;
	}
	.yesORno{
		font-size: 32rpx;
		margin-left: auto;
	}
</style>
