<template>
	<view class="item-user">
		
		<view class="admin-item-user">
			<view style="font-weight: bold;font-size: 40rpx;margin: 30rpx;">项目简介：<text class="t1" selectable="false">{{itemlist.i_desc}}</text></view>
			
			<u-table>
					<u-tr>
						<u-th>姓名</u-th>
						<u-th>邮箱</u-th>
						<u-th>手机号</u-th>
						<u-th>操作</u-th>
					</u-tr>
					<u-tr v-for="iuser in iuserList" :kye="iuser.ui_id">
						<u-td class="td">{{iuser.u_name}}</u-td>
						<u-td class="td">{{iuser.u_email}}</u-td>
						<u-td class="td">{{iuser.u_phone}}</u-td>
						<u-td class="td"><u-button type="warning" @click="toChange" size="mini" :plain="true">移除</u-button></u-td>
						<u-modal @confirm="toDelete(iuser)" v-model="confirmShow" :showCancelButton="true" :content="confirmContent"></u-modal>
					</u-tr>
					<u-tr>
						<u-td><u-button type="success" size="medium" :plain="true" @click="toIUAdd(itemlist)">新增项目人员</u-button></u-td>
					</u-tr>
					
			</u-table>
			<!-- <view class="admin-item-user-list" v-for="iuser in iuserList" :kye="iuser.i_id" >
				<view style="display:flex;flex-direction: raw;justify-content:center;margin-left: 100rpx;flex: auto;">
					<view class="user">姓名:{{iuser.u_name}}</view>
					<view class="user">邮箱:{{iuser.u_email}}</view>
					<view class="user">手机:{{iuser.u_phone}}</view>
				</view>
				
			</view> -->
		</view>	
	</view>
	
</template>

<script>
	export default{
		data(){
			return{
				iuserList:[],
				itemlist:[],
				
				confirmShow: false,
				confirmContent: '111',
				
			}
		},
		onLoad(params){
			
			//获取传递的json字符串
			this.itemlist = JSON.parse(decodeURIComponent(params.item));
			console.log("测试itemlist=======",this.itemlist);
			
			this.getIUserList();
		},
		methods: {
			async getIUserList(){
				console.log("i_id=====",this.itemlist.i_id)
				console.log("itemlist=====",this.itemlist)
				this.iuserList = await this.$u.post('admin/items/stUIs',this.itemlist);
				console.log("测试iuserList======",this.iuserList)
			},
			toDelete(param){
				console.log(param);
				this.$u.post('/admin/items/deleteUIs',param);
				this.$u.toast('移除成功');
				this.$u.route('/pages/admin/admin_item');
			},
			toChange(){
				this.confirmContent = "您确定从项目中移除该成员吗?"
				this.confirmShow = true;
			},
			toIUAdd(itemlist){					
					//将对象转为json字符串
					const jsonStr = JSON.stringify(itemlist);
					console.log(jsonStr);
					
					//对字符串进行字符串编码
					const str = encodeURIComponent(jsonStr);
					console.log(str);
					
					this.$u.route({
						url:'/pages/admin/admin_item_user_add',
						params:{
							itemlist:str
						}
					});
				
			}

			
		
		}
		
	}
</script>

<style>
	.admin-item-user{
		background-color: rgba(123, 222, 222, .1);
	}
	.user{
		margin:10rpx 20rpx;
	}
	.td{
		height: 70rpx;
	}
	.t1{
		font-weight:normal ;
	}
</style>