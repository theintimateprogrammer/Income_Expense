package income_expense.github.mikephil.charting.charts;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import com.github.mikephil.charting.data.PieData;

import org.jetbrains.annotations.NotNull;

public class PieChart extends View {
    @NotNull
    public PieData data;
    @NotNull
    public Object description;
    @NotNull
    public String centerText;
    @NotNull
    public PieChart text;


    public PieChart(Context context, Object description, Object description1) {
        this(context, null);
    }

    public PieChart(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PieChart(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void animateY(int i) {

    }
}
