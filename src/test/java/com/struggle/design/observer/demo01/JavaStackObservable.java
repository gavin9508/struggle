package com.struggle.design.observer.demo01;

import java.util.Observable;

/**
 * 观察目标：栈长
 */
public class JavaStackObservable extends Observable {

    private String article;

    /**
     * 发表文章
     * @param article
     */
    public void publish(String article){
        // 发表文章
        this.article = article;

        // 改变状态
        this.setChanged();

        // 通知所有观察者
        this.notifyObservers();
    }

    public String getArticle() {
        return article;
    }
}

