package FEESTRATEGY;
import MODELS.Ticket;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class FlatHourlyRate implements FeeCalculator {
    private double ratePerHour;

    public void setFlatRate(double ratePerHour){this.ratePerHour=ratePerHour;}

    @Override
    public double feeCalculator(Ticket ticket, LocalDateTime exitTime){
        long minutes = ChronoUnit.MINUTES.between(ticket.getEntryTime(), exitTime);
        double hours = Math.ceil(minutes/60.0);

        return ratePerHour*hours;
    }
}
