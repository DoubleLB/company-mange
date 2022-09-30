<template>
	<view class="admin-item-user-add">
		<u-form  :model="form" ref="uForm">
			<u-form-item label="项目名称:" label-width="150rpx" >
				<u-input v-model="form.i_name" disabled="true"/>
			</u-form-item>
			<!-- 展示没有项目的员工 -->
			<u-form-item label="增加人员工号:" label-width="200rpx" prop="u_id">
				<u-input v-model="form.u_id" type="select" @click="userListShow = true"/>
				<u-select v-model="userListShow" :list="userList" @confirm="onuserListConfirm" value-name="user_id"
					label-name="user_name"></u-select>&nbsp;&nbsp;
				<text>{{form.us_name}}</text>
			</u-form-item>
			
			
		</u-form>

		<u-button @click="execAdd" type="primary" style="margin: 60rpx 30rpx;" :ripple="true" shape="circle">提交
		</u-button>

	</view>
</template>

<script>
	export default {
		data() {
			return {
				form: {
					i_name:'',
					i_id:'',
					u_id:'',
					us_name:''
				},
				
				userList:[{
					user_id: 1,
					user_name: '分类1'
				},
				{
					user_id: 2,
					user_name: '分类2'
				}
				],
				userListShow :false,
				
				rules:{
					u_id:[{
						required: true,
						message: '请选择员工ID',
						// 可以单个或者同时写两个触发验证方式
						trigger: 'blur,change'
					}]
				}

			};
		},
		//必须要在onReady生命周期，因为onLoad生命周期组件可能尚未创建完毕
		onReady() {
			this.$refs.uForm.setRules(this.rules);
		},
		onLoad(params) {
			this.form = JSON.parse(decodeURIComponent(params.itemlist));
			console.log(this.form);
			
			this.getuserList();
		},
		methods: {
			async getuserList() {
				this.userList = await this.$u.get('/admin/user/nobusy');
			},
			onuserListConfirm(selectedArr){
				console.log("", selectedArr);//{value: 1, label: '分类1'}
				this.form.u_id = selectedArr[0].value.toString();
				this.form.us_name = selectedArr[0].label;
				
			},
			
			async execAdd() {			
				try {
					await this.$u.post('/admin/items/insertUIs', this.form);
					
					this.$u.toast('新增成功');
					this.$u.route('/pages/admin/adminhome');
					
				} catch (err) {
					this.$u.toast('提交失败！');
				}

			}
		}
	}
</script>

<style lang="scss" scoped>
	.admin-item-user-add {
		padding: 20rpx 40rpx;
	}
</style>
