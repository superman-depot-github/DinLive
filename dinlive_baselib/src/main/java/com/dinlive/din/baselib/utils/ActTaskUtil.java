package com.dinlive.din.baselib.utils;

import android.app.Activity;

import java.util.Stack;

/**
 * 管理和回收Act
 * Created by superman on 2018/4/9.
 */

public class ActTaskUtil {
    private static Stack<Activity> stack = new Stack();
    private static ActTaskUtil instance;

    /**
     * 获得单例对象
     */
    public static ActTaskUtil getInstance() {
        if (instance == null) {
            synchronized (ActTaskUtil.class) {
                if (instance == null) {
                    instance = new ActTaskUtil();
                }
            }
        }
        return instance;
    }

    /**
     * 移除所有activity
     */
    public void popAll() {
        while (!stack.isEmpty()) {
            pop();
        }
    }

    /**
     * 移除位于栈顶的activity
     */
    public void pop() {
        Activity activity = stack.pop();
        if (activity != null && !activity.isFinishing()) {
            activity.finish();
        }
    }

    /**
     * 获得栈顶activity
     */
    public Activity topStack() {
        return stack.peek();
    }

    /**
     * 移除指定activity
     */
    public void pop(Activity activity) {

        for (Activity a : stack) {
            if (a.getClass().equals(activity.getClass())) {
                if (!a.isFinishing()) {
                    a.finish();
                }
            }
        }
        stack.remove(activity);
    }

    public void pop(Class<? extends Activity> activity) {

        for (Activity a : stack) {
            if (a.getClass().equals(activity)) {
                if (!a.isFinishing()) {
                    a.finish();
                }
            }
        }
        stack.remove(activity);
    }

    /**
     * 移除并关闭指定某一类的activity
     */
    public void popClass(Class<? extends Activity> cls) {
        Stack<Activity> newStack = new Stack<Activity>();
        for (Activity a : stack) {
            if (a.getClass().equals(cls)) {
                if (!a.isFinishing()) {
                    a.finish();
                }
            } else {
                newStack.push(a);
            }
        }
        stack = newStack;
    }

    /**
     * 获取在栈顶的activity
     */
    public Activity current() {
        if (stack.isEmpty()) {
            return null;
        }
        return stack.peek();
    }

    /**
     * 添加activity到栈中
     */
    public void push(Activity activity) {
        stack.push(activity);
    }

    /**
     * 判断堆栈中是否存在此activity，如果存在则返回当前activity市里
     */
    public Activity isExists(Class<? extends Activity> activity) {
        for (Activity a : stack) {
            if (a.getClass().equals(activity)) {
                return a;
            }
        }
        return null;
    }

    /**
     * 保留某一类的activity，其它的都关闭并移出栈
     */
    public static void retain(Class<? extends Activity> cls) {
        Stack<Activity> newStack = new Stack<Activity>();
        for (Activity a : stack) {
            if (a.getClass().equals(cls)) {
                newStack.push(a);
            } else {
                if (!a.isFinishing()) {
                    a.finish();
                }
            }
        }
        stack = newStack;
    }
}
