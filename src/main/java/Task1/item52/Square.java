package Task1.item52;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Square extends Rectangle{
    int sideA;

    @Override
    public double countArea() {
        return Math.pow(sideA, 2);
    }
}
