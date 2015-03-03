package com.xplore.web.exception;

/**
 * Created by zhouzhihao on 2014/10/21.
 */
public class XploreException extends Exception {

    private static final long serialVersionUID = 6034592482590653805L;

    public XploreException() {
        super();
    }

    public XploreException(String message, Throwable cause) {
        super(message, cause);
    }

    public XploreException(String message) {
        super(message);
    }

    public XploreException(Throwable cause) {
        super(cause);
    }

}
