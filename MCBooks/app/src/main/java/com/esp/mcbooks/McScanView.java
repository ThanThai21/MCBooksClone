package com.esp.mcbooks;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;

import me.dm7.barcodescanner.core.IViewFinder;
import me.dm7.barcodescanner.core.ViewFinderView;
import me.dm7.barcodescanner.zbar.ZBarScannerView;


/**
 * Created by Admin on 27/5/2017.
 */

public class McScanView extends ZBarScannerView {

    public McScanView(Context context) {
        super(context);
    }

    public McScanView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    protected IViewFinder createViewFinderView(Context paramContext) {
        return new QrView(paramContext);
    }

    private class QrView extends ViewFinderView {
        public QrView(Context paramContext)
        {
            super(paramContext);
        }

        public void onDraw(Canvas paramCanvas)
        {
            if (getFramingRect() != null) {}
        }
    }
}
