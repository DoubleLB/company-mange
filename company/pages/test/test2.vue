<template>
	<view class="">
		<u-dropdown ref="uDropdown">
			<u-dropdown-item title="属性">
				<view class="slot-content">
					<view class="u-text-center u-content-color u-m-t-20 u-m-b-20" v-for="item in itemList" :key="item.i_id">
						<view style="margin-right: 30rpx;font-size: 38rpx;" @click="toExe">{{item.i_name}}</view>
					</view>
					<u-button type="primary" @click="closeDropdown">确定</u-button>
				</view>
			</u-dropdown-item>
		</u-dropdown>
	</view>
</template>

<script>
	export default {
		data(){
			return{			
				itemList:[]
			}
		},
		
		onLoad(){
			this.getItemList();
		},
		methods: {
			async getItemList(){
				this.itemList = await this.$u.get('/admin/items/list');//这是一个耗时的ajax请求,await表是一直阻塞，直到获取响应数据
			},
			toExe(index) {
				this.currentItem = index;
			},
			
			closeDropdown() {
				this.$refs.uDropdown.close();
			}
		}
	}
</script>