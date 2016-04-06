package com.yhd.fragment;

import com.yhd.R;
import com.yhd.activity.LocationCityActivity;
import com.yhd.activity.PlayVideoActivity;
import com.yhd.activity.SlideBarTestActivity;
import com.yhd.activity.SqliteTestActivity;
import com.yhd.view.CustomDialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class DrivingExamFragment extends Fragment implements OnClickListener {

	private View view;
	private Activity mContext;

	private Button btn_show_dialog,btn_operate_db,btn_slide_bar,btn_location_city,btn_play_video
			,btn_slidebar_dialog;
	private TextView tv_count;
	private SeekBar mSeekbar;
	private Dialog dialog;
	private CustomDialog slidebarCustomDialog;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_driving_exam, container,
				false);
		mContext = getActivity();
		initView();
		return view;
	}

	private void initView() {
		btn_show_dialog = (Button) view.findViewById(R.id.btn_show_dialog);
		btn_show_dialog.setOnClickListener(this);
		btn_operate_db = (Button) view.findViewById(R.id.btn_operate_db);
		btn_operate_db.setOnClickListener(this);
		btn_slide_bar = (Button) view.findViewById(R.id.btn_slide_bar);
		btn_slide_bar.setOnClickListener(this);
		btn_location_city = (Button) view.findViewById(R.id.btn_location_city);
		btn_location_city.setOnClickListener(this);
		btn_play_video = (Button) view.findViewById(R.id.btn_play_video);
		btn_play_video.setOnClickListener(this);
		btn_slidebar_dialog = (Button)view.findViewById(R.id.btn_slidebar_dialog);
		btn_slidebar_dialog.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if (v == btn_show_dialog) {
			showAddLinesAlertDialog();
		}else if(v == btn_operate_db){
			startActivity(new Intent(getActivity(),SqliteTestActivity.class));
		}else if(v == btn_slide_bar){
			startActivity(new Intent(getActivity(),SlideBarTestActivity.class));
		}else if(v == btn_location_city){
			startActivity(new Intent(getActivity(),LocationCityActivity.class));
		}else if(v == btn_play_video){
			startActivity(new Intent(getActivity(),PlayVideoActivity.class));
		}else if(v == btn_slidebar_dialog){
			showSlidebarDialog();
		}
	}

	/**
	 * 弹出滑动条对话框
	 */
	private void showSlidebarDialog() {
		LayoutInflater inflater = LayoutInflater.from(mContext);
		View v = inflater.inflate(R.layout.slidebar_dialog, null);
		tv_count = (TextView) v.findViewById(R.id.tv_count);
		mSeekbar = (SeekBar) v.findViewById(R.id.seekbar);
		slidebarCustomDialog = new CustomDialog(mContext);
		CustomDialog.Builder builer = new CustomDialog.Builder(mContext);
		builer.setTitle("移动位置");
		builer.setContentView(v);
		builer.setNegativeButton("取消", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
			}
		});
		builer.setPositiveButton("确定", new DialogInterface.OnClickListener(){

			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
			}
		});
		slidebarCustomDialog = builer.create();
		slidebarCustomDialog.show();
	}

	/****
	 * 显示提示增加线路
	 */
	private void showAddLinesAlertDialog() {
		LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		final View layout = inflater.inflate(R.layout.edit_text_dialog, null);
		dialog = new AlertDialog.Builder(mContext)
		.setTitle("确认删除")
		.setView(layout)
		.setPositiveButton("是",new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog,int which) {

			}
		}).setNeutralButton("否", null).create();
		dialog.show();
		Window window = dialog.getWindow();
	    window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
	}
}
