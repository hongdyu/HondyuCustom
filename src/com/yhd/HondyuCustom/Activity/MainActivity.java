package com.yhd.HondyuCustom.Activity;

import com.yhd.Fragment.CoachFragment;
import com.yhd.Fragment.DiscoveryFragment;
import com.yhd.Fragment.DrivingExamFragment;
import com.yhd.Fragment.DrivingGroupFragment;
import com.yhd.HondyuCustom.Activity.R;
import com.yhd.HondyuCustom.Entity.Person;
import com.yhd.HondyuCustom.Helper.CustomDialogActivity;

import cn.bmob.v3.BmobInstallation;
import cn.bmob.v3.BmobPushManager;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.DeleteListener;
import cn.bmob.v3.listener.GetListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends FragmentActivity implements OnClickListener {

	private Button addBtn, queryBtn, updateBtn, deleteBtn, btn_sendAll,
			btn_dialog, btn_sendMsgToAndroid, btn_register, btn_myLocation,
			btn_homepage, btn_map, btn_headimage;
	private RelativeLayout rl_delete_item;
	private TextView tv_driving_exam, tv_coach, tv_driving_exam_group,
			tv_discovery;

	BmobPushManager<BmobInstallation> bmobPushManager;
	private String userId = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// 创建推送消息的对象
		bmobPushManager = new BmobPushManager<BmobInstallation>(this);
		initView();
		initMainButtom();
	}

	private void initView() {

		tv_driving_exam = (TextView) findViewById(R.id.tv_driving_exam);
		tv_driving_exam.setOnClickListener(this);
		tv_coach = (TextView) findViewById(R.id.tv_coach);
		tv_coach.setOnClickListener(this);
		tv_driving_exam_group = (TextView) findViewById(R.id.tv_driving_exam_group);
		tv_driving_exam_group.setOnClickListener(this);
		tv_discovery = (TextView) findViewById(R.id.tv_discovery);
		tv_discovery.setOnClickListener(this);

		/*
		 * addBtn = (Button) findViewById(R.id.addBtn); queryBtn = (Button)
		 * findViewById(R.id.queryBtn); updateBtn = (Button)
		 * findViewById(R.id.updateBtn); deleteBtn = (Button)
		 * findViewById(R.id.deleteBtn); btn_sendAll = (Button)
		 * findViewById(R.id.btn_sendAll); btn_sendMsgToAndroid = (Button)
		 * findViewById(R.id.btn_sendMsgToAndroid); btn_register = (Button)
		 * findViewById(R.id.btn_register); btn_myLocation = (Button)
		 * findViewById(R.id.btn_myLocation); btn_homepage = (Button)
		 * findViewById(R.id.btn_homepage); btn_map = (Button)
		 * findViewById(R.id.btn_map); btn_headimage = (Button)
		 * findViewById(R.id.btn_headimage); btn_dialog = (Button)
		 * findViewById(R.id.btn_dialog);
		 * 
		 * addBtn.setOnClickListener(this); queryBtn.setOnClickListener(this);
		 * updateBtn.setOnClickListener(this);
		 * deleteBtn.setOnClickListener(this);
		 * btn_sendAll.setOnClickListener(this);
		 * btn_sendMsgToAndroid.setOnClickListener(this);
		 * btn_register.setOnClickListener(this);
		 * btn_myLocation.setOnClickListener(this);
		 * btn_homepage.setOnClickListener(this);
		 * btn_map.setOnClickListener(this);
		 * btn_headimage.setOnClickListener(this);
		 * btn_dialog.setOnClickListener(this);
		 */
	}

	/**
	 * 初始化底部菜单栏
	 */
	private void initMainButtom() {
		changeFragment(new DrivingExamFragment());
		initBottomTextview(tv_driving_exam);
	}

	private void initBottomTextview(TextView tv_checked) {
		tv_driving_exam.setSelected(false);
		tv_coach.setSelected(false);
		tv_driving_exam_group.setSelected(false);
		tv_discovery.setSelected(false);
		tv_checked.setSelected(true);
	}

	@Override
	public void onClick(View v) {

		if (v == tv_driving_exam) {
			changeFragment(new DrivingExamFragment());
			initBottomTextview(tv_driving_exam);
		} else if (v == tv_coach) {
			changeFragment(new CoachFragment());
			initBottomTextview(tv_coach);
		} else if (v == tv_driving_exam_group) {
			changeFragment(new DrivingGroupFragment());
			initBottomTextview(tv_driving_exam_group);
		} else if (v == tv_discovery) {
			changeFragment(new DiscoveryFragment());
			initBottomTextview(tv_discovery);
		}

		/*
		 * switch (v.getId()) {
		 * 
		 * case R.id.addBtn: addDataToBmob(); break; case R.id.queryBtn:
		 * queryDataFromBmobById(); break; case R.id.updateBtn:
		 * UpdateDataInBmobById(); break; case R.id.deleteBtn:
		 * deleteDataFromBmobById(); break; case R.id.btn_sendAll: //
		 * startPushMessage(); // 推送一条消息给所有安装此应用的设备
		 * bmobPushManager.pushMessageAll("这是给所有设备推送的一条消息。"); break; case
		 * R.id.btn_sendMsgToAndroid: // 创建Installation表的BmobQuery对象
		 * BmobQuery<BmobInstallation> query = BmobInstallation.getQuery(); //
		 * 并添加条件为设备类型属于android query.addWhereEqualTo("deviceType", "android");
		 * // 设置推送条件给bmobPushManager对象。 bmobPushManager.setQuery(query); //
		 * 设置推送消息，服务端会根据上面的查询条件，来进行推送这条消息
		 * bmobPushManager.pushMessage("这是一条推送给所有Android设备的消息。"); break; case
		 * R.id.btn_register: startActivity(new Intent(MainActivity.this,
		 * RegisterActivity.class)); break; case R.id.btn_myLocation:
		 * startActivity(new Intent(MainActivity.this, LocationActivity.class));
		 * break; case R.id.btn_homepage: startActivity(new
		 * Intent(MainActivity.this, HomePageActivity.class)); break; case
		 * R.id.btn_map: startActivity(new Intent(MainActivity.this,
		 * MapActivity.class)); break; case R.id.btn_headimage:
		 * startActivity(new Intent(MainActivity.this,
		 * HeadImageSetActivity.class)); break; case R.id.btn_dialog:
		 * showMyDialog(); break; case R.id.rl_delete_item: Toast.makeText(this,
		 * "我要删除该项目@", Toast.LENGTH_LONG).show(); break; default: break; }
		 */
	}

	private void changeFragment(Fragment targetFragment) {
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.main_fragment, targetFragment, "fragment")
				.setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
				.commit();
	}

	/**
	 * 显示dialog
	 */
	private void showMyDialog() {
		// 创建Dialog并设置样式主题
		CustomDialogActivity customDialog = new CustomDialogActivity(this,
				R.style.dialog);
		Window win = customDialog.getWindow();
		LayoutParams params = new LayoutParams();
		params.x = 0;// 设置x坐标
		params.y = 0;// 设置y坐标
		win.setAttributes(params);
		customDialog.setCanceledOnTouchOutside(true);// 设置点击Dialog外部任意区域关闭Dialog
		customDialog.show();
		rl_delete_item = (RelativeLayout) customDialog
				.findViewById(R.id.rl_delete_item);
		rl_delete_item.setOnClickListener(this);
	}

