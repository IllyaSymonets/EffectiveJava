package Task1.item52;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Rectangle implements AreaCountable{
    int sideA;
    int sideB;

    public double countArea() {
        return sideA*sideB;
    }
}
