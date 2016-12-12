package person.ntl.personaldemo.anim;

import android.animation.TypeEvaluator;
import android.graphics.Point;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * Created by jzzb on 2016/7/25.
 */
public class PointEvaluator implements TypeEvaluator {
    @Override
    public Object evaluate(float fraction, Object startValue, Object endValue) {

        Point startPoint = (Point) startValue;
        Point endPoint = (Point) endValue;

        int x = 0;
        float y = 0;

        BigDecimal bigDecimal = new BigDecimal(fraction);
        DecimalFormat doubleFormat = new DecimalFormat("0.00");
        String format = doubleFormat.format(bigDecimal);

        Float frac = Float.parseFloat(format) ;
        int i = 0;
        if (frac != 0){
            i = (int) (frac*100);
        }
        if (i %2 ==0){
            x = startPoint.x + Math.abs((endPoint.x - startPoint.x)/150);
        }else {
            x = startPoint.x - Math.abs((endPoint.x - startPoint.x)/150);
        }

        y = startPoint.y + fraction * (endPoint.y - startPoint.y);

        return new Point(x,(int)y);
    }
}
