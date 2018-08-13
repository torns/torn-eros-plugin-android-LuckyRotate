package com.torn.luckyrotate;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.alibaba.weex.plugin.annotation.WeexModule;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.common.WXModule;

import com.alibaba.weex.plugin.annotation.WeexComponent;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.dom.WXDomObject;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.WXComponentProp;
import com.taobao.weex.ui.component.WXVContainer;
import com.taobao.weex.utils.WXLogUtils;
import com.torn.luckyrotate.lib.RotateView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by liuyuanxiao on 2018/5/4.
 * 基于https://github.com/yukunkun/RotateView
 */
@WeexComponent(names = {"tr-luckyrotate"})
public class LuckyRotateComponent extends WXComponent<TornRotateView> {
    TornRotateView mRotateView;
    //字体颜色
    protected String mTextColor = "#ffffff";
    List<Integer> mImages = new ArrayList<>();
    List<String> mNames = new ArrayList<>();


    public LuckyRotateComponent(WXSDKInstance instance, WXDomObject dom, WXVContainer parent) {
        super(instance, dom, parent);
    }

    public LuckyRotateComponent(WXSDKInstance instance, WXDomObject dom, WXVContainer parent, int type) {
        super(instance, dom, parent, type);
    }

    @Override
    protected TornRotateView initComponentHostView(@NonNull Context context) {
        mRotateView = new TornRotateView(context);
        return mRotateView;
    }

    //开始抽奖
    @JSMethod(uiThread = false)
    public void start() {
        mImages.clear();
        mNames.clear();
        mImages.add(R.mipmap.role);
        mNames.add("测试1");
        mImages.add(R.mipmap.role);
        mNames.add("测试1");
        mImages.add(R.mipmap.role);
        mNames.add("测试1");
        mRotateView.setImageIcon(mImages);
        mRotateView.setStrName(mNames);
        mRotateView.startAnimation(500);
    }

    @WXComponentProp(name = "config")
    public void setConfig(String config) {
        try {
            JSONObject object = new JSONObject(config);
            String textColor = object.optString("textColor");
            if (!TextUtils.isEmpty(textColor)) {
                mTextColor = textColor;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @WXComponentProp(name = "items")
    public void setItems(List items) {
        mImages.clear();
        mNames.clear();
        mImages.add(R.mipmap.role);
        mNames.add("测试");
        mImages.add(R.mipmap.role);
        mNames.add("测试");
        mImages.add(R.mipmap.role);
        mNames.add("测试");
        mRotateView.setImageIcon(mImages);
        mRotateView.setStrName(mNames);
    }

    protected void rdraw() {

    }
//    private void intDate(Context context) {
//        images.add(R.mipmap.role);
//        images.add(R.mipmap.sports);
//        images.add(R.mipmap.words);
//        images.add(R.mipmap.action);
//        images.add(R.mipmap.combat);
//        images.add(R.mipmap.moba);
//        names = Arrays.asList(context.getResources().getStringArray(R.array.name));
//    }
}
