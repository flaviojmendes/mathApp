package es.flaviojmend.tabuada.components;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class HandwrittenTextView extends TextView {
    public HandwrittenTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setTypeface(Typeface.createFromAsset(context.getAssets(),"fonts/SF_Arch_Rival.ttf"));
    }

}