/*	*//**
	 * 向Bmob中添加一行数据
	 *//*
	private void addDataToBmob() {
		// 向Bomb服务器中添加一行数据
		final Person p2 = new Person();
		p2.setName("hondyu");
		p2.setAddress("四川成都");
		p2.save(this, new SaveListener() {

			@Override
			public void onSuccess() {
				ShowToast("添加数据成功，返回objectId为：" + p2.getObjectId());
				userId = p2.getObjectId();
			}

			@Override
			public void onFailure(int code, String msg) {
				ShowToast("创建数据失败：" + msg);
			}
		});
	}

	*//**
	 * 从Bmob中根据ID查询数据
	 *//*
	private void queryDataFromBmobById() {
		BmobQuery<Person> bmobQuery = new BmobQuery<Person>();
		if ("".equals(userId) || null == userId) {
			ShowToast("userID为空，找不到您想要查询的用户");
			return;
		}
		bmobQuery.getObject(this, userId, new GetListener<Person>() {

			@Override
			public void onSuccess(Person object) {
				ShowToast("查询成功");
			}

			@Override
			public void onFailure(int code, String msg) {
				ShowToast("查询失败" + msg);
			}
		});
	}

	*//**
	 * 在Bmob中更改一行数据
	 *//*
	private void UpdateDataInBmobById() {
		final Person p2 = new Person();
		p2.setAddress("四川乐山");
		if ("".equals(userId) || null == userId) {
			ShowToast("userID为空，找不到您想要查询的用户");
			return;
		}
		p2.update(this, userId, new UpdateListener() {

			@Override
			public void onSuccess() {
				ShowToast("更新成功：" + p2.getUpdatedAt());
			}

			@Override
			public void onFailure(int code, String msg) {
				ShowToast("更新失败：" + msg);
			}
		});
	}

	*//**
	 * 从Bmob中删除数据
	 *//*
	private void deleteDataFromBmobById() {
		Person p2 = new Person();
		p2.setObjectId(userId);
		if ("".equals(userId) || null == userId) {
			ShowToast("userID为空，找不到您想要查询的用户");
			return;
		}
		p2.delete(this, new DeleteListener() {

			@Override
			public void onSuccess() {
				ShowToast("删除成功");
			}

			@Override
			public void onFailure(int code, String msg) {
				ShowToast("删除失败：" + msg);
			}
		});
	}*/
}
