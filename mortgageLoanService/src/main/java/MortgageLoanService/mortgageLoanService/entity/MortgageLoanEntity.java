package MortgageLoanService.mortgageLoanService.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "mortgageloanentity")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MortgageLoanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(name = "maxamount")
    private float maxAmount;

    @Column(name = "mininterestrate")
    private float minInterestRate;

    @Column(name = "maxinterestrate")
    private float maxInterestRate;

    @Column(name = "maxterm")
    private int maxTerm;

    @Column(name = "type")
    private int type;
}
