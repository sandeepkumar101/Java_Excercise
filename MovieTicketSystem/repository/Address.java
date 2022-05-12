package MovieTicketSystem.repository;

public class Address {

    private int id;
    private String streetAddress;
    private String city;
    private String state;
    private String country;
    private int zipcode;
}

public enum BookingStatus
{
    REQUEST, PENDDING, CONFIRMED, CHECKED_IN,CANCELED
}

public enum AccountStatus
{
    ACTIVE,CLOSED,BLOCKED,BANNED,UNKNOWN
}

public enum SeatType
{
    REGULAR, PREMIUM, ASSESSIBLE, OTHER
}

public enum PaymentStatus
{
    UNPAID, PENDING, COMPLETED, FAILED, DECLINED, SETTLING, SETTLED, REFUNDED
}