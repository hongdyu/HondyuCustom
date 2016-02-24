package com.yhd.fragment;

import com.yhd.R;
import com.yhd.activity.SqliteTestActivity;

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

public class DrivingExamFragment extends Fragment implements OnClickListener {

	private View view;
	private Activity mContxt;

	private Button btn_show_dialog,btn_operate_db;
	private Dialog dialog;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.fragment_driving_exam, container,
				false);
		mContxt = getActivity();
		Window win = mContxt.getWindow();
		WindowManager.LayoutParams params = win.getAttributes();
		win.setSoftInputMode(params.SOFT_INPUT_ADJUST_NOTHING);
		initView();
		return view;
	}

	private void initView() {
		btn_show_dialog = (Button) view.findViewById(R.id.btn_show_dialog);
		btn_show_dialog.setOnClickListener(this);
		btn_operate_db = (Button) view.findViewById(R.id.btn_operate_db);
		btn_operate_db.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if (v == btn_show_dialog) {
			showAddLinesAlertDialog();
		}else if(v == btn_operate_db){
			startActivity(new Intent(getActivity(),SqliteTestActivity.class));
		}
	}

	/****
	 * 显示提示增加线路
	 */
	private void showAddLinesAlertDialog() {
	/*	AlertDialog.Builder builer = new AlertDialog.Builder(mContxt);
//		Dialog dialog = new AlertDialog.Builder(mContxt);
		final EditText edt = new EditText(mContxt);
		edt.setPrivateImeOptions("flagNoExtractUi");
		builer.setTitle("添加线路").setView(edt);
		builer.setPositiveButton("增加", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// 传数据
			}
		});
		builer.setNegativeButton("取消", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
			}
		});
		builer.show();
		*/
		

//		final EditText edt = new EditText(mContxt);
//		edt.setPrivateImeOptions("flagNoExtractUi");
		LayoutInflater inflater = (LayoutInflater) mContxt.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		final View layout = inflater.inflate(R.layout.edit_text_dialog, null);
//		final EditText tv_content = (EditText) layout
//				.findViewById(R.id.tv_content);
		dialog = new AlertDialog.Builder(mContxt)
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
