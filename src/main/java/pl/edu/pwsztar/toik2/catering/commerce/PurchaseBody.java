package pl.edu.pwsztar.toik2.catering.commerce;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseBody {
    private Long dietId;
    private int weeks;

    private String name;
    private String surname;
    private String email;

    private Long cityId;
    private String zipCode;
    private String addressLine;

    @Override
    public String toString() {
        return "PurchaseBody{" +
                "dietId=" + dietId +
                ", weeks=" + weeks +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", cityId=" + cityId +
                ", zipCode='" + zipCode + '\'' +
                ", addressLine='" + addressLine + '\'' +
                '}';
    }
}