package Task1.Item30;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
public enum Price {
    WALLET(BigDecimal.valueOf(150.0), BigDecimal.valueOf(0.150)),
    BELT(BigDecimal.valueOf(100.0), BigDecimal.valueOf(0.250)),
    BOOTS(BigDecimal.valueOf(300.0), BigDecimal.valueOf(0.800)),
    CLOCK(BigDecimal.valueOf(250.0), BigDecimal.valueOf(0.350)),
    BAG(BigDecimal.valueOf(140.0), BigDecimal.valueOf(0.600)),
    HAT(BigDecimal.valueOf(80.0), BigDecimal.valueOf(0.200));

    private BigDecimal price;
    private BigDecimal weight;

}
