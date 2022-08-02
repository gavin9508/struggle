package com.struggle.design.responsibility.demo_2;

/*
 *
 *   使用链表直接实现FilterChain
 *
 * 属性, Filter next
 *   除了RuntimeException与其子类，以及错误（Error），其他的都是检查异常（绝对的大家族）。
 *
 *
 * */
public class FilterChainIII {

    public static void main(String[] args) {
        Filter1 htmlFilter = new HtmlFitler();
        htmlFilter.setNext(new SesitiveFilter());
        Requeset req = new Requeset();
        Response res = new Response();
        htmlFilter.doFilter(req, res);
        System.out.println(req.msg);
        System.out.println(res.msg);
    }
}


abstract class Filter1 {
    private Filter1 next;
    public Filter1 setNext(Filter1 next){
        this.next = next;
        return this;
    }
    public abstract void doFilter(Requeset req, Response resp);
    public Filter1 getNext() throws NullPointerException{
        if (this.next != null) return this.next;
        else throw new NullPointerException("没有设置next!!!请设置在调用");
    }
}
class Requeset {
    String msg = "";
}
class Response {
    String msg = "";
}

class HtmlFitler extends Filter1 {

    @Override
    public void doFilter(Requeset req, Response resp) {
        req.msg += "Req.htmlFilter->";
        Filter1 nx = super.getNext();
        nx.doFilter(req, resp);
        resp.msg += "Resp.htmlFilter->";
    }
}

class SesitiveFilter extends Filter1 {
    @Override
    public void doFilter(Requeset req, Response resp) {
        req.msg += "Req.sensitiveFilter->";
//        getNext().doFilter(req, resp);      // 报错
        resp.msg += "Resp.sensitiveFilter->";
    }
}
