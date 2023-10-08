package common;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Parking Spot Type
 * Add/Update/Delete Parking Lot
 * Register User
 * Search parking Lot
 * Reserve parking Lot
 * Cancle Reservation
 * Add Time to reservation
 * Payment
 * Rate
 * Notification time start/ end
 * 
 */
public class ParkingLot {

    public class Parklot {
        int id;
        String address1;
        String address2;
        String city;// TODO add Look up reference
        String state;// TODO add Look up reference
        String country;// TODO add Look up reference
        List<Slot> slotList;
    }

    public abstract class Slot {
        int id;
        boolean status = true; // true avaiable, false unavaialbe
    }

    public class HDSlot extends Slot {
        int id;
        boolean status = true; // true avaiable, false unavaialbe
    }

    public abstract class baseUser {
        int id;
        String firstName;
        String lastName;
        String email;
    }

    public class User extends baseUser {
        PaymentMethod paymentMethod;
        //
    }

    public class ParkingOwner extends baseUser {
        List<Parklot> parkLot;
        PaymentMethod paymentMethod;
    }

    public interface PaymentType {
        public abstract int pay(float ammount);
    }

    public abstract class PaymentTypeCreditCard implements PaymentType {
        int id;
        int cardNumbers;
        int expireMM;
        int expireYY;
        int secretNumber;

        @Override
        public int pay(float ammount) {
            // TODO implement the payment process
            return 0;
        }

    }

    public abstract class PaymentTypeAccount implements PaymentType {
        int id;
        int acocuntNumber;
        int routingNUmber;

        @Override
        public int pay(float ammount) {
            // TODO implement the payment process
            return 0;
        }

    }

    public class PaymentMethod {
        PaymentType paymentType;

    }

    public class Reserve {
        int id;
        int spotId;
        int userId;
        LocalDateTime start;
        LocalDateTime end;
    }

    public class Transaction {
        int id;
        int reservationId;
        float amount;
    }

    public int addParking() {
        // TODO
        return 0;
    }

    public int updateParking() {
        // TODO
        return 0;
    }

    public int deleteParking() {
        // TODO
        return 0;
    }

}
