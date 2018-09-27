package com.dsd.view.mylib;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * Created by a on 2018/8/7.
 */

public class VerifyCodeEditText extends LinearLayout
{

    public interface onVerifyInputCompleteListener{ public void onCallBack(); public void onCallBackError(); }


    onVerifyInputCompleteListener listener;

    EditText editText1;

    TextView editText2,editText3,editText4,editText5,editText6;

    public VerifyCodeEditText(Context context, AttributeSet attrs, int defStyle)     {
        super(context, attrs, defStyle);
    }

    public VerifyCodeEditText(Context context, AttributeSet attrs) {
        super(context, attrs);

        View.inflate(context, R.layout.verify_edittext, this);

        editText1 = (EditText) findViewById(R.id.edit1);
        editText2 = (TextView) findViewById(R.id.edit2);
        editText3 = (TextView) findViewById(R.id.edit3);
        editText4 = (TextView) findViewById(R.id.edit4);
        editText5 = (TextView) findViewById(R.id.edit5);
        editText6 = (TextView) findViewById(R.id.edit6);



        editText1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {

                if(null != s)
                {

                    if(null != s && s.length() == 1)
                    {
                        doFocus(editText2);
                    }

                    if(null !=s && s.length() > 1)
                    {

                        if(TextUtils.isEmpty(editText2.getText().toString().trim()))
                        {
                            editText1.setText(getFirstValue(s.toString()));
                            editText2.setText(getvalue(s.toString()));
                            doFocus(editText3);

                        }
                        else if(TextUtils.isEmpty(editText3.getText().toString().trim()))
                        {
                            editText1.setText(getFirstValue(s.toString()));
                            editText3.setText(getvalue(s.toString()));
                            doFocus(editText4);
                        }
                        else if(TextUtils.isEmpty(editText4.getText().toString().trim()))
                        {
                            editText1.setText(getFirstValue(s.toString()));
                            editText4.setText(getvalue(s.toString()));
                            doFocus(editText5);
                        }
                        else if(TextUtils.isEmpty(editText5.getText().toString().trim()))
                        {
                            editText1.setText(getFirstValue(s.toString()));
                            editText5.setText(getvalue(s.toString()));
                            doFocus(editText6);
                        }
                        else if(TextUtils.isEmpty(editText6.getText().toString().trim()))
                        {
                            editText1.setText(getFirstValue(s.toString()));
                            editText6.setText(getvalue(s.toString()));
                            doFocus(editText6);
                        }
                        else
                        {
                            editText1.setText(getFirstValue(s.toString()));
                            editText6.setText(getvalue(s.toString()));
                            doFocus(editText6);
                        }

                        toLast(editText1);

                        if(getVerifyValue().length() == 6)
                        {
                            listener.onCallBack();
                        }

                        //toLast(editText2);



                    }
                }




                if(null == s || s.length() == 0)
                {

                    clearVerifyValue();

                    if(getVerifyValue().length() < 6)
                    {
                        listener.onCallBackError();
                    }

                }

            }
        });

        editText2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                showInput(editText1);
            }
        });

        editText3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                showInput(editText1);
            }
        });

        editText4.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                showInput(editText1);
            }
        });

        editText5.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                showInput(editText1);
            }
        });

        editText6.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                showInput(editText1);
            }
        });

    }


    public void setErrorStatus()
    {

        editText1.setText("");
        editText2.setText("");
        editText3.setText("");
        editText4.setText("");
        editText5.setText("");
        editText6.setText("");

        editText1.setBackgroundResource(R.drawable.et_bkg_error);
        editText2.setBackgroundResource(R.drawable.et_bkg_error);
        editText3.setBackgroundResource(R.drawable.et_bkg_error);
        editText4.setBackgroundResource(R.drawable.et_bkg_error);
        editText5.setBackgroundResource(R.drawable.et_bkg_error);
        editText6.setBackgroundResource(R.drawable.et_bkg_error);

        editText1.clearFocus();
    }

    public void setNormalStatus()
    {

        editText1.requestFocus();
        doFocus(editText1);
    }

    public String getVerifyValue()
    {

        return editText1.getText().toString().trim()+editText2.getText().toString().trim()+editText3.getText().toString().trim()
                +editText4.getText().toString().trim()+editText5.getText().toString().trim()+editText6.getText().toString().trim();
    }


    public void clearVerifyValue()
    {
        editText2.setText("");
        editText3.setText("");
        editText4.setText("");
        editText5.setText("");
        editText6.setText("");

        editText1.requestFocus();

        doFocus(editText1);


    }

    public void setListener(onVerifyInputCompleteListener listener)
    {
        this.listener = listener;
    }


    //光标移动到最后
    public void toLast(EditText et)
    {
        if(!TextUtils.isEmpty(et.getText()))
        {
            et.setSelection(et.getText().length());
        }

    }

    //获取光标前一位
    public String getvalue(String str)
    {
        return str.substring(1,2);
    }


    public String getFirstValue(String str)
    {

        return str.substring(0,1);
    }


    private void doFocus(View tv)
    {

        int id = tv.getId();
        if(id == R.id.edit1)
        {
            editText2.setBackground(getResources().getDrawable(R.drawable.et_underline_unselected_normal));
            editText1.setBackground(getResources().getDrawable(R.drawable.et_underline_selected));
            editText3.setBackground(getResources().getDrawable(R.drawable.et_underline_unselected_normal));
            editText4.setBackground(getResources().getDrawable(R.drawable.et_underline_unselected_normal));
            editText5.setBackground(getResources().getDrawable(R.drawable.et_underline_unselected_normal));
            editText6.setBackground(getResources().getDrawable(R.drawable.et_underline_unselected_normal));
        }
        else if(id == R.id.edit2)
        {
            editText1.setBackground(getResources().getDrawable(R.drawable.et_underline_unselected_normal));
            editText2.setBackground(getResources().getDrawable(R.drawable.et_underline_selected));
            editText3.setBackground(getResources().getDrawable(R.drawable.et_underline_unselected_normal));
            editText4.setBackground(getResources().getDrawable(R.drawable.et_underline_unselected_normal));
            editText5.setBackground(getResources().getDrawable(R.drawable.et_underline_unselected_normal));
            editText6.setBackground(getResources().getDrawable(R.drawable.et_underline_unselected_normal));
        }
        else if(id == R.id.edit3)
        {
            editText1.setBackground(getResources().getDrawable(R.drawable.et_underline_unselected_normal));
            editText3.setBackground(getResources().getDrawable(R.drawable.et_underline_selected));
            editText2.setBackground(getResources().getDrawable(R.drawable.et_underline_unselected_normal));
            editText4.setBackground(getResources().getDrawable(R.drawable.et_underline_unselected_normal));
            editText5.setBackground(getResources().getDrawable(R.drawable.et_underline_unselected_normal));
            editText6.setBackground(getResources().getDrawable(R.drawable.et_underline_unselected_normal));
        }
        else if(id == R.id.edit4)
        {
            editText1.setBackground(getResources().getDrawable(R.drawable.et_underline_unselected_normal));
            editText4.setBackground(getResources().getDrawable(R.drawable.et_underline_selected));
            editText3.setBackground(getResources().getDrawable(R.drawable.et_underline_unselected_normal));
            editText2.setBackground(getResources().getDrawable(R.drawable.et_underline_unselected_normal));
            editText5.setBackground(getResources().getDrawable(R.drawable.et_underline_unselected_normal));
            editText6.setBackground(getResources().getDrawable(R.drawable.et_underline_unselected_normal));
        }
        else if(id == R.id.edit5)
        {
            editText1.setBackground(getResources().getDrawable(R.drawable.et_underline_unselected_normal));
            editText5.setBackground(getResources().getDrawable(R.drawable.et_underline_selected));
            editText3.setBackground(getResources().getDrawable(R.drawable.et_underline_unselected_normal));
            editText4.setBackground(getResources().getDrawable(R.drawable.et_underline_unselected_normal));
            editText2.setBackground(getResources().getDrawable(R.drawable.et_underline_unselected_normal));
            editText6.setBackground(getResources().getDrawable(R.drawable.et_underline_unselected_normal));
        }
        else if(id == R.id.edit6)
        {
            editText1.setBackground(getResources().getDrawable(R.drawable.et_underline_unselected_normal));
            editText6.setBackground(getResources().getDrawable(R.drawable.et_underline_selected));
            editText3.setBackground(getResources().getDrawable(R.drawable.et_underline_unselected_normal));
            editText4.setBackground(getResources().getDrawable(R.drawable.et_underline_unselected_normal));
            editText5.setBackground(getResources().getDrawable(R.drawable.et_underline_unselected_normal));
            editText2.setBackground(getResources().getDrawable(R.drawable.et_underline_unselected_normal));
        }
        else
        {

        }

//        switch (id)
//        {
//            case R.id.edit1:
//                editText2.setBackground(getResources().getDrawable(R.drawable.et_underline_unselected_normal));
//                editText1.setBackground(getResources().getDrawable(R.drawable.et_underline_selected));
//                editText3.setBackground(getResources().getDrawable(R.drawable.et_underline_unselected_normal));
//                editText4.setBackground(getResources().getDrawable(R.drawable.et_underline_unselected_normal));
//                editText5.setBackground(getResources().getDrawable(R.drawable.et_underline_unselected_normal));
//                editText6.setBackground(getResources().getDrawable(R.drawable.et_underline_unselected_normal));
//                break;
//            case R.id.edit2:
//                editText1.setBackground(getResources().getDrawable(R.drawable.et_underline_unselected_normal));
//                editText2.setBackground(getResources().getDrawable(R.drawable.et_underline_selected));
//                editText3.setBackground(getResources().getDrawable(R.drawable.et_underline_unselected_normal));
//                editText4.setBackground(getResources().getDrawable(R.drawable.et_underline_unselected_normal));
//                editText5.setBackground(getResources().getDrawable(R.drawable.et_underline_unselected_normal));
//                editText6.setBackground(getResources().getDrawable(R.drawable.et_underline_unselected_normal));
//
//                break;
//            case R.id.edit3:
//                editText1.setBackground(getResources().getDrawable(R.drawable.et_underline_unselected_normal));
//                editText3.setBackground(getResources().getDrawable(R.drawable.et_underline_selected));
//                editText2.setBackground(getResources().getDrawable(R.drawable.et_underline_unselected_normal));
//                editText4.setBackground(getResources().getDrawable(R.drawable.et_underline_unselected_normal));
//                editText5.setBackground(getResources().getDrawable(R.drawable.et_underline_unselected_normal));
//                editText6.setBackground(getResources().getDrawable(R.drawable.et_underline_unselected_normal));
//                break;
//            case R.id.edit4:
//                editText1.setBackground(getResources().getDrawable(R.drawable.et_underline_unselected_normal));
//                editText4.setBackground(getResources().getDrawable(R.drawable.et_underline_selected));
//                editText3.setBackground(getResources().getDrawable(R.drawable.et_underline_unselected_normal));
//                editText2.setBackground(getResources().getDrawable(R.drawable.et_underline_unselected_normal));
//                editText5.setBackground(getResources().getDrawable(R.drawable.et_underline_unselected_normal));
//                editText6.setBackground(getResources().getDrawable(R.drawable.et_underline_unselected_normal));
//                break;
//            case R.id.edit5:
//                editText1.setBackground(getResources().getDrawable(R.drawable.et_underline_unselected_normal));
//                editText5.setBackground(getResources().getDrawable(R.drawable.et_underline_selected));
//                editText3.setBackground(getResources().getDrawable(R.drawable.et_underline_unselected_normal));
//                editText4.setBackground(getResources().getDrawable(R.drawable.et_underline_unselected_normal));
//                editText2.setBackground(getResources().getDrawable(R.drawable.et_underline_unselected_normal));
//                editText6.setBackground(getResources().getDrawable(R.drawable.et_underline_unselected_normal));
//                break;
//            case R.id.edit6:
//                editText1.setBackground(getResources().getDrawable(R.drawable.et_underline_unselected_normal));
//                editText6.setBackground(getResources().getDrawable(R.drawable.et_underline_selected));
//                editText3.setBackground(getResources().getDrawable(R.drawable.et_underline_unselected_normal));
//                editText4.setBackground(getResources().getDrawable(R.drawable.et_underline_unselected_normal));
//                editText5.setBackground(getResources().getDrawable(R.drawable.et_underline_unselected_normal));
//                editText2.setBackground(getResources().getDrawable(R.drawable.et_underline_unselected_normal));
//                break;
//        }
    }

    private void showInput(View view)
    {
        InputMethodManager imm = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        if(null != imm)
        {
            imm.showSoftInput(view,0);
        }

    }

}