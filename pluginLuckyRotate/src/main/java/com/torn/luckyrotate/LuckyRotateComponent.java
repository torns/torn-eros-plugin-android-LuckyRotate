package com.torn.luckyrotate;

import android.content.Context;
import android.support.annotation.NonNull;
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
import com.torn.luckyrotate.lib.RotateView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by liuyuanxiao on 2018/5/4.
 * 基于https://github.com/yukunkun/RotateView
 */
@WeexComponent(names = {"tr-luckyrotate"})
public class LuckyRotateComponent extends WXComponent<RotateView> {

    List<Integer> images = new ArrayList<>();
    List<String> names = new ArrayList<>();

    public LuckyRotateComponent(WXSDKInstance instance, WXDomObject dom, WXVContainer parent) {
        super(instance, dom, parent);
    }

    public LuckyRotateComponent(WXSDKInstance instance, WXDomObject dom, WXVContainer parent, int type) {
        super(instance, dom, parent, type);
    }

    @Override
    protected RotateView initComponentHostView(@NonNull Context context) {
        this.intDate(context);
        RotateView rotateView = new RotateView(context);
        //View view = new View(context);
        rotateView.setImageIcon(images);
        rotateView.setStrName(names);
        return rotateView;
    }

    private void intDate(Context context) {
        images.add(R.mipmap.role);
        images.add(R.mipmap.sports);
        images.add(R.mipmap.words);
        images.add(R.mipmap.action);
        images.add(R.mipmap.combat);
        images.add(R.mipmap.moba);
        names = Arrays.asList(context.getResources().getStringArray(R.array.name));
    }
}
