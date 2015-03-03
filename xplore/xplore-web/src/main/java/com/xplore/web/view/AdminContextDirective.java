package com.xplore.web.view;

import com.xplore.web.constants.AdminConfig;
import org.apache.velocity.context.InternalContextAdapter;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.runtime.parser.node.Node;
import org.apache.velocity.tools.view.ViewToolContext;

import java.io.IOException;
import java.io.Writer;

/**
 * Created by zhouzhihao on 2014/10/16.
 */
public class AdminContextDirective extends AbstractDirective {

    @Override
    public String getName() {
        return "cPath";
    }

    @Override
    public int getType() {
        return LINE;
    }

    private String key;

    @Override
    protected boolean doRender(InternalContextAdapter internalContext, ViewToolContext context, Writer writer, Node node)
            throws IOException, ResourceNotFoundException, ParseErrorException, MethodInvocationException {
        writer.write(AdminConfig.get(AdminConfig.KEY_CONTEXT_PATH));
        return true;

    }
}
