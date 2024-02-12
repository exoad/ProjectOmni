/*
 * Copyright 2024 Jack Meng (exoad). All rights reserved.
 * Use of this source code is governed by a BSD-style license that can be
 * found in the LICENSE file.
 */
package pkg.exoad.omni.engine.ui;
import javax.swing.JComponent;

/**
 *
 * @author Jack Meng (exoad)
 */
public class UIDelegate<T extends UIComponent<A extends JComponent>> extends UIComponent<A>
{

    public static <A extends UIComponent<? extends JComponent>> UIDelegate<A> makeWith(
            String id,
            A component)
    {
        Objects.requireNonNull(id);
        UIDelegate<A> e=new UIDelegate<>(id);
        e.setRootElement(component);
        return e;
    }
    
    private T rootElement;
    
    protected UIDelegate(String id)
    {
        
    }

    protected void LOG(Level level,String message)
    {
        if(SharedConstants.USE_DIAGNOSTICS)
            OmniEngine.LOG.log(level,"{0}#{1} {2}",new Object[]
            {
                this.getClass().
                getSimpleName(),id(),message
            });
    }

    public UIDelegate<T> withAlignmentX(Alignment alignment)
    {
        rootElement.setAlignmentX(alignment.axis());
        return this;
    }

    public UIDelegate<T> withAlignmentY(Alignment alignment)
    {
        rootElement.setAlignmentY(alignment.axis());
        return this;
    }

    public UIDelegate<T> withVisibility(boolean visibility)
    {
        rootElement.setVisible(visibility);
        return this;
    }

    public UIDelegate<T> withSize(SwingOperable<Dimension> size)
    {
        rootElement.setSize(size.convert());
        return this;
    }

    public UIDelegate<T> withPrefSize(SwingOperable<Dimension> size)
    {
        rootElement.setPreferredSize(size.convert());
        return this;
    }

    @Override
    public T exposeInternal()
    {
        return rootElement;
    }

    private void setRootElement(T element)
    {
        this.rootElement=element;
    }
}
