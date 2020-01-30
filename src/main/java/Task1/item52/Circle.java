package Task1.item52;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Circle implements AreaCountable {

    int radius;

    public double countArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}
