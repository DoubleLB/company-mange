<template>
	<view>
		<!-- style-type="'button'"中有 text和button两种风格 -->
		<view class="uni-padding-wrap ">
			<u-subsection :list="items" :current="currentItem" @change="sectionChange"></u-subsection>
		</view>

		<u-dropdown>
			<u-dropdown-item v-model="value1" title="部门" :options="options1" @change="toExe" value-name="d_id"
					label-name="d_name"></u-dropdown-item>
		</u-dropdown>

		<view class="content">
			<!-- 选项卡1的内容 -->
			<view v-if="currentItem === 0">
				<text class="content-text"> 选项卡1的内容</text>
			</view>
			<!-- 选项卡2的内容 -->
			<view v-if="currentItem === 1">
				<text class="content-text">选项卡2的内容</text>
			</view>
			<!-- 选项卡3的内容 -->
			<view v-if="currentItem === 2">
				<text class="content-text">选项卡3的内容</text>
			</view>
		</view>

	</view>
</template>

<script>
	export default {
		data() {
			return {
				items: [{
						name: '待发货',						
					},
					{
						name: '待付款'
					},
					{
						name: '待评价'
					}
				],
				currentItem: 0,

				value1: 0,
				options1: [{
						d_id: 0,
						d_name: '默认排序'
						
					},
					{
						d_id: 1,
						d_name: '距离优先'
						
					},
					{
						d_id: 2,
						d_name: '价格优先'
						
					}
				],
			}
		},
		methods: {
			sectionChange(index) {
				this.currentItem = index;
			},
			toExe(index) {
				this.currentItem = index;
			},
		}
	}
</script>

<style>
	/* 头条小程序组件内不能引入字体 */
	/* #ifdef MP-TOUTIAO */
	@font-face {
		font-family: uniicons;
		font-weight: normal;
		font-style: normal;
		src: url('~@/static/uni.ttf') format('truetype');
	}

	/* #endif */

	/* #ifndef APP-NVUE */
	page {
		display: flex;
		flex-direction: column;
		box-sizing: border-box;
		background-color: #efeff4;
		min-height: 100%;
		height: auto;
	}

	.uni-padding-wrap {
		width: 750rpx;
		padding: 0px 30px;
	}

	.content {
		/* #ifndef APP-NVUE */
		display: flex;
		/* #endif */
		justify-content: center;
		align-items: center;
		height: 150px;
		text-align: center;
	}

	.content-text {
		font-size: 18px;
		color: #333;
	}

	/* #endif */
</style>
