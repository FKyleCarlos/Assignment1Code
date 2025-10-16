package shapes;

import java.util.Comparator;

public class ShapeVolumeComparator implements Comparator<Shape> 
{

    @Override
    public int compare(Shape s1, Shape s2) 
    {
        // Descending order: larger volume first
        if (s1.calcVolume() < s2.calcVolume()) return 1;
        if (s1.calcVolume() > s2.calcVolume()) return -1;
        return 0;
    }
}
