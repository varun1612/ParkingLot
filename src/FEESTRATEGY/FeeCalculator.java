package FEESTRATEGY;
import java.time.LocalDateTime;
import MODELS.Ticket;

public interface FeeCalculator {
    public double feeCalculator(Ticket ticket, LocalDateTime exitTime);
}
